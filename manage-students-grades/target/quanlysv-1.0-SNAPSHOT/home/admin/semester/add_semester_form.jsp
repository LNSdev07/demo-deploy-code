<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_hoc_ky" method="post" onsubmit="return validateForm()">
    <div class="chua-modal">
        <div class="dong-modal" onclick="hideModal('modal_hoc_ky')">
            <i id ="dong-form-btn" class="ti-close"></i>
        </div>
        <!-- modal header -->
        <header class="dau-modal">
            <i class="dau-modal-icon ti-view-list-alt"></i>
            Thêm học kỳ
        </header>
        <!-- modal body -->
        <div class="than-modal">
            <label for="" class="nhan-hieu-modal">Mã học kỳ</label>
            <input id="ma-hk" name="ma-hk" type="text" class="nhap-modal" placeholder="Nhập mã ...">
            <div id="ma-hk-error" class="tb-loi-nhap">Mã học kỳ không được để trống </div>

            <label for="" class="nhan-hieu-modal">Tên học kỳ</label>
            <input id="ten-hk" name="ten-hk" type="text" class="nhap-modal" placeholder="Nhập tên ...">
            <div id="ten-hk-error" class="tb-loi-nhap">Tên học kỳ không được để trống </div>

        </div>
        <!-- modal footer -->
        <div class="cuoi-modal">
            <input class="them-btn" type="submit" value="Thêm"/>
        </div>
    </div>
</form>
