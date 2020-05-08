package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;

import kr.co.packcom.hipackanybox.Adapter.미수현황리스트어뎁터;
import kr.co.packcom.hipackanybox.Model.미수현황모델;
import kr.co.packcom.hipackanybox.Network.SendPost;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ReturnArrayListFunction;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class 미수현황 extends AppCompatActivity {
    private TextView menu2_title;
    private RecyclerView menu2_recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private int sendFlag = 1;
    private Message msg;
    private Menu2Handler handler;
    private Dialog asyncDialog;
    private TextView tv_progress_message;
    private ArrayList<미수현황모델> list;
    private ReturnArrayListFunction returnArrayListFunction;
    private 미수현황리스트어뎁터 adapter;
    private TextView misu_sum2, misu_sum1;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private ArrayList<String> group;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);
        handler = new Menu2Handler();
        init();


    }

    private void init() {
        sharedPreferences = getSharedPreferences("basicData", 0);
        editor = sharedPreferences.edit();
        returnArrayListFunction = new ReturnArrayListFunction();
        asyncDialog = new Dialog(this);

        asyncDialog.setCancelable(false);
        asyncDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        asyncDialog.setContentView(R.layout.loading);

        asyncDialog.show();

        final ImageView img_loading_frame = asyncDialog.findViewById(R.id.iv_frame_loading);
        final AnimationDrawable frameAnimation = (AnimationDrawable) img_loading_frame.getBackground();
        tv_progress_message = asyncDialog.findViewById(R.id.tv_progress_message);
        tv_progress_message.setText("미수현황 데이터 조회 중 입니다.");
        //        frameAnimation.start();

        img_loading_frame.post(new Runnable() {
            @Override
            public void run() {
                frameAnimation.start();
            }
        });

        Calendar calendar = new GregorianCalendar(Locale.KOREA);
        String s_month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        menu2_title = findViewById(R.id.menu2_title);
        menu2_title.setText(s_month + "월 미수현황");
        menu2_recyclerview = findViewById(R.id.menu2_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        menu2_recyclerview.setLayoutManager(layoutManager);
        misu_sum1 = findViewById(R.id.misu_sum1);
        misu_sum2 = findViewById(R.id.misu_sum2);
        SendPost sendPost = new SendPost(sendFlag, "미수현황모델", callback, getApplicationContext());
        sendPost.execute();

    }


    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            msg = handler.obtainMessage();
            msg.what = 100;
            handler.sendMessage(msg);
            Log.d("aa", "콜백오류:" + e.getMessage());
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

    private class Menu2Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String resultMessage;
            switch (msg.what) {
                case 1:
                    group = new ArrayList<>();
                    list = new ArrayList<>();

                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);

                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");

                    Log.d("resultMessage", resultMessage);
                    list = returnArrayListFunction.미수잔액모델리스트(resultMessage);
                    for (int i = 0; i < list.size(); i++) {

                        if (!group.contains(list.get(i).customSName)) {

                            group.add(list.get(i).customSName);

                        }
                    }

                    Log.d("list.size", list.size() + "");
                    adapter = new 미수현황리스트어뎁터();

                    menu2_recyclerview.setAdapter(adapter);
                    adapter.setList(list, group, handler);
                    int leftMoney = 0;
                    int before1MonthLeftMoney = 0;
                    for (int i = 0; i < list.size(); i++) {

                        leftMoney += Double.parseDouble(list.get(i).LeftMoney);
                        before1MonthLeftMoney += Double.parseDouble(list.get(i).Before1MonthLeftMoney);


                    }

                    misu_sum1.setText(decimalFormat.format(leftMoney));
                    misu_sum2.setText(decimalFormat.format(before1MonthLeftMoney));
                    asyncDialog.dismiss();
                    break;
//                case 2:
//                    sendFlag = 2;
//                    SendPost sendPost = new SendPost(sendFlag, "미수현황상세", callback, getApplicationContext());
//                    sendPost.execute();
//
//                    break;


                case 2:
                    int position = msg.arg1;
                    Log.d("group", group.get(position));
                    String customID = "";
                    String customSName= "";

                    for (int i = 0; i < list.size(); i++) {
                        if (group.get(position).equalsIgnoreCase(list.get(i).customSName)) {
                            customID = list.get(i).customID;
                            customSName =list.get(i).customSName;
                            break;
                        }

                    }
                    editor.putString("customID", customID);
                    editor.putString("customSName",customSName);
                    editor.apply();
                    Log.d("customID", customID);
                    Log.d("customSName", customSName);
                    startActivity(new Intent(미수현황.this,미수현황상세.class));
                    break;

            }
        }
    }
}
