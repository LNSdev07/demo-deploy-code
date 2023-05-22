<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.*" %>
<%@ page import="org.apache.http.client.methods.HttpPost" %>
<%@ page import="org.apache.http.client.HttpClient" %>
<%@ page import="org.apache.http.HttpResponse" %>
<%@ page import="org.json.*" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="org.apache.http.entity.StringEntity" %>
<%@ page import="org.apache.http.impl.client.HttpClientBuilder" %>
<%@ page import="java.io.IOException" %>
<html>
<head>
    <%@include file="../menu/admin_menu_header.jsp" %>
    <link rel="stylesheet" href="../../../assets/css/admin/semester.css">
    <link rel="stylesheet" href="../../../assets/css/pagination.css">
    <link rel="stylesheet"  href="../../../assets/css/admin/add_semester_form.css">
    <link rel="stylesheet"  href="../../../assets/css/admin/update_semester_form.css">
    <title>Học kỳ</title>
</head>
<%
    HttpClient httpClient = HttpClientBuilder.create().build();

    // get session id
    String value = "JSESSIONID=";
    HttpSession getSession = request.getSession();
    String cookieValue = (String) getSession.getAttribute("cookie_value");

    // variables in request body
    String sortField = "";
    String sortOrder = "";
    int pageSize = 10;

    int pageIndex = 1;
    if (session.getAttribute("pageIndexHK") != null) {
        pageIndex = (int) session.getAttribute("pageIndexHK");
    }

    System.out.println(session.getAttribute("pageIndexHK"));
    System.out.println("pageIndex in semester.jsp: " + pageIndex);

    // request body for getAll, finding and sorting
    String requestBody = "{" +
            "\"sortField\":\"" + sortField + "\"," +
            "\"sortOrder\":\"" + sortOrder + "\"," +
            "\"pageIndex\":" + pageIndex + "," +
            "\"pageSize\":" + pageSize +
            "}";
%>
<body>
<%@include file="../menu/admin_menu.jsp" %>
<div class="manHinhChinh">
    <%!
        int totalPages;

        // Hàm Refresh lại trang lấy học kỳ
        public JSONArray getAllHk(HttpClient httpClient, HttpPost httpPost) throws IOException {
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
        //get all
        String uriGetAll = "http://localhost:8080/api/admin/home/semester";

        HttpPost httpPost = new HttpPost(uriGetAll);
        StringEntity entity = new StringEntity(requestBody);
        httpPost.setEntity(entity);

        httpPost.setHeader("Cookie", value + cookieValue);

        // call function, return data
        JSONArray listResp = getAllHk(httpClient, httpPost);
    %>
    <%
        // add HK
        String uriAddHK = "http://localhost:8080/api/admin/home/semester/create-or-edit";
        String idHk = request.getParameter("ma-hk");
        String tenHk = request.getParameter("ten-hk");
        String requestBodyAddHK = "{"+
                "\"status\":" + 0 + ","+
                "\"idHk\":\"" + idHk + "\","+
                "\"tenHocKy\":\"" + tenHk + "\""+
                "}";

        // send the request and retrieve the response
        boolean exist = false;
        if(idHk!=null && tenHk!=null) {
            System.out.println(requestBodyAddHK);

            HttpPost httpPostAddHK = new HttpPost(uriAddHK);
            StringEntity entityAddHK = new StringEntity(requestBodyAddHK);
            httpPostAddHK.setEntity(entityAddHK);

            httpPostAddHK.setHeader("Cookie",value+cookieValue);

            HttpResponse respAddHK = httpClient.execute(httpPostAddHK);
            String responseBodyAddHK = EntityUtils.toString(respAddHK.getEntity());
            System.out.println(responseBodyAddHK);

            JSONObject jsonResponseAddHK = new JSONObject(responseBodyAddHK);

            if(jsonResponseAddHK.getInt("status")!=200) {
                exist = true;
            }
            System.out.println(jsonResponseAddHK);
            // get all hoc ky
            listResp = getAllHk(httpClient, httpPost);
        }
    %>
    <%
        // update HK
        String uriUpdateHK = "http://localhost:8080/api/admin/home/semester/create-or-edit";
        String idHkU = request.getParameter("ma-hk-sua");
        String tenHkU = request.getParameter("ten-hk-sua");
        String requestBodyUpdateHK = "{"+
                "\"status\":" + 1 + ","+
                "\"idHk\":\"" + idHkU + "\","+
                "\"tenHocKy\":\"" + tenHkU + "\""+
                "}";
        // send the request and retrieve the response
        if (idHkU != null && tenHkU != null) {
            System.out.println(requestBodyUpdateHK);

            HttpPost httpPostUpdateHK = new HttpPost(uriUpdateHK);
            StringEntity entityUpdateHK = new StringEntity(requestBodyUpdateHK);
            httpPostUpdateHK.setEntity(entityUpdateHK);

            httpPostUpdateHK.setHeader("Cookie", value + cookieValue);

            HttpResponse respUpdateHK = httpClient.execute(httpPostUpdateHK);
            String responseBodyUpdateHK = EntityUtils.toString(respUpdateHK.getEntity());
            System.out.println(responseBodyUpdateHK);

            JSONObject jsonResponseUpdateHK = new JSONObject(responseBodyUpdateHK);
            System.out.println(jsonResponseUpdateHK);

            // get all học kỳ
            listResp = getAllHk(httpClient, httpPost);
        }
    %>
    <%
        // sort
        sortField = request.getParameter("sortFieldHK");
        sortOrder = request.getParameter("sortOrderHK");
        if(sortField!=null) {
            requestBody = "{" +
                    "\"sortField\":\"" + sortField + "\"," +
                    "\"sortOrder\":\"" + sortOrder + "\"," +
                    "\"pageIndex\":" + pageIndex + "," +
                    "\"pageSize\":" + pageSize +
                    "}";
            entity = new StringEntity(requestBody);
            httpPost.setEntity(entity);

            System.out.println("Sort Field: " + sortField);
            System.out.println("Sort Order: " + sortOrder);
            listResp = getAllHk(httpClient, httpPost);
        }
    %>
    <div class="dauTrang">
        <h1 class="tieuDeTrang">Các học kỳ</h1>
        <button id="nut_them_HK" onclick="showModal('modal_hoc_ky')" class="nutThemHK js-nutThemHK" type="button">
            <span class="nutThemHK_tieuDe">Thêm học kỳ</span>
            <i class="fa-solid fa-plus"></i>
        </button>
    </div>

    <div class="boc-bang">
        <form id="formHK" method="post" action="/admin/semester">
            <input type="hidden" name="sortFieldHK" value="<%=sortField%>">
            <input type="hidden" name="sortOrderHK" value="<%=sortOrder%>">
            <input type="hidden" name="pageIndexHK" value="<%=pageIndex%>">
            <input type="hidden" name="pageSizeHK" value="<%=pageSize%>">
            <table class="danhSach" id="myTable">
                <thead class="hang1">
                    <th data-sort onclick="sortTable('idHk', this)" class="cot-maHK idHk">Mã học kỳ</th>
                    <th data-sort onclick="sortTable('tenHocKy', this)" class="cot-tenHK tenHocKy">Tên học kỳ</th>
                    <th data-sort onclick="sortTable('ngayTao', this)" class="cot-ngayTao ngayTao">Ngày tạo</th>
                    <th data-sort onclick="sortTable('ngaySua', this)" class="cot-ngayTao ngaySua">Ngày cập nhật</th>
                    <th class="hanh-dong">Action</th>
                </thead>
                <tbody>
                    <%--            hiển thị ra màn hình--%>
                    <%  if (listResp != null) {
                        for (int i = 0; i < listResp.length(); i++) {%>
                    <% JSONObject semester = listResp.getJSONObject(i); %>
                    <tr>
                        <td><%= semester.getString("idHk")%></td>
                        <td><%= semester.getString("tenHocKy")%></td>
                        <td><%= semester.getString("ngayTao")%></td>
                        <td><%= semester.getString("ngaySua")%></td>
                        <td class="chucNang">
                            <div class="hop-hanh-dong">
                                <button class="sua hop-hanh-dong-nut" type="button" onclick="showModalSua('modal_hoc_ky_sua', '<%=semester.getString("idHk")%>', '<%=semester.getString("tenHocKy")%>')">
                                    <span class="sua_tieuDe">Sửa</span>
                                    <i class="fa-solid fa-pencil sua_icon"></i>
                                </button>
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
<%@include file="add_semester_form.jsp" %>
<%@include file="update_semester_form.jsp" %>

</body>
    <script src="../../../assets/js/pagination.js"></script>
    <script>
        if(<%= exist %>) {
            alert("Mã học kỳ hoặc tên học kỳ đã tồn tại")
        }

        // do lúc gửi đoạn sort nó hay load lại trang dẫn đến không kịp lưu lại class, hàm này dùng để lấy session đã lưu
        // trong SemesterSessionController, gán nó vào class để hiển thị giao diện mũi tên là đang sort theo cột nào, asc hay desc
        if('${sessionScope.sortFieldHK}'!=='null' && '${sessionScope.sortFieldHK}'!=='') {
            const getTd = document.querySelector('.${sessionScope.sortFieldHK}');
            const asc = '${sessionScope.sortOrderHK}'==='desc';
            getTd.classList[asc ? 'remove' : 'add']('asc');
            getTd.classList[asc ? 'add' : 'remove']('desc');
        }

        // hàm sort cột
        function sortTable(field, event) {
            const sortFieldInput = document.querySelector('input[name="sortFieldHK"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderHK"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexHK"]');

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

            // Submit the form
            document.getElementById("formHK").submit();
        }

        // tạo UI phân trang
        createPaginationUI(<%= totalPages %>, <%= pageIndex %>);

        // nút chuyển sang trang trước đó
        function nutPrev() {
            const pageIndexInput = document.querySelector('input[name="pageIndexHK"]');
            console.log('Page Index Before: ' + pageIndexInput.value);

            // Kiểm tra xem hiện tại có đang ở trang đầu tiên k
            if(pageIndexInput.value>1) {
                pageIndexInput.value--;
                document.getElementById("formHK").submit();
            }
        }

        // nút chuyển sang trang tiếp theo
        function nutNext() {
            const sortFieldInput = document.querySelector('input[name="sortFieldHK"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderHK"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexHK"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldHK}'!=='null' && '${sessionScope.sortFieldHK}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldHK}';
                sortOrderInput.value = '${sessionScope.sortOrderHK}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            // Kiểm tra xem hiện tại có đang ở trang cuối cùng k
            if(+pageIndexInput.value < <%= totalPages %>) {
                pageIndexInput.value = +pageIndexInput.value + 1;
                document.getElementById("formHK").submit();
            }
        }

        // nút chọn 1 trang
        function nutTrang(page) {
            const sortFieldInput = document.querySelector('input[name="sortFieldHK"]');
            const sortOrderInput = document.querySelector('input[name="sortOrderHK"]');
            const pageIndexInput = document.querySelector('input[name="pageIndexHK"]');

            // Kiểm tra session xem có đang sort cột nào k
            if('${sessionScope.sortFieldHK}'!=='null' && '${sessionScope.sortFieldHK}'!=='') {
                sortFieldInput.value = '${sessionScope.sortFieldHK}';
                sortOrderInput.value = '${sessionScope.sortOrderHK}';
            } else {
                sortFieldInput.value = '';
                sortOrderInput.value = '';
            }

            pageIndexInput.value = page;
            document.getElementById("formHK").submit();
        }
    </script>
    <script src="../../../assets/js/menu.js"></script>
    <script src="../../../assets/js/admin/add_form.js"></script>
    <script src="../../../assets/js/admin/update_semester.js"></script>
    <script src ="../../../assets/js/admin/text_error_semester.js"></script>
</html>
