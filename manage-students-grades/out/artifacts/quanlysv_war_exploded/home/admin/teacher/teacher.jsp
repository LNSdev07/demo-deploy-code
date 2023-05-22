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
    <meta charset="UTF-8">
    <%@include file="../menu/admin_menu_header.jsp" %>
    <link rel="stylesheet" href="../../../assets/css/admin/teacher.css">
    <link rel="stylesheet" href="../../../assets/css/admin/add_teacher_form.css">
    <link rel="stylesheet" href="../../../assets/css/admin/update_teacher_form.css">
    <link rel="stylesheet" href="../../../assets/css/pagination.css">
    <link rel="stylesheet" href="../../../assets/css/admin/confirm_delete_form.css">
    <title>Giảng viên</title>
</head>
<%
    HttpClient httpClient = HttpClientBuilder.create().build();

    // get session id
    String value="JSESSIONID=";
    HttpSession getSession = request.getSession();
    String cookieValue = (String) getSession.getAttribute("cookie_value");

    // variables in request body
    String tenGv = "";
    String sortField = "";
    String sortOrder = "";
    int pageSize = 10;

    int pageIndex = 1;
    if(session.getAttribute("pageIndexGV")!=null) {
        pageIndex = (int) session.getAttribute("pageIndexGV");
    }

    System.out.println(session.getAttribute("pageIndexGV"));
    System.out.println("pageIndex in teacher.jsp: " + pageIndex);
    System.out.println("pageSize in teacher.jsp: " + pageSize);

    // request body for getAll, finding and sorting
    String requestBody ="{"+
            "\"tenGv\":\"" + tenGv + "\","+
            "\"baseRequest\":{"+
            "\"sortField\":\"" + sortField + "\","+
            "\"sortOrder\":\"" + sortOrder + "\","+
            "\"pageIndex\":" + pageIndex + ","+
            "\"pageSize\":" + pageSize +
            "}"+
            "}";

    //get all
    String uriGetAll = "http://localhost:8080/api/admin/home/teacher";

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

        // Hàm Refresh lại trang lấy giảng viên
        public JSONArray getAllGv(HttpClient httpClient, HttpPost httpPost) throws IOException {
            HttpResponse resp  = httpClient.execute(httpPost);
            String responseBody = EntityUtils.toString(resp.getEntity());
            JSONObject jsonResponse = new JSONObject(responseBody);
            if(jsonResponse.getInt("status")==200) {
                totalPages = jsonResponse.getInt("totalPages");
                return jsonResponse.getJSONArray("data");
            } else {
                return null;
            }
        }
    %>
    <%
        // add GV
        String uriAddGV = "http://localhost:8080/api/admin/home/teacher/create-or-edit";
        String idGv = request.getParameter("ma-gv");
        String nameGv = request.getParameter("ten-gv");
        String emailGv = request.getParameter("email-gv");
        String genderGv = request.getParameter("gioi-tinh-gv");
        String sdtGv = request.getParameter("sdt-gv");
        String idKhoa = request.getParameter("ma-khoa-gv");
        String requestBodyAddGV = "{"+
                "\"status\":\"" + 0 + "\","+
                "\"idGv\":\"" + idGv + "\","+
                "\"tenGv\":\"" + nameGv + "\","+
                "\"sdtGv\":\"" + sdtGv + "\","+
                "\"emailGv\":\"" + emailGv + "\","+
                "\"genderGv\":\"" + genderGv + "\","+
                "\"idKhoa\":\"" + idKhoa + "\"" +
                "}";

        boolean exist = false;
        // send the request and retrieve the response
        if(idGv!=null && nameGv!=null && emailGv!=null && genderGv!=null && sdtGv!=null && idKhoa!=null) {
            System.out.println(requestBodyAddGV);

            HttpPost httpPostAddGV = new HttpPost(uriAddGV);
            StringEntity entityAddGV = new StringEntity(requestBodyAddGV);
            httpPostAddGV.setEntity(entityAddGV);

            httpPostAddGV.setHeader("Cookie",value+cookieValue);

            HttpResponse respAddGV = httpClient.execute(httpPostAddGV);
            String responseBodyAddGV = EntityUtils.toString(respAddGV.getEntity());
            System.out.println(responseBodyAddGV);

            JSONObject jsonResponseAddGV = new JSONObject(responseBodyAddGV);

            // check if the data is existed or not
            if (jsonResponseAddGV.getInt("status") != 200) {
                exist = true;
            }

            // get all mon hoc
            if(!exist) {
                listResp = getAllGv(httpClient, httpPost);
            }
        }
    %>
    <%
        // update GV
        String uriUpdateGV = "http://localhost:8080/api/admin/home/teacher/create-or-edit";
        String idGvU = request.getParameter("ma-gv-sua");
        String tenGvU = request.getParameter("ten-gv-sua");
        String emailGvU = request.getParameter("email-gv-sua");
        String genderGvU = request.getParameter("gioi-tinh-gv-sua");
        String sdtGvU = request.getParameter("sdt-gv-sua");
        String idKhoaU = request.getParameter("ma-khoa-gv-sua");
        String requestBodyUpdateGV ="{"+
                "\"status\":\"" + 1 + "\","+
                "\"idGv\":\"" + idGvU + "\","+
                "\"tenGv\":\"" + tenGvU + "\","+
                "\"sdtGv\":\"" + sdtGvU + "\","+
                "\"emailGv\":\"" + emailGvU + "\","+
                "\"genderGv\":\"" + genderGvU + "\","+
                "\"idKhoa\":\"" + idKhoaU + "\"" +
                "}";
        // send the request and retrieve the response
        if(idGvU!=null && tenGvU!=null && emailGvU!=null && genderGvU!=null && sdtGvU!=null && idKhoaU!=null) {
            System.out.println(requestBodyUpdateGV);

            HttpPost httpPostUpdateGV = new HttpPost(uriUpdateGV);
            StringEntity entityUpdateGV = new StringEntity(requestBodyUpdateGV);
            httpPostUpdateGV.setEntity(entityUpdateGV);

            httpPostUpdateGV.setHeader("Cookie",value+cookieValue);

            HttpResponse respUpdateGV = httpClient.execute(httpPostUpdateGV);
            String responseBodyUpdateGV = EntityUtils.toString(respUpdateGV.getEntity());
            System.out.println(responseBodyUpdateGV);

            JSONObject jsonResponseUpdateGV = new JSONObject(responseBodyUpdateGV);
            System.out.println(jsonResponseUpdateGV);

            // get all giang vien
            listResp = getAllGv(httpClient, httpPost);
        }
    %>
    <%
        // delete
        String idGvD = request.getParameter("ma-gv-xoa");
        URI uriDeleteGV = new URIBuilder("http://localhost:8080/api/admin/home/teacher").setParameter("id", idGvD).build();
        if(idGvD!=null) {
            HttpDelete httpDelete = new HttpDelete(uriDeleteGV);
            httpDelete.setHeader("Cookie",value+cookieValue);

            httpClient.execute(httpDelete);

            // get all giang vien
            listResp = getAllGv(httpClient, httpPost);
        }
    %>
    <%
        // tìm kiếm
        tenGv = request.getParameter("nhapTimKiem");
        if(tenGv==null) tenGv = "";
        System.out.println("Ten GV tim kiem: " + tenGv);
        requestBody = "{"+
                "\"tenGv\":\"" + tenGv + "\","+
                "\"baseRequest\":{"+
                "\"sortField\":\"" + sortField + "\","+
                "\"sortOrder\":\"" + sortOrder + "\","+
                "\"pageIndex\":" + pageIndex + ","+
                "\"pageSize\":" + pageSize +
                "}"+
                "}";
        entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);
        listResp = getAllGv(httpClient, httpPost);

        // return UTF8
        byte[] bytes = tenGv.getBytes(StandardCharsets.ISO_8859_1);
        tenGv = new String(bytes, StandardCharsets.UTF_8);
    %>
    <%
        // sort
        sortField = request.getParameter("sortFieldGV");
        sortOrder = request.getParameter("sortOrderGV");
        if(sortField!=null) {
            tenGv = request.getParameter("tenGv");
            if(tenGv==null) tenGv = "";
            System.out.println("Ten GV sort: " + tenGv);

            requestBody = "{"+
                    "\"tenGv\":\"" + tenGv + "\","+
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
            System.out.println("Ten GV sort: " + tenGv);
            listResp = getAllGv(httpClient, httpPost);

            // return UTF8
            bytes = tenGv.getBytes(StandardCharsets.ISO_8859_1);
            tenGv = new String(bytes, StandardCharsets.UTF_8);
        }
    %>
    <h1 class="tieuDeTrang">Danh sách giảng viên</h1>
    <div class="themVaTimKiem">
        <!-- nut them giang vien -->
        <button id="nut_them_GV" onclick="showModal('modal_giang_vien')" class="nutThemGV js-nutThemGV"
                type="button">
            <span class="nutThemGV_tieuDe">Thêm giảng viên</span>
            <i class="fa-solid fa-plus"></i>
        </button>
        <form class="timKiem" method="post" accept-charset="UTF-8">
            <div class="tieuDeTimKiem">Tìm kiếm giảng viên: </div>
            <input type="search" id="nhapTimKiem" name="nhapTimKiem" placeholder="Nhập tên giảng viên" value="<%= tenGv %>">
            <button class="nutTimKiem" type="submit">
                <span class="nutTimKiem_tieuDe">Tìm</span>
                <i class="fa-solid fa-magnifying-glass"></i>
            </button>
        </form>
    </div>

    <div class="boc-bang">
        <form id="formGV" method="post" action="/admin/teacher" accept-charset="UTF-8">
            <input type="hidden" name="tenGv" value="<%= tenGv %>">
            <input type="hidden" name="sortFieldGV" value="<%= sortField %>">
            <input type="hidden" name="sortOrderGV" value="<%= sortOrder %>">
            <input type="hidden" name="pageIndexGV" value="<%= pageIndex %>">
            <input type="hidden" name="pageSizeGV" value="<%= pageSize %>">

            <table id="myTable" class="danhSach">
                <thead class="hang1">
                    <th data-sort onclick="sortTable('idGv', this)" class="cot-maGV idGv">Mã GV</th>
                    <th data-sort onclick="sortTable('tenGv', this)" class="cot-tenGV tenGv">Họ và tên</th>
                    <th class="cot-sdtGV">Số điện thoại</th>
                    <th class="cot-emailGV">Email</th>
                    <th data-sort onclick="sortTable('genderGv', this)" class="cot-gioiTinhGV genderGv">Giới tính</th>
                    <th data-sort onclick="sortTable('idKhoa', this)" class="cot-khoaGV idKhoa">Khoa</th>
                    <th data-sort onclick="sortTable('trangThai', this)" class="cot-trangThai trangThai">Trạng thái</th>
                    <th data-sort onclick="sortTable('ngayTao', this)" class="cot-ngayTao ngayTao">Ngày tạo</th>
                    <th data-sort onclick="sortTable('ngaySua', this)" class="cot-ngayTao ngaySua">Ngày cập nhật</th>
                    <th class="hanh-dong">Action</th>
                </thead>
                <tbody>
                <%--            hiển thị ra màn hình--%>
                <%  if(listResp!=null) {
                    for(int i=0;i<listResp.length();i++) {%>
                <% JSONObject teacher = listResp.getJSONObject(i); %>
                <tr>
                    <td><%= teacher.getString("idGv") %></td>
                    <td><%= teacher.getString("tenGv") %></td>
                    <td><%= teacher.getString("sdtGv") %></td>
                    <td><%= teacher.getString("emailGv") %></td>
                    <td><%= teacher.getString("genderGv") %></td>
                    <td><%= teacher.getString("tenKhoa") %></td>
                    <%
                        if(teacher.getInt("trangThai")==1) {
                    %>
                    <td class="dangCongTac">Đang công tác</td>
                    <%
                    }
                    else {
                    %>
                    <td class="ngungCongTac">Ngừng công tác</td>
                    <%
                        }
                    %>
                    <td><%= teacher.getString("ngayTao") %></td>
                    <td><%= teacher.getString("ngaySua") %></td>
                    </td>
                    <td class="chucNang">
                        <div class="hop-hanh-dong">
                            <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_giang_vien_sua', '<%= teacher.getString("idGv") %>' , '<%= teacher.getString("tenGv") %>', '<%= teacher.getString("sdtGv") %>','<%=  teacher.getString("emailGv") %>','<%= teacher.getString("genderGv") %>','<%= teacher.getString("idKhoa") %>')">
                                <span class="sua_tieuDe">Sửa</span>
                                <i class="fa-solid fa-pencil sua_icon"></i>
                            </button>
                            <%
                                if(teacher.getInt("trangThai")==1) {
                            %>
                            <button onclick="hienXacNhanXoa('modal_xac_nhan_xoa', '<%= teacher.getString("idGv") %>', 'ma-gv-xoa')" class="xoa hop-hanh-dong-nut" type="button">
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
</div>

<%@include file="../teacher/add_teacher_form.jsp" %>
<%@include file="../teacher/update_teacher_form.jsp" %>
<%@include file="../teacher/confirm_delete_teacher.jsp"%>

</body>
    <script src="../../../assets/js/pagination.js"></script>
    <script>
        // Kiểm tra xem lúc thêm giảng viên thì id, số điện thoại hay email đã tồn tại chưa?
        if(<%= exist %>) {
            alert("Mã giảng viên, email hoặc số điện thoại đó đã tồn tại!");
        }

        // do lúc gửi đoạn sort nó hay load lại trang dẫn đến không kịp lưu lại class, hàm này dùng để lấy session đã lưu
        // trong TeacherSessionController, gán nó vào class để hiển thị giao diện mũi tên là đang sort theo cột nào, asc hay desc
        if('${sessionScope.sortFieldGV}'!=='null' && '${sessionScope.sortFieldGV}'!=='') {
            var getTd = document.querySelector('.${sessionScope.sortFieldGV}');
            const asc = '${sessionScope.sortOrderGV}'==='desc';
            getTd.classList[asc ? 'remove' : 'add']('asc');
            getTd.classList[asc ? 'add' : 'remove']('desc');
        }

        // hàm sort cột
        function sortTable(field, event) {
            const tenGvInput = document.querySelector('input[name="tenGv"]');
            const sortFieldInput = document.querySelector('input[name="sortFieldGV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderGV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexGV"]');

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
            console.log('Tên giảng viên trước khi gán giá trị: ' + tenGvInput.value);
            console.log('Nhập tìm kiếm: ' + document.querySelector('#nhapTimKiem').value);
            if(document.querySelector('#nhapTimKiem').value!==null) {
                tenGvInput.value = document.querySelector('#nhapTimKiem').value;
            }
            // Submit the form
            document.getElementById("formGV").submit();
        }

        // tạo UI phân trang
        createPaginationUI(<%= totalPages %>, <%= pageIndex %>);

        // nút chuyển sang trang trước đó
        function nutPrev() {
            const pageIndexInput = document.querySelector('input[name="pageIndexGV"]');
            console.log('Page Index Before: ' + pageIndexInput.value);

            // Kiểm tra xem hiện tại có đang ở trang đầu tiên k
            if(pageIndexInput.value>1) {
                pageIndexInput.value--;
                document.getElementById("formGV").submit();
            }
        }

        // nút chuyển sang trang tiếp theo
        function nutNext() {
            const sortFieldInput = document.querySelector('input[name="sortFieldGV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderGV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexGV"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldGV}'!=='null' && '${sessionScope.sortFieldGV}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldGV}';
                sortOrderInput.value = '${sessionScope.sortOrderGV}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            // Kiểm tra xem hiện tại có đang ở trang cuối cùng k
            if(+pageIndexInput.value < <%= totalPages %>) {
                pageIndexInput.value = +pageIndexInput.value + 1;
                document.getElementById("formGV").submit();
            }
        }

        // nút chọn 1 trang
        function nutTrang(page) {
            const sortFieldInput = document.querySelector('input[name="sortFieldGV"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderGV"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexGV"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldGV}'!=='null' && '${sessionScope.sortFieldGV}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldGV}';
                sortOrderInput.value = '${sessionScope.sortOrderGV}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            pageIndexInput.value = page;
            document.getElementById("formGV").submit();
        }

    </script>
    <script src="../../../assets/js/menu.js"></script>
    <script src="../../../assets/js/admin/add_form.js"></script>
    <script src="../../../assets/js/admin/update_teacher.js"></script>
    <script src="../../../assets/js/admin/text_error_teacher.js"></script>
    <script src="../../../assets/js/admin/confirm_delete_form.js"></script>
</html>