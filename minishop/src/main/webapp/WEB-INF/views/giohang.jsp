<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script>
$(document).ready(function(){
  $(".soluonggiohang").change(function(){
    alert("The text has been changed.");
  });
});
</script> -->
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>

<!-- Bat dau phan header -->

	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-default none_nav">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src='<c:url value="/resources/Image/icon-yame-shop.png" />' /></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-center ">
					<li class="active"><a href="#">TRANG CHU</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul></li>
					<li><a href="#">DICH VU</a></li>
					<li><a href="#">LIEN HE</a></li>

				</ul>

				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${chucaidau != null }">
							<li><a class="circle-avatar" href="dangnhap/"><span>${chucaidau}</span></a></li>

						</c:when>
						<c:otherwise>
							<li><a href="dangnhap/">Dang nhap</a></li>
						</c:otherwise>

					</c:choose>

					<!-- <li><a href="#">Dang ky</a></li> -->
					<li id="giohang"><a href="#"><img
								src='<c:url value="/resources/Image/icon-shopping-cart.png" />' />
					<c:if test="${soluongsanphamgiohang > 0 }">
						<div class="circle-giohang"><span>${soluongsanphamgiohang}</span></div>
					</c:if>
					
					<c:if test="${soluongsanphamgiohang <= 0 || soluongsanphamgiohang == null }">
						<div><span>${soluongsanphamgiohang}</span></div>
					</c:if>
					</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>
	</div>
	
<!-- Ket thuc phan header -->

<!-- Bat dau phan chi tiet -->

	<div class="container">
		<div class="row">
		
			<div class="col-md-6 col-sm-12">
				<h3>Thong tin gio hang</h3>
				<table class="table">
					<thead>
						<tr>
							<td><h4>Ten san pham</h4></td>
							<td><h4>Mau sac</h4></td>
							<td><h4>Size</h4></td>
							<td><h4>So luong</h4></td>
							<td><h4>Gia tien</h4></td>
						</tr>
					</thead>

					<tbody>

						<c:forEach var="value" items="${sanphamgiohang }">
							<tr data-machitietsp="${value.getMachitietsp()}">
								<td class="tensanpham" data-masp="${value.getMasp()}">${value.getTensp()}</td>
								<td class="mau" data-mamau="${value.getMamau()}">${value.getTenmau()}</td>
								<td class="size" data-masize="${value.getMasize()}">${value.getTensize()}</td>
								<td class="soluong"><input class="soluonggiohang" type="number" min = "1" value="${value.getSoluong()}"></td>
								<td class="giatien" data-value="${value.getGiatien()}">${value.getGiatien()}</td>
								<td class="btn btn-danger xoa-giohang">Xoa</td>
							</tr>

						</c:forEach>

					</tbody>
				</table>
				<h4>Tong tien: <span id="tongtiensanpham" style="color : red">0.000 VND</span></h4>
			</div>
			
			<div class="col-md-6 col-sm-12">
				<h3>Thong tin khach hang</h3>
				<form action="" method="post">
					<div class="form-group">
						<label for="tennguoimua">Ten nguoi mua:</label> 
						<input class="form-control" id="tennguoimua" name="tenkhachhang"><br/>
						
						<label for="dienthoailienlac">Dien thoai lien lac:</label> 
						<input class="form-control" id="dienthoailienlac" name="sodt"><br/>

						<div class="radio">
							<label><input type="radio" name="hinhthucgiaohang" checked value="Giao hang tan noi">Giao hang tan noi</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="hinhthucgiaohang" value="Nhan tai cua hang">Nhan tai cua hang</label>
						</div>

						<label for="diachi">Dia chi nhan hang:</label> 
						<input class="form-control" id="diachi" name="diachigiaohang"><br/>
						
						<label for="ghichu">Ghi chu:</label>
  						<textarea class="form-control" rows="5" id="ghichu" name="ghichu"></textarea><br/>
					</div>
					<input type="submit" class="btn btn-primary" value="Dat hang"/>
				</form>
			</div>
		</div>

	</div>
	<!-- Ket thuc phan chi tiet -->

<!-- Bat dau footer -->
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4 col-sm-4 wow fadeInDown">
				<p>
					<span class="title-footer">THONG TIN SHOP</span>
				</p>
				<span>Yame la thuong hieu thoi trang uy tin, luon dam bao
					chat luong cho khach hang</span>
			</div>
			<div class="col-md-4 col-sm-4 wow fadeInDown">
				<p>
					<span class="title-footer">LIEN HE</span>
				</p>
				<span>145-Cong Hoa-Tan Binh-Ho Chi Minh</span></br> <span>098767888</span>

			</div>
			<div class="col-md-4 col-sm-4 wow fadeInDown">
				<p>
					<span class="title-footer">GOP Y</span>
				</p>
				<form action="" method="post">
					<input name="tenNhanVien" class="footer-input" type="text"
						placeholder="Email" />
					<textarea name="tuoi" class="footer-area" rows="4" cols="50"
						placeholder="Noi dung"></textarea>
					<button class="footer-button">Dong y</button>
				</form>
			</div>
		</div>

	</div>
	
<!-- Ket thuc phan footer -->

	<jsp:include page="footer.jsp" />
</body>
</html>