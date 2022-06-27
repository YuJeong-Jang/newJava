<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("id", URLEncoder.encode("손", "UTF-8"));	//인코딩
cookie.setMaxAge(60*60*24*30);	//한달 동안 쿠키 유지
response.addCookie(cookie);
response.sendRedirect("using_cookie.jsp");
%>