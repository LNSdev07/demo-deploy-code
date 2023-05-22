package com.example.quanlysv.servlet.controller.grade.api;

import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.ThanhPhanService;
import com.example.quanlysv.servlet.service.impl.ThanhPhanServiceImpl;
import com.example.quanlysv.servlet.util.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/thanh-phan/get")

public class ThanhPhanController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ThanhPhanService thanhPhanService;
    public ThanhPhanController() {
        this.thanhPhanService = new ThanhPhanServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String idDiem = req.getParameter("idDiem");
        BaseResponse<?> baseResponse = thanhPhanService.getThanhPhanByIdDiem(idDiem);
        ResponseUtils.responseApi(req, resp, baseResponse);

    }
}
