<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>detail page</h1>
	
	<table border="1">
	<tr>
	<td>제목</td><td>${bbs.title }</td>
	</tr>
	<tr>
	<td>작성자</td><td>${bbs.writer }</td>
	</tr>
	<tr>
	<td>내용</td><td>${bbs.content }</td>
	</tr>
	<tr>
	<td><a href="delete?bno=${bbs.bno}">삭제</a></td><td><a href="list">목록가기</a></td>
	</tr>
	</table>
	
</body>
</html>