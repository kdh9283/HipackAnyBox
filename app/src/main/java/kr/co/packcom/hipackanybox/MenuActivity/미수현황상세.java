package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import kr.co.packcom.hipackanybox.Adapter.미수현황상세리스트어뎁터;
import kr.co.packcom.hipackanybox.Model.미수현황상세모델;
import kr.co.packcom.hipackanybox.Network.SendPost;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ReturnArrayListFunction;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class 미수현황상세 extends AppCompatActivity {

    private int sendFlag;
    private Message msg;
    private misu_handler handler;
    private TextView menu2_detail_title;
    private SharedPreferences sharedPreferences;
    private RecyclerView misu_detail_recyclerview;
    private RecyclerView.LayoutManager layoutManager;
    private ReturnArrayListFunction returnArrayListFunction;
    private ArrayList<미수현황상세모델> list;
    private 미수현황상세리스트어뎁터 adapter;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private TextView IOMoney_total1, IOMoney_total2, RecpMoney, DiscountMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.misu_detail);

        init();
    }

    private void init() {

        returnArrayListFunction = new ReturnArrayListFunction();
        sharedPreferences = getSharedPreferences("basicData", 0);

        Calendar calendar = new GregorianCalendar(Locale.KOREA);
        String s_month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);

        menu2_detail_title = findViewById(R.id.menu2_detail_title);
        menu2_detail_title.setText(s_month + "월 미수상세현황 - " + sharedPreferences.getString("customSName", ""));
        misu_detail_recyclerview = findViewById(R.id.misu_detail_recyclerview);

        layoutManager = new LinearLayoutManager(this);
        misu_detail_recyclerview.setLayoutManager(layoutManager);
        IOMoney_total1 = findViewById(R.id.IOMoney_total1);
        IOMoney_total2 = findViewById(R.id.IOMoney_total2);
        DiscountMoney = findViewById(R.id.DiscountMoney);
        RecpMoney = findViewById(R.id.RecpMoney);

        handler = new misu_handler();
        sendFlag = 1;

        SendPost sendPost = new SendPost(sendFlag, "미수현황상세", callback, getApplicationContext());
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

    private class misu_handler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            String resultMessage;
            switch (msg.what) {
                case 1:

                    adapter = new 미수현황상세리스트어뎁터();
                    ArrayList<String> group = new ArrayList<>();
                    list = new ArrayList<>();
                    resultMessage = msg.obj.toString();
                    resultMessage = resultMessage.substring(1, resultMessage.length() - 1);
                    resultMessage = resultMessage.replaceAll("\\\\\\\\r\\\\\\\\n", "ª");
                    resultMessage = resultMessage.replaceAll("\\\\", "");
                    resultMessage = resultMessage.replaceAll("ª", "\\\\r\\\\n");

                    Log.d("resultMessage", resultMessage);
                    list = returnArrayListFunction.미수현황상세리스트(resultMessage);

                    for (int i = 0; i < list.size(); i++) {
                        if (!group.contains(list.get(i).MonthNo)) {

                            group.add(list.get(i).MonthNo);

                        }
                    }

                    misu_detail_recyclerview.setAdapter(adapter);
                    adapter.setData(group, list, handler);

                    int 매출 = 0;
                    int 잔액 = 0;
                    int 할인 = 0;
                    int 수금 = 0;

                    for (int i = 0; i < list.size(); i++) {

                        if (Integer.parseInt(list.get(i).MonthNo) != 0) {

                            매출 += Double.parseDouble(list.get(i).IOMoney);
                            매출 -= Double.parseDouble(list.get(i).DiscountMoney);
                            매출 -= Double.parseDouble(list.get(i).RecpMoney);
                            할인 += Double.parseDouble(list.get(i).DiscountMoney);
                            수금 += Double.parseDouble(list.get(i).RecpMoney);

                        }

                        잔액 += Double.parseDouble(list.get(i).IOMoney);
                        잔액 -= Double.parseDouble(list.get(i).DiscountMoney);
                        잔액 -= Double.parseDouble(list.get(i).RecpMoney);

                    }

                    IOMoney_total1.setText(decimalFormat.format(매출));
                    IOMoney_total2.setText(decimalFormat.format(잔액));
                    RecpMoney.setText(decimalFormat.format(수금));
                    DiscountMoney.setText(decimalFormat.format(할인));

                    break;

                case 2:

                    break;
            }
        }
    }
}
