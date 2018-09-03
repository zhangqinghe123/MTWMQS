<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>领取优惠券</title>
    <meta name="viewport" content="width=device-width,initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta content="yes" name="apple-touch-fullscreen">
    <meta content="telephone=no" name="format-detection" />
    <link rel="stylesheet" href="${basePath}resources/html/css/common.css" type="text/css">
    <link rel="stylesheet" href="${basePath}resources/html/css/pages.css" type="text/css">
</head>

<body>
<div class="loading">加载中...</div>
<section>
    <div class="wrap">
        <div class="top">
            <img class=" rubberBand delay1" style="width: 1.5rem ;" src="${basePath}resources/html/images/108.png">
            <p style="font-size: 0.32rem;color: #FFFFFF">沈阳鼎骏</p>
            <img class="animated rubberBand delay1" src="${basePath}resources/html/images/m-ten.png">
        </div>

        <div class="content">
            <form action="" method="">
                <div class="form-control">
                    <input type="hidden" name = "sign" value="${sign}">
                    <input id="mobile" type="tel" name="mobile" placeholder="请输入乘客手机号">
                </div>
            </form>
           <c:if test="${isOpen == 1}">
                <a  class="share-btn animated shake delay3 share" href="javascript:;">马上领取</a>
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
<div class="pop hide">
    <div class="mask"></div>
    <div class="content">
        <div class="error-msg">错误信息错误信息错误信息错误</div>
        <div class="success-info hide">
            <p>恭喜你，我们已经发送1张8折无门槛券到你的账户，请赶快去下载。</p>
            <a href="http://www.djrentcar.com/download/dingjunchuxing.html">我知道了</a>
        </div>
    </div>
</div>
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
    var isCheck = true;
    // todo:使用tap代替click！
  $(function(){
      // 页面加载完成后去掉loading加载层
        $(".loading").hide();
        // 遮罩关闭
        $(".mask").tap(function(event){
            event.preventDefault();
            $(".pop").hide();
        });

    $(".share").tap(function(){
        var mobile = $("#mobile").val();
        var reg = /^(13[0-9]|14[7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9]|17[0|6|7|8])\d{8}$/;
        if(!mobile){
            $(".error-msg").removeClass("hide").html("请先填写手机号哦！");
            $(".success-info").addClass("hide");
            $(".pop").show();
            return false;
        }
        if(!reg.test(mobile)){
            $(".error-msg").removeClass("hide").html("请输入正确手机号!");
            $(".success-info").addClass("hide");
            $(".pop").show();
            return false;
        }
           basePath = '${basePath}';
            if(isCheck) {
                isCheck = false;
                $.ajax({
                    url: basePath + "admin/insShare?mobile=" + $("input[name='mobile']").val()+"&sign="+$("input[name='sign']").val(),
                    type: "POST",
                    success: function (data) {
                        if (data.errCode != 0) {
                            isCheck = true;
                            $(".error-msg").removeClass("hide").html(data.message);
                            $(".success-info").addClass("hide");
                            $(".pop").show();
                        } else {
                            $(".error-msg").addClass("hide").html("");
                            $(".success-info").removeClass("hide");
                            $(".pop").show();
                        }
                    }
                });
            }
      });
})
</script>

</body>
</html>
