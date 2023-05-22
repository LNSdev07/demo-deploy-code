package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.LopEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class LopMapper implements IRowMapper<LopEntity> {
    @Override
    public LopEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new LopEntity(),resultSet);
    }
}