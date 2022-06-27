<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String msg = null;

if(name.equals("김연아")) {
	msg = "그래 난 " + name + ". 피겨요정이지!";
} else if(name.equals("김연경")) {
	msg = "그래 난 " + name + ". 배구황제지!";
} else if(name.equals("윤두준")) {
	msg = "그래 난 " + name + ". 먹보지!";
} else {
	msg = "그래 난 " + name + ". 똥멍충이지...ㅠ";
}
%>
<%=msg%>