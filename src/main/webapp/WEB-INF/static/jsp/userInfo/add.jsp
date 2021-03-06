<%@ page contentType="text/html;charset=UTF-8"%>
<script type="text/javascript">
$(function ($) {
    var isCheck = true;
    $(".qz_save_btn").click(function () {
        if(isCheck) {
        if($("#versionForm").valid()) { 
            $(".qz_save_btn").attr("disabled", true).find("span").html("提交中...");
            isCheck = false;
            window.setTimeout(function () {
                $.ajax({
                    url: basePath + "admin/userInfo/doAdd",
                    data: $("#versionForm").serialize(),
                    type: 'POST',
                    success: function (data) {
                        if (data.errCode == 0) {
                            apus.ui.toastr.success("保存成功！");
                            window.setTimeout(function () {
                                location.href = basePath + "admin/userInfo"
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
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 姓名：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="userName" data-rule-required="true" placeholder="请输入姓名"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 职位：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="userPosition" data-rule-required="true" placeholder="请输入职位"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 手机号：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="mobile" data-rule-required="true" placeholder="请输入手机号"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 用户名：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="account" data-rule-required="true" placeholder="请输入用户名"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 密码：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="password" data-rule-required="true" placeholder="请输入密码"/>
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