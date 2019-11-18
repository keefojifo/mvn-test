<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
target.jsp
<%
String name= (String)pageContext.getAttribute("name");
out.println(name);

%>
</body>
</html>