<%@ page import="org.apache.http.client.HttpClient" %>
<%@ page import="org.apache.http.impl.client.HttpClientBuilder" %>
<%@ page import="org.apache.http.client.methods.HttpGet" %>
<%@ page import="org.apache.http.entity.StringEntity" %>
<%@ page import="org.apache.http.HttpResponse" %>
<%@ page import="org.apache.http.util.EntityUtils" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.databind.JsonNode" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <%@include file="../menu/admin_menu_header.jsp" %>
  <title>Danh sách lớp</title>
  <link rel="stylesheet" href="../../../assets/fonts/fontawesome-free-6.3.0-web/css/all.min.css">
  <link rel="stylesheet" href="../../../assets/themify-icons/themify-icons.css">
  <link rel="stylesheet" href="../../../assets/css/admin/class.css">
  <link rel="stylesheet" href="../../../assets/css/admin/add_class_form.css">
  <link rel="stylesheet" href="../../../assets/css/pagination.css">
  <link rel="stylesheet" href="../../../assets/css/page_404.css">
  <link rel="stylesheet" href="../../../assets/css/admin/update_class_form.css">
  <link rel="stylesheet" href="../../../assets/css/admin/confirm_delete_form.css">
</head>

<body>
<%
  HttpClient httpClient = HttpClientBuilder.create().build();

  // get session id
  String value = "JSESSIONID=";
  HttpSession getSession = request.getSession();
  String cookieValue = (String) getSession.getAttribute("cookie_value");

  String khoa = request.getParameter("type");
%>

<%!
  // lấy list học kỳ
  public String GetTenHk(HttpClient httpClient,String idHk,String value,String cookieValue) throws IOException {
    String uri = "http://localhost:8080/api/admin/home/semester?id="+idHk;
    HttpGet httpGet = new HttpGet(uri);
    httpGet.setHeader("Cookie", value + cookieValue);
    HttpResponse resp = httpClient.execute(httpGet);
    String responseData = EntityUtils.toString(resp.getEntity());
    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(responseData);
    JsonNode infoHk = jsonNode.get("data");
    return infoHk.get("tenHocKy").asText();
  }
%>

<%
  //get all
  String uriGetAll = "http://localhost:8080/api/admin/class?idKhoa="+khoa;

  HttpGet httpGet = new HttpGet(uriGetAll);
  httpGet.setHeader("Cookie", value + cookieValue);

  HttpResponse resp = httpClient.execute(httpGet);
  String responseBody = EntityUtils.toString(resp.getEntity());
  JSONObject jsonResponse = new JSONObject(responseBody);
  JSONArray listLop = jsonResponse.getJSONArray("data");

  List<String> listHk = new ArrayList<>();
  for(int i=0;i<listLop.length();i++){
    JSONObject infoLop = listLop.getJSONObject(i);
    listHk.add(GetTenHk(httpClient, String.valueOf(infoLop.getString("idHk")),value,cookieValue ) );
  }
  for(int i=0;i< listHk.size();i++){
    System.out.println( listHk.get(i) );
  }
%>


<div class="lop">
  <header class="phanlop-header">
    <div class="lop-tieuDe">Danh sách các lớp
      <span id="lop-tieuDe-chiTiet"></span>
    </div>

    <div class="dauTrang">
      <button id="nut_them_lop" onclick="showModal('modal_lop')" class="nutThemlop js-nutThemlop"
              type="button">
        <span class="nutThemlop_tieuDe">Thêm lớp</span>
        <i class="fa-solid fa-plus"></i>
      </button>
    </div>
    <div class="phanlop-close js-phanlop-close" class="back" onclick="location.href='../specialization/specialization.jsp'">
      Khoa Chuyên Môn
    </div>
  </header>
  <div class="khuVucTimKiem">
    <div class="khuVucTimKiem-dau">
      <div class="tieuDeTimKiem">Tìm kiếm lớp</div>
    </div>
    <div class="khuVucTimKiem-phanThan">
      <div class="phanTimKiem">
        <input type="search" class="nhapTimKiem" placeholder="Nhập mã lớp">
        <input type="search" class="nhapTimKiem" placeholder="Nhập tên lớp">
      </div>
      <div class="timKiem-cacNut">
        <button class="nutTimKiem">
          <span class="nutTimKiem_tieuDe">Tìm</span>
          <i class="fa-solid fa-magnifying-glass"></i>
        </button>
        <button class="nutReset">
          <span class="nutReset_tieuDe">Reset</span>
          <i class="fa-solid fa-arrow-rotate-back"></i>
        </button>
      </div>
    </div>
  </div>

  <div class="boc-bang">
    <table class="danhSach">
      <thead class="hang1">
      <th data-sort onclick="sortTable(0, this)" class="cot-malop">Mã lớp</th>
      <th data-sort onclick="sortName(1,this)" class="cot-tenlop">Tên lớp</th>
      <th data-sort onclick="sortName(2,this)" class="cot-tenHK">Tên học kỳ</th>
      <th data-sort onclick="sortName(3,this)" class="cot-ngayTao">Ngày tạo</th>
      <th data-sort onclick="sortName(4,this)" class="cot-ngayTao">Ngày cập nhật</th>
      <th data-sort onclick="sortName(5,this)" class="hanh-dong">Action</th>
      </thead>
      <tbody>
      <%
        for(int i=0;i<listLop.length();i++){
          JSONObject infoLop = listLop.getJSONObject(i);
          String maLop = infoLop.getString("idLop");
          String tenLop = infoLop.getString("tenLop");
          String tenHk = listHk.get(i);
          String ngayTao = infoLop.getString("ngayTao");
          String ngaySua = infoLop.getString("ngaySua");
      %>
      <tr>
        <td> <%=maLop%> </td>
        <td><%=tenLop%></td>
        <td><%=tenHk%></td>
        <td><%=ngayTao%></td>
        <td><%=ngaySua%></td>
        <td class="chucNang">
          <div class="hop-hanh-dong">
            <a href="../grade/view-grade.jsp?idLop=<%=maLop%>">
              <button class="xem hop-hanh-dong-nut" type="button">
                <span class="sua_tieuDe">Xem điểm</span>
                <i class="fa-solid fa-eye sua_icon"></i>
              </button>
            </a>
          </div>
          <div class="hop-hanh-dong">
            <button class="sua hop-hanh-dong-nut" type="button"
                    onclick="showModalSua('modal_giang_vien_sua', 'D20CQCN11-B', 'Công nghệ 11 khóa D20', 'Công nghệ thông tin')">
              <span class="sua_tieuDe">Sửa</span>
              <i class="fa-solid fa-pencil sua_icon"></i>
            </button>
            <button class="xoa hop-hanh-dong-nut" type="button" onclick="hienXacNhanXoa('modal_xac_nhan_xoa', 'D20CQCN11-B')">
              <span class="xoa_tieuDe">Xóa</span>
              <i class="fa-solid fa-trash xoa_icon"></i>
            </button>
          </div>
        </td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>
  <div class="phanTrang">
    <ul></ul>
  </div>
</div>
<%@include file="../class/add_class_form.jsp" %>
<%@include file="confirm_delete_class.jsp" %>
<%@include file="update_class_form.jsp" %>
<script src="../../../assets/js/admin/pagination_class.js"></script>
<script src="../../../assets/js/admin/add_form.js"></script>
<script src="../../../assets/js/admin/class.js"></script>
<script src="../../../assets/js/admin/text_error_class.js"></script>
<script src="../../../assets/js/admin/update_class.js"></script>
<script src="../../../assets/js/admin/confirm_delete_form.js"></script>

</body>

</html>