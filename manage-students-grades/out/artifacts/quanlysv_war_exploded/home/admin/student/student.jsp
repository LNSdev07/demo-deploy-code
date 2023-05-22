<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.*" %>
<%@ page import="org.apache.http.client.methods.HttpPost" %>
<%@ page import="org.apache.http.client.HttpClient" %>
<%@ page import="org.apache.http.HttpResponse" %>
<%@ page import="org.json.*" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="org.apache.http.entity.StringEntity" %>
<%@ page import="org.apache.http.impl.client.HttpClientBuilder" %>
<%@ page import="org.apache.http.client.methods.HttpDelete" %>
<%@ page import="org.apache.http.client.utils.URIBuilder" %>
<%@ page import="java.net.URI" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<html>
<head>
    <%@include file="../menu/admin_menu_header.jsp" %>
    <link rel="stylesheet" href="../../../assets/css/admin/student.css">
    <link rel="stylesheet" href="../../../assets/css/admin/add_student_form.css">
    <link rel="stylesheet" href="../../../assets/css/admin/update_student_form.css">
    <link rel="stylesheet" href="../../../assets/css/pagination.css">
    <link rel="stylesheet" href="../../../assets/css/admin/confirm_delete_form.css">
    <title>Sinh viên</title>
</head>
<%
    HttpClient httpClient = HttpClientBuilder.create().build();

    // get session id
    String value = "JSESSIONID=";
    HttpSession getSession = request.getSession();
    String cookieValue = (String) getSession.getAttribute("cookie_value");

    // variables in request body
    String idSv = "";
    String tenSv = "";
    String sortField = "";
    String sortOrder = "";
    int pageSize = 10;

    int pageIndex = 1;
    if (session.getAttribute("pageIndexSV") != null) {
        pageIndex = (int) session.getAttribute("pageIndexSV");
    }

    // request body for getAll, finding and sorting
    String requestBody = "{" +
            "\"idSv\":\"" + idSv + "\"," +
            "\"tenSv\":\"" + tenSv + "\"," +
            "\"baseRequest\":{" +
            "\"sortField\":\"" + sortField + "\"," +
            "\"sortOrder\":\"" + sortOrder + "\"," +
            "\"pageIndex\":" + pageIndex + "," +
            "\"pageSize\":" + pageSize +
            "}" +
            "}";

    //get all
    String uriGetAll = "http://localhost:8080/api/admin/home/student";

    HttpPost httpPost = new HttpPost(uriGetAll);
    StringEntity entity = new StringEntity(requestBody);
    httpPost.setEntity(entity);

    httpPost.setHeader("Cookie", value + cookieValue);

    // call function, return data
    JSONArray listResp;
%>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<div class="manHinhChinh">
    <%!
        int totalPages;

        // Hàm Refresh lại trang lấy sinh vien
        public JSONArray getAllSv(HttpClient httpClient, HttpPost httpPost) throws IOException {
            HttpResponse resp = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(resp.getEntity());
            JSONObject jsonResponse = new JSONObject(responseBody);
            if (jsonResponse.getInt("status") == 200) {
                totalPages = jsonResponse.getInt("totalPages");
                return jsonResponse.getJSONArray("data");
            } else {
                return null;
            }
        }
    %>
    <%
        // add SV (status = 0)
        String uriAddSV = "http://localhost:8080/api/admin/home/student/create-or-edit";
        String idSvAdd = request.getParameter("ma-sv");
        String tenSvAdd = request.getParameter("ten-sv");
        String emailSv = request.getParameter("email-sv");
        String dobSv = request.getParameter("dob-sv");
        String genderSv = request.getParameter("gioi-tinh-sv");
        String sdtSv = request.getParameter("sdt-sv");
        String lopSv = request.getParameter("ma-lop-sv");

        // send the request and retrieve the response
        boolean exist = false;
        if (idSvAdd != null && tenSvAdd != null && emailSv != null && dobSv != null && genderSv != null && sdtSv != null  && lopSv != null) {
            // reformat dob (current: 04-07-2002)
            String[] dob = dobSv.split("-");
            dobSv= dob[2] + "/" + dob[1] + "/" + dob[0];

            String requestBodyAddSV = "{" +
                    "\"status\":" + 0 + "," +
                    "\"idSv\":\"" + idSvAdd + "\"," +
                    "\"tenSv\":\"" + tenSvAdd + "\"," +
                    "\"emailSv\":\"" + emailSv + "\"," +
                    "\"dobSv\":\"" + dobSv + "\"," +
                    "\"genderSv\":\"" + genderSv + "\"," +
                    "\"phoneSv\":\"" + sdtSv + "\"," +
                    "\"lopHanhChinhSv\":\"" + lopSv + "\"" +
                    "}";

            System.out.println(requestBodyAddSV);

            HttpPost httpPostAddSV = new HttpPost(uriAddSV);
            StringEntity entityAddSV = new StringEntity(requestBodyAddSV);
            httpPostAddSV.setEntity(entityAddSV);

            httpPostAddSV.setHeader("Cookie", value + cookieValue);

            HttpResponse respAddSV = httpClient.execute(httpPostAddSV);
            String responseBodyAddSV = EntityUtils.toString(respAddSV.getEntity());

            JSONObject jsonResponseAddSV = new JSONObject(responseBodyAddSV);

            if (jsonResponseAddSV.getInt("status") != 200) {
                exist = true;
            }
            System.out.println(jsonResponseAddSV);

            // get all sinh vien
            if(!exist) {
                listResp = getAllSv(httpClient, httpPost);
            }
        }
    %>
    <%
        // update SV (status = 1)
        String uriUpdateSV = "http://localhost:8080/api/admin/home/student/create-or-edit";
        String idSvUpdate = request.getParameter("ma-sv-sua");
        String tenSvUpdate = request.getParameter("ten-sv-sua");
        String emailSvU = request.getParameter("email-sv-sua");
        String dobSvU = request.getParameter("dob-sv-sua");
        String genderSvU = request.getParameter("gioi-tinh-sv-sua");
        String sdtSvU = request.getParameter("sdt-sv-sua");
        String lopSvU = request.getParameter("ma-lop-sv-sua");

        if (idSvUpdate != null && tenSvUpdate != null && emailSvU != null && dobSvU != null && genderSvU != null && sdtSvU != null  && lopSvU != null) {
            // reformat dob (current: 04-07-2002)
            String[] dob = dobSvU.split("-");
            dobSvU= dob[2] + "/" + dob[1] + "/" + dob[0];

            String requestBodyUpdateSV = "{" +
                    "\"status\":" + 1 + "," +
                    "\"idSv\":\"" + idSvUpdate + "\"," +
                    "\"tenSv\":\"" + tenSvUpdate + "\"," +
                    "\"emailSv\":\"" + emailSvU + "\"," +
                    "\"dobSv\":\"" + dobSvU + "\"," +
                    "\"genderSv\":\"" + genderSvU + "\"," +
                    "\"phoneSv\":\"" + sdtSvU + "\"," +
                    "\"lopHanhChinhSv\":\"" + lopSvU + "\"" +
                    "}";

            System.out.println(requestBodyUpdateSV);

            HttpPost httpPostUpdateSV = new HttpPost(uriUpdateSV);
            StringEntity entityUpdateSV = new StringEntity(requestBodyUpdateSV);
            httpPostUpdateSV.setEntity(entityUpdateSV);

            httpPostUpdateSV.setHeader("Cookie", value + cookieValue);

            HttpResponse respUpdateSV = httpClient.execute(httpPostUpdateSV);
            String responseBodyUpdateSV = EntityUtils.toString(respUpdateSV.getEntity());

            JSONObject jsonResponseUpdateSV = new JSONObject(responseBodyUpdateSV);
            System.out.println(jsonResponseUpdateSV);

            // get all sinh vien
            listResp = getAllSv(httpClient, httpPost);
        }
    %>
    <%
        // delete
        String idSvD = request.getParameter("ma-sv-xoa");
        URI uriDeleteSV = new URIBuilder("http://localhost:8080/api/admin/home/student").setParameter("idSv", idSvD).build();
        if (idSvD != null) {
            HttpDelete httpDelete = new HttpDelete(uriDeleteSV);
            httpDelete.setHeader("Cookie", value + cookieValue);

            httpClient.execute(httpDelete);

            // get all sinh vien
            listResp = getAllSv(httpClient, httpPost);
        }
    %>
    <%
        // tìm kiếm
        idSv = request.getParameter("timIdSv");
        tenSv = request.getParameter("timTenSv");

        if(idSv == null) idSv = "";
        if(tenSv == null) tenSv = "";

        System.out.println("Ma Sv tim kiem: " + idSv);
        System.out.println("Ten Sv tim kiem: " + tenSv);
        requestBody = "{" +
                "\"idSv\":\"" + idSv + "\"," +
                "\"tenSv\":\"" + tenSv + "\"," +
                "\"baseRequest\":{" +
                "\"sortField\":\"" + sortField + "\"," +
                "\"sortOrder\":\"" + sortOrder + "\"," +
                "\"pageIndex\":" + pageIndex + "," +
                "\"pageSize\":" + pageSize +
                "}" +
                "}";
        entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);
        listResp = getAllSv(httpClient, httpPost);

        // return UTF8
        byte[] bytes = tenSv.getBytes(StandardCharsets.ISO_8859_1);
        tenSv = new String(bytes, StandardCharsets.UTF_8);
    %>
    <%
        // sort
        sortField = request.getParameter("sortFieldSV");
        sortOrder = request.getParameter("sortOrderSV");
        if(sortField!=null) {
            idSv = request.getParameter("idSv");
            tenSv = request.getParameter("tenSv");

            if(idSv == null) idSv = "";
            if(tenSv == null) tenSv = "";

            requestBody = "{" +
                    "\"idSv\":\"" + idSv + "\"," +
                    "\"tenSv\":\"" + tenSv + "\"," +
                    "\"baseRequest\":{" +
                    "\"sortField\":\"" + sortField + "\"," +
                    "\"sortOrder\":\"" + sortOrder + "\"," +
                    "\"pageIndex\":" + pageIndex + "," +
                    "\"pageSize\":" + pageSize +
                    "}" +
                    "}";
            entity = new StringEntity(requestBody);
            httpPost.setEntity(entity);

            System.out.println("Sort Field: " + sortField);
            System.out.println("Sort Order: " + sortOrder);
            System.out.println("idSv sort: " + idSv);
            System.out.println("tenSv sort: " + tenSv);
            listResp = getAllSv(httpClient, httpPost);

            // return UTF8
            bytes = tenSv.getBytes(StandardCharsets.ISO_8859_1);
            tenSv = new String(bytes, StandardCharsets.UTF_8);
        }
    %>
    <div class="dauTrang">
        <h1 class="tieuDeTrang">Danh sách sinh viên</h1>
        <button id="nut_them_SV" onclick="showModal('modal_sinh_vien')" class="nutThemSV js-nutThemSV"
                type="button">
            <span class="nutThemSV_tieuDe">Thêm sinh viên</span>
            <i class="fa-solid fa-plus"></i>
        </button>
    </div>

    <form class="khuVucTimKiem" method="post">
        <div class="khuVucTimKiem-dau">
            <div class="tieuDeTimKiem">Tìm kiếm sinh viên</div>
        </div>
        <div class="khuVucTimKiem-phanThan">
            <div class="phanTimKiem">
                <input type="search" class="nhapTimKiem" id="timIdSv" name="timIdSv" placeholder="Nhập mã sinh viên" value="<%=idSv%>">
                <input type="search" class="nhapTimKiem" id="timTenSv" name="timTenSv" placeholder="Nhập tên sinh viên" value="<%=tenSv%>">
            </div>
            <div class="timKiem-cacNut">
                <button class="nutTimKiem" type="submit">
                    <span class="nutTimKiem_tieuDe">Tìm</span>
                    <i class="fa-solid fa-magnifying-glass"></i>
                </button>
                <button class="nutReset" onclick="clearSearchBar()" type="submit">
                    <span class="nutReset_tieuDe">Reset</span>
                    <i class="fa-solid fa-arrow-rotate-back"></i>
                </button>
            </div>
        </div>
    </form>

    <div class="boc-bang">
        <form id="formSV" method="post" action="/admin/student">
            <input type="hidden" name="idSv" value="<%=idSv%>">
            <input type="hidden" name="tenSv" value="<%=tenSv%>">
            <input type="hidden" name="sortFieldSV" value="<%=sortField%>">
            <input type="hidden" name="sortOrderSV" value="<%=sortOrder%>">
            <input type="hidden" name="pageIndexSV" value="<%=pageIndex%>">
            <input type="hidden" name="pageSizeSV" value="<%=pageSize%>">
            <table id="myTable" class="danhSach">
                <thead class="hang1">
                <th data-sort onclick="sortTable('idSv', this)" class="cot-maSV idSv">Mã SV</th>
                <th data-sort onclick="sortTable('tenSv', this)" class="cot-tenSV tenSv">Họ và tên</th>
                <th class="cot-emailSV">Email</th>
                <th class="cot-ngaySinhSV">Ngày sinh</th>
                <th data-sort onclick="sortTable('genderSv', this)" class="cot-gioiTinhSV genderSv">Giới tính</th>
                <th class="cot-sdtSV">Số điện thoại</th>
                <th data-sort onclick="sortTable('lopHanhChinhSv', this)" class="cot-lopSV lopHanhChinhSv">Lớp hành chính</th>
                <th data-sort onclick="sortTable('trangThai', this)" class="cot-trangThai trangThai">Trạng thái</th>
                <th data-sort onclick="sortTable('ngayTao', this)" class="cot-ngayTao ngayTao">Ngày tạo</th>
                <th data-sort onclick="sortTable('ngaySua', this)" class="cot-ngayTao ngaySua">Ngày cập nhật</th>
                <th class="hanh-dong">Action</th>
                </thead>
                <tbody>
                    <%--            hiển thị ra màn hình--%>
                    <%  if (listResp != null) {
                        for (int i = 0; i < listResp.length(); i++) {%>
                    <% JSONObject student = listResp.getJSONObject(i); %>
                    <tr>
                        <td><%=student.getString("idSv")%></td>
                        <td><%=student.getString("tenSv")%></td>
                        <td><%=student.getString("emailSv")%></td>
                        <td><%=student.getString("dobSv")%></td>
                        <td><%=student.getString("genderSv")%></td>
                        <td><%=student.getString("phoneSv")%></td>
                        <td><%=student.getString("lopHanhChinhSv")%></td>
                        <%
                            if(student.getInt("trangThai")==1) {
                        %>
                        <td class="dangHoc">Đang học</td>
                        <%
                        }
                        else {
                        %>
                        <td class="daThoiHoc">Đã thôi học</td>
                        <%
                            }
                        %>
                        <td><%=student.getString("ngayTao")%></td>
                        <td><%=student.getString("ngaySua")%></td>
                        <td class="chucNang">
                            <div class="hop-hanh-dong">
                                <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_sinh_vien_sua', '<%=student.getString("idSv")%>', '<%=student.getString("tenSv")%>', '<%=student.getString("emailSv")%>','<%=student.getString("dobSv")%>', '<%=student.getString("genderSv")%>', '<%=student.getString("phoneSv")%>', '<%=student.getString("lopHanhChinhSv")%>')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                </button>
                                <%
                                    if(student.getInt("trangThai")==1) {
                                %>
                                <button onclick="hienXacNhanXoa('modal_xac_nhan_xoa', '<%=student.getString("idSv")%>', 'ma-sv-xoa')" class="xoa hop-hanh-dong-nut" type="button">
                                    <span class="xoa_tieuDe">Xóa</span>
                                    <i class="fa-solid fa-trash xoa_icon"></i>
                                </button>
                                <%
                                    }
                                %>
                            </div>
                        </td>
                    </tr>
                    <% }
                    }%>
                </tbody>
            </table>
        </form>
    </div>
    <div class="phanTrang">
        <ul>
            <li class="nutPaginate prev" style="color: white" onclick="nutPrev()">
                <span><i class="fas fa-angle-left"></i></span>
            </li>
            <span class="soTrang">

            </span>
            <li class="nutPaginate next" style="color: white" onclick="nutNext()">
                <span><i class="fas fa-angle-right"></i></span>
            </li>
        </ul>
    </div>
    <!-- Them sinh vien dialog -->
    <%@include file="add_student_form.jsp" %>
    <%@include file="update_student_form.jsp" %>
    <%@include file="confirm_delete_student.jsp"%>
</div>
</body>
    <script src="../../../assets/js/pagination.js"></script>
    <script>
        if(<%= exist %>) {
            alert("Mã sinh viên, email sinh viên hoặc số điện thoại đã tồn tại\nVui lòng kiểm tra lại thông tin nhập");
        }

        // hàm đc gọi khi bấm nút reset
        function clearSearchBar() {
            document.getElementById("timIdSv").value = "";
            document.getElementById("timTenSv").value = "";
        }

        // do lúc gửi đoạn sort nó hay load lại trang dẫn đến không kịp lưu lại class, hàm này dùng để lấy session đã lưu
        // trong SubjectSessionController, gán nó vào class để hiển thị giao diện mũi tên là đang sort theo cột nào, asc hay desc
        if('${sessionScope.sortFieldSV}'!=='null' && '${sessionScope.sortFieldSV}'!=='') {
            const getTd = document.querySelector('.${sessionScope.sortFieldSV}');
            const asc = '${sessionScope.sortOrderSV}'==='desc';
            getTd.classList[asc ? 'remove' : 'add']('asc');
            getTd.classList[asc ? 'add' : 'remove']('desc');
        }

        // hàm sort cột
        function sortTable(field, event) {
            const idSVInput = document.querySelector('input[name="idSv"]');
            const tenSVInput = document.querySelector('input[name="tenSv"]');
            const sortFieldInput = document.querySelector('input[name="sortFieldSV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderSV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexSV"]');

            const thead=document.querySelector('thead');
            const hData=[...thead.querySelectorAll('th')]

            hData.map((head) => {
                if(head!==event) {
                    head.classList.remove('asc', 'desc')
                }
            });

            if (sortFieldInput.value === field) {
                const asc = sortOrderInput.value === "asc"
                event.classList[asc ? 'remove' : 'add']('asc');
                event.classList[asc ? 'add' : 'remove']('desc');
                sortOrderInput.value = sortOrderInput.value === "asc" ? "desc" : "asc";
            } else {
                event.classList.add('asc');
                sortFieldInput.value = field;
                sortOrderInput.value = "asc";
            }

            // sau khi sort, quay trở lại trang đầu tiên
            pageIndexInput.value = 1;

            // Lấy phần id và tên trong khu vực tìm kiếm (nếu có)
            if(document.querySelector('#timIdSv').value!==null) {
                idSVInput.value = document.querySelector('#timIdSv').value;
            }
            if(document.querySelector('#timTenSv').value!==null) {
                tenSVInput.value = document.querySelector('#timTenSv').value;
            }
            // Submit the form
            document.getElementById("formSV").submit();
        }

        // tạo UI phân trang
        createPaginationUI(<%= totalPages %>, <%= pageIndex %>);

        // nút chuyển sang trang trước đó
        function nutPrev() {
            const pageIndexInput = document.querySelector('input[name="pageIndexSV"]');
            console.log('Page Index Before: ' + pageIndexInput.value);

            // Kiểm tra xem hiện tại có đang ở trang đầu tiên k
            if(pageIndexInput.value>1) {
                pageIndexInput.value--;
                document.getElementById("formSV").submit();
            }
        }

        // nút chuyển sang trang tiếp theo
        function nutNext() {
            const sortFieldInput = document.querySelector('input[name="sortFieldSV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderSV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexSV"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldSV}'!=='null' && '${sessionScope.sortFieldSV}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldSV}';
                sortOrderInput.value = '${sessionScope.sortOrderSV}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            // Kiểm tra xem hiện tại có đang ở trang cuối cùng k
            if(+pageIndexInput.value < <%= totalPages %>) {
                pageIndexInput.value = +pageIndexInput.value + 1;
                document.getElementById("formSV").submit();
            }
        }

        // nút chọn 1 trang
        function nutTrang(page) {
            const sortFieldInput = document.querySelector('input[name="sortFieldSV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderSV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexSV"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldSV}'!=='null' && '${sessionScope.sortFieldSV}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldSV}';
                sortOrderInput.value = '${sessionScope.sortOrderSV}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            pageIndexInput.value = page;
            document.getElementById("formSV").submit();
        }
    </script>
    <script src="../../../assets/js/menu.js"></script>
    <script src="../../../assets/js/admin/add_form.js"></script>
    <script src="../../../assets/js/admin/update_student.js"></script>
    <script src="../../../assets/js/admin/text_error_student.js"></script>
    <script src="../../../assets/js/admin/confirm_delete_form.js"></script>
</html>
