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
<form method="post" action="/coupon">
    discount:<input type="text" name="discount">
    baseLine:<input type="text" name="baseLine">
    <input type="submit">
</form>
<br>
put
<form method="post" action="/coupon">
    <input name="_method" value="put" type="hidden">
    id:<input type="text" name="id">
    discount:<input type="text" name="discount">
    baseLine:<input type="text" name="baseLine">
    <input type="submit">
</form>
<br>
delete
<form method="post" action="/coupon">
    <input name="_method" value="delete" type="hidden">
    id:<input type="text" name="id">
    <input type="submit">
</form>
</body>
</html>
