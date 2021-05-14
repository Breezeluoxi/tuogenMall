<%--
  Created by IntelliJ IDEA.
  User: 周睿锋
  Date: 2021/5/4
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="/static/css/font.css">
    <link rel="stylesheet" href="/static/css/xadmin.css">
    <script src="/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="/static/js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="/static/js/html5.min.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
    <title>后台管理系统</title>
</head>
<style>
    .rt_wrap{
        height:100%;
        position:relative;
    }
    .rt_content{
        margin-bottom:80px;
        margin-right:8px;
        overflow:hidden;
    }
    .page_title{
        height:40px;
        line-height:40px;
        border-bottom:1px #b6b6b6 solid;
        margin:10px 0;
    }
    .page_title h2{
        font-size:15px;
        font-weight:bold;
    }
    .page_title .top_rt_btn{
        display:inline-block;
        height:30px;
        line-height:30px;
        padding:0 15px;
        border:1px #d2d2d2 solid;
        background:#f8f8f8;
        color:#19a97b;
        vertical-align:middle;
        cursor:pointer;
    }
    .fl{
        float:left;
    }
    .fr{
        float:right;
    }
    .top_rt_btn{
        display:inline-block;
        height:30px;
        line-height:30px;
        padding:0 15px;
        border:1px #d2d2d2 solid;
        background:#f8f8f8;
        color:#19a97b;
        vertical-align:middle;
        cursor:pointer;
    }
    .add_icon:before{
        content:"+";
        margin:0 5px;
    }
    table
    {border-collapse:collapse;
        border-spacing:0
    }
    .table{width:100%;
        table-layout:fixed;
        margin:5px 0;
    }
    .table th{
        border:1px #d2d2d2 solid;
        height:40px;
        line-height:40px;
    }
    .table td
    {border:1px #d2d2d2 solid;
        padding:10px 8px;
        position:relative;
    }
    .table tr:hover
    {background:#f9f9f9;
    }
    .table td a{
        color:#19a97b;
        margin:0 5px;
        cursor:pointer;
    }
    .center{
        text-align:center
    }
    .rmb_icon{
        color:#19a97b;
    }
    .rmb_icon:before{
        content:"￥";
        margin-right:2px;
    }
    .paging{margin:8px 0;
        overflow:hidden;
        text-align:right;
    }
    .paging a{background:#19a97b;
        border:1px #139667 solid;
        color:white;padding:5px 8px;
        display:inline-block;
        cursor:pointer;
    }
    .paging a:hover{
        background:#11a274;
        border:1px #0e8f61 solid;
    }
    .paging a:active{
        background:#17a578;
        border:1px #0e8f61 solid;
    }
</style>
<body>
<section class="rt_wrap content mCustomScrollbar">
    <div class="rt_content">
        <div class="page_title">
            <h2 class="fl">商品列表</h2>
            <a href="../view/manager/add_goods.jsp" class="fr top_rt_btn add_icon">添加商品</a>
        </div>
        <div class="layui-card">
            <div class="layui-card-body ">
                <div class="layui-collapse" lay-filter="test">
                    <div class="layui-colla-item">
                        <h2 class="layui-colla-title">条件筛选<i class="layui-icon layui-colla-icon"></i></h2>
                        <div class="layui-colla-content">
                            <form class="layui-form" action="/goods/queryGoodsType" method="post" >
                                <div class="layui-form-item">
                                    <div class="layui-inline">
                                        <label class="layui-form-label">选择商品类型</label>
                                        <div class="layui-input-inline">
                                            <select name="goodTypeId" lay-verify="required" lay-search="">
                                                <option value="1">装饰摆件</option>
                                                <option value="2">布艺软饰</option>
                                                <option value="3">墙式壁挂</option>
                                                <option value="4">蜡艺香熏</option>
                                                <option value="5">创意家居</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="layui-inline">
                                    <label class="layui-form-label">商品售卖类型选择</label>
                                    <div class="layui-input-inline">
                                        <select name="goodSaleType" class="select">
                                            <option value="1">新品</option>
                                            <option value="2">热卖</option>
                                            <option value="3">折扣</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="layui-form-item">
                                    <div class="layui-input-block">
                                        <button class="layui-btn" type="submit"  lay-filter="demo1">立即提交</button>
                                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <table class="table">
            <tr>
                <th>缩略图</th>
                <th>商品编号</th>
                <th>商品名称</th>
                <th>商品类型</th>
                <th>商品售卖类型</th>
                <th>商品价格</th>
                <th>商品库存</th>
                <th>店铺编号</th>
                <th>商品介绍</th>
                <th>操作</th>
            </tr>
            <c:forEach  items="${goodsList}" var="goods">
                <tr>
                    <td class="center"><img src="../../static/img/goods_img/${goods.goodPicUrl}" width="50" height="50" alt="暂无"/></td>
                    <td class="center" id="gid">${goods.goodId}</td>
                    <td id="gname">${goods.goodName}</td>
                    <td class="center" id="gtype">${goods.goodType}</td>
                    <td class="center" id="gsaletype">${goods.goodSaleType}</td>
                    <td class="center" id="gprice"><strong class="rmb_icon">${goods.goodPrice}</strong></td>
                    <td class="center" id="gstock">${goods.goodNum}</td>
                    <td class="center" id="gsellid">${goods.goodShopId}</td>
                    <td class="center" id="gintroduce">${goods.goodIntroduce}</td>
                    <td class="center">
                        <c:if test="${adminLevel==1}">
                            <a href="/goods/gmodPer?goodId=${goods.goodId}" title="编辑" ><img src="../../static/img/goods_page/编辑.png" width="30" height="30"/></a>
                            <a href="/goods/delGoods?goodId=${goods.goodId}" title="删除" ><img src="../../static/img/goods_page/删除.png" width="30" height="30"/></a>
                            <a href="/goods/wareGoods?goodId=${goods.goodId}" title="库存" ><img src="../../static/img/goods_page/KC%20.png" width="30" height="30"/></a>
                        </c:if>
                        <c:if test="${adminLevel==2}">
                            <a style="pointer-events: none;" href="/goods/gmodPer?goodId=${goods.goodId}" title="编辑" ><img src="../../static/img/goods_page/JZ.png" width="30" height="30"/></a>
                            <a style="pointer-events: none;" href="/goods/delGoods?goodId=${goods.goodId}" title="删除" ><img src="../../static/img/goods_page/JZ.png" width="30" height="30"/></a>
                            <a style="pointer-events: none;" href="/goods/wareGoods?goodId=${goods.goodId}" title="库存" ><img src="../../static/img/goods_page/JZ.png" width="30" height="30"/></a>
                        </c:if>

                    </td>
                </tr>
            </c:forEach>
        </table>
        <aside class="paging">
            <c:if test="${pageInfo.hasPreviousPage}">
                <a href="?pageNo=${pageInfo.prePage}">上一页</a>
            </c:if>
            <a> 第${pageInfo.pageNum}页</a>
            <c:if test="${pageInfo.hasNextPage}">
                <a href="?pageNo=${pageInfo.nextPage}">下一页</a>
            </c:if>
        </aside>
    </div>
</section>
</body>
</html>


