package com.example.quanlysv.servlet.dto.request.student;

import com.example.quanlysv.servlet.dto.request.BaseRequest;

public class StudentFilter {
    private BaseRequest baseRequest;
    private String idSv;
    private String tenSv;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public String getIdSv() {
        return idSv;
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
}
