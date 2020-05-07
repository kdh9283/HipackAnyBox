package kr.co.packcom.hipackanybox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Dialog.NetworkCheckDialog;
import kr.co.packcom.hipackanybox.Model.로그인모델;
import kr.co.packcom.hipackanybox.Network.HttpConnect;
import kr.co.packcom.hipackanybox.Network.NodeServerPostSend;
import kr.co.packcom.hipackanybox.Network.SendPost;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class 인트로 extends AppCompatActivity {
    private TextView anybox_version;
    private PackageInfo packageInfo = null;
    private Dialog asyncDialog;
    private static final int PermitionRE = 2;
    private TextView tv_progress_message;
    private int sendFlag;
    private Message msg;
    private IntroHandler handler;
    private String appVersion, serverVersion, phoneNum;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ArrayList<로그인모델> list;
    private ReturnArrayListFunction returnArrayListFunction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo("kr.co.packcom.hipackanybox", PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }


        sharedPreferences = getSharedPreferences("basicData", 0);
        editor = sharedPreferences.edit();
        handler = new IntroHandler();
        returnArrayListFunction = new ReturnArrayListFunction();
        appversionCheck();
    }

    private void appversionCheck() {
        anybox_version = findViewById(R.id.anybox_version);
        try {

            packageInfo = getApplication().getPackageManager().getPackageInfo(getPackageName(), 0);
            appVersion = packageInfo.versionName;
            anybox_version = findViewById(R.id.anybox_version);
            anybox_version.setText("Version : " + appVersion);
            checkPermission();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    @TargetApi(Build.VERSION_CODES.M)
    private void checkPermission() {

        //
        //   ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_DENIED

        ) {
            requestPermissions(new String[]{android.Manifest.permission.READ_PHONE_STATE, android.Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, PermitionRE);

        } else {

            init();

        }
    }

    public void init() {
        phoneNum = makePhoneNumber(getPhoneNumber());
        asyncDialog = new Dialog(인트로.this);
        asyncDialog.setCancelable(false);
        asyncDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        asyncDialog.setContentView(R.layout.loading);

        asyncDialog.show();

        final ImageView img_loading_frame = asyncDialog.findViewById(R.id.iv_frame_loading);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img_loading_frame.getBackground();
        tv_progress_message = asyncDialog.findViewById(R.id.tv_progress_message);
        tv_progress_message.setText("버전 체크 중 입니다.");
        //        frameAnimation.start();

        img_loading_frame.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });
        sendFlag = 1;
        Log.d("getPackageName", getPackageName());
        JSONObject jsonObject;
        jsonObject = new JSONObject();

        try {
            jsonObject.put("packagename", getPackageName());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        sendFlag = 1;
        NodeServerPostSend sendPost = new NodeServerPostSend(sendFlag, "appversioncheck", jsonObject.toString(), callback);
        sendPost.execute();


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PermitionRE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    init();
                } else {
                    Toast.makeText(this, "권한사용을 동의해주셔야 이용이 가능합니다.", Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            Log.d("aa", "콜백오류:" + e.getMessage());
            msg = handler.obtainMessage();
            msg.what = 100;
            handler.sendMessage(msg);
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {

            String body = response.body().string();
            Log.d("aa", "서버에서 응답한 Body:" + body);

            msg = handler.obtainMessage();
            msg.what = sendFlag;
            msg.obj = body;
            handler.sendMessage(msg);

        }
    };

    public class IntroHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String resultMessage = msg.obj.toString();
            JSONObject jsonObject;
            String update;

            switch (msg.what) {
                // 앱 버전 체크

                case 1:
                    Log.d("버전 응답값 ->", resultMessage);
                    try {
                        jsonObject = new JSONObject(resultMessage);
                        serverVersion = jsonObject.getString("version");
                        update = jsonObject.getString("update");

                        if (!update.equalsIgnoreCase("1")) {
                            Intent dialog = new Intent(인트로.this, NetworkCheckDialog.class);
                            dialog.putExtra("flag", "1");
                            startActivity(dialog);
                        } else {
                            if (serverVersion.equalsIgnoreCase(appVersion)) {
                                tv_progress_message.setText("로그인 인증 중 입니다");
                                sendFlag = 2;
                                jsonObject = new JSONObject();
                                jsonObject.put("phoneNum", phoneNum);
                                NodeServerPostSend sendpost = new NodeServerPostSend(sendFlag, "login", jsonObject.toString(), callback);
                                sendpost.execute();
                            } else {
                                // 앱 업데이트
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    break;

                case 2:
                    // 로그인 인증 처리
                    Log.d("버전 응답값 ->", resultMessage);
                    String server_ip = "";
                    String corp_id = "";

                    String anybox = "";
                    try {
                        jsonObject = new JSONObject(resultMessage);
                        anybox = jsonObject.getString("anybox");

                        if (anybox.equalsIgnoreCase("1")) {
                            asyncDialog.dismiss();
                            server_ip = jsonObject.getString("server_ip");
                            corp_id = jsonObject.getString("corp_id");
                            HttpConnect httpConnect = HttpConnect.getInstance();
                            httpConnect.setHttp(server_ip);
                            editor.putString("server_ip", server_ip);
                            editor.putString("corp_id", corp_id);
                            editor.putString("phoneNum", phoneNum);
                            editor.apply();
                            sendFlag = 3;
                            SendPost sendPost = new SendPost(3, "serverlogin", callback, getApplicationContext());
                            sendPost.execute();


                        } else if (anybox.equalsIgnoreCase("0")) {
                            asyncDialog.dismiss();
                            Intent dialog = new Intent(인트로.this, NetworkCheckDialog.class);
                            dialog.putExtra("flag", "2");
                            startActivity(dialog);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                    break;
                case 3:
                    Log.d("로그인 응답값 ->", resultMessage);
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll(" ", "");
                    resultMessage = resultMessage.replaceAll("\\p{Z}", "");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    Log.d("result", resultMessage);
                    list = returnArrayListFunction.getloginData(resultMessage);
                    Log.d("list.size", list.size() + "");
                    if (list.get(0).CORP_ID.equalsIgnoreCase("")) {

                        asyncDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "ERP에서 인증되지 않은 사용자 입니다.", Toast.LENGTH_SHORT).show();
                        Intent dialog = new Intent(인트로.this, NetworkCheckDialog.class);
                        dialog.putExtra("flag", "1");
                        startActivity(dialog);

                    } else {
                        editor.putString("phonenum", getPhoneNumber());
                        editor.putString("corp_id", list.get(0).CORP_ID);
                        editor.putString("corp_name", list.get(0).CORP_NAME);
                        editor.putString("carnum", list.get(0).CARNUMBER);
                        editor.putString("ftpid", list.get(0).ftpid);
                        editor.putString("ftppw", list.get(0).ftppass);

                        editor.putString("WEBIMAGE_PATH", list.get(0).WEBIMAGE_PATH);
                        editor.apply();

                        startActivity(new Intent(인트로.this, 메인화면.class));
                    }
                    break;
            }
        }
    }

    @SuppressLint("MissingPermission")
    public String getPhoneNumber() {

        String getPhoneNumber = "";
        TelephonyManager telephonyManager;
        telephonyManager = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);

        if (!TextUtils.isEmpty(telephonyManager.getLine1Number())) {
            getPhoneNumber = telephonyManager.getLine1Number();
        }

        getPhoneNumber = "010-0000-0000";
        if (getPhoneNumber.length() > 1) {
            Log.d("getphonenum", getPhoneNumber.substring(0, 3));

            if (getPhoneNumber.substring(0, 3).equalsIgnoreCase("+82")) {
                Log.d("바꿔야함", "oo");
                getPhoneNumber = getPhoneNumber.replace("+82", "0");
            }

            getPhoneNumber = getPhoneNumber.replaceAll("-", "");

        } else {
            getPhoneNumber = "1";
        }

        return getPhoneNumber;

    }

    public String makePhoneNumber(String src) {

        if (src == null) {
            return "";
        }

        if (src.length() == 8) {
            return src.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");

        } else if (src.length() == 12) {
            return src.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");

        }

        return src.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
    }

}
