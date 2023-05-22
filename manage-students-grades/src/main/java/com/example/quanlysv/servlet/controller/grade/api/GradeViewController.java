package com.example.quanlysv.servlet.controller.grade.api;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.diem.GradeFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.IGradeService;
import com.example.quanlysv.servlet.service.impl.GradeServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/grade/view")

public class GradeViewController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public IGradeService service ;
    public GradeViewController() { this.service=new GradeServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        GradeFilter baseRequest = HttpUtil.of(req.getReader()).toModel(GradeFilter.class);
        BaseResponse<?> baseResponse = service.viewGradeByIdLop(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        GradeFilter baseRequest = HttpUtil.of(req.getReader()).toModel(GradeFilter.class);
        BaseResponse<?> baseResponse = service.viewGradeByIdLop(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
