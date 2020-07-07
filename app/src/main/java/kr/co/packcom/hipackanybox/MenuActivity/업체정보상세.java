package kr.co.packcom.hipackanybox.MenuActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.kakao.kakaonavi.KakaoNaviParams;
import com.kakao.kakaonavi.KakaoNaviService;
import com.kakao.kakaonavi.NaviOptions;
import com.kakao.kakaonavi.options.CoordType;
import com.kakao.kakaonavi.options.RpOption;
import com.kakao.kakaonavi.options.VehicleType;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.co.packcom.hipackanybox.암호화모듈;
import kr.co.packcom.hipackanybox.Dialog.Dialog_twobutton;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.R;

public class 업체정보상세 extends AppCompatActivity implements View.OnClickListener {
    private Intent get_intent;
    private ArrayList<업체정보모델> list;
    private TextView detail_축소상호;
    private TextView detail_전화번호;
    private TextView detail_menu_상호, detail_menu_대표자, detail_menu_주소, detail_menu_전화번호, detail_menu_팩스번호, detail_menu_휴대폰, detail_menu_담당자, detail_menu_메일주소, detail_menu_메모사항, detail_menu_참고1, detail_menu_참고2;
    private 암호화모듈 암호화모듈;
    private String phonenum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu1_);

        init();
    }

    private void init() {

        암호화모듈 = new 암호화모듈("ICD4662402");
        get_intent = getIntent();

        list = (ArrayList<업체정보모델>) get_intent.getSerializableExtra("list");

        detail_축소상호 = findViewById(R.id.detail_축소상호);
        detail_축소상호.setText(list.get(0).축소상호);
        detail_전화번호 = findViewById(R.id.detail_전화번호);
        detail_전화번호.setText(list.get(0).전화번호);

        //

        String 상호 = list.get(0).상호;
        String 대표자 = list.get(0).대표;
        String 주소 = list.get(0).주소;
        String 전화번호 = list.get(0).전화번호;
        String 팩스번호 = list.get(0).corpFax;
        String 휴대폰 = "";
        String 메일주소 = "";

        try {

            휴대폰 = 암호화모듈.복호화(list.get(0).부서폰번호);
            메일주소 = 암호화모듈.복호화(list.get(0).이메일);

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }

        String 담당자 = list.get(0).담당자명;

        String 비고 = list.get(0).비고;

        detail_menu_상호 = findViewById(R.id.detail_menu_상호);
        detail_menu_상호.setText(상호);
        detail_menu_대표자 = findViewById(R.id.detail_menu_대표자);
        detail_menu_대표자.setText(대표자);
        detail_menu_주소 = findViewById(R.id.detail_menu_주소);
        detail_menu_주소.setOnClickListener(this);
        detail_menu_주소.setText(주소);
        detail_menu_전화번호 = findViewById(R.id.detail_menu_전화번호);
        detail_menu_전화번호.setOnClickListener(this);
        detail_menu_전화번호.setText(전화번호);
        detail_menu_팩스번호 = findViewById(R.id.detail_menu_팩스번호);
        detail_menu_팩스번호.setText(팩스번호);
        detail_menu_휴대폰 = findViewById(R.id.detail_menu_휴대폰);
        detail_menu_휴대폰.setOnClickListener(this);
        detail_menu_휴대폰.setText(휴대폰);
        detail_menu_담당자 = findViewById(R.id.detail_menu_담당자);
        detail_menu_담당자.setText(담당자);
        detail_menu_메일주소 = findViewById(R.id.detail_menu_메일주소);
        detail_menu_메일주소.setText(메일주소);
        detail_menu_메모사항 = findViewById(R.id.detail_menu_메모사항);
        detail_menu_메모사항.setText(비고);
        detail_menu_참고1 = findViewById(R.id.detail_menu_참고1);
        detail_menu_참고2 = findViewById(R.id.detail_menu_참고2);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.detail_menu_전화번호:
                phonenum = detail_menu_전화번호.getText().toString();
                if (!phonenum.equalsIgnoreCase("")) {
                    Intent i = new Intent(this, Dialog_twobutton.class);
                    i.putExtra("content", phonenum + " 로 전화 거시겠습니까?");
                    startActivityForResult(i, 1000);
                }
                break;
            case R.id.detail_menu_휴대폰:
                phonenum = detail_menu_휴대폰.getText().toString();
                if (!phonenum.equalsIgnoreCase("")) {
                    Intent i = new Intent(this, Dialog_twobutton.class);
                    i.putExtra("content", phonenum + " 로 전화 거시겠습니까?");
                    startActivityForResult(i, 1000);
                }
                break;
            case R.id.detail_menu_주소:

                String address = detail_menu_주소.getText().toString();


                if (!address.equalsIgnoreCase("")) {
                    Intent i = new Intent(this, Dialog_twobutton.class);
                    i.putExtra("content", address + " 로 길찾기를 안내 합니다.");
                    startActivityForResult(i, 2000);
                }

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1000:
                int i_flag = data.getIntExtra("flag", 3);

                switch (i_flag) {
                    case 1:
                        Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phonenum));
                        startActivity(call);
                        break;
                }
                break;
            case 2000:

                NaviOptions options = NaviOptions.newBuilder().setCoordType(CoordType.WGS84).setVehicleType(VehicleType.FIRST).setRpOption(RpOption.SHORTEST).build();
                Location location = findGeoPoint(getApplicationContext(), detail_menu_주소.getText().toString());
                double latitude = location.getLatitude();
                double longtitude = location.getLongitude();

                Log.d("latitude", latitude + "");
                Log.d("longtitude", longtitude + "");
                com.kakao.kakaonavi.Location destination = com.kakao.kakaonavi.Location.newBuilder(detail_menu_주소.getText().toString(), longtitude, latitude).build();
                KakaoNaviParams params = KakaoNaviParams.newBuilder(destination)
                        .setNaviOptions(options)
                        .build();
                i_flag = data.getIntExtra("flag", 0);
                if (i_flag == 1) {
                    KakaoNaviService.getInstance().navigate(this, params);
                }
                break;
        }
    }

    public static Location findGeoPoint(Context mcontext, String address) {


        Location loc = new Location("");
        Geocoder coder = new Geocoder(mcontext);
        List<Address> addr = null; // 한좌표에 대해 두개이상의 이름이 존재할수있기에 주소배열을 리턴받기 위해 설정


        try {
            addr = coder.getFromLocationName(address, 5);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 몇개 까지의 주소를 원하는지 지정 1~5개 정도가 적당
        if (addr != null) {
            for (int i = 0; i < addr.size(); i++) {
                Address lating = addr.get(i);
                double lat = lating.getLatitude(); // 위도가져오기
                double lon = lating.getLongitude(); // 경도가져오기
                loc.setLatitude(lat);
                loc.setLongitude(lon);
            }
        }
        return loc;
    }
}
