package com.memInfo.dao;

import java.util.List;

import com.memInfo.bean.MemInfo;

public interface MemInfoDao {
	
	int insert(MemInfo memInfo);
	
	MemInfo findByLogin(MemInfo memInfo);
	
	MemInfo findById(Integer id);
	
	List<MemInfo> findAll();
	
	int update(MemInfo memInfo);
}
