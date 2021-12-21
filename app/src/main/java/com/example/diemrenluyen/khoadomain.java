package com.example.diemrenluyen;

public class khoadomain {
    private int idkhoa;
    private String tenkhoa;

    public khoadomain(int idkhoa, String tenkhoa) {
        this.idkhoa = idkhoa;
        this.tenkhoa = tenkhoa;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }
}
