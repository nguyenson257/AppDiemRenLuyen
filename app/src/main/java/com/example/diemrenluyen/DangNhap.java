package com.example.diemrenluyen;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhap extends AppCompatActivity {

    private TextView txt_username, txt_password;
    private Button btn_dangnhap;
    private ArrayList<userdomain> user= new ArrayList<>();
    private userdomain muser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        getlistuser();
        btn_dangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicklogin();
            }
        });

    }
    private void clicklogin(){
        String strUsername=txt_username.getText().toString().trim();
        String strPassword=txt_password.getText().toString().trim();
        AlertDialog.Builder alert = new AlertDialog.Builder(DangNhap.this);
        alert.setTitle("Nhập Thiếu Thông Tin");
        alert.setMessage("Bạn nhập thiếu thông tin. Vui lòng nhập lại");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alert.setCancelable(true);
            }
        });
        if(strUsername.isEmpty()||strPassword.isEmpty()){
            alert.show();
        }
        else {
            if(user == null || user.isEmpty()){
                return;
            }
            boolean isHasUser = false;
            for(userdomain khachHang: user){
                if(strUsername.equals(khachHang.getMadn()) && strPassword.equals(khachHang.getPass())){
                    isHasUser = true;
                    muser = khachHang;
                    break;
                }
            }
            if (isHasUser){
                Intent intent = new Intent(getApplicationContext(), TrangChu.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",muser);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }else {
                alert.setTitle("Đăng nhập thất bại");
                alert.setMessage("Bạn nhập sai tên đăng nhập hoặc mật khẩu! Vui lòng kiểm tra lại!");
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alert.setCancelable(true);
                    }
                });
                alert.show();
            }
        }
    }
    private void getlistuser() {
        ApiService.apiService.showuser().enqueue(new Callback<ArrayList<userdomain>>() {
            @Override
            public void onResponse(Call<ArrayList<userdomain>> call, Response<ArrayList<userdomain>> response) {
                user = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<userdomain>> call, Throwable t) {

            }
        });
    }


    public void init(){
        txt_username = findViewById(R.id.txt_username);
        txt_password = findViewById(R.id.pass);
        btn_dangnhap = findViewById(R.id.btn_dangnhap);
    }
}