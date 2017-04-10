<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/11
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动漫添加</title>
</head>
<body>
<form action="${website}/cartoon/add" method="post">
    <div>
        动漫类别&nbsp&nbsp:<input type="text" name="name"/>
    </div>

    <div>
        动漫名称&nbsp&nbsp:<input type="text" name="pName"/>
    </div>
    <div>
        动漫作者&nbsp&nbsp:<input type="text" name="author"/>
    </div>
    <div>
        动漫介绍&nbsp&nbsp:
        <textarea name="description" rows="5" cols="100"></textarea>
    </div>
    <input type="submit" value="提交">
</form>
</body>
</html>
