package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.StudentEntity;
import com.example.quanlysv.servlet.entity.ThanhPhanEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class ThanhPhanMapper implements IRowMapper<ThanhPhanEntity> {
    @Override
    public ThanhPhanEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new ThanhPhanEntity(), resultSet);
    }
}
