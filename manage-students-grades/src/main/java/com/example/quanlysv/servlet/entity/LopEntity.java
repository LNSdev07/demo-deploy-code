package com.example.quanlysv.servlet.entity;

import java.time.Instant;

public class LopEntity {
    private String idLop,tenLop,idKhoa,idHk;
    private Long ngayTao,ngaySua;
    public Long GetCurrentTime(Instant instant){
        Long timestamp = instant.toEpochMilli();
        return timestamp;
    }
    public LopEntity(){

    }

    public String getIdHk() {
        return idHk;
    }

    public void setIdHk(String idHk) {
        this.idHk = idHk;
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
    public LopEntity(String idLop, String tenLop, String idKhoa, Long ngayTao, Long ngaySua) {
        this.idLop = idLop;
        this.tenLop = tenLop;
        this.idKhoa = idKhoa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }
}