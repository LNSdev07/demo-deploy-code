package com.example.quanlysv.servlet.dto.request.subject;

public class CreateOrEditSubjectDTO {
    private String idMh;
    private String tenMonHoc;

    private Integer tinChi;

    private String idKhoa;

    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
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

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }
}
