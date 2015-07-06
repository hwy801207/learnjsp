<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mypack.CounterBean" %>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean"></jsp:useBean>
<jsp:setProperty property="counter" name="myPageBean" value="<%=myPageBean.getCounter()+1 %>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Counter</title>
</head>
<body>
Current count value is : <jsp:getProperty property="counter" name="myPageBean"/>

<%
String[] scopeNames = {"No scope", "page", "request", "session", "application"};
int scope = pageContext.getAttributesScope("myPageBean");
%>
<p>scope=<%=scopeNames[scope] %> </p>
<%--
<jsp:forward page="pagecount2.jsp"></jsp:forward>
--%>
</body>
</html>