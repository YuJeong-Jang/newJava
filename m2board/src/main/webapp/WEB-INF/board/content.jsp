<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/board.css" type="text/css" />
<script type="text/javascript">
function confirm_delete() {
	if(!confirm('정말로 삭제하시겠습니까?')) {
		return;
	}
	location.href = 'BoardDeleteAction.do?no=${boardDto.no }';
}
</script>
</head>
<body>
	<table width="600">
		<caption>글 상세보기</caption>
		<tr>
			<th>글번호</th>
			<td>${boardDto.no }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.title }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${boardDto.memberDto.name }(${boardDto.memberDto.id })</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.readcount }</td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td>${boardDto.regdate }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardDto.content }</td>
		</tr>
	</table>
	<br>
	<a href="BoardList.do">[리스트]</a>
	<c:if test="${boardDto.memberDto.id == sessionScope.userInfo.id}">
		<a href="BoardUpdate.do?no=${boardDto.no }">[수정]</a>
		<a href="javascript:;" onclick="confirm_delete();">[삭제]</a>
	</c:if>
</body>
</html>