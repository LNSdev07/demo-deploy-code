<%--
  Created by IntelliJ IDEA.
  User: lnspt
  Date: 5/7/2023
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Quên mật khẩu</title>
  <link rel="stylesheet" href="../assets/css/change_password_default.css">
  <link rel="icon" type="image/x-icon" href=".././assets/images/ptit.png">
  <style>
  </style>
</head>
<body>
<h1 style="text-align: center;">Khôi phục mật khẩu !</h1>
<div class="container">

  <% String successMessage11 = (String) request.getAttribute("successMessage");
    if (successMessage11 == null) { %>
  <form action="/auth/forgot-password"  style="margin-top: 5%;" method="post">
  <% } else { %>
    <form action="/auth/verify-code"  style="margin-top: 5%;" method="get">
    <% } %>
    <%--    hiển thị lỗi--%>
    <div class="row">
      <div class="col-25">
      </div>
      <div class="col-75">
        <% String errorMessage = (String) request.getAttribute("message");
          if (errorMessage != null) { %>
        <div class="thongBaoLoi"><%= errorMessage %></div>
        <% } %>

        <% String successMessage1 = (String) request.getAttribute("successMessage");
          if (successMessage1 != null) { %>
        <div class="thongBaoThanhCong"><%= successMessage1 %></div>
        <% } %>
      </div>
    </div>

      <% String successMessage = (String) request.getAttribute("successMessage");
        if (successMessage == null) { %>
      <div class="row">
        <div class="col-25">
          <label><strong>Mail</strong></label>
        </div>
        <div class="col-75">
          <input type="text"  value="${gmail}"  name="gmail" placeholder="">
        </div>
      </div>
      <br>
      <div class="row">
        <input style="margin-right: 45%;" class="forgot" type="submit" value="Lấy lại mật khẩu">
      </div>
      <% } else { %>
      <div class="row">
        <div class="col-25">
          <label><strong>Tên đăng nhập</strong></label>
        </div>
        <div class="col-75">
          <input type="text"  name="username" placeholder="">
        </div>
      </div>
      <br>
      <div class="row">
        <div class="col-25">
          <label><strong>Nhập mã code</strong></label>
        </div>
        <div class="col-75">
          <input type="text"  name="code" placeholder="">
        </div>
      </div>
      <br>
      <div class="row">
        <input style="margin-right: 45%;"  type="submit" value="Xác thực code">
      </div>
      <br>
     <div class="row">
       <a href="/auth/forgot-password" style="text-decoration: underline; cursor: pointer; margin-left: 39%; color: red" >
         Bạn chưa nhận được code. Gửi lại !</a>
     </div>
      <% } %>
  </form>
</div>
</body>
</html>
