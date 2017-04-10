<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/10
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动漫信息修改</title>
</head>
<body>

<form action="${website}/cartoon/update/${id}" method="get">


    <td>动漫类别&nbsp&nbsp： <input name="name" type="text" value="${cartoon.name}" /></td><p>
    <td>动漫名称&nbsp&nbsp： <input name="pName" type="text" value="${cartoon.pName}" /></td><p>
    <td>动漫作者&nbsp&nbsp： <input name="author" type="text" value="${cartoon.author}" /></td><p>
    <td>动漫介绍&nbsp&nbsp:  <textarea name="description" rows="5" cols="100" ></textarea></td><p>
    <p>
       <input type="submit" name="Submit" value="更新" />
    </p>
</form>
</body>
</html>

