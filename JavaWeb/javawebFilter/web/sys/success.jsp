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
session id:
<%= request.getSession().getAttribute("USER_SESSION")%>

主页
<p><a href="/servlet/loginout">注销</a></p>

</body>
</html>
