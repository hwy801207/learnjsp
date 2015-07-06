<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mypack.CounterBean" %>

<html>
<body>
<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean"/>

Current count value is <jsp:getProperty property="counter" name="myPageBean"/>
</body>
</html>