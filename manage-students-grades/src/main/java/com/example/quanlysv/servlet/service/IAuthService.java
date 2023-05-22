package com.example.quanlysv.servlet.service;

import com.example.quanlysv.servlet.entity.AccountEntity;

public interface IAuthService {
    AccountEntity findAccountByUsernameAndPassword(String username);


    boolean checkPassword(String username, String password);

    boolean changePassword(String username, String pass);

    String changePassDefault(String username, String passNew, String  passAgain);

    boolean checkPassDefault(String username, String pass);


}
