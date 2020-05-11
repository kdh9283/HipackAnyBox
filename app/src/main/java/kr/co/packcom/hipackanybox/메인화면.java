package kr.co.packcom.hipackanybox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pm10.library.CircleIndicator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Adapter.공지사항리스트어뎁터;
import kr.co.packcom.hipackanybox.MenuActivity.업체정보;
import kr.co.packcom.hipackanybox.MenuActivity.미수현황;
import kr.co.packcom.hipackanybox.MenuActivity.제품정보;
import kr.co.packcom.hipackanybox.Model.공지사항모델;
import kr.co.packcom.hipackanybox.Network.NodeServerPostSend;
import kr.co.packcom.hipackanybox.Network.SendPost;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//test
public class 메인화면 extends AppCompatActivity implements View.OnClickListener {
    private TextView main_corp_name;
    private SharedPreferences sharedPreferences;
    private String corp_name;
    private ViewPager main_viewpager;
    private MainHandler handler;
    private Message msg;
    private int sendFlag;
    private LinearLayout main_menu1, main_menu2, main_menu3;
    private SharedPreferences.Editor editor;
    private Dialog asyncDialog;
    private TextView tv_progress_message;
    private long backKeyPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new MainHandler();
        asyncDialog = new Dialog(this);
        asyncDialog.setCancelable(false);
        asyncDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        asyncDialog.setContentView(R.layout.loading);
        asyncDialog.show();

        final ImageView img_loading_frame = asyncDialog.findViewById(R.id.iv_frame_loading);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img_loading_frame.getBackground();
        tv_progress_message = asyncDialog.findViewById(R.id.tv_progress_message);
        tv_progress_message.setText("데이터 로딩 중... ");
        //        frameAnimation.start();
        img_loading_frame.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });
        init();

//test
    }

    private void init() {

        sharedPreferences = getSharedPreferences("basicData", 0);
        editor = sharedPreferences.edit();
        corp_name = sharedPreferences.getString("corp_name", "");
        main_viewpager = findViewById(R.id.main_viewpager);
        main_corp_name = findViewById(R.id.main_corp_name);
        main_corp_name.setText(corp_name);
        main_menu1 = findViewById(R.id.main_menu1);
        main_menu1.setOnClickListener(this);
        main_menu2 = findViewById(R.id.main_menu2);
        main_menu2.setOnClickListener(this);
        main_menu3 = findViewById(R.id.main_menu3);
        main_menu3.setOnClickListener(this);

        sendFlag = 1;

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("use", "y");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        NodeServerPostSend nodeServerPostSend = new NodeServerPostSend(sendFlag, "notice", jsonObject.toString(), callback);
        nodeServerPostSend.execute();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.main_menu1:

                startActivity(new Intent(this, 업체정보.class));

                break;

            case R.id.main_menu2:

                startActivity(new Intent(this, 미수현황.class));

                break;


            case R.id.main_menu3:
                startActivity(new Intent(this, 제품정보.class));
                break;

        }
    }

    private class MainHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String resultMessage = "";
            JSONObject jsonObject;
            ArrayList<공지사항모델> list = new ArrayList<>();
            resultMessage = msg.obj.toString();
            switch (msg.what) {
                case 1:
                    try {

                        jsonObject = new JSONObject(resultMessage);
                        String message = jsonObject.getString("message");
                        String data = jsonObject.getString("data");
                        Log.d("message", message);
                        Log.d("data", data);
                        JSONArray ja = new JSONArray(data);

                        for (int i = 0; i < ja.length(); i++) {
                            JSONObject order = ja.getJSONObject(i);
                            list.add(new 공지사항모델(order.getString("notice_image"), order.getString("notice_url")));
                            Log.d("---------", i + "--------");
                            Log.d("noctice_image", order.getString("notice_image"));
                            Log.d("notice_url", order.getString("notice_url"));
                        }

                        main_viewpager.setClipToPadding(false);
                        main_viewpager.setAdapter(new 공지사항리스트어뎁터(메인화면.this, list));
                        CircleIndicator circleIndicator = findViewById(R.id.circularindicator);
                        circleIndicator.setupWithViewPager(main_viewpager);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    sendFlag = 2;
//
                    SendPost sendPost = new SendPost(sendFlag, "account_code", callback, getApplicationContext());
                    sendPost.execute();

                    break;

                case 2:

                    asyncDialog.dismiss();
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    editor.putString("account_list", resultMessage);
                    editor.apply();

                    break;
            }
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

    @Override
    public void onBackPressed() {
        BackPressCloseHandler();
    }

    public void BackPressCloseHandler() {

        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            Toast.makeText(this, "\'뒤로\'버튼을 한번 더 누르시면 종료 됩니다.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            moveTaskToBack(true);
            finishAffinity();
            android.os.Process.killProcess(android.os.Process.myPid());
        }

    }
}
