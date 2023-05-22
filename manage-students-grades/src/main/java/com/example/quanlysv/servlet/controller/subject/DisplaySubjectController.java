package com.example.quanlysv.servlet.controller.subject;


import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.dto.request.subject.SubjectDTO;
import com.example.quanlysv.servlet.dto.request.subject.SubjectFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.ISubjectService;
import com.example.quanlysv.servlet.service.impl.SubjectServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/admin/home/subject/display")
public class DisplaySubjectController extends HttpServlet {


    private ISubjectService service;

    public DisplaySubjectController(){
        this.service = new SubjectServiceImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        SubjectFilter baseRequest = HttpUtil.of(req.getReader()).toModel(SubjectFilter.class);
        BaseResponse<?> baseResponse = service.findSubject(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String idMh = req.getParameter("idMh");
        BaseResponse<?> baseResponse = service.deleteSubject(idMh);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
