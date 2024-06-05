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
			<td>제목</td><td>${board.title }</td>
		</tr>
		<tr>
			<td>작성자</td><td>${board.user.username }</td>
		</tr>
		<tr>
			<td>내용</td><td>${board.content }</td>
		</tr>
		
			
	</table>
	<a href="main">메인으로</a>

</body>
</html>