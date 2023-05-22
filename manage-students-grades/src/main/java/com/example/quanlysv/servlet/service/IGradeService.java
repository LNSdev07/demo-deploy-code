package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.diem.CreateOrEditGradeDTO;
import com.example.quanlysv.servlet.dto.request.diem.GradeFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;
import com.example.quanlysv.servlet.entity.GradeEntity;

public interface IGradeService {
    BaseResponse<?> nhapDiem(GradeEntity gradeEntity);
    void createOrUpdateGrade(CreateOrEditGradeDTO createOrEditGradeDTO);

    BaseResponse<?>getGrade(BaseRequest request,String idLop);

    BaseResponse<?>viewGradeByIdLop(GradeFilter request);

}