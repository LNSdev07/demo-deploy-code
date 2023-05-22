package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.student.StudentDTO;
import com.example.quanlysv.servlet.dto.request.student.StudentFilter;
import com.example.quanlysv.servlet.entity.StudentEntity;

import java.util.List;

public interface IStudentDao  extends IGenericDao<StudentEntity> {

   List<StudentEntity> findStudent(StudentFilter request);

   Integer countTotalRecords(StudentFilter request);

   void createOrUpdateStudent (StudentEntity studentEntity);

   boolean existedByEmailAndIdSvAndPhone(String id, String email, String phone);

   StudentEntity getById(String id);

   void deleteStudentById(String id);

   List<StudentEntity>findListStudentByIdLop(String idLop);
}
