<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:set var="score" value="85"/>
    <c:choose>
        <c:when test="${score>90}">
            90
        </c:when>
        <c:when test="${score>80}">
            80
        </c:when>
        <c:when test="${score>70}">
            70
        </c:when>

    </c:choose>

</body>
</html>
