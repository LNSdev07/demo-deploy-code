package com.example.quanlysv.servlet.controller.subject;

import com.example.quanlysv.servlet.dto.request.student.CreateOrEditStudentDTO;
import com.example.quanlysv.servlet.dto.request.subject.CreateOrEditSubjectDTO;
import com.example.quanlysv.servlet.dto.request.subject.SubjectDTO;
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

@WebServlet("/api/admin/home/subject/create-or-edit")
public class CreateOrEditSubjectController extends HttpServlet {

    private final ISubjectService service;

    public CreateOrEditSubjectController(){
        this.service = new SubjectServiceImpl();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        CreateOrEditSubjectDTO baseRequest = HttpUtil.of(req.getReader()).toModel(CreateOrEditSubjectDTO.class);
        BaseResponse<?> baseResponse = service.createOrUpdateSubject(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
