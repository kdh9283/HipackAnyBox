package kr.co.packcom.hipackanybox.Dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import kr.co.packcom.hipackanybox.R;

public class Dialog_twobutton extends Activity implements View.OnClickListener {
    private Button btn_cancle;
    private Button btn_ok;
    private TextView dialog_text;
    String content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_twobutton);
        content = getIntent().getStringExtra("content");
        init();

    }

    private void init() {

        btn_ok = findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(this);
        btn_cancle = findViewById(R.id.btn_cancle);
        btn_cancle.setOnClickListener(this);
        dialog_text = findViewById(R.id.dialog_text);
        dialog_text.setText(content);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_ok:
                Intent intent = new Intent();
                intent.putExtra("flag", 1);
                setResult(2000, intent);
                finish();
                break;

            case R.id.btn_cancle:

                intent = new Intent();
                intent.putExtra("flag", 0);
                setResult(2000, intent);
                finish();

                break;

        }
    }
}
