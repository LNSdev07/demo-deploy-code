package com.example.quanlysv.servlet.controller.student.api;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.IStudentService;
import com.example.quanlysv.servlet.service.impl.StudentServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/home/student")
public class StudentController extends HttpServlet {
    private IStudentService service;

    public StudentController(){
        this.service = new StudentServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        StudentFilter baseRequest = HttpUtil.of(req.getReader()).toModel(StudentFilter.class);
        BaseResponse<?> baseResponse = service.findStudent(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String idSv = req.getParameter("idSv");
        BaseResponse<?> baseResponse = service.getStudentById(idSv);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String idSv = req.getParameter("idSv");
        BaseResponse<?> baseResponse = service.deleteStudentById(idSv);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
