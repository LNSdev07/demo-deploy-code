<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <c:choose>
        <c:when test="${sessionScope.ACCOUNT.roleId == 1}">
            <%@include file="../admin/menu/admin_menu_header.jsp" %>
        </c:when>
        <c:when test="${sessionScope.ACCOUNT.roleId == 2}">
            <%@include file="../user/menu/user_menu_header.jsp" %>
        </c:when>
    </c:choose>
    <link rel="stylesheet" href="../../assets/css/change_password.css">
    <link rel="stylesheet" href="../../assets/themify-icons/themify-icons.css">
    <title>Đổi mật khẩu</title>
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.ACCOUNT.roleId == 1}">
        <%@include file="../admin/menu/admin_menu.jsp" %>
    </c:when>
    <c:when test="${sessionScope.ACCOUNT.roleId == 2}">
        <%@include file="../user/menu/user_menu.jsp" %>
    </c:when>
</c:choose>

<div class="manHinhChinh">
    <h1 class="tieuDeTrang">Đổi mật khẩu</h1>
    <div class="container">
        <form action="/auth/change-password" method="post">

            <div class="row">
                <div class="col-25">
                    <label hidden="true" >Mật khẩu cũ</label>
                </div>
                <div class="col-75">
                    <% String errorMessage = (String) request.getAttribute("errorMessage");
                        if (errorMessage != null) { %>
                    <div class="thongBaoLoi"><%= errorMessage %></div>
                    <% } %>

                    <% String successMessage = (String) request.getAttribute("successMessage");
                        if (successMessage != null) { %>
                    <div class="thongBaoThanhCong"><%= successMessage %></div>
                    <% } %>
                </div>
            </div>

            <div class="row">
                <div class="col-25">
                    <label >Mật khẩu cũ</label>
                </div>
                <div class="col-75">
                    <input value="${passOld}" type="password" style="font-size: 16px" name="passOld"  placeholder="">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label >Mật khẩu mới</label>
                </div>
                <div class="col-75">
                    <input value="${passNew}" type="password" style="font-size: 16px" name="passNew"   placeholder="">
                </div>
            </div>
            <div class="row">
                <div class="col-25">
                    <label >Nhập lại mật khẩu</label>
                </div>
                <div class="col-75">
                    <input value="${passAgain}" type="password" style="font-size: 16px" name="passAgain"  placeholder="">
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-25">
                    <button class="btn" type="submit" >Đổi mật khẩu</button>
                </div>
            </div>
        </form>
    </div>

</div>
</body>
<script src="../../assets/js/menu.js"></script>
<script src="../../assets/js/change_password.js"></script>
</html>
