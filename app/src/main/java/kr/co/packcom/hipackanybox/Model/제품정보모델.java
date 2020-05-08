package kr.co.packcom.hipackanybox.Model;

import java.io.Serializable;

public class 제품정보모델 implements Serializable {

    public String atype="";
    public String setcnt="";
    public String customID="";
    public String customSName="";
    public String prodID="";
    public String prodName="";
    public String pJang="";
    public String pPock="";
    public String pGo="";
    public String pSize="";
    public String prodUnit="";
    public String deliverMemo="";
    public String UpUserID="";
    public String UpUserName="";
    public String UpDatetime="";
    public String bPublic="";
    public String chkWork="";
    public String paperName="";
    public String givWD="";
    public String givSC="";
    public String wjName="";
    public String SCState="";
    public String prodTypeID="";
    public String boxType="";
    public String bVAT="";
    public String bSET="";
    public String aL="";
    public String aW="";
    public String pCnt="";
    public String cL="";
    public String cW="";
    public String metrialID="";
    public String WDName="";
    public String WDmL="";
    public String WDmW="";
    public String WDpCnt="";
    public String metrialGor="";
    public String WDJang="";
    public String WDPock="";
    public String SCName="";
    public String SCmL="";
    public String SCmW="";
    public String SCpCnt="";


    public 제품정보모델(String atype, String setcnt, String customID, String customSName, String prodID, String prodName, String pJang, String pPock, String pGo, String pSize, String prodUnit, String deliverMemo, String upUserID, String upUserName, String upDatetime, String bPublic, String chkWork, String paperName, String givWD, String givSC, String wjName, String SCState, String prodTypeID, String boxType, String bVAT, String bSET, String aL, String aW, String pCnt, String cL, String cW, String metrialID, String WDName, String WDmL, String WDmW, String WDpCnt, String metrialGor, String WDJang, String WDPock, String SCName, String SCmL, String SCmW, String SCpCnt) {
        this.atype = atype;
        this.setcnt = setcnt;
        this.customID = customID;
        this.customSName = customSName;
        this.prodID = prodID;
        this.prodName = prodName;
        this.pJang = pJang;
        this.pPock = pPock;
        this.pGo = pGo;
        this.pSize = pSize;
        this.prodUnit = prodUnit;
        this.deliverMemo = deliverMemo;
        UpUserID = upUserID;
        UpUserName = upUserName;
        UpDatetime = upDatetime;
        this.bPublic = bPublic;
        this.chkWork = chkWork;
        this.paperName = paperName;
        this.givWD = givWD;
        this.givSC = givSC;
        this.wjName = wjName;
        this.SCState = SCState;
        this.prodTypeID = prodTypeID;
        this.boxType = boxType;
        this.bVAT = bVAT;
        this.bSET = bSET;
        this.aL = aL;
        this.aW = aW;
        this.pCnt = pCnt;
        this.cL = cL;
        this.cW = cW;
        this.metrialID = metrialID;
        this.WDName = WDName;
        this.WDmL = WDmL;
        this.WDmW = WDmW;
        this.WDpCnt = WDpCnt;
        this.metrialGor = metrialGor;
        this.WDJang = WDJang;
        this.WDPock = WDPock;
        this.SCName = SCName;
        this.SCmL = SCmL;
        this.SCmW = SCmW;
        this.SCpCnt = SCpCnt;
    }
}
