package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.StudentEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class StudentMapper  implements IRowMapper<StudentEntity>{
    @Override
    public StudentEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new StudentEntity(), resultSet);
    }
}
