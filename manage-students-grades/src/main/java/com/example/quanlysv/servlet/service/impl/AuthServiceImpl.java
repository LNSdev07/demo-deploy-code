package com.example.quanlysv.servlet.service.impl;

import com.example.quanlysv.servlet.dao.IAccountDao;
import com.example.quanlysv.servlet.dao.impl.AccountDaoImpl;
import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.service.IAuthService;
import org.mindrot.jbcrypt.BCrypt;

public class AuthServiceImpl implements IAuthService {


   private IAccountDao accountDao;

   public AuthServiceImpl(){
       accountDao = new AccountDaoImpl();
   }


    @Override
    public AccountEntity findAccountByUsernameAndPassword(String username) {
        return accountDao.findAccountByUsernameAndPassword(username);
    }

    @Override
    public boolean checkPassword(String username, String password) {
        AccountEntity accountEntity = findAccountByUsernameAndPassword(username);
        if(accountEntity == null) return false;
        String passwordOld =accountEntity.getPassword();
        return BCrypt.checkpw(password, passwordOld);
    }

    @Override
    public boolean changePassword(String username, String pass) {
          try {
              String passwordNew = BCrypt.hashpw(pass, BCrypt.gensalt());
              return accountDao.changePass(passwordNew, username);
          }catch (Exception e){
              System.out.println(e.getMessage());
              return false;
          }
    }

    @Override
    public String changePassDefault(String username, String passNew, String passAgain) {
        try {
            if(!validate(passNew, passAgain).equals("ok")) return validate(passNew, passAgain);
            AccountEntity accountEntity = findAccountByUsernameAndPassword(username);
            if(accountEntity == null) return "Người dùng không tồn tại!";

            String passwordNew = BCrypt.hashpw(passNew, BCrypt.gensalt());
            boolean res =  accountDao.changePassDefault(passwordNew, username);
            if(res) return "ok";
            return "Thay đôi mật khẩu thất bại";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "Không thể thay đổi mật khẩu";
        }
    }

    @Override
    public boolean checkPassDefault(String username, String pass) {
        return accountDao.checkPassDefault(username, pass);
    }


    private String validate(String passNew, String passAgain){
       if(passNew.length() < 8 || passAgain.length() < 8 ) return "Mật khẩu không được nhỏ hơn 8 kí tự!";
       else if(!passNew.equals(passAgain)) return "Mật khẩu nhập lại không trùng khớp!";
       return "ok";
    }
}
