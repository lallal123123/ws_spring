<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test9 Page</h1>
<%
    out.print("test9 page 입니다.");
%>

<form action ="" method="post">
    <input type="text" id="sid" placeholder="아이디를 입력하세요" oninput="f()">
    <input type="text" id="copy">

</form>
<br>
<button onclick="f2()">f2사용</button>
<dev id="demo"></dev>
아이디는 ${id}<br>
이름은 ${name}

<script>

    function f(){
        let sid = document.getElementById("sid");
      
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            document.getElementById("copy").value = this.responseText;
         }
        xhttp.open("GET", "test10?sid="+sid.value, true);
        xhttp.send();

    }
    function f2(){
       
      
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function() {
            let obj = JSON.parse(this.responseText);
            document.getElementById("demo").innerHTML = "<br>"+obj[0].id+"<br>"+obj[1].id+"<br>";
         }
        xhttp.open("GET", "test12", true);
         xhttp.send();

    }
</script>
</body>
</html>