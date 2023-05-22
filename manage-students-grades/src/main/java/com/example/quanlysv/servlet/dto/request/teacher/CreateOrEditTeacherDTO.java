package com.example.quanlysv.servlet.dto.request.teacher;

public class CreateOrEditTeacherDTO {
    private int status;

    private String idGv,tenGv,sdtGv,emailGv,genderGv,idKhoa;

    public String getIdGv() {
        return idGv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdGv(String idGv) {
        this.idGv = idGv;
    }

    public String getTenGv() {
        return tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }

    public String getSdtGv() {
        return sdtGv;
    }

    public void setSdtGv(String sdtGv) {
        this.sdtGv = sdtGv;
    }

    public String getEmailGv() {
        return emailGv;
    }

    public void setEmailGv(String emailGv) {
        this.emailGv = emailGv;
    }

    public String getGenderGv() {
        return genderGv;
    }

    public void setGenderGv(String genderGv) {
        this.genderGv = genderGv;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }
}
