package com.example.quanlysv.servlet.dto.request.diem;

import com.example.quanlysv.servlet.dto.request.BaseRequest;

public class GradeFilter {
    private BaseRequest baseRequest;
    private String idLop;

    public BaseRequest getBaseRequest() {
        return baseRequest;
    }

    public void setBaseRequest(BaseRequest baseRequest) {
        this.baseRequest = baseRequest;
    }

    public String getIdLop() {
        return idLop;
    }

    public void setIdLop(String idLop) {
        this.idLop = idLop;
    }
}
