<%@ page import="com.example.quanlysv.servlet.entity.AccountEntity" %><%--
  Created by IntelliJ IDEA.
  User: NMQ
  Date: 4/10/2023
  Time: 12:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/assets/css/page_404.css">
    <title>Lỗi</title>
    <link rel="icon" href="/assets/images/ptit.png" type="image/x-icon" />
</head>
<body>
<div class="boc-trang-404">
    <div class="bao-boc-404">
        <div class="chua-404">
            <%
                AccountEntity account = (AccountEntity) request.getAttribute("account");
                if (account == null) {
            %>
            <a href="/auth/login.jsp" class="tro-ve-trang chu">Quay về trang chủ chưa đăng nhập</a>
            <%
            } else {
                if(account.getRoleId() == 1) {
            %>
            <a href="/home/admin/home_admin/home_admin.jsp" class="tro-ve-trang chu">Quay về trang chủ admin</a>
            <%
            } else {
            %>
            <a href="/home/user/home_user/home_user.jsp" class="tro-ve-trang chu">Quay về trang chủ user</a>
            <%
                    }
                }
            %>
            <div class="blank b403">
                <img src="https://code.ptit.edu.vn/2020/images/download (2)@3x.png" alt="">
                <p>Đã có lỗi gì đó ! Rất tiếc vì sự cố này</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>
