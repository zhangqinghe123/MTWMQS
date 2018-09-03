<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<link rel="stylesheet" href="${basePath}resources/js/zTree/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${basePath}resources/js/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/roleResouce/role_resouce_list.js" />"></script>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
        	<li>权限管理</li>
            <li class="active">菜单管理</li>
        </ul><!-- .breadcrumb -->
    </div>

    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <!-- 内容开始 -->
                <div class="tab-pane">
                	<p class="top-p">
						<span class="sh-but"> 
							<i></i> 
							<a href="${basePath}admin/roleResouce/toAdd" class="w5-search" id="add">添加</a> 
							<i class="sh-but-r"></i> 
						</span> 
						<span class="sh-but"> 
							<i></i> 
							<a id="edit">修改</a> 
							<i class="sh-but-r"></i> 
						</span> 
						<span class="sh-but"> 
							<i></i> 
							<a id="delete">删除</a> 
							<i class="sh-but-r"></i> 
						</span>
					<div class="cf"></div>
					</p>
					<div style="float: left; width: 90%;">
						<div id="treeMenu" class="ztree"></div>
					</div>
                </div>
                <!-- 内容介绍-->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>
