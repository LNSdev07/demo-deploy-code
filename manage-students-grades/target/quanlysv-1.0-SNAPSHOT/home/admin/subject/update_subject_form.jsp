<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_mon_hoc_sua" method="POST" onsubmit="return validateFormSua()">
    <div class="chua-modal">
        <div class="dong-modal" onclick="hideModalSua('modal_mon_hoc_sua')">
            <i id ="dong-form-btn" class="ti-close"></i>
        </div>
        <!-- modal header -->
        <header class="dau-modal-sua">
            <i class="dau-modal-icon ti-pencil-alt"></i>
            Sửa môn học
        </header>
        <!-- modal body -->
        <div class="than-modal">
            <label for="" class="nhan-hieu-modal">Mã môn học</label>
            <input id ="ma-mh-sua" name="ma-mh-sua" type="text" class="nhap-modal" placeholder="Nhập mã ..." readonly>
            <div id="ma-mh-error-sua" class="tb-loi-nhap-sua">Mã môn học không được để trống </div>

            <label for="" class="nhan-hieu-modal">Tên môn học</label>
            <input id="ten-mh-sua" name="ten-mh-sua" type="text" class="nhap-modal" placeholder="Nhập tên ...">
            <div id="ten-mh-error-sua" class="tb-loi-nhap-sua">Tên môn học không được để trống  </div>

            <label for="" class="nhan-hieu-modal">Số tín chỉ</label>
            <select id="stc-mh-sua" name="stc-mh-sua" class="nhap-modal" required>
                <option value="">Please select</option>
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
            </select>
            <div id="stc-mh-error-sua" class="tb-loi-nhap-sua">Chọn số tín chỉ</div>

            <label for="" class="nhan-hieu-modal">Mã khoa</label>
            <select id="ma-khoa-mh-sua" name="ma-khoa-mh-sua" class="nhap-modal" required>
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
            <div id="ma-khoa-mh-error-sua" class="tb-loi-nhap-sua">Chọn mã khoa</div>

        </div>
        <!-- modal footer -->
        <div class="cuoi-modal">
            <input class="sua-btn" type="submit" value="Sửa">
        </div>
    </div>
</form>