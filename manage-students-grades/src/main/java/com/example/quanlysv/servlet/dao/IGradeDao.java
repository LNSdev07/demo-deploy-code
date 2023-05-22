package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.diem.GradeFilter;
import com.example.quanlysv.servlet.entity.GradeEntity;

import java.util.List;

public interface IGradeDao extends IGenericDao<GradeEntity> {
    void nhapDiem(GradeEntity gradeEntity);
    void createOrUpdateGrade(GradeEntity gradeEntity);
    List<GradeEntity> findDiem(BaseRequest request,String idLop);

    List<GradeEntity>viewGradeByIdLop(GradeFilter request);

    Integer countTotalRecords(GradeFilter request);
}