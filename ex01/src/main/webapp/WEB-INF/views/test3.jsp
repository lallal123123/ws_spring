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

<c:forEach var="list" items="${lists}">
    ${list}
</c:forEach>


당신의 이름은 ${name} 입니다.
</body>
</html>