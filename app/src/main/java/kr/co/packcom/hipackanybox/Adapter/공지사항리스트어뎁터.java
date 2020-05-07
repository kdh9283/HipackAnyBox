package kr.co.packcom.hipackanybox.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Model.공지사항모델;
import kr.co.packcom.hipackanybox.R;


public class 공지사항리스트어뎁터 extends PagerAdapter {

    private Context mContext;
    private ArrayList<공지사항모델> imageList;

    public 공지사항리스트어뎁터(Context context, ArrayList<공지사항모델> imageList) {

        this.mContext = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.pagerview_layout, null);

        ImageView imageView = view.findViewById(R.id.imageView);
        Glide.with(imageView.getContext()).load(imageList.get(position).notice_image).into(imageView);
        // Glide.with(imageView.getContext()).load("http://hipackcom.co.kr/image/test.jpg").into(imageView);

        container.addView(view);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!imageList.get(position).notice_url.equalsIgnoreCase("")) {

                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(imageList.get(position).notice_url));
                    container.getContext().startActivity(i);

                }
            }
        });
        return view;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (View) o);
    }
}
