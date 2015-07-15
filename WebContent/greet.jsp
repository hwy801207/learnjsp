<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/mytaglib" prefix="mm"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% int size=3; %>
<mm:greet count="3" >
	<font size="<%=size++ %>">
	Hi, ${param.username} <br>
	</font>
</mm:greet>
	

</body>
</html>