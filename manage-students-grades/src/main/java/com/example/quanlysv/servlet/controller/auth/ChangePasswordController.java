package com.example.quanlysv.servlet.controller.auth;


import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.service.IAuthService;
import com.example.quanlysv.servlet.service.impl.AuthServiceImpl;
import com.example.quanlysv.servlet.util.SessionUtils;
import com.example.quanlysv.servlet.util.Validate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth/change-password")
public class ChangePasswordController extends HttpServlet {

    private final IAuthService authService;

    public ChangePasswordController() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String passOld = req.getParameter("passOld");
         String passNew = req.getParameter("passNew");
         String passAgain = req.getParameter("passAgain");
         if(!Validate.validatePass(passNew, passAgain, passOld).equals("ok")){
             String errorMessage = Validate.validatePass(passNew, passAgain, passOld);
             setValueForForm(req, passOld, passNew, passAgain, errorMessage);
             req.getRequestDispatcher("/home/common/change_password.jsp").forward(req, resp);
         }
        HttpSession session = req.getSession(false);
        if (session != null) {
            AccountEntity accountEntity = (AccountEntity) SessionUtils.getInstance().getValue(req, "ACCOUNT");
            if(!authService.checkPassword(accountEntity.getUsername(), passOld)){
                setValueForForm(req, passOld, passNew, passAgain, "Mật khẩu không đúng!");
                req.getRequestDispatcher("/home/common/change_password.jsp").forward(req, resp);
            }
            else{
                boolean ac = authService.changePassword(accountEntity.getUsername(), passNew);
                if(!ac){
                    setValueForForm(req, passOld, passNew, passAgain, "Thay đổi mật khẩu không thành công!");
                }
                req.setAttribute("successMessage", "Bạn đã đổi mật khẩu thành công");
                req.getRequestDispatcher("/home/common/change_password.jsp").forward(req, resp);
            }
        }
    }

    private static void setValueForForm(HttpServletRequest req,
                                        String passOld, String passNew,
                                        String passAgain, String message) {
        req.setAttribute("passOld", passOld);
        req.setAttribute("passNew", passNew);
        req.setAttribute("passAgain", passAgain);
        req.setAttribute("errorMessage", message);
    }
}
