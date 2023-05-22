<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="/home/admin/menu/admin_menu_header.jsp" %>
    <link rel="stylesheet" href="../../../assets/css/admin/home_admin.css">

    <title>Trang chủ</title>
</head>
<%
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    String url = resourceBundle.getString("url");
    String username = resourceBundle.getString("username");
    String password = resourceBundle.getString("password");
    String driver=resourceBundle.getString("driverName");
%>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<div class="manHinhChinh">


    <div id="noidung">
        <div class="noidung-header">
            <h2>Dashboard</h2>
        </div>
        <section class="content">
            <div class="container">
                <div class="bon-box">
                    <div class="box1">
                        <div class="small-box1">
                            <div class="benTrong">
                                <%
                                    try{
                                        Class.forName(driver);
                                        Connection con= DriverManager.getConnection(url,username,password);
                                        String query="select count(*) from sinhvien where trang_thai=1";
                                        PreparedStatement ps=con.prepareStatement(query);
                                        ResultSet rs=ps.executeQuery();
                                        while(rs.next()){
                                %>
                                <h3><%=rs.getInt(1)%></h3>
                                <p>Sinh viên</p>
                                <% }

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                %>
                            </div>
                            <div class="icon i1">
                                <i class="ti-user"></i>
                            </div>
                        </div>
                        <a href="/../../home/admin/student/student.jsp" class="small-box-duoicung f1">Xem thêm</a>
                    </div>
                    <div class="box2">
                        <div class="small-box2">
                            <div class="benTrong">
                                <%
                                    try{
                                        Class.forName(driver);
                                        Connection con= DriverManager.getConnection(url,username,password);
                                        String query="select count(*) from giangvien where trang_thai=1";
                                        PreparedStatement ps=con.prepareStatement(query);
                                        ResultSet rs=ps.executeQuery();
                                        while(rs.next()){
                                %>
                                <h3><%=rs.getInt(1)%></h3>
                                <% }

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                %>
                                <p>Giảng viên</p>
                            </div>
                            <div class="icon i2">
                                <i class="ti-bag"></i>
                            </div>
                        </div>
                        <a href="/../../home/admin/teacher/teacher.jsp" class="small-box-duoicung f2">Xem thêm</a>
                    </div>
                    <div class="box3">
                        <div class="small-box3">
                            <div class="benTrong">
                                <%
                                    try{
                                        Class.forName(driver);
                                        Connection con= DriverManager.getConnection(url,username,password);
                                        String query="select count(*) from monhoc where trang_thai=1";
                                        PreparedStatement ps=con.prepareStatement(query);
                                        ResultSet rs=ps.executeQuery();
                                        while(rs.next()){
                                %>
                                <h3><%=rs.getInt(1)%></h3>
                                <% }

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                %>
                                <p>Môn học</p>
                            </div>
                            <div class="icon i3">
                                <i class="ti-bar-chart"></i>
                            </div>
                        </div>
                        <a href="/../../home/admin/subject/subject.jsp" class="small-box-duoicung f3">Xem thêm</a>
                    </div>
                    <div class="box4">
                        <div class="small-box4">
                            <div class="benTrong">
                                <%
                                    try{
                                        Class.forName(driver);
                                        Connection con= DriverManager.getConnection(url,username,password);
                                        String query="select count(*) from lop";
                                        PreparedStatement ps=con.prepareStatement(query);
                                        ResultSet rs=ps.executeQuery();
                                        while(rs.next()){
                                %>
                                <h3><%=rs.getInt(1)%></h3>
                                <% }

                                }catch (Exception e){
                                    e.printStackTrace();
                                }
                                %>
                                <p>Lớp học phần</p>
                            </div>
                            <div class="icon i4">
                                <i class="ti-user"></i>
                            </div>
                        </div>
                        <a href="/../../home/admin/specialization/specialization.jsp" class="small-box-duoicung f4">Xem thêm</a>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<script src="../../../assets/js/menu.js"></script>
<script src="../../../assets/js/admin/home_admin.js"></script>
</body>
</html>