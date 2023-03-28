package com.lamtai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamtai.dao.NhanVienDao;
import com.lamtai.daoimp.NhanVienImp;
import com.lamtai.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp{

	@Autowired
	NhanVienDao nhanVienDao;

	@Override
	public boolean kiemTraDangNhap(String email, String matKhau) {
		// TODO Auto-generated method stub
		boolean kiemTra = nhanVienDao.kiemTraDangNhap(email, matKhau);
		return kiemTra;
	}

	@Override
	public boolean themNhanVien(NhanVien nhanvien) {
		// TODO Auto-generated method stub
		boolean ktThem = nhanVienDao.themNhanVien(nhanvien);
		return ktThem;
	}


}