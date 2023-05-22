<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Trang đăng nhập</title>
    <link rel="stylesheet" href=".././assets/css/login.css">
    <link rel="icon" type="image/x-icon" href=".././assets/images/ptit.png">
</head>
<body>
    <img class="anh-ben-trai" src="https://code.ptit.edu.vn/2020/images/bg_left.png" alt="Ảnh bên trái">
    <img class="anh-ben-phai" src="https://code.ptit.edu.vn/2020/images/bg_right.png" alt="Ảnh bên phải">
    <form action="/auth/login" method="post">
        <div class="phan-tieuDe">
            <img src=".././assets/images/ptit.png" alt="" class="logo-ptit">
            <div class="dangNhap-tieuDe">Đăng nhập</div>
        </div>
        <div class="phan-nhap">
            <% String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) { %>
            <div class="thongBaoLoi"><%= errorMessage %></div>
            <% } %>
            <label>
                <b class="tenDangNhap-tieuDe">Tên đăng nhập</b>
            </label>
            <input type="text" value="${username}" placeholder="Nhập tên đăng nhập" name="username" required>
            <label>
                <b  class="matKhau-tieuDe">Mật khẩu</b>
            </label>
            <input type="password"  value="${password}"  placeholder="Nhập mật khẩu" name="password" required>
            <button type="submit" class="nut-dangNhap">Đăng nhập</button>
            <a class="quen-mat-khau" href="/auth/forgot-password">Quên mật khẩu?</a>
        </div>
    </form>
</body>
</html>