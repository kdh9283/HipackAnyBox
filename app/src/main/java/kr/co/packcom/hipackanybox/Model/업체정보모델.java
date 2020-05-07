package kr.co.packcom.hipackanybox.Model;

import java.io.Serializable;

public class 업체정보모델 implements Serializable {
    public String 거래처키 = "";
    public String 대표="";
    public String 주소="";
    public String 비고="";
    public String 상호="";
    public String 축소상호 ="";
    public String 부서폰번호="";
    public String 담당자명="";
    public String 담당자Count="";
    public String 선입금="";
    public String 전화번호="";
    public String 이메일="";
    public String corpFax = "";
    public String UpUserID = "";
    public String UpUserName = "";
    public String UpDatetime ="";
    public String outBox ="";
    public String outKT="";
    public String inWD ="";
    public String inSC ="";
    public String inYJ ="";
    public String inKT ="";
    public String notCompany ="";
    public String UpUserID1 ="";
    public String UpUserName1 ="";
    public String UpDatetime1 ="";
    public String EnableCheck ="";

    public 업체정보모델(String 거래처키, String 대표, String 주소, String 비고, String 상호, String 축소상호, String 부서폰번호, String 담당자명, String 담당자Count, String 선입금, String 전화번호, String 이메일, String corpFax, String upUserID, String upUserName, String upDatetime, String outBox, String outKT, String inWD, String inSC, String inYJ, String inKT, String notCompany, String upUserID1, String upUserName1, String upDatetime1, String enableCheck) {
        this.거래처키 = 거래처키;
        this.대표 = 대표;
        this.주소 = 주소;
        this.비고 = 비고;
        this.상호 = 상호;
        this.축소상호 = 축소상호;
        this.부서폰번호 = 부서폰번호;
        this.담당자명 = 담당자명;
        this.담당자Count = 담당자Count;
        this.선입금 = 선입금;
        this.전화번호 = 전화번호;
        this.이메일 = 이메일;
        this.corpFax = corpFax;
        UpUserID = upUserID;
        UpUserName = upUserName;
        UpDatetime = upDatetime;
        this.outBox = outBox;
        this.outKT = outKT;
        this.inWD = inWD;
        this.inSC = inSC;
        this.inYJ = inYJ;
        this.inKT = inKT;
        this.notCompany = notCompany;
        UpUserID1 = upUserID1;
        UpUserName1 = upUserName1;
        UpDatetime1 = upDatetime1;
        EnableCheck = enableCheck;
    }
}
