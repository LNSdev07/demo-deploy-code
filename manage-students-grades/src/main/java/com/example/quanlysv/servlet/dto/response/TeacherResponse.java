package com.example.quanlysv.servlet.dto.response;

public class TeacherResponse {
    private String idGv,tenGv,sdtGv,emailGv,genderGv,idKhoa,tenKhoa;
    private Long ngayTao,ngaySua;

    public TeacherResponse(String idGv, String tenGv, String sdtGv, String emailGv, String genderGv, String tenKhoa, Long ngayTao, Long ngaySua) {
        this.idGv = idGv;
        this.tenGv = tenGv;
        this.sdtGv = sdtGv;
        this.emailGv = emailGv;
        this.genderGv = genderGv;
        this.tenKhoa = tenKhoa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

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
}
