package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ThongTinCaNhan extends AppCompatActivity {
    private userdomain user;
    private Button btn_sua_ttcn;
    private ImageView img_back_ttcn;
    private ArrayList<lopdomain> lop= new ArrayList<>();
    private ArrayList<khoadomain> khoa= new ArrayList<>();
    private TextView tv_hoten, tv_sdt, tv_gioitinh, tv_ngaysinh, tv_email, tv_masv, tv_lop, tv_khoa, txt_hname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_ca_nhan);
        Bundle bundleRecevie = getIntent().getExtras();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
        AnhXa();
        getlop();
        getkhoa();
        OnTab();
        bottomNavigation();
    }

    private void getkhoa() {
        ApiService.apiService.showkhoa().enqueue(new Callback<ArrayList<khoadomain>>() {
            @Override
            public void onResponse(Call<ArrayList<khoadomain>> call, Response<ArrayList<khoadomain>> response) {
                khoa = response.body();
                setInfor(user);
            }

            @Override
            public void onFailure(Call<ArrayList<khoadomain>> call, Throwable t) {

            }
        });
    }

    private void getlop() {
        ApiService.apiService.showlop().enqueue(new Callback<ArrayList<lopdomain>>() {
            @Override
            public void onResponse(Call<ArrayList<lopdomain>> call, Response<ArrayList<lopdomain>> response) {
                lop = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<lopdomain>> call, Throwable t) {

            }
        });
    }


    private void setInfor(userdomain user) {
        String lsh = null, ksh = null;
        int idk = 0;
        for(lopdomain i: lop){
            if(user.getIdlop()==i.getIdlop()){
                lsh = i.getTenlop();
                idk = i.getIdkhoa();
                break;
            }
        }
        for(khoadomain i: khoa){
            if(idk == i.getIdkhoa()){
                ksh = i.getTenkhoa();
                break;
            }
        }
        txt_hname.setText(user.getTen());
        tv_hoten.setText(user.getTen());
        tv_email.setText(user.getEmail());
        tv_ngaysinh.setText(user.getNgaysinh());
        tv_gioitinh.setText(user.getGioitinh());
        tv_sdt.setText(user.getSdt());
        tv_masv.setText(user.getMadn());
        tv_lop.setText(lsh);
        tv_khoa.setText(ksh);
    }

    public void OnTab() {
        //quay lại trang cá nhân
        img_back_ttcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinCaNhan.this, HoSo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //đến trang sửa thông tin
        btn_sua_ttcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThongTinCaNhan.this, ChinhSuaThongTin.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                bundle.putSerializable("object_lop",tv_lop.getText().toString());
                bundle.putSerializable("object_khoa",tv_khoa.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    public void AnhXa() {
        btn_sua_ttcn = findViewById(R.id.btn_sua_ttcn);
        img_back_ttcn = findViewById(R.id.img_back_ttcn);
        tv_hoten = findViewById(R.id.tv_ttcn_hoten);
        tv_email = findViewById(R.id.tv_ttcn_email);
        tv_ngaysinh = findViewById(R.id.tv_ttcn_ngaysinh);
        tv_gioitinh = findViewById(R.id.tv_ttcn_gioitinh);
        tv_sdt = findViewById(R.id.tv_ttcn_sdt);
        tv_lop = findViewById(R.id.tv_ttcn_lop);
        tv_khoa = findViewById(R.id.tv_ttcn_khoa);
        tv_masv = findViewById(R.id.tv_ttcn_masv);
        txt_hname = findViewById(R.id.txt_hname);
    }
    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout favBtn = findViewById(R.id.favBtn);
        LinearLayout notiBtn = findViewById(R.id.notBtn);
        LinearLayout proBtn = findViewById(R.id.proBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ChamDiem.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), XemDiem.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        notiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ThongBao.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        proBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HoSo.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

}