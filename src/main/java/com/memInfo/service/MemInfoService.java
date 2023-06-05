package com.memInfo.service;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.memInfo.bean.MemInfo;

public interface MemInfoService {
	List<MemInfo> findMemInfo();
	MemInfo findMemInfo(Integer id);
	JSONObject updateMemInfo(MemInfo memInfo) throws JSONException;
}
