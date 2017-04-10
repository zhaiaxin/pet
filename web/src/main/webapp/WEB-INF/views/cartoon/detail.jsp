<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/18
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>动漫展示页</title>
    <style type="text/css">
    </style>
</head>
<body>
<div class="header">
    <div class="login">
        <a href="&{website}/user//toIndex">${sessionScope.user.userName}</a>
        <a href="${website}/cartoon/logout">注销</a>
    </div>
</div>

<div class="content">
    <h1>${cartoon.pName}</h1>
    <h4>${cartoon.author}<span>${cartoon.timeStamp}</span></h4>

    <p>动漫介绍 ${cartoon.description}</p>

</div>
<div class="comment">
    <ol>
        <c:forEach items="${commentList}" var="comment">
            <li>${comment.userName}:&nbsp;&nbsp;&nbsp;${comment.content}
                <c:if test="${sessionScope.user.judgeId == 1||sessionScope.user.judgeId == 2}">
                <a href="${website}/cartoon/delete/comment/${comment.id}/${comment.cartoonId}" >删除</a>
                </c:if>
            </li><br><hr>
        </c:forEach>
    </ol>
    <br><hr><br>
    <form action="${website}/cartoon/add/comment" method="get">
        <input type="hidden" name="cartoonId" value="${cartoon.id}">
        <input type="hidden" name="userName" value="${sessionScope.user.userName}">
        评论：<textarea name="content"></textarea>
        <input type="submit" value="提交评论">
    </form>

</div>

</body>
</html>