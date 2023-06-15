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
	public JSONObject insertMemInfo(MemInfo memInfo) throws JSONException {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		
		int count = dao.insert(memInfo);
		
		if (count > 0 ) {
			result.put("action", "Y");
		} else {
			result.put("action", "N");
		}
		
		return result;
	}
	
	@Override
	@Transactional
	public List<MemInfo> findMemInfo() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public JSONObject findMemInfoByLogin(MemInfo memInfo) throws JSONException {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		
		MemInfo loginInfo = dao.findByLogin(memInfo);
		
		
		if (loginInfo != null) {
			result.put("action", true);
			result.put("loginInfo", loginInfo);
		} else {
			result.put("action", false);
		}
		return result;
	}
	
	@Override
	@Transactional
	public MemInfo findMemInfoById(Integer id) {
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
