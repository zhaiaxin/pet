<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/8
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body>
<form action="${website}/user/register" method="post">

    <div>
        <input type="hidden" name="judgeId" value="0" >
    </div>

    <div>
        用户名：<input type="text" name="userName">${message}
    </div>
    <div>
        密&nbsp&nbsp&nbsp码：<input type="password" name="password">
    </div>
    <div>
        重复密码：<input type="password" name="passwordAgain">
    </div>

    <input type="submit" value="提交"><br>

</form>

</body>
</html>
