package com.example.diemrenluyen;

import java.io.Serializable;

public class userdomain implements Serializable {
    private int iduser;
    private int idrole;
    private int idlop;
    private String madn;
    private String ten;
    private String pass;
    private String ngaysinh;
    private String gioitinh;
    private String quequan;
    private String sdt;
    private String email;

    public userdomain(int iduser, int idrole, int idlop, String madn, String ten, String pass, String ngaysinh, String gioitinh, String quequan, String sdt, String email) {
        this.iduser = iduser;
        this.idrole = idrole;
        this.idlop = idlop;
        this.madn = madn;
        this.ten = ten;
        this.pass = pass;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.quequan = quequan;
        this.sdt = sdt;
        this.email = email;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public int getIdlop() {
        return idlop;
    }

    public void setIdlop(int idlop) {
        this.idlop = idlop;
    }

    public String getMadn() {
        return madn;
    }

    public void setMadn(String madn) {
        this.madn = madn;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
