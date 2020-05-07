package kr.co.packcom.hipackanybox.ViewHolder;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import kr.co.packcom.hipackanybox.R;

public class AccountCodeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private itemViewHolderCallback callback;
    public LinearLayout accountcode_item;
    public TextView 축소상호;
    public TextView 주소;
    public TextView 전화번호;

    public AccountCodeViewHolder(@NonNull View itemView,itemViewHolderCallback callback) {
        super(itemView);
        accountcode_item = itemView.findViewById(R.id.accountcode_item);
        accountcode_item.setOnClickListener(this);
        축소상호 = itemView.findViewById(R.id.축소상호);
        주소 = itemView.findViewById(R.id.주소);
        전화번호 = itemView.findViewById(R.id.전화번호);

        this.callback = callback;

    }

    @Override
    public void onClick(View v) {
        int postion = getAdapterPosition();
        Log.d("position",postion+" ");
        switch (v.getId()){
            case R.id.accountcode_item:
                callback.onItemClick(postion);
                break;
        }
    }

    public interface itemViewHolderCallback{
        void onItemClick(int position);
    }
}
