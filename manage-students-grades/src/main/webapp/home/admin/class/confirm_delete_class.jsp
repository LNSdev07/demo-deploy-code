<%--
  Created by IntelliJ IDEA.
  User: Personal
  Date: 5/14/2023
  Time: 1:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- xóa lớp -->
<div class="boc-modal-xoa" id="modal_xac_nhan_xoa">
    <div class="chua-modal-xoa">
        <div class="dong-modal-xoa" onclick="anXacNhanXoa('modal_xac_nhan_xoa')">
            <i id="dong-form-btn" class="ti-close"></i>
        </div>
        <!-- modal header -->
        <header class="dau-modal-xoa">
            <i class="dau-modal-icon ti-trash"></i>

        </header>
        <!-- modal body -->
        <div class="than-modal-xoa">
            Bạn có chắc chắn muốn xóa lớp <span id="textMa"></span> không?
            <br>
            Sau khi xóa bạn không thể khôi phục dữ liệu này.
        </div>
        <!-- modal footer -->
        <div class="cuoi-modal-xoa">
            <button onclick="anXacNhanXoa('modal_xac_nhan_xoa')" class="huy-btn" type="submit">
                Hủy
            </button>
            <button class="xoa-btn" type="submit" onclick="deleteGV(this)">
                Xóa
            </button>
        </div>
    </div>
</div>
