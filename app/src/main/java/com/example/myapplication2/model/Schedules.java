package com.example.myapplication2.model;

public class Schedules {
    private String diadiem, ngayhoc, monhoc, mamonhoc;

    public Schedules() {
    }

    public Schedules(String diadiem, String ngayhoc, String monhoc, String mamonhoc) {
        this.diadiem = diadiem;
        this.ngayhoc = ngayhoc;
        this.monhoc = monhoc;
        this.mamonhoc = mamonhoc;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getNgayhoc() {
        return ngayhoc;
    }

    public void setNgayhoc(String ngayhoc) {
        this.ngayhoc = ngayhoc;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }
}
