<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
</head>
<body>
	<form action="BoardDeleteAction.do" method="post">
		<table>
			<caption>글 삭제</caption>
			<tr>
			<th>글번호</th>
			<td>${no }<input type="hidden" name="no" value="${no }" readonly="readonly"/></td>
			</tr>
			<tr>
			<th>비밀번호</th>
			<td>
				<input type="password" name="password" required="required" /><br>
				<font color="red">*처음 글을 작성시 입력한 비밀번호를 동일하게 재입력해주세요.</font>
			</td>
			<tr>
			<td colspan="2" align="center"><input type="submit" name="완료" /></td>
			</tr>
		</table>
	</form>
</body>
</html>