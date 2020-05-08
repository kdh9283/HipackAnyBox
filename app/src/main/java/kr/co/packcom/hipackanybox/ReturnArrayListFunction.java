package kr.co.packcom.hipackanybox;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;

import kr.co.packcom.hipackanybox.Model.미수현황모델;
import kr.co.packcom.hipackanybox.Model.미수현황상세모델;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.Model.로그인모델;


public class ReturnArrayListFunction {

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
        String IOType="";
        String MonthNo="";
        String IOMoney="";
        String RecpMoney="";
        String DiscountMoney="";
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
                list.add(new 미수현황상세모델(IOType,MonthNo,IOMoney,RecpMoney,DiscountMoney));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;

    }


}
