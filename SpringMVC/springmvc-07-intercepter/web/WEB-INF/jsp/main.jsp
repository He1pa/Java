<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/25
  Time: 14:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
首页
<span>${username}</span>
<p>
    <a href="${pageContext.request.contextPath}/user/out">注销</a>
</p>
</body>
</html>
