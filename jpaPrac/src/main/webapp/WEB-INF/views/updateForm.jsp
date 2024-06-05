<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>update Form</h1>

	<form action="update" method="post">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" value= ${bbs.title }></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value= ${bbs.writer }></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><input type="text" name="content" value= ${bbs.content }></td>
			</tr>
			<tr>
				<td><button>수정</button></td>
				<td><a href="list">목록가기</a></td>
			</tr>
		</table>
	</form>

</body>
</html>