package com.example.quanlysv.servlet.dto.request.kyhoc;

public class CreateOrEditSemesterDTO {
    private int status;
    private String idHk;
    private String tenHocKy;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
