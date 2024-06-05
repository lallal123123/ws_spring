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
<a href="/test2">test2 바로가기</a> <br>
<a href="/test3">test3 바로가기</a> <br>
<a href="/form">폼가기</a> <br>
<a href="/test5">test5 바로가기</a> <br>
<a href="/test6">test6 바로가기</a> <br>
<a href="/test7/aaa/bbb">test7 바로가기</a> <br>
<a href="/test9">test9 바로가기</a>
</html>