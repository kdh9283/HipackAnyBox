package kr.co.packcom.hipackanybox.Dialog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.packcom.hipackanybox.R;



public class NetworkCheckDialog extends Activity {

    Intent getintent;
    String flag = "";
    String packagename = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.networkcheck_dialog);
        flag = getIntent().getStringExtra("flag");
        packagename = getIntent().getStringExtra("name");
        Button btn_ok = findViewById(R.id.btn_ok);

        TextView textView = findViewById(R.id.dialog_text);

        switch (flag) {

            case "1":
                textView.setText("프로그램이 현재 점검 중입니다. 나중에 다시 시도해 주세요");
                break;
            case "2":
                textView.setText("사용 권한이 없습니다.");
                break;

        }

        btn_ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (flag){
                    case "1":
                    case "2":
                        android.os.Process.killProcess(android.os.Process.myPid());
                        finish();
                        break;
                }
            }
        });
    }
}
