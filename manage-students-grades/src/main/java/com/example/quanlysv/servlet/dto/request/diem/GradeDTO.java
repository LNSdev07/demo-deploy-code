package com.example.quanlysv.servlet.dto.request.diem;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class GradeDTO {
    private String idDiem,idGv,idMh,idSv,idHk,idLop, ngayTao,ngaySua;
    private Double diemCc,diemBt,diemThi,diemKt;

    public String convertTimeFromLongToString(Long timestamp){
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());

        // Format LocalDateTime as string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedTime = dateTime.format(formatter);

        return formattedTime;
    }

//    public GradeDTO(String idDiem, String idGv, String idMh, String idSv, String idHk, String idLop, Long ngayTao, Long ngaySua, Double diemCc, Double diemBt, Double diemThi, Double diemKt) {
//        this.idDiem = idDiem;
//        this.idGv = idGv;
//        this.idMh = idMh;
//        this.idSv = idSv;
//        this.idHk = idHk;
//        this.idLop = idLop;
//        this.ngayTao = convertTimeFromLongToString(ngayTao);
//        this.ngaySua = convertTimeFromLongToString(ngaySua);
//        this.diemCc = diemCc;
//        this.diemBt = diemBt;
//        this.diemThi = diemThi;
//        this.diemKt = diemKt;
//    }


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

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }

    public String getNgayTao() {
        return ngayTao;
    }

//    public void setNgayTao(Long ngayTao) {
//
//        this.ngayTao = convertTimeFromLongToString(ngayTao);
//    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }


    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }


//    public void setNgaySua(Long ngaySua) {
//        this.ngaySua = convertTimeFromLongToString(ngaySua);
//    }

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

    @Override
    public String toString() {
        return "GradeDTO{" +
                "idDiem='" + idDiem + '\'' +
                ", idGv='" + idGv + '\'' +
                ", idMh='" + idMh + '\'' +
                ", idSv='" + idSv + '\'' +
                ", idHk='" + idHk + '\'' +
                ", idLop='" + idLop + '\'' +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngaySua='" + ngaySua + '\'' +
                ", diemCc=" + diemCc +
                ", diemBt=" + diemBt +
                ", diemThi=" + diemThi +
                ", diemKt=" + diemKt +
                '}';
    }
}
