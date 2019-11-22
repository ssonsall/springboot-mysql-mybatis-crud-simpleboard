<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form Page</title>
</head>
<body>
<form action="/post/update" method="post">
<input type="hidden" name="id" value="${post.id}"/>
<input type="text" name="title" placeholder="제목" value="${post.title}"/><br/>
<textarea rows="5" cols="20" name="content">${post.content}</textarea><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>