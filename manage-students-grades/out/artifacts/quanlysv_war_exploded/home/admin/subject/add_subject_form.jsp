<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_mon_hoc" method="post" onsubmit="return validateForm()">
  <div class="chua-modal ">
    <div class="dong-modal" onclick="hideModal('modal_mon_hoc')">
      <i id ="dong-form-btn" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal">
      <i class="dau-modal-icon ti-pencil-alt"></i>
      Thêm môn học
    </header>
    <!-- modal body -->
    <div class="than-modal">
      <label for="" class="nhan-hieu-modal">Mã môn học</label>
      <input id ="ma-mh" name="ma-mh" type="text" class="nhap-modal" placeholder="Nhập mã ...">
      <div id="ma-mh-error" class="tb-loi-nhap">Mã môn học không được để trống </div>

      <label for="" class="nhan-hieu-modal">Tên môn học</label>
      <input id ="ten-mh" name="ten-mh" type="text" class="nhap-modal" placeholder="Nhập tên ...">
      <div id="ten-mh-error" class="tb-loi-nhap">Tên môn học không được để trống  </div>

      <label for="" class="nhan-hieu-modal">Số tín chỉ</label>
      <select id="stc-mh" name="stc-mh" class="nhap-modal" required>
        <option value="">Please select</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
      </select>
      <div id="stc-mh-error" class="tb-loi-nhap">Chọn số tín chỉ</div>

      <label for="" class="nhan-hieu-modal">Mã khoa</label>
      <select id="ma-khoa-mh" name="ma-khoa-mh" class="nhap-modal" required>
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
      <div id="ma-khoa-mh-error" class="tb-loi-nhap">Chọn mã khoa</div>
    </div>
    <!-- modal footer -->
    <div class="cuoi-modal">
      <input class="them-btn" type="submit" value="Thêm">
    </div>
  </div>
</form>