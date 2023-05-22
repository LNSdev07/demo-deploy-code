package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.GradeEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class GradeMapper implements IRowMapper<GradeEntity> {

    @Override
    public GradeEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new GradeEntity(),resultSet);
    }
}