<%@ page contentType="text/html;charset=UTF-8" trimDirectiveWhitespaces="true" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="messages" var="message" />
<html>
<head>
    <meta charset='UTF-8' />
    <title><fmt:message key="login" bundle="${message}" /></title>
</head>
<body>
<form method='post' action='/login.do'>
    <fmt:message key="id" bundle="${message}" />: <input type='text' name='id' /><br />
    <fmt:message key="pwd" bundle="${message}" />: <input type='password' name='pwd' /><br />
    <input type='submit' value='<fmt:message key="login" bundle="${message}" />' />
</form>
</body>
</html>
