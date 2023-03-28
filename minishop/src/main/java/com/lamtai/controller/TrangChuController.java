package com.lamtai.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.lamtai.entity.DanhMucSanPham;
import com.lamtai.entity.SanPham;
import com.lamtai.service.DanhMucService;
import com.lamtai.service.SanPhamService;




@Controller
@RequestMapping("/")
public class TrangChuController {
	@Autowired
	SanPhamService sanPhamServie;
	
	@Autowired
	DanhMucService danhMucService;
	
	@GetMapping
	@Transactional
	public String Default(@SessionAttribute(name = "email",required=false) String user, ModelMap modelMap,HttpSession httpSession) {
		if(httpSession.getAttribute("user") != null	) {
			String email = (String) httpSession.getAttribute("user");
			
			String chucaidau =email.substring(0,1);
			modelMap.addAttribute("chucaidau", chucaidau);
					
		}
		List<DanhMucSanPham> danhMucSanPham = danhMucService.layDanhMuc();
		modelMap.addAttribute("danhmuc", danhMucSanPham);
		
		List<SanPham>listSanPham = sanPhamServie.layDanhSachSanPhamLimit(0);
		modelMap.addAttribute("listSanPham", listSanPham);
		
		return "trangchu";
	}
	
}
