package com.example.quanlysv.servlet.entity;

public class KhoaEntity {
    private String idKhoa;
    private String tenKhoa;

    public KhoaEntity(){

    }
    public KhoaEntity(String idKhoa, String tenKhoa) {
        this.idKhoa = idKhoa;
        this.tenKhoa = tenKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    @Override
    public String toString() {
        return "KhoaEntity{" +
                "idKhoa='" + idKhoa + '\'' +
                ", tenKhoa='" + tenKhoa + '\'' +
                '}';
    }
}
