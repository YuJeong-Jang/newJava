<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    	public String dateFormat(int year, int month, int date) {
    	return year + "년 " + month + "월 " + date + "일";
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();	//인스턴스를 얻어온 바로 그 시점의 년, 월, 일로 셋팅
	/* out.println("<h1>"+ cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1) + "월 " + cal.get(Calendar.DATE) + "일" + "</h1>"); */
	
%>
<!-- 표현식(expression) -->
<h1><%=
dateFormat(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DATE))
/* cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1) + "월 " + cal.get(Calendar.DATE) + "일" */ %></h1>
</body>
</html>