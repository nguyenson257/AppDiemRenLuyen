package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DangNhap extends AppCompatActivity {

    private TextView txt_username, txt_password;
    private Button btn_dangnhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        init();
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrangChu.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("object_user",khachhang);
//                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }

    public void init(){
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.txt_password);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
    }
}