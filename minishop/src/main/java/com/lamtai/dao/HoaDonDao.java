package com.lamtai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamtai.daoimp.HoaDonImp;
import com.lamtai.entity.HoaDon;
@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class HoaDonDao implements HoaDonImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int themHoaDon(HoaDon hoaDon) {
		Session session =sessionFactory.getCurrentSession();
		int mahoadon = (int) session.save(hoaDon);
		if(mahoadon > 0) {
			return mahoadon;
		}else {
			return 0;
		}
		
	}

}
