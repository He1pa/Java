<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--@include会将两个页面合二为一--%>
    <%@include file="common/header.jsp"%>
    <h1>网页主题</h1>
    <%@include file="common/footer.jsp"%>

    <hr>


    <%--jSP标签
        jsp:include：拼接页面，本质还是三个
        --%>
    <jsp:include page="/common/header.jsp"/>
    <h1>网页主体</h1>
    <jsp:include page="/common/footer.jsp"/>
</body>
</html>