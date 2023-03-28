package com.lamtai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lamtai.entity.SanPham;
import com.lamtai.service.SanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {

	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap) {
		List<SanPham> listsanpham =  sanPhamService.layDanhSachSanPhamLimit(0);
		List<SanPham> allsanpham = sanPhamService.layDanhSachSanPhamLimit(-1);
		int tongsopage = allsanpham.size()/5;
		modelMap.addAttribute("listsanpham", listsanpham);
		modelMap.addAttribute("allsanpham", allsanpham);
		modelMap.addAttribute("tongsopage", tongsopage);
		
		return "themsanpham";
	}
}
