package com.example.diemrenluyen;

public class chitietchamdrldomain {
    private int iduser;
    private int idmdc;
    private int idhk;
    private int diemcham;
    private int diemchamlai;
    private int trangthai;

    public chitietchamdrldomain(int iduser, int idmdc, int idhk, int diemcham, int diemchamlai, int trangthai) {
        this.iduser = iduser;
        this.idmdc = idmdc;
        this.idhk = idhk;
        this.diemcham = diemcham;
        this.diemchamlai = diemchamlai;
        this.trangthai = trangthai;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdmdc() {
        return idmdc;
    }

    public void setIdmdc(int idmdc) {
        this.idmdc = idmdc;
    }

    public int getIdhk() {
        return idhk;
    }

    public void setIdhk(int idhk) {
        this.idhk = idhk;
    }

    public int getDiemcham() {
        return diemcham;
    }

    public void setDiemcham(int diemcham) {
        this.diemcham = diemcham;
    }

    public int getDiemchamlai() {
        return diemchamlai;
    }

    public void setDiemchamlai(int diemchamlai) {
        this.diemchamlai = diemchamlai;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
