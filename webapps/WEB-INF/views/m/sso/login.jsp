<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
  <title>로그인(M-SSO)</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/css/themes/default/jquery.mobile-1.4.5.min.css">
  <script src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/js/jquery.js"></script>
  <script src="<%= contextPath %>/resources/js/jquery.mobile-1.4.5/js/jquery.mobile-1.4.5.min.js"></script>
  
<style type="text/css">
	#edit-with-js-bin { 
		display: none !important; 
	}
</style>

</head>
<body>

<!-- 본문 -->
<div data-role="page" id="startpage" data-theme="a">
  
	<div data-role="header" style="background-color:#DF0174;color:#FFF">
    	<h1>로그인 - 예제(OpenSource)</h1>
  	</div>
  	
  	<!-- 본문 -->
  	<div role="main" class="ui-content">
		<form method="POST" data-ajax="false" action="<%= contextPath %>/sso/process.do"
			class="ui-body ui-body-a ui-corner-all">
			
		<label for="text-basic">이메일</label>
		<input type="text" name="email" id="text-basic" value="">
		<br/>
		<label for="text-basic">비밀번호</label>
		<input type="password" name="passwd" id="text-basic" value="">
		<br/>
		<label for="text-basic">인증토큰</label>
		<input type="text" name="token" id="text-basic" value="">
		<br/>
		<input type="submit" class="ui-shadow ui-btn ui-corner-all" value="로그인">
		</form>
	</div>
	
</div>

<!-- 하단 -->
</body>
</html>
