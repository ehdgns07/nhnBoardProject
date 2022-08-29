<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <div class="info">ID : ${user.getId()} , 이름 : ${user.getName()}</div>
    <div class="edit">
      <form action="/update.do" method="post">
        <span>이름</span><input type="text" name="edituser" />
        <span>비밀번호</span><input type="text" name="edituser"/>
        <span>프로필</span>
        <img src="http://localhost:8080/profile/${user.getProfileFileName()}">
        <input type="submit" name="button" value="edit" />

        <input type="submit" name="button" value="delete" />
      </form>
    </div>
  </body>
</html>
