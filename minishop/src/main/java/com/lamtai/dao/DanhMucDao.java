package com.lamtai.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamtai.daoimp.DanhMucImp;
import com.lamtai.entity.DanhMucSanPham;
import com.lamtai.entity.SanPham;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DanhMucDao implements DanhMucImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<DanhMucSanPham> layDanhMuc() {
	
		Session session =sessionFactory.getCurrentSession();
		String sql ="from DANHMUCSANPHAM";
		List<DanhMucSanPham> danhMucSanPham = session.createQuery(sql).getResultList();
		return danhMucSanPham;
	}

	
}
