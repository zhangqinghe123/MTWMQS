<%@ page import="com.qianxx.qztaxi.webService.adminuser.BaseController" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
    request.setAttribute("_CURR_USER", request.getSession().getAttribute("name"));
    request.setAttribute("_CURR_RULE", request.getSession().getAttribute("rule"));
    request.setAttribute("_CURR_COMPANY", request.getSession().getAttribute("company"));
%>
<!DOCTYPE html>
<html>
<head>
    <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>山洪灾害监测预警移动查询系统</title>
    <!-- Libraries -->
    <script type="text/javascript">basePath = '${basePath}';rule = ${_CURR_RULE} </script>
    <link href="${basePath}resources/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${basePath}resources/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/ace.min.css" />
    <link rel="stylesheet" href="${basePath}resources/css/newCommon.css?v=1.3" />
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
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
						<span class="user-info">
							<small>欢迎光临,</small>
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
                        <li>
                            <a href="${basePath}admin/rewIndex">
                                <i class="icon-cog"></i> 修改密码
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
                <li <c:if test="${menu == null}">class="active"</c:if>>
                    <a href="${basePath}admin/index">
                        <i class="iconfont icon-home"></i>
                        <span class="menu-text"> 系统首页</span>
                    </a>
                </li>
                <li <c:if test="${menu == 'monitoring'}">class="active"</c:if>>
                    <a href="${basePath}admin/monitoring/index">
                        <i class="iconfont icon-monitor"></i>
                        <span class="menu-text"> 监控调度中心 </span>
                    </a>
                </li>
                <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                    <li <c:if test="${menu == 'orderStatusStatistics'|| menu == 'myIncome'||menu == 'dailyNewPassenger'||menu =='dailyActiveDriver'||menu =='dailyOrderIncome'}">class="active"</c:if>>
                         <a href="#" class="dropdown-toggle">
                             <i class="iconfont icon-monitor"></i>
                             <span class="menu-text">数据统计中心</span>
                             <b class="arrow icon-angle-down"></b>
                         </a>
                         <ul class="submenu">
                             <li <c:if test="${menu == 'dailyNewPassenger'}">class="active"</c:if>>
                                 <a href="${basePath}admin/statistics/dailyNewPassenger">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">每日新增乘客</span>
                                 </a>
                             </li>
                             <li <c:if test="${menu == 'dailyActiveDriver'}">class="active"</c:if>>
                                 <a href="${basePath}admin/statistics/dailyActiveDriver">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">每日活跃司机</span>
                                 </a>
                             </li>
                             <li <c:if test="${menu == 'dailyOrderIncome'}">class="active"</c:if>>
                                 <a href="${basePath}admin/statistics/dailyOrderIncome">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">每日订单收入</span>
                                 </a>
                             </li>
                             <li <c:if test="${menu == 'orderStatusStatistics'}">class="active"</c:if>>
                                 <a href="${basePath}admin/statistics/orderStatusStatistics">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">订单状态统计</span>
                                 </a>
                             </li>
                             <li <c:if test="${menu == 'myIncome'}">class="active"</c:if>>
                                 <a href="${basePath}admin/driver/myIncome">
                                     <i class="icon-double-angle-right"></i>
                                     <span class="menu-text">收入统计</span>
                                 </a>
                             </li>
                         </ul>
                    </li>
                    </c:if>
                    <c:if test="${_CURR_RULE == 3 or _CURR_RULE == 1 }">
                        <li  <c:if test="${menu == 'car'}">class="active"</c:if>>
                            <a href="#" class="dropdown-toggle">
                                <i class="iconfont icon-car"></i>
                                <span class="menu-text">车辆管理中心</span>
                                <b class="arrow icon-angle-down"></b>
                            </a>
                            <ul class="submenu">
                                <%--<li <c:if test="${menu1 == '1'}">class="active"</c:if>>--%>
                                    <%--<a href="${basePath}admin/driver/index?carType=1">--%>
                                        <%--<i class="icon-double-angle-right"></i>--%>
                                        <%--<span class="menu-text">出租车管理</span>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <%--<li <c:if test="${menu1 == '2'}">class="active"</c:if>>--%>
                                    <%--<a href="${basePath}admin/driver/index?carType=2">--%>
                                        <%--<i class="icon-double-angle-right"></i>--%>
                                        <%--<span class="menu-text">专车管理</span>--%>
                                    <%--</a>--%>
                                <%--</li>--%>
                                <li <c:if test="${menu1 == '3'}">class="active"</c:if>>
                                    <a href="${basePath}admin/driver/index?carType=3">
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">跨城拼车管理</span>
                                    </a>
                                </li>
                                <li <c:if test="${menu1 == '4'}">class="active"</c:if>>
                                    <a href="${basePath}admin/message/driverindex" >
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">司机通知管理 </span>
                                    </a>
                                </li>
                                <li <c:if test="${menu1 == '5'}">class="active"</c:if>>
                                    <a href="${basePath}admin/complaint/index" >
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">投诉管理 </span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                        <li <c:if test="${menu == 'passenger'}">class="active"</c:if>>
                           <%-- <a href="${basePath}admin/passenger/index">
                                <i class="iconfont icon-server"></i>
                                <span class="menu-text"> 乘客信息管理 </span>
                            </a>--%>
                            <a href="#" class="dropdown-toggle">
                                <i class="iconfont icon-server"></i>
                                <span class="menu-text"> 乘客服务中心 </span>
                                <b class="arrow icon-angle-down"></b>
                            </a>
                            <ul class="submenu">
                                <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                                    <a href="${basePath}admin/passenger/index">
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">乘客信息管理</span>
                                    </a>
                                </li>
                                <li <c:if test="${menu1 == '2'}">class="active"</c:if>>
                                    <a href="${basePath}admin/message/index">
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">乘客通知管理</span>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </c:if>

                    <li <c:if test="${menu == 'order'}">class="active"</c:if>>
                        <a href="#" class="dropdown-toggle">
                            <i class="iconfont icon-order"></i>
                            <span class="menu-text"> 订单处理中心 </span>
                            <b class="arrow icon-angle-down"></b>
                        </a>
                        <ul class="submenu">
                            <%--<li <c:if test="${menu1 == '1'}">class="active"</c:if>>--%>
                                <%--<a href="${basePath}admin/order/index?orderType=1">--%>
                                    <%--<i class="icon-double-angle-right"></i>--%>
                                    <%--<span class="menu-text">出租车订单</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <%--<li <c:if test="${menu1 == '2'}">class="active"</c:if>>--%>
                                <%--<a href="${basePath}admin/order/index?orderType=2">--%>
                                    <%--<i class="icon-double-angle-right"></i>--%>
                                    <%--<span class="menu-text">专车订单</span>--%>
                                <%--</a>--%>
                            <%--</li>--%>
                            <li <c:if test="${menu1 == '3'}">class="active"</c:if>>
                                <a href="${basePath}admin/order/index?orderType=3">
                                    <i class="icon-double-angle-right"></i>
                                    <span class="menu-text">跨城拼车订单</span>
                                </a>
                            </li>
                            <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                                <a href="${basePath}admin/order/index?orderType=1">
                                    <i class="icon-double-angle-right"></i>
                                    <span class="menu-text">出租车订单</span>
                                </a>
                            </li>
                            <li <c:if test="${menu1 == '2'}">class="active"</c:if>>
                                <a href="${basePath}admin/order/index?orderType=2">
                                    <i class="icon-double-angle-right"></i>
                                    <span class="menu-text">专车订单</span>
                                </a>
                            </li>
                            <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                                <li <c:if test="${menu1 == '4'}">class="active"</c:if>>
                                    <a href="${basePath}admin/order/call">
                                        <i class="icon-double-angle-right"></i>
                                        <span class="menu-text">电话叫车</span>
                                    </a>
                                </li>
                                <li <c:if test="${menu1 == '5'}">class="active"</c:if>>
                                    <a href="${basePath}admin/mstComment/detail">
                                        <i class="icon-text-width"></i>
                                        <span class="menu-text"> 评价标签管理 </span>
                                    </a>
                                </li>
                            </c:if>
                        </ul>
                    </li>
                <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1 }">
                <li <c:if test="${menu == 'cash'}">class="active"</c:if>>
                    <a href="#" class="dropdown-toggle">
                        <i class=" icon-list"></i>
                        <span class="menu-text"> 财务管理中心 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                        <a href="${basePath}admin/cash/index">
                        <i class="icon-double-angle-right"></i>
                        <span class="menu-text">提现审核管理</span>
                        </a>
                        </li>
                    </ul>
                </li>
               </c:if>
                <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                    <li <c:if test="${menu == 'marketing'}">class="active"</c:if>>
                        <a href="#" class="dropdown-toggle">
                            <i class="iconfont icon-center"></i>
                            <span class="menu-text"> 营销活动中心 </span>
                            <b class="arrow icon-angle-down"></b>
                        </a>
                        <ul class="submenu">
                            <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                            <a href="${basePath}admin/coupon/index">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">优惠券管理</span>
                            </a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <li <c:if test="${menu == 'message'}">class="active"</c:if>>
                    <a href="#" class="dropdown-toggle">
                        <i class="iconfont icon-message"></i>
                        <span class="menu-text"> 信息发布中心 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                            <a href="${basePath}admin/lostArticle/found">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">招领管理</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '2'}">class="active"</c:if>>
                            <a href="${basePath}admin/lostArticle/index">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">失物管理</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '3'}">class="active"</c:if>>
                            <a href="${basePath}admin/article/index">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">文章管理</span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu1 == '4'}">class="active"</c:if>>
                                <a href="${basePath}admin/feedback/index">
                                    <i class="icon-double-angle-right"></i>
                                    <span class="menu-text">反馈管理</span>
                                </a>
                            </li>
                            <li <c:if test="${menu1 == '5'}">class="active"</c:if>>
                                <a href="${basePath}admin/help/index">
                                    <i class="icon-text-width"></i>
                                    <span class="menu-text"> 帮助文档管理</span>
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </li>
                <li <c:if test="${menu == 'companyInfo'}">class="active"</c:if>>
                    <a href="#" class="dropdown-toggle">
                        <i class="iconfont icon-message"></i>
                        <span class="menu-text"> 网约车信息维护 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/company">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车基本信息</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '2'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/companystat">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车运营规模信息</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '3'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/companypay">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车支付信息</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '4'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/companyservice">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车服务机构信息</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '5'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/companypermit">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车经营许可信息</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '6'}">class="active"</c:if>>
                            <a href="${basePath}admin/shCompany/companyfare">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">网约车运价信息</span>
                            </a>
                        </li>
                    </ul>
                </li>
                <li <c:if test="${menu == 'role'}">class="active"</c:if>>
                    <a href="#" class="dropdown-toggle">
                        <i class="iconfont icon-message"></i>
                        <span class="menu-text"> 权限管理 </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li <c:if test="${menu1 == '1'}">class="active"</c:if>>
                            <a href="${basePath}admin/roleResouce/list">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">菜单管理</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '2'}">class="active"</c:if>>
                            <a href="${basePath}admin/roleGroup/list">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">角色管理</span>
                            </a>
                        </li>
                        <li <c:if test="${menu1 == '3'}">class="active"</c:if>>
                            <a href="${basePath}admin/adminuser/list">
                                <i class="icon-double-angle-right"></i>
                                <span class="menu-text">人员管理</span>
                            </a>
                        </li>
                    </ul>
                </li>
             <%--   <li <c:if test="${menu == 'myInfo'}">class="active"</c:if>>
                    <a href="${basePath}admin/rewIndex">
                        <i class="icon-edit"></i>
                        <span class="menu-text"> 账号管理 </span>
                    </a>
                </li>--%>
                     <%--   <c:if test="${_CURR_RULE == 3}">
                            <li <c:if test="${menu == 'company'}">class="active"</c:if>>
                                <a href="${basePath}admin/company/detail">
                                    <i class="icon-text-width"></i>
                                    <span class="menu-text"> 企业信息管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <li  <c:if test="${menu == 'driver'}">class="active"</c:if>>
                            <a href="${basePath}admin/driver/index" >
                                <i class="icon-desktop"></i>
                                <span class="menu-text">司机信息管理 </span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 3}">
                            <li  <c:if test="${menu == 'car'}">class="active"</c:if>>
                                <a href="${basePath}admin/car/index">
                                    <i class="iconfont icon-car"></i>
                                    <span class="menu-text">车辆管理中心 </span>
                            </a>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 2 || _CURR_RULE == 4 || _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'car'}">class="active"</c:if>>
                                <a href="#" class="dropdown-toggle">
                                    <i class="icon-edit"></i>
                                    <span class="menu-text"> 车辆信息管理 </span>
                                    <b class="arrow icon-angle-down"></b>
                                </a>
                                <ul class="submenu">
                                    <c:forEach items="${_CURR_COMPANY}" var="z" varStatus="s">
                                        <li <c:if test="${companyId == z.id}">class="active"</c:if>>
                                            <a href="${basePath}admin/car/index?companyId=${z.id}">
                                                <i class="icon-double-angle-right"></i>${z.name}
                                            </a>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                        <li <c:if test="${menu == 'passenger'}">class="active"</c:if>>
                            <a href="${basePath}admin/passenger/index">
                                <i class="icon-dashboard"></i>
                                <span class="menu-text"> 乘客信息管理 </span>
                            </a>
                        </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'coupon'}">class="active"</c:if>>
                                <a href="${basePath}admin/coupon/index" >
                                    <i class="icon-list"></i>
                                    <span class="menu-text">优惠券管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 3 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'complaint'}">class="active"</c:if>>
                                <a href="${basePath}admin/complaint/index" >
                                    <i class="icon-list"></i>
                                    <span class="menu-text">投诉管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <li <c:if test="${menu == 'order'}">class="active"</c:if>>
                            <a href="${basePath}admin/order/index" >
                                <i class="iconfont icon-order"></i>
                                <span class="menu-text"> 订单处理中心 </span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 5 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'orderCall'}">class="active"</c:if>>
                                <a href="${basePath}admin/order/call">
                                    <i class="icon-list-alt"></i>
                                    <span class="menu-text"> 电话叫车 </span>
                                </a>
                            </li>
                        </c:if>
                        <li <c:if test="${menu == 'lostArticle'}">class="active"</c:if>>
                            <a href="${basePath}admin/lostArticle/index">
                                <i class="icon-calendar"></i>
                                <span class="menu-text">失物管理</span>
                            </a>
                        </li>
                        <li  <c:if test="${menu == 'found'}">class="active"</c:if>>
                            <a href="${basePath}admin/lostArticle/found">
                                <i class="icon-picture"></i>
                                <span class="menu-text"> 招领管理 </span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'feedback'}">class="active"</c:if>>
                                <a href="${basePath}admin/feedback/index">
                                    <i class="icon-tag"></i>
                                    <span class="menu-text"> 反馈管理</span>
                                </a>
                            </li>
                        </c:if>
                        <li <c:if test="${menu == 'notice'}">class="active"</c:if>>
                            <a href="${basePath}admin/message/driverindex" >
                                <i class="icon-edit"></i>
                                <span class="menu-text">系统通知管理 </span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                     	<li <c:if test="${menu == 'comment'}">class="active"</c:if>>
                            <a href="${basePath}admin/mstComment/detail">
                                <i class="icon-text-width"></i>
                                <span class="menu-text"> 评价标签管理 </span>
                            </a>
                        </li>
                        </c:if>
                       	<li <c:if test="${menu == 'article'}">class="active"</c:if>>
                            <a href="${basePath}admin/article/index" >
                                <i class="icon-edit"></i>
                                <span class="menu-text">文章管理 </span>
                            </a>
                        </li>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'message'}">class="active"</c:if>>
                                <a href="${basePath}admin/message/index">
                                    <i class="icon-dashboard"></i>
                                    <span class="menu-text"> 乘客活动管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'cash'}">class="active"</c:if>>
                                <a href="${basePath}admin/cash/index" >
                                    <i class="icon-list"></i>
                                    <span class="menu-text">提现审核管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE == 2 or _CURR_RULE == 1}">
                            <li <c:if test="${menu == 'help'}">class="active"</c:if>>
                                <a href="${basePath}admin/help/index" >
                                    <i class="icon-edit"></i>
                                    <span class="menu-text">帮助文档管理 </span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${_CURR_RULE != 3 }">
                            <li <c:if test="${menu == 'companyList'}">class="active"</c:if>>
                                <a href="${basePath}admin/company/index">
                                    <i class="icon-text-width"></i>
                                    <span class="menu-text"> 企业管理 </span>
                                </a>
                            </li>
                        </c:if>
                <li <c:if test="${menu == 'myInfo'}">class="active"</c:if>>
                    <a href="${basePath}admin/rewIndex">
                        <i class="icon-edit"></i>
                        <span class="menu-text"> 账号管理 </span>
                    </a>
                </li>
                <c:if test="${_CURR_RULE == 5 or _CURR_RULE == 6}">
                 <li> <span style="color: red;display: block;padding-left: 12px">遇用户投诉司机：1. 请按车牌号或手机号查询订单，提供订单详情内的出租车公司号码 2. 或直接在企业管理查询各公司投诉电话 3. 查不到订单或公司时，请提供提供交通执法支队：22599110</span></li>
               </c:if>--%>
            </ul><!-- /.nav-list -->
            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>