<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<script type="text/javascript">
$(function ($) {
    var url = basePath + '/admin/version/getVersionList';
    var table = apus.ui.dataTables('#qz_version_table', {
        'ajax': {
            'url': url,
            'type': "POST",
            'data': function ( d ) {
                d.terminal = $("select[name='terminal'] option:selected").val();
            },
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
                "width": '150',
                "title": '版本号',
            },
            {
                "data": "md5",
                "width": '350',
                "title": 'md5校验码',
            },
            {
                "data": "terminal",
                "width": '100',
                "title": '终端',
                "render": function (data, type, row) {
                    var str = "";
                    switch (parseInt(row["terminal"])) {
                        case 1:
                            str = "用户端";
                            break
                        case 2:
                            str = "司机端";
                            break
                    }
                    return str;
                }
            },
            {
                "data": "versionType",
                "title": '更新类型',
                "width": '100',
                "render": function (data, type, row) {
                    var str = "";
                    switch (parseInt(row["versionType"])) {
                        case 1:
                            str = "非强制";
                            break
                        case 2:
                            str = "强制";
                            break
                    }
                    return str;
                }
            },
            {
                "data": "state",
                "title": '状态',
                "width": '100',
                "render": function (data, type, row) {
                    var str = "";
                    switch (parseInt(row["state"])) {
                        case 1:
                            str = "启用";
                            break
                        case 2:
                            str = "禁用";
                            break
                    }
                    return str;
                }
            },
            {
                "data": "ctime",
                "title": '创建时间',
                "width": '250',
                "render": function (data, type, row) {
                    return sysCfg.formatter.fDateTime(row["ctime"]);
                }
            },
            {
                "title": '操作',
                "width": '150',
                "render": function (data, type, row) {
                    var str = '';
                    str += '<a id="getDetail" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">查看</a>';
                    if(row["state"] == "2") {
                        str += '<a id="update" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">编辑</a>';
                        str += '<a id="state_on" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">启用</a>';
	                    str += '<a id="delete" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">删除</a>';
                    } else {
                        str += '<a id="state_off" data-id="' + row["versionId"] + '" class="btn btn-info btn-xs" style="margin-right: 5px;">禁用</a>';
                    }
                    return str;
                }
            }
        ],
        initComplete: function () {
            $("#qz_version_table_wrapper").on('click', '#getDetail', function () {
                var id = $(this).attr("data-id");
                dialog.openUrlModal(
                    "查看版本信息",
                    basePath + "admin/version/view?versionId=" + id,
                    { width: 750, height: 680, id: "my_customer_dialog", ajaxOption: { type: "get" } }
                );
            });
            $("#qz_version_table_wrapper").on('click', '#state_on', function () {
            	var id = $(this).attr("data-id");
            	dialog.confirm(
                    "确认启用所选版本吗？",
                    function(){
                    	$.ajax({
                            url: basePath + "admin/version/doUpdateState",
                            data: {versionId: id},
                            type: 'POST',
                            success: function (data) {
                                if (data.errCode == 0) {
                                    apus.ui.toastr.success(data.message);
                                    var load =  sysCfg.loading(true);
                                    table.ajax.reload();
                                    setTimeout(function() {
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
            $("#qz_version_table_wrapper").on('click', '#state_off', function () {
            	var id = $(this).attr("data-id");
            	dialog.confirm(
                    "确认禁用所选版本吗？",
                    function(){
                    	$.ajax({
                            url: basePath + "admin/version/doUpdateState",
                            data: {versionId: id},
                            type: 'POST',
                            success: function (data) {
                                if (data.errCode == 0) {
                                    apus.ui.toastr.success(data.message);
                                    var load =  sysCfg.loading(true);
                                    table.ajax.reload();
                                    setTimeout(function() {
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
            $("#qz_version_table_wrapper").on('click', '#delete', function () {
            	var id = $(this).attr("data-id");
            	dialog.confirm(
                    "确认删除所选版本吗？",
                    function(){
                    	$.ajax({
                            url: basePath + "admin/version/doDelete",
                            data: {versionId: id},
                            type: 'POST',
                            success: function (data) {
                                if (data.errCode == 0) {
                                    apus.ui.toastr.success(data.message);
                                    var load =  sysCfg.loading(true);
                                    table.ajax.reload();
                                    setTimeout(function() {
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
            $("#qz_version_table_wrapper").on('click', '#update', function () {
                var id = $(this).attr("data-id");
                dialog.openUrlModal(
                    "编辑版本信息",
                    basePath + "admin/version/update?versionId=" + id,
                    { width: 750, height: 680, id: "my_customer_dialog", ajaxOption: { type: "get" } }
                );
            });
            //搜索
            $(".query_btn").on('click',  function () {
                if($("#selectForm").valid()) {
                    var load =  sysCfg.loading(true);
                    table.ajax.reload();
                    setTimeout(function() {
                        load.stop();
                    }, 500)
                }
            });
            $(".add_btn").on('click',  function () {
            	dialog.openUrlModal(
                    "新增版本信息",
                    basePath + "admin/version/add",
                    { width: 750, height: 680, id: "my_customer_dialog", ajaxOption: { type: "get" } }
                );
            });
        }
    });
});
</script>
<div class="main-content">
    <div class="appversion" id="appversion">
        <script type="text/javascript">
            try{ace.settings.check('appversion', 'fixed')}catch(e){}
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
	                                             终端：<select name="terminal">
	                                <option value="">全部</option>
	                                <option value="1">用户端</option>
	                                <option value="2">司机端</option>
	                            </select>
                                <span class="btn btn-primary btn-sm query_btn">搜索</span>
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
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>