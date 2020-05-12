package kr.co.packcom.hipackanybox.Network;

import android.util.Log;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpConnect {
    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http;
    }

    public String http = "";
    public static HttpConnect getInstance = new HttpConnect();

    public static HttpConnect getInstance() {
        return getInstance;
    }

    public OkHttpClient client;

    public HttpConnect() {
        client = new OkHttpClient();
    }

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    void SendPostData(String url, String json, Callback callback) {

        RequestBody requestBody;
        requestBody = RequestBody.Companion.create(json, JSON);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Log.d("SendURL", url);
        client.newCall(request).enqueue(callback);
    }

    // 로그인
    public void login(String phoneNum, Callback callback) {
        // http://packcom.ml/WAS/AndroidService.svc/AndroidSearch/000000public┘0┘0/spPHONENUMBER_CHECK/@PHONE_NO┘@TOKEN_ID/010-3563-5877┘dk3fFcS-VNA:APA91bG6nibWU6WbvcIrGwKhz1fjZX8Iu6-fVleUdbLSjqHu0EZzcMNf6_L5A3-NwDsSkdUqrwTsiwg9hwQvQHKO0O43ZVyXa9dA7n47G6B7EUF6zRlWhBXwgfOE7sbV-srdg5lOmWJb
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/000000public┘0┘0/spPHONENUMBER_CHECK/@PHONE_NO/" + phoneNum;

        //url = "http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/000000public┘0┘0/spPHONENUMBER_CHECK/@PHONE_NO┘@TOKEN_ID/010-6513-1917┘" + ReplacePost(tokenID);

        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);

    }

    // 거래처 정보 조회 http://packcom.ml/WAS/AndroidService.svc/AndroidDefault/" +CORP_ID + "┘" +  phoneNumber + "┘" + USER_NAME + "/spSel011customersinfo_sNameAll

    public void spSel011customersinfo_sNameAll(String phoneNum, String corp_id, String user_name, Callback callback) {

        String url = http + "/WAS/AndroidService.svc/AndroidDefault/" + corp_id + "┘" + phoneNum + "┘" + user_name + "/spSel011customersinfo_sNameAll";

        //url = "http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/000000public┘0┘0/spPHONENUMBER_CHECK/@PHONE_NO┘@TOKEN_ID/010-6513-1917┘" + ReplacePost(tokenID);

        Log.d("send ->", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);

    }

    // 미수현황모델 표시 http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel971repcIO_ThreeMonthList/@%EC%B6%9C%EB%A0%A5%EC%9D%BC/2020-04-25
    public void spSel971repcIO_ThreeMonthList(String phoneNum, String corp_id, String date, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phoneNum + "┘/spSel971repcIO_ThreeMonthList/@출력일/" + date;
        Log.d("send ->", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);

    }

    public void spSel972repcIO_DetailList(String phonenum, String corp_id, String s_today, String customID, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel972repcIO_DetailList/@출력일┘@거래처ID/" + s_today + "┘" + customID;
        Log.d("send ->", url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }

    //    http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel031productinfo_baseCustomer/@%EA%B1%B0%EB%9E%98%EC%B2%98ID/128
    public void spSel031productinfo_baseCustomer(String phonenum, String corp_id, String key, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel031productinfo_baseCustomer/@거래처ID/" + key;
        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
    //http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel031productinfo_base2/@%EC%A0%9C%ED%92%88ID/10
    public void spSel031productinfo_base2(String phonenum,String corp_id,String prodID,Callback callback){
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel031productinfo_base2/@제품ID/" + prodID;
        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
    //http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel032productinfo_metrial/@%EC%A0%9C%ED%92%88ID/10
    public void spSel032productinfo_metrial(String phonenum, String corp_id, String prodID, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel032productinfo_metrial/@제품ID/" + prodID;
        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
    //http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel031productinfo_base_PROCESS/@%EC%A0%9C%ED%92%88ID/10
    public void spSel031productinfo_base_PROCESS(String phonenum, String corp_id, String prodID, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel031productinfo_base_PROCESS/@제품ID/" + prodID;
        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
    private String ReplacePost(String uri_Value) {

        uri_Value =
                uri_Value.replace("`", "├00┤")

                        .replace("~", "├01┤")
                        .replace("!", "├02┤")
                        .replace("@", "├03┤")
                        .replace("#", "├04┤")
                        .replace("$", "├05┤")
                        .replace("%", "├06┤")
                        .replace("^", "├07┤")
                        .replace("&", "├08┤")
                        .replace("*", "├09┤")
                        .replace("(", "├10┤")
                        .replace(")", "├11┤")
                        .replace("+", "├12┤")
                        .replace("-", "├13┤")
                        .replace(",", "├14┤")
                        .replace(".", "├15┤")
                        .replace(";", "├16┤")
                        .replace(":", "├17┤")
                        .replace("'", "├18┤")
                        .replace("\"", "├19┤")
                        .replace("/", "├20┤")
                        .replace("{", "├21┤")
                        .replace("}", "├22┤")
                        .replace("<", "├23┤")
                        .replace(">", "├24┤")
                        .replace("[", "├25┤")
                        .replace("]", "├26┤");

        return uri_Value;

    }

//http://miraebox.float-zone.com/WAS/AndroidService.svc/AndroidSearch/C4E5132036%E2%94%98010-0000-0000%E2%94%98/spSel037productinfo_photo/@%EC%A0%9C%ED%92%88ID/10
    public void spSel037productinfo_photo(String phonenum, String corp_id, String prodID, Callback callback) {
        String url = http + "/WAS/AndroidService.svc/AndroidSearch/" + corp_id + "┘" + phonenum + "┘/spSel037productinfo_photo/@제품ID/" + prodID;
        Log.d("send ->", url);
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(callback);
    }
}

