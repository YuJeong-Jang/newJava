<%@page import="java.util.List"%>
<%@page import="board.model.BoardDAO"%>
<%@page import="board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardDAO boardDAO = BoardDAO.getInstance();
	System.out.println("boardDAO.hashcode : " + boardDAO.hashCode());
	List<BoardDto> list = boardDAO.getBoardList();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../css/board.css" type="text/css" />
</head>
	<body>
	<table width="600">
		<caption>게시판 리스트</caption>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>이름</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<% for(BoardDto dto : list) { %>
		<tr>
			<td><%=dto.getNo() %></td>
			<td><a href="content.jsp?no=<%=dto.getNo() %>"><%=dto.getTitle() %></a></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getWriteDay() %></td>
			<td align="right"><%=dto.getReadCount() %></td>
		</tr>			
		<% } %>
	</table><br>
	<a href="insert.jsp">[글쓰기]</a>
	</body>
</html>