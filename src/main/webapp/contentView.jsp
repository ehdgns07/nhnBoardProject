<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

제목:<textarea>${post.getTitle()}</textarea>
작성자: <a href="/userInfo.do?key=${post.getWriterUserId()}">${post.getWriterUserId()}</a>
내용:<textarea>${post.getContent()}</textarea><br/>
조회수: ${post.getViewCount()}
<form action="/postRefactor.do?key=${post.getId()}" method="post">
    <input type="submit" name="button" value="edit" />
    <input type="submit" name="button" value="delete" />
</form>
</body>
</html>
