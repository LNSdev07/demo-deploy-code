package com.example.quanlysv.servlet.controller.auth;

import com.example.quanlysv.servlet.service.IAuthService;
import com.example.quanlysv.servlet.service.IForgotPassService;
import com.example.quanlysv.servlet.service.impl.AuthServiceImpl;
import com.example.quanlysv.servlet.service.impl.ForgotPassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/auth/forgot-password")
public class ForgotPassController extends HttpServlet {


    private final IForgotPassService forgotPassService;

    public ForgotPassController() {
        this.forgotPassService = new ForgotPassServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", null);
        req.setAttribute("gmail", null);
        req.setAttribute("pass", null);
        req.setAttribute("successMessage", null);
        req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gmail = req.getParameter("gmail");
        if(!forgotPassService.existEmailUser(gmail)){
            String errorMessage = "Không tồn tại người dùng này !";
            req.setAttribute("message", errorMessage);
            req.setAttribute("gmail", gmail);
            req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
        }
        else {
            if(forgotPassService.sendEmail(gmail)){
                String successMessage = "Code đã được gửi về gmail. Vui lòng xác thực!";
                req.setAttribute("successMessage", successMessage);
                req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
            }
            else{
                String errorMessage = "Rất tiếc. Có sự cố trong quá trình gửi mail !";
                req.setAttribute("message", errorMessage);
                req.setAttribute("gmail", gmail);
                req.getRequestDispatcher("forgot_pass.jsp").forward(req, resp);
            }
        }
    }
}
