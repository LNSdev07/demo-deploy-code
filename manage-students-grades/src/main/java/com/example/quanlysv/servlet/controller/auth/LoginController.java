package com.example.quanlysv.servlet.controller.auth;


import com.example.quanlysv.servlet.common.Constant;
import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.service.IAuthService;
import com.example.quanlysv.servlet.service.impl.AuthServiceImpl;
import com.example.quanlysv.servlet.util.CookieUtils;
import com.example.quanlysv.servlet.util.SessionUtils;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet("/auth/login")
public class LoginController extends HttpServlet {
    private IAuthService authService;
    public LoginController(){
        authService = new AuthServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie arr[] = req.getCookies();
        if(arr != null){
            for(Cookie o : arr){
                if(o.getName().equals("username")){
                    req.setAttribute("username", o.getValue());
                }
            }
        }
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        AccountEntity accountEntity = new AccountEntity();
        accountEntity = authService.findAccountByUsernameAndPassword(username);
        try {
            if(accountEntity != null
                    && accountEntity.getStatusPasswordDefault() == 0
                    && authService.checkPassDefault(username, password)) {
                SessionUtils.getInstance().putValue(req, "ACCOUNT", accountEntity);

                resp.sendRedirect("/home/common/change_password_default.jsp");
                return;
            }
        if(accountEntity != null &&
                BCrypt.checkpw(password, accountEntity.getPassword())){
            // lưu đăng nhập vào session
            SessionUtils.getInstance().putValue(req, "ACCOUNT", accountEntity);

            Cookie u = new Cookie("username", accountEntity.getUsername());
            u.setMaxAge(3600);
            resp.addCookie(u);

            ResourceBundle resourceBundle = ResourceBundle.getBundle("auth");
            CookieUtils.getInstance().addCookie(resp,req);
            Cookie cookie = new Cookie(resourceBundle.getString("key_cookie"), req.getSession().getId());
            HttpSession session = req.getSession();
            session.setAttribute("cookie_name",cookie.getName());
            session.setAttribute("cookie_value",cookie.getValue());

            if(accountEntity.getRoleId() == 1)
                req.getRequestDispatcher("/home/admin/home_admin/home_admin.jsp").forward(req, resp);
            else if (accountEntity.getRoleId() == 2) {
                req.getRequestDispatcher("/home/user/home_user/home_user.jsp").forward(req, resp);
            }
                else {
                    String errorMessage = "Người dùng chưa được phân quyền!";
                    req.setAttribute("errorMessage", errorMessage);
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            }
            else{
                String errorMessage = Constant.ERROR_LOGIN;
                req.setAttribute("errorMessage", errorMessage);
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        }catch (Exception e){
            String errorMessage = Constant.ERROR_LOGIN;
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
