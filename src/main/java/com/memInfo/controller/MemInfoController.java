package com.memInfo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("index")
	public ModelAndView goIndexView() {
		return new ModelAndView("index", "command", new MemInfo());
	}
	
	@RequestMapping("goRegist")
	public ModelAndView goRegistView() {
		return new ModelAndView("regist", "command", new MemInfo());
	}
	
	@RequestMapping("goLogin")
	public ModelAndView goLoginView() {
		return new ModelAndView("login", "command", new MemInfo());
	}
	
	@RequestMapping("testListener")
	public ModelAndView testListener() {
		return new ModelAndView("index", "command", new MemInfo());
	}
	
	@RequestMapping(value = "insert" ,method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("memInfo") MemInfo memInfo,RedirectAttributes attr) throws JSONException {
		System.out.println("Enter");
		System.out.println("memInfo:"+memInfo.toString());
		JSONObject resultInsert = memberservice.insertMemInfo(memInfo);
		
		String action = resultInsert.getString("action");
		
		if (action.equals("Y")) {
			attr.addFlashAttribute("message","新增成功");
		}	else {
			attr.addFlashAttribute("message","新增失敗");
		}
		
		return new ModelAndView("redirect:index.jsp");
	}
	
	@RequestMapping(value = "login" ,method = RequestMethod.POST)
	public ModelAndView login(	HttpServletRequest request,
            					HttpServletResponse response,
            					@ModelAttribute("memInfo") MemInfo memInfo, 
            					RedirectAttributes attr) throws JSONException {
		
		JSONObject memInfoByLogin = memberservice.findMemInfoByLogin(memInfo);
		ModelAndView model = new ModelAndView();
		
		Boolean action = memInfoByLogin.getBoolean("action");
		MemInfo loginInfo = (MemInfo) memInfoByLogin.get("loginInfo");
		
		System.out.println(loginInfo.toString());
		System.out.println(action);
		if (action) {
			model.addObject("memInfo", loginInfo);
			request.getSession().setAttribute("loginSuccessInfo", memInfo.getAccount());
			attr.addFlashAttribute("message","登入成功");
			model.setViewName("index");
		} else {
			request.getSession().setAttribute("loginSuccessInfo", null);
			attr.addFlashAttribute("message","登入失敗");
			model.setViewName("login");
		}
		
		
		
		return model;
	}
	
	@RequestMapping(value = "goLogout" ,method = RequestMethod.GET)
	public ModelAndView logout(	HttpServletRequest request,
            					HttpServletResponse response,
            					@ModelAttribute("memInfo") MemInfo memInfo, 
            					RedirectAttributes attr) throws JSONException {
		
		ModelAndView model = new ModelAndView();
		
		request.getSession().removeAttribute("loginSuccessInfo");
		attr.addFlashAttribute("message","移除Session成功");
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping("memInfo")
	public ModelAndView hello() {
		@SuppressWarnings("unused")
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
		
		MemInfo memInfo = memberservice.findMemInfoById(id);
		ModelAndView model = new ModelAndView();
		model.setViewName("view");
		model.addObject("memInfo", memInfo);
		model.addObject("type",type);
		
		return model;
	}
	
	@RequestMapping(value = "update" ,method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("memInfo") MemInfo memInfo,RedirectAttributes attr) throws JSONException {
		
		JSONObject resultUpdate = memberservice.updateMemInfo(memInfo);
		
		Boolean action = resultUpdate.getBoolean("action");
		
		if (action) {
			attr.addFlashAttribute("message","修改成功");
		}	else {
			attr.addFlashAttribute("message","修改失敗");
		}
		
		return new ModelAndView("redirect:memInfo");
	}
}
