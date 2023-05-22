package com.example.quanlysv.servlet.controller.hocky;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/semester")
public class SemesterSessionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String sortField = request.getParameter("sortFieldHK");
        if(sortField==null) sortField="";

        String sortOrder = request.getParameter("sortOrderHK");
        if(sortOrder==null) sortOrder="";

        String pageIndex = request.getParameter("pageIndexHK");
        if(pageIndex==null) pageIndex="1";

        String pageSize = request.getParameter("pageSizeHK");
        if(pageSize==null) pageSize="10";

        System.out.println("pageIndex in Session: " + pageIndex);
        System.out.println("pageSize in Session: " + pageSize);

        session.setAttribute("sortFieldHK", sortField);
        session.setAttribute("sortOrderHK", sortOrder);
        session.setAttribute("pageIndexHK", Integer.parseInt(pageIndex));
        session.setAttribute("pageSizeHK", Integer.parseInt(pageSize));
        request.getRequestDispatcher("/home/admin/semester/semester.jsp").forward(request, response);
    }
}
