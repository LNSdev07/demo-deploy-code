package com.example.quanlysv.servlet.service;

public interface IForgotPassService {
        boolean existEmailUser(String email);

        boolean sendEmail(String emailFinish);

        boolean updateVerification(String verification, String username);
}
