<%--
  Created by IntelliJ IDEA.
  User: 王大哥
  Date: 2020/11/26
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>优惠卷</title>
    <link rel="stylesheet" href="/static/css/wei/reset-min.css">
    <link rel="stylesheet" href="/static/css/wei/userList.css">
    <script src="/static/js/jquery.min.js"></script>

</head>
<body>
增加：
<form action="/coupon" method="post">
    减免金额:<input type="number" name="discount">
    减免门槛: <input type="number" name="baseLine">
    <input type="submit">
</form>
修改：
<form action="/coupon" method="post">
    <input type="hidden" name="_method" value="put">
    优惠卷id:<input type="number" name="id">
    减免金额:<input type="number" name="discount">
    减免门槛: <input type="number" name="baseLine">
    <input type="submit">
</form>
删除：
<form action="/coupon" method="post">
    <input type="hidden" name="_method" value="delete">
    优惠卷id:<input type="number" name="id">
    <input type="submit">
</form>
<h1>优惠卷列表</h1>
<article>
    <table>
        <tr>
            <td class="td_head td_hobby">ID</td>
            <td class="td_head td_name">Discount</td>
            <td class="td_head td_password">BaseLine</td>
        </tr>
    </table>
</article>
</body>
<script>
    $.ajax({
        url: "/coupon",
        success: function (result) {
            console.log(result)
            let trs=""
            $.each(result["detail"]["coupons"], function (n, value) {
                trs += "                <tr>\n" +
                    "                    <td class='td_hobby'>\n" +
                    "                            " + value.id + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_name'>\n" +
                    "                            " + value.discount + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_password'>\n" +
                    "                            " + value.baseLine + "\n" +
                    "                    </td>\n" +
                    "                </tr>\n";
            });
            $("tbody").append(trs)
        }
    })
    window.onload = function () {

        if (${del_success!=null}) {
            ${sessionScope.remove("del_success")}
            alert("删除成功")
        }
        if (${mod_success!=null}) {
            ${sessionScope.remove("mod_success")}
            alert("修改用户成功")
        }
        if (${register_success!=null}) {
            ${sessionScope.remove("register_success")}
            alert("添加用户成功")
        }
    }
</script>
</html>
