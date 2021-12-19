package com.example.diemrenluyen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class mucdiemAdapter extends RecyclerView.Adapter<mucdiemAdapter.ViewHolder> {

    ArrayList<mucchamdomain> mucchamdomains;
    ArrayList<getdiemcham> getdiemchams;
    public mucdiemAdapter(ArrayList<mucchamdomain> mucchamdomains) {
        this.mucchamdomains = mucchamdomains;
    }

    public mucdiemAdapter(ArrayList<mucchamdomain> mucchamdomains, ArrayList<getdiemcham> getdiemchams) {
        this.mucchamdomains = mucchamdomains;
        this.getdiemchams = getdiemchams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.holder_danhsach_muccham, parent, false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        getdiemchams.get(position).setIdmdcon(mucchamdomains.get(position).getIdmdcon());
        getdiemchams.get(position).setDiemcham(0);
        int smax = mucchamdomains.get(position).getDiemtoida();
        holder.txt_noidung.setText(mucchamdomains.get(position).getNoidung());
        holder.txt_diem.setText("0");
        holder.btn_cong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  soluong =Integer.parseInt(holder.txt_diem.getText().toString());
                if (soluong>=smax){
                }else{
                soluong = soluong + 1;
                holder.txt_diem.setText(String.valueOf(soluong));
                getdiemchams.get(position).setDiemcham(soluong);
                }
            }
        });

        holder.btn_tru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int  soluong =Integer.parseInt(holder.txt_diem.getText().toString());
                if (soluong > 0) {
                    soluong = soluong - 1;
                    getdiemchams.get(position).setDiemcham(soluong);
                }
                holder.txt_diem.setText(String.valueOf(soluong));
            }
        });
    }


    @Override
    public int getItemCount() {
        return mucchamdomains.size();
    }

    public ArrayList<getdiemcham> getitem(){
        return getdiemchams;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txt_noidung, txt_diem;
        ImageView btn_tru,btn_cong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_noidung = itemView.findViewById(R.id.txt_noidung);
            txt_diem = itemView.findViewById(R.id.txt_diem);
            btn_tru = itemView.findViewById(R.id.btn_tru);
            btn_cong = itemView.findViewById(R.id.btn_cong);
        }
    }
}
