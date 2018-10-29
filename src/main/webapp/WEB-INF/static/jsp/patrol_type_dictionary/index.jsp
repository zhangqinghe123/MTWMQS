<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sA85emPOmdhtikFDCmEq1uRaWV2qI5F5"></script>
<script type="text/javascript">
    $(function ($) {
        var url = basePath + 'admin/patrolTypeDictionary/getDictionaryList';
        var table = apus.ui.dataTables('#qz_userinfo_table', {
            'ajax': {
                'url': url,
                'type': "POST"
            },
            'searching': false,
            "columns": [
                {
                    "data": "id",
                    "width": '50',
                    "title": 'ID',
                },
                {
                    "data": "name",
                    "width": '200',
                    "title": '类型名称',
                },
                {
                    "title": '操作',
                    "width": '300',
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
                        "确认删除所选类型吗？",
                        function () {
                            $.ajax({
                                url: basePath + "admin/patrolTypeDictionary/doDelete",
                                data: {id: id},
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
                                    apus.ui.toastr.error("删除失败，请联系管理员");

                                },
                            });
                        },
                        null
                    );
                });
                $("#qz_userinfo_table_wrapper").on('click', '#update', function () {
                    var id = $(this).attr("data-id");
                    dialog.openUrlModal(
                        "编辑巡查类型",
                        basePath + "admin/patrolTypeDictionary/update?id=" + id,
                        {width: 350, height: 150, id: "my_customer_dialog", ajaxOption: {type: "get"}}
                    );
                });
                $(".add_btn").on('click', function () {
                    dialog.openUrlModal(
                        "新增巡查类型",
                        basePath + "admin/patrolTypeDictionary/add",
                        {width: 350, height: 150, id: "my_customer_dialog", ajaxOption: {type: "get"}}
                    );
                });
            }
        });
    });
</script>
<div class="main-content">
    <div class="appversion" id="appversion">
        <ul class="breadcrumb">
            <li>巡查类型管理</li>
            <li class="active">巡查类型管理</li>
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
                    <table id="qz_userinfo_table" class="table table-bordered"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>