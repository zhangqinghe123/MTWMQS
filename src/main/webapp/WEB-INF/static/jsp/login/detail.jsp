<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>

                账号管理
            </li>
        </ul><!-- .breadcrumb -->
    </div>

    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <!-- 内容开始 -->
                <form class="form-horizontal" role="form" id="adminForm" modelAttribute="form" >
                    <input name="id" value="${info.id}" type="hidden">

                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> 账号：</label>

                        <div class="col-sm-9">
                         <span> ${info.userName}</span>
                        </div>
                    </div>

                    <div class="space-4"></div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">  新密码：</label>

                        <div class="col-sm-9">
                            <input  type="password" name="password" id="password"  data-rule-required="true"  data-rule-maxlength="12"  />
                        </div>
                    </div>

                    <div class="space-4"></div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right"> 确定密码：</label>

                        <div class="col-sm-9">
                            <input type="password" name="rePassword" data-rule-equalTo="#password"  data-rule-required="true"  data-rule-maxlength="12" />
                        </div>
                    </div>

                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">
                            <a class="btn btn-info qz_save_btn" >
                                <i class="icon-ok bigger-110"></i>
                                <span>提交</span>
                            </a>

                        </div>
                    </div>
                </form>

                <!-- 内容介绍-->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>
<script>

    $(".qz_save_btn").click(function () {

        if($("#adminForm").valid()){
            $(".qz_save_btn").attr("disabled",true).find("span").html("提交中...");
            $.ajax({
                url : basePath + "admin/rewPass",
                data : $("#adminForm").serialize(),
                type : 'POST',
                success : function(data) {
                    if (data.errCode == 0) {
                        apus.ui.toastr.success("修改成功！");
                        window.setTimeout(function() {
                            location.href = basePath + "login"
                        }, 1500);
                    } else {
                        $(".qz_save_btn").attr("disabled",false).find("span").html("提交.");
                        apus.ui.toastr.error("修改失败，错误信息：" + data.message);
                    }
                },
                error: function(e) {
                    $(".qz_save_btn").attr("disabled",false).find("span").html("提交.");
                    apus.ui.toastr.error("保存失败");
                },
            });
        }
    });


</script>
</body>
</html>
