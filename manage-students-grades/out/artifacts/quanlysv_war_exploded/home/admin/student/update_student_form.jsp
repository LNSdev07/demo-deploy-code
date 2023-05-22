<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_sinh_vien_sua" method="post" onsubmit="return validateFormSua()">
  <div class="chua-modal">
    <div class="dong-modal" onclick="hideModal('modal_sinh_vien_sua')">
      <i id ="dong-form-btn-sua" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal-sua">
      <i class="dau-modal-icon ti-user"></i>
      Sửa sinh viên
    </header>
    <!-- modal body -->
    <div class="than-modal">
      <label for="" class="nhan-hieu-modal">Mã sinh viên</label>
      <input id="ma-sv-sua" name="ma-sv-sua" type="text" class="nhap-modal" readonly>
      <div id="ma-sv-error-sua" class="tb-loi-nhap">Mã sinh viên không được để trống </div>

      <label for="" class="nhan-hieu-modal">Tên sinh viên</label>
      <input id="ten-sv-sua" name="ten-sv-sua" type="text" class="nhap-modal" placeholder="Nhập tên ...">
      <div id="ten-sv-error-sua" class="tb-loi-nhap">Tên sinh viên không được để trống </div>


      <label for="" class="nhan-hieu-modal">Email</label>
      <input id="email-sv-sua" name="email-sv-sua" type="email" class="nhap-modal" placeholder="Điền email .. ">
      <div id="email-sv-error-sua" class="tb-loi-nhap">Email không được để trống </div>


      <label for="" class="nhan-hieu-modal">Ngày sinh</label>
      <input id="dob-sv-sua" name="dob-sv-sua" type="date" class="nhap-modal">
      <div id="dob-sv-error-sua" class="tb-loi-nhap"> Chọn ngày tháng năm sinh </div>


      <label for="" class="nhan-hieu-modal">Giới tính</label>
      <select id="gioi-tinh-sv-sua" name="gioi-tinh-sv-sua" class="nhap-modal" required>
        <option value="">Please select</option>
        <option value="Nam">Nam</option>
        <option value="Nữ">Nữ</option>
      </select>
      <div id="gioi-tinh-sv-error-sua" class="tb-loi-nhap">Chọn giới tính </div>

      <label for="" class="nhan-hieu-modal">Số điện thoại</label>
      <input id="sdt-sv-sua" name="sdt-sv-sua" type="text" class="nhap-modal" placeholder="Nhập số điện thoại ...">
      <div id="sdt-sv-error-sua" class="tb-loi-nhap">Số điện thoại không được để trống</div>

      <label for="" class="nhan-hieu-modal">Lớp hành chính</label>
      <input type="text" id="ma-lop-sv-sua" name="ma-lop-sv-sua" class="nhap-modal" placeholder="Điền lớp .. ">
      <div id="ma-lop-sv-error-sua" class="tb-loi-nhap-sua">Chọn lớp hành chính</div>

    </div>
    <!-- modal footer -->
    <div class="cuoi-modal">
      <input class="sua-btn" type="submit" value="Sửa">
    </div>
  </div>
</form>