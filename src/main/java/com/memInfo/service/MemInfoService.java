package com.memInfo.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.memInfo.bean.MemInfo;

public interface MemInfoService {
	
	JSONObject insertMemInfo(MemInfo memInfo) throws JSONException;
	
	List<MemInfo> findMemInfo();
	
	JSONObject findMemInfoByLogin(MemInfo memInfo)  throws JSONException;
	
	MemInfo findMemInfoById(Integer id);
	
	JSONObject updateMemInfo(MemInfo memInfo) throws JSONException;
}
