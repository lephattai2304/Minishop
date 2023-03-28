package com.lamtai.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lamtai.entity.ChucVu;
import com.lamtai.entity.NhanVien;
import com.lamtai.service.NhanVienService;

@Controller
@RequestMapping("dangnhap/")

public class DangNhapController {

	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping
	public String Default() {
		
		return "dangnhap";
	}
	
	@PostMapping
	@Transactional
	public String xuLyDangNhap(@RequestParam String email, @RequestParam String matKhau, @RequestParam String nhapLaiMatKhau, ModelMap map) {
		boolean ktemail = validate(email);
		if(ktemail) {
			if(matKhau.equals(nhapLaiMatKhau)) {
				NhanVien nhanvien = new NhanVien();
				nhanvien.setEmail(email);
				nhanvien.setTendangnhap(email);
				nhanvien.setMatkhau(matKhau);
				
				boolean ktThem = nhanVienService.themNhanVien(nhanvien);
				if(ktThem) {
					map.addAttribute("kiemdangnhap", "Tao tai khoan thanh cong");
				}else {
					map.addAttribute("kiemdangnhap", "Tao tai khoan that bai");
				}
			}else {
				map.addAttribute("kiemdangnhap", "Mat khau khong trung khop");
			}
		}else {
			map.addAttribute("kiemdangnhap", "Vui long nhap dung dinh danh email");
		}
		return "dangnhap";
	}	
	
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
			Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}
	/*@Autowired
	NhanVienService nhanVienService;
	
	
	@PostMapping
	@Transactional
	public String xuLyDangNhap(@RequestParam String email, @RequestParam String matKhau, ModelMap modelMap) {
		Session session =sessionFactory.getCurrentSession();
		try {
			String sql = "from NHANVIEN where matkhau = '"+ matKhau +"' and email"+ email";
			NhanVien nhanVien= (NhanVien) session.createQuery(sql).uniqueResult();
			if( nhanVien != null)
			{
				System.out.println("thanh cong");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("that bai");
		}

		
		boolean kiemTra = nhanVienService.kiemTraDangNhap(email, matKhau);
		if(kiemTra == true) {
			modelMap.addAttribute("kiemdangnhap", "Dang nhap thanh cong!");
		}
		else {
			modelMap.addAttribute("kiemdangnhap", "Dang nhap that bai!");
		}
		return "dangnhap";
	}*/
}
