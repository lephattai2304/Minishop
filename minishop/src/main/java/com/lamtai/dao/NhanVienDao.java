package com.lamtai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamtai.daoimp.NhanVienImp;
import com.lamtai.entity.NhanVien;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienImp {

	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	@Transactional
	public boolean kiemTraDangNhap(String email, String matKhau) {
		Session session =sessionFactory.getCurrentSession();
		try {
			String sql = "from NHANVIEN where matkhau = '"+ matKhau +"' and email='"+ email+"'";
			NhanVien nhanVien= (NhanVien) session.createQuery(sql).uniqueResult();
			if( nhanVien != null)
			{
				return true;
			}
			else {
				return false;
			}
				
		} catch (Exception e) {
			return false;
		}
	}


	@Override
	@Transactional
	public boolean themNhanVien(NhanVien nhanvien) {
		Session session =sessionFactory.getCurrentSession();
		int manhanvien = (int) session.save(nhanvien);
		if(manhanvien > 0) {
			return true;	
		}else  {
			return false;
		}
		
	}

	
}
