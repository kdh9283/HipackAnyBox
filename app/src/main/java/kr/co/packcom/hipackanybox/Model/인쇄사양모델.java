package kr.co.packcom.hipackanybox.Model;

public class 인쇄사양모델 {
    public String prodID="";
    public String photoID="";
    public String photoDate="";
    public String photofilePath="";
    public String photoName ="";
    public String photoChk ="";
    public String ctpfilePath ="";
    public String photoMemo ="";
    public String UpUserID ="";
    public String UpUserName ="";
    public String UpDatetime ="";
    public String customID ="";

    public 인쇄사양모델(String prodID, String photoID, String photoDate, String photofilePath, String photoName, String photoChk, String ctpfilePath, String photoMemo, String upUserID, String upUserName, String upDatetime, String customID) {
        this.prodID = prodID;
        this.photoID = photoID;
        this.photoDate = photoDate;
        this.photofilePath = photofilePath;
        this.photoName = photoName;
        this.photoChk = photoChk;
        this.ctpfilePath = ctpfilePath;
        this.photoMemo = photoMemo;
        UpUserID = upUserID;
        UpUserName = upUserName;
        UpDatetime = upDatetime;
        this.customID = customID;
    }
}
