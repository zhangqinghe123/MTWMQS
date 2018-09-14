<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sA85emPOmdhtikFDCmEq1uRaWV2qI5F5"></script>
<script type="text/javascript">
    $(function ($) {
        var url = basePath + '/admin/userInfo/getPatrolRecords';
        var table = apus.ui.dataTables('#qz_patrol_table', {
            'ajax': {
                'url': url,
                'type': "POST",
                'data': function (d) {
                    d.userId = $("input[name='userId']").val();
                },
            },
            'searching': false,
            "columns": [
                {
                    "data": "filePath",
                    "width": '300',
                    "title": '巡查图片',
                    "render": function (data, type, row) {
                        var str = basePath + 'admin/userInfo/getPatrolPic?patrolRecordId=' + row.id;
                        return '<img src="' + str + '" width="150px" height="150px">';
                    }
                },
                {
                    "data": "explain",
                    "width": '200',
                    "title": '图片说明',
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
                    "data": "userName",
                    "title": '巡查人',
                    "width": '150',
                },
                {
                    "data": "userMobile",
                    "title": '巡查人手机号',
                    "width": '150',
                },
                {
                    "title": '操作',
                    "width": '300',
                    "render": function (data, type, row) {
                        var str = '<a id="showPosition" data-longitude="' + row["longitude"] + '" data-latitude="' + row["latitude"] + '" class="btn btn-success btn-xs" style="margin-right: 5px;">查看上传位置</a>';
                        return str;
                    }
                }
            ],
            initComplete: function () {
                $("#qz_patrol_table").on('click', '#showPosition', function () {
                    debugger;
                    var longitude = $(this).attr("data-longitude");
                    var latitude = $(this).attr("data-latitude");
                    dialog.openUrlModal(
                        "查看上传位置",
                        basePath + "admin/userInfo/showPosition?longitude=" + longitude + "&latitude=" + latitude,
                        {width: 1000, height: 700, id: "my_customer_dialog", ajaxOption: {type: "get"}}
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
            <li>用户管理</li>
            <li class="active">用户巡查记录</li>
        </ul>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <input type="hidden" name="userId" value="${userId}">
                <div class="tab-pane">
                    <table id="qz_patrol_table" class="table table-bordered"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>