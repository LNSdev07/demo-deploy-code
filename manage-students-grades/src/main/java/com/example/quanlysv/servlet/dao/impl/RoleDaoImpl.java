package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.common.Role;
import com.example.quanlysv.servlet.dao.IRoleDao;
import com.example.quanlysv.servlet.entity.RoleEntity;
import com.example.quanlysv.servlet.mapper.RoleMapper;

public class RoleDaoImpl extends AbstractDao<RoleEntity>  implements IRoleDao {

    @Override
    public RoleEntity findRoleWithId(Long id) {
        try{
            String sql ="select r.id as id, role_name as roleName from roles as r where id =?";
            RoleEntity role = findOne(sql,new RoleMapper(), id);
            return role== null? null: role;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
