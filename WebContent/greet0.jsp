<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/mytaglib" prefix="mm" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int size = 3; %>
<% int count = 3; 
	String username = request.getParameter("username");
	StringBuffer buffer = new StringBuffer();
	
	for(int i = 0; i < count; ++i){
		buffer.append("<font size='" + (size++) + "'>" + "\r\n");
		buffer.append("Hi, "+ username + "<br>" + "\r\n");
		buffer.append("</font>" + "\r\n");
		
	
	}
	System.out.println(buffer);
	
	if (username != null && username.equals("Monster") ){
		%>	
		
		Go away , Monster！
		<%} else{ %>
		<%=buffer %>
		
		<%} %>

</body>
</html>