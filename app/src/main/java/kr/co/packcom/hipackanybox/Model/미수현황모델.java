package kr.co.packcom.hipackanybox.Model;



public class 미수현황모델 implements Comparable<미수현황모델>{
    public String IOType;
    public String customID;
    public String corpTel;
    public String customSName;
    public String LeftMoney;
    public String ThisMonthIO;
    public String ThisMonthRecp;
    public String BeforeOneMonthIO;
    public String BeforeOneMonthRecp;
    public String PaymentDay;
    public String PaymentTerm;
    public String NoReceiveMonth;
    public String NoReceiveMoney1;
    public String NoReceiveMoney2;
    public String NoReceiveMoney;
    public String newCustomer;
    public String Before1MonthLeftMoney;
    public String Before2MonthLeftMoney;

    public 미수현황모델(String IOType, String customID, String corpTel, String customSName, String leftMoney, String thisMonthIO, String thisMonthRecp, String beforeOneMonthIO, String noReceiveMonth, String noReceiveMoney1, String noReceiveMoney2, String noReceiveMoney, String newCustomer, String before1MonthLeftMoney, String before2MonthLeftMoney) {

        this.IOType = IOType;
        this.customID = customID;
        this.corpTel = corpTel;
        this.customSName = customSName;
        LeftMoney = leftMoney;
        ThisMonthIO = thisMonthIO;
        ThisMonthRecp = thisMonthRecp;
        BeforeOneMonthIO = beforeOneMonthIO;
        NoReceiveMonth = noReceiveMonth;
        NoReceiveMoney1 = noReceiveMoney1;
        NoReceiveMoney2 = noReceiveMoney2;
        NoReceiveMoney = noReceiveMoney;
        this.newCustomer = newCustomer;
        Before1MonthLeftMoney = before1MonthLeftMoney;
        Before2MonthLeftMoney = before2MonthLeftMoney;

    }

    @Override
    public int compareTo(미수현황모델 o) {
        return this.customSName.compareTo(o.customSName);
    }
}
