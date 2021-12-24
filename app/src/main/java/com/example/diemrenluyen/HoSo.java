package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HoSo extends AppCompatActivity {
    private userdomain user;
    private RelativeLayout thongtincanhan, password, dangxuat;
    private TextView txt_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ho_so);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
        bottomNavigation();
        thongtincanhan = findViewById(R.id.thongtincanhan);
        password = findViewById(R.id.password);
        dangxuat = findViewById(R.id.dangxuat);
        txt_name = findViewById(R.id.txt_name);

        txt_name.setText(user.getTen());
        thongtincanhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThongTinCaNhan.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DoiMatKhau.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        dangxuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DangNhap.class);
                startActivity(intent);
            }
        });
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