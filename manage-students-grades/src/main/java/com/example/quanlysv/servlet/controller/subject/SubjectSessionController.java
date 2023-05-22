package com.example.quanlysv.servlet.controller.subject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/subject")
public class SubjectSessionController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String tenMonHoc = request.getParameter("tenMh");
        if(tenMonHoc==null) tenMonHoc="";

        String sortField = request.getParameter("sortFieldMH");
        if(sortField==null) sortField="";

        String sortOrder = request.getParameter("sortOrderMH");
        if(sortOrder==null) sortOrder="";

        String pageIndex = request.getParameter("pageIndexMH");
        if(pageIndex==null) pageIndex="1";

        String pageSize = request.getParameter("pageSizeMH");
        if(pageSize==null) pageSize="10";

        System.out.println("pageIndex in Session: " + pageIndex);
        System.out.println("pageSize in Session: " + pageSize);

        session.setAttribute("tenMonHoc", tenMonHoc);
        session.setAttribute("sortFieldMH", sortField);
        session.setAttribute("sortOrderMH", sortOrder);
        session.setAttribute("pageIndexMH", Integer.parseInt(pageIndex));
        session.setAttribute("pageSizeMH", Integer.parseInt(pageSize));
        request.getRequestDispatcher("/home/admin/subject/subject.jsp").forward(request, response);
    }
}
