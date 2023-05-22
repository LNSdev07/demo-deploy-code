package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IRoleDao;
import com.example.quanlysv.servlet.dao.impl.RoleDaoImpl;
import com.example.quanlysv.servlet.entity.RoleEntity;
import com.example.quanlysv.servlet.service.IRoleService;
import org.apache.log4j.Logger;

public class RoleServiceImpl implements IRoleService {
    private static final org.apache.log4j.Logger log =
            Logger.getLogger(RoleServiceImpl.class.getName());

    private IRoleDao iRoleDao;

    public RoleServiceImpl(){
        this.iRoleDao = new RoleDaoImpl();
    }

    @Override
    public RoleEntity findRoleWithId(Long id) {
        try {
            return iRoleDao.findRoleWithId(id);
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
    }
}
