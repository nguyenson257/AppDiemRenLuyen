package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class ChamDiemThanhCong extends AppCompatActivity {
    ImageView bt;
    Button bttc;
    private userdomain user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cham_diem_thanh_cong);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        bt=findViewById(R.id.img_back_ttcn);
        bttc=findViewById(R.id.btn_trangchu);
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
        }
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        bttc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}