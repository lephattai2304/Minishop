package com.lamtai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lamtai.dao.DanhMucDao;
import com.lamtai.daoimp.DanhMucImp;
import com.lamtai.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp{

	@Autowired
	DanhMucDao danhMucDao;
	@Override
	public List<DanhMucSanPham> layDanhMuc() {
		List<DanhMucSanPham> danhMucSanPham = danhMucDao.layDanhMuc();
		return danhMucSanPham;
	}

}
