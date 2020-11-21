/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: FuncUtil.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class FuncUtil {

	public static Timestamp getTodayDate() {
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		return ts;
	}
	
	public static boolean isMobile(HttpServletRequest request) {
		
        String userAgent = request.getHeader("user-agent");
        
        boolean mobile1 = userAgent.matches(".*(iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson).*");
        boolean mobile2 = userAgent.matches(".*(LG|SAMSUNG|Samsung).*");
        
        if(mobile1 || mobile2) {
            return true;
        }
        
        return false;
    }	
	
}
