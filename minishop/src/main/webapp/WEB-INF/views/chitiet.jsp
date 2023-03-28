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
			
			<div class="col-sm-8 col-md-8">
				<div class="row">
					
					<div class="col-sm-4 col-md-4">
						<img id="hinhchitietsanpham" src='<c:url value="/resources/Image/sanpham/${sanpham.getHinhsanpham()}" />' />
					</div>
					
					<div class="col-sm-8 col-md-8">
						<h3 id="tensp" data-masp = "${sanpham.getMasanpham()}">${sanpham.getTensanpham()}</h3>
						<h4 id="giatien" data-value="${sanpham.getGiatien()}" style="color:red">${sanpham.getGiatien()} VND</h4>
						<table class="table">
							<thead>
								<tr>
									<td><h4>Mau sac</h4></td>
									<td><h4>Size</h4></td>
									<td><h4>So luong</h4></td>
								</tr>
							</thead>
							
							<tbody>
							
								<c:forEach var="chitietsanpham" items="${sanpham.getChitietsanpham() }">
									<tr>
										<td class="mau" data-mamau="${chitietsanpham.getMausanpham().getMamau()}">${chitietsanpham.getMausanpham().getTenmau()}</td>
										<td class="size" data-masize="${chitietsanpham.getSizesanpham().getMasize()}">${chitietsanpham.getSizesanpham().getTenSize()}</td>
										<td class="soluong" >${chitietsanpham.getSoluong()}</td>
										<td><button class="btn btn-success btn-giohang" data-machitietsp = "${chitietsanpham.getMachitietsanpham()}">Gio hang</button></td>
									</tr>
								
								</c:forEach>
							
							</tbody>
						</table>
					</div>
					
				</div>
			</div>
			
			<div class="col-sm-2 col-md-2">
				<span>
				${sanpham.getMota()}
				</span>
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