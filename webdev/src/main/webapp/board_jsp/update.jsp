<%@page import="board.model.BoardDto"%>
<%@page import="board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	Long no = Long.parseLong(request.getParameter("no"));
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDto boardDto = boardDAO.getBoardView(no);
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/board.css" type="text/css" />
</head>
<body>
	<form action="update_action.jsp" method="post">
		<table>
			<caption>글 수정</caption>
			<tr>
			<th>글번호</th>
			<td><%=boardDto.getNo() %><input type="hidden" name="no" value="<%=boardDto.getNo()%>" readonly="readonly"/></td>
			</tr>
			<tr>
			<th>제목</th>
			<td><input type="text" name="title" autofocus="autofocus" required="required" value="<%=boardDto.getTitle()%>"/></td>
			</tr>
			<tr>
			<th>이름</th>
			<td><input type="text" name="name" required="required" value="<%=boardDto.getName()%>"/></td>
			</tr>
			<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" required="required" /><br>
				<font color="red">*처음 글을 작성시 입력한 비밀번호를 동일하게 재입력해주세요.</font>
			</td>
			</tr>
			<tr>
			<th>내용</th>
			<td><textarea rows="5" cols="50" name="content" required="required" ><%=boardDto.getContent()%></textarea></td>
			</tr>
			<tr>
			<td colspan="2" align="center"><input type="submit" name="완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>