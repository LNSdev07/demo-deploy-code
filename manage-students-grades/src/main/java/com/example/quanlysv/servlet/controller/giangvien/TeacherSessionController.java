package com.example.quanlysv.servlet.controller.giangvien;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/teacher")
public class TeacherSessionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String sortField = request.getParameter("sortFieldGV");
        if(sortField==null) sortField="";

        String sortOrder = request.getParameter("sortOrderGV");
        if(sortOrder==null) sortOrder="";

        String pageIndex = request.getParameter("pageIndexGV");
        if(pageIndex==null) pageIndex="1";

        String pageSize = request.getParameter("pageSizeGV");
        if(pageSize==null) pageSize="10";

        System.out.println("pageIndex in Session: " + pageIndex);
        System.out.println("pageSize in Session: " + pageSize);

        session.setAttribute("sortFieldGV", sortField);
        session.setAttribute("sortOrderGV", sortOrder);
        session.setAttribute("pageIndexGV", Integer.parseInt(pageIndex));
        session.setAttribute("pageSizeGV", Integer.parseInt(pageSize));
        request.getRequestDispatcher("/home/admin/teacher/teacher.jsp").forward(request, response);
    }
}
