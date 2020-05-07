package kr.co.packcom.hipackanybox.Adapter;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Model.미수현황모델;
import kr.co.packcom.hipackanybox.Model.미수현황상세모델;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ViewHolder.미수현황상세뷰홀더;

public class 미수현황상세리스트어뎁터 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<String> group;
    ArrayList<미수현황상세모델> list;
    Handler handler;
    private DecimalFormat decimalFormat = new DecimalFormat("###,###");

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.misu_detail_item, parent, false);

        return new 미수현황상세뷰홀더(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindviewholder((미수현황상세뷰홀더) holder, position);
    }

    public void bindviewholder(미수현황상세뷰홀더 holder, int position) {
        String monthNo = group.get(position);
        int IOMoney = 0;
        int RecpMoney = 0;
        int DiscountMoney = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).MonthNo.equalsIgnoreCase(monthNo)) {
                Log.d("i", i + "");
                IOMoney += Double.parseDouble(list.get(i).IOMoney);
                RecpMoney += Double.parseDouble(list.get(i).RecpMoney);
                DiscountMoney += Double.parseDouble(list.get(i).DiscountMoney);
            }

        }

        Log.d("month", monthNo + " aa");
        if (group.get(position).equalsIgnoreCase("0")) {
            int total = 0;
            total +=IOMoney;
            total -=RecpMoney;
            total -=DiscountMoney;

            holder.misu_detail_item_MonthNo.setText("이 월");
            holder.misu_detail_item_total.setText(decimalFormat.format(total));
        } else {
            int total = 0;
            for(int i = 0 ; i < list.size();i++){
                if(Integer.parseInt(monthNo)>=Integer.parseInt(list.get(i).MonthNo)){
                    total +=Double.parseDouble(list.get(i).IOMoney);
                    total -=Double.parseDouble(list.get(i).RecpMoney);
                    total -=Double.parseDouble(list.get(i).DiscountMoney);
                }
            }
            holder.misu_detail_item_MonthNo.setText(group.get(position) + " 월");
            holder.misu_detail_item_total.setText(decimalFormat.format(total));
        }

        holder.misu_detail_item_IOMoney.setText(decimalFormat.format(IOMoney));
        holder.misu_detail_item_RecpMoney.setText(decimalFormat.format(RecpMoney));
        holder.misu_detail_item_DiscountMoney.setText(decimalFormat.format(DiscountMoney));

    }

    @Override
    public int getItemCount() {
        return group.size();
    }

    public void setData(ArrayList<String> group, ArrayList<미수현황상세모델> list, Handler handler) {
        this.group = group;
        this.list = list;
        this.handler = handler;

    }
}
