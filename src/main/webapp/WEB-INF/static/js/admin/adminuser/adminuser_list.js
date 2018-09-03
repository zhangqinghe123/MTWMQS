/**

 */
$(function ($) {
	var url = basePath+'/admin/adminuser/listdata';
     var table = apus.ui.dataTables('#qz_adminuser_table',{
         'ajax': {
             'url': url,
             'type':"POST",
             'data':function ( d ) {

             },
         },
         'searching': false,
        "columns": [
            {
            	"data": "account",
                "title": '登录名',
            },
            {
            	"data": "userName",
                "title": '用户名',
            },
            {
                "title": '操作',
                "width": '200',
                "render": function (data, type, row) {
                    return '<a id="update" data-id="'+row["id"]+'" class="btn btn-info btn-xs" style="margin-right: 5px;">修改</a>'+
                    '<a id="resetPassword" data-id="'+row["id"]+'" class="btn btn-danger btn-xs" style="margin-right: 5px;">重置密码</a>'+
                    '<a id="delete" data-id="'+row["id"]+'" class="btn btn-danger btn-xs" style="margin-right: 5px;">删除</a>';
                }
            }
        ],
         initComplete: function () {
         }
    });
     
     //修改
     $("#qz_adminuser_table").on('click', '#update', function () {
    	 var id = $(this).attr("data-id");
    	 location.href = basePath + "admin/adminuser/toEdit?id="+id;
     });
     //重置密码
     $("#qz_adminuser_table").on('click', '#resetPassword', function () {
    	 var id = $(this).attr("data-id");
         dialog.confirm("<div style='font-size:16px'>确认要重置密码吗?</div>",function(){
        	 $.ajax({
                 url: basePath + "/admin/adminuser/resetPassword",
                 data: {
                	 id:id
                 },
                 type: 'POST',
                 success: function (data) {
                     if (data.errCode == 0) {
                         apus.ui.toastr.success("操作成功！");
                     } else {
                         isCheck = true;
                         apus.ui.toastr.error("操作失败，错误信息：" + data.message);
                     }
                 }
             });
        	
         })
    	 
     });

     //删除
     $("#qz_adminuser_table").on('click', '#delete', function () {
         var id = $(this).attr("data-id");
         dialog.confirm("<div style='font-size:16px'>确认要删除此用户吗?</div>",function(){
        	 $.ajax({
                 url: basePath + "/admin/adminuser/deleteById",
                 data: {
                	 id:id
                 },
                 type: 'POST',
                 success: function (data) {
                     if (data.errCode == 0) {
                         apus.ui.toastr.success("删除成功！");
                         location.href = basePath + "admin/adminuser/list?";
                     } else {
                         isCheck = true;
                         apus.ui.toastr.error("删除失败，错误信息：" + data.message);
                     }
                 }
             });
        	
         })
     });
});






