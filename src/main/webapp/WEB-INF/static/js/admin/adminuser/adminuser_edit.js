/**
 */
$(function($) {
    $(".qz_save_btn").click(function () {
	    var roleids = ''
		$('input[name="tempRoleGroupIds"]').each(function() {
			if($(this).prop('checked')){
				roleids += $(this).val() + ',';
			}
	    });
	    if(roleids.length === 0) {
	    	apus.ui.toastr.error("角色不能为空");
	    	return;
	    } else {
	    	$('#roleGroupIds').val(roleids);
	    	if ($("form").valid()) {
	    		$(".qz_save_btn").attr("disabled", true).find("span").html("保存中...");
	    		isCheck = false;
	    		window.setTimeout(function() {
	    			$.ajax({
	    				url : basePath + "admin/adminuser/edit",
	    				data : $("form").serialize(),
	    				type : 'POST',
	    				success : function(data) {
	    					if (data.errCode == 0) {
	    						apus.ui.toastr.success("保存成功！");
	    						window.setTimeout(function() {
	    							location.href = basePath + "admin/adminuser/list"
	    						}, 1500);
	    					} else {
	    						isCheck = true;
	    						$(".qz_save_btn").attr("disabled", false).find("span").html("保存");
	    						apus.ui.toastr.error("保存失败，错误信息：" + data.message);
	    					}
	    				},
	    				error : function(e) {
	    					isCheck = true;
	    					$(".qz_save_btn").attr("disabled", false).find("span").html("保存");
	    					apus.ui.toastr.error("保存失败");
	    				},
	    			});
	    		}, 10)
	    	}
	    }
    });
});