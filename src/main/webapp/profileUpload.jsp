<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/profileUpload.do?key=${requestScope.createUserId}" method ="post" enctype="multipart/form-data">
    파일 : <input type = "file" name="fileName" />
    <input type="submit"  value="Upload" />
</form>
</body>
</html>
