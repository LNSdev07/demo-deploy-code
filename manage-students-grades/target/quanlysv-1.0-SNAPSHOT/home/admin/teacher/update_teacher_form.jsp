<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_giang_vien_sua" method="POST" onsubmit="return validateFormSua()">
  <div class="chua-modal js-modal-container">
    <div class="dong-modal js-modal-close" onclick="hideModalSua('modal_giang_vien_sua')">
      <i id ="dong-form-btn-sua" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal-sua">
      <i class="dau-modal-icon ti-user"></i>
      Sửa giảng viên
    </header>
    <!-- modal body -->
    <div class="than-modal">
      <label for="" class="nhan-hieu-modal">Mã giảng viên</label>
      <input id ="ma-gv-sua" name="ma-gv-sua" type="text" class="nhap-modal" placeholder="Nhập mã ..." readonly>
      <div id="ma-gv-error-sua" class="tb-loi-nhap-sua">Mã giảng viên không được để trống</div>

      <label for="" class="nhan-hieu-modal">Tên giảng viên</label>
      <input id = "ten-gv-sua" name="ten-gv-sua" type="text" class="nhap-modal" placeholder="Nhập tên ...">
      <div id="ten-gv-error-sua" class="tb-loi-nhap-sua">Tên giảng viên không được để trống</div>

      <label for="" class="nhan-hieu-modal">Email</label>
      <input id="email-gv-sua" name="email-gv-sua" type="email" class="nhap-modal" placeholder="Điền email .. ">
      <div id="email-gv-error-sua" class="tb-loi-nhap-sua">Email không được để trống</div>

      <label for="" class="nhan-hieu-modal">Giới tính</label>
      <select id = "gioi-tinh-gv-sua" name="gioi-tinh-gv-sua" class="nhap-modal" required>
        <option value="">Please select</option>
        <option value="Nam">Nam</option>
        <option value="Nữ">Nữ</option>
      </select>
      <div id="gioi-tinh-gv-error-sua" class="tb-loi-nhap-sua">Chọn giới tính </div>

      <label for="" class="nhan-hieu-modal">Số điện thoại</label>
      <input id="sdt-gv-sua" name="sdt-gv-sua" type="text" class="nhap-modal" placeholder="Nhập số điện thoại ...">
      <div id="sdt-gv-error-sua" class="tb-loi-nhap-sua">Số điện thoại không được để trống </div>

      <label for="" class="nhan-hieu-modal">Mã khoa </label>
      <select id="ma-khoa-gv-sua" name="ma-khoa-gv-sua" class="nhap-modal" required>
        <option value="">Please select</option>
        <option value="CNTT">Công nghệ thông tin</option>
        <option value="ATTT">An toàn thông tin</option>
        <option value="DPT">Đa phương tiện</option>
        <option value="MKT">Marketing</option>
        <option value="DTVT">Điện tử viễn thông</option>
        <option value="KTDT">Kĩ thuật điện tử</option>
        <option value="QTKD">Quản trị kinh doanh</option>
        <option value="TCKT">Tài chính kế toán</option>
        <option value="CB">Cơ bản</option>
      </select>
      <div id="ma-khoa-gv-error-sua" class="tb-loi-nhap-sua">Chọn mã khoa</div>

    </div>
    <!-- modal footer -->
    <div class="cuoi-modal">
      <input class="sua-btn" type="submit" value="Sửa"/>
    </div>
  </div>
</form>
