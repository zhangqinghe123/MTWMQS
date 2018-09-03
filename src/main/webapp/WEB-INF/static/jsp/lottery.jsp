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
    <title>每日抽奖</title>

    <link href="${basePath}resources/html/css/style.css" rel="stylesheet" type="text/css">
    <link href="http://apps.bdimg.com/libs/animate.css/3.1.0/animate.min.css" rel="stylesheet" type="text/css">
    <link href="${basePath}resources/html/css/prize.css" rel="stylesheet" type="text/css">


    <script type="text/javascript" src="${basePath}resources/html/js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="${basePath}resources/html/js/awardRotate.js"></script>
<style>
    .color-rect{
        color: #FFF;
    }
</style>
</head>
<body>
<img src="${basePath}resources/html/images/1.png" id="shan-img" style="display:none;" />
<img src="${basePath}resources/html/images/2.png" id="sorry-img" style="display:none;" />
<div class="banner">
    <div class="turnplate" style="background-image:url(${basePath}resources/html/images/turnplate-bg.png);background-size:100% 100%;">
        <canvas class="item" id="wheelcanvas" width="422px" height="422px"></canvas>
        <img class="pointer" src="${basePath}resources/html/images/turnplate-pointer.png"/>
    </div>
</div>
<input name = "userId" type="hidden" value="${userId}">
<input name = "isDriver" type="hidden" value="${isDriver}">
<input name = "sign" type="hidden" value="${sign}">
<div style="text-align: center;color: yellow;font-size: 14px" >今天还剩<span id="lottyTime">${time}</span>次</div>
<div class="jp-get-a"><a href="${basePath}lottery/myWinning?isDriver=${isDriver}&userId=${userId}&sign=${sign}">我的中奖纪录>></a></div>
<div id="jpContent" class="jp-set">
    <h5><span style="font-size: 18px">奖品设置</span> <span class="set-span"><a  href="tel:13514014887" style="color: #fed82c">提供赞助请点此>></a></span></h5>
    <div class="set-content">
        <table width="100%" cellpadding="0" cellspacing="0">
            <thead>
            <tr>
                <th align="left" width="30%">奖品</th>
                <th align="center" width="25%">数量</th>
                <th align="center">奖品赞助商</th>
            </tr>
            </thead>
            <tbody>
          <c:forEach items="${lottyAwards}" var="z" varStatus="s">
                <tr>
                    <td align="left" height="40" width="30%" style="font-size: 14px">${z.title}</td>
                    <td align="center" width="25%">${z.showNum}</td>
                      <td align="center" ><a class="color-rect" <c:if test="${ !empty  z.companyUrl && (fn:contains(z.companyUrl,'http') || fn:contains(z.companyUrl,'https')) }">style="text-decoration:underline" href="${z.companyUrl}" </c:if>>${z.sponsors}</a></td>
                   </tr>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="jp-md">
        <div class="title">中奖名单</div>
        <div class="content">
            <table width="100%" cellpadding="0" cellspacing="0">
                <c:if test="${isDriver == 1}">
                    <c:forEach items="${lottyWining}" var="z" varStatus="s">
                        <tr>
                            <td width="25%" align="left" height="33">${z.companyName}</td>
                            <td width="25%" align="center">${z.plateNum}</td>
                            <td width="25%" align="center">${z.name}</td>
                            <td align="right">${z.award}</td>
                        </tr>

                    </c:forEach>
                </c:if>

                <c:if test="${isDriver == 0}">
                    <c:forEach items="${lottyWining}" var="z" varStatus="s">
                        <tr>
                            <td width="35%" align="left" height="33">${fn:substring(z.mobile,0,2)}*******${fn:substring(z.mobile,9,11)}</td>
                            <td width="25%" align="center">${z.name}</td>
                            <td align="right">${z.award}</td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
    </div>
    <div class="jp-rule">
        <div>
            <table width="100%" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="40%" align="right"><img src="${basePath}resources/html/images/ac1@2x.png" alt="" width="75%"/></td>
                    <td align="center">活动规则</td>
                    <td width="40%" align="left"><img src="${basePath}resources/html/images/ac@2x.png" alt="" width="75%"/></td>
                </tr>
            </table>
        </div>
        <div class="content">
            <ul>
              <c:if test="${isDriver == 1}">
                <li>1.抽奖每日19:00-20:00开放，互联打的平台所有出租车司机都可以参与活动</li>
                <li>2.出车每满4小时获得1次抽奖机会（点击收车时计算），每接单成功1次获得1次抽奖机会，抽奖机会当天有效</li>
                <li>3.中奖后根据提示在有效期内到指定地点兑奖</li>
                <li>4.如有疑问请咨询0595－22501313，互联打的拥有最终解释权</li>
              </c:if>
                <c:if test="${isDriver == 0}">
                    <li>1.抽奖每日19:30-20:30开放，互联打的平台所有乘客都可以参与活动</li>
                    <li>2.每位乘客每天有1次抽奖机会，每打车成功1次有1次抽奖机会，当天有效</li>
                    <li>3.中奖后根据提示在有效期内到指定地点兑奖</li>
                    <li>4.如有疑问请咨询0595－22501313，互联打的拥有最终解释权</li>
                </c:if>
            </ul>
        </div>
    </div>
</div>
<div class="tips-wp" style="display: none">您今日已经抽过奖</div>
<div class="winning-mask" style="display: none">
<div class="winning-tip animated" id="winning-tip" >
    <div class="winning-top">
        <div class="winning-info">
            <h5 align="center" id="showTitle">恭喜您，陈师傅！</h5>
            <ul>
                <li >兑奖时间：<span id="showDate">08月08日</span>前</li>
                <li >兑奖地点：<span id="showAddress">互联打的的公司大门</span></li>
                <li >兑奖凭证：注册手机号（尾号<span id="showPhone">1234</span>）</li>
            </ul>
        </div>
    </div>
    <div class="winning1-btn">
        <a href="#">好的</a>
    </div>
</div>
</div>

<script type="text/javascript">
    basePath = '${basePath}';


    if($("input[name='isDriver']").val() == 0){

       $("body").css("background","url("+basePath+"resources/html/images/bgp@2x.png) no-repeat #1ab938");
        $("body").css("background-size","100%");
    }
    var isCheck = true;
    var turnplate={
        ids:[],				     //大转盘奖品id
        restaraunts:[],				//大转盘奖品名称
        colors:[],					//大转盘奖品区块对应背景颜色
        outsideRadius:192,			//大转盘外圆的半径
        textRadius:155,				//大转盘奖品位置距离圆心的距离
        insideRadius:68,			//大转盘内圆的半径
        startAngle:0,				//开始角度
        bRotate:false				//false:停止;ture:旋转
    };

    $(document).ready(function(){
        $(".banner").css("margin-top", $(window).width()*0.47);
        $.ajax({
            type: "GET",
            url: basePath+"lottery/jp?isDriver="+$("input[name='isDriver']").val(),
            dataType: "json",
            success: function(result){
                var jsonList = result.data;
                var jpArray = [];
                var idArray = [];
                $(jsonList).each(function(i){
                    var record = jsonList[i];
                    jpArray.push(record.jp);
                    idArray.push(record.id);
                });
                turnplate.restaraunts = jpArray;
                turnplate.ids = idArray;

                //颜色也可以由后台传过来
                turnplate.colors = ["#FE6500", "#FFEB8C", "#FE6500", "#FFEB8C","#FE6500", "#FFEB8C","#FE6500", "#FFEB8C","#FE6500", "#FFEB8C"];
                drawRouletteWheel();
                $('.pointer').click(function () {

                /*    if($("input[name='isDriver']").val() == 1) {*/

                        if (isCheck) {
                            isCheck = false;
                            $.ajax({
                                type: "GET",
                                url: basePath + "lottery/random?userId=" + $("input[name='userId']").val() + "&isDriver=" + $("input[name='isDriver']").val()+ "&sign=" + $("input[name='sign']").val(),
                                data: {username: $("#username").val(), content: $("#content").val()},
                                dataType: "json",
                                success: function (result) {
                                    if (result.errCode == 0) {
                                        if (turnplate.bRotate)return;
                                        turnplate.bRotate = !turnplate.bRotate;
                                        //获取随机数(奖品个数范围内)
                                        var item = result.data + 1;
                                        console.log("后台随机数：" + item);
                                        //奖品数量等于10,指针落在对应奖品区域的中心角度[252, 216, 180, 144, 108, 72, 36, 360, 324, 288]
                                        rotateFn(item, turnplate.restaraunts[item - 1], turnplate.ids[item - 1]);
                                        $("#lottyTime").html($("#lottyTime").html() - 1);
                                    } else {
                                        isCheck = true;
                                        tips(result.message);
                                    }
                                }
                            });
                        }

                 /*   }else{
                        tips("抽奖即将开始，敬请期待");
                    }*/
                });
            }
        });
    });

    var rotateTimeOut = function (){
        $('#wheelcanvas').rotate({
            angle:0,
            animateTo:2160,
            duration:8000,
            callback:function (){
                tips('网络超时，请检查您的网络设置！');
            }
        });
    };

    function tips(content){
        if ($(".tips-wp").length > 0)
        {
            $(".tips-wp").hide();
        }
        $(".tips-wp").html(content);
        var tipsObj = $(".tips-wp");
        $(".tips-wp").fadeIn();
        setTimeout(function(){
            if ($(".tips-wp").length > 0)
            {
                tipsObj.hide();
            }
        }, 4000);
    }
    function fDateTime(time,f)
    {
        var date = new Date(time);
        var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
        var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
        var h = date.getHours() > 9 ? date.getHours() : "0" + date.getHours();
        var m = date.getMinutes() > 9 ? date.getMinutes() : "0" + date.getMinutes();
        var s = date.getSeconds() > 9 ? date.getSeconds() : "0" + date.getSeconds();

        return date.getFullYear() + '年' + month + '月' + day + '日' ;


    }

    //旋转转盘 item:奖品位置; txt：提示语;
    var rotateFn = function (item, txt,id){
        var angles = item * (360 / turnplate.restaraunts.length) - (360 / (turnplate.restaraunts.length*2));
        if(angles < 270){
            angles = 270 - angles;
        }else{
            angles = 360 - angles + 270;
        }
        $('#wheelcanvas').stopRotate();
        $('#wheelcanvas').rotate({
            angle:0,
            animateTo:angles+1800,
            duration:8000,
            callback:function () {
                isCheck = true;
                //处理得奖后的回调事件，可以去服务端处理相关业务，异步
                turnplate.bRotate = !turnplate.bRotate;
                if (id != 0) {
                    $.ajax({
                        type: "GET",
                        url: basePath + "lottery/insAward?id=" + id + "&userId=" + $("input[name='userId']").val() + "&isDriver=" + $("input[name='isDriver']").val()+ "&sign=" + $("input[name='sign']").val(),
                        dataType: "json",
                        success: function (result) {
                            if (result.errCode == 0) {
                                $("#showTitle").html("恭喜您,"+ result.data.name+"！");
                                $("#showDate").html(fDateTime(result.data.time));
                                $("#showAddress").html(result.data.address);
                                $("#showPhone").html(result.data.mobile);
                                $(".winning-mask").fadeIn();
                                $("#winning-tip").removeClass("bounceOut");
                                $("#winning-tip").addClass("bounceIn");
                                $("#winning-tip").css("display", "block");
                                $(".winning-btn, .winning-mask").click(function(){
                                    $(".winning-mask").fadeOut();
                                    $("#winning-tip").removeClass("bounceIn");
                                    $("#winning-tip").addClass("bounceOut");
                                });

                            } else {
                                tips(result.message);
                            }
                        }
                    });
                }

            }
        });
    };

    function rnd(n, m){
        var random = Math.floor(Math.random()*(m-n+1)+n);
        return random;

    }


    function drawRouletteWheel() {
        var canvas = document.getElementById("wheelcanvas");
        if (canvas.getContext) {
            //根据奖品个数计算圆周角度
            var arc = Math.PI / (turnplate.restaraunts.length/2);
            var ctx = canvas.getContext("2d");
            //在给定矩形内清空一个矩形
            ctx.clearRect(0,0,422,422);
            //strokeStyle 属性设置或返回用于笔触的颜色、渐变或模式
            ctx.strokeStyle = "#FFBE04";
            //font 属性设置或返回画布上文本内容的当前字体属性
            ctx.font = 'bold 18px Microsoft YaHei';
            for(var i = 0; i < turnplate.restaraunts.length; i++) {
                var angle = turnplate.startAngle + i * arc;
                ctx.fillStyle = turnplate.colors[i];
                ctx.beginPath();
                //arc(x,y,r,起始角,结束角,绘制方向) 方法创建弧/曲线（用于创建圆或部分圆）
                ctx.arc(211, 211, turnplate.outsideRadius, angle, angle + arc, false);
                ctx.arc(211, 211, turnplate.insideRadius, angle + arc, angle, true);
                ctx.stroke();
                ctx.fill();
                //锁画布(为了保存之前的画布状态)
                ctx.save();

                //----绘制奖品开始----
                ctx.fillStyle = "#111111";
                var text = turnplate.restaraunts[i];
                var line_height = 17;
                //translate方法重新映射画布上的 (0,0) 位置
                ctx.translate(211 + Math.cos(angle + arc / 2) * turnplate.textRadius, 211 + Math.sin(angle + arc / 2) * turnplate.textRadius);

                //rotate方法旋转当前的绘图
                ctx.rotate(angle + arc / 2 + Math.PI / 2);

                /** 下面代码根据奖品类型、奖品名称长度渲染不同效果，如字体、颜色、图片效果。(具体根据实际情况改变) **/
                if(text.indexOf("M")>0){//流量包
                    var texts = text.split("M");
                    for(var j = 0; j<texts.length; j++){
                        ctx.font = j == 0?'bold 20px Microsoft YaHei':'16px Microsoft YaHei';
                        if(j == 0){
                            ctx.fillText(texts[j]+"M", -ctx.measureText(texts[j]+"M").width / 2, j * line_height);
                        }else{
                            ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
                        }
                    }
                }else if(text.indexOf("M") == -1 && text.length>6){//奖品名称长度超过一定范围
                    text = text.substring(0,6)+"||"+text.substring(6);
                    var texts = text.split("||");
                    for(var j = 0; j<texts.length; j++){
                        ctx.fillText(texts[j], -ctx.measureText(texts[j]).width / 2, j * line_height);
                    }
                }else{
                    //在画布上绘制填色的文本。文本的默认颜色是黑色
                    //measureText()方法返回包含一个对象，该对象包含以像素计的指定字体宽度
                    ctx.fillText(text, -ctx.measureText(text).width / 2, 0);
                }

                //添加对应图标
                if(text.indexOf("闪币")>0){
                    var img= document.getElementById("shan-img");
                    img.onload=function(){
                        ctx.drawImage(img,-15,10);
                    };
                    ctx.drawImage(img,-15,10);
                }else if(text.indexOf("谢谢参与")>=0){
                    var img= document.getElementById("sorry-img");
                    img.onload=function(){
                        ctx.drawImage(img,-15,10);
                    };
                    ctx.drawImage(img,-15,10);
                }
                //把当前画布返回（调整）到上一个save()状态之前
                ctx.restore();
                //----绘制奖品结束----
            }
        }
    }

</script>
</body>
</html>
