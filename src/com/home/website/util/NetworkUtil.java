/*
 *  프로젝트 주제: 웹, 모바일 융복합 - 공부
 * 	작성자: Dodo (rabbit.white at daum dot net)
 *  작성일자: 2020-11-20
 *  파일명: NetworkUtil.java
 *  비고: 
 *  1. 신규 생성, 도도, 2020-11-20
 * 
 */
package com.home.website.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetworkUtil {

	 public static String getLocalMacAddress() {
	 	String result = "";
		InetAddress ip;

		try {
			ip = InetAddress.getLocalHost();
	        System.out.println(ip);
		   
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();
		   
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			
			result = sb.toString();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e){
			e.printStackTrace();
		}
		
		return result;
		
	 }
	
}
