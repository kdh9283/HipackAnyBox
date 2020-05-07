package kr.co.packcom.hipackanybox.Adapter;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.co.packcom.hipackanybox.암호화모듈;
import kr.co.packcom.hipackanybox.Model.업체정보모델;
import kr.co.packcom.hipackanybox.R;
import kr.co.packcom.hipackanybox.ViewHolder.AccountCodeViewHolder;

public class 업체정보리스트어뎁터 extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements AccountCodeViewHolder.itemViewHolderCallback {
    암호화모듈 암호화모듈;
    ArrayList<업체정보모델> list;
    ArrayList<업체정보모델> arraylist;
    private Handler handler;
    private Message msg;


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.accountcode_item, parent, false);

        return new AccountCodeViewHolder(view, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindAccountViewHolder((AccountCodeViewHolder) holder, position);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void bindAccountViewHolder(AccountCodeViewHolder holder, int position) {
        String 부서폰번호 = "";
        holder.축소상호.setText(list.get(position).축소상호);
        holder.주소.setText(list.get(position).주소);

        try {
            if (!list.get(position).부서폰번호.equalsIgnoreCase("")) {
                부서폰번호 = 암호화모듈.복호화(list.get(position).부서폰번호);
            }
        } catch (NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (!list.get(position).전화번호.equalsIgnoreCase("")) {
            holder.전화번호.setText(Html.fromHtml("T: " + list.get(position).전화번호 + "\t\t" + "<font color=\"#4b89dc\">" + 부서폰번호 + "</font>", 0));
        } else {
            holder.전화번호.setText("T: " + 부서폰번호);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updatelist(ArrayList<업체정보모델> list, Handler handler) {

        this.list = list;
        this.handler = handler;
        notifyDataSetChanged();

    }

    public void setAccountlist(ArrayList<업체정보모델> list, Handler handler) {

        this.list = list;
        this.arraylist = list;
        암호화모듈 = new 암호화모듈("ICD4662402");
        this.handler = handler;
        notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {
        Log.d("position", position + "클릭");
        msg = handler.obtainMessage();
        msg.what = 2;
        msg.arg1 = position;
        handler.sendMessage(msg);

    }

}
