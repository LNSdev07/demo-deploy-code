package com.example.quanlysv.servlet.controller.hocky.api;


import com.example.quanlysv.servlet.dto.request.kyhoc.CreateOrEditSemesterDTO;
import com.example.quanlysv.servlet.dto.request.kyhoc.SemesterDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.IHocKyService;
import com.example.quanlysv.servlet.service.impl.HocKyServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/home/semester/create-or-edit")
public class CreateOrEditSemesterController extends HttpServlet {

    private IHocKyService service;

    public CreateOrEditSemesterController(){
        this.service = new HocKyServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CreateOrEditSemesterDTO semesterDTO = HttpUtil.of(req.getReader()).toModel(CreateOrEditSemesterDTO.class);
        BaseResponse<?> baseResponse = service.createOrEdit(semesterDTO);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CreateOrEditSemesterDTO semesterDTO = HttpUtil.of(req.getReader()).toModel(CreateOrEditSemesterDTO.class);
        BaseResponse<?> baseResponse = service.createOrEdit(semesterDTO);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

}
