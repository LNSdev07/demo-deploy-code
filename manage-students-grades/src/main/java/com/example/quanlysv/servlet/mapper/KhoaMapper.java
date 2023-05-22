package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.KhoaEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class KhoaMapper implements IRowMapper<KhoaEntity> {
    @Override
    public KhoaEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new KhoaEntity(),resultSet);
    }
}
