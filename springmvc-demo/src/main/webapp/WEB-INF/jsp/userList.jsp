<%--
  Created by IntelliJ IDEA.
  User: Crady
  Date: 2019/08/07
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${requestScope.users}" var="user">
   用户ID：<c:out value="${user.id}"/><br>
   姓名：<c:out value="${user.name}"/><br>
   年龄：<c:out value="${user.age}"/><br>
</c:forEach>
</body>
</html>
