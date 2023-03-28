
$(function() {

	/*$('#cot1').click(function(event) {
		console.log('Da chay duoc hieu ung click roi ')
		alert("hello");
		$(this).addClass('active');
		$(this).next().slideToggle();
		$(this).toggleClass('xanh')
	});*/

	$('#btnDangNhap').click(function(event) {
		console.log('Da chay duoc hieu ung click roi ')
//		alert("hello");
		var email = $('#email').val();
		var matKhau =$('#matKhau').val();
		$.ajax({
			url : "/minishop/api/kiemtradangnhap",
			type : "get", // chọn phương thức gửi là get
//			dateType:"text", // dữ liệu trả về dạng text
			data : { // Danh sách các thuộc tính sẽ gửi đi
				email:email,
				matKhau:matKhau
			},
			success : function (value){
				// Sau khi gửi và kết quả trả về thành công thì gán nội dung trả về
				// đó vào thẻ div có id = result
//				$('#result').html(result);

				if(value == "true")
				{
					duongDanHienTai = window.location.href;
					duongDan = duongDanHienTai.replace("dangnhap/","");
					window.location = duongDan;
//					$('#ketquadangnhap').text("Dang nhap thanh cong!")
				}
				else
				{
					$('#ketquadangnhap').text("Dang nhap that bai!")
				}
			}

		});
	});

	$('#dangnhap').click(function(event) {
		$(this).addClass('active');
		$('#dangky').removeClass('active');
		$(".container-login-form").show();
		$(".container-signup-form").css("display","none");
	});
	$('#dangky').click(function(event) {
		$(this).addClass('active');
		$('#dangnhap').removeClass('active');
		$(".container-login-form").css("display","none");
		$(".container-signup-form").show();
	});
	
	$('.xoa-giohang').click(function(event) {
		var self = $(this);
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensanpham").attr("data-masp");
		
		$.ajax({
			url : "/minishop/api/XoaGioHang",
			type : "get", // chọn phương thức gửi là get
			data : { // Danh sách các thuộc tính sẽ gửi đi
				masp:masp,
				masize:masize,
				mamau:mamau,
			
			},
			success : function (value){
				self.closest("tr").remove();
				tinhtongtien();
				$('.circle-giohang').html("<span>"+value+"</span>");
			}
		})
		
	});
	
	$('.btn-giohang').click(function(event) {
		console.log('Da chay duoc hieu ung click roi ')
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var tenmau = $(this).closest("tr").find(".mau").text();
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var tensize = $(this).closest("tr").find(".size").text();
		var tensp = $("#tensp").text();
		var masp = $("#tensp").attr("data-masp");
		var giatien = $("#giatien").attr("data-value");
		var soluong = $(this).closest("tr").find(".soluong").text();
		var machitietsp = $(this).attr("data-machitietsp");
		
		$.ajax({
			url : "/minishop/api/ThemGioHang",
			type : "get", // chọn phương thức gửi là get
			data : { // Danh sách các thuộc tính sẽ gửi đi
				masp:masp,
				masize:masize,
				mamau:mamau,
				tensp:tensp,
				giatien:giatien,
				tenmau:tenmau,
				tensize:tensize,
				soluong:soluong,
				machitietsp:machitietsp
			},
			success : function (value){
				
				$("#giohang").find("div").addClass("circle-giohang");
				$("#giohang").find("div").html("<span>"+value+"</span>");
			}

		})/*.done(function(){
			$.ajax({
				url : "/minishop/api/LaySoLuongGioHang",
				type : "get", // chọn phương thức gửi là get
				success : function (value){
					alert("hello");
					$("#giohang").find("div").addClass("circle-giohang");
					$("#giohang").find("div").html("<span>"+value+"</span>")
				}

			});
			
		});*/
	});
	
	$(".giatien").each(function(){
		var soluong = $(this).closest("tr").find(".soluonggiohang").val();
		var giatien = parseFloat($(this).text());
		var tongtien = soluong*giatien;
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\,)/g, "$1,").toString();
		$(this).html(format);
	})
	
	tinhtongtien();
		
	$( ".soluonggiohang" ).change(function() {
		var mamau = $(this).closest("tr").find(".mau").attr("data-mamau");
		var masize = $(this).closest("tr").find(".size").attr("data-masize");
		var masp = $(this).closest("tr").find(".tensanpham").attr("data-masp");
		var soluong = $(this).val();
		
		$.ajax({
			url : "/minishop/api/CapNhatGioHang",
			type : "get", // chọn phương thức gửi là get
			data : { // Danh sách các thuộc tính sẽ gửi đi
				masp:masp,
				masize:masize,
				mamau:mamau,
				soluong:soluong
			},
			success : function (value){
			
			}
		})
		var giatien = $(this).closest("tr").find(".giatien").attr("data-value");
		var tongtien = soluong*parseFloat(giatien);
		var format = tongtien.toFixed(3).replace(/(\d)(?=(\d{3})+\,)/g, "$1,").toString();
		$(this).closest("tr").find(".giatien").html(format);
		tinhtongtien();
		
		});
	
	function tinhtongtien(){
		var tongtiensp = 0;
		$(".giatien").each(function(){
			var giatien = ($(this).text());
			tongtiensp = tongtiensp + parseFloat(giatien);
			var formattongtien = parseFloat(tongtiensp).toFixed(3).replace(/(\d)(?=(\d{3})+\,)/g, "$1,").toString();
			$("#tongtiensanpham").html(formattongtien + " VND");
		})
	}
});

