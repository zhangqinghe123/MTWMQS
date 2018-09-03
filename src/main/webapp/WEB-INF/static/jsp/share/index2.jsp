<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>朋友得2元，我得2元</title>
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta content="telephone=no" name="format-detection" />
    <script type="text/javascript">basePath = '${basePath}' </script>
    <link rel="stylesheet" href="${basePath}resources/html/css/common.css" type="text/css">
    <style type="text/css">
        body{
            background-color: #fff;
            overflow-y: auto;
        }
        section{
            position: relative;
            width: 100%;
            min-height: 100%;
            padding-bottom: .4rem;
            background-color: #fff;
            color: #666;
            text-align: center;
            font-size: .3rem;
        }
        h2{
            margin-bottom: .2rem;
            font-size: .36rem;
        }
        p{
            padding: 0 .6rem;
            line-height: .5rem;
        }
        #code{
            position: absolute;
            top: 4.05rem;
            left: 2.67rem;
            width: 2.18rem;
            height: 2.18rem;
            overflow: hidden;
        }
        #code canvas{
            width:100%;
            heihgt: 100%
        }
    </style>
</head>
<body>

<section>
    <input type="hidden" name = "sign" value="${sign}">
    <div id="code"></div>
    <img src="${basePath}resources/html/images/main-pic.png">
    <h2>·分享有奖规则·</h2>
    <p>每邀请一名乘客注册并成功打车，你将获得2元收益，收益将月底结算至您的翼支付账户。</p>
</section>
<script type="text/javascript" src="${basePath}resources/js/jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${basePath}resources/html/js/jquery.qrcode.min.js"></script>
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


    var sign = $("input[name='sign']").val();
    var str = basePath +"admin/share?sign="+sign;
    $("#code").qrcode(str);


</script>



</body>
</html>

