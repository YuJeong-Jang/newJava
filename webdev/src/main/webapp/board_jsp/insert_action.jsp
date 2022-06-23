<%@page import="board.model.BoardDAO"%>
<%@page import="board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setTitle(title);
	boardDto.setName(name);
	boardDto.setPassword(password);
	boardDto.setContent(content);
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	System.out.println("BoardDAO.hashcode : " + boardDAO.hashCode());
	boolean result = boardDAO.insertBoard(boardDto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
<%if(result) {%>
alert('글이 등록되었습니다.');
location.href='list.jsp';
<% } else { %>
alert('글 등록이 실패했습니다.');
location.href='javascript:history.back();';
<% } %>
</script>
</body>
</html>