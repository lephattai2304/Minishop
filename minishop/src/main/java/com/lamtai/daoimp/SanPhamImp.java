package com.lamtai.daoimp;

import java.util.List;

import com.lamtai.entity.SanPham;

public interface SanPhamImp {

	List<SanPham> layDanhSachSanPhamLimit(int spbatdau);
	SanPham layDanhSachSanPhamChiTietTheoMa(int masanpham);
	List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc);
}
