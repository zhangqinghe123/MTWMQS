/**

 */
$(function ($) {
	var setting = {
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
				url:basePath+"admin/roleResouce/getAllRoleResouce",
				autoParam:["id"],
				dataType:"json"
			},
	        callback:{
	        	onClick: function(event, treeId, treeNode, clickFlag){
	        		$('#add').attr('href',basePath+'admin/roleResouce/toAdd?parentMenuId='+treeNode.id+'&parentMenuName='+treeNode.name);
	        		$('#edit').attr('href',basePath+'admin/roleResouce/toEdit?id='+treeNode.id);
	        		$('#delete').attr('menu_id',treeNode.id);
	        	}
	        }
		};
	//var zNodes = "";
	$.fn.zTree.init($("#treeMenu"), setting);
	
	$('#delete').click(function(){
		 dialog.confirm("<div style='font-size:16px'>确认要删除此菜单吗?</div>",function(){
	       	 $.ajax({
	                url: basePath + "/admin/roleResouce/deleteById",
	                data: {
	               	 id:$('#delete').attr('menu_id')
	                },
	                type: 'POST',
	                success: function (data) {
	                    if (data.errCode == 0) {
	                        apus.ui.toastr.success("删除成功！");
							location.href = basePath + "admin/roleResouce/list"
	                    } else {
	                        isCheck = true;
	                        apus.ui.toastr.error("删除失败，错误信息：" + data.message);
	                    }
	                }
	            });
	       	
	        })
	});
});





