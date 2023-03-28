package com.lamtai.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lamtai.entity.DanhMucSanPham;
import com.lamtai.entity.GioHang;
import com.lamtai.entity.NhanVien;
import com.lamtai.entity.SanPham;
import com.lamtai.service.DanhMucService;
import com.lamtai.service.SanPhamService;



@Controller
@RequestMapping("/chitiet")
@SessionAttributes("giohang")

public class ChiTietController {

	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping("/{masanpham}")
	public String Default(@PathVariable int masanpham, ModelMap modelMap, HttpSession httpSession) {
		SanPham sanPham = sanPhamService.layDanhSachSanPhamChiTietTheoMa(masanpham);
		modelMap.addAttribute("sanpham", sanPham);
		
		List<DanhMucSanPham> danhMucSanPham = danhMucService.layDanhMuc();
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
		}
		return "chitiet";
	}
	
	}
