package com.example.quanlysv.servlet.dao.impl;

import com.example.quanlysv.servlet.dao.IAccountDao;
import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.mapper.AccountMapper;

import java.util.List;

public class AccountDaoImpl extends AbstractDao<AccountEntity> implements IAccountDao {


    @Override
    public AccountEntity findAccountByUsernameAndPassword(String username) {
        String sql = "select tk.id as id, tk.username as username, " +
                "tk.password as password, tk.email as email, " +
                "tk.role_id as roleId, tk.status_password_default as statusPasswordDefault, tk.verification as verification" +
                " from taikhoan as tk where username=?";
        List<AccountEntity> accountEntities = findByProperties(sql, new AccountMapper(), username);
        return accountEntities.isEmpty() ? null : accountEntities.get(0);
    }

    @Override
    public  AccountEntity existEmailUser(String email) {
        String sql = "select tk.id as id, tk.username as username, " +
                "tk.password as password, tk.email as email, " +
                "tk.role_id as roleId, tk.status_password_default as statusPasswordDefault" +
                " from taikhoan as tk where email=?";
        AccountEntity accountEntity = findOne(sql, new AccountMapper(), email);
        return accountEntity;
    }

    @Override
    public boolean changePass(String pass, String username) {
        try {
            String sql = "update taikhoan set password =? where username = ?";
            return update(sql, pass, username );
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateVerification(String verification, String username) {
        try {
            String sql = "update taikhoan set verification =? where username = ?";
            return update(sql, verification, username );
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean changePassDefault(String pass, String username) {
        try {
            String sql = "update taikhoan set password =?, status_password_default = ? where username = ?";
            return update(sql, pass, 1, username );
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean checkPassDefault(String username, String pass) {
        String sql = "select tk.id as id, tk.username as username, " +
                "tk.password as password, tk.email as email, " +
                "tk.role_id as roleId, tk.status_password_default as statusPasswordDefault" +
                " from taikhoan as tk where username=? and password =?";
        List<AccountEntity> accountEntities = findByProperties(sql, new AccountMapper(), username, pass);
        if(accountEntities.size() > 0) return true;
        return false;
    }
}
