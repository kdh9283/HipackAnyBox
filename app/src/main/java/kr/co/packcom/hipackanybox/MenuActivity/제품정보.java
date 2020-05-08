package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.CodeName_List;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.Network.SendPost;
import kr.co.packcom.hipackanybox.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class 제품정보 extends AppCompatActivity implements View.OnClickListener {
    private TextView menu3_title;
    private Button menu3_select;
    private ArrayList<업체정보모델> list;
    private TextView tv_name;
    private int sendFlag;
    private Dialog asyncDialog;
    private Menu3Handler handler;
    private Message msg;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        init();
    }

    private void init() {
        sharedPreferences = getSharedPreferences("basicData", 0);
        editor = sharedPreferences.edit();
        handler = new Menu3Handler();
        menu3_title = findViewById(R.id.menu3_title);
        menu3_title.setText("제품정보");
        menu3_select = findViewById(R.id.menu3_select);
        menu3_select.setOnClickListener(this);
        tv_name = findViewById(R.id.tv_name);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu3_select:
                startActivityForResult(new Intent(this, CodeName_List.class),1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){

            case 1:
                Log.d("돌아옴","oo");
                String 상호 = data.getStringExtra("상호");
                String key = data.getStringExtra("key");
                Log.d("상호",상호);
                Log.d("키값",key);
                editor.putString("거래처키",key);
                editor.commit();
                tv_name.setText(상호);
                sendFlag = 1;
                SendPost sendPost = new SendPost(sendFlag,"제품정보",callback,getApplicationContext());
                sendPost.execute();
                break;

            case 2:

                break;
        }
    }

    private final Callback callback = new Callback() {
        @Override
        public void onFailure(Call call, IOException e) {
            asyncDialog.dismiss();

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

    private class Menu3Handler extends Handler{
        @Override
        public void handleMessage(Message msg) {
           switch (msg.what){
               case 1:

                   break;
           }
        }
    }
}