package kr.co.packcom.hipackanybox.Model;

public class 미수현황상세모델 {
    public String IOType;
    public String MonthNo;
    public String IOMoney;
    public String RecpMoney;
    public String DiscountMoney;

    public 미수현황상세모델(String IOType, String monthNo, String IOMoney, String recpMoney, String discountMoney) {
        this.IOType = IOType;
        MonthNo = monthNo;
        this.IOMoney = IOMoney;
        RecpMoney = recpMoney;
        DiscountMoney = discountMoney;
    }
}
