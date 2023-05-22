package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.khoa.KhoaDTO;

import java.util.List;

public interface IKhoaService{
    List<KhoaDTO> findKhoa(BaseRequest request);
}
