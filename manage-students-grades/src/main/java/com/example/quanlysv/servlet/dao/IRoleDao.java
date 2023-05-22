package com.example.quanlysv.servlet.dao;

import com.example.quanlysv.servlet.entity.RoleEntity;

public interface IRoleDao {
    RoleEntity findRoleWithId(Long id);
}
