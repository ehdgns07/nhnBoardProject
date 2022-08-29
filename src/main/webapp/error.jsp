<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Error</title>
</head>
<body>
    Error:
<c:choose>
    <c:when test="${'RuntimeException'.equals(exception.getClass().name)}">${exception.getCause()}</c:when>
    <c:otherwise>${exception}</c:otherwise>
</c:choose>
    <br />
    <br />
    <a href="/">Go to main</a>
</body>
</html>
