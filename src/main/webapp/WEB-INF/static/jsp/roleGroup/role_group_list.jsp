<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/roleGroup/role_group_list.js" />"></script>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
       	 	<li>权限管理</li>
            <li class="active">角色管理</li>
        </ul><!-- .breadcrumb -->
    </div>

    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <!-- 内容开始 -->
                <div class="tab-pane">
                     <form class="form-horizontal" role="form" id="selectForm" modelAttribute="form">
                        <div class="control-group">
                            <div class="input-control">
                                <a href="${basePath}admin/roleGroup/toEdit" class="btn btn-primary btn-sm" style="margin-right: 5px;"> <i class="glyphicon glyphicon-plus"></i>新建</a>
                            </div>
                        </div>
                    </form>
                    <table id="qz_role_group_table" class="table table-bordered"></table>

                </div>

                <!-- 内容介绍-->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>
