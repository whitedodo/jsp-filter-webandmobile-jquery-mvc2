/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: FrontController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.website.controller.member.LoginController;
import com.home.website.controller.member.LogoutController;
import com.home.website.controller.member.ProcessController;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String charset = null;
	private HashMap<String, Controller> list = null;
	
	@Override
	public void init(ServletConfig sc) throws ServletException {
			
		charset = "UTF-8";
		
		list = new HashMap<String, Controller>();
		list.put("/index.do", new com.home.website.controller.home.IndexController() );

		list.put("/sso/login.do", new LoginController() );
		list.put("/sso/process.do", new ProcessController() );
		list.put("/sso/logout.do", new LogoutController() );
		
		// 웹 & 모바일
		list.put("/hama/index.do", new com.home.website.controller.hama.IndexController() );
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res, "GET");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doService(req, res, "POST");
	}
	
	protected void doService(HttpServletRequest req, HttpServletResponse res, String type) throws ServletException, IOException {

		req.setCharacterEncoding(charset);
		
		String retMsg = "";
		String url = req.getRequestURI();
		String contextPath = req.getContextPath();
		String path = url.substring(contextPath.length());
		
		if ( req.getAttribute("resources") != null ) {
			retMsg = (String)req.getAttribute("resources");	
		}
						
		Controller subController = null;
		
		System.out.println(url + "/" + path);
		/*System.out.println("참4-1");*/
		if ( list.get(path) != null ) {
			subController = list.get(path);
		}
		/*System.out.println("참4-2");*/
		
		/*System.out.println(subController);*/
		// Resources 식별표기가 된 경우에만 Controller 처리
		if ( subController != null && 
				retMsg == "true" ) {
			subController.execute(req, res);
		}else if ( subController != null && 
				retMsg == "false") {
			subController.execute(req, res);
		}
		
/*		System.out.println("참4-3");*/
		
	}

}
