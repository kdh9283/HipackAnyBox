package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.packcom.hipackanybox.CodeName_List;
import kr.co.packcom.hipackanybox.R;

public class 제품정보 extends AppCompatActivity implements View.OnClickListener {
    private TextView menu3_title;
    private Button menu3_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        init();
    }

    private void init() {
        menu3_title = findViewById(R.id.menu3_title);
        menu3_title.setText("제품정보");
        menu3_select = findViewById(R.id.menu3_select);
        menu3_select.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu3_select:
                startActivityForResult(new Intent(this, CodeName_List.class),1);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                Log.d("돌아옴","oo");
                break;
        }
    }
}