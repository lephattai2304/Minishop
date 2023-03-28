package com.lamtai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lamtai.entity.DanhMucSanPham;
import com.lamtai.entity.SanPham;
import com.lamtai.service.DanhMucService;
import com.lamtai.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {

	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/{madanhmuc}/{tendanhmuc}")
	public String Default(@PathVariable int madanhmuc,@PathVariable String tendanhmuc, ModelMap modelMap) {
		
		List<SanPham> listSanPham = sanPhamService.layDanhSachSanPhamTheoMaDanhMuc(madanhmuc);
		List<DanhMucSanPham> danhMucSanPham = danhMucService.layDanhMuc();
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		
		modelMap.addAttribute("tendanhmuc", tendanhmuc);
		modelMap.addAttribute("listSanPham", listSanPham);
		return "sanpham";
	}
}
