/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: controller.home.IndexController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 *  
 */
package com.home.website.controller.home;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.website.controller.Controller;
import com.home.website.util.HttpUtil;

public class IndexController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpUtil.forward(req, res, "/WEB-INF/views/index.jsp");
		
	}

}
