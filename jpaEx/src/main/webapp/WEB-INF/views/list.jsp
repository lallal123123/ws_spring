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
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
}

h1 {
	text-align: center;
	color: #333;
	background-color:rgb(135, 221, 172);
	margin: 0;
	padding: 10px;

}

table {
	width: 50%;
	margin: 20px auto;
	border-collapse: collapse;
	background-color: #fff;
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

#pageBox {
	text-align: center;
	margin-top: 20px;
}

#preBtn, #nextBtn {
	background-color: rgb(135, 221, 172);
	color: white;
	padding: 5px 10px;
	border: none;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 13px;
	margin: 4px 8px;
	cursor: pointer;
	border-radius: 4px;
}

a {
	color: rgb(135, 221, 172);
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<h1>list page</h1>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>내용</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="m" items="${list }">
				<tr>
					<td>${m.mno }</td>
					<td>${m.memoText }</td>
				</tr>
			</c:forEach>

		</tbody>


	</table>
	<div id="pageBox">

		<c:if test="${pageBlock ne 1 }">
			<button id="preBtn" onclick="pre()">[이전]</button>
		</c:if>

		<c:if test="${end <endMax }"> <!-- 삼항연산자로 코드 간결하게 가능!!!! -->
			<c:forEach var="x" begin="${begin }" end="${end }">
				<c:if test="${x eq page}">
				 ${x }
			</c:if>
				<c:if test="${x ne page}">
					<a href="list1?page=${x }">${x }</a>
				</c:if>
			</c:forEach>
		</c:if>

		<c:if test="${end >endMax }">
			<c:forEach var="x" begin="${begin }" end="${endMax }">
				<c:if test="${x eq page}">
				 ${x }
	 		</c:if>
				<c:if test="${x ne page}">
					<a href="list1?page=${x }">${x }</a>
				</c:if>
			</c:forEach>
		</c:if>

		<c:if test="${pageBlock ne pageBlockMax }">
			<button id="nextBtn" onclick="next()">[다음]</button>
		</c:if>
	</div>
	<script>
		//alert("${pageBlock}");
		function next() {

			location.href = "pageNext?pageBlock=${pageBlock }";
		}

		function pre() {
			location.href = "pagePre?pageBlock=${pageBlock }";
		}
	</script>

</body>
</html>