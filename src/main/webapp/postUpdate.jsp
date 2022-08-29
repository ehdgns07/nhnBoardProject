<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/postUpdate.do?key=${post.getId()}" method="post">
    <input type="text" name="postTitle" value="${post.getTitle()}" />
    <textarea name="postContent">${post.getContent()}</textarea>
    <input type="submit" value="등록" />
</form>
</body>
</html>
