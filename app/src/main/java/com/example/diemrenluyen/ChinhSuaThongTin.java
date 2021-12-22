package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

public class ChinhSuaThongTin extends AppCompatActivity {
    private userdomain user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_thong_tin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
    }
}