<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="menu">
  <div class="menu-phanTren">
    <div class="tieuDe">
      <img class="logo" src="../../../assets/images/ptit.png" alt="Logo PTIT">
      <div class="tenTieuDe">Quản lý điểm sinh viên</div>
    </div>
    <div class="nganCach"></div>
    <div class="taiKhoan">
      <img src="../../../assets/images/avatar.png" alt="avatar" class="avatar">
      <div class="tenTaiKhoan">Admin</div>
    </div>
    <div class="nganCach"></div>
    <a class="menuMuc trangChuMuc" href="/../../home/admin/home_admin/home_admin.jsp">
      <img src="../../../assets/images/home.png" alt="Trang chủ" class="icon-Muc">
      <div class="menuMuc-tieuDe">Trang chủ</div>
    </a>
    <a class="menuMuc nhapDiemMuc" href="/../../home/admin/grade/add_grade.jsp">
      <img src="../../../assets/images/score.png" alt="Điểm" class="icon-Muc">
      <div class="menuMuc-tieuDe">Nhập điểm</div>
    </a>
    <a class="menuMuc sinhVienMuc" href="/../../home/admin/student/student.jsp">
      <img src="../../../assets/images/student.svg" alt="Sinh viên" class="icon-Muc">
      <div class="menuMuc-tieuDe">Sinh viên</div>
    </a>
    <a class="menuMuc giangVienMuc" href="/../../home/admin/teacher/teacher.jsp">
      <img src="../../../assets/images/teacher.png" alt="Giảng vien" class="icon-Muc">
      <div class="menuMuc-tieuDe">Giảng viên</div>
    </a>
    <a class="menuMuc hocKyMuc" href="/../../home/admin/semester/semester.jsp">
      <img src="../../../assets/images/general_info.png" alt="Học kỳ" class="icon-Muc">
      <div class="menuMuc-tieuDe">Học kỳ</div>
    </a>
    <a class="menuMuc monHocMuc" href="/../../home/admin/subject/subject.jsp">
      <img src="../../../assets/images/subject.jpg" alt="Thông tin mon hoc" class="icon-Muc">
      <div class="menuMuc-tieuDe">Thông tin môn học</div>
    </a>
    <a class="menuMuc khoaMuc" href="/../../home/admin/specialization/specialization.jsp">
      <img src="../../../assets/images/school.png" alt="Khoa" class="icon-Muc">
      <div class="menuMuc-tieuDe">Khoa chuyên môn</div>
    </a>
    <a class="menuMuc doiMatKhauMuc" href="/../home/common/change_password.jsp">
      <img src="../../../assets/images/change_password.png" alt="Người dùng" class="icon-Muc">
      <div class="menuMuc-tieuDe">Đổi mật khẩu</div>
    </a>
  </div>
  <div class="menu-phanDuoi">
    <div class="dongMenuMuc" onclick="closeMenu()">
      <img src="../../../assets/images/menu.png" alt="Đóng menu" class="icon-Muc">
      <div class="dongMenu-tieuDe">Đóng menu</div>
    </div>
    <a href="/auth/logout" class="dangXuat">
      <img src="../../../assets/images/log-out.png" alt="Đăng xuất" class="icon-DangXuat">
      <div class="dangXuat-tieuDe">Đăng xuất</div>
    </a>
  </div>
</div>
