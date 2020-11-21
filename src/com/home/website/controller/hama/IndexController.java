/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: controller.hama.IndexController.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.controller.hama;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.home.website.controller.Controller;
import com.home.website.util.FuncUtil;
import com.home.website.util.HttpUtil;

public class IndexController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		boolean chkMobile = FuncUtil.isMobile(req);
		
		System.out.println("참");
		if ( chkMobile == true ) {
			System.out.println("참1");
			HttpUtil.forward(req, res, "/WEB-INF/views/m/hama/index.jsp");
		}else {
			System.out.println("참2");
			//HttpUtil.forward(req, res, "/WEB-INF/views/m/hama/index.jsp");
			HttpUtil.forward(req, res, "/WEB-INF/views/hama/index.jsp");			
		}
		
	}

}
