<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-color: #f9fafb;
        margin: 0;
        padding: 0;
    }

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .login-box {
        background-color: #fff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .login-box h1 {
        color: #4CAF50;
        text-align: center;
        margin-bottom: 20px;
    }

    .login-box a {
        display: block;
        text-align: center;
        margin-top: 20px;
        font-size: 18px;
        color: #4CAF50;
        text-decoration: none;
        transition: color 0.3s ease;
    }

    .login-box a:hover {
        color: #45a049;
    }

    table {
        width: 70%;
        margin: 20px auto;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ddd;
        padding: 8px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }

    a {
        color: #4CAF50;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }
</style>
</head>
<body>
	<h1>main page</h1>

	<div class="center">
		<c:if test="${sessionScope.name ne null }">
		${sessionScope.name } 님 환영합니다.<br>
			<a href="/user/logout">로그아웃</a>
			<a href="${pageContext.request.contextPath}/board/writeForm"> 게시물
				작성하기</a>
		</c:if>

		<c:if test="${sessionScope.name eq null }">
			<a href="/user/login">로그인</a>
		</c:if>
	</div>

	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.bno }</td>
					<td><a href="detail?bno=${dto.bno }">${dto.title }</a></td>
					<td>${dto.user.username }</td>
			</c:forEach>
		</tbody>

	</table>
</body>
</html>