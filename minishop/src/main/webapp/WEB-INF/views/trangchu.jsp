<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body>
	<div id="header" class="container-fluid">
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
						aria-expanded="false">San pham <span class="caret"></span></a>
						<ul class="dropdown-menu">
						
							<c:forEach var="value" items="${danhmuc}">
								<li role="separator" class="divider"></li>
								<li><a href="<c:url value='/sanpham/${value.getMadanhmuc() }/${value.getTendanhmuc()}' />">${value.getTendanhmuc()}</a></li>
							</c:forEach>

						</ul>
					</li>
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
					<li><a href="#"><img
							src='<c:url value="/resources/Image/icon-shopping-cart.png" />' /></a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid --> </nav>

		<div class="event_header container wow fadeInDown">
			<span>Ngay 17/10- 23/10/2017</span></br> <span style="font-size: 50px">Mua
				1 tang 1</span></br>
			<button>Xem ngay</button>
		</div>
	</div>
	<div id="info" class="container">
		<div class="row">
			<div class="col-12 col-sm-4 col-md-4 wow bounceIn"
				data-wow-duration="1s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_chat_luong.png" />' /></br> <span
					style="font-size: 32px; font-weight: 500">CHAT LUONG</span></br> <span>Chung
					toi cam ket se mang den cho ban chat luong tot nhat</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow bounceIn"
				data-wow-duration="1s" data-wow-delay="1s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_tiet_kiem.png" />' /></br> <span
					style="font-size: 32px; font-weight: 500">TIET KIEM CHI PHI</span></br>
				<span>Cam ket gia re nhat Viet Nam giup cac ban tiet kiem hon
					20% cho tung san pham</span>
			</div>
			<div class="col-12 col-sm-4 col-md-4 wow bounceIn"
				data-wow-duration="1s" data-wow-delay="2s">
				<img class="icon"
					src='<c:url value="/resources/Image/icon_giao_hang.png" />' /></br> <span
					style="font-size: 32px; font-weight: 500">GIAO HANG</span></br> <span>Giao
					hang tan noi tron ngay. De mang san pham den cho ban nhanh nhat</span>
			</div>
		</div>

	</div>
	<div id="title-sanpham" class="container">
		<span>SAN PHAM HOT</span>
		<div class="row" style="margin-top: 46px">

			<c:forEach var="sanpham" items="${listSanPham}">
				<div class="col-md-3 col-sm-6">
					<a href="chitiet/${sanpham.getMasanpham() }">
						<div class="sanpham wow bounceIn">
						<img alt="hinh"
							src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}" />' /></br> 
							<span>${sanpham.getTensanpham()}</span></br>
						<span class="gia">${sanpham.getGiatien()} VND</span>
					</div>
					</a>
					
				</div>

			</c:forEach>

		</div>
	</div>
	<!-- end san pham -->
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

	<jsp:include page="footer.jsp" />
</body>
</html>