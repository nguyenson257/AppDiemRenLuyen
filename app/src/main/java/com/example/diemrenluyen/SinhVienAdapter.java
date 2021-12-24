package com.example.diemrenluyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SinhVienAdapter extends RecyclerView.Adapter<SinhVienAdapter.ViewHolder>  {
    ArrayList<userdomain> userdomains;
    private userdomain user;

    public SinhVienAdapter(ArrayList<userdomain> userdomains, userdomain user) {
        this.userdomains = userdomains;
        this.user = user;
    }

    @NonNull
    @Override
    public SinhVienAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.sinhvienlist, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SinhVienAdapter.ViewHolder holder, int position) {
        holder.name.setText(userdomains.get(position).getTen());
        holder.gt.setText(userdomains.get(position).getGioitinh());
        holder.msv.setText(userdomains.get(position).getMadn());
    }

    @Override
    public int getItemCount() {
        return userdomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,msv, gt;
        LinearLayout favBtn ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            msv=itemView.findViewById(R.id.msv);
            gt=itemView.findViewById(R.id.gt);
            favBtn=itemView.findViewById(R.id.favBtn);
        }
    }
}
