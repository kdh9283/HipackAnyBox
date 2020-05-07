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

        String phonenum = sharedPreferences.getString("phoneNum", "");
        String corp_id = sharedPreferences.getString("corp_id", "");
        String user_name = sharedPreferences.getString("user_name", "");
        String customID = sharedPreferences.getString("customID", "");
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

            case "account_code":

                httpConnect.거래처정보(phonenum, corp_id, user_name, callback);
                break;

            case "미수현황모델":

                httpConnect.미수잔액(phonenum, corp_id, s_today, callback);
                break;

            case "미수현황상세":
                httpConnect.미수현황상세(phonenum, corp_id, s_today, customID, callback);
                break;

        }

        return null;

    }
}
