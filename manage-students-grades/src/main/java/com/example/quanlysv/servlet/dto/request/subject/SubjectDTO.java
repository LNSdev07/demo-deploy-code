package com.example.quanlysv.servlet.dto.request.subject;

public class SubjectDTO {
    private String idMh, tenMonHoc, idKhoa, tenKhoa, ngayTao, ngaySua;
    private Integer tinChi, trangThai;

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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }

    public String getIdMh() {
        return idMh;
    }

    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public Integer getTinChi() {
        return tinChi;
    }

    public void setTinChi(Integer tinChi) {
        this.tinChi = tinChi;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "idMh='" + idMh + '\'' +
                ", tenMonHoc='" + tenMonHoc + '\'' +
                ", idKhoa='" + idKhoa + '\'' +
                ", tenKhoa='" + tenKhoa + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngaySua='" + ngaySua + '\'' +
                ", tinChi=" + tinChi +
                ", trangThai=" + trangThai +
                '}';
    }
}
