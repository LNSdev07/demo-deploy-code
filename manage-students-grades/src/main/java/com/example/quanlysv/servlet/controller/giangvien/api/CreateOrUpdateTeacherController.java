package com.example.quanlysv.servlet.controller.giangvien.api;

import com.example.quanlysv.servlet.dto.request.teacher.CreateOrEditTeacherDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.ITeacherService;
import com.example.quanlysv.servlet.service.impl.TeacherServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/home/teacher/create-or-edit")
public class CreateOrUpdateTeacherController extends HttpServlet {
    private ITeacherService service;

    public CreateOrUpdateTeacherController(){this.service=new TeacherServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CreateOrEditTeacherDTO baseRequest= HttpUtil.of(req.getReader()).toModel(CreateOrEditTeacherDTO.class);
        BaseResponse<?> baseResponse=service.createOrEditTeacher(baseRequest);
        ResponseUtils.responseApi(req,resp,baseResponse);
    }
}
