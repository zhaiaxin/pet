<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2016/11/14
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
${message}
<table border="1" cellspacing="0" cellpadding="0" style="text-align: center;font-size: 20px">
<form  method="get">
    <tr>
        <th>序号</th>
        <th>用户名&nbsp&nbsp</th>
        <th>是否为管理员&nbsp&nbsp</th>
        <th colspan="2">操作</th>
    </tr>
    <c:forEach items="${userList}" var="user" varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td>${user.userName}</td>
            <td>${user.judgeId}</td>

            <c:if test="${sessionScope.user.judgeId == 2}">
            <td><a href="${website}/user/delete/all/${user.id}">删除 by 2</a></td>
                <td><a href="${website}/user/toUpdate/${user.id}">编辑</a></td>
            </c:if>
            <c:if test="${sessionScope.user.judgeId == 1 }">
            <td><a href="${website}/user/delete/user/${user.id}">删除 by 1</a></td>
            </c:if>

<<inp

            <%--<select name="judgeId" onchange="self.location.href=options[selectedIndex].name">--%>
                <%--<option value="" selected="selected">${user.judgeId}</option>--%>
                <%--<c:set var="judgeId" value="${user.judgeId}" />--%>
                <%--<c:if test="${judgeId == 1}">--%>
                    <%--<option name="${website}/user/update" value="0" >0</option>--%>
                <%--</c:if>--%>
                <%--<c:if test="${judgeId == 0}">--%>
                    <%--<option name="${website}/user/update" value="1" >1</option>--%>
                <%--</c:if>--%>
            <%--</select>//之前用这个做了个下拉框，后来不会传参，就放弃了--%>




        </tr>
    </c:forEach>
</form>
</table>
<a href="${website}/user/toIndex">返回主页</a>
<%--<script type="text/javascript" src="http://libs.baidu.com/jquery/1.9.0/jquery.min.js"></script>--%>
<%--<script src="../../../js/select.js" type="text/javascript"></script>--%>
</body>
</html>
