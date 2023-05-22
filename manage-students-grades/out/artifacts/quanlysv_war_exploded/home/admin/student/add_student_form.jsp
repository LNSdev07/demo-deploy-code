<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" method="post" id="modal_sinh_vien" onsubmit="return validateForm()">
  <div class="chua-modal">
    <div class="dong-modal" onclick="hideModal('modal_sinh_vien')">
      <i id ="dong-form-btn" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal">
      <i class="dau-modal-icon ti-user"></i>
      Thêm sinh viên
    </header>
    <!-- modal body -->
    <div class="than-modal">
      <label for="" class="nhan-hieu-modal">Mã sinh viên</label>
      <input id="ma-sv" name="ma-sv" type="text" class="nhap-modal" placeholder="Nhập mã ...">
      <div id="ma-sv-error" class="tb-loi-nhap">Mã sinh viên không được để trống </div>

      <label for="" class="nhan-hieu-modal">Tên sinh viên</label>
      <input id="ten-sv" name="ten-sv" type="text" class="nhap-modal" placeholder="Nhập tên ...">
      <div id="ten-sv-error" class="tb-loi-nhap">Tên sinh viên không được để trống </div>

      <label for="" class="nhan-hieu-modal">Email</label>
      <input id="email-sv" name="email-sv" type="email" class="nhap-modal" placeholder="Điền email .. ">
      <div id="email-sv-error" class="tb-loi-nhap">Email không được để trống </div>

      <label for="" class="nhan-hieu-modal">Ngày sinh</label>
      <input id="dob-sv" name="dob-sv" type="date" class="nhap-modal">
      <div id="dob-sv-error" class="tb-loi-nhap"> Chọn ngày tháng năm sinh </div>

      <label for="" class="nhan-hieu-modal">Giới tính</label>
      <select id="gioi-tinh-sv" name="gioi-tinh-sv" class="nhap-modal" required>
        <option value="">Please select</option>
        <option value="Nam">Nam</option>
        <option value="Nữ">Nữ</option>
      </select>
      <div id="gioi-tinh-sv-error" class="tb-loi-nhap">Chọn giới tính </div>

      <label for="" class="nhan-hieu-modal">Số điện thoại</label>
      <input id="sdt-sv" name="sdt-sv" type="text" class="nhap-modal" placeholder="Nhập số điện thoại ...">
      <div id="sdt-sv-error" class="tb-loi-nhap">Số điện thoại không được để trống</div>

      <label for="" class="nhan-hieu-modal">Lớp hành chính</label>
      <input id="ma-lop-sv" name="ma-lop-sv" type="text" class="nhap-modal" placeholder="Nhập lớp hành chính ...">
      <div id="ma-lop-sv-error" class="tb-loi-nhap">Lớp hành chính không được để trống</div>

    </div>
    <!-- modal footer -->
    <div class="cuoi-modal">
      <input class="them-btn" type="submit" value="Thêm">
    </div>
  </div>
</form>