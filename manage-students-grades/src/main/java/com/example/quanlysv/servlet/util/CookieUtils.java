package com.example.quanlysv.servlet.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;

public class CookieUtils {
    private static CookieUtils cookieUtils = null;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("auth");

    public static CookieUtils getInstance(){
        if(cookieUtils == null) cookieUtils = new CookieUtils();
        return cookieUtils;
    }
    public void addCookie(HttpServletResponse response, HttpServletRequest request){
        Cookie cookie = new Cookie(resourceBundle.getString("key_cookie"), request.getSession().getId());
        cookie.setMaxAge(Integer.parseInt(resourceBundle.getString("time_expired_cookie")));
        cookie.setHttpOnly(true); // chỉ cho phép truy cập cookie từ phía server, không cho phép client-side scripting
        HttpSession session = request.getSession();
        session.setAttribute("cookie_name",cookie.getName());
        session.setAttribute("cookie_value",cookie.getValue());
        response.addCookie(cookie);
    }

    public Object getValue(HttpServletRequest request, String key){
        return request.getSession().getAttribute(key);
    }
    public void removeValue(HttpServletRequest request, HttpServletResponse response, String key){
        request.getSession().removeAttribute(key);
        addCookie(response, null);
    }

}
