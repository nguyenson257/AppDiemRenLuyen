package com.example.diemrenluyen;

public class getdiemcham {
    int diemcham,idmdcon;

    public getdiemcham(int diemcham, int idmdcon) {
        this.diemcham = diemcham;
        this.idmdcon = idmdcon;
    }

    @Override
    public String toString() {
        return "getdiemcham{" +
                "diemcham=" + diemcham +
                ", idmdcon=" + idmdcon +
                '}';
    }

    public int getDiemcham() {
        return diemcham;
    }

    public void setDiemcham(int diemcham) {
        this.diemcham = diemcham;
    }

    public int getIdmdcon() {
        return idmdcon;
    }

    public void setIdmdcon(int idmdcon) {
        this.idmdcon = idmdcon;
    }
}
