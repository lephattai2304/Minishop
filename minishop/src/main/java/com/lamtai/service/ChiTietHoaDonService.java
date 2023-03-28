package com.lamtai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamtai.dao.ChiTietHoaDonDao;
import com.lamtai.daoimp.ChiTietHoaDonImp;
import com.lamtai.entity.ChiTietHoaDon;
@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {

	@Autowired
	ChiTietHoaDonDao chiTietHoaDonDao;
	
	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {

		return chiTietHoaDonDao.themChiTietHoaDon(chiTietHoaDon);
	}

}
