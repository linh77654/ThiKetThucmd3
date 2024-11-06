<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Phong Tro</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>View Phong Tro</h2>
    <table class="table table-bordered">
        <tr>
            <th>ID</th>
            <td>${phongTro.id}</td>
        </tr>
        <tr>
            <th>Tên người thuê</th>
            <td>${phongTro.tenPhongTro}</td>
        </tr>
        <tr>
            <th>Số Điện Thoại</th>
            <td>${phongTro.soDienThoai}</td>
        </tr>
        <tr>
            <th>Ngày Bắt Đầu</th>
            <td>${phongTro.ngayBatDau}</td>
        </tr>
        <tr>
            <th>Hình Thức Thanh Toán</th>
            <td>${phongTro.hinhThucThanhToan}</td>
        </tr>
        <tr>
            <th>Ghi Chú</th>
            <td>${phongTro.ghiChu}</td>
        </tr>
    </table>
    <a href="/phongtro?action=list" class="btn btn-primary">Back to List</a>
</div>
</body>
</html>