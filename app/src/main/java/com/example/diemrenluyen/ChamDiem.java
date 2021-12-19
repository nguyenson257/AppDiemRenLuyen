package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChamDiem extends AppCompatActivity {

    private RecyclerView danhsachmuccham;
    private RecyclerView.Adapter adapter;
    private mucdiemAdapter list;
    private ArrayList<getdiemcham> listdiem = new ArrayList<>();
    private Button btn_nopdiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cham_diem);
        danhsachmuccham = findViewById(R.id.danhsach);
        btn_nopdiem = findViewById(R.id.btn_nopdiem);
        mucchamlist();
        btn_nopdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list= (mucdiemAdapter) danhsachmuccham.getAdapter();
                ArrayList<getdiemcham> danhsachcham = new ArrayList<>();
                listdiem=(list.getitem());
                Toast.makeText(ChamDiem.this,listdiem.get(0).toString()+listdiem.get(1).toString()+listdiem.get(2).toString()+listdiem.get(3).toString()+listdiem.get(4).toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }
    private void mucchamlist(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        danhsachmuccham.setLayoutManager(linearLayoutManager);
        ArrayList<mucchamdomain> mucchamdomains = new ArrayList<>();
//        ApiService.apiService.showitem().enqueue(new Callback<ArrayList<mucchamdomain>>() {
//            @Override
//            public void onResponse(Call<ArrayList<mucchamdomain>> call, Response<ArrayList<mucchamdomain>> response) {
////                Toast.makeText(TrangChu.this,khachhang.toString(), Toast.LENGTH_SHORT).show();
//                ArrayList<mucchamdomain> mucchamdomain = response.body();
//                adapter = new mucdiemAdapter(mucchamdomain);
//                danhsachmuccham.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<mucchamdomain>> call, Throwable t) {
//
//            }
//        });
        mucchamdomains.add(new mucchamdomain(1,1,"Noi dung 1",3));
        mucchamdomains.add(new mucchamdomain(2,1,"Noi dung 2",3));
        mucchamdomains.add(new mucchamdomain(3,1,"Noi dung 3",4));
        mucchamdomains.add(new mucchamdomain(4,1,"Noi dung 4",2));
        mucchamdomains.add(new mucchamdomain(5,1,"Noi dung 5",3));
        mucchamdomains.add(new mucchamdomain(6,1,"Noi dung 6",4));
        mucchamdomains.add(new mucchamdomain(7,1,"Noi dung 7",1));
        mucchamdomains.add(new mucchamdomain(8,1,"Noi dung 8",2));
        adapter = new mucdiemAdapter(mucchamdomains,listdiem);
        danhsachmuccham.setAdapter(adapter);
    }
}