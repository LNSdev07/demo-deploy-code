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
import java.io.IOException;

@WebServlet("/auth/verify-code")
public class VerifyCodeController extends HttpServlet {

    private final IAuthService authService;


    public VerifyCodeController() {
        this.authService = new AuthServiceImpl();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        String username = req.getParameter("username");

        AccountEntity account = authService.findAccountByUsernameAndPassword(username);
        if(account == null){
            String errorMessage = "Người dùng không tồn tại !";
            req.setAttribute("message", errorMessage);

            String successMessage = "Code đã được gửi về gmail. Vui lòng xác thực!";
            req.setAttribute("successMessage", successMessage);

            req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
        }
        else if(account.getVerification() == null || !account.getVerification().equals(code)){
            String errorMessage = "Mã xác nhận không đúng !";
            req.setAttribute("message", errorMessage);
            String successMessage = "Code đã được gửi về gmail. Vui lòng xác thực!";
            req.setAttribute("successMessage", successMessage);
            req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
        }
        else{
            req.setAttribute("username", null);
            req.setAttribute("passNew", null);
            req.setAttribute("passAgain", null);
            req.getRequestDispatcher("confirm_pass.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passNew = req.getParameter("passNew");
        String passAgain = req.getParameter("passAgain");
        String code = req.getParameter("code");

        AccountEntity accountEntity = authService.findAccountByUsernameAndPassword(username);

        if(accountEntity == null){
            String message = "Người dùng không tồn tại!";
            req.setAttribute("message", message);
            req.getRequestDispatcher("confirm_pass.jsp").forward(req, resp);
            return;
        }
        else if( accountEntity.getVerification() == null || !accountEntity.getVerification().equals(code)){
            String message = "Mã xác thực không đúng";
            req.setAttribute("message", message);
            req.getRequestDispatcher("confirm_pass.jsp").forward(req, resp);
            return;
        }
        String message = authService.changePassDefault(accountEntity.getUsername(), passNew, passAgain);
        if(!message.equals("ok")){
            setValueForForm(req, passNew, passAgain, message);
            req.getRequestDispatcher("confirm_pass.jsp").forward(req, resp);
            return;
        }
        else{
                resp.sendRedirect("/auth/login");
                return;
        }
    }

    private static void setValueForForm(HttpServletRequest req,
                                        String passNew, String passAgain,
                                        String message) {
        req.setAttribute("passNew", passNew);
        req.setAttribute("passAgain", passAgain);
        req.setAttribute("message", message);
    }
}
