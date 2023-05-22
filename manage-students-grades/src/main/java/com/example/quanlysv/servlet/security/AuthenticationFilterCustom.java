package com.example.quanlysv.servlet.security;

import com.example.quanlysv.servlet.entity.AccountEntity;
import com.example.quanlysv.servlet.util.SessionUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilterCustom implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String url = request.getRequestURI();
        if(url.startsWith("/home") || url.startsWith("/api")){
            AccountEntity accountEntity = (AccountEntity) SessionUtils.getInstance().getValue(request, "ACCOUNT");
            if(accountEntity != null){
                if(accountEntity.getRoleId() ==1 && url.contains("admin")){
                    filterChain.doFilter(request, response);
                }
                else if(accountEntity.getRoleId() ==2 && url.contains("user")){
                    filterChain.doFilter(request, response);
                }
                else if(url.contains("common")){
                    filterChain.doFilter(request, response);
                }
                else {
                    request.setAttribute("account", accountEntity);
                    request.getRequestDispatcher("/auth/page_404.jsp").forward(request, response);
                }
            }
            else{
                response.sendRedirect("/auth/login");
            }
        }
        else{
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
