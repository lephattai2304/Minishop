package com.lamtai.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lamtai.entity.GioHang;
import com.lamtai.service.NhanVienService;

@Controller
@RequestMapping("api/")
@SessionAttributes({"user","giohang"})
public class ApiController {

	@Autowired
	NhanVienService nhanVienService;
	
	@GetMapping("kiemtradangnhap")
	@ResponseBody
	public String kiemtradangnhap(@RequestParam String email, @RequestParam String matKhau, ModelMap modelMap) {
		boolean kiemTra = nhanVienService.kiemTraDangNhap(email, matKhau);
		modelMap.addAttribute("user", email);
		return ""+kiemTra;
	}
	
	@GetMapping("CapNhatGioHang")
	@ResponseBody
	public void CapNhatGioHang(@RequestParam int masp, 
								@RequestParam int masize,
								@RequestParam int mamau,
								@RequestParam int soluong,
								HttpSession httpSession) {
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		int vitri = kiemTraSanPhamTonTaiGioHang(listGioHangs,masp,masize,mamau);
		listGioHangs.get(vitri).setSoluong(soluong);
	}
	
	@GetMapping("XoaGioHang")
	@ResponseBody
	public String XoaGioHang(@RequestParam int masp, 
								@RequestParam int masize,
								@RequestParam int mamau,
								HttpSession httpSession) {
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		int vitri = kiemTraSanPhamTonTaiGioHang(listGioHangs,masp,masize,mamau);
		listGioHangs.remove(vitri);
		listGioHangs.size();
		httpSession.setAttribute("giohang", listGioHangs);
		return listGioHangs.size()+"";
	}
	
	@GetMapping("ThemGioHang")
	@ResponseBody
	public String ThemGioHang(@RequestParam int masp, 
							@RequestParam int masize,
							@RequestParam int mamau,
							@RequestParam String tensp,
							@RequestParam String giatien,
							@RequestParam String tenmau,
							@RequestParam String tensize,
							@RequestParam int soluong,
							@RequestParam int machitietsp,
							HttpSession httpSession) {
		if(null == httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = new ArrayList<GioHang>();
			GioHang gioHang = new GioHang();
			gioHang.setMasp(masp);
			gioHang.setMasize(masize);
			gioHang.setMamau(mamau);
			gioHang.setTensp(tensp);
			gioHang.setGiatien(giatien);
			gioHang.setTenmau(tenmau);
			gioHang.setTensize(tensize);
			gioHang.setMachitietsp(machitietsp);
			gioHang.setSoluong(1);
			
			
			listGioHangs.add(gioHang);
			httpSession.setAttribute("giohang", listGioHangs);
			
		}else {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			int vitri = kiemTraSanPhamTonTaiGioHang(listGioHangs,masp,masize,mamau);
			if(vitri == -1) {
				GioHang gioHang = new GioHang();
				gioHang.setMasp(masp);
				gioHang.setMasize(masize);
				gioHang.setMamau(mamau);
				gioHang.setTensp(tensp);
				gioHang.setGiatien(giatien);
				gioHang.setTenmau(tenmau);
				gioHang.setTensize(tensize);
				gioHang.setMachitietsp(machitietsp);
				gioHang.setSoluong(1);
				
				listGioHangs.add(gioHang);
			}else {
				int soluongmoi = listGioHangs.get(vitri).getSoluong()+1;
				listGioHangs.get(vitri).setSoluong(soluongmoi);
				
			}
			httpSession.setAttribute("giohang", listGioHangs);
		}
		List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
		return listGioHangs.size()+"";
		
	}

	private int kiemTraSanPhamTonTaiGioHang(List<GioHang> listGioHangs, int masp, int masize, int mamau) {
		for (int i = 0; i < listGioHangs.size(); i++) {
			if (listGioHangs.get(i).getMasp() == masp &&
					listGioHangs.get(i).getMasize() == masize &&
					listGioHangs.get(i).getMamau() == mamau) {
				return i;
			}
		}
		return -1;
	}
	
	/*@GetMapping("LaySoLuongGioHang")
	@ResponseBody
	public String LaySoLuongGioHang(HttpSession httpSession) {
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			return gioHangs.size()+"";
		}
		return "";
	}*/
}
