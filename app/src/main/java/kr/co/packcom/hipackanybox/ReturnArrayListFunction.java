package kr.co.packcom.hipackanybox;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

import kr.co.packcom.hipackanybox.Model.공정모델;
import kr.co.packcom.hipackanybox.Model.미수현황모델;
import kr.co.packcom.hipackanybox.Model.미수현황상세모델;
import kr.co.packcom.hipackanybox.Model.박스사양모델;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.Model.로그인모델;
import kr.co.packcom.hipackanybox.Model.인쇄사양모델;
import kr.co.packcom.hipackanybox.Model.자제사양모델;
import kr.co.packcom.hipackanybox.Model.작업사양모델;
import kr.co.packcom.hipackanybox.Model.제품정보모델;


public class ReturnArrayListFunction {
    public ArrayList<자제사양모델> 자제사양리스트(String result) {
        ArrayList<자제사양모델> list = new ArrayList<>();
        String prodID = "";
        String metrialID = "";
        String metrialName = "";
        String mL = "";
        String mW = "";
        String pCnt = "";
        String WDScore = "";
        String BJMemo = "";
        String metcustomID = "";
        String WDJang = "";
        String WDPock = "";
        String WDJs = "";
        String UpUserID = "";
        String UpUserName = "";
        String UpDatetime = "";
        String metrialName1 = "";
        String metrialGor = "";
        String metrialKind = "";
        String metrialmUnit = "";

        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");
                }
                if (!jsonObject.isNull("metrialID")) {
                    metrialID = jsonObject.getString("metrialID");
                }
                if (!jsonObject.isNull("metrialName")) {
                    metrialName = jsonObject.getString("metrialName");
                }
                if (!jsonObject.isNull("mL")) {
                    mL = jsonObject.getString("mL");
                }
                if (!jsonObject.isNull("mW")) {
                    mW = jsonObject.getString("mW");
                }
                if (!jsonObject.isNull("pCnt")) {
                    pCnt = jsonObject.getString("pCnt");
                }
                if (!jsonObject.isNull("WDScore")) {
                    WDScore = jsonObject.getString("WDScore");
                }
                if (!jsonObject.isNull("BJMemo")) {
                    BJMemo = jsonObject.getString("BJMemo");
                }
                if (!jsonObject.isNull("metcustomID")) {
                    metcustomID = jsonObject.getString("metcustomID");
                }
                if (!jsonObject.isNull("WDJang")) {
                    WDJang = jsonObject.getString("WDJang");
                }
                if (!jsonObject.isNull("WDPock")) {
                    WDPock = jsonObject.getString("WDPock");
                }
                if (!jsonObject.isNull("WDJs")) {
                    WDJs = jsonObject.getString("WDJs");
                }
                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");
                }
                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");
                }
                if (!jsonObject.isNull("UpDatetime")) {
                    UpDatetime = jsonObject.getString("UpDatetime");
                }
                if (!jsonObject.isNull("metrialName1")) {
                    metrialName1 = jsonObject.getString("metrialName1");
                }
                if (!jsonObject.isNull("metrialGor")) {
                    metrialGor = jsonObject.getString("metrialGor");
                }
                if (!jsonObject.isNull("metrialKind ")) {
                    metrialKind = jsonObject.getString("metrialKind");
                }
                if (!jsonObject.isNull("metrialmUnit")) {
                    metrialmUnit = jsonObject.getString("metrialmUnit");
                }
                list.add(new 자제사양모델(prodID, metrialID, metrialName, mL, mW, pCnt, WDScore, BJMemo, metcustomID, WDJang, WDPock, WDJs, UpUserID, UpUserName, UpDatetime, metrialName1, metrialGor, metrialKind, metrialmUnit));
                Log.d("prodID ", prodID + " ");
                Log.d("metrialID ", metrialID + " ");
                Log.d("metrialName ", metrialName + " ");
                Log.d("mL ", mL + " ");
                Log.d("mW ", mW + " ");
                Log.d("pCnt ", pCnt + " ");
                Log.d("WDScore ", WDScore + " ");
                Log.d("BJMemo ", BJMemo + " ");
                Log.d("metcustomID ", metcustomID + " ");
                Log.d("WDJang ", WDJang + " ");
                Log.d("WDPock ", WDPock + " ");
                Log.d("WDJs ", WDJs + " ");
                Log.d("UpUserID ", UpUserID + " ");
                Log.d("UpUserName ", UpUserName + " ");
                Log.d("UpDatetime ", UpDatetime + " ");
                Log.d("pCnt ", pCnt + " ");
                Log.d("metrialName1 ", metrialName1 + " ");
                Log.d("metrialGor ", metrialGor + " ");
                Log.d("metrialKind ", metrialKind + " ");
                Log.d("metrialmUnit ", metrialmUnit + " ");

            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<박스사양모델> 박스사양리스트(String result) {
        ArrayList<박스사양모델> list = new ArrayList<>();
        String customID = "";
        String prodID = "";
        String prodName = "";
        String boxType = "";
        String prodserialNo = "";
        String prodTypeID = "";
        String pJang = "";
        String pPock = "";
        String pGo = "";
        String cL = "";
        String cW = "";
        String spc1 = "";
        String spc2 = "";
        String aL = "";
        String aW = "";
        String pCnt = "";
        String prodUnit = "";
        String UnitupDateTime = "";
        String bVAT = "";
        String bSET = "";
        String bPublic = "";
        String deliverMemo = "";
        String vendorID = "";
        String chkJG = "";
        String chkWork = "";
        String givWD = "";
        String givSC = "";
        String prodMemo = "";
        String paperName = "";
        String UpUserID = "";
        String UpUserName = "";
        String UpDatetime = "";
        String MCODE1 = "";
        String MCODE2 = "";
        String metrialID = "";
        String metrialName = "";
        String metrialGor = "";
        String metrialKind = "";
        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("customID")) {
                    customID = jsonObject.getString("customID");
                }
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");
                }
                if (!jsonObject.isNull("prodName")) {
                    prodName = jsonObject.getString("prodName");
                }
                if (!jsonObject.isNull("boxType")) {
                    boxType = jsonObject.getString("boxType");
                }
                if (!jsonObject.isNull("prodserialNo")) {
                    prodserialNo = jsonObject.getString("prodserialNo");
                }
                if (!jsonObject.isNull("prodTypeID")) {
                    prodTypeID = jsonObject.getString("prodTypeID");
                }
                if (!jsonObject.isNull("pJang")) {
                    pJang = jsonObject.getString("pJang");
                }
                if (!jsonObject.isNull("pPock")) {
                    pPock = jsonObject.getString("pPock");
                }
                if (!jsonObject.isNull("pGo")) {
                    pGo = jsonObject.getString("pGo");
                }
                if (!jsonObject.isNull("cL")) {
                    cL = jsonObject.getString("cL");
                }
                if (!jsonObject.isNull("cW ")) {
                    cW = jsonObject.getString("cW ");
                }

                if (!jsonObject.isNull("spc1")) {
                    spc1 = jsonObject.getString("spc1");
                }
                if (!jsonObject.isNull("spc2")) {
                    spc2 = jsonObject.getString("spc2");
                }
                if (!jsonObject.isNull("aL")) {
                    aL = jsonObject.getString("aL");
                }
                if (!jsonObject.isNull("aW")) {
                    aW = jsonObject.getString("aW");
                }
                if (!jsonObject.isNull("pCnt")) {
                    pCnt = jsonObject.getString("pCnt");
                }
                if (!jsonObject.isNull("prodUnit")) {
                    prodUnit = jsonObject.getString("prodUnit");
                }
                if (!jsonObject.isNull("UnitupDateTime")) {
                    UnitupDateTime = jsonObject.getString("UnitupDateTime");
                }
                if (!jsonObject.isNull("bVAT")) {
                    bVAT = jsonObject.getString("bVAT");
                }
                if (!jsonObject.isNull("bSET")) {
                    bSET = jsonObject.getString("bSET");
                }
                if (!jsonObject.isNull("bPublic")) {
                    bPublic = jsonObject.getString("bPublic");
                }
                if (!jsonObject.isNull("deliverMemo")) {
                    deliverMemo = jsonObject.getString("deliverMemo");
                }
                if (!jsonObject.isNull("vendorID")) {
                    vendorID = jsonObject.getString("vendorID");
                }
                if (!jsonObject.isNull("chkJG")) {
                    chkJG = jsonObject.getString("chkJG");
                }
                if (!jsonObject.isNull("chkWork")) {
                    chkWork = jsonObject.getString("chkWork");
                }
                if (!jsonObject.isNull("givWD")) {
                    givWD = jsonObject.getString("givWD");
                }
                if (!jsonObject.isNull("givSC")) {
                    givSC = jsonObject.getString("givSC");
                }
                if (!jsonObject.isNull("prodMemo")) {
                    prodMemo = jsonObject.getString("prodMemo");
                }
                if (!jsonObject.isNull("paperName")) {
                    paperName = jsonObject.getString("paperName");
                }
                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");
                }
                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");
                }
                if (!jsonObject.isNull("UpDatetime ")) {
                    UpDatetime = jsonObject.getString("UpDatetime ");
                }
                if (!jsonObject.isNull("MCODE1")) {
                    MCODE1 = jsonObject.getString("MCODE1");
                }
                if (!jsonObject.isNull("MCODE2")) {
                    MCODE2 = jsonObject.getString("MCODE2");
                }
                if (!jsonObject.isNull("metrialID")) {
                    metrialID = jsonObject.getString("metrialID");
                }
                if (!jsonObject.isNull("metrialName")) {
                    metrialName = jsonObject.getString("metrialName");
                }
                if (!jsonObject.isNull("metrialGor")) {
                    metrialGor = jsonObject.getString("metrialGor");
                }
                if (!jsonObject.isNull("metrialKind")) {
                    metrialKind = jsonObject.getString("metrialKind");
                }
                list.add(new 박스사양모델(customID, prodID, prodName, boxType, prodserialNo, prodTypeID, pJang, pPock, pGo, cL, cW, spc1, spc2, aL, aW, pCnt, prodUnit, UnitupDateTime, bVAT, bSET, bPublic, deliverMemo, vendorID, chkJG
                        , chkWork, givWD, givSC, prodMemo, paperName, UpUserID, UpUserName, UpDatetime, MCODE1, MCODE2, metrialID, metrialName, metrialGor, metrialKind));
                Log.d("customID ", customID + " ");
                Log.d("prodID ", prodID + " ");
                Log.d("prodName ", prodName + " ");
                Log.d("boxType ", boxType + " ");
                Log.d("prodserialNo ", prodserialNo + " ");
                Log.d("prodTypeID ", prodTypeID + " ");
                Log.d("pJang ", pJang + " ");
                Log.d("pPock ", pPock + " ");
                Log.d("pGo ", pGo + " ");
                Log.d("cL ", cL + " ");
                Log.d("cW ", cW + " ");
                Log.d("spc1 ", spc1 + " ");
                Log.d("spc2 ", spc2 + " ");
                Log.d("aL ", aL + " ");
                Log.d("aW ", aW + " ");
                Log.d("pCnt ", pCnt + " ");
                Log.d("prodUnit ", prodUnit + " ");
                Log.d("UnitUpDatetime ", UnitupDateTime + " ");
                Log.d("bVAT ", bVAT + " ");
                Log.d("bSET ", bSET + " ");
                Log.d("bPublic ", bPublic + " ");
                Log.d("deliverMemo ", deliverMemo + " ");
                Log.d("vendorID ", vendorID + " ");
                Log.d("chkJG ", chkJG + " ");
                Log.d("chkWork ", chkWork + " ");
                Log.d("givWD ", givWD + " ");
                Log.d("givSC ", givSC + " ");
                Log.d("prodMemo ", prodMemo + " ");
                Log.d("paperName ", paperName + " ");
                Log.d("UpUserID ", UpUserID + " ");
                Log.d("UpUserName ", UpUserName + " ");
                Log.d("UpDatetime ", UpDatetime + " ");
                Log.d("MCODE1 ", MCODE1 + " ");
                Log.d("MCODE2 ", MCODE2 + " ");
                Log.d("metrialID ", metrialID + " ");
                Log.d("metrialName ", metrialName + " ");
                Log.d("metrialGor  ", metrialGor + " ");
                Log.d("metrialKind  ", metrialKind + " ");


            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    public ArrayList<로그인모델> getloginData(String result) {
        ArrayList<로그인모델> list = new ArrayList<>();
        String CORP_ID = "";
        String CORP_NAME = "";
        String CarNumber = "";
        String ftpid = "";
        String ftppass = "";
        String WEBIMAGE_PATH = "";

        try {

            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                if (!jsonObject.isNull("CORP_ID")) {
                    CORP_ID = jsonObject.getString("CORP_ID");
                }

                if (!jsonObject.isNull("CORP_NAME")) {
                    CORP_NAME = jsonObject.getString("CORP_NAME");
                }

                if (!jsonObject.isNull("CarNumber")) {
                    CarNumber = jsonObject.getString("CarNumber");
                }

                if (!jsonObject.isNull("FTP_ID")) {
                    ftpid = jsonObject.getString("FTP_ID");
                }

                if (!jsonObject.isNull("FTP_PW")) {
                    ftppass = jsonObject.getString("FTP_PW");
                }

                if (!jsonObject.isNull("WEBIMAGE_PATH")) {
                    WEBIMAGE_PATH = jsonObject.getString("WEBIMAGE_PATH");
                }

                Log.d("CORP_ID", CORP_ID + " ");
                Log.d("CORP_NAME", CORP_NAME + " ");
                Log.d("CarNumber", CarNumber + " ");
                list.add(new 로그인모델(CORP_ID, CORP_NAME, CarNumber, ftpid, ftppass, WEBIMAGE_PATH));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<업체정보모델> getAccountCodelist(String result) {
        ArrayList<업체정보모델> list = new ArrayList<>();

        String 거래처키 = "";
        String 대표 = "";
        String 주소 = "";
        String 비고 = "";
        String 상호 = "";
        String 축소상호 = "";
        String 부서폰번호 = "";
        String 담당자명 = "";
        String 담당자Count = "";
        String 선입금 = "";
        String 전화번호 = "";
        String 이메일 = "";
        String corpFax = "";
        String UpUserID = "";
        String UpUserName = "";
        String UpDatetime = "";
        String outBox = "";
        String outKT = "";
        String inWD = "";
        String inSC = "";
        String inYJ = "";
        String inKT = "";
        String notCompany = "";
        String UpUserID1 = "";
        String UpUserName1 = "";
        String UpDatetime1 = "";
        String EnableCheck = "";

        try {
            JSONArray jsonArray = new JSONArray(result);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("거래처키")) {
                    거래처키 = jsonObject.getString("거래처키");
                }
                if (!jsonObject.isNull("대표")) {
                    대표 = jsonObject.getString("대표");
                }
                if (!jsonObject.isNull("주소")) {
                    주소 = jsonObject.getString("주소");
                }
                if (!jsonObject.isNull("비고")) {
                    비고 = jsonObject.getString("비고");
                }
                if (!jsonObject.isNull("상호")) {
                    상호 = jsonObject.getString("상호");
                }
                if (!jsonObject.isNull("축소상호")) {
                    축소상호 = jsonObject.getString("축소상호");
                }

                if (!jsonObject.isNull("부서폰번호")) {
                    부서폰번호 = jsonObject.getString("부서폰번호");
                }

                if (!jsonObject.isNull("담당자명")) {
                    담당자명 = jsonObject.getString("담당자명");
                }

                if (!jsonObject.isNull("담당자Count")) {
                    담당자Count = jsonObject.getString("담당자Count");
                }

                if (!jsonObject.isNull("선입금")) {
                    선입금 = jsonObject.getString("선입금");
                }

                if (!jsonObject.isNull("전화번호")) {
                    전화번호 = jsonObject.getString("전화번호");
                }

                if (!jsonObject.isNull("이메일")) {
                    이메일 = jsonObject.getString("이메일");
                }

                if (!jsonObject.isNull("corpFax")) {
                    corpFax = jsonObject.getString("corpFax");
                }

                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");
                }

                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");
                }

                if (!jsonObject.isNull("UpDatetime")) {
                    UpDatetime = jsonObject.getString("UpDatetime");
                }

                if (!jsonObject.isNull("outBox")) {
                    outBox = jsonObject.getString("outBox");
                }

                if (!jsonObject.isNull("outKT")) {
                    outKT = jsonObject.getString("outKT");
                }

                if (!jsonObject.isNull("inWD")) {
                    inWD = jsonObject.getString("inWD");
                }

                if (!jsonObject.isNull("inSC")) {
                    inSC = jsonObject.getString("inSC");
                }

                if (!jsonObject.isNull("inYJ")) {
                    inYJ = jsonObject.getString("inYJ");
                }

                if (!jsonObject.isNull("inKT")) {
                    inKT = jsonObject.getString("inKT");
                }

                if (!jsonObject.isNull("notCompany")) {
                    notCompany = jsonObject.getString("notCompany");
                }

                if (!jsonObject.isNull("UpUserID1")) {
                    UpUserID1 = jsonObject.getString("UpUserID1");
                }

                if (!jsonObject.isNull("UpUserName1")) {
                    UpUserName1 = jsonObject.getString("UpUserName1");
                }

                if (!jsonObject.isNull("UpDatetime1")) {
                    UpDatetime1 = jsonObject.getString("UpDatetime1");
                }

                if (!jsonObject.isNull("EnableCheck")) {
                    EnableCheck = jsonObject.getString("EnableCheck");
                }

//                Log.d("========"+i,"번쩨========");
//                Log.d("거래처키", 거래처키 + " ");
//                Log.d("대표", 대표 + " ");
//                Log.d("주소", 주소 + " ");
//                Log.d("비고", 비고 + " ");
//                Log.d("상호", 상호 + " ");
//                Log.d("축소상호", 축소상호 + " ");
//                Log.d("부서폰번호", 부서폰번호 + " ");
//                Log.d("담당자명", 담당자명 + " ");
//                Log.d("담당자Count", 담당자Count + " ");
//                Log.d("선입금", 선입금 + " ");
//                Log.d("전화번호", 전화번호 + " ");
//                Log.d("이메일", 이메일 + " ");
//                Log.d("corpFax", corpFax + " ");
//                Log.d("UpUserID", UpUserID + " ");
//                Log.d("UpUserName", UpUserName + " ");
//                Log.d("UpDatetime", UpDatetime + " ");
//                Log.d("outBox", outBox + " ");
//                Log.d("outKT", outKT + " ");
//                Log.d("inWD", inWD + " ");
//                Log.d("inSC", inSC + " ");
//                Log.d("inYJ", inYJ + " ");
//                Log.d("inKT", inKT + " ");
//                Log.d("notCompany", notCompany + " ");
//                Log.d("UpUserID1", UpUserID1 + " ");
//                Log.d("UpUserName1", UpUserName1 + " ");
//                Log.d("UpDatetime1", UpDatetime1 + " ");
//                Log.d("EnableCheck", EnableCheck + " ");

                list.add(new 업체정보모델(거래처키, 대표, 주소, 비고, 상호, 축소상호, 부서폰번호, 담당자명, 담당자Count,
                        선입금, 전화번호, 이메일, corpFax,
                        UpUserID, UpUserName, UpDatetime, outBox, outKT, inWD, inSC, inYJ, inKT, notCompany, UpUserID1, UpUserName1, UpDatetime1, EnableCheck));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }

    public ArrayList<미수현황모델> 미수잔액모델리스트(String receiveMsg) {

        ArrayList<미수현황모델> list = new ArrayList<>();
        String IOType = "";
        String customID = "";
        String corpTel = "";
        String customSName = "";
        String LeftMoney = "";
        String ThisMonthIO = "";
        String ThisMonthRecp = "";
        String BeforeOneMonthIO = "";
        String BeforeOneMonthRecp = "";
        String PaymentDay = "";
        String PaymentTerm = "";
        String NoReceiveMonth = "";
        String NoReceiveMoney1 = "";
        String NoReceiveMoney2 = "";
        String NoReceiveMoney = "";
        String newCustomer = "";
        String Before1MonthLeftMoney = "";
        String Before2MonthLeftMoney = "";

        try {

            JSONArray jsonArray = new JSONArray(receiveMsg);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {

                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("IOType")) {
                    IOType = jsonObject.getString("IOType");

                }
                if (!jsonObject.isNull("customID")) {
                    customID = jsonObject.getString("customID");

                }
                if (!jsonObject.isNull("corpTel")) {
                    corpTel = jsonObject.getString("corpTel");

                }
                if (!jsonObject.isNull("customSName")) {
                    customSName = jsonObject.getString("customSName");

                }
                if (!jsonObject.isNull("LeftMoney")) {
                    LeftMoney = jsonObject.getString("LeftMoney");

                }
                if (!jsonObject.isNull("ThisMonthIO")) {
                    ThisMonthIO = jsonObject.getString("ThisMonthIO");

                }
                if (!jsonObject.isNull("ThisMonthRecp")) {
                    ThisMonthRecp = jsonObject.getString("ThisMonthRecp");

                }
                if (!jsonObject.isNull("BeforeOneMonthIO")) {
                    BeforeOneMonthIO = jsonObject.getString("BeforeOneMonthIO");

                }
                if (!jsonObject.isNull("BeforeOneMonthRecp")) {
                    BeforeOneMonthRecp = jsonObject.getString("BeforeOneMonthRecp");

                }
                if (!jsonObject.isNull("PaymentDay")) {
                    PaymentDay = jsonObject.getString("PaymentDay");

                }
                if (!jsonObject.isNull("PaymentTerm")) {
                    PaymentTerm = jsonObject.getString("PaymentTerm");

                }
                if (!jsonObject.isNull("NoReceiveMonth")) {
                    NoReceiveMonth = jsonObject.getString("NoReceiveMonth");

                }
                if (!jsonObject.isNull("NoReceiveMoney1")) {
                    NoReceiveMoney1 = jsonObject.getString("NoReceiveMoney1");

                }
                if (!jsonObject.isNull("NoReceiveMoney2")) {
                    NoReceiveMoney2 = jsonObject.getString("NoReceiveMoney2");

                }
                if (!jsonObject.isNull("NoReceiveMoney")) {
                    NoReceiveMoney = jsonObject.getString("NoReceiveMoney");

                }
                if (!jsonObject.isNull("newCustomer")) {
                    newCustomer = jsonObject.getString("newCustomer");

                }
                if (!jsonObject.isNull("Before1MonthLeftMoney")) {
                    Before1MonthLeftMoney = jsonObject.getString("Before1MonthLeftMoney");

                }
                if (!jsonObject.isNull("Before2MonthLeftMoney")) {
                    Before2MonthLeftMoney = jsonObject.getString("Before2MonthLeftMoney");

                }
                Log.d("========" + i, "번쩨========");
//                Log.d("IOType", IOType + " ");
//                Log.d("customID", customID + " ");
//                Log.d("corpTel", corpTel + " ");
                Log.d("customSName", customSName + " ");
//                Log.d("LeftMoney", LeftMoney + " ");
//                Log.d("ThisMonthIO", ThisMonthIO + " ");
//                Log.d("ThisMonthRecp", ThisMonthRecp + " ");
//                Log.d("BeforeOneMonthIO", BeforeOneMonthIO + " ");
//                Log.d("BeforeOneMonthRecp", BeforeOneMonthRecp + " ");
//                Log.d("IOType", PaymentDay + " ");
//                Log.d("PaymentTerm", PaymentTerm + " ");
//                Log.d("NoReceiveMonth", NoReceiveMonth + " ");
//                Log.d("NoReceiveMoney1", NoReceiveMoney1 + " ");
//                Log.d("NoReceiveMoney2", NoReceiveMoney2 + " ");
//                Log.d("NoReceiveMoney", NoReceiveMoney + " ");
//                Log.d("newCustomer", newCustomer + " ");
//                Log.d("Before1MonthLeftMoney", Before1MonthLeftMoney + " ");
//                Log.d("Before2MonthLeftMoney", Before2MonthLeftMoney + " ");
                list.add(new 미수현황모델(IOType, customID, corpTel, customSName, LeftMoney, ThisMonthIO, ThisMonthRecp, BeforeOneMonthIO, NoReceiveMonth, NoReceiveMoney1, NoReceiveMoney2, NoReceiveMoney, newCustomer, Before1MonthLeftMoney, Before2MonthLeftMoney));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }

    public ArrayList<미수현황상세모델> 미수현황상세리스트(String receiveMsg) {
        ArrayList<미수현황상세모델> list = new ArrayList<>();
        String IOType = "";
        String MonthNo = "";
        String IOMoney = "";
        String RecpMoney = "";
        String DiscountMoney = "";
        try {
            JSONArray jsonArray = new JSONArray(receiveMsg);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                if (!jsonObject.isNull("IOType")) {
                    IOType = jsonObject.getString("IOType");

                }
                if (!jsonObject.isNull("MonthNo")) {
                    MonthNo = jsonObject.getString("MonthNo");

                }
                if (!jsonObject.isNull("IOMoney")) {
                    IOMoney = jsonObject.getString("IOMoney");

                }
                if (!jsonObject.isNull("RecpMoney")) {
                    RecpMoney = jsonObject.getString("RecpMoney");

                }
                if (!jsonObject.isNull("DiscountMoney")) {
                    DiscountMoney = jsonObject.getString("DiscountMoney");

                }
                Log.d("========" + i, "번쩨========");
                Log.d("IOType", IOType + " ");
                Log.d("MonthNo", MonthNo + " ");
                Log.d("IOMoney", IOMoney + " ");
                Log.d("RecpMoney", RecpMoney + " ");
                Log.d("DiscountMoney", DiscountMoney + " ");
                list.add(new 미수현황상세모델(IOType, MonthNo, IOMoney, RecpMoney, DiscountMoney));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;

    }

    public ArrayList<제품정보모델> 제품정보모델리스트(String msg) {
        ArrayList<제품정보모델> list = new ArrayList<>();

        String atype = "";
        String setcnt = "";
        String customID = "";
        String customSName = "";
        String prodID = "";
        String prodName = "";
        String pJang = "";
        String pPock = "";
        String pGo = "";
        String pSize = "";
        String prodUnit = "";
        String deliverMemo = "";
        String UpUserID = "";
        String UpUserName = "";
        String UpDatetime = "";
        String bPublic = "";
        String chkWork = "";
        String paperName = "";
        String givWD = "";
        String givSC = "";
        String wjName = "";
        String SCState = "";
        String prodTypeID = "";
        String boxType = "";
        String bVAT = "";
        String bSET = "";
        String aL = "";
        String aW = "";
        String pCnt = "";
        String cL = "";
        String cW = "";
        String metrialID = "";
        String WDName = "";
        String WDmL = "";
        String WDmW = "";
        String WDpCnt = "";
        String metrialGor = "";
        String WDJang = "";
        String WDPock = "";
        String SCName = "";
        String SCmL = "";
        String SCmW = "";
        String SCpCnt = "";

        try {
            JSONArray jsonArray = new JSONArray(msg);
            JSONObject jsonObject;

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);

                if (!jsonObject.isNull("atype")) {
                    atype = jsonObject.getString("atype");
                }
                if (!jsonObject.isNull("setcnt")) {
                    setcnt = jsonObject.getString("setcnt");

                }
                if (!jsonObject.isNull("customID")) {
                    customID = jsonObject.getString("customID");

                }
                if (!jsonObject.isNull("customSName")) {
                    customSName = jsonObject.getString("customSName");

                }
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");

                }
                if (!jsonObject.isNull("prodName")) {
                    prodName = jsonObject.getString("prodName");

                }
                if (!jsonObject.isNull("pJang")) {
                    pJang = jsonObject.getString("pJang");

                }
                if (!jsonObject.isNull("pPock")) {
                    pPock = jsonObject.getString("pPock");

                }
                if (!jsonObject.isNull("pGo")) {
                    pGo = jsonObject.getString("pGo");

                }
                if (!jsonObject.isNull("pSize")) {
                    pSize = jsonObject.getString("pSize");

                }
                if (!jsonObject.isNull("prodUnit")) {
                    prodUnit = jsonObject.getString("prodUnit");
                }
                if (!jsonObject.isNull("deliverMemo")) {
                    deliverMemo = jsonObject.getString("deliverMemo");

                }
                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");

                }
                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");

                }
                if (!jsonObject.isNull("UpDatetime")) {
                    UpDatetime = jsonObject.getString("UpDatetime");

                }
                if (!jsonObject.isNull("bPublic")) {
                    bPublic = jsonObject.getString("bPublic");

                }
                if (!jsonObject.isNull("chkWork")) {
                    chkWork = jsonObject.getString("chkWork");

                }
                if (!jsonObject.isNull("paperName")) {
                    paperName = jsonObject.getString("paperName");

                }
                if (!jsonObject.isNull("givWD")) {
                    givWD = jsonObject.getString("givWD");

                }
                if (!jsonObject.isNull("givSC")) {
                    givSC = jsonObject.getString("givSC");

                }
                if (!jsonObject.isNull("wjName")) {
                    wjName = jsonObject.getString("wjName");
                }
                if (!jsonObject.isNull("SCState")) {
                    SCState = jsonObject.getString("SCState");

                }
                if (!jsonObject.isNull("prodTypeID")) {
                    prodTypeID = jsonObject.getString("prodTypeID");

                }
                if (!jsonObject.isNull("boxType")) {
                    boxType = jsonObject.getString("boxType");

                }
                if (!jsonObject.isNull("bVAT")) {
                    bVAT = jsonObject.getString("bVAT");

                }
                if (!jsonObject.isNull("bSET")) {
                    bSET = jsonObject.getString("bSET");

                }
                if (!jsonObject.isNull("aL")) {
                    aL = jsonObject.getString("aL");

                }
                if (!jsonObject.isNull("aW")) {
                    aW = jsonObject.getString("aW");

                }
                if (!jsonObject.isNull("pCnt")) {
                    pCnt = jsonObject.getString("pCnt");

                }
                if (!jsonObject.isNull("cL")) {
                    cL = jsonObject.getString("cL");

                }
                if (!jsonObject.isNull("cW")) {
                    cW = jsonObject.getString("cW");
                }
                if (!jsonObject.isNull("metrialID")) {
                    metrialID = jsonObject.getString("metrialID");

                }
                if (!jsonObject.isNull("WDName")) {
                    WDName = jsonObject.getString("WDName");

                }
                if (!jsonObject.isNull("WDmL")) {
                    WDmL = jsonObject.getString("WDmL");

                }
                if (!jsonObject.isNull("WDmW")) {
                    WDmW = jsonObject.getString("WDmW");

                }
                if (!jsonObject.isNull("WDpCnt")) {
                    WDpCnt = jsonObject.getString("WDpCnt");

                }
                if (!jsonObject.isNull("metrialGor")) {
                    metrialGor = jsonObject.getString("metrialGor");

                }
                if (!jsonObject.isNull("WDJang")) {
                    WDJang = jsonObject.getString("WDJang");

                }
                if (!jsonObject.isNull("WDPock")) {
                    WDPock = jsonObject.getString("WDPock");

                }
                if (!jsonObject.isNull("SCName")) {
                    SCName = jsonObject.getString("SCName");

                }
                if (!jsonObject.isNull("SCmL")) {
                    SCmL = jsonObject.getString("SCmL");

                }
                if (!jsonObject.isNull("SCmW")) {
                    SCmW = jsonObject.getString("SCmW");

                }
                if (!jsonObject.isNull("SCpCnt")) {
                    SCpCnt = jsonObject.getString("SCpCnt");

                }


                if (bPublic.equalsIgnoreCase("false")) {
                    list.add(new 제품정보모델(atype, setcnt, customID, customSName, prodID, prodName, pJang, pPock, pGo, pSize, prodUnit, deliverMemo, UpUserID, UpUserName, UpDatetime, bPublic, chkWork, paperName, givWD,
                            givSC, wjName, SCState, prodTypeID, boxType, bVAT, bSET, aL, aW, pCnt, cL, cW, metrialID, WDName, WDmL, WDmW, WDpCnt, metrialGor, WDJang, WDPock, SCName, SCmL, SCmW, SCpCnt));

                    Log.d("========" + i, "번쩨========");
                    Log.d("atype", atype + " ");
                    Log.d("setcnt", setcnt + " ");
                    Log.d("customID", customID + " ");
                    Log.d("customSName", customSName + " ");
                    Log.d("prodID", prodID + " ");
                    Log.d("prodName", prodName + " ");
                    Log.d("pJang", pJang + " ");
                    Log.d("pPock", pPock + " ");
                    Log.d("pGo", pGo + " ");
                    Log.d("pSize", pSize + " ");
                    Log.d("prodUnit", prodUnit + " ");
                    Log.d("deliverMemo", deliverMemo + " ");
                    Log.d("UpUserID", UpUserID + " ");
                    Log.d("UpUserName", UpUserName + " ");
                    Log.d("UpDatetime", UpDatetime + " ");
                    Log.d("bPublic", bPublic + " ");
                    Log.d("chkWork", chkWork + " ");
                    Log.d("paperName", paperName + " ");
                    Log.d("givWD", givWD + " ");
                    Log.d("givSC", givSC + " ");
                    Log.d("wjName", wjName + " ");
                    Log.d("SCState", SCState + " ");
                    Log.d("prodTypeID", prodTypeID + " ");
                    Log.d("boxType", boxType + " ");
                    Log.d("bVAT", bVAT + " ");
                    Log.d("bSET", bSET + " ");
                    Log.d("aL", aL + " ");
                    Log.d("aW", aW + " ");
                    Log.d("pCnt", pCnt + " ");
                    Log.d("cL", cL + " ");
                    Log.d("cW", cW + " ");
                    Log.d("metrialID", metrialID + " ");
                    Log.d("WDName", WDName + " ");
                    Log.d("WDmL", WDmL + " ");
                    Log.d("WDmW", WDmW + " ");
                    Log.d("WDpCnt", WDpCnt + " ");
                    Log.d("metrialGor", metrialGor + " ");
                    Log.d("WDJang", WDJang + " ");
                    Log.d("WDPock", WDPock + " ");
                    Log.d("SCName", SCName + " ");
                    Log.d("SCmL", SCmL + " ");
                    Log.d("SCmW", SCmW + " ");
                    Log.d("SCpCnt", SCpCnt + " ");
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;

    }


    public ArrayList<공정모델> 생산공전리스트(String resultMessage) {
        ArrayList<공정모델> list = new ArrayList<>();
        String prodID = "";
        String ProcessType = "";
        String ProcessTypeName = "";
        String ProcessSeq = "";
        String TypeCheck = "";
        String OutType = "";
        try {
            JSONArray jsonArray = new JSONArray(resultMessage);
            JSONObject jsonObject;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");

                }
                if (!jsonObject.isNull("ProcessType")) {
                    ProcessType = jsonObject.getString("ProcessType");

                }
                if (!jsonObject.isNull("ProcessTypeName")) {
                    ProcessTypeName = jsonObject.getString("ProcessTypeName");

                }
                if (!jsonObject.isNull("ProcessSeq")) {
                    ProcessSeq = jsonObject.getString("ProcessSeq");

                }
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");

                }
                if (!jsonObject.isNull("TypeCheck")) {
                    TypeCheck = jsonObject.getString("TypeCheck");

                }
                if (!jsonObject.isNull("OutType")) {
                    OutType = jsonObject.getString("OutType");

                }
                list.add(new 공정모델(prodID, ProcessType, ProcessTypeName, ProcessSeq, TypeCheck, OutType));

                Log.d("========" + i, "번쩨========");
                Log.d("prodID", prodID + " ");
                Log.d("ProcessType", ProcessType + " ");
                Log.d("ProcessTypeName", ProcessTypeName + " ");
                Log.d("ProcessSeq", ProcessSeq + " ");
                Log.d("prodID", prodID + " ");
                Log.d("TypeCheck", TypeCheck + " ");
                Log.d("OutType", OutType + " ");


            }
        } catch (JSONException e) {
            e.getCause();
        }
        return list;
    }

    public ArrayList<인쇄사양모델> 인쇄사양모델리스트(String resultMessage) {
        ArrayList<인쇄사양모델> list = new ArrayList<>();
        String prodID = "";
        String photoID = "";
        String photoDate = "";
        String photofilePath = "";
        String photoName = "";
        String photoChk = "";
        String ctpfilePath = "";
        String photoMemo = "";
        String UpUserID = "";
        String UpUserName = "";
        String UpDatetime = "";
        String customID = "";
        try {
            JSONArray jsonArray = new JSONArray(resultMessage);
            JSONObject jsonObject;
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");

                }
                if (!jsonObject.isNull("photoID")) {
                    photoID = jsonObject.getString("photoID");

                }
                if (!jsonObject.isNull("photoDate")) {
                    photoDate = jsonObject.getString("photoDate");

                }
                if (!jsonObject.isNull("photofilePath")) {
                    photofilePath = jsonObject.getString("photofilePath");

                }
                if (!jsonObject.isNull("photoName")) {
                    photoName = jsonObject.getString("photoName");

                }
                if (!jsonObject.isNull("photoChk")) {
                    photoChk = jsonObject.getString("photoChk");

                }
                if (!jsonObject.isNull("ctpfilePath")) {
                    ctpfilePath = jsonObject.getString("ctpfilePath");

                }
                if (!jsonObject.isNull("photoMemo")) {
                    photoMemo = jsonObject.getString("photoMemo");

                }
                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");

                }
                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");

                }
                if (!jsonObject.isNull("UpDatetime")) {
                    UpDatetime = jsonObject.getString("UpDatetime");

                }
                if (!jsonObject.isNull("customID")) {
                    customID = jsonObject.getString("customID");

                }
                list.add(new 인쇄사양모델(prodID,photoID,photoDate,photofilePath,photoName,photoChk, ctpfilePath,photoMemo,UpUserID,UpUserName,UpDatetime,customID));

                Log.d("========" + i, "번쩨========");
                Log.d("prodID", prodID + " ");
                Log.d("photoID", photoID + " ");
                Log.d("photoDate", photoDate + " ");
                Log.d("photofilePath", photofilePath + " ");
                Log.d("photoName", photoName + " ");
                Log.d("photoChk", photoChk + " ");
                Log.d("ctpfilePath", ctpfilePath + " ");
                Log.d("photoMemo", photoMemo + " ");
                Log.d("UpUserID", UpUserID + " ");
                Log.d("UpUserName", UpUserName + " ");
                Log.d("UpDatetime", UpDatetime + " ");
                Log.d("customID", customID + " ");
            }
        } catch (JSONException e) {
            e.getCause();
        }
        return list;
    }

    public ArrayList<작업사양모델> 작업사양리스트(String resultMessage) {
        ArrayList<작업사양모델> list = new ArrayList<>();
         String prodID="";
         String PrintNo="" ;
         String Printposition="" ;
         String ColorType="" ;
         String PastingID="" ;
         String CoatingType="" ;
         String CoatingID="" ;
         String PushingNo="" ;
         String Pushingposition="" ;
         String ConnetingType="" ;
         String ConnetingID="" ;
         String PackCount="" ;
         String PackType="" ;
         String PackID="" ;
         String levelCount="" ;
         String loadposition="" ;
         String barcode="" ;
         String filmNo="" ;
         String handChk ="";
         String JobMemo ="";
         String UpUserID ="";
         String UpUserName ="";
         String UpDatetime ="";
        try {
            JSONArray jsonArray = new JSONArray(resultMessage);
            JSONObject jsonObject;



            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                if (!jsonObject.isNull("prodID")) {
                    prodID = jsonObject.getString("prodID");
                }
                if (!jsonObject.isNull("PrintNo")) {
                    PrintNo = jsonObject.getString("PrintNo");
                }
                if (!jsonObject.isNull("Printposition")) {
                    Printposition = jsonObject.getString("Printposition");
                }
                if (!jsonObject.isNull("ColorType")) {
                    ColorType = jsonObject.getString("ColorType");
                }
                if (!jsonObject.isNull("PastingID")) {
                    PastingID = jsonObject.getString("PastingID");
                }
                if (!jsonObject.isNull("CoatingType")) {
                    CoatingType = jsonObject.getString("CoatingType");
                }
                if (!jsonObject.isNull("CoatingID")) {
                    CoatingID = jsonObject.getString("CoatingID");
                }
                if (!jsonObject.isNull("PushingNo")) {
                    PushingNo = jsonObject.getString("PushingNo");
                }
                if (!jsonObject.isNull("Pushingposition")) {
                    Pushingposition = jsonObject.getString("Pushingposition");
                }
                if (!jsonObject.isNull("ConnetingType")) {
                    ConnetingType = jsonObject.getString("ConnetingType");
                }
                if (!jsonObject.isNull("ConnetingID")) {
                    ConnetingID = jsonObject.getString("ConnetingID");
                }
                if (!jsonObject.isNull("PackCount")) {
                    PackCount = jsonObject.getString("PackCount");
                }
                if (!jsonObject.isNull("PackType")) {
                    PackType = jsonObject.getString("PackType");
                }
                if (!jsonObject.isNull("PackID")) {
                    PackID = jsonObject.getString("PackID");
                }
                if (!jsonObject.isNull("levelCount")) {
                    levelCount = jsonObject.getString("levelCount");
                }
                if (!jsonObject.isNull("loadposition")) {
                    loadposition = jsonObject.getString("loadposition");
                }
                if (!jsonObject.isNull("barcode")) {
                    barcode = jsonObject.getString("barcode");
                }
                if (!jsonObject.isNull("filmNo")) {
                    filmNo = jsonObject.getString("filmNo");
                }
                if (!jsonObject.isNull("handChk")) {
                    handChk = jsonObject.getString("handChk");
                }
                if (!jsonObject.isNull("JobMemo")) {
                    JobMemo = jsonObject.getString("JobMemo");
                }
                if (!jsonObject.isNull("UpUserID")) {
                    UpUserID = jsonObject.getString("UpUserID");
                }
                if (!jsonObject.isNull("UpUserName")) {
                    UpUserName = jsonObject.getString("UpUserName");
                }
                if (!jsonObject.isNull("UpDatetime")) {
                    UpDatetime = jsonObject.getString("UpDatetime");
                }
                list.add(new 작업사양모델(prodID,PrintNo,Printposition,ColorType,PastingID,CoatingType,CoatingID,PushingNo,Pushingposition,ConnetingType,ConnetingID,PackCount,PackType,PackID,levelCount,loadposition,barcode,filmNo
                        ,handChk,JobMemo,UpUserID,UpUserName,UpDatetime
                        ));
                Log.d("========" + i, "번쩨========");
                Log.d("prodID", prodID + " ");
                Log.d("PrintNo", PrintNo + " ");
                Log.d("Printposition", Printposition + " ");
                Log.d("ColorType", ColorType + " ");
                Log.d("PastingID", PastingID + " ");
                Log.d("CoatingType", CoatingType + " ");
                Log.d("CoatingID", CoatingID + " ");
                Log.d("PushingNo", PushingNo + " ");
                Log.d("Pushingposition", Pushingposition + " ");
                Log.d("ConnetingType", ConnetingType + " ");
                Log.d("ConnetingID", ConnetingID + " ");
                Log.d("PackCount", PackCount + " ");
                Log.d("PackType", PackType + " ");
                Log.d("PackID", PackID + " ");
                Log.d("levelCount", levelCount + " ");
                Log.d("loadposition", loadposition + " ");
                Log.d("barcode", barcode + " ");
                Log.d("filmNo", filmNo + " ");
                Log.d("handChk", handChk + " ");
                Log.d("JobMemo", JobMemo + " ");
                Log.d("UpUserID", UpUserID + " ");
                Log.d("UpUserName", UpUserName + " ");
                Log.d("UpDatetime", UpDatetime + " ");




            }
        } catch (JSONException e) {
            e.getCause();
        }
        return list;
    }
}
