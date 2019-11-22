<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Write Form Page</title>
</head>
<body>
<form action="/post/save" method="post">
<input type="text" name="title" placeholder="제목"/><br/>
<textarea rows="5" cols="20" name="content"></textarea><br/>
<input type="submit" value="전송"/>
</form>
</body>
</html>