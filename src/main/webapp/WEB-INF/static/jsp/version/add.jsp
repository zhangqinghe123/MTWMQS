<%@ page contentType="text/html;charset=UTF-8" %>

<script type="text/javascript">
    $(function ($) {
        var isCheck = true;
        $(".qz_save_btn").click(function () {
            if (isCheck) {
                if ($("#versionForm").valid()) {
                    $(".qz_save_btn").attr("disabled", true).find("span").html("提交中...");
                    isCheck = false;
                    window.setTimeout(function () {
                        $.ajax({
                            url: basePath + "admin/version/doAdd",
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

        $("#uploadAppFile").uploadifive({
            //后台处理的页面
            'uploadScript': basePath + "admin/version/uploadAdInfo",
            //按钮显示的文字
            'buttonText': '选择上传的APP',
            //允许上传的文件后缀
            'fileType': '*.apk',
            //选择文件后自动上传
            'auto': true,
            //设置为true将允许多文件上传
            'multi': false,
            // 上传对象
            'fileObjName': 'uploadfile',
            'method': 'POST',
            'removeCompleted': true,
            // 浏览器检测不到兼容时触发该事件
            'onFallback': function () {
                apus.ui.toastr.error("您的浏览器不支持上传组件，请更换谷歌、Firefox等浏览器");
            },
            'onUploadComplete': function (file, data) {
                data = eval('(' + data + ')');
                if(data.status == 0) {
                    $("#downLoadUrl").val(data.data);
                } else {
                    apus.ui.toastr.error(data.message);
                }
            }
        });
    });
</script>
<div class="page-content">
    <div class="row">
        <div class="col-xs-12">
            <form class="form-horizontal" role="form" id="versionForm" modelAttribute="form"
                  enctype="multipart/form-data" method="post">
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本名称：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="versionName" data-rule-required="true"
                               placeholder="请输入版本名称"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本号：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="versionCode" data-rule-required="true"
                               placeholder="请输入版本号"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label"> 版本号Int值：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" name="codeInt" data-rule-required="true"
                               placeholder="请输入版本号Int值"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">版本说明 ：</label>
                    <div class="col-sm-7">
                        <textarea class="form-control" name="introduce" data-rule-required="true"
                                  placeholder="请输入版本说明"></textarea>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">上文路径 ：</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="downLoadUrl" name="downLoadUrl" data-rule-required="true" readonly="readonly" placeholder="上传文件后文件路径"/>
                    </div>
                </div>
                <div class="space-4"></div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">APP文件 ：</label>
                    <div class="col-sm-7">
                        <input type="file" name="uploadAppFile" id="uploadAppFile"/>
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
    $("#closeDialog").on("click", function () {
        var myDialog = window.dialogModal["my_customer_dialog"];
        myDialog.close();
    });
</script>