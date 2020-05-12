package kr.co.packcom.hipackanybox.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.co.packcom.hipackanybox.Model.공정모델;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ViewHolder.공정모델뷰홀더;

public class 공정모델어뎁터 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<공정모델> list;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.processitem, parent, false);
        return new 공정모델뷰홀더(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BindViewHolder((공정모델뷰홀더) holder, position);
    }

    public void BindViewHolder(공정모델뷰홀더 holder, int position) {
        holder.processName.setText(list.get(position).ProcessTypeName);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(ArrayList<공정모델> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
