package kr.co.packcom.hipackanybox.Network;

import android.os.AsyncTask;

import okhttp3.Callback;


public class NodeServerPostSend extends AsyncTask<Void,Void,Void> {
    private int flag;
    private String name;
    private Callback callback;
    private String json;
    HttpConnect httpConnect = HttpConnect.getInstance();

    public NodeServerPostSend(int flag, String name, String json, Callback callback){
        this.flag = flag;
        this.name = name;
        this.json = json;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        String url = "http://hipackcom.co.kr/"+name;
        httpConnect.SendPostData(url,json,callback);
        return null;
    }
}
