<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<link rel="stylesheet" href="${basePath}resources/js/zTree/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="${basePath}resources/js/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/roleResouce/role_resouce_list.js" />"></script>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">


        <ul class="breadcrumb">
            <li>权限管理</li>
            <li>角色管理</li>
            <li class="active">设置权限</li>
        </ul><!-- .breadcrumb -->
    </div>
    <form>
    	<input name="id" value="${info.id}" type="hidden"/>
	    <div class="page-content">
	        <div class="row">
	        	<input type="hidden" name="roleGroupId" value="${roleGroupId}" id="roleGroupId"/>
				<input type="hidden" name="menuIds" id="menuIds"/>
				<div id="treeMenu" class="ztree"></div>
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
	        </div><!-- /.row -->
	        
	    </div>
    </form>
    <!-- /.page-content -->
</div><!-- /.main-content -->
<script>
function getCheckedAll() {
    var treeObj = $.fn.zTree.getZTreeObj("treeMenu");
    var nodes = treeObj.getCheckedNodes(true);
    var ids = "";
    for (var i = 0; i < nodes.length; i++) {
    	ids += nodes[i].id + ";";
    }
    return ids;
}

$(function($) {
	var setting;
	$(function() {
		setting = {
				view: {
					selectedMulti: false
				},
				check: {
					enable: true,
					chkboxType:  { "Y" : "ps", "N" : "s" }
				},
				data: {
		            simpleData: {
		                enable: true,
		                idKey: "id",
		                pIdKey: "pid",
		                nameKey: "name",
		                rootPId: 0
		            },
		            key:{
		            	name:"name"
		            }
		        },
				async: {
					enable: true,
		            type: "post",
		            contentType: "application/json",
		            url:"${basePath}admin/roleResouce/getAllRoleResouce",
					autoParam:["id"],
					dataType:"json"
				},
		        callback:{
		        	onAsyncSuccess:function(){
		        		var treeObj= $.fn.zTree.getZTreeObj("treeMenu");
		        		$.each(${auth},function(entryIndex,entry){
		        			var node = treeObj.getNodeByParam("id", entry['id'], null);
		        			if(typeof(node.children) == "undefined")
		        				treeObj.checkNode(node, true, true);
		        		    }); 
		        	}
		        }
			};
		 $.fn.zTree.init($("#treeMenu"), setting);
		 
	});
	    $(".qz_save_btn").click(function () {
                if($("form").valid()){
                    $(".qz_save_btn").attr("disabled",true).find("span").html("保存中...");
                    isCheck = false;
                    $('#menuIds').val(getCheckedAll);
                    window.setTimeout(function () {
                        $.ajax({
                            url: basePath + "admin/roleGroup/auth",
                            data: $("form").serialize(),
                            type: 'POST',
                            success: function (data) {
                                if (data.errCode == 0) {
                                    apus.ui.toastr.success("保存成功！");
                                    window.setTimeout(function () {
                                        location.href = basePath + "admin/roleGroup/list"
                                    }, 1500);

                                } else {
                                    isCheck = true;
                                    $(".qz_save_btn").attr("disabled", false).find("span").html("保存");
                                    apus.ui.toastr.error("保存失败，错误信息：" + data.message);
                                }
                            },
                            error: function (e) {
                                isCheck = true;
                                $(".qz_save_btn").attr("disabled", false).find("span").html("保存");
                                apus.ui.toastr.error("保存失败");
                            },
                        });
                    },10)
                }
	        });
});

</script>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>