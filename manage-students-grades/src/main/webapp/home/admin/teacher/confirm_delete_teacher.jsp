<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal-xoa" id="modal_xac_nhan_xoa" method="post">
  <div class="chua-modal-xoa">
    <div class="dong-modal-xoa" onclick="anXacNhanXoa('modal_xac_nhan_xoa')">
      <i id ="dong-form-btn" class="ti-close"></i>
    </div>
    <!-- modal header -->
    <header class="dau-modal-xoa">
      <i class="dau-modal-icon ti-trash"></i>

    </header>
    <!-- modal body -->
    <div class="than-modal-xoa">
      Bạn có chắc chắn muốn xóa giảng viên <span id="textMa"></span> không?
      <br>
      Sau khi xóa bạn không thể khôi phục dữ liệu này.
    </div>

    <%--    hidden input to retrieve id--%>
    <input id ="ma-gv-xoa" name="ma-gv-xoa" type="hidden">

    <!-- modal footer -->
    <div class="cuoi-modal-xoa">
      <button onclick="anXacNhanXoa('modal_xac_nhan_xoa')" class="huy-btn" type="button">
        Hủy
      </button>
      <input class="xoa-btn" type="submit" onclick="anXacNhanXoa('modal_xac_nhan_xoa')" value="Xóa">
    </div>
  </div>
</form>
