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
					<li id="giohang"><a href="/minishop/giohang/"><img
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
		<div class="row" style="margin-top : 16px">
			
			<div class="col-sm-2 col-md-2">
				<h3>Danh Muc</h3>
				<ul class="mymenu">
					<c:forEach var="value" items="${danhmuc}">
						<li><a href="#">${value.getTendanhmuc()}</a></li>
					</c:forEach>
					
				</ul>
			</div>

			<div class="col-sm-10 col-md-10">
				<div id="title-sanpham" class="container">
					
					<div class="row" >
						<h3>${tendanhmuc }</h3>
						<c:forEach var="sanpham" items="${listSanPham}">
							<div class="col-md-3 col-sm-6">
								<a href="chitiet/${sanpham.getMasanpham() }">
									<div class="sanpham wow bounceIn">
										<img alt="hinh"
											src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}" />' /></br>
										<span>${sanpham.getTensanpham()}</span></br> <span class="gia">${sanpham.getGiatien()}
											VND</span>
									</div>
								</a>

							</div>

						</c:forEach>

					</div>
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