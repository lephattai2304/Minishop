package com.lamtai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamtai.dao.HoaDonDao;
import com.lamtai.daoimp.HoaDonImp;
import com.lamtai.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {

	@Autowired
	HoaDonDao hoaDonDao;
	@Override
	public int themHoaDon(HoaDon hoaDon) {
		
		return hoaDonDao.themHoaDon(hoaDon);
	}

}
