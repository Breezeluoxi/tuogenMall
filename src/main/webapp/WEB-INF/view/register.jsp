<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <title>注册</title>
    <link rel="stylesheet" href="/static/css/wei/reset-min.css">
    <link rel="stylesheet" href="/static/css/wei/register.css">
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/wei/register.js"></script>
</head>
<body>
    <div id="container">
        <div>
            <h1>注册</h1>
        </div>
        <ul id="content">
            <li class="type buyer selected">
                <p>用户</p>
                <div class="registerCont selectCont">
                    <form action="/register/user" method="post" enctype="multipart/form-data">
                        <ul>
                            <li>
                                <span class="name">名称:</span>
                                <input type="text" name="userName">
                            </li>
                            <li>
                                <span class="name">密码:</span>
                                <input type="password" name="userPassword">
                            </li>
                            <li>
                                <span class="name">年龄</span>
                                <input type="text" name="userAge">
                            </li>
                            <li>
                                <span class="name">vip等级</span>
                                <input type="text" name="userVipLevel">
                            </li>
                            <li>
                                <span class="name">电话:</span>
                                <input type="text" name="userPhone">
                            </li>
                            <li>
                                <span class="name">userVipLevel:</span>
                                <input type="text" name="userVipLevel">
                            </li>
                            <li>
                                <span class="name">地址:</span>
                                <input type="text" name="userAddress">
                            </li>
                            <li>
                                <div class="centerEle">
                                    <span class="name">头像:</span>
                                    <div class="form-group col-md-3  mb-2">
                                        <input type="text"  id="viewfile1" placeholder="未选择文件" disabled autocomplete="off" class="form-control">
                                        <input type="file" style="display: none" name="icon" onchange="javascript: reShow1();" id="upload1"/>
                                    </div>
                                    <label class="btn btn-primary  mb-2" for="upload1" id="upText1">浏览</label>
                                </div>
                            </li>
                            <li>
                                <input type="submit" value="注册">
                            </li>
                        </ul>

                    </form>

                </div>
            </li>
            <li class="type seller">
                <p>商家</p>
                <div class="registerCont">
                    <form action="/register/merchant" method="post" enctype="multipart/form-data">
                        <ul>
                            <li>
                                <span class="name">名称:</span>
                                <input type="text" name="adminName">
                            </li>
                            <li>
                                <span class="name">商店名:</span>
                                <input type="password" name="adminShopName">
                            </li>
                            <li>
                                <span class="name">密码:</span>
                                <input type="text" name="adminPassword">
                            </li>
                            <li>
                                <div class="centerEle">
                                    <span class="name">头像:</span>
                                    <div class="form-group col-md-3  mb-2">
                                        <input type="text"  id="viewfile" placeholder="未选择文件" disabled autocomplete="off" class="form-control">
                                        <input type="file" style="display: none" name="icon" onchange="javascript: reShow();" id="upload" />
                                    </div>
                                    <label class="btn btn-primary  mb-2" for="upload" id="upText">浏览</label>
                                </div>
                            </li>
                            <li>
                                <input type="submit" value="注册">
                            </li>
                        </ul>

                    </form>

                </div>
            </li>
        </ul>

    </div>
</body>
<script>
    function reShow1() {
        document.getElementById('viewfile1').value = document.getElementById('upload1').value;
    }
    function reShow() {
        document.getElementById('viewfile').value = document.getElementById('upload').value;
    }
</script>
</html>