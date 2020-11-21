<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login Project</title>
	
	<style type="text/css">
		
		h2{
			margin:auto;
			text-align:center;
		}
		
		.home_tbl{
			width:500px;
			margin:0 auto;
			text-align:center;
			border-collapse:collapse;
		}
		
		.home_tbl td{
			border:1px solid #e2e2e2;
		}
	
		.input_txt{
			width:90%;
		}
		
		.input_button_txt{
			width:98%;
		}
	</style>
	<script type="text/javascript">
	
		function register(){
			location.href = "<%=contextPath%>/nac/index.do";	
		}
	</script>
</head>
<body>
	<h2>Login Project</h2>
	<hr/>
	<br/>
	<!-- 본문 -->
	<form method="POST" action="<%= contextPath %>/sso/process.do">
	<table class="home_tbl">
		<tr>
			<td style="width:20%; background-color:#e2e2e2;">
				<span style="font-weight:bold">계정명</span>
			</td>
			<td>
				<input class="input_txt" type="text" name="email" />
			</td>
		</tr>
		<tr>
			<td style="width:20%; background-color:#e2e2e2;">
				<span style="font-weight:bold">비밀번호</span>
			</td>
			<td>
				<input class="input_txt" type="password" name="passwd" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input class="input_button_txt" type="submit" value="로그인" />
				<input class="input_button_txt" type="button" value="신규등록" onclick="register()" />
			</td>
		</tr>
	</table>
	</form>
</body>
</html>