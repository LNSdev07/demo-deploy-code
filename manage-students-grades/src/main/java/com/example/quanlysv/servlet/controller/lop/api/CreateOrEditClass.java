package com.example.quanlysv.servlet.controller.lop.api;

import com.example.quanlysv.servlet.dto.request.lop.LopDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.ILopService;
import com.example.quanlysv.servlet.service.impl.LopServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateOrEditClass extends HttpServlet {
    private ILopService service;

    public CreateOrEditClass() {
        this.service = new LopServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        LopDTO lopDTO = HttpUtil.of(req.getReader()).toModel(LopDTO.class);
        BaseResponse<?> baseResponse = service.createOrUpdateLop(lopDTO);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
