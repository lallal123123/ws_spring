<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>list page</h1>
	<a href="writeForm">글작성하기</a>
	글 개수 : ${bbsCnt }
	<table border="1">
		
		<thead>
			<tr>
				<th>번호</th><th>제목</th><th>작성자</th><th>수정</th> <th>삭제</th>
			</tr>
		
		</thead>
		<tbody>
			<c:forEach var="dto"  items="${list }" >
				<tr>
					<td>${ dto.bno}</td>
					<td><a href="detail?bno=${dto.bno}">${ dto.title}</a></td>
					<td>${ dto.writer}</td>
					<td><a href="updateForm?bno=${dto.bno}">수정</a></td>
					<td><a href="delete?bno=${dto.bno}">삭제</a></td>
				</tr>
			
			</c:forEach>
		</tbody>	
	</table>
	

</body>
</html>