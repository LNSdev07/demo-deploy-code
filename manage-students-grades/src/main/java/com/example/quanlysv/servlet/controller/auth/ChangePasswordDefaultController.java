package com.example.quanlysv.servlet.controller.auth;


import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.service.IAuthService;
import com.example.quanlysv.servlet.service.impl.AuthServiceImpl;
import com.example.quanlysv.servlet.util.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth/change-password-default")
public class ChangePasswordDefaultController extends HttpServlet {

    private final IAuthService authService;

    public ChangePasswordDefaultController() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String passNew = req.getParameter("passNew");
        String passAgain = req.getParameter("passAgain");

        HttpSession session = req.getSession(false);
        if (session != null) {
            AccountEntity accountEntity = (AccountEntity) SessionUtils.getInstance().getValue(req, "ACCOUNT");
            String message = authService.changePassDefault(accountEntity.getUsername(), passNew, passAgain);
            if(!message.equals("ok")){
                setValueForForm(req, passNew, passAgain, message);
                req.getRequestDispatcher("/home/common/change_password_default.jsp").forward(req, resp);
            }
            else{
                if(accountEntity.getRoleId() == 1) {
                    resp.sendRedirect("/home/admin/home_admin/home_admin.jsp");
                    return;
                }
                else if (accountEntity.getRoleId() == 2) {
                    resp.sendRedirect("/home/user/home_user/home_user.jsp");
                    return;
                }
            }
        }
        setValueForForm(req, passNew, passAgain, "Lỗi đăng nhập!");
        req.getRequestDispatcher("/home/common/change_password_default.jsp").forward(req, resp);

    }

    private static void setValueForForm(HttpServletRequest req,
                                        String passNew, String passAgain,
                                        String message) {
        req.setAttribute("passNew", passNew);
        req.setAttribute("passAgain", passAgain);
        req.setAttribute("message", message);
    }


}
