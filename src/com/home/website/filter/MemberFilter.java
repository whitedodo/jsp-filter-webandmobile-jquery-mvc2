/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: MemberFilter.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.home.website.controller.Controller;

/**
 * Servlet Filter implementation class MemberFilter
 */
@WebFilter("*")
public class MemberFilter implements Filter {

	private HashMap<String, Integer> allowUrlList = null;
	private String[] allowResourcesArr = null; 
	
    public void init(FilterConfig fConfig) throws ServletException {
    	
    	allowUrlList = new HashMap<String, Integer>();
    	allowResourcesArr = new String[6];
    	
    	// 허용 URL List
    	allowUrlList.put("/", 1);
    	allowUrlList.put("/sso/login.do", 1);
    	allowUrlList.put("/sso/logout.do", 1);
    	allowUrlList.put("/sso/process.do", 1);	
    	allowUrlList.put("/resources/", 1);
    	
    	// 허용 Resource 자원
    	allowResourcesArr[0] = ".js";
    	allowResourcesArr[1] = ".css";
    	allowResourcesArr[2] = ".jpg";
    	allowResourcesArr[3] = ".gif";
    	allowResourcesArr[4] = ".svg";
    	allowResourcesArr[5] = ".png";
		
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest hReq = (HttpServletRequest)req;
		HttpServletResponse hRes = (HttpServletResponse)res;
		
		HttpSession session = hReq.getSession();
		
		boolean chkResource = false;
		int retUrl = -1;
		
		String url = hReq.getRequestURI();
		String contextPath = hReq.getContextPath();
		String path = url.substring(contextPath.length() );
		String cusUrl = url.replace(contextPath, "");
		
		Object loginSession = null;
		
		//System.out.println("p" + cusUrl);
		
		// 유효 필터 주소값 가져오기
		if ( allowUrlList.get(cusUrl) != null ) {
			retUrl = allowUrlList.get(cusUrl);
		}
		if ( cusUrl.indexOf("/resources/") > 1 ) {
			retUrl = allowUrlList.get(cusUrl);
		}
		
		// 세션 정보 읽기
		if ( session != null ) {
			loginSession = session.getAttribute("login");
		}
		
		//System.out.println("retUrl:" + retUrl + "/" + cusUrl);
		//System.out.print("[][" + session + "/" + session.getAttribute("login"));
		//System.out.println("/" + retUrl + "/" + cusUrl.indexOf("login.do"));
		
		// 유효 범위 내에 있을 때
		if ( retUrl == 1 ) {
			
			if ( cusUrl.equals("/") && loginSession == null ) {
				hRes.sendRedirect(contextPath + "/sso/login.do");
			}else {
				req.setAttribute("resources", "false");
				chain.doFilter(req, res);
			}
			
		}else {
			
			if ( loginSession != null ) {
				req.setAttribute("resources", "false");
				chain.doFilter(req, res);
			}else if (cusUrl.indexOf("resources") > -1){
				req.setAttribute("resources", "false");
				chain.doFilter(req, res);
			}else {
				hRes.sendRedirect(contextPath + "/sso/login.do");
			}
			
			// Resource 파일은 예외처리
			chkResource = checkResources( cusUrl );
			
			if ( chkResource == true ) {
				System.out.println("참1" + cusUrl);
				req.setAttribute("resources", chkResource);
				chain.doFilter(req, res);
				System.out.println("참2" + cusUrl);
			}
			else {
				req.setAttribute("resources", "false");
				chain.doFilter(req, res);
			}
			
		}
		
	}
	
	private boolean checkResources( String url ) {
		
		boolean result = false;
		String ext = "";
		int i = 0 ;
		
		//System.out.println(allowResourcesArr.length);
		while ( i < allowResourcesArr.length) {
			
			ext = allowResourcesArr[i];
			
			if ( url.indexOf( ext ) > 1 ) {
				result = true;				
				break;
			}
			
			i++;
		}
			
		return result;
		
	}
	
	public void destroy() {

	}

}
