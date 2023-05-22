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
    <link rel="stylesheet" href="../../../assets/css/admin/subject.css">
    <link rel="stylesheet" href="../../../assets/css/admin/add_subject_form.css">
    <link rel="stylesheet" href="../../../assets/css/admin/update_subject_form.css">
    <link rel="stylesheet" href="../../../assets/css/pagination.css">
    <link rel="stylesheet" href="../../../assets/css/admin/confirm_delete_form.css">
    <title>Môn học</title>
</head>
<%
    HttpClient httpClient = HttpClientBuilder.create().build();

    // get session id
    String value = "JSESSIONID=";
    HttpSession getSession = request.getSession();
    String cookieValue = (String) getSession.getAttribute("cookie_value");

    // variables in request body
    String tenMonHoc = "";
    String sortField = "";
    String sortOrder = "";
    int pageSize = 10;

    int pageIndex = 1;
    if (session.getAttribute("pageIndexMH") != null) {
        pageIndex = (int) session.getAttribute("pageIndexMH");
    }

    System.out.println(session.getAttribute("pageIndexMH"));
    System.out.println("pageIndex in subject.jsp: " + pageIndex);

    // request body for getAll, finding and sorting
    String requestBody = "{" +
            "\"tenMonHoc\":\"" + tenMonHoc + "\"," +
            "\"baseRequest\":{" +
            "\"sortField\":\"" + sortField + "\"," +
            "\"sortOrder\":\"" + sortOrder + "\"," +
            "\"pageIndex\":" + pageIndex + "," +
            "\"pageSize\":" + pageSize +
            "}" +
            "}";

    //get all
    String uriGetAll = "http://localhost:8080/api/admin/home/subject/display";

    HttpPost httpPost = new HttpPost(uriGetAll);
    StringEntity entity = new StringEntity(requestBody);
    httpPost.setEntity(entity);

    httpPost.setHeader("Cookie", value + cookieValue);

    JSONArray listResp;
%>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<div class="manHinhChinh">
    <%!
        int totalPages;

        // Hàm Refresh lại trang lấy môn học
        public JSONArray getAllMh(HttpClient httpClient, HttpPost httpPost) throws IOException {
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
        // add MH
        String uriAddMH = "http://localhost:8080/api/admin/home/subject/create-or-edit";
        String idMh = request.getParameter("ma-mh");
        String tenMh = request.getParameter("ten-mh");
        String tinChi = request.getParameter("stc-mh");
        String idKhoa = request.getParameter("ma-khoa-mh");
        String requestBodyAddMH = "{" +
                "\"idMh\":\"" + idMh + "\"," +
                "\"tenMonHoc\":\"" + tenMh + "\"," +
                "\"tinChi\":\"" + tinChi + "\"," +
                "\"idKhoa\":\"" + idKhoa + "\"," +
                "\"flag\":\"" + 1 + "\"" +
                "}";
        // biến flag: thêm mới là 1, sửa là 0

        // send the request and retrieve the response
        boolean exist = false;
        if (idMh != null && tenMh != null && tinChi != null && idKhoa != null) {
            System.out.println(requestBodyAddMH);

            HttpPost httpPostAddMH = new HttpPost(uriAddMH);
            StringEntity entityAddMH = new StringEntity(requestBodyAddMH);
            httpPostAddMH.setEntity(entityAddMH);

            httpPostAddMH.setHeader("Cookie", value + cookieValue);

            HttpResponse respAddMH = httpClient.execute(httpPostAddMH);
            String responseBodyAddMH = EntityUtils.toString(respAddMH.getEntity());

            JSONObject jsonResponseAddMH = new JSONObject(responseBodyAddMH);

            if (jsonResponseAddMH.getInt("status") != 200) {
                exist = true;
            }

            // get all mon hoc
            if(!exist) {
                listResp = getAllMh(httpClient, httpPost);
            }
        }
    %>
    <%
        // update MH
        String uriUpdateMH = "http://localhost:8080/api/admin/home/subject/create-or-edit";
        String idMhU = request.getParameter("ma-mh-sua");
        String tenMhU = request.getParameter("ten-mh-sua");
        String tinChiU = request.getParameter("stc-mh-sua");
        String idKhoaU = request.getParameter("ma-khoa-mh-sua");
        String requestBodyUpdateMH = "{" +
                "\"idMh\":\"" + idMhU + "\"," +
                "\"tenMonHoc\":\"" + tenMhU + "\"," +
                "\"tinChi\":\"" + tinChiU + "\"," +
                "\"idKhoa\":\"" + idKhoaU + "\"," +
                "\"flag\":\"" + 0 + "\"" +
                "}";
        // send the request and retrieve the response
        if (idMhU != null && tenMhU != null && tinChiU != null && idKhoaU != null) {
            System.out.println(requestBodyUpdateMH);

            HttpPost httpPostUpdateMH = new HttpPost(uriUpdateMH);
            StringEntity entityUpdateMH = new StringEntity(requestBodyUpdateMH);
            httpPostUpdateMH.setEntity(entityUpdateMH);

            httpPostUpdateMH.setHeader("Cookie", value + cookieValue);

            HttpResponse respUpdateMH = httpClient.execute(httpPostUpdateMH);
            String responseBodyUpdateMH = EntityUtils.toString(respUpdateMH.getEntity());
            System.out.println(responseBodyUpdateMH);

            JSONObject jsonResponseUpdateMH = new JSONObject(responseBodyUpdateMH);
            System.out.println(jsonResponseUpdateMH);

            // get all mon hoc
            listResp = getAllMh(httpClient, httpPost);
        }
    %>
    <%
        // delete
        String idMhD = request.getParameter("ma-mh-xoa");
        URI uriDeleteMH = new URIBuilder("http://localhost:8080/api/admin/home/subject/display").setParameter("idMh", idMhD).build();
        if (idMhD != null) {
            HttpDelete httpDelete = new HttpDelete(uriDeleteMH);
            httpDelete.setHeader("Cookie", value + cookieValue);

            httpClient.execute(httpDelete);

            // get all mon hoc
            listResp = getAllMh(httpClient, httpPost);
        }
    %>
    <%
        // tìm kiếm
        tenMonHoc = request.getParameter("nhapTimKiem");
        if(tenMonHoc==null) tenMonHoc = "";
        System.out.println("Ten Mh: " + tenMonHoc);
        requestBody = "{" +
                "\"tenMonHoc\":\"" + tenMonHoc + "\"," +
                "\"baseRequest\":{" +
                "\"sortField\":\"" + sortField + "\"," +
                "\"sortOrder\":\"" + sortOrder + "\"," +
                "\"pageIndex\":" + pageIndex + "," +
                "\"pageSize\":" + pageSize +
                "}" +
                "}";
        entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);
        listResp = getAllMh(httpClient, httpPost);

        // return UTF8
        byte[] bytes = tenMonHoc.getBytes(StandardCharsets.ISO_8859_1);
        tenMonHoc = new String(bytes, StandardCharsets.UTF_8);
    %>
    <%
        // sort
        sortField = request.getParameter("sortFieldMH");
        sortOrder = request.getParameter("sortOrderMH");
        if(sortField!=null) {
            tenMonHoc = request.getParameter("tenMh");
            if(tenMonHoc==null) tenMonHoc = "";

            requestBody = "{"+
                    "\"tenMonHoc\":\"" + tenMonHoc + "\","+
                    "\"baseRequest\":{"+
                    "\"sortField\":\"" + sortField + "\","+
                    "\"sortOrder\":\"" + sortOrder + "\","+
                    "\"pageIndex\":" + pageIndex + ","+
                    "\"pageSize\":" + pageSize +
                    "}"+
                    "}";
            entity = new StringEntity(requestBody);
            httpPost.setEntity(entity);

            System.out.println("Sort Field: " + sortField);
            System.out.println("Sort Order: " + sortOrder);
            System.out.println("Ten MH sort: " + tenMonHoc);
            listResp = getAllMh(httpClient, httpPost);

            // return UTF8
            bytes = tenMonHoc.getBytes(StandardCharsets.ISO_8859_1);
            tenMonHoc = new String(bytes, StandardCharsets.UTF_8);
        }
    %>
    <h1 class="tieuDeTrang">Danh sách môn học</h1>
    <div class="themVaTimKiem">
        <!-- nut them mon hoc -->
        <button id="nut_them_MH" onclick="showModal('modal_mon_hoc')" class="nutThemMH js-nutThemMH"
                type="button">
            <span class="nutThemMH_tieuDe">Thêm môn học</span>
            <i class="fa-solid fa-plus"></i>
        </button>
        <form class="timKiem" method="post">
            <div class="tieuDeTimKiem">Tìm kiếm môn học: </div>
            <input type="search" id="nhapTimKiem" name="nhapTimKiem" placeholder="Nhập tên môn học" value="<%= tenMonHoc %>">
            <button class="nutTimKiem" type="submit">
                <span class="nutTimKiem_tieuDe">Tìm</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </button>
        </form>
    </div>
    <div class="boc-bang">
        <form id="formMH" method="post" action="/admin/subject">
            <input type="hidden" name="tenMh" value="<%=tenMonHoc%>">
            <input type="hidden" name="sortFieldMH" value="<%=sortField%>">
            <input type="hidden" name="sortOrderMH" value="<%=sortOrder%>">
            <input type="hidden" name="pageIndexMH" value="<%=pageIndex%>">
            <input type="hidden" name="pageSizeMH" value="<%=pageSize%>">
            <table class="danhSach">
                <thead class="hang1">
                    <th data-sort onclick="sortTable('idMh', this)" class="cot-maMH idMh">Mã môn học</th>
                    <th data-sort onclick="sortTable('tenMonHoc', this)" class="cot-tenMH tenMonHoc">Tên môn học</th>
                    <th data-sort onclick="sortTable('tinChi', this)" class="cot-TC tinChi">Số tín chỉ</th>
                    <th data-sort onclick="sortTable('idKhoa', this)" class="cot-khoa idKhoa">Khoa</th>
                    <th data-sort onclick="sortTable('trangThai', this)" class="cot-trangThai trangThai">Trạng thái</th>
                    <th data-sort onclick="sortTable('ngayTao', this)" class="cot-ngayTao ngayTao">Ngày tạo</th>
                    <th data-sort onclick="sortTable('ngaySua', this)" class="cot-ngayTao ngaySua">Ngày cập nhật</th>
                    <th class="hanh-dong">Action</th>
                </thead>
                <tbody>
                    <%--            hiển thị ra màn hình--%>
                    <%  if (listResp != null) {
                        for (int i = 0; i < listResp.length(); i++) {%>
                    <% JSONObject subject = listResp.getJSONObject(i); %>
                    <tr>
                        <td class="cot-maMH"><%=subject.getString("idMh")%></td>
                        <td><%=subject.getString("tenMonHoc")%></td>
                        <td class="cot-TC"><%=subject.getInt("tinChi")%></td>
                        <td><%=subject.getString("tenKhoa")%></td>
                        <%
                            if(subject.getInt("trangThai")==1) {
                        %>
                        <td class="dangGiangDay">Còn giảng dạy</td>
                        <%
                        }
                        else {
                        %>
                        <td class="ngungGiangDay">Ngừng giảng dạy</td>
                        <%
                            }
                        %>
                        <td><%=subject.getString("ngayTao")%></td>
                        <td><%=subject.getString("ngaySua")%></td>
                        <td class="chucNang">
                            <%
                                if(subject.getInt("trangThai")==1) {
                            %>
                            <div class="hop-hanh-dong">
                                <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_mon_hoc_sua', '<%=subject.getString("idMh")%>', '<%=subject.getString("tenMonHoc")%>', '<%=subject.getInt("tinChi")%>', '<%=subject.getString("idKhoa")%>')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                </button>
                                <button onclick="hienXacNhanXoa('modal_xac_nhan_xoa', '<%=subject.getString("idMh")%>', 'ma-mh-xoa')" class="xoa hop-hanh-dong-nut" type="button">
                                    <span class="xoa_tieuDe">Xóa</span>
                                    <i class="fa-solid fa-trash xoa_icon"></i>
                                </button>
                            </div>
                            <%
                                }
                            %>
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
    <%@include file="add_subject_form.jsp" %>
    <%@include file="update_subject_form.jsp" %>
    <%@include file="confirm_delete_subject.jsp" %>
</div>
</body>
    <script src="../../../assets/js/pagination.js"></script>
    <script>
        if(<%= exist %>) {
            alert("Mã môn học hoặc môn học đã tồn tại");
        }

        // do lúc gửi đoạn sort nó hay load lại trang dẫn đến không kịp lưu lại class, hàm này dùng để lấy session đã lưu
        // trong SubjectSessionController, gán nó vào class để hiển thị giao diện mũi tên là đang sort theo cột nào, asc hay desc
        if('${sessionScope.sortFieldMH}'!=='null' && '${sessionScope.sortFieldMH}'!=='') {
            const getTd = document.querySelector('.${sessionScope.sortFieldMH}');
            const asc = '${sessionScope.sortOrderMH}'==='desc';
            getTd.classList[asc ? 'remove' : 'add']('asc');
            getTd.classList[asc ? 'add' : 'remove']('desc');
        }

        // hàm sort cột
        function sortTable(field, event) {
            const tenMhInput = document.querySelector('input[name="tenMh"]');
            const sortFieldInput = document.querySelector('input[name="sortFieldMH"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderMH"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexMH"]');

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

            // Lấy phần tên trong khu vực tìm kiếm (nếu có)
            console.log('Tên môn học trước khi gán giá trị: ' + tenMhInput.value);
            console.log('Nhập tìm kiếm: ' + document.querySelector('#nhapTimKiem').value);
            if(document.querySelector('#nhapTimKiem').value!==null) {
                tenMhInput.value = document.querySelector('#nhapTimKiem').value;
            }
            // Submit the form
            document.getElementById("formMH").submit();
        }

        // tạo UI phân trang
        createPaginationUI(<%= totalPages %>, <%= pageIndex %>);

        // nút chuyển sang trang trước đó
        function nutPrev() {
            const pageIndexInput = document.querySelector('input[name="pageIndexMH"]');
            console.log('Page Index Before: ' + pageIndexInput.value);

            // Kiểm tra xem hiện tại có đang ở trang đầu tiên k
            if(pageIndexInput.value>1) {
                pageIndexInput.value--;
                document.getElementById("formMH").submit();
            }
        }

        // nút chuyển sang trang tiếp theo
        function nutNext() {
            const sortFieldInput = document.querySelector('input[name="sortFieldMH"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderMH"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexMH"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldMH}'!=='null' && '${sessionScope.sortFieldMH}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldMH}';
                sortOrderInput.value = '${sessionScope.sortOrderMH}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            // Kiểm tra xem hiện tại có đang ở trang cuối cùng k
            if(+pageIndexInput.value < <%= totalPages %>) {
                pageIndexInput.value = +pageIndexInput.value + 1;
                document.getElementById("formMH").submit();
            }
        }

        // nút chọn 1 trang
        function nutTrang(page) {
            const sortFieldInput = document.querySelector('input[name="sortFieldMH"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderMH"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexMH"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldMH}'!=='null' && '${sessionScope.sortFieldMH}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldMH}';
                sortOrderInput.value = '${sessionScope.sortOrderMH}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            pageIndexInput.value = page;
            document.getElementById("formMH").submit();
        }
    </script>
    <script src="../../../assets/js/menu.js"></script>
    <script src="../../../assets/js/admin/update_subject.js"></script>
    <script src="../../../assets/js/admin/add_form.js"></script>
    <script src="../../../assets/js/admin/text_error_subject.js"></script>
    <script src="../../../assets/js/admin/confirm_delete_form.js"></script>
</html>