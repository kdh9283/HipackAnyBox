package kr.co.packcom.hipackanybox;


import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Adapter.업체정보리스트어뎁터;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.Network.SendPost;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CodeName_List extends Activity {
    private int sendFlag = 0;
    private CodeNameHandler handler;
    private Message msg;
    private String intentString;
    private ArrayList<업체정보모델> list;
    private ArrayList<업체정보모델> arraylist;
    private ReturnArrayListFunction returnArrayListFunction;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private 업체정보리스트어뎁터 adapter;
    private EditText ed_codename;
    private Dialog asyncDialog;
    private TextView tv_progress_message;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_name__list);
        sharedPreferences = getSharedPreferences("basicData",0);
        intentString = sharedPreferences.getString("account_list","");
        init();

    }

    private void init() {
        ed_codename = findViewById(R.id.ed_codename);
        ed_codename.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = ed_codename.getText().toString();
                Log.d("text", text);
                search(text);
            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.code_name_recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new 업체정보리스트어뎁터();
        returnArrayListFunction = new ReturnArrayListFunction();
        handler = new CodeNameHandler();

        if(intentString.length()!=0){
            arraylist = new ArrayList<>();
            list = returnArrayListFunction.getAccountCodelist(intentString);
            adapter.setAccountlist(list, handler);
            arraylist.addAll(list);
            recyclerView.setAdapter(adapter);

        }

//        sendFlag = 1;
//
//        SendPost sendPost = new SendPost(sendFlag, "account_code", callback, getApplicationContext());
//        sendPost.execute();

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

    private class CodeNameHandler extends Handler {

        @Override

        public void handleMessage(Message msg) {

            String resultMessage = "";

            switch (msg.what) {

                case 1:
                    resultMessage = msg.obj.toString();
                    arraylist = new ArrayList<>();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    list = returnArrayListFunction.getAccountCodelist(resultMessage);
                    adapter.setAccountlist(list, handler);
                    arraylist.addAll(list);
                    recyclerView.setAdapter(adapter);
                    Log.d("resultMessage", resultMessage);
                    asyncDialog.dismiss();

                    break;

                case 2:
                    Intent intent = new Intent();
                    intent.putExtra("상호",list.get(msg.arg1).축소상호);
                    intent.putExtra("key",list.get(msg.arg1).거래처키);
                    setResult(1,intent);
                    finish();
                    break;
            }
        }
    }

    private void search(String text) {

        list.clear();
        if (text.length() == 0) {
            list.addAll(arraylist);

        } else {
            for (int i = 0; i < arraylist.size(); i++) {

                if (arraylist.get(i).축소상호.toLowerCase().contains(text)) {

                    list.add(arraylist.get(i));
                }
            }
        }

        adapter.updatelist(list, handler);

    }

}
