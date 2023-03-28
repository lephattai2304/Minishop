package com.lamtai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamtai.dao.SanPhamDao;
import com.lamtai.daoimp.SanPhamImp;
import com.lamtai.entity.SanPham;

@Service
public class SanPhamService implements SanPhamImp{

	@Autowired
	SanPhamDao sanPhamDao;
	
	@Override
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		List<SanPham>listSanPham = sanPhamDao.layDanhSachSanPhamLimit(spbatdau);
		return listSanPham;
	}

	@Override
	public SanPham layDanhSachSanPhamChiTietTheoMa(int masanpham) {
		SanPham sanPham = sanPhamDao.layDanhSachSanPhamChiTietTheoMa(masanpham);
		return sanPham;
	}

	@Override
	public List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		// TODO Auto-generated method stub
		return sanPhamDao.layDanhSachSanPhamTheoMaDanhMuc(madanhmuc);
	}

}
