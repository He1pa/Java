<%--
  Created by IntelliJ IDEA.
  User: ZZ
  Date: 2020/8/10
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="text-align: center">
    <%--以post方式提交表单，提交到login--%>
    <form action="${pageContext.request.contextPath}/login" method="post">
        用户名:<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        爱好：
        <input type="checkbox" name="hobby" value="抽烟">抽烟
        <input type="checkbox" name="hobby" value="喝酒">喝酒
        <input type="checkbox" name="hobby" value="烫头">烫头

        <br>
        <input type="submit">

    </form>

</div>
</body>
</html>
