package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Model.제품정보모델;
import kr.co.packcom.hipackanybox.R;

public class 제품정보상세 extends AppCompatActivity {
    private TextView menu3_detail_title;
    private ArrayList<제품정보모델> list;
    private int position;
    private TextView menu3_detail_prodName;
    private TextView menu3_detail_prodName_code;
    private TextView menu3_detail_boxType;
    private TextView menu3_detail_paperName;
    private TextView menu3_detail_psize;
    private TextView menu3_detail_aLcW;
    private TextView menu3_detail_pCnt;
    private TextView menu3_detail_prodUnit;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3_detail);

        init();
    }

    private void init() {
        list = (ArrayList<제품정보모델>) getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position", 0);
        menu3_detail_title = findViewById(R.id.menu3_detail_title);
        menu3_detail_title.setText("박스코드 상세정보 - " + list.get(position).prodName);
        menu3_detail_prodName = findViewById(R.id.menu3_detail_prodName);
        menu3_detail_prodName.setText(list.get(position).prodName);
        menu3_detail_prodName_code = findViewById(R.id.menu3_detail_prodName_code);
        menu3_detail_prodName_code.setText(list.get(position).prodID);
        menu3_detail_boxType = findViewById(R.id.menu3_detail_boxType);
        menu3_detail_boxType.setText(list.get(position).boxType);
        menu3_detail_paperName = findViewById(R.id.menu3_detail_paperName);
        menu3_detail_paperName.setText(list.get(position).paperName);
        menu3_detail_psize = findViewById(R.id.menu3_detail_psize);
        menu3_detail_psize.setText(list.get(position).pJang + " * " + list.get(position).pPock + " * " + list.get(position).pGo);
        menu3_detail_aLcW = findViewById(R.id.menu3_detail_aLcW);
        menu3_detail_aLcW.setText(list.get(position).aL + " * " + list.get(position).aW);
        menu3_detail_pCnt = findViewById(R.id.menu3_detail_pCnt);
        menu3_detail_pCnt.setText(list.get(position).pCnt);
        menu3_detail_prodUnit = findViewById(R.id.menu3_detail_prodUnit);
        menu3_detail_prodUnit.setText(decimalFormat.format(Double.parseDouble(list.get(position).prodUnit)));


    }
}
