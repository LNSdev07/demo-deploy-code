<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="boc-modal" id="modal_giang_vien" method="POST" onsubmit="return validateForm()">
    <div class="chua-modal js-modal-container">
        <div class="dong-modal js-modal-close" onclick="hideModal('modal_giang_vien')">
            <i id ="dong-form-btn" class="ti-close"></i>
        </div>
        <!-- modal header -->
        <header class="dau-modal">
            <i class="dau-modal-icon ti-user"></i>
            Thêm giảng viên
        </header>
        <!-- modal body -->
        <div class="than-modal">
            <label for="" class="nhan-hieu-modal">Mã giảng viên</label>
            <input id ="ma-gv" name="ma-gv" type="text" class="nhap-modal" placeholder="Nhập mã ...">
            <div id="ma-gv-error" class="tb-loi-nhap">Mã giảng viên không được để trống</div>



            <label for="" class="nhan-hieu-modal">Tên giảng viên</label>
            <input id = "ten-gv" name="ten-gv" type="text" class="nhap-modal" placeholder="Nhập tên ...">
            <div id="ten-gv-error" class="tb-loi-nhap">Tên giảng viên không được để trống</div>


            <label for="" class="nhan-hieu-modal">Email</label>
            <input id="email-gv" name="email-gv" type="email" class="nhap-modal" placeholder="Điền email .. ">
            <div id="email-gv-error" class="tb-loi-nhap">Email không được để trống</div>

            <label for="" class="nhan-hieu-modal">Giới tính</label>
            <select id = "gioi-tinh-gv" name="gioi-tinh-gv" class="nhap-modal" required>
                <option value="">Please select</option>
                <option value="Nam">Nam</option>
                <option value="Nữ">Nữ</option>
            </select>
            <div id="gioi-tinh-gv-error" class="tb-loi-nhap">Chọn giới tính </div>

            <label for="" class="nhan-hieu-modal">Số điện thoại</label>
            <input id="sdt-gv" type="text" name="sdt-gv" class="nhap-modal" placeholder="Nhập số điện thoại ...">
            <div id="sdt-gv-error" class="tb-loi-nhap">Số điện thoại không được để trống </div>

            <label for="" class="nhan-hieu-modal">Mã khoa </label>
            <select id="ma-khoa-gv" name="ma-khoa-gv" class="nhap-modal" required>
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
            <div id="ma-khoa-gv-error" class="tb-loi-nhap">Chọn mã khoa</div>

        </div>
        <!-- modal footer -->
        <div class="cuoi-modal">
            <input class="them-btn" type="submit" value="Thêm"/>
        </div>
    </div>
</form>
