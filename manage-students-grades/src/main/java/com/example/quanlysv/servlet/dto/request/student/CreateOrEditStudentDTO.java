package com.example.quanlysv.servlet.dto.request.student;

public class CreateOrEditStudentDTO {
    private int status;
    private String idSv;
    private String tenSv;
    private String emailSv;
    private String dobSv;
    private String genderSv;
    private String phoneSv;
    private String lopHanhChinhSv;

    public String getIdSv() {
        return idSv;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIdSv(String idSv) {
        this.idSv = idSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public String getEmailSv() {
        return emailSv;
    }

    public void setEmailSv(String emailSv) {
        this.emailSv = emailSv;
    }

    public String getDobSv() {
        return dobSv;
    }

    public void setDobSv(String dobSv) {
        this.dobSv = dobSv;
    }

    public String getGenderSv() {
        return genderSv;
    }

    public void setGenderSv(String genderSv) {
        this.genderSv = genderSv;
    }

    public String getPhoneSv() {
        return phoneSv;
    }

    public void setPhoneSv(String phoneSv) {
        this.phoneSv = phoneSv;
    }

    public String getLopHanhChinhSv() {
        return lopHanhChinhSv;
    }

    public void setLopHanhChinhSv(String lopHanhChinhSv) {
        this.lopHanhChinhSv = lopHanhChinhSv;
    }
}
