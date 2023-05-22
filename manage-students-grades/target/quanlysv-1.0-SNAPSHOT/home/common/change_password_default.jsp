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
  <title>Thay đổi mật khẩu mặc định</title>
  <link rel="stylesheet" href="../../assets/css/change_password_default.css">
  <link rel="icon" type="image/x-icon" href="../.././assets/images/ptit.png">
  <style>
  </style>
</head>
<body>
<h1 style="text-align: center;">Vui lòng thay đổi mật khẩu !</h1>

<div class="container">
  <form action="/auth/change-password-default" style="margin-top: 5%;" method="post">
<%--    hiển thị lỗi--%>
    <div class="row">
      <div class="col-25">
      </div>
      <div class="col-75">
        <% String errorMessage = (String) request.getAttribute("message");
          if (errorMessage != null) { %>
        <div class="thongBaoLoi"><%= errorMessage %></div>
        <% } %>
      </div>
    </div>

    <div class="row">
      <div class="col-25">
        <label ><strong>Mật khẩu mới</strong></label>
      </div>
      <div class="col-75">
        <input type="password" value="${passNew}"  name="passNew" placeholder="">
      </div>
    </div>
    <div class="row">
      <div class="col-25">
        <label ><strong>Nhập lại mật khẩu</strong></label>
      </div>
      <div class="col-75">
        <input type="password" value="${passAgain}"  name="passAgain" placeholder="">
      </div>
    </div>
    <br>
    <br>
    <div class="row">
      <input style="margin-right: 45%;" type="submit" value="Thay đổi mật khẩu">
    </div>
  </form>
</div>
</body>
</html>
