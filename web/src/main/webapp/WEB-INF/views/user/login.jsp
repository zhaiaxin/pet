<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/7
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动漫大放送</title>
</head>
<body>
<form action="${website}/user/login/" method="post">
    <div>
        用户名：<input type="text" name="userName" />
    </div>
    <div>
        密&nbsp&nbsp&nbsp码：<input type="password" name="password" />
    </div>
    <input type="submit" value="登录"/>
    <h1>${message}</h1>
</form>
<a href="${website}/user/toRegister">注册用户</a>

</body>
</html>
