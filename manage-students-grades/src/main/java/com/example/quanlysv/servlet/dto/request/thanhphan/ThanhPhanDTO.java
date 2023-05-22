package com.example.quanlysv.servlet.dto.request.thanhphan;

public class ThanhPhanDTO {
    private String idTp,idDiem;
    private Integer diemCc,diemBt,diemThi,diemKt;
    private String ngayTao,ngaySua;

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

    @Override
    public String toString() {
        return "ThanhPhanDTO{" +
                "idTp='" + idTp + '\'' +
                ", idDiem='" + idDiem + '\'' +
                ", diemCc=" + diemCc +
                ", diemBt=" + diemBt +
                ", diemThi=" + diemThi +
                ", diemKt=" + diemKt +
                ", ngayTao='" + ngayTao + '\'' +
                ", ngaySua='" + ngaySua + '\'' +
                '}';
    }
}
