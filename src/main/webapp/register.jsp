<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>${title}</title>
  </head>
  <body>
    <form action="/register.do" method="post">
      <input type="text" name="registerUserId" placeholder="아이디" />
      <input type="text" name="registerUserPwd" placeholder="비밀번호" />
      <input type="text" name="registerUserName" placeholder="이름" />
      <input type="submit" value="생성" />
    </form>
  </body>
</html>
