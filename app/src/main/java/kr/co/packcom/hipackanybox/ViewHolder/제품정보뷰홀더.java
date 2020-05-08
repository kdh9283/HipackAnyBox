package kr.co.packcom.hipackanybox.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kr.co.packcom.hipackanybox.R;

public class 제품정보뷰홀더 extends RecyclerView.ViewHolder implements View.OnClickListener {
    public itemviewHolderCallback callback;
    public TextView menu3_recyclerview_item_prodName;
    public TextView menu3_recyclerview_item_pSize;
    public TextView menu3_recyclerview_item_prodUnit;
    public 제품정보뷰홀더(@NonNull View itemView,itemviewHolderCallback callback) {
        super(itemView);
        menu3_recyclerview_item_prodName = itemView.findViewById(R.id.menu3_recyclerview_item_prodName);
        menu3_recyclerview_item_pSize = itemView.findViewById(R.id.menu3_recyclerview_item_pSize);
        menu3_recyclerview_item_prodUnit = itemView.findViewById(R.id.menu3_recyclerview_item_prodUnit);
        this.callback = callback;
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
