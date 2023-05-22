package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.SubjectEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class SubjectMapper implements IRowMapper<SubjectEntity>{
    @Override
    public SubjectEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new SubjectEntity(), resultSet);
    }
}
