<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta content="telephone=no" name="format-detection" />
    <script type="text/javascript">basePath = '${basePath}' </script>
    <link rel="stylesheet" href="${basePath}resources/html/css/common.css" type="text/css">
    <link rel="stylesheet" href="${basePath}resources/html/css/pages.css" type="text/css">
    <title>邀请有奖</title>
</head>
<body>
<section>
    <div class="wrap">
        <div class="top">
            <img class=" rubberBand delay1" style="width: 1.5rem;" src="${basePath}resources/html/images/108.png">
            <p style="font-size: 0.32rem;color: #FFFFFF">沈阳鼎骏</p>
            <img class="animated rubberBand delay1" src="${basePath}resources/html/images/m-ten.png">
        </div>
        <div class="content">
            <input type="hidden" name = "sign" value="${sign}">
            <img class="f-title" src="${basePath}resources/html/images/title.png">
            <!-- 如果活动已结束，把以下按钮class="share-btn btn-disable",效果见disable页面 -->
            <c:if test="${isOpen == 1}">
                <a class="share-btn animated shake delay3  share" >分享给朋友</a>
            </c:if>
            <c:if test="${isOpen == 0}">
                <a class="share-btn btn-disable" >活动已结束</a>
            </c:if>
            <img class="s-title" src="${basePath}resources/html/images/title-rule.png">
            <p>
                1.分享专属链接给好友，邀请他使用【鼎骏出行】；
            </p>
            <p>
                2.新用户通过邀请页面留下手机号，即可获得8折无门槛券一张(最高减免15元)，可在【鼎骏出行】APP内使用；
            </p>
            <p>
                3.您邀请的用户使用【鼎骏出行】APP后，您也可以获得8折无门槛券一张(最高减免15元)；
            </p>
            <p>
                4.通过您的邀请链接注册的用户越多，您得到的奖励也越多。
            </p>
        </div>
    </div>
</section>
<script type="text/javascript" src="${basePath}resources/html/js/zepto.min.js"></script>
<script type="text/javascript" src="${basePath}resources/html/js/touch.js"></script>
<script type="text/javascript">
    // 设置rem
    (function (doc, win) {
        var docEl = doc.documentElement,
                resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
                recalc    = function () {
                    var clientWidth = docEl.clientWidth;
                    clientWidth = clientWidth > 750 ? 750 : clientWidth;
                    if (!clientWidth) return;
                    docEl.style.fontSize = 100 * (clientWidth / 750) + 'px';
                };
        if (!doc.addEventListener) return;
        win.addEventListener(resizeEvt, recalc, false);
        doc.addEventListener('DOMContentLoaded', recalc, false);
    })(document, window);

    $(".share").tap(function(){
        var sign = $("input[name='sign']").val();
        var options = ["Hi 朋友，送你8折优惠券，打车就用鼎骏出行，放心又省钱！", "我正在使用鼎骏出行，放心又省钱！送你8折优惠券，邀你一起体验！", basePath +"admin/share?sign="+sign,"www.djrentcar.com/images/coupon/share.png"];
       NativeObject.shareAwards(options);
     //location.href = basePath +"admin/share?sign="+sign;
    });
</script>

</body>
</html>

