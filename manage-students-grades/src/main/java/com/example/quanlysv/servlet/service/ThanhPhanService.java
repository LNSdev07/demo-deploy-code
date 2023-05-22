package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.dto.request.thanhphan.CreateThanhPhanDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;

public interface ThanhPhanService {
    void createThanhPhan (CreateThanhPhanDTO createThanhPhanDTO);
    BaseResponse<?> getThanhPhanByIdDiem(String idDiem);

}
