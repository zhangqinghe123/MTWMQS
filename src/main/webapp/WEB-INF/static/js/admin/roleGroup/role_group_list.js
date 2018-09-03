/**

 */
$(function ($) {
	var url = basePath+'/admin/roleGroup/listdata';
     var table = apus.ui.dataTables('#qz_role_group_table',{
         'ajax': {
             'url': url,
             'type':"POST",
             'data':function ( d ) {

             },
         },
         'searching': false,
        "columns": [
            {
            	"data": "name",
                "title": '角色名称',
            },
            {
            	"data": "disabled",
                "title": '状态',
                "render": function (data, type, row) {
                	if(0===data){return '启用'}
                	else if(1===data){return '停用'}
                	else{return '未知'}
                }
            },
            {
                "title": '操作',
                "width": '200',
                "render": function (data, type, row) {
                	var disabled=row.disabled,statusName;
                	if(0===disabled){
                		statusName= '停用';
                		disabled=1;
                	}
                	else if(1===disabled){
                		statusName= '启用';
                		disabled=0;
                	}
                    return '<a id="update" data-id="'+row["id"]+'" class="btn btn-info btn-xs" style="margin-right: 5px;">修改</a>'+
                    '<a id="delete" data-id="'+row["id"]+'" data-disabled="'+disabled+'" class="btn btn-danger btn-xs" style="margin-right: 5px;">'+statusName+'</a>'+
                    '<a id="setAuth" data-id="'+row["id"]+'" class="btn btn-danger btn-xs" style="margin-right: 5px;">设置权限</a>';
                }
            }
        ],
         initComplete: function () {
         }
    });
     
     
     //启用停用
     $("#qz_role_group_table").on('click', '#delete', function () {
    	 var id = $(this).attr("data-id");
    	 var disabled = $(this).attr("data-disabled");
    	 $.ajax({
    		 url: basePath + "/admin/roleGroup/deleteById",
    		 data: {
    			 id:id,
    			 disabled:disabled
    		 },
    		 type: 'POST',
    		 success: function (data) {
    			 if (data.errCode == 0) {
    				 apus.ui.toastr.success("操作成功！");
    				 location.href = basePath + "admin/roleGroup/list"
    			 } else {
    				 isCheck = true;
    				 apus.ui.toastr.error("操作失败，错误信息：" + data.message);
    			 }
    		 }
    	 });
    	 
     });
     //修改
     $("#qz_role_group_table").on('click', '#update', function () {
    	 var id = $(this).attr("data-id");
    	 location.href = basePath + "admin/roleGroup/toEdit?id="+id;
    	 
     });
     //设置权限
       $("#qz_role_group_table").on('click', '#setAuth', function () {
    	   var id = $(this).attr("data-id");
    	   location.href = basePath + "admin/roleGroup/toAuth?id="+id;
          	
       });
});






