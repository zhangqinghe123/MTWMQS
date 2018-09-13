<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript">
    $(function ($) {
        var url = basePath + 'admin/userInfo/getUserInfoList';
        var table = apus.ui.dataTables('#qz_userinfo_table', {
            'ajax': {
                'url': url,
                'type': "POST",
                'data': function (d) {
                    d.mobile = $("input[name='mobile']").val();
                },
            },
            'searching': false,
            "columns": [
                {
                    "data": "id",
                    "title": 'ID',
                },
                {
                    "data": "account",
                    "title": '账号',
                },
                {
                    "data": "password",
                    "title": '密码',
                },
                {
                    "data": "mobile",
                    "title": '手机号',
                },
                {
                    "data": "userName",
                    "title": '用户名',
                },
                {
                    "data": "userPosition",
                    "title": '职位',
                },
                {
                    "title": '操作',
                    "render": function (data, type, row) {
                        var str = '<a id="update" data-id="' + row["id"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">编辑</a>';
                        str += '<a id="delete" data-id="' + row["id"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">删除</a>';
                        return str;
                    }
                }
            ],
            initComplete: function () {
                $("#qz_userinfo_table_wrapper").on('click', '#delete', function () {
                    var id = $(this).attr("data-id");
                    dialog.confirm(
                        "确认删除所选版本吗？",
                        function () {
                            $.ajax({
                                url: basePath + "admin/version/doDelete",
                                data: {versionId: id},
                                type: 'POST',
                                success: function (data) {
                                    if (data.errCode == 0) {
                                        apus.ui.toastr.success(data.message);
                                        var load = sysCfg.loading(true);
                                        table.ajax.reload();
                                        setTimeout(function () {
                                            load.stop();
                                        }, 500)
                                    } else {
                                        apus.ui.toastr.error(data.message);
                                    }
                                },
                                error: function (e) {
                                    apus.ui.toastr.error("保存失败，请联系管理员");

                                },
                            });
                        },
                        null
                    );
                });
                $("#qz_userinfo_table_wrapper").on('click', '#update', function () {
                    var id = $(this).attr("data-id");
                    dialog.openUrlModal(
                        "编辑版本信息",
                        basePath + "admin/version/update?versionId=" + id,
                        {width: 750, height: 680, id: "my_customer_dialog", ajaxOption: {type: "get"}}
                    );
                });
                //搜索
                $(".query_btn").on('click', function () {
                    if ($("#selectForm").valid()) {
                        var load = sysCfg.loading(true);
                        table.ajax.reload();
                        setTimeout(function () {
                            load.stop();
                        }, 500)
                    }
                });
                $(".add_btn").on('click', function () {
                    dialog.openUrlModal(
                        "新增版本信息",
                        basePath + "admin/version/add",
                        {width: 750, height: 680, id: "my_customer_dialog", ajaxOption: {type: "get"}}
                    );
                });
            }
        });
    });
</script>
<div class="main-content">
    <div class="appversion" id="appversion">
        <ul class="breadcrumb">
            <li>用户管理</li>
            <li class="active">用户管理</li>
        </ul>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="tab-pane">
                    <form class="form-horizontal" role="form" id="selectForm" modelAttribute="form">
                        <div class="control-group">
                            <div class="input-control">
                                <span>手机号码: <input type="text" name="mobile" data-rule-digits="ture"
                                                   data-rule-maxlength="11" placeholder="请输入手机号码"/></span>
                                <span class="btn btn-primary btn-sm query_btn">搜索</span>
                                <span class="btn btn-primary btn-sm add_btn">新增</span>
                            </div>
                        </div>
                    </form>
                    <table id="qz_userinfo_table" class="table table-bordered"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>