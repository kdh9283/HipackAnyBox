package kr.co.packcom.hipackanybox.Model;

public class 공정모델 {
    public String prodID="";
    public String ProcessType="";
    public String ProcessTypeName ="";
    public String ProcessSeq ="";
    public String TypeCheck ="";
    public String OutType="";

    public 공정모델(String prodID, String processType, String processTypeName, String processSeq, String typeCheck, String outType) {
        this.prodID = prodID;
        ProcessType = processType;
        ProcessTypeName = processTypeName;
        ProcessSeq = processSeq;
        TypeCheck = typeCheck;
        OutType = outType;
    }
}
