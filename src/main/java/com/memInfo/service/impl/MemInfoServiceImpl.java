package com.memInfo.service.impl;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.memInfo.bean.MemInfo;
import com.memInfo.dao.MemInfoDao;
import com.memInfo.service.MemInfoService;

@Service
public class MemInfoServiceImpl implements MemInfoService{
	
	@Autowired
	private MemInfoDao dao;

	@Override
	@Transactional
	public List<MemInfo> findMemInfo() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional
	public MemInfo findMemInfo(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	@Transactional
	public JSONObject updateMemInfo(MemInfo memInfo) throws JSONException {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		
		int count = dao.update(memInfo);
		
		if (count > 0 ) {
			result.put("action", "Y");
		} else {
			result.put("action", "N");
		}
		
		return result;
	}

	
	
}
