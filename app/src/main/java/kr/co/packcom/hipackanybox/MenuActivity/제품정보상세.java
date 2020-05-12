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
import android.view.View;
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
import kr.co.packcom.hipackanybox.Model.작업사양모델;
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
    private ArrayList<박스사양모델> boxlist;
    private ArrayList<자제사양모델> merriallist;
    private ArrayList<공정모델> processlist;
    private ArrayList<인쇄사양모델> photolist;
    private ArrayList<작업사양모델> workinfolist;
    private int position;
    private TextView menu3_detail_prodName, menu3_detail_prodName_code, menu3_detail_boxType, menu3_detail_paperName, menu3_detail_psize, menu3_detail_aLcW, menu3_detail_pCnt, menu3_detail_prodUnit;
    private TextView menu3_detail_WDName, menu3_detail_WDmL_WDmW, menu3_detail_WDpCnt, menu3_detail_WDJang_WDPock, menu3_detail_WDScore, tv_progress_message, menu3_detail_WDJs, menu3_no_image;
    private TextView menu3_detail_filmNo, menu3_detail_CoatingType, menu3_detail_PrintNo, menu3_detail_Printposition, menu3_detail_ColorType, menu3_detail_PushingNo, menu3_detail_Pushingposition, menu3_detail_ConnetingType, menu3_detail_handChk,
            menu3_detail_PackCount, menu3_detail_PackType, menu3_detail_JobMemo;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private Message msg;
    private Menu3_detail_Handler handler;
    private int sendFlag;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ReturnArrayListFunction returnArrayListFunction;
    private RecyclerView menu3_detail_process_recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private 공정모델어뎁터 adapter;
    private ImageView menu3_detail_image;
    private Dialog asyncDialog;

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
        menu3_detail_WDJs = findViewById(R.id.menu3_detail_WDJs);
        menu3_no_image = findViewById(R.id.menu3_no_image);
        menu3_detail_filmNo = findViewById(R.id.menu3_detail_filmNo);
        menu3_detail_CoatingType = findViewById(R.id.menu3_detail_CoatingType);
        menu3_detail_PrintNo = findViewById(R.id.menu3_detail_PrintNo);
        menu3_detail_Printposition = findViewById(R.id.menu3_detail_Printposition);
        menu3_detail_ColorType = findViewById(R.id.menu3_detail_ColorType);
        menu3_detail_PushingNo = findViewById(R.id.menu3_detail_PushingNo);
        menu3_detail_Pushingposition = findViewById(R.id.menu3_detail_Pushingposition);
        menu3_detail_ConnetingType = findViewById(R.id.menu3_detail_ConnetingType);
        menu3_detail_handChk = findViewById(R.id.menu3_detail_handChk);
        menu3_detail_PackCount = findViewById(R.id.menu3_detail_PackCount);
        menu3_detail_PackType = findViewById(R.id.menu3_detail_PackType);
        menu3_detail_JobMemo = findViewById(R.id.menu3_detail_JobMemo);


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
                    menu3_detail_aLcW.setText(boxlist.get(0).aL + " * " + boxlist.get(0).aW + " (" + (Double.parseDouble(boxlist.get(0).aL) * Double.parseDouble(boxlist.get(0).aW)) / 1000000 + " ㎡)");
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
                    menu3_detail_WDmL_WDmW.setText(merriallist.get(0).mL + " * " + merriallist.get(0).mW + " (" + (Double.parseDouble(merriallist.get(0).mL) * Double.parseDouble(merriallist.get(0).mW)) / 1000000 + " ㎡)");

                    menu3_detail_WDpCnt.setText(merriallist.get(0).pCnt);
                    menu3_detail_WDJang_WDPock.setText(merriallist.get(0).WDJang + " * " + merriallist.get(0).WDPock + " (" + (Double.parseDouble(merriallist.get(0).WDJang) * Double.parseDouble(merriallist.get(0).WDPock)) / 1000000 + " ㎡)");
                    menu3_detail_WDScore.setText(merriallist.get(0).WDScore.replaceAll("\\*", " \\* "));
                    menu3_detail_WDJs.setText(merriallist.get(0).WDJs);
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

                        menu3_no_image.setVisibility(View.INVISIBLE);
                        menu3_detail_image.setVisibility(View.VISIBLE);
                        String url = "";
                        url = httpConnect.getHttp() + ":62402/MOBI_Pic/" + sharedPreferences.getString("corp_id", "") + "/" + photolist.get(0).photoName;
                        Log.d("url", url);
                        Glide.with(getApplicationContext()).load(url).into(menu3_detail_image);

                    } else {
                        menu3_no_image.setVisibility(View.VISIBLE);
                        menu3_detail_image.setVisibility(View.INVISIBLE);
                    }

                    sendFlag = 5;
                    sendPost = new SendPost(sendFlag, "spSel033productworkinfo_Memo", callback, getApplicationContext());
                    sendPost.execute();

                    break;

                case 5:
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");
                    workinfolist = returnArrayListFunction.작업사양리스트(resultMessage);
                    menu3_detail_filmNo.setText(workinfolist.get(0).filmNo);
                    menu3_detail_CoatingType.setText(workinfolist.get(0).CoatingType);
                    menu3_detail_PrintNo.setText(workinfolist.get(0).PrintNo);
                    menu3_detail_Printposition.setText(workinfolist.get(0).Printposition);
                    menu3_detail_ColorType.setText(workinfolist.get(0).ColorType);
                    menu3_detail_PushingNo.setText(workinfolist.get(0).PushingNo);
                    menu3_detail_Pushingposition.setText(workinfolist.get(0).Pushingposition);
                    menu3_detail_ConnetingType.setText(workinfolist.get(0).ConnetingType);
                    menu3_detail_handChk.setText(workinfolist.get(0).handChk);
                    menu3_detail_PackCount.setText(workinfolist.get(0).PackCount);
                    menu3_detail_PackType.setText(workinfolist.get(0).PackType);
                    menu3_detail_JobMemo.setText(workinfolist.get(0).JobMemo);
                    asyncDialog.dismiss();
                    break;
            }
        }
    }
}
