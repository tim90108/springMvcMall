package com.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class memInfoFilter implements Filter {
	
	private FilterConfig config;
	
	/****** 開始 ******/
	public void init(FilterConfig config) {
		this.config = config;
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String info = (String) session.getAttribute("loginSuccessInfo");
		
		if (info.isEmpty()) {
			System.out.println("--------未成功過filter------------");
			session.setAttribute("location", req.getRequestURI()); // 設路徑為req.自己
			res.sendRedirect(req.getContextPath() + "/shop/login");
			return;
		} else {
			System.out.println("--------成功過filter------------");
			chain.doFilter(request, response);
		}
		
	}
	
	/****** 結束 ******/
	public void destory() {
		config = null;
	}
}
