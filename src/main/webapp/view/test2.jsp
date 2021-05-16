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
<form method="post" action="/userCoupon">
    userID:<input type="text" name="userId">
    couponId:<input type="text" name="coupon.id">
    num:<input type="text" name="num">
    validityDate:<input type="text" name="validityDate">
    <input type="submit">
</form>
<br>
<%--put--%>
<%--<form method="post" action="/userCoupon">--%>
<%--    <input name="_method" value="put" type="hidden">--%>
<%--    id:<input type="text" name="id">--%>
<%--    userID:<input type="text" name="userId">--%>
<%--    couponId:<input type="text" name="coupon.id">--%>
<%--    num:<input type="text" name="num">--%>
<%--    validityDate:<input type="text" name="validityDate">--%>
<%--    <input type="submit">--%>
<%--</form>--%>
<%--<br>--%>
<%--delete--%>
<%--<form method="post" action="/userCoupon">--%>
<%--    <input name="_method" value="delete" type="hidden">--%>
<%--    id:<input type="text" name="id">--%>
<%--    <input type="submit">--%>
<%--</form>--%>
</body>
</html>
