<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Form Page</h1>
<%
    out.print("Form page 입니다.");
%>

<form action="/test7" method="get">
    <input type="text" name="id" value="hgd"><br>
    <input type="text" name="name" value="hongildong"><br>
    <input type="submit" >전송<br>
</form>
</body>
</html>