<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../menu/user_menu_header.jsp" %>
    <link rel="stylesheet" href="../../../assets/css/user/watch_grade.css">
    <title>Xem điểm</title>
</head>
<body>
<%
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    String url = resourceBundle.getString("url");
    String username = resourceBundle.getString("username");
    String password = resourceBundle.getString("password");
    String driver = resourceBundle.getString("driverName");
%>
<%@include file="../menu/user_menu.jsp" %>
<div class="manHinhChinh">



    <%!
        public Double ConvertDiemTB( Double x) {
            if(Double.compare(4.0,x)>0)return 0.0;
            else if(Double.compare(5.0,x)>0)return 1.0;
            else if(Double.compare(5.5,x)>0)return 1.5;
            else if(Double.compare(6.5,x)>0)return 2.0;
            else if(Double.compare(7.0,x)>0)return 2.5;
            else if(Double.compare(8.0,x)>0)return 3.0;
            else if(Double.compare(8.5,x)>0)return 3.5;
            else if(Double.compare(9.0,x)>0)return 3.7;
            return 4.0;
        }
    %>
    <%!
        public String ConvertTrangThai ( Double x ){
            if(Double.compare(1.0,x)>0)return "Trượt môn";
            return "Qua môn";
        }
    %>
    <%!
        public String ConvertDiemChu (Double x){
            Double tolerance = 0.001;
            if(Math.abs( 0.0 - x ) <= tolerance) return "F";
            else if(Math.abs( 1.0 - x ) <= tolerance)return "D";
            else if(Math.abs( 1.5 - x ) <= tolerance)return "D+";
            else if(Math.abs( 2.0 - x ) <= tolerance)return "C";
            else if(Math.abs( 2.5 - x ) <= tolerance)return "C+";
            else if(Math.abs( 3.0 - x ) <= tolerance)return "B";
            else if(Math.abs( 3.5 - x ) <= tolerance)return "B+";
            else if(Math.abs( 3.7 - x ) <= tolerance)return "A";
            return "A+";
        }
    %>


    <h1 class = "tieuDeTrang">Bảng điểm học phần</h1>

    <table>
        <tr>
            <th>STT</th>
            <th>Tên học phần</th>
            <th>Chuyên cần</th>
            <th>Bài tập</th>
            <th>Điểm thi</th>
            <th>Điểm KT</th>
            <th>Điểm TB(Thang 10)</th>
            <th>Điểm TB(dạng chữ)</th>
            <th>Điểm TB(Thang 4)</th>
            <th>Trạng thái</th>
        </tr>

        <%
            try {
                Class.forName(driver);
                Connection con= DriverManager.getConnection(url, username, password);


                // Chuẩn bị câu truy vấn
                String query = "SELECT DISTINCT  ten_mon_hoc, diem_cc, diem_bt, diem_thi,diem_kt  ,chuyen_can, bai_tap, thi,kiem_tra  FROM diem, monhoc, taikhoan , thanhphan WHERE diem.id_sv =  ? and diem.id_mh = monhoc.id_mh and diem.id_diem = thanhphan.id_tp ";
                PreparedStatement statement = con.prepareStatement(query);


                statement.setString(1,tenTaiKhoan);
                // Thực hiện truy vấn
                ResultSet resultSet = statement.executeQuery();

                // Xử lý kết quả truy vấn
                Integer stt = 1;
                while (resultSet.next()) {
                    String tenMonHoc = resultSet.getString("ten_mon_hoc");
                    Double diemBaiTap = resultSet.getDouble("diem_bt");
                    Double diemChuyenCan = resultSet.getDouble("diem_cc");
                    Double diemKiemTra = resultSet.getDouble("diem_kt");
                    Double diemThi = resultSet.getDouble("diem_thi");

                    Integer ptChuyenCan = resultSet.getInt("chuyen_can");
                    Integer ptBaiTap = resultSet.getInt("bai_tap");
                    Integer ptKiemTra = resultSet.getInt("kiem_tra");
                    Integer ptThi = resultSet.getInt("thi");

                    Double diemTBthang10 = (diemChuyenCan*ptChuyenCan + diemBaiTap * ptBaiTap + diemThi * ptThi + diemKiemTra * ptKiemTra) /100;
                    Double diemTBthang4 = ConvertDiemTB(diemTBthang10);
                    String diemTBChu = ConvertDiemChu(diemTBthang4);
                    String trangThai = ConvertTrangThai(diemTBthang4);

        %>
        <tr>
            <td><%= stt %></td>
            <td><%= tenMonHoc %></td>
            <td><%= diemChuyenCan %></td>
            <td><%= diemBaiTap %></td>
            <td><%= diemThi %></td>
            <td><%= diemKiemTra %></td>
            <td><%= diemTBthang10 %></td>
            <td><%= diemTBChu %></td>
            <td><%= diemTBthang4 %></td>
            <td><%= trangThai %></td>

        </tr>
        <%
                    stt++;
                }

                // Đóng kết nối và tài nguyên
                resultSet.close();
                statement.close();
                con.close();
            } catch (Exception e) {

            }
        %>
    </table>

</div>
</body>
<script src="../../../assets/js/menu.js"></script>
</html>