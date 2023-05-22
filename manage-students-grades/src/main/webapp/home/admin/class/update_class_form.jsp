<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- sửa lớp -->
<div class="boc-modal" id="modal_lop_sua">
  <div class="chua-modal js-modal-container">
    <div class="dong-modal js-modal-close" onclick="hideModalSua('modal_lop_sua')">
      <i id="dong-form-btn-sua" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal-sua">
      <i class="dau-modal-icon ti-user"></i>
      Sửa lớp
    </header>
    <!-- modal body -->
    <div class="than-modal">
      <label for="" class="nhan-hieu-modal">Mã lớp</label>
      <input id="ma-lop-sua" type="text" class="nhap-modal" placeholder="Nhập mã ...">
      <div id="ma-lop-error-sua" class="tb-loi-nhap-sua">Mã lớp không được để trống</div>

      <label for="" class="nhan-hieu-modal">Tên lớp</label>
      <input id="ten-lop-sua" type="text" class="nhap-modal" placeholder="Nhập tên ...">
      <div id="ten-lop-error-sua" class="tb-loi-nhap-sua">Tên lớp không được để trống</div>


      <label for="" class="modal-label">Học kỳ</label>
      <input id="hoc-ky-sua" type="text" class="modal-input" placeholder="Nhập học kỳ ...">
      <div id="hoc-ky-error-sua" class="error-message">Làm ơn nhập vào </div>

    </div>
    <!-- modal footer -->
    <div class="cuoi-modal">
      <button class="sua-btn" type="submit" onclick="validateFormSua()">Sửa</button>
    </div>
  </div>
</div>