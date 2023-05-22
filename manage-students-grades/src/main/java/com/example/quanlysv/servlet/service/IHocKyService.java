package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.kyhoc.CreateOrEditSemesterDTO;
import com.example.quanlysv.servlet.dto.request.kyhoc.SemesterDTO;
import com.example.quanlysv.servlet.dto.response.BaseResponse;

public interface IHocKyService {
     BaseResponse<?> createOrEdit(CreateOrEditSemesterDTO semesterDTO);

     BaseResponse<?> findSemester(BaseRequest request);

     BaseResponse<?> findSemesterById(String id);

     BaseResponse<?> deleteSemester(String id);
}
