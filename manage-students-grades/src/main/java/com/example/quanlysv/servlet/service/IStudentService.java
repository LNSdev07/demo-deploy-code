package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.student.CreateOrEditStudentDTO;
import com.example.quanlysv.servlet.dto.request.student.StudentDTO;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.dto.response.BaseResponse;

import java.util.List;

public interface IStudentService {

    BaseResponse<?> findStudent(StudentFilter request);


    BaseResponse<?> createOrUpdateStudent(CreateOrEditStudentDTO studentDTO);

    BaseResponse<?> getStudentById(String id);

    BaseResponse<?> deleteStudentById(String id);
}
