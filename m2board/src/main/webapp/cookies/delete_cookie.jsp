<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie cookie = new Cookie("id", URLEncoder.encode("손", "UTF-8"));	//인코딩
cookie.setMaxAge(0);	//쿠키삭제(다른 메소드 따로 없음)
response.addCookie(cookie);
response.sendRedirect("using_cookie.jsp");
%>