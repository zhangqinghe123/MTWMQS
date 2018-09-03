<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">


        <ul class="breadcrumb">
            <li>权限管理</li>
            <li>角色管理</li>
            <li class="active">编辑角色</li>
        </ul><!-- .breadcrumb -->
    </div>
    <form>
    	<input name="id" value="${info.id}" type="hidden"/>
	    <div class="page-content">
	        <div class="row">
	            <div class="col-xs-12">
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >角色名称：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="name" data-rule-required="true" value="${info.name}"  data-rule-maxlength="10"  />
	                        </div>
	                    </div>
	                </div>
	                <div class="clearfix form-actions">
	                    <div class="col-md-offset-3 col-md-9">
	                        <button class="btn btn-info qz_save_btn" >
	                            <i class="icon-ok bigger-110"></i>
	                            <span>提交</span>
	                        </button>
	                        <a class="btn" href="${basePath}admin/roleGroup/list">
	                            <i class="icon-undo bigger-110"></i>
	                            返回
	                        </a>
	                    </div>
	                </div>
	            </div><!-- /.col -->
	        </div><!-- /.row -->
	    </div>
    </form>
    <!-- /.page-content -->
</div><!-- /.main-content -->
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/roleGroup/role_group_edit.js" />"></script>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>