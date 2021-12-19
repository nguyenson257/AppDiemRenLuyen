package com.example.diemrenluyen;

public class mucchamdomain {

    private int idmdcon;
    private int idmdcha;
    private String noidung;
    private int diemtoida;

    public mucchamdomain(int idmdcon, int idmdcha, String noidung, int diemtoida) {
        this.idmdcon = idmdcon;
        this.idmdcha = idmdcha;
        this.noidung = noidung;
        this.diemtoida = diemtoida;
    }

    @Override
    public String toString() {
        return "mucchamdomain{" +
                "idmdcon=" + idmdcon +
                ", idmdcha=" + idmdcha +
                ", noidung='" + noidung + '\'' +
                ", diemtoida=" + diemtoida +
                '}';
    }

    public int getIdmdcon() {
        return idmdcon;
    }

    public void setIdmdcon(int idmdcon) {
        this.idmdcon = idmdcon;
    }

    public int getIdmdcha() {
        return idmdcha;
    }

    public void setIdmdcha(int idmdcha) {
        this.idmdcha = idmdcha;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getDiemtoida() {
        return diemtoida;
    }

    public void setDiemtoida(int diemtoida) {
        this.diemtoida = diemtoida;
    }
}
