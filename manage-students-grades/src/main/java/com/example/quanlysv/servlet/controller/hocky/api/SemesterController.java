package com.example.quanlysv.servlet.controller.hocky.api;


import com.example.quanlysv.servlet.dto.request.BaseRequest;
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


@WebServlet("/api/admin/home/semester")
public class SemesterController extends HttpServlet {

    private IHocKyService service;

    public SemesterController(){
        this.service = new HocKyServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        BaseRequest baseRequest = HttpUtil.of(req.getReader()).toModel(BaseRequest.class);
        BaseResponse<?> baseResponse = service.findSemester(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        BaseResponse<?> baseResponse = service.findSemesterById(id);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }
}
