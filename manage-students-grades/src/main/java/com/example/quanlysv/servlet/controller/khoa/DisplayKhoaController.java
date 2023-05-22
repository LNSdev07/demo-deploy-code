package com.example.quanlysv.servlet.controller.khoa;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.khoa.KhoaDTO;
import com.example.quanlysv.servlet.service.IKhoaService;
import com.example.quanlysv.servlet.service.impl.KhoaServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;

@WebServlet("/home/khoa/display")
public class DisplayKhoaController extends HttpServlet {
    private IKhoaService service;

    public DisplayKhoaController(IKhoaService service){
        this.service=new KhoaServiceImpl();
    }

    public List<KhoaDTO>findKhoa(){
        BaseRequest request= new BaseRequest();
        request.setPageIndex(0);
        request.setPageSize(7);
        request.setSortField("tenKhoa");
        request.setSortOrder("desc");
        return service.findKhoa(request);
    }
}
