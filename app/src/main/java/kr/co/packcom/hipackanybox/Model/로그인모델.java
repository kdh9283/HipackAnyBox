package kr.co.packcom.hipackanybox.Model;

public class 로그인모델 {
    public String CORP_ID;
    public String CORP_NAME;

    public String CARNUMBER;
    public String ftpid;
    public String ftppass;
    public String WEBIMAGE_PATH;

    public 로그인모델(String CORP_ID, String CORP_NAME, String CARNUMBER, String ftpid, String ftppass, String WEBIMAGE_PATH) {

        this.CORP_ID = CORP_ID;
        this.CORP_NAME = CORP_NAME;
        this.CARNUMBER = CARNUMBER;
        this.ftpid = ftpid;
        this.ftppass = ftppass;
        this.WEBIMAGE_PATH = WEBIMAGE_PATH;

    }
}
