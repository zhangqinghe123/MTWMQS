<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%--
  Created by IntelliJ IDEA.
  User: Qianxia
  Date: 2016/7/8
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>我的中奖纪录</title>


    <script type="text/javascript" src="${basePath}resources/html/js/jquery-1.10.2.js"></script>
   <style>
       .change-list {background-color: #fff;}
       .change-list>li {position: relative;height: 60px;display: -webkit-box;display: box;padding:10px;border-bottom: 1px solid #ccc;}
       .change-list .agree-add{background: #848C9D;color: #fff;}
       .change-list .list-info{display: inline-block;padding-right:25px;}
       .change-list .list-info .title{font-size:16px;font-weight: bold;margin: 0;margin: 0}
       .change-list .list-info .time{color: #9F9A9A;}
       .change-list .change-btn{position: absolute;top:1px;right:0;height: 60px;line-height: 60px;width:60px;text-align: center;background: #ffae00;color: #fff;}
       .change-list .change-btn.done{background: #999;}

       .change-layer{display:none;width: 100%;height: 100%;position: absolute;top: 0;left: 0;background-color:rgba(0,0,0,0.3);
       }
       .change-layer .change-content{width: 250px;background: #fff;border:1px solid #ccc; text-align: center;line-height: 20px;padding: 10px;position: absolute;
           top: 50%;
           left: 50%;
           -webkit-transform: translate(-50%, -50%);
           transform: translate(-50%, -50%);}
       .change-layer .change-content p{width: 100%;clear: both;margin: 15px 0;}
       .change-layer .change-content .title{font-size: 16px;}
       .change-layer .change-content .code-input{width: 85%;border: 1px solid #ccc;line-height: 25px;padding: 3px;}
       .change-layer .change-content .done-btn{background: #ffae00;color: #fff;padding:8px 30px;}
   </style>
</head>
<body>
    <div class="change-page">
        <ul class="change-list">
           <c:forEach items="${lotteryWinnings}" var="z" varStatus="s">
                <li>
                    <div class="list-info">
                        <p class="title">${z.award}</p>
                        <p class="time">中奖:${fn:substring(z.createOn,0,10)}</p>
                    </div>
                    <c:if test="${z.status == 1}">
                        <a href="#" class="change-btn">兑换</a>
                    </c:if>
                    <c:if test="${z.status == 2}">
                        <a href="#" class="change-btn done">已兑换</a>
                    </c:if>
                </li>
           </c:forEach>
        </ul>

        <div class="change-layer" id="change-layer">
            <div class="change-content">
                <p class="title">大米20斤</p>
                <p><input class="code-input" type="text" name = "code" placeholder="请输入兑换码"/></p>
                <p><a href="#" class="done-btn">兑换</a></p>
            </div>
        </div>
    </div>

    <script type="text/javascript">

        $("#change-layer").css({ width: $(window).width(), height: $(window).height() });
        $(".change-btn").click(function () {
            $("#change-layer").show();
        });
        $(".done-btn").click(function () {


            $("#change-layer").hide();
        });
    </script>
</body>
</html>
