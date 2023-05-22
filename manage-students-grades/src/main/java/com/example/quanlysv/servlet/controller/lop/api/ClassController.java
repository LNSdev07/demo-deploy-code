package com.example.quanlysv.servlet.controller.lop.api;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.lop.LopDTO;
import com.example.quanlysv.servlet.dto.request.lop.LopFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.service.ILopService;
import com.example.quanlysv.servlet.service.impl.LopServiceImpl;
import com.example.quanlysv.servlet.util.HttpUtil;
import com.example.quanlysv.servlet.util.ResponseUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/class")
public class ClassController extends HttpServlet {
    private ILopService service;

    public ClassController() {
        this.service = new LopServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String idKhoa = req.getParameter("idKhoa");
        BaseResponse<?> baseResponse = service.getLopByIdKhoa(idKhoa);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        LopFilter baseRequest = HttpUtil.of(req.getReader()).toModel(LopFilter.class);
        BaseResponse<?> baseResponse = service.findLop(baseRequest);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        LopDTO lopDTO = HttpUtil.of(req.getReader()).toModel(LopDTO.class);
        BaseResponse<?> baseResponse = service.createOrUpdateLop(lopDTO);
        ResponseUtils.responseApi(req, resp, baseResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        BaseResponse<?> baseResponse = service.deleteLopById(id);
        ResponseUtils.responseApi(req, resp, baseResponse);    }
}
