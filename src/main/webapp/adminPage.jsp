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
  <form action="/search.do" method="post">
        <input type="text" name="userid"/>
    <input type="submit" value="찾기"/>
    </div>
  </form>
  <a href="/goToRegister.do">사용자 생성 페이지로 이동</a>
  </body>
</html>
