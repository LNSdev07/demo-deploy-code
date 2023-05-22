package com.example.quanlysv.servlet.dto.request.subject;

import com.example.quanlysv.servlet.dto.request.BaseRequest;

public class SubjectFilter {
    private BaseRequest baseRequest;
    private String tenMonHoc;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
}
