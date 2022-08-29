<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/post.do" method="post">
        <input type="text" name="postTitle" placeholder="제목" />
        <textarea name="postContent" placeholder="내용" ></textarea>
        <input type="submit" value="등록" />
    </form>
</body>
</html>
