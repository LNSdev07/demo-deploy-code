package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.dto.request.BaseRequest;
import com.example.quanlysv.servlet.dto.request.subject.SubjectFilter;
import com.example.quanlysv.servlet.entity.SubjectEntity;
import java.util.List;

public interface ISubjectDao {

    List<SubjectEntity> findSubject(SubjectFilter baseRequest);

    Integer countTotalRecords(SubjectFilter baseRequest);

    boolean exitsByIdOrName(String id, String name);


    boolean existById(String id);
    void createOrUpdateSubject(SubjectEntity subjectEntity);

    void deleteSubject(String id);
}
