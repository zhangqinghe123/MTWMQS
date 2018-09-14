<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
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
                    "width": '200',
                    "title": '巡查图片',
                    "render": function (data, type, row) {
                        var str = '';
                        // str += '<img src=row["filePath"] width="100px" height="100px">';
                        str += '<img src="http://localhost:10113/MTWMQS//admin/version/downloadApp?versionId=3" width="100px" height="100px">';
                        return str;
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
            ],
            initComplete: function () {
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