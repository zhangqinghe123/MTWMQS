<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript">
    $(function ($) {
        var url = basePath + '/admin/version/getVersionList';
        var table = apus.ui.dataTables('#qz_version_table', {
            'ajax': {
                'url': url,
                'type': "POST",
            },
            'searching': false,
            "columns": [
                {
                    "data": "versionName",
                    "width": '200',
                    "title": '版本名称',
                },
                {
                    "data": "versionCode",
                    "width": '100',
                    "title": '版本号',
                },
                {
                    "data": "codeInt",
                    "width": '100',
                    "title": '版本号Int值',
                },
                {
                    "data": "createTime",
                    "title": '发布日期',
                    "width": '150',
                    "render": function (data, type, row) {
                        return sysCfg.formatter.fDateTime(row["createTime"]);
                    }
                },
                {
                    "data": "introduce",
                    "width": '350',
                    "title": '版本说明',
                },
                {
                    "title": '操作',
                    "width": '150',
                    "render": function (data, type, row) {
                        var str = '';
                        str += '<a id="downloadApp" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">下载</a>';
                        str += '<a id="delete" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">删除</a>';
                        return str;
                    }
                }
            ],
            initComplete: function () {
                $("#qz_version_table_wrapper").on('click', '#delete', function () {
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
                $("#qz_version_table_wrapper").on('click', '#download', function () {
                    var id = $(this).attr("data-id");
                    dialog.openUrlModal(
                        "编辑版本信息",
                        basePath + "admin/version/update?versionId=" + id,
                        {width: 750, height: 680, id: "my_customer_dialog", ajaxOption: {type: "get"}}
                    );
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
        <script type="text/javascript">
            try {
                ace.settings.check('appversion', 'fixed')
            } catch (e) {
            }
        </script>
        <ul class="breadcrumb">
            <li>APP更新</li>
            <li class="active">APP更新</li>
        </ul>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <div class="tab-pane">
                    <form class="form-horizontal" role="form" id="selectForm" modelAttribute="form">
                        <div class="control-group">
                            <div class="input-control">
                                <span class="btn btn-primary btn-sm add_btn">新增</span>
                            </div>
                        </div>
                    </form>
                    <table id="qz_version_table" class="table table-bordered"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>