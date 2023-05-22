package com.example.quanlysv.servlet.entity;

public class HocKyEntity {
    private String idHk;
    private String tenHocKy;

    private Long ngayTao;

    private Long ngaySua;

    public Long getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Long getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Long ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getIdHk() {
        return idHk;
    }

    public void setIdHk(String idHk) {
        this.idHk = idHk;
    }

    public String getTenHocKy() {
        return tenHocKy;
    }

    public void setTenHocKy(String tenHocKy) {
        this.tenHocKy = tenHocKy;
    }
}
