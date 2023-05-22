package com.example.quanlysv.servlet.entity;

import java.time.Instant;

public class ThanhPhanEntity {
    private String idTp,idDiem;
    private Integer diemCc,diemBt,diemThi,diemKt;
    private Long ngayTao,ngaySua;
    public Long GetCurrentTime(Instant instant){
        Long timestamp = instant.toEpochMilli();
        return timestamp;
    }

    public ThanhPhanEntity() {
    }

    public ThanhPhanEntity(String idTp, String idDiem, Integer diemCc, Integer diemBt, Integer diemThi, Integer diemKt, Long ngayTao, Long ngaySua) {
        this.idTp = idTp;
        this.idDiem = idDiem;
        this.diemCc = diemCc;
        this.diemBt = diemBt;
        this.diemThi = diemThi;
        this.diemKt = diemKt;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public String getIdTp() {
        return idTp;
    }

    public void setIdTp(String idTp) {
        this.idTp = idTp;
    }

    public String getIdDiem() {
        return idDiem;
    }

    public void setIdDiem(String idDiem) {
        this.idDiem = idDiem;
    }


    public Integer getDiemCc() {
        return diemCc;
    }

    public void setDiemCc(Integer diemCc) {
        this.diemCc = diemCc;
    }

    public Integer getDiemBt() {
        return diemBt;
    }

    public void setDiemBt(Integer diemBt) {
        this.diemBt = diemBt;
    }

    public Integer getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(Integer diemThi) {
        this.diemThi = diemThi;
    }

    public Integer getDiemKt() {
        return diemKt;
    }

    public void setDiemKt(Integer diemKt) {
        this.diemKt = diemKt;
    }

    public void setNgayTao(Long ngayTao) {
        this.ngayTao = ngayTao;
    }

    public void setNgaySua(Long ngaySua) {
        this.ngaySua = ngaySua;
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
        return "ThanhPhanEntity{" +
                "idTp='" + idTp + '\'' +
                ", idDiem='" + idDiem + '\'' +
                ", diemCc=" + diemCc +
                ", diemBt=" + diemBt +
                ", diemThi=" + diemThi +
                ", diemKt=" + diemKt +
                ", ngayTao=" + ngayTao +
                ", ngaySua=" + ngaySua +
                '}';
    }
}
