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
				<td>${boardDto.name }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${boardDto.readCount }</td>
			</tr>
			<tr>
				<th>작성시간</th>
				<td>${boardDto.writeDay }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${boardDto.content }</td>
			</tr>
		</table><br>
		<a href="BoardList.do">[리스트]</a>
		<a href="BoardUpdate.do?no=${boardDto.no }">[수정]</a>
		<a href="BoardDelete.do?no=${boardDto.no }">[삭제]</a>
	</body>
</html>