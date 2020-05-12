package kr.co.packcom.hipackanybox.Network;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import okhttp3.Callback;

public class SendPost extends AsyncTask<Void, Void, Void> {
    private int flag;
    private String send;
    private Callback callback;
    private HttpConnect httpConnect = HttpConnect.getInstance();
    private String http;
    private SharedPreferences sharedPreferences;

    public SendPost(int flag, String send, Callback callback, Context context) {

        this.flag = flag;
        this.send = send;
        this.callback = callback;
        http = httpConnect.getHttp();
        sharedPreferences = context.getSharedPreferences("basicData", 0);

    }

    @Override
    protected Void doInBackground(Void... voids) {
        String prodID = sharedPreferences.getString("prodID","");
        String phonenum = sharedPreferences.getString("phoneNum", "");
        String corp_id = sharedPreferences.getString("corp_id", "");
        String user_name = sharedPreferences.getString("user_name", "");
        String customID = sharedPreferences.getString("customID", "");
        String 거래처키 = sharedPreferences.getString("거래처키","");
        String s_today;
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        s_today = simpleDateFormat.format(today);

        switch (send) {

            case "serverlogin":

                httpConnect.login(phonenum, callback);
                break;

            case "spSel011customersinfo_sNameAll":

                httpConnect.spSel011customersinfo_sNameAll(phonenum, corp_id, user_name, callback);
                break;

            case "spSel971repcIO_ThreeMonthList":

                httpConnect.spSel971repcIO_ThreeMonthList(phonenum, corp_id, s_today, callback);
                break;

            case "spSel972repcIO_DetailList":
                httpConnect.spSel972repcIO_DetailList(phonenum, corp_id, s_today, customID, callback);
                break;
                //제품정보리스트
            case "spSel031productinfo_baseCustomer":
                httpConnect.spSel031productinfo_baseCustomer(phonenum, corp_id,  거래처키, callback);
                break;

                //박스사양
            case "spSel031productinfo_base2":
                httpConnect.spSel031productinfo_base2(phonenum,corp_id,prodID,callback);
                break;
                //자재사양
            case "spSel032productinfo_metrial":
                httpConnect.spSel032productinfo_metrial(phonenum,corp_id,prodID,callback);
                break;
            case "spSel031productinfo_base_PROCESS":
                httpConnect.spSel031productinfo_base_PROCESS(phonenum,corp_id,prodID,callback);
                break;
            case "spSel037productinfo_photo":
                httpConnect.spSel037productinfo_photo(phonenum,corp_id,prodID,callback);
                break;

            case "spSel033productworkinfo_Memo":
                httpConnect.spSel033productworkinfo_Memo(phonenum,corp_id,prodID,callback);
                break;


        }

        return null;

    }
}
