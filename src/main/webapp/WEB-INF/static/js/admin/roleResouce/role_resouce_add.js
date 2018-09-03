/**
 */
$(function($) {
    $(".qz_save_btn").click(function () {
	if ($("form").valid()) {
		$(".qz_save_btn").attr("disabled", true).find("span").html("保存中...");
		isCheck = false;
		// apus.ui.toastr.error("测试环境无法操作" );
		// return false;
		window.setTimeout(function() {
			$.ajax({
				url : basePath + "admin/roleResouce/edit",
				data : $("form").serialize(),
				type : 'POST',
				success : function(data) {
					if (data.errCode == 0) {
						apus.ui.toastr.success("保存成功！");
						window.setTimeout(function() {
							location.href = basePath + "admin/roleResouce/list"
						}, 1500);

					} else {
						isCheck = true;
						$(".qz_save_btn").attr("disabled", false).find("span")
								.html("保存");
						apus.ui.toastr.error("保存失败，错误信息：" + data.message);
					}
				},
				error : function(e) {
					isCheck = true;
					$(".qz_save_btn").attr("disabled", false).find("span")
							.html("保存");
					apus.ui.toastr.error("保存失败");
				},
			});
		}, 10)
	}
    });
});
