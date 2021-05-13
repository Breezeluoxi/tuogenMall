<%--
  Created by IntelliJ IDEA.
  User: 王大哥
  Date: 5/8/2021
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>test</h1>
<br>
post
<form method="post" action="/register/user" enctype="multipart/form-data">
    userName:<input type="text" name="userName">
    userPassword:<input type="text" name="userPassword">
    userAge:<input type="text" name="userAge">
    <input type="file" name="icon">
    <input type="submit">
</form>
<br>
</body>
</html>
