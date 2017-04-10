<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fujia
  Date: 2016/4/6
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>动漫大放送</title>
</head>
<body>
${sessionScope.user.userName}<a href="${website}/cartoon/logout">注销</a>
<hr>
${message}
<div class="header">
    <form  action="${website}/cartoon/query/by/condition" method='get'>
        <div>
            动漫类别&nbsp&nbsp:<input type="text" name="name"/>
        </div>
        <div>
            动漫名称&nbsp&nbsp:<input type="text" name="pName"/>
        </div>
        <div>
            动漫作者&nbsp&nbsp:<input type="text" name="author"/>
        </div>


        <input type="submit" value="查询">
    </form>
</div>


<table border="1" cellspacing="0" cellpadding="0" style="text-align: center;font-size: 20px">

    <form  method="get">
        <tr>
            <th>序号</th>
            <th>动漫类别&nbsp&nbsp</th>
            <th>动漫名称&nbsp&nbsp</th>
            <th>动漫作者&nbsp&nbsp</th>
            <th>动漫介绍&nbsp&nbsp</th>
            <th>时间&nbsp&nbsp</th>
            <th colspan="3">操作</th>
        </tr>
    <c:forEach items="${cartoonList}" var="cartoon" varStatus="status">
        <tr>
                <td>${status.index+1}</td>
                <td><a href="${website}/cartoon/query/by/name/${cartoon.name}" >${cartoon.name}</a></td>
                <td>${cartoon.pName}</td>
                <td>${cartoon.author}</td>
                <td>${cartoon.description}</td>
                <td>${cartoon.timeStamp}</td>
            <c:if test="${sessionScope.user.judgeId == 1||sessionScope.user.judgeId == 2}">
                <td><a href="${website}/cartoon/toUpdate/${cartoon.id}">编辑</a></td>
                <td><a href="${website}/cartoon/delete/${cartoon.id}">删除</a></td>
            </c:if>

            <td><a href="${website}/cartoon/list/comment/${cartoon.id}">查看</a></td>


        </tr>
    </c:forEach>
    </form>
    </table>

    <a href="/cartoon/toAdd">添加动漫信息</a>


</body>
</html>
