package com.example.diemrenluyen;

public class lopdomain {
    private int idlop;
    private int idkhoa;
    private String tenlop;

    public lopdomain(int idlop, int idkhoa, String tenlop) {
        this.idlop = idlop;
        this.idkhoa = idkhoa;
        this.tenlop = tenlop;
    }

    public int getIdlop() {
        return idlop;
    }

    public void setIdlop(int idlop) {
        this.idlop = idlop;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }
}
