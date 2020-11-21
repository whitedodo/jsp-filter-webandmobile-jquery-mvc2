/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: member.ProcessController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.website.controller.Controller;
import com.home.website.util.FuncUtil;
import com.home.website.util.HttpUtil;

public class ProcessController implements Controller {

	private String admEmail = "root@localhost";
	private String admPasswd = "123456";
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String contextPath = req.getContextPath();
		HttpSession session = req.getSession();
		
		boolean chkMobile = false;
		
		String usrEmail = "";
		String usrPasswd = "";
		
		if ( req.getParameter("email") != null ) {
			usrEmail = req.getParameter("email");
		}
		
		if ( req.getParameter("passwd") != null ) {
			usrPasswd = req.getParameter("passwd");
		}
		
		// 모바일 디바이스 인식 여부
		chkMobile = FuncUtil.isMobile(req) ;
		
		if ( usrEmail.equals(admEmail) && 
				usrPasswd.equals(admPasswd)) {
		
			session.setAttribute("login", "hello");
			req.setAttribute("locationUrl", contextPath + "/hama/index.do");
			HttpUtil.forward(req, res, "/WEB-INF/views/msg/alert.jsp");
		
		}else {
			req.setAttribute("msg", "계정을 확인하세요.");
			req.setAttribute("locationUrl", "login.do");
			HttpUtil.forward(req, res, "/WEB-INF/views/msg/alert.jsp");
		}

	}

}
