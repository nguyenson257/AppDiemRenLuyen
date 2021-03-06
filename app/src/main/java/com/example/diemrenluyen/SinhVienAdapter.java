package com.example.diemrenluyen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;

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
        int drawableResourceId;
        if(userdomains.get(position).getGioitinh().equals("Nam")){
            drawableResourceId= holder.itemView.getContext().getResources().getIdentifier("icon_male", "drawable", holder.itemView.getContext().getPackageName());
        }
        else {
            drawableResourceId= holder.itemView.getContext().getResources().getIdentifier("icon_female", "drawable", holder.itemView.getContext().getPackageName());
        }
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return userdomains.size();
    }

    public void filterList(ArrayList<userdomain> filterList, userdomain user1){
        userdomains = filterList;
        user = user1;
        notifyDataSetChanged();
    };

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,msv, gt;
        LinearLayout favBtn ;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            msv=itemView.findViewById(R.id.msv);
            gt=itemView.findViewById(R.id.gt);
            favBtn=itemView.findViewById(R.id.favBtn);
            img=itemView.findViewById(R.id.imghinh);
        }
    }
}
