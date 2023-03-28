package com.lamtai.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="SIZESANPHAM")
public class SizeSanPham {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int masize;
	String tensize;
	public int getMasize() {
		return masize;
	}
	public void setMasize(int masize) {
		this.masize = masize;
	}
	public String getTenSize() {
		return tensize;
	}
	public void setTenSize(String tensize) {
		this.tensize = tensize;
	}
	
	
}
