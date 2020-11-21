/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: member.LogoutController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 *  2. 버그 개선 - response 사용하면 안 됨. (SendRedirect 문제), 도도, 2020-11-20
 * 
 */
package com.home.website.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.website.controller.Controller;
import com.home.website.util.HttpUtil;

public class LogoutController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String contextPath = req.getContextPath();
		session.invalidate();

		req.setAttribute("locationUrl", contextPath + "/");
		System.out.println("참2");
		HttpUtil.forward(req, res, "/WEB-INF/views/msg/alert.jsp");
		System.out.println("참3");

	}

}
