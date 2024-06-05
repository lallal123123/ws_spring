<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>writeForm page</h1>
	<form action="write" method="post">
		제목 : <input type="text" name="title"><br>
		내용 : <input type="text" name ="content"><br>
		작성자 : <input type="text" name = "writer" value="${sessionScope.username }"><br>
		<input type="submit" value="등록">
	</form>


</body>
</html>