<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--jsp:include--%>
<jsp:forward page="jsptag2.jsp">
<jsp:param name="name" value="zz"/>
<jsp:param name="age" value="1"/>
</body>
</jsp:forward>

</html>
