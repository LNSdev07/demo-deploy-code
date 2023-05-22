package com.example.quanlysv.servlet.entity;

import java.time.Instant;

public class GradeEntity {
    private String idDiem,idGv,idMh,idSv,idHk,idLop;
    private Double diemCc,diemBt,diemThi,diemKt;
    private Long ngayTao,ngaySua;
    public Long GetCurrentTime(Instant instant){
        Long timestamp = instant.toEpochMilli();
        return timestamp;
    }
    public GradeEntity() {
    }

    public GradeEntity(Double diemCc, Double diemBt, Double diemThi, Double diemKt, Long ngayTao, Long ngaySua) {
        this.diemCc = diemCc;
        this.diemBt = diemBt;
        this.diemThi = diemThi;
        this.diemKt = diemKt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(String idDiem) {
        this.idDiem = idDiem;
    }

    public String getIdGv() {
        return idGv;
    }

    public void setIdGv(String idGv) {
        this.idGv = idGv;
    }

    public String getIdMh() {
        return idMh;
    }

    public void setIdMh(String idMh) {
        this.idMh = idMh;
    }

    public String getIdSv() {
        return idSv;
    }

    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }

    public String getIdHk() {
        return idHk;
    }

    public void setIdHk(String idHk) {
        this.idHk = idHk;
    }

    public Double getDiemCc() {
        return diemCc;
    }

    public void setDiemCc(Double diemCc) {
        this.diemCc = diemCc;
    }

    public Double getDiemBt() {
        return diemBt;
    }

    public void setDiemBt(Double diemBt) {
        this.diemBt = diemBt;
    }

    public Double getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(Double diemThi) {
        this.diemThi = diemThi;
    }

    public Double getDiemKt() {
        return diemKt;
    }

    public void setDiemKt(Double diemKt) {
        this.diemKt = diemKt;
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
        return "GradeEntity{" +
                "idDiem='" + idDiem + '\'' +
                ", idGv='" + idGv + '\'' +
                ", idMh='" + idMh + '\'' +
                ", idSv='" + idSv + '\'' +
                ", idHk='" + idHk + '\'' +
                ", diemCc=" + diemCc +
                ", diemBt=" + diemBt +
                ", diemThi=" + diemThi +
                ", diemKt=" + diemKt +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}