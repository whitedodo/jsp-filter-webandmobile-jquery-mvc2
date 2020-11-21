/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: member.LoginController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.website.controller.Controller;
import com.home.website.util.FuncUtil;
import com.home.website.util.HttpUtil;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		boolean chkMobile = false;

		// 모바일 디바이스 인식 여부
		chkMobile = FuncUtil.isMobile(req) ;
		
		if ( chkMobile == true ) {
			HttpUtil.forward(req, res, "/WEB-INF/views/m/sso/login.jsp");
		}
		else {
			HttpUtil.forward(req, res, "/WEB-INF/views/sso/login.jsp");
			//HttpUtil.forward(req, res, "/WEB-INF/views/m/sso/login.jsp");
		}

	}

}
