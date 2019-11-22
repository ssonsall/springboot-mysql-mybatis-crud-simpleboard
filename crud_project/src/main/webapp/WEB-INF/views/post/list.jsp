<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>post/list.jsp</title>
</head>
<body>
	<img alt="" src="/gakki.jpg" width="500px" height="500px">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>유저아이디</th>
			<th>제목</th>
			<th>내용</th>
			<th>날짜</th>
		</tr>
		<c:forEach var="post" items="${posts}">
		<tr>
			<th>${post.id}</th>
			<th>${post.userId}</th>
			<th><a href="/post/${post.id}">${post.title}</a></th>
			<th>${post.content}</th>
			<th>${post.createDate}</th>
		</tr>
		</c:forEach>
	</table>
	
	<a href="/post/writeForm">글쓰기</a>
</body>
</html>