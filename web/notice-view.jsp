<%--
  Created by IntelliJ IDEA.
  User: liupengfei
  Date: 2016/7/14
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>易买网 - 首页</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
    <div id="logo"><img src="images/logo.gif" /></div>
    <div class="help"><a href="#" class="shopping">购物车</a><a href="login.jsp">登录</a><a href="register.jsp">注册</a><a href="guestbook.jsp">留言</a></div>
    <div class="navbar">
        <ul class="clearfix">
            <li class="current"><a href="/action">首页</a></li>
            <li><a href="#">图书</a></li>
            <li><a href="#">百货</a></li>
            <li><a href="#">品牌</a></li>
            <li><a href="#">促销</a></li>
        </ul>
    </div>
</div>
<div id="childNav">
    <div class="wrap">
        <ul class="clearfix">
            <li class="first"><a href="#">音乐</a></li>
            <li><a href="#">影视</a></li>
            <li><a href="#">少儿</a></li>
            <li><a href="#">动漫</a></li>
            <li><a href="#">小说</a></li>
            <li><a href="#">外语</a></li>
            <li><a href="#">数码相机</a></li>
            <li><a href="#">笔记本</a></li>
            <li><a href="#">羽绒服</a></li>
            <li><a href="#">秋冬靴</a></li>
            <li><a href="#">运动鞋</a></li>
            <li><a href="#">美容护肤</a></li>
            <li><a href="#">家纺用品</a></li>
            <li><a href="#">婴幼奶粉</a></li>
            <li><a href="#">饰品</a></li>
            <li class="last"><a href="#">Investor Relations</a></li>
        </ul>
    </div>
</div>
<div id="position" class="wrap">
    您现在的位置：<a href="/action">易买网</a> &gt; 公告详情
</div>
<div id="main" class="wrap">
    <div class="left-side">
        <div class="news-list">
            <h4>最新公告</h4>
            <ul>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
                <li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
            </ul>
        </div>
        <div class="spacer"></div>
        <div class="news-list">
            <h4>新闻动态</h4>
            <ul>
                <c:forEach var="noticeslist" varStatus="status" items="${noticeList}">
                    <li><a href="action?id=${noticeslist.ec_id}&judge=detail" target="_blank">${noticeslist.ec_entitle}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div id="news" class="right-main">
        <h1>${notices.ec_entitle}</h1>
        <div class="content">
            ${notices.ec_content}
        </div>
    </div>
    <div class="clear"></div>
</div>
<div id="footer">
    Copyright &copy; 2010 北风教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>

