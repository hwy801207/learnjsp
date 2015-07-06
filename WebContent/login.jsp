<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="/mytaglib" prefix="mm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% String language = request.getParameter("language");
	if (language == null) language = "English";
	session.setAttribute("language", language);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><mm:message key="login.title"/></title>
</head>
<body>
<br>
<form name="loginForm" method="post" action="hello.jsp">
<table>
<tr><td><div align="right"><mm:message key="login.user"/>:</div></td><td><input type="text" name="username"></td></tr>
<tr><td><div align="right"><mm:message key="login.password"/>:</div></td><td><input type="text" name="password"></td></tr>
<tr><td></td>
<td><input type="submit" name="Submit" value=<mm:message key="login.submit"/> > </td></tr>

</table>
</form>

</body>
</html>