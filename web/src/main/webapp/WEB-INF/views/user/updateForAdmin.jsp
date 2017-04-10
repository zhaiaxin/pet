<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/17
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${website}/user/update" method="get">



    <div>
        <input type="hidden" name="id" value="${user.id}">
    </div>

    <div>
        用户名:<input type="text" name="userName" value="${user.userName}" readonly="readonly"/>
    </div>

    <div>
        <input type="hidden" name="password" value="${user.password}" />
    </div>

    <div>
        <input type="hidden" name="passwordAgain" value="${user.password}"/>${message}
    </div>


    <div>
        身份：<input type="text" name="judgeId"/>(0为普通用户，1为管理员，2为超级管理员)
    </div>


    <input type="submit" value="提交"/>

</form>
</body>
</html>
