package com.example.quanlysv.servlet.entity;

import java.time.Instant;

public class TeacherEntity {
    private String idGv,tenGv,sdtGv,emailGv,genderGv,idKhoa,tenKhoa;
    private Long ngayTao,ngaySua;
    private Integer trangThai;

    public Long GetCurrentTime(Instant instant){
        Long timestamp = instant.toEpochMilli();
        return timestamp;
    }
    public TeacherEntity(){

    }

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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Long getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Instant instant) {
        this.ngayTao = GetCurrentTime(instant);
    }

    public Long getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Instant instant) {
        this.ngaySua = GetCurrentTime(instant);
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "idGv='" + idGv + '\'' +
                ", tenGv='" + tenGv + '\'' +
                ", sdtGv='" + sdtGv + '\'' +
                ", emailGv='" + emailGv + '\'' +
                ", genderGv='" + genderGv + '\'' +
                ", idKhoa='" + idKhoa + '\'' +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
