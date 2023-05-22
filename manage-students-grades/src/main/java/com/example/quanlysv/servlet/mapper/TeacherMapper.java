package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.TeacherEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class TeacherMapper implements IRowMapper<TeacherEntity> {
    @Override
    public TeacherEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new TeacherEntity(),resultSet);
    }
}
