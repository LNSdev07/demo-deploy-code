package com.example.quanlysv.servlet.dto.request.teacher;

import com.example.quanlysv.servlet.dto.request.BaseRequest;

public class TeacherFilter {
    private BaseRequest baseRequest;
    private  String idGv,tenGv;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public String getIdGv() {
        return idGv;
    }

    public void setIdGv(String idGv) {
        this.idGv = idGv;
    }

    public String getTenGv() {
        return tenGv;
    }

    public void setTenGv(String tenGv) {
        this.tenGv = tenGv;
    }
}
