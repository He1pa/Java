<%@ page import="com.zz.pojo.People" %><%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/14
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //People people = new People();
%>
<jsp:useBean id="people" class="com.zz.pojo.People" scope="page" />
<jsp:setProperty name="people" property="name" value="zz1"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="age" value="3"/>
<jsp:setProperty name="people" property="address" value="js"/>

<jsp:getProperty name="people" property="id" />
<jsp:getProperty name="people" property="name" />
<jsp:getProperty name="people" property="age" />
<jsp:getProperty name="people" property="address" />

</body>
</html>
