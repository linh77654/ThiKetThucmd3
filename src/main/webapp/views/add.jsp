<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Phong Tro</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

  <script>
    function validateForm() {
      var tenPhongTro = document.getElementById('tenPhongTro').value;
      var namePattern = /^[A-Za-z\s]{5,50}$/;
      if (!namePattern.test(tenPhongTro)) {
        alert("Tên người thuê phải từ 5 đến 50 ký tự và không chứa số hoặc ký tự đặc biệt.");
        return false;
      }

      var soDienThoai = document.getElementById('soDienThoai').value;
      var phonePattern = /^\d{10}$/;
      if (!phonePattern.test(soDienThoai)) {
        alert("Số điện thoại phải là 10 chữ số.");
        return false;
      }

      var ngayBatDau = new Date(document.getElementById('ngayBatDau').value);
      var today = new Date();
      today.setHours(0, 0, 0, 0);
      if (ngayBatDau < today) {
        alert("Ngày bắt đầu không được là ngày trong quá khứ.");
        return false;
      }

      var hinhThucThanhToan = document.getElementById('hinhThucThanhToan').value;
      if (hinhThucThanhToan === "") {
        alert("Vui lòng chọn hình thức thanh toán.");
        return false;
      }

      var ghiChu = document.getElementById('ghiChu').value;
      if (ghiChu.length > 200) {
        alert("Ghi chú không được quá 200 ký tự.");
        return false;
      }

      return true;
    }
  </script>

</head>
<body>
<div class="container mt-4">
  <h2>Add New Phong Tro</h2>

  <c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
  </c:if>

  <form action="/phongtro" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="action" value="add">

    <div class="form-group">
      <label for="tenPhongTro">Tên người thuê</label>
      <input type="text" class="form-control" id="tenPhongTro" name="tenPhongTro" required>
    </div>

    <div class="form-group">
      <label for="soDienThoai">Số Điện Thoại</label>
      <input type="text" class="form-control" id="soDienThoai" name="soDienThoai" required>
    </div>

    <div class="form-group">
      <label for="ngayBatDau">Ngày Bắt Đầu</label>
      <input type="date" class="form-control" id="ngayBatDau" name="ngayBatDau" required>
    </div>

    <div class="form-group">
      <label for="hinhThucThanhToan">Hình Thức Thanh Toán</label>
      <select class="form-control" id="hinhThucThanhToan" name="hinhThucThanhToan" required>
        <option value="">Chọn hình thức thanh toán</option>
        <option value="1">Theo tháng</option>
        <option value="2">Theo quý</option>
        <option value="3">Theo năm</option>
      </select>
    </div>

    <div class="form-group">
      <label for="ghiChu">Ghi Chú</label>
      <textarea class="form-control" id="ghiChu" name="ghiChu"></textarea>
    </div>

    <button type="submit" class="btn btn-primary">Add Phong Tro</button>
    <a href="/phongtro?action=list" class="btn btn-secondary">Cancel</a>
  </form>
</div>

</body>
</html>