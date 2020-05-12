package kr.co.packcom.hipackanybox.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kr.co.packcom.hipackanybox.R;

public class 공정모델뷰홀더 extends RecyclerView.ViewHolder {
    public TextView processName;
    public 공정모델뷰홀더(@NonNull View itemView) {
        super(itemView);
        processName = itemView.findViewById(R.id.menu3_detail_process_recyclerview_item);

    }
}
