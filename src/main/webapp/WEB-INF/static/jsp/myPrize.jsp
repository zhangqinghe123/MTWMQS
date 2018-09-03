<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Qianxia
  Date: 2016/7/14
  Time: 9:56
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


    <link href="http://apps.bdimg.com/libs/animate.css/3.1.0/animate.min.css" rel="stylesheet" type="text/css">
    <link href="${basePath}resources/html/css/prize.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${basePath}resources/html/js/jquery-1.10.2.js"></script>
    <style>

        .tips-wp{position: fixed;width: 70%;left: 15%;top:30%;background: rgba(3, 2, 4, 0.61);padding: 10px;border-radius: 5px;color: #ffffff;text-align: center}
    </style>
</head>
<body>
<div class="prize-wp">
    <ul>

    <c:forEach items="${lotteryWinnings}" var="z" varStatus="s">
        <li>
            <div class="prize-top <c:if test="${z.status == 2}">prize-top-gray</c:if> clearfix">
                <div class="prize-name fl">${z.award}</div>
                <div class="prize-btn fr vm"><a href="javascript:;" data-title="${z.award}" data-id="${z.id}" <c:if test="${z.status == 1}">class="dj-btn"</c:if>> <c:if test="${z.status == 2}">已</c:if>兑奖</a></div>
            </div>
            <div class="prize-info">
                <table width="100%">
                    <tr>
                        <td width="80" height="20" align="right">截止时间：</td>
                        <td>${fn:substring(z.expireTime,0,10)}</td>
                    </tr>
                    <tr>
                        <td width="80" align="right">兑奖地址：</td>
                        <td>${z.address}</td>
                    </tr>
                </table>
            </div>
        </li>
    </c:forEach>

    </ul>
</div>
<div class="tips-wp" style="display: none">您今日已经抽过奖</div>
<div class="winning-mask" style="display: none"></div>
    <div class="winning-tip animated" id="exchange-tip" style="display: none">
        <div class="winning-top">
            <div class="winning-info">
                <h2 align="center" id="exchangeTitle">兑换码</h2>
                <div>
                    <input type="text" name="code" class="input-code" value="" placeholder="请输入兑奖码"/>
                </div>
            </div>
        </div>
        <div class="winning-btn">
            <a href="#">确定</a>
        </div>
        <div class="cancle-btn">
            <a href="#">取消</a>
        </div>
    </div>
<div class="tips-wp" style="display: none"></div>
<c:if test="${empty lotteryWinnings}">
<a href="javascript:;" id="testBtn" style="margin-left: 5%;display: block;width: 90%;height: 40px;line-height:40px;margin: 20px auto;text-align: center;color: #0c0c0c;font-size: 15px;border-radius: 4px">暂无中奖纪录</a>
</c:if>
    <script type="text/javascript">
        basePath = '${basePath}';
    $(function(){
        $(".dj-btn").click(function(){
            var id = $(this).attr("data-id");
            var title = $(this).attr("data-title");
            $("#exchangeTitle").html(title);
            $(".winning-mask").fadeIn();
            $("#exchange-tip").removeClass("flipOutX");
            $("#exchange-tip").addClass("flipInX");
            $("#exchange-tip").css("display", "block");
            $(".winning-btn, .winning-mask").click(function(){
                var code = $(".input-code").val();
                if(code == "" ){
                    $(".input-code").val("").attr('placeholder','请输入兑奖码');
                    return false;
                }
                if (!(/^[0-9]*$/g.test(code))) {
                    $(".input-code").val("").attr('placeholder','只能输数字');
                    return false;
                }

                $.ajax({
                    type: "GET",
                    url: basePath + "lottery/checkCode?id=" + id +   "&code=" + $("input[name='code']").val(),
                    dataType: "json",
                    success: function (result) {
                        if (result.errCode == 0) {
                            tips("兑奖成功");
                            $(".winning-mask").fadeOut();
                            $("#exchange-tip").removeClass("flipInX");
                            $("#exchange-tip").addClass("flipOutX");

                        } else {
                            $(".input-code").val("").attr('placeholder',result.message);
                            return false;
                        }
                    }
                });
            });
        });

        $(".cancle-btn").click(function(){
            $(".winning-mask").fadeOut();
            $("#exchange-tip").removeClass("flipInX");
            $("#exchange-tip").addClass("flipOutX");
        });


        function tips(content){

            if ($(".tips-wp").length > 0)
            {
                $(".tips-wp").hide();
            }
            $(".tips-wp").html(content);
            var tipsObj = $(".tips-wp");
            $(".tips-wp").show();
            setTimeout(function(){
                if ($(".tips-wp").length > 0)
                {
                    tipsObj.hide();
                    location.reload();
                }
            }, 4000);
        }
    });
</script>
</body>
