package kr.co.packcom.hipackanybox.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kr.co.packcom.hipackanybox.R;

public class 미수현황상세뷰홀더 extends RecyclerView.ViewHolder {
    public TextView misu_detail_item_MonthNo;
    public TextView misu_detail_item_IOMoney;
    public TextView misu_detail_item_RecpMoney;
    public TextView misu_detail_item_DiscountMoney;
    public TextView misu_detail_item_total;
    public 미수현황상세뷰홀더(@NonNull View itemView) {
        super(itemView);
        misu_detail_item_MonthNo = itemView.findViewById(R.id.misu_detail_item_MonthNo);
        misu_detail_item_IOMoney = itemView.findViewById(R.id.misu_detail_item_IOMoney);
        misu_detail_item_RecpMoney = itemView.findViewById(R.id.misu_detail_item_RecpMoney);
        misu_detail_item_DiscountMoney = itemView.findViewById(R.id.misu_detail_item_DiscountMoney);
        misu_detail_item_total = itemView.findViewById(R.id.misu_detail_item_total);

    }
}
