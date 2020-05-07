package kr.co.packcom.hipackanybox.Adapter;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import kr.co.packcom.hipackanybox.Model.미수현황모델;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ViewHolder.미수현황뷰홀더;

public class 미수현황리스트어뎁터 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements 미수현황뷰홀더.itemviewHolderCallback {

    private Handler handler;
    private ArrayList<미수현황모델> list;
    ArrayList<String> group;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");
    private Message msg;
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.misu_list_item, parent, false);

        return new 미수현황뷰홀더(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindViewMisuHolder((미수현황뷰홀더) holder, position);
    }

    private void bindViewMisuHolder(미수현황뷰홀더 holder, int position) {
        int leftMoney = 0;
        int before1MonthLeftMoney = 0;


        holder.misu_customsname.setText(group.get(position));

        for(int i = 0 ; i < list.size();i++) {
            if (group.get(position).equalsIgnoreCase(list.get(i).customSName)){
                leftMoney += Double.parseDouble(list.get(i).LeftMoney);
                before1MonthLeftMoney += Double.parseDouble(list.get(i).Before1MonthLeftMoney);
            }

        }


        holder.misu_LeftMoney.setText(decimalFormat.format(leftMoney));
        holder.misu_Before1MonthLeftMoney.setText(decimalFormat.format(before1MonthLeftMoney));
        holder.setIsRecyclable(false);
    }

    @Override
    public int getItemCount() {
        return group.size();
    }

    public void setList(ArrayList<미수현황모델> list,ArrayList<String> group, Handler handler) {
        this.list = list;
        this.handler = handler;
        this.group = group;
        Collections.sort(this.group);
        notifyDataSetChanged();



    }

    @Override
    public void onItemClick(int position) {
        msg = handler.obtainMessage();
        msg.what = 2;
        msg.arg1 = position;
        handler.sendMessage(msg);
    }
}
