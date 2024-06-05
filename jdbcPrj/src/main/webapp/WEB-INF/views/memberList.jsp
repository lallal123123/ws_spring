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
<h1>memberList Page</h1>

<table border="1">
    <thead>
        <tr>
            <th>id</th><th>이름</th><th>역할</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="m" items="${members}">
            <tr>
                <td>${m.id}</td><td>${m.name}</td><td>${m.role}</td>
            </tr>

        </c:forEach>
    
    </tbody>
</table>


</html>