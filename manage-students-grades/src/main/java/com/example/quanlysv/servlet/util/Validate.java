package com.example.quanlysv.servlet.util;

public class Validate {
    public static String validatePass(String passNew, String passAgain, String passOld ){
        if(passNew.length() < 8 || passAgain.length() < 8) return "Mật khẩu phải dài hơn 8 kí tự!";
        else if(!passNew.equals(passAgain)) return "Mật khẩu nhập lại không trùng khớp!";
        else if(passNew.equals(passOld)) return "Mật khẩu mới trùng với mật khẩu hiện có!";
        return "ok";
    }
}
