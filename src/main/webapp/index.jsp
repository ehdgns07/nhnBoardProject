<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./public/style.css">
    <title>${title}</title>
</head>
<body>
<div class="wrapper">
    <div class="table-head display-flex">
        <div class="padding-50 head-data">No.</div>
        <div class="padding-50 head-title">제목</div>
        <div class="padding-50 head-auther">글쓴이</div>
        <div class="padding-50 head-createdtime">작성시간</div>
        <div class="padding-50 head-count">조회수</div>
    </div>                 
    <c:forEach var="post" items="${Board.getPosts()}">
    <div class="table-data display-flex">
        <div class="padding-50 data-seq">${post.value.getId()}</div>
        <div class="padding-50 data-title"><a href="/contentView.do?key=${post.value.getId()}">${post.value.getTitle()}</a></div>
        <div class="padding-50 data-auther">${post.value.getWriterUserId()}</div>
        <div class="padding-50 data-createdtime">${post.value.getWriteTime()}</div>
        <div class="padding-50 data-count">${post.value.getViewCount()}</div>
    </div>
    </c:forEach>
    <a href="/post.do">게시글 등록</a>
    <a href="/logout.do">로그아웃</a>
</div>
</body>
</html>