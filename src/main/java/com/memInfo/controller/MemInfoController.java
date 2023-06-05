package com.memInfo.controller;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.memInfo.bean.MemInfo;
import com.memInfo.service.MemInfoService;

@Controller
public class MemInfoController {
	
	@Autowired
	private MemInfoService memberservice;
	
	@SuppressWarnings("unused")
	@RequestMapping("memInfo")
	public ModelAndView hello() {
		List<MemInfo> list = memberservice.findMemInfo();
		
		return new ModelAndView("memInfo");
	}
	
	@RequestMapping("list")
	public ModelAndView list() {
		List<MemInfo> resultList = memberservice.findMemInfo();
		ModelAndView model = new ModelAndView();
		model.setViewName("list");
		model.addObject("resultList",resultList);
		
		return model;
	}
	
	@RequestMapping(value = "view" ,method = RequestMethod.POST)
	public ModelAndView view(@RequestParam Integer id,@RequestParam String type) {
		
		MemInfo memInfo = memberservice.findMemInfo(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("view");
		model.addObject("memInfo", memInfo);
		model.addObject("type",type);
		
		return model;
	}
	
	@RequestMapping(value = "update" ,method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("memInfo") MemInfo memInfo,RedirectAttributes attr) throws JSONException {
		
		JSONObject resultUpdate = memberservice.updateMemInfo(memInfo);
		
		String action = resultUpdate.getString("action");
		
		if (action.equals("Y")) {
			attr.addFlashAttribute("message","修改成功");
		}	else {
			attr.addFlashAttribute("message","修改失敗");
		}
		
		return new ModelAndView("redirect:memInfo");
	}
}
