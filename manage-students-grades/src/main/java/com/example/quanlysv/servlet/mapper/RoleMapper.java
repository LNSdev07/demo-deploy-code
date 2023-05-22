package com.example.quanlysv.servlet.mapper;
import com.example.quanlysv.servlet.entity.RoleEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class RoleMapper implements IRowMapper<RoleEntity>{
    @Override
    public RoleEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new RoleEntity(), resultSet);
    }
}
