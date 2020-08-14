<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/servlet/login" method="post">
    <span>用户名：</span> <input type="text" name="username">

    <input type="submit">
</form>
session id:
<%= request.getSession().getAttribute("USER_SESSION")%>

</body>
</html>
