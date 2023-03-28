<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp"></jsp:include>
</head>
<body id="body-login">
	<div id="body-flex-login">
		<div id="container-login">
			<div id="container-login-left">
				<div id="header-top-left" class="header-login">
				<span id="text-logo">Welcome</span><br/>
				<span id="hint-text-logo">Hay tao nen phong cach cua ban cung minishop!</span>
				</div>
				
				<div id="header-bottom-left">
				<p><img alt="icon_oval" src='<c:url value="/resources/Image/ic_lock.png" />' /> <span>Luon cap nhat xu huong thoi trang moi nhat</span></p>
				<p><img alt="icon_oval" src='<c:url value="/resources/Image/ic_lock.png" />' /> <span>Giam hon 50% tat ca cac mat hang danh cho khach vip</span></p>
				<p><img alt="icon_oval" src='<c:url value="/resources/Image/ic_lock.png" />' /> <span>Tan tinh tu van de tao nen phong cach cua ban</span></p>
				</div>
			</div>
			<div id="container-login-right">
				<div id="header-top-right" class="header-login">
					<span id="dangnhap" class="active">Dang nhap</span> / <span id="dangky">Dang ky</span>
				</div>
				
				<div id="container-center-login-right">
					<div class="container-login-form" id="container-center-login-right">
						<input id="email" name="email" class="material-textinput input-icon-email" type="text" placeholder="Email"/><br/><p></p>
						<input id="matKhau" name="matKhau" class="material-textinput input-icon-pass" type="password" placeholder="Password"/><br/><p></p>
						<input id="btnDangNhap" class="primary-button" type="submit" value="Dang nhap"/><br/>
					</div>
					
					<div class="container-signup-form" id="container-center-login-right">
					<form action="" method="post">
						<input id="email" name="email" class="material-textinput input-icon-email" type="text" placeholder="Email"/><br/><p></p>
						<input id="matKhau" name="matKhau" class="material-textinput input-icon-pass" type="password" placeholder="Password"/><br/><p></p>
						<input id="nhapLaiMatKhau" name="nhapLaiMatKhau" class="material-textinput input-icon-pass" type="password" placeholder="Nhap lai Password"/><br/><p></p>
						<input id="btnDangKy" class="primary-button" type="submit" value="Dang ky"/><br/>
					</form>
						
					</div>
					<span id="ketquadangnhap"></span>
					<span>${kiemdangnhap}</span>
				</div>
				
				<div id="container-social-login">
					<img alt="icon_facebook" src='<c:url value="/resources/Image/icon_facebook.png" />' />
					<img alt="icon_google" src='<c:url value="/resources/Image/icon_google.png" />' />
				</div>
		</div>
	
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>