<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--

  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/9
  Time: 13:25
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
        用&nbsp&nbsp户&nbsp&nbsp名:<input type="text" name="userName" value="${user.userName}" />
    </div>

    <div>
        密&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp码:<input type="password" name="password"/>
    </div>

    <div>
        重复密码:<input type="password" name="passwordAgain"/>${message}
    </div>

    <div>
        <input type="hidden" name="judgeId" value="0">
    </div>

    <input type="submit" value="提交"/>

</form>
</body>
</html>
