<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">


        <ul class="breadcrumb">
       	 	<li>权限管理</li>
            <li>菜单管理</li>
            <li class="active">新增菜单</li>
        </ul><!-- .breadcrumb -->
    </div>
    <form>
    	<input name="pid" value="${parentMenuId}" type="hidden"/>
	    <div class="page-content">
	        <div class="row">
	            <div class="col-xs-12">
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >菜单名称：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="name" data-rule-required="true" value="${info.name}"  data-rule-maxlength="10"  />
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >父级菜单：</label>
	                        <div class="col-sm-9">
	                            <label>${parentMenuName}</label>
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >地址链接：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="actionLink" value="${info.actionLink}"  data-rule-maxlength="100"  />
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >排序号：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="orderBy" value="${info.orderBy}"  data-rule-maxlength="11"  />
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >图标css：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="iconClass" value="${info.iconClass}"  data-rule-maxlength="100" placeholder="一级菜单图标" />
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >标识：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="menuFlag" value="${info.menuFlag}"  data-rule-maxlength="100"  />
	                        </div>
	                    </div>
	                </div>
	                 <div class="form-horizontal">
	                    <div class="form-group">
	                        <label class="col-sm-3 control-label no-padding-right" >选项卡标识(普通菜单不填,选项卡填1)：</label>
	                        <div class="col-sm-9">
	                            <input type="text" name="tabFlag" value="${info.tabFlag}"  data-rule-maxlength="100"  />
	                        </div>
	                    </div>
	                </div>
	                <div class="clearfix form-actions">
	                    <div class="col-md-offset-3 col-md-9">
	                        <button class="btn btn-info qz_save_btn" >
	                            <i class="icon-ok bigger-110"></i>
	                            <span>提交</span>
	                        </button>
	                       <a class="btn" href="${basePath}admin/roleResouce/list">
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
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/roleResouce/role_resouce_add.js" />"></script>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>