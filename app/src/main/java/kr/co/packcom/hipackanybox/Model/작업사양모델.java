package kr.co.packcom.hipackanybox.Model;

public class 작업사양모델 {
    public String prodID;
    public String PrintNo ;
    public String Printposition ;
    public String ColorType ;
    public String PastingID ;
    public String CoatingType ;
    public String CoatingID ;
    public String PushingNo ;
    public String Pushingposition ;
    public String ConnetingType ;
    public String ConnetingID ;
    public String PackCount ;
    public String PackType ;
    public String PackID ;
    public String levelCount ;
    public String loadposition ;
    public String barcode ;
    public String filmNo ;
    public String handChk ;
    public String JobMemo ;
    public String UpUserID ;
    public String UpUserName ;
    public String UpDatetime ;

    public 작업사양모델(String prodID, String printNo, String printposition, String colorType, String pastingID, String coatingType, String coatingID, String pushingNo, String pushingposition, String connetingType, String connetingID, String packCount, String packType, String packID, String levelCount, String loadposition, String barcode, String filmNo, String handChk, String jobMemo, String upUserID, String upUserName, String upDatetime) {
        this.prodID = prodID;
        PrintNo = printNo;
        Printposition = printposition;
        ColorType = colorType;
        PastingID = pastingID;
        CoatingType = coatingType;
        CoatingID = coatingID;
        PushingNo = pushingNo;
        Pushingposition = pushingposition;
        ConnetingType = connetingType;
        ConnetingID = connetingID;
        PackCount = packCount;
        PackType = packType;
        PackID = packID;
        this.levelCount = levelCount;
        this.loadposition = loadposition;
        this.barcode = barcode;
        this.filmNo = filmNo;
        this.handChk = handChk;
        JobMemo = jobMemo;
        UpUserID = upUserID;
        UpUserName = upUserName;
        UpDatetime = upDatetime;
    }
}
