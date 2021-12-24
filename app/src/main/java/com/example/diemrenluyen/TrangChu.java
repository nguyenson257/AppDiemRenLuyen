package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TrangChu extends AppCompatActivity {

    private userdomain user;
    private TextView tv, thoigian;
    ImageView img;
    private Animation topAnim, bottomAnim, leftAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        Bundle bundleRecevie = getIntent().getExtras();
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_ani);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_ani);
        leftAnim = AnimationUtils.loadAnimation(this, R.anim.left_ani);

        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
//        Toast.makeText(TrangChu.this, user.toString(), Toast.LENGTH_SHORT).show();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bottomNavigation();
        tv=findViewById(R.id.text_chao);
        img=findViewById(R.id.img);
        thoigian=findViewById(R.id.thoigian);
        tv.setText("Chào bạn " + user.getTen() +",");
        tv.setAnimation(leftAnim);
        img.setAnimation(bottomAnim);
        thoigian.setAnimation(bottomAnim);
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