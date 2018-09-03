<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
$(function ($) {
    var isCheck = true;
    $(".qz_save_btn").click(function () {
        if(isCheck) {
        if($("#versionForm").valid()){ 
            $(".qz_save_btn").attr("disabled", true).find("span").html("提交中...");
            isCheck = false;
            window.setTimeout(function () {
                $.ajax({
                    url: basePath + "admin/version/doUpdate",
                    data: $("#versionForm").serialize(),
                    type: 'POST',
                    success: function (data) {
                        if (data.errCode == 0) {
                            apus.ui.toastr.success("保存成功！");
                            window.setTimeout(function () {
                                location.href = basePath + "admin/version"
                            }, 1500);
                        } else {
                            isCheck = true;
                            $(".qz_save_btn").attr("disabled", false).find("span").html("提交");
                            apus.ui.toastr.error(data.message);
                        }
                    },
                    error: function (e) {
                        isCheck = true;
                        $(".qz_save_btn").attr("disabled", false).find("span").html("提交");
                        apus.ui.toastr.error("保存失败，请联系管理员");
                    },
                });
              }, 10)
            }
        }
    });
});
</script>
<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" role="form" id="versionForm" modelAttribute="form">
            	<input type="hidden" name="versionId" value="${appVersion.versionId}">
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本名称：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="versionName" value="${appVersion.versionName}" data-rule-required="true" placeholder="请输入版本名称"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本号：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="versionCode" value="${appVersion.versionCode}" data-rule-required="true" placeholder="请输入版本号"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">MD5校验码 ：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="md5" value="${appVersion.md5}" data-rule-required="true" placeholder="请输入MD5校验码"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 终端类型：</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="terminal">
                            <option value="">请选择终端类型</option>
                            <option value="1" <c:if test="${appVersion.terminal eq 1}">selected="selected"</c:if>>用户端</option>
                            <option value="2" <c:if test="${appVersion.terminal eq 2}">selected="selected"</c:if>>司机端</option>
                        </select>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 更新类型：</label>
                    <div class="col-sm-7">
                        <select class="form-control" name="versionType">
                        	<option value="">请选择更新类型</option>
                            <option value="1" <c:if test="${appVersion.versionType eq 1}">selected="selected"</c:if>>非强制更新</option>
                            <option value="2" <c:if test="${appVersion.versionType eq 2}">selected="selected"</c:if>>强制更新</option>
                        </select>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">下载地址 ：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="downLoadUrl" value="${appVersion.downLoadUrl}" data-rule-required="true" placeholder="请输入下载地址"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">版本介绍：</label>
                    <div class="col-sm-7">
                        <textarea class="form-control" rows="4" name="introduce" placeholder="请输入版本介绍">${appVersion.introduce}</textarea>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">用途：</label>
                    <div class="col-sm-7">
                        <textarea class="form-control" rows="4" name="purpose" placeholder="请输入用途">${appVersion.purpose}</textarea>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group text-center">
                    <a class="btn btn-info qz_save_btn">
                        <i class="icon-ok bigger-110"></i>提交
                    </a>
                    &nbsp;
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