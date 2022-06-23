<%@page import="board.model.BoardDAO"%>
<%@page import="board.model.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Long no = Long.parseLong(request.getParameter("no"));
	String password = request.getParameter("password");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setNo(no);
	boardDto.setPassword(password);
	
	BoardDAO boardDAO = BoardDAO.getInstance();
	boolean result = boardDAO.deleteBoard(boardDto); 
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
alert('글이 삭제되었습니다.');
location.href='list.jsp';
<% } else { %>
alert('글 삭제가 실패했습니다. 비밀번호를 확인하세요.');
location.href='javascript:history.back();';
<% } %>
</script>
</body>
</html>