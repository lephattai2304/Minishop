package com.lamtai.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lamtai.daoimp.ChiTietHoaDonImp;
import com.lamtai.entity.ChiTietHoaDon;
import com.lamtai.entity.ChiTietHoaDonId;

@Repository
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
public class ChiTietHoaDonDao implements ChiTietHoaDonImp {


	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Session sessoin = sessionFactory.getCurrentSession();
		ChiTietHoaDonId chiTietHoaDonId = (ChiTietHoaDonId) sessoin.save(chiTietHoaDon);
		
		if(chiTietHoaDonId != null) {
			return true;
		}else {
			return false;
		}
		
	}

}
