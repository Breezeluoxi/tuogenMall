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
<h1>优惠卷列表</h1>
<article>
    <table>
        <tr>
            <td class="td_head td_hobby">优惠减免</td>
            <td class="td_head td_name">优惠门槛</td>
            <td class="td_head td_password">数量</td>
            <td class="td_head td_hobby">获得时间</td>
            <td class="td_head td_name">过期时间</td>
        </tr>
    </table>
</article>
</body>
<script>
    $.ajax({
        url: "/userCoupon/${user.userId}",
        success: function (result) {
            console.log(result)
            let trs=""
            $.each(result["detail"]["userCoupons"], function (n, value) {
                trs += "                <tr>\n" +
                    "                    <td class='td_hobby'>\n" +
                    "                            " + value.coupon.discount + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_name'>\n" +
                    "                            " + value.coupon.baseLine + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_password'>\n" +
                    "                            " + value.num + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_hobby'>\n" +
                    "                            " + value.getData + "\n" +
                    "                    </td>\n" +
                    "                    <td class='td_name'>\n" +
                    "                            " + value.validityDate + "\n" +
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
