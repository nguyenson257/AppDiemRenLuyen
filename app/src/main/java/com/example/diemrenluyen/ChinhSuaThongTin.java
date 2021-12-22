package com.example.diemrenluyen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChinhSuaThongTin extends AppCompatActivity {
    private userdomain user;
    private String lop, khoa;
    EditText edt_hoten, edt_ngaysinh, edt_sdt, edt_email;
    TextView txt_hname, tv_masv, tv_lop, tv_khoa;
    RadioButton rbt_nam, rbt_nu, rbt_khac;
    ImageView img_back_cstt;
    Button btn_luu_cstt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinh_sua_thong_tin);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){

        }
        AnhXa();
        setinfo();
        OnTab();
    }

    private void OnTab() {
        //quay lại trang thông tin
        img_back_cstt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChinhSuaThongTin.this, ThongTinCaNhan.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        //chọn ngày
        edt_ngaysinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChonNgay();
            }
        });

        btn_luu_cstt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                saveInfor(user);
//                ApiService.apiService.updateKhachhang(khachhang,khachhang.getIdkh()).enqueue(new Callback<Khachhang>() {
//                    @Override
//                    public void onResponse(Call<Khachhang> call, Response<Khachhang> response) {
//                        if(response.isSuccessful()){
//                            Toast.makeText(ChinhSuaThongTin.this,"Cập nhật thành công!!!",Toast.LENGTH_LONG).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Khachhang> call, Throwable t) {
//                        Toast.makeText(ChinhSuaThongTin.this,"Thaats bai!!!",Toast.LENGTH_LONG).show();
//                    }
//                });
                Intent intent = new Intent(ChinhSuaThongTin.this, ThongTinCaNhan.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_user",user);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void saveInfor(userdomain user) {
    }

    private void setinfo() {
        Bundle bundleRecevie = getIntent().getExtras();
        if(bundleRecevie!=null){
            user = (userdomain) bundleRecevie.get("object_user");
            lop = (String) bundleRecevie.get("object_lop");
            khoa = (String) bundleRecevie.get("object_khoa");

            edt_hoten.setText(user.getTen());
            edt_ngaysinh.setText(user.getNgaysinh());
            edt_sdt.setText(user.getSdt());
            edt_email.setText(user.getEmail());

            tv_masv.setText(user.getMadn());
            tv_lop.setText(lop);
            tv_khoa.setText(khoa);
            txt_hname.setText(user.getTen());

            String gioitinh = user.getGioitinh();
            if (gioitinh.equals("Nam")) {
                rbt_nam.isSelected();
            } else {
                if (gioitinh.equals("Nữ")) {
                    rbt_nu.isSelected();
                } else{
                    if (gioitinh.equals("Nữ")){
                        rbt_khac.isSelected();
                    }
                }
            }
        }
    }

    public void AnhXa() {
        img_back_cstt = findViewById(R.id.img_back_cstt);
        btn_luu_cstt = findViewById(R.id.btn_luu_cstt);

        edt_hoten = findViewById(R.id.edt_cstt_hoten);
        edt_ngaysinh = findViewById(R.id.edt_cstt_ngaysinh);
        edt_sdt = findViewById(R.id.edt_cstt_sdt);
        edt_email = findViewById(R.id.edt_cstt_email);

        rbt_nam = findViewById(R.id.rbt_nam_cstt);
        rbt_nu = findViewById(R.id.rbt_nu_cstt);
        rbt_khac = findViewById(R.id.rbt_khac_cstt);

        txt_hname = findViewById(R.id.txt_hname);
        tv_masv = findViewById(R.id.tv_masv);
        tv_lop = findViewById(R.id.tv_lop);
        tv_khoa = findViewById(R.id.tv_khoa);
    }
    public void ChonNgay() {
        Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                edt_ngaysinh.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }
}