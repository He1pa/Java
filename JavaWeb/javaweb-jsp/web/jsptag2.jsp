<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
jsptag2
<%--
http://localhost:8080/jsptag.jsp?name=kuangshen&age=12
--%>
<%=request.getParameter("name")%>
<%=request.getParameter("age")%>
</body>
</html>
