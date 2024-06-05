<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test6 Page</h1>
<%
    out.print("test6 page 입니다.");
%>

<br>

아이디는 ${member.id}<br>
이름은 ${member.name}

</body>
</html>