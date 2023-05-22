package com.example.quanlysv.servlet.dto.request.student;

public class StudentDTO {
    private String idSv;
    private String tenSv;
    private String emailSv;
    private String dobSv;
    private String genderSv;
    private String phoneSv;
    private String lopHanhChinhSv;

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    private Integer trangThai;

    private String ngayTao;
    private String ngaySua;

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

    public String getIdSv() {
        return idSv;
    }

    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getEmailSv() {
        return emailSv;
    }

    public void setEmailSv(String emailSv) {
        this.emailSv = emailSv;
    }

    public String getDobSv() {
        return dobSv;
    }

    public void setDobSv(String dobSv) {
        this.dobSv = dobSv;
    }

    public String getGenderSv() {
        return genderSv;
    }

    public void setGenderSv(String genderSv) {
        this.genderSv = genderSv;
    }

    public String getPhoneSv() {
        return phoneSv;
    }

    public void setPhoneSv(String phoneSv) {
        this.phoneSv = phoneSv;
    }

    public String getLopHanhChinhSv() {
        return lopHanhChinhSv;
    }

    public void setLopHanhChinhSv(String lopHanhChinhSv) {
        this.lopHanhChinhSv = lopHanhChinhSv;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "idSv='" + idSv + '\'' +
                ", tenSv='" + tenSv + '\'' +
                ", emailSv='" + emailSv + '\'' +
                ", dobSv='" + dobSv + '\'' +
                ", genderSv='" + genderSv + '\'' +
                ", phoneSv='" + phoneSv + '\'' +
                ", lopHanhChinhSv='" + lopHanhChinhSv + '\'' +
                ", trangThai=" + trangThai +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngaySua='" + ngaySua + '\'' +
                '}';
    }
}
