<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/9
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<%--SP标准标签库（JSTL）中的c:set和c:if标签--%>
<h1>Hello！帅气的${sessionScope.user.userName}!</h1>
<c:set var="judgeId" value="${user.judgeId}"/>


<c:if test="${judgeId == 0}">
    <a href="${website}/user/toUpdate/password/${sessionScope.user.id}">修改密码</a>
</c:if>

<c:if test="${judgeId == 1}">
    <a href="${website}/user/list/user">普通用户管理</a>
</c:if>

<c:if test="${judgeId == 2}">
    <a href="${website}/user/list/all">用户管理</a>
</c:if>





<a href="${website}/cartoon/list">动漫推荐</a>
<h1>${message}</h1>

</body>
</html>