<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>List Phong Tro</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>List Phong Tro</h2>

    <form action="phongtro" method="get" class="form-inline mb-3">
        <input type="text" name="tenPhongTro" class="form-control mr-2" placeholder="Tên Phòng Trọ" value="${param.tenPhongTro}">
        <input type="text" name="soDienThoai" class="form-control mr-2" placeholder="Số Điện Thoại" value="${param.soDienThoai}">
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <a href="phongtro?action=add" class="btn btn-success mb-3">Add New Phong Tro</a>

    <form action="phongtro" method="post" id="delete-form">
        <input type="hidden" name="action" value="delete">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th><input type="checkbox" id="select-all"></th>
                <th>ID</th>
                <th>Tên người thuê</th>
                <th>Số Điện Thoại</th>
                <th>Ngày Bắt Đầu</th>
                <th>Hình Thức Thanh Toán</th>
                <th>Ghi Chú</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${phongTroList}" var="phongTro">
                <tr>
                    <td><input type="checkbox" name="ids" value="${phongTro.id}"></td>
                    <td>${phongTro.id}</td>
                    <td>${phongTro.tenPhongTro}</td>
                    <td>${phongTro.soDienThoai}</td>
                    <td>${phongTro.ngayBatDau}</td>
                    <td>${phongTro.hinhThucThanhToan}</td>
                    <td>${phongTro.ghiChu}</td>
                    <td>
                            <%--                        <a href="phongtro?action=view&id=${phongTro.id}" class="btn btn-info btn-sm">View</a>--%>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button type="submit" class="btn btn-danger" id="delete-btn">Delete Selected</button>
    </form>
</div>

<script>
    document.getElementById('select-all').onclick = function() {
        var checkboxes = document.querySelectorAll('input[name="ids"]');
        checkboxes.forEach(function(checkbox) {
            checkbox.checked = document.getElementById('select-all').checked;
        });
    };

    document.getElementById('delete-btn').onclick = function(event) {
        var selectedItems = document.querySelectorAll('input[name="ids"]:checked');
        if (selectedItems.length === 0) {
            alert('Please select at least one item to delete.');
            return;
        }

        var confirmation = confirm("Are you sure you want to delete the selected items?");
        if (!confirmation) {
            event.preventDefault();
        }
    };
</script>

</body>
</html>

</body>
</html>