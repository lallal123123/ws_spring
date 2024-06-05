<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Index Page</h1>
<%
    out.print("Hello JSP in Springboot");
%><br>
<a href="/test1">test1 바로가기</a> <br>
<a href="/test2">test2 바로가기</a>
<a href="/mv">myView 바로가기</a>
<a href="/test4?id=aaa&name=bbb">test4 바로가기</a>
<a href="/form">form으로 가기</a>
<a href="/test5">test2 바로가기</a>
<a href="/test7/aaa/asd">test7 바로가기</a>
</html>