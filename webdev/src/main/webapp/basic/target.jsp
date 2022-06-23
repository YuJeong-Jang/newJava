<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% 
		String name = request.getParameter("name");
	   	String str = "안녕 나의 귀여운 " + name;
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<h1><%=str %></h1>
	</form>
</body>
</html>