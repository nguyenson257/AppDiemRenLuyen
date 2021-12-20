package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DoiMatKhau extends AppCompatActivity {
    private userdomain user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doi_mat_khau);
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
    }
}