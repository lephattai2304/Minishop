package com.lamtai.daoimp;

import com.lamtai.entity.NhanVien;

public interface NhanVienImp {

	boolean kiemTraDangNhap(String email, String matKhau);
	boolean themNhanVien(NhanVien nhanvien);
}
