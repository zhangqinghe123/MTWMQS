<%@ page import="com.qianxx.qztaxi.webService.adminuser.BaseController" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
    request.setAttribute("_CURR_USER", request.getSession().getAttribute("name"));
    request.setAttribute("_CURR_RULE", request.getSession().getAttribute("rule"));
    request.setAttribute("_ROLE_RESOUCES", request.getSession().getAttribute("roleResouces"));
%>
<!DOCTYPE html>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>鼎骏出行系统</title>
    <!-- Libraries -->
    <script type="text/javascript">basePath = '${basePath}'</script>
    <link href="${basePath}resources/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${basePath}resources/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/newCommon.css?v=1.4" />
    <link rel="stylesheet" href="${basePath}resources/css/validate.bootstrap.css" />
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${basePath}resources/ie8/ace-ie.min.css" />
    <![endif]-->

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
    <script src="${basePath}resources/js/ace-extra.min.js"></script>
    <script src="${basePath}resources/js/jquery.validate.min.js"></script>
    <script src="${basePath}resources/js/validate.bootstrap.js"></script>
    <script src="${basePath}resources/js/common.js"></script>
    <script src="${basePath}resources/js/My97DatePicker/WdatePicker.js"></script>
    <!-- 表格 -->
    <link rel="stylesheet" href="${basePath}resources/js/datatables/css/jquery.dataTables.css">
    <script src="${basePath}resources/js/datatables/jquery.dataTables.js"></script>
    <script src="${basePath}resources/js/datatables/apus.ui.dataTables.js"></script>
    <!-- 提示 -->
    <link rel="stylesheet" href="${basePath}resources/css/apus.ui.toastr.css"/>
    <script src="${basePath}resources/js/apus.ui.toastr.js"></script>

    <!--弹出框 -->
    <link rel="stylesheet" href="${basePath}resources/js/artDialog/css/ui-dialog.css"/>
    <script src="${basePath}resources/js/artDialog/dialog-plus.js"></script>
    <script src="${basePath}resources/js/artDialog/dialog-customer.js"></script>

    <!--maskLlock 全屏锁屏-->
    <link rel="stylesheet" href="${basePath}resources/js/loading/loading.css"/>
    <script src="${basePath}resources/js/loading/loading.js"></script>

    <!--maskLlock 全屏锁屏-->
    <link rel="stylesheet" href="${basePath}resources/js/uploadify/uploadifive.css"/>
    <script src="${basePath}resources/js/uploadify/jquery.uploadifive.min.js"></script>
</head>
<body>
<div class="navbar navbar-default" id="navbar" style="height: 10px;">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>
    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
               <img src="${basePath}resources/css/images/logo.png"/><span>.信息服务管理系统</span>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->
        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close" style="min-width:100px; padding:5px 10px;">
                    	<div id="remindMsgDetail" style="line-height:24px;"></div>
                    </ul>
                </li>
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<span class="user-info">
							<small>欢迎光临</small>
						    <span id="userName">${_CURR_USER}</span>
						</span>
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="${basePath}login">
                                <i class="icon-off"></i>退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>
            <ul class="nav nav-list">
            	<c:forEach items="${_ROLE_RESOUCES}" var="roleResouce">
            		<li <c:if test="${menu == roleResouce.menuFlag}">class="active"</c:if>>
						<a <c:if test="${fn:length(roleResouce.sons)>0}">class="dropdown-toggle"</c:if><c:if test="${roleResouce.actionLink==''}">href="#" </c:if><c:if test="${roleResouce.actionLink!=''}">href="${basePath}${roleResouce.actionLink}"</c:if>>
							<i class="iconfont ${roleResouce.iconClass}"></i>
							<span class="menu-text">${roleResouce.name}</span>
							<c:if test="${fn:length(roleResouce.sons)>0}"><b class="arrow icon-angle-down"></b></c:if>
						</a>
						<ul class="submenu">
							<c:forEach items="${roleResouce.sons}" var="sonRoleResouce">
								<li <c:if test="${menu1 == sonRoleResouce.menuFlag}">class="active"</c:if>>
                                 <a href="${basePath}${sonRoleResouce.actionLink}">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">${sonRoleResouce.name}</span>
                                 </a>
                            	</li>
							</c:forEach>
						</ul>
					</li>
            	</c:forEach>
            </ul><!-- /.nav-list -->
            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>
    </div>
</div>