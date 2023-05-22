package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.dto.request.teacher.TeacherFilter;
import com.example.quanlysv.servlet.entity.TeacherEntity;

import java.util.List;

public interface ITeacherDao extends IGenericDao<TeacherEntity> {
    void createOrEditTeacher(TeacherEntity teacherEntity);
    List<TeacherEntity> findTeacher(TeacherFilter baseRequest);
    Integer countTotalRecords(TeacherFilter request);
    void deleteTeacher(String id);
    TeacherEntity getById(String id);

    boolean existedByIdOrEmailOrPhone(String id, String email, String phoneNum);
}
