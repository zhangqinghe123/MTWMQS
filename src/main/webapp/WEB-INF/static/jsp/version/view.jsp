<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" role="form" id="versionForm" modelAttribute="form">
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本名称：</label>
                    <div class="col-sm-7 no-padding-top">${appVersion.versionName}</div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本号：</label>
                    <div class="col-sm-7">${appVersion.versionCode}</div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 终端类型：</label>
                    <div class="col-sm-7">
	                    <c:if test="${appVersion.terminal eq 1}">用户端</c:if>
	                    <c:if test="${appVersion.terminal eq 2}">司机端</c:if>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 更新类型：</label>
                    <div class="col-sm-7">
                    	<c:if test="${appVersion.versionType eq 1}">非强制更新</c:if>
                      	<c:if test="${appVersion.versionType eq 2}">强制更新</c:if>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">下载地址 ：</label>
                    <div class="col-sm-8">${appVersion.downLoadUrl}</div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">状态 ：</label>
                    <div class="col-sm-7">
                     	<c:if test="${appVersion.state eq 1}">启用</c:if>
                     	<c:if test="${appVersion.state eq 2}">禁用</c:if>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">创建时间 ：</label>
                    <div class="col-sm-7"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${appVersion.ctime}"/></div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">版本介绍 ：</label>
                    <div class="col-sm-7">${appVersion.introduce}</div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">用途：</label>
                    <div class="col-sm-7">${appVersion.purpose}</div>
                </div>
                <div class="space-4"></div>
                <div class="form-group text-center">
                    <a class="btn" id="closeDialog">
                    	<i class="icon-undo bigger-110"></i>关闭
                    </a>
                </div>
        	</form>
        </div>
    </div>
</div>
<script type="text/javascript">
$("#closeDialog").on("click",function(){
    var myDialog = window.dialogModal["my_customer_dialog"];
    myDialog.close();
});
</script>