package com.lamtai.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamtai.daoimp.SanPhamImp;
import com.lamtai.entity.ChiTietSanPham;
import com.lamtai.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<SanPham> layDanhSachSanPhamLimit(int spbatdau) {
		Session session =sessionFactory.getCurrentSession();
		List<SanPham> listSanPham = new ArrayList<SanPham>();
		if(spbatdau < 0)
		{
			String sql ="from SANPHAM";
			listSanPham = session.createQuery(sql).getResultList();
		}else {
			listSanPham = session.createQuery("from SANPHAM").setMaxResults(spbatdau).setMaxResults(5).getResultList();
		}
		return listSanPham;
	}

	@Override
	@Transactional
	public SanPham layDanhSachSanPhamChiTietTheoMa(int masanpham) {
		// TODO Auto-generated method stub
		Session session =sessionFactory.getCurrentSession();
		String sql ="from SANPHAM sp where sp.masanpham="+masanpham;
		SanPham sanPham = (SanPham) session.createQuery(sql).getSingleResult();
		/*for(SanPham sanPham : listSanPham) {
			System.out.println(sanPham.getMasanpham());
			for(ChiTietSanPham ctSanPham : sanPham.getChitietsanpham()) {
				System.out.println(ctSanPham.getSoluong());
			}			
				
		}*/
		
		return sanPham;
	}

	@Override
	@Transactional
	public List<SanPham> layDanhSachSanPhamTheoMaDanhMuc(int madanhmuc) {
		Session session =sessionFactory.getCurrentSession();
		String sql ="from SANPHAM sp where sp.danhmucsanpham.madanhmuc="+madanhmuc;
		List<SanPham> listsanPham = session.createQuery(sql).getResultList();
		return listsanPham;
	}

}
