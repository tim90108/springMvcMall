package com.memInfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.memInfo.bean.MemInfo;
import com.memInfo.service.MemInfoService;

@Controller
public class MemInfoController {
	
	@Autowired
	private MemInfoService memberservice;
	
	@RequestMapping("memInfo")
	public ModelAndView hello() {
		List<MemInfo> list = memberservice.findMemInfo();
		System.out.println(list);
		
		System.out.println(memberservice.findMemInfo(1));
		
		return new ModelAndView("memInfo");
	}
}
