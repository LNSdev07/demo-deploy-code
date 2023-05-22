package com.example.quanlysv.servlet.dto.request.kyhoc;

public class SemesterDTO {
    private int status;
    private String idHk;
    private String tenHocKy;

    private String ngayTao;
    private String ngaySua;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
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
