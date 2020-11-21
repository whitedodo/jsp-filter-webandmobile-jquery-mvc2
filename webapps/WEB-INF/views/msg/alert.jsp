<%
	String msg = (String)request.getAttribute("msg");
	String locationUrl = (String)request.getAttribute("locationUrl");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<%
	if ( msg != null ){
%>
	alert('<%= msg %>');
<%
	}
%>

<%
	if ( locationUrl != null ){
%>
	location.href = "<%= locationUrl %>";
<%
	}
%>
</script>