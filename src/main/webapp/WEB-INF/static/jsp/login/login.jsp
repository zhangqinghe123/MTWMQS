<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    pageContext.setAttribute("basePath", basePath);
%>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>山洪灾害监测预警移动查询系统后台登陆界面</title>
    <script type="text/javascript">basePath = '${basePath}';</script>
    <link href="${basePath}resources/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${basePath}resources/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/validate.bootstrap.css" />
    <link rel="stylesheet" href="${basePath}resources/css/login.css" />
    <!--[if !IE]> -->
    <script src="${basePath}resources/js/jquery-2.0.3.min.js"></script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script src="${basePath}resources/ie8/jquery-1.10.2.min.js"></script>
    <![endif]-->
    <!--[if !IE]> -->
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${basePath}resources/ie8/jquery-1.10.2.min.js'>"+"<"+"script>");
    </script>
    <!-- <![endif]-->
    <!--[if IE]>
    <script type="text/javascript">
        window.jQuery || document.write("<script src='${basePath}resources/js/jquery-2.0.3.min.js'>"+"<"+"script>");
    </script>
    <![endif]-->
    <script src="${basePath}resources/js/bootstrap.min.js"></script>
    <script src="${basePath}resources/js/ace-elements.min.js"></script>
    <script src="${basePath}resources/js/ace.min.js"></script>
    <script src="${basePath}resources/js/jquery.validate.min.js"></script>
    <script src="${basePath}resources/js/validate.bootstrap.js"></script>
    <script src="${basePath}resources/js/common.js"></script>
    <!-- 提示 -->
    <link rel="stylesheet" href="${basePath}resources/css/apus.ui.toastr.css"/>
    <script src="${basePath}resources/js/apus.ui.toastr.js"></script>
</head>
<body class="login-page">
    <div class="login-content">
        <div class="full-width m-top">
            <div class="login-title">
                <img class="logobg" src="${basePath}resources/css/images/loginTitleNew.png"/>
            </div>
            <div class="logo-page">
                <div class="logo-area">
                    <img class="logobg" src="${basePath}resources/css/images/logoDown.jpg"/>
                    <form class="form-horizontal" role="form" id="LoginForm">
                        <p class="title">用户登录</p>
                        <div class="logo-unit">
                            <i class="iconfont icon-user"></i>
                            <input type="text" name="username" data-rule-required="true" placeholder="请输入用户名" autocomplete="off"/>
                        </div>
                        <div class="logo-unit">
                            <i class="iconfont icon-password"></i>
                            <input type="password" name="password" data-rule-required="true" placeholder="请输入密码" autocomplete="off"/>
                        </div>
                        <div class="form-group">
                        	<div class="col-sm-6">
					        	<img src="${basePath}login/code" alt="点击换一张" title="看不清楚，换一张" style="cursor:pointer;width: 130px;height: 45px;" onclick="this.src='${basePath}login/code?t='+Math.random();">
                        	</div>
                        	<div class="col-sm-6">
					        	<input type="text" name="code" data-rule-required="true" class="form-control input-lg" placeholder="请输入验证码" autocomplete="off"/>
                        	</div>
                        </div>
                        <div class="logo-uint">
                        	<button type="button" class="btn btn-info" id="login">登录</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    $(function() {
        if($("#rightContent").length > 0) {
            window.location.reload();
        }
        if(window.parent != window) {
            window.parent.location = window.location;
        }
        $(document).keyup(function(event) {
            if(event.keyCode == 13) {
                login();
            }
        });
        $("#login").click(function() {
            login();
        });
        function login() {
            if($("#LoginForm").valid()) {
                $("#login").find("span").html("登录中...").attr("disabled", true);
                $.ajax({
                    url: basePath + "login/ajaxLogin",
                    type: "POST",
                    data: {
                        username: $("input[name='username']").val(),
                        password: $("input[name='password']").val(),
                        code: $("input[name='code']").val()
                    },
                    success: function(data) {
                        if (data.errCode != 0) {
                            apus.ui.toastr.error( data.message);
                            $("#login").find("span").html("登录").attr("disabled", false);
                            return;
                        } else {
                            window.location.href = basePath + "admin/index";
                        }
                    }
                });
            }
        }
        var topHeight = ($(window).height() - 490) * 0.5;
        $(".login-content").css('padding-top', topHeight);
    });
</script>
</body>
</html>