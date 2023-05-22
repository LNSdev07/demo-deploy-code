package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.HocKyEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class HocKyMapper implements IRowMapper<HocKyEntity>{
    @Override
    public HocKyEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new HocKyEntity(), resultSet);
    }
}
