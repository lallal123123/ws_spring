<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test1 Page</h1>
<%
    out.print("test1 page 입니다.");
%>

<br>
<form action="/test8" method="post">
    <input type="text" name="id" value="ljh"><br>
    <input type="text" name="name" value="lee"><br>
    <input type="submit" value="제출하기">
    </form>
</body>
</html>