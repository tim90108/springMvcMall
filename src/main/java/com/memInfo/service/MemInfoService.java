package com.memInfo.service;

import java.util.List;

import com.memInfo.bean.MemInfo;

public interface MemInfoService {
	List<MemInfo> findMemInfo();
	MemInfo findMemInfo(Integer id);
	void updateMemInfo(MemInfo memInfo);
}
