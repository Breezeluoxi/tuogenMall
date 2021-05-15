<%--
  Created by IntelliJ IDEA.
  User: 王大哥
  Date: 5/12/2021
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>${myException.error}</title>
    <style>
        .container {
            width: 60%;
            margin: 10% auto 0;
            background-color: #f0f0f0;
            padding: 2% 5%;
            border-radius: 10px;
            text-align: center;
        }
        h1{
            width: 100%;
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>${myException.error}</h1>
    <h2>${myException.description}</h2>
    <a href="${myException.aHref}">${myException.aText}</a>
</div>
</body>
</html>
