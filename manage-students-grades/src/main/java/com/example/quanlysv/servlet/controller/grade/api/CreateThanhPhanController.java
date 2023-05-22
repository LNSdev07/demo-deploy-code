package com.example.quanlysv.servlet.controller.grade.api;

import com.example.quanlysv.servlet.dto.request.thanhphan.CreateThanhPhanDTO;
import com.example.quanlysv.servlet.service.ThanhPhanService;
import com.example.quanlysv.servlet.service.impl.ThanhPhanServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/thanh-phan/create-or-edit")
public class CreateThanhPhanController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public ThanhPhanService thanhPhanService;
    public CreateThanhPhanController() {
        this.thanhPhanService = new ThanhPhanServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idDiem = req.getParameter("idDiem");
        String idLop = req.getParameter("idLop");
        Integer cc=Integer.valueOf(req.getParameter("chuyen_can"));
        Integer bt=Integer.valueOf(req.getParameter("bai_tap"));
        Integer thi=Integer.valueOf(req.getParameter("thi"));
        Integer kiem_tra=Integer.valueOf(req.getParameter("kiem_tra"));


        CreateThanhPhanDTO requestThanhPhan = new CreateThanhPhanDTO(idDiem,idDiem,cc,bt,thi,kiem_tra);
        System.out.println(requestThanhPhan.toString());
        thanhPhanService.createThanhPhan(requestThanhPhan);

        req.setAttribute("showDialog", true);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/home/admin/grade/add_grade.jsp");
        dispatcher.forward(req, resp);
    }
}
