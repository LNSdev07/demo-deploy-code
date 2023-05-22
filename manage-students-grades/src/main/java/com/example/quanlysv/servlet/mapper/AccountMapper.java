package com.example.quanlysv.servlet.mapper;

import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.util.MapUtils;

import java.sql.ResultSet;

public class AccountMapper implements IRowMapper<AccountEntity> {
    @Override
    public AccountEntity mapFromDbToClass(ResultSet resultSet) {
        return MapUtils.mapRowFromTableToClass(new AccountEntity(), resultSet);
    }
}
