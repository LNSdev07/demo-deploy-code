package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.mapper.IRowMapper;

import java.util.List;

public interface IGenericDao<T> {
    List<T> findByProperties(String sql, IRowMapper<T> mapper, Object... params);

}
