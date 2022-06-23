<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Connection cn = null;	//커넥션 객체를 참조
	boolean result = false;	//db 연결 성공하면 true
	try{
		Class.forName("oracle.jdbc.OracleDriver");	//오라클 드라이버 존재 유무 확인
		cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oj", "oj");
		result = true;
	}catch(Exception e) {
		e.printStackTrace();
	}finally{	//사용한 자원을 역순으로 해제
		if(cn!=null) try{cn.close();} catch(Exception e) {}
	}
%>
<!-- C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(result) { %>
데이터베이스 연결 성공
<% } else { %>
데이터베이스 연결 실패
<%} %>
</body>
</html>