package com.lamtai.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lamtai.entity.ChiTietHoaDon;
import com.lamtai.entity.ChiTietHoaDonId;
import com.lamtai.entity.GioHang;
import com.lamtai.entity.HoaDon;
import com.lamtai.service.ChiTietHoaDonService;
import com.lamtai.service.HoaDonService;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
	
	@Autowired
	ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	HoaDonService hoaDonService;
	
	@GetMapping
	public String Defaut( ModelMap modelMap, HttpSession httpSession) {
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang", gioHangs.size());
			modelMap.addAttribute("sanphamgiohang", gioHangs);
		}
		return "giohang";
	}

	@PostMapping
	public String ThemHoaDon (@RequestParam String tenkhachhang,
								@RequestParam String sodt,
								@RequestParam String diachigiaohang,
								@RequestParam String hinhthucgiaohang,
								@RequestParam String ghichu,
								HttpSession httpSession) {
		
		if(null != httpSession.getAttribute("giohang")) {
			List<GioHang> listGioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			
			HoaDon hoaDon = new HoaDon();
			hoaDon.setTenkhachhang(tenkhachhang);
			hoaDon.setSodt(sodt);
			hoaDon.setDiachigiaohang(diachigiaohang);
			hoaDon.setGhichu(ghichu);
			hoaDon.setHinhthucgiaohang(hinhthucgiaohang);
			int mahoadon = hoaDonService.themHoaDon(hoaDon);
		
			if(mahoadon > 0 ) {
				Set<ChiTietHoaDonService> listChiTietHoaDon = new HashSet<>();
				for (GioHang gioHang : listGioHangs) {
					ChiTietHoaDonId chiTietHoaDonId = new ChiTietHoaDonId();
					chiTietHoaDonId.setMachitietsanpham(gioHang.getMachitietsp());
					chiTietHoaDonId.setMahoadon(mahoadon);
					
					ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
					chiTietHoaDon.setChiTietHoaDonId(chiTietHoaDonId);
					chiTietHoaDon.setGiatien(gioHang.getGiatien());
					chiTietHoaDon.setSoluong(gioHang.getSoluong());
					chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDon);
				}
			}else {
				System.out.println("them hoa don that bai");
			}
		}else {
			System.out.println("Them hoa don that bai");
		}
		
		return "giohang";
	}
}
