package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChamDiem extends AppCompatActivity {

    private ArrayList<mucchamdomain>  mucchamdomains1 = new ArrayList<>(), mucchamdomains2 = new ArrayList<>(), mucchamdomains3 = new ArrayList<>(), mucchamdomains4 = new ArrayList<>(), mucchamdomains5 = new ArrayList<>() ;
    private RecyclerView danhsachmuccham1, danhsachmuccham2, danhsachmuccham3, danhsachmuccham4, danhsachmuccham5;
    private RecyclerView.Adapter adapter1, adapter2, adapter3, adapter4, adapter5;
    private mucdiemAdapter list1, list2, list3, list4, list5 ;
    private int mmax1=0, mmax2=0, mmax3=0, mmax4=0, mmax5=0;
    private ArrayList<getdiemcham> listdiem1 = new ArrayList<>(), listdiem2 = new ArrayList<>(), listdiem3 = new ArrayList<>(), listdiem4 = new ArrayList<>(), listdiem5 = new ArrayList<>();
    private Button btn_nopdiem,btn_capnhat;
    private TextView tongdiem1, tongdiem2, tongdiem3, tongdiem4, tongdiem5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cham_diem);
        init();
        ApiService.apiService.showitem().enqueue(new Callback<ArrayList<mucchamdomain>>() {
            @Override
            public void onResponse(Call<ArrayList<mucchamdomain>> call, Response<ArrayList<mucchamdomain>> response) {

                ArrayList<mucchamdomain> allmucchamdomains = response.body();
                setadapter(allmucchamdomains);
            }

            @Override
            public void onFailure(Call<ArrayList<mucchamdomain>> call, Throwable t) {

            }
        });
//        mucchamlist();
        setlayoutrecycleview();

        btn_nopdiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                settongdiem();
            }
        });
    }

    private void setlayoutrecycleview() {
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager3 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager linearLayoutManager5 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        danhsachmuccham1.setLayoutManager(linearLayoutManager1);
        danhsachmuccham2.setLayoutManager(linearLayoutManager2);
        danhsachmuccham3.setLayoutManager(linearLayoutManager3);
        danhsachmuccham4.setLayoutManager(linearLayoutManager4);
        danhsachmuccham5.setLayoutManager(linearLayoutManager5);
    }

    private void setadapter(ArrayList<mucchamdomain> mucchamdomains) {
        for (mucchamdomain i:mucchamdomains
        ) {
            if(i.getIdmdcha()==1){
                mmax1 =mmax1+ i.getDiemtoida();
                mucchamdomains1.add(i);
            }
        }
        adapter1 = new mucdiemAdapter(mucchamdomains1,listdiem1);
        danhsachmuccham1.setAdapter(adapter1);

        for (mucchamdomain i:mucchamdomains
        ) {
            if(i.getIdmdcha()==2){
                mmax2 =mmax2+ i.getDiemtoida();
                mucchamdomains2.add(i);
            }
        }
        adapter2 = new mucdiemAdapter(mucchamdomains2,listdiem2);
        danhsachmuccham2.setAdapter(adapter2);

        for (mucchamdomain i:mucchamdomains
        ) {
            if(i.getIdmdcha()==3){
                mmax3 =mmax3+ i.getDiemtoida();
                mucchamdomains3.add(i);
            }
        }
        adapter3 = new mucdiemAdapter(mucchamdomains3,listdiem3);
        danhsachmuccham3.setAdapter(adapter3);

        for (mucchamdomain i:mucchamdomains
        ) {
            if(i.getIdmdcha()==4){
                mmax4 =mmax4+ i.getDiemtoida();
                mucchamdomains4.add(i);
            }
        }
        adapter4 = new mucdiemAdapter(mucchamdomains4,listdiem4);
        danhsachmuccham4.setAdapter(adapter4);

        for (mucchamdomain i:mucchamdomains
        ) {
            if(i.getIdmdcha()==5){
                mmax5 =mmax5+ i.getDiemtoida();
                mucchamdomains5.add(i);
            }
        }
        adapter5 = new mucdiemAdapter(mucchamdomains5,listdiem5);
        danhsachmuccham5.setAdapter(adapter5);
    }

    private void settongdiem(){
        int tongd1 = 0;
        int tongd2 = 0;
        int tongd3 = 0;
        int tongd4 = 0;
        int tongd5 = 0;
        list1= (mucdiemAdapter) danhsachmuccham1.getAdapter();
        list2= (mucdiemAdapter) danhsachmuccham2.getAdapter();
        list3= (mucdiemAdapter) danhsachmuccham3.getAdapter();
        list4= (mucdiemAdapter) danhsachmuccham4.getAdapter();
        list5= (mucdiemAdapter) danhsachmuccham5.getAdapter();
        listdiem1=(list1.getitem());
        listdiem2=(list2.getitem());
        listdiem3=(list3.getitem());
        listdiem4=(list4.getitem());
        listdiem5=(list5.getitem());

        for (getdiemcham d:listdiem1
             ) {
            tongd1 = tongd1 + d.diemcham;
        };

        for (getdiemcham d:listdiem2
        ) {
            tongd2 = tongd2 + d.diemcham;
        };

        for (getdiemcham d:listdiem3
        ) {
            tongd3 = tongd3 + d.diemcham;
        };

        for (getdiemcham d:listdiem4
        ) {
            tongd4 = tongd4 + d.diemcham;
        };

        for (getdiemcham d:listdiem5
        ) {
            tongd5 = tongd5 + d.diemcham;
        };

        String text1 = "Tổng điểm mục 1: "+(tongd1)+"/"+(mmax1)+" điểm";
        String text2 = "Tổng điểm mục 2: "+(tongd2)+"/"+(mmax2)+" điểm";
        String text3 = "Tổng điểm mục 3: "+(tongd3)+"/"+(mmax3)+" điểm";
        String text4 = "Tổng điểm mục 4: "+(tongd4)+"/"+(mmax4)+" điểm";
        String text5 = "Tổng điểm mục 5: "+(tongd5)+"/"+(mmax5)+" điểm";

        tongdiem1.setText(text1);
        tongdiem2.setText(text2);
        tongdiem3.setText(text3);
        tongdiem4.setText(text4);
        tongdiem5.setText(text5);
    }



    private void mucchamlist(){


    }
    public void init(){
        danhsachmuccham1 = findViewById(R.id.danhsach1);
        danhsachmuccham2 = findViewById(R.id.danhsach2);
        danhsachmuccham3 = findViewById(R.id.danhsach3);
        danhsachmuccham4 = findViewById(R.id.danhsach4);
        danhsachmuccham5 = findViewById(R.id.danhsach5);
        btn_nopdiem = findViewById(R.id.btn_nopdiem);
        btn_capnhat = findViewById(R.id.btn_capnhat);
        tongdiem1 = findViewById(R.id.tongdiem1);
        tongdiem2 = findViewById(R.id.tongdiem2);
        tongdiem3 = findViewById(R.id.tongdiem3);
        tongdiem4 = findViewById(R.id.tongdiem4);
        tongdiem5 = findViewById(R.id.tongdiem5);
    }
}