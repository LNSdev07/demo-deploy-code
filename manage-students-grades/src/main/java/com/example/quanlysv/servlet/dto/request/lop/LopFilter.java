package com.example.quanlysv.servlet.dto.request.lop;

import com.example.quanlysv.servlet.dto.request.BaseRequest;

public class LopFilter {
    private BaseRequest baseRequest;
    private String idKhoa;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public String getIdKhoa() {
        return idKhoa;
    }

    public void setIdKhoa(String idKhoa) {
        this.idKhoa = idKhoa;
    }
}
