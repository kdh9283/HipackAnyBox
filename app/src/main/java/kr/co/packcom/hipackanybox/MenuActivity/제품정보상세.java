package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
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

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Adapter.공정모델어뎁터;
import kr.co.packcom.hipackanybox.Model.공정모델;
import kr.co.packcom.hipackanybox.Model.박스사양모델;
import kr.co.packcom.hipackanybox.Model.인쇄사양모델;
import kr.co.packcom.hipackanybox.Model.자제사양모델;
import kr.co.packcom.hipackanybox.Model.제품정보모델;
import kr.co.packcom.hipackanybox.Network.HttpConnect;
import kr.co.packcom.hipackanybox.Network.SendPost;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ReturnArrayListFunction;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class 제품정보상세 extends AppCompatActivity {
    private TextView menu3_detail_title;
    private ArrayList<제품정보모델> list;
    private int position;
    private TextView menu3_detail_prodName;
    private TextView menu3_detail_prodName_code;
    private TextView menu3_detail_boxType;
    private TextView menu3_detail_paperName;
    private TextView menu3_detail_psize;
    private TextView menu3_detail_aLcW;
    private TextView menu3_detail_pCnt;
    private TextView menu3_detail_prodUnit;
    private TextView menu3_detail_WDName;
    private TextView menu3_detail_WDmL_WDmW;
    private TextView menu3_detail_WDpCnt;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private TextView menu3_detail_WDJang_WDPock;
    private Message msg;
    private Menu3_detail_Handler handler;
    private int sendFlag;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ReturnArrayListFunction returnArrayListFunction;
    private ArrayList<박스사양모델> boxlist;
    private ArrayList<자제사양모델> merriallist;
    private ArrayList<공정모델> processlist;
    private ArrayList<인쇄사양모델> photolist;
    private TextView menu3_detail_WDScore;
    private RecyclerView menu3_detail_process_recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private 공정모델어뎁터 adapter;
    private ImageView menu3_detail_image;
    private Dialog asyncDialog;
    private TextView tv_progress_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3_detail);
        list = (ArrayList<제품정보모델>) getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position", 0);
        sharedPreferences = getSharedPreferences("basicData", 0);
        editor = sharedPreferences.edit();
        editor.putString("prodID", list.get(position).prodID);
        editor.apply();

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
    }

    private void init() {

        returnArrayListFunction = new ReturnArrayListFunction();
        handler = new Menu3_detail_Handler();
        menu3_detail_process_recyclerview = findViewById(R.id.menu3_detail_process_recyclerview);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        menu3_detail_process_recyclerview.setLayoutManager(layoutManager);
        adapter = new 공정모델어뎁터();

        menu3_detail_image = findViewById(R.id.menu3_detail_image);
        menu3_detail_title = findViewById(R.id.menu3_detail_title);
        menu3_detail_title.setText("박스코드 상세정보 - " + list.get(position).prodName);
        menu3_detail_prodName = findViewById(R.id.menu3_detail_prodName);
        menu3_detail_prodName_code = findViewById(R.id.menu3_detail_prodName_code);
        menu3_detail_boxType = findViewById(R.id.menu3_detail_boxType);
        menu3_detail_paperName = findViewById(R.id.menu3_detail_paperName);
        menu3_detail_psize = findViewById(R.id.menu3_detail_psize);
        menu3_detail_aLcW = findViewById(R.id.menu3_detail_aLcW);
        menu3_detail_pCnt = findViewById(R.id.menu3_detail_pCnt);
        menu3_detail_prodUnit = findViewById(R.id.menu3_detail_prodUnit);
        menu3_detail_WDName = findViewById(R.id.menu3_detail_WDName);
        menu3_detail_WDmL_WDmW = findViewById(R.id.menu3_detail_WDmL_WDmW);
        menu3_detail_WDpCnt = findViewById(R.id.menu3_detail_WDpCnt);
        menu3_detail_WDJang_WDPock = findViewById(R.id.menu3_detail_WDJang_WDPock);
        menu3_detail_WDScore = findViewById(R.id.menu3_detail_WDScore);
        sendFlag = 1;

        SendPost sendPost = new SendPost(sendFlag, "spSel031productinfo_base2", callback, getApplicationContext());
        sendPost.execute();

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

    public class Menu3_detail_Handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String resultMessage;
            switch (msg.what) {
                case 1:

                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    boxlist = returnArrayListFunction.박스사양리스트(resultMessage);
                    menu3_detail_prodName.setText(boxlist.get(0).prodName);
                    menu3_detail_prodName_code.setText(boxlist.get(0).prodserialNo);
                    menu3_detail_boxType.setText(boxlist.get(0).boxType);
                    menu3_detail_paperName.setText(boxlist.get(0).paperName + " (" + boxlist.get(0).metrialGor + "골)");
                    menu3_detail_psize.setText(boxlist.get(0).pJang + " * " + boxlist.get(0).pPock + " * " + boxlist.get(0).pGo);
                    menu3_detail_aLcW.setText(boxlist.get(0).aL + " * " + boxlist.get(0).aW);
                    menu3_detail_pCnt.setText(boxlist.get(0).pCnt);
                    menu3_detail_prodUnit.setText(decimalFormat.format(Double.parseDouble(boxlist.get(0).prodUnit)));

                    sendFlag = 2;
                    SendPost sendPost = new SendPost(sendFlag, "spSel032productinfo_metrial", callback, getApplicationContext());
                    sendPost.execute();
                    break;

                case 2:
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    merriallist = returnArrayListFunction.자제사양리스트(resultMessage);
                    menu3_detail_WDName.setText(merriallist.get(0).metrialName + " (" + merriallist.get(0).metrialGor + "골)");
                    menu3_detail_WDmL_WDmW.setText(merriallist.get(0).mL + " * " + merriallist.get(0).mW);
                    menu3_detail_WDpCnt.setText(merriallist.get(0).pCnt);
                    menu3_detail_WDJang_WDPock.setText(merriallist.get(0).WDJang + " * " + merriallist.get(0).WDPock);
                    menu3_detail_WDScore.setText(merriallist.get(0).WDScore.replaceAll("\\*", " \\* "));
                    sendFlag = 3;
                    sendPost = new SendPost(sendFlag, "spSel031productinfo_base_PROCESS", callback, getApplicationContext());
                    sendPost.execute();

                    break;
                case 3:
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");

                    processlist = returnArrayListFunction.생산공전리스트(resultMessage);
                    menu3_detail_process_recyclerview.setAdapter(adapter);
                    adapter.setData(processlist);
                    sendFlag = 4;
                    sendPost = new SendPost(sendFlag, "spSel037productinfo_photo", callback, getApplicationContext());
                    sendPost.execute();

                    break;

                case 4:
                    HttpConnect httpConnect = HttpConnect.getInstance();
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    photolist = returnArrayListFunction.인쇄사양모델리스트(resultMessage);
                    if (photolist.size() != 0) {
                        String url = "";
                        url = httpConnect.getHttp() + ":62402/MOBI_Pic/" + sharedPreferences.getString("corp_id", "") + "/" + photolist.get(0).photoName;
                        Log.d("url", url);
                        Glide.with(getApplicationContext()).load(url).into(menu3_detail_image);
                    }
                    asyncDialog.dismiss();
                    break;
            }
        }
    }
}
