package com.example.quanlysv.servlet.dto.request.teacher;

public class TeacherDTO {
    private String idGv,tenGv,sdtGv,emailGv,genderGv,idKhoa,tenKhoa;
    private String ngayTao,ngaySua;
    private Integer trangThai;

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getIdGv() {
        return idGv;
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

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    @Override
    public String toString() {
        return "TeacherDTO{" +
                "idGv='" + idGv + '\'' +
                ", tenGv='" + tenGv + '\'' +
                ", sdtGv='" + sdtGv + '\'' +
                ", emailGv='" + emailGv + '\'' +
                ", genderGv='" + genderGv + '\'' +
                ", idKhoa='" + idKhoa + '\'' +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngaySua='" + ngaySua + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
