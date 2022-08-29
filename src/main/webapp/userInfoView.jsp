<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     작성자이름 : ${infoUser.getName()},
    방문자 수: ${infoUser.getViewCount()}
프로필 :<img src="http://localhost:8080/profile/${user.getProfileFileName()}">

</body>
</html>
