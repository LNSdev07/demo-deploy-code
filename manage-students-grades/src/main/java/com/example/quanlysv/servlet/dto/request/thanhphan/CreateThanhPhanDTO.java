package com.example.quanlysv.servlet.dto.request.thanhphan;

public class CreateThanhPhanDTO {
    private String idTp,idDiem;
    private Integer diemCc,diemBt,diemThi,diemKt;


    public CreateThanhPhanDTO(String idTp, String idDiem, Integer diemCc, Integer diemBt, Integer diemThi, Integer diemKt) {
        this.idTp = idTp;
        this.idDiem = idDiem;
        this.diemCc = diemCc;
        this.diemBt = diemBt;
        this.diemThi = diemThi;
        this.diemKt = diemKt;
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

    @Override
    public String toString() {
        return "CreateThanhPhanDTO{" +
                "idTp='" + idTp + '\'' +
                ", idDiem='" + idDiem + '\'' +
                ", diemCc=" + diemCc +
                ", diemBt=" + diemBt +
                ", diemThi=" + diemThi +
                ", diemKt=" + diemKt +
                '}';
    }
}
