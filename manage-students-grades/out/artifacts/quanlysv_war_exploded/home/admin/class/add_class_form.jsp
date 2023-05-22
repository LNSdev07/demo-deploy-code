<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="boc-modal" id="modal_lop">
  <div class="modal-container js-modal-container">
    <div class="modal-close js-modal-close" onclick="hideModal('modal_lop')">
      <i id="close-btn" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="modal-header">
      <i class="modal-heading-icon ti-user"></i>
      Thêm lớp
    </header>
    <!-- modal body -->
    <div class="modal-body">
      <label for="" class="modal-label">Mã lớp</label>
      <input id="ma" type="text" class="modal-input" placeholder="Nhập mã ...">
      <div id="ma-error" class="error-message">Mã lớp không được để trống</div>

      <label for="" class="modal-label">Tên lớp</label>
      <input id="ten" type="text" class="modal-input" placeholder="Nhập tên ...">
      <div id="ten-error" class="error-message">Tên lớp không được để trống</div>

      <label for="" class="modal-label">Học kỳ</label>
      <input id="ten-hk" type="text" class="modal-input" placeholder="Nhập tên ...">
      <div id="ten-hk-error" class="error-message">Học kỳ không được để trống</div>

    </div>
    <!-- modal footer -->
    <div class="modal-footer">
      <button class="buy-btn" type="submit" onclick="validateForm()">
        Thêm
      </button>
    </div>
  </div>
</div>