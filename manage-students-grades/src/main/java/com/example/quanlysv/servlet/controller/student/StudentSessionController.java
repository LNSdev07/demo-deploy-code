package com.example.quanlysv.servlet.controller.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/student")
public class StudentSessionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String idSv = request.getParameter("idSv");
        if(idSv==null) idSv="";

        String tenSv = request.getParameter("tenSv");
        if(tenSv==null) tenSv="";

        String sortField = request.getParameter("sortFieldSV");
        if(sortField==null) sortField="";

        String sortOrder = request.getParameter("sortOrderSV");
        if(sortOrder==null) sortOrder="";

        String pageIndex = request.getParameter("pageIndexSV");
        if(pageIndex==null) pageIndex="1";

        String pageSize = request.getParameter("pageSizeSV");
        if(pageSize==null) pageSize="10";

        session.setAttribute("idSv", idSv);
        session.setAttribute("tenSv", tenSv);
        session.setAttribute("sortFieldSV", sortField);
        session.setAttribute("sortOrderSV", sortOrder);
        session.setAttribute("pageIndexSV", Integer.parseInt(pageIndex));
        session.setAttribute("pageSizeSV", Integer.parseInt(pageSize));
        request.getRequestDispatcher("/home/admin/student/student.jsp").forward(request, response);
    }
}
