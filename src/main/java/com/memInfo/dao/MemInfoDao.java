package com.memInfo.dao;

import java.util.List;

import com.memInfo.bean.MemInfo;

public interface MemInfoDao {
	
	MemInfo findById(Integer id);
	List<MemInfo> findAll();
	int update(MemInfo memInfo);
}
