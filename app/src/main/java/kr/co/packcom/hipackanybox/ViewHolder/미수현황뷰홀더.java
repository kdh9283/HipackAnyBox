package kr.co.packcom.hipackanybox.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kr.co.packcom.hipackanybox.R;

public class 미수현황뷰홀더 extends RecyclerView.ViewHolder implements View.OnClickListener {
    private itemviewHolderCallback callback;
    public TextView misu_customsname;
    public TextView misu_Before1MonthLeftMoney;
    public TextView misu_LeftMoney;
    public 미수현황뷰홀더(@NonNull View itemView, itemviewHolderCallback callback) {

        super(itemView);
        this.callback = callback;
        misu_customsname = itemView.findViewById(R.id.misu_customsname);
        misu_Before1MonthLeftMoney = itemView.findViewById(R.id.misu_Before1MonthLeftMoney);
        misu_LeftMoney = itemView.findViewById(R.id.misu_LeftMoney);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        callback.onItemClick(position);
    }


    public interface itemviewHolderCallback{
        void onItemClick(int position);
    }
}
