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
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Adapter.업체정보리스트어뎁터;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.Network.SendPost;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ReturnArrayListFunction;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class 업체정보 extends AppCompatActivity {
    private RecyclerView menu1_recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private Message msg;
    private int sendFlag;
    private Menu1Handler handler;
    private ReturnArrayListFunction returnArrayListFunction;
    private 업체정보리스트어뎁터 adapter;
    private Dialog asyncDialog;
    private TextView tv_progress_message;
    private ArrayList<업체정보모델> list;
    private EditText menu1_search;
    private ArrayList<업체정보모델> arraylist;
    private SharedPreferences sharedPreferences;
    private String intentString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);
        handler = new Menu1Handler();
        init();
    }

    private void init() {
        sharedPreferences = getSharedPreferences("basicData", 0);
        intentString = sharedPreferences.getString("account_list", "");
        menu1_search = findViewById(R.id.menu1_search);
        menu1_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String text = menu1_search.getText().toString();
                Log.d("text", text);
                search(text);

            }
        });
        menu1_recyclerview = findViewById(R.id.menu1_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        menu1_recyclerview.setLayoutManager(layoutManager);
        adapter = new 업체정보리스트어뎁터();

        returnArrayListFunction = new ReturnArrayListFunction();
        if (intentString.length() != 0) {
            arraylist = new ArrayList<>();
            list = returnArrayListFunction.getAccountCodelist(intentString);
            adapter.setAccountlist(list, handler);
            arraylist.addAll(list);
            menu1_recyclerview.setAdapter(adapter);
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

    private class Menu1Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {

            switch (msg.what) {
                case 1:
//
                    break;
                // DetailAccountCode
                case 2:
                    ArrayList<업체정보모델> sendlist = new ArrayList<>();
                    Intent intent = new Intent(업체정보.this, 업체정보상세.class);
                    sendlist.add(list.get(msg.arg1));
                    intent.putExtra("list", sendlist);
                    startActivity(intent);

                    break;
            }
        }
    }
}
