package kr.co.packcom.hipackanybox.Adapter;

import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;


import kr.co.packcom.hipackanybox.Model.제품정보모델;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ViewHolder.제품정보뷰홀더;

public class 제품정보리스트어뎁터 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements 제품정보뷰홀더.itemviewHolderCallback {
    ArrayList<제품정보모델> list;
    Handler handler;
    Message msg;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu3_recyclerview_item, parent, false);


        return new 제품정보뷰홀더(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BindViewHolder((제품정보뷰홀더) holder, position);
    }

    void BindViewHolder(제품정보뷰홀더 holder, int position) {
        holder.menu3_recyclerview_item_pSize.setText(list.get(position).pJang + " * " + list.get(position).pPock + " * " + list.get(position).pGo);
        holder.menu3_recyclerview_item_prodName.setText(Html.fromHtml(position+1+". <font color=\"#4b89dc\">"+ list.get(position).prodName+"  ("+list.get(position).boxType+")</font>"));
        holder.menu3_recyclerview_item_prodUnit.setText(decimalFormat.format(Double.parseDouble(list.get(position).prodUnit)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onItemClick(int position) {

        Log.d("position",position+"");
        msg = handler.obtainMessage();
        msg.what = 2;
        msg.arg1 = position;
        handler.sendMessage(msg);

    }

    public void setData(ArrayList<제품정보모델> list, Handler handler) {
        this.list = list;
        this.handler = handler;

        notifyDataSetChanged();

    }
}
