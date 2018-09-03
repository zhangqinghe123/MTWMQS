(function(){
    var html = '<div class="ui-dialog-modal">' +
        '<table  class="ui-dialog-modal-table"  align="center" cellpadding="10" cellspacing="0">' +
        '<tr><td class="td-ico"><i class="iconfont {$icon_font}"></i></td>' +
        '<td  class="td-body">{$content}</td></tr>' +
        '</table>' +
        '</div>';

    //提示框
    var dialogAlert = function(msgAndTitle,okFun,option) {
        var title = "提示";
        var content = "";

        if (msgAndTitle){
            var msgAndTitleArr = msgAndTitle.split("|");
            if (msgAndTitleArr.length > 1) {
                content = msgAndTitleArr[0];
                title = msgAndTitleArr[1];
            }
            else {
                content = msgAndTitle;
            }
        }
        if (okFun == null){
            okFun = true;
        }
        var iconFont = "icon-tip";
        if (option && option.iconType) {
            switch(option.iconType) {
                case "success":
                    iconFont = "icon-success";
                    break;
                case "wrong":
                    iconFont = "icon-wrong";
                    break;
            }
        }
        var strHtml = html.replace("{$icon_font}", iconFont).replace("{$content}", content);
        var alertDialog = dialog($.extend({title: title, content:strHtml,okValue: '确定', ok: okFun, cancel:false,fixed: true},option||{}));
        alertDialog.showModal();
    };

    //确认提示框
    var dialogConfirm = function(msgAndTitle,okFun,centerFun,option){
        var title = "确认提示";
        var content = "";
        if (msgAndTitle){
            var msgAndTitleArr = msgAndTitle.split("|");
            if (msgAndTitleArr.length > 1) {
                content = msgAndTitleArr[0];
                title = msgAndTitleArr[1];
            }
            else {
                content = msgAndTitle;
            }
        }
        if (okFun == null){okFun = true;}
        if (centerFun == null){centerFun = true;}
        var strHtml = html.replace("{$icon_font}", "icon-help").replace("{$content}", content);
        var confirmDialog = dialog($.extend({title: title, content: strHtml, okValue: '确定', ok: okFun, cancelValue: '取消',cancel:centerFun,fixed: true},option||{}));
        confirmDialog.showModal();
    };

    //加载Url弹窗内容
    var dialogOpenUrlModal = function(title,url,option){
        if (!window.dialogModal) window.dialogModal = {};
        var notModal = false;
        var quickClose = true;
        if (option && option.notModal === true) {
            notModal = true;
            quickClose = false;
        }
        var id = parseInt(Math.random()*100000);
        var defaultOption = { id: "dialog_" + id, title: title, fixed: true, quickClose: quickClose, width: 300,  okValue: '确定', cancelValue: '取消' };
        if(option&&option.iframe===true){
            defaultOption= $.extend(defaultOption,{url:url},option);
            defaultOption= $.extend(defaultOption,{onremove: function () {
                    delete(window.dialogModal[defaultOption.id]);
                    if($("#"+defaultOption.id).length>0){
                        $("#"+defaultOption.id).remove();
                    }
                }
            });
            if (notModal) {
                window.dialogModal[defaultOption.id] = dialog(defaultOption).show();
            } else {
                window.dialogModal[defaultOption.id] = dialog(defaultOption).showModal();
            }
        }
        else {
            var showFun = null;
            if (option.onshow != undefined && typeof (option.onshow) == "function") {
                showFun = option.onshow;
                delete (option.onshow);
            }

            var ajaxOption = { url: url, type: "post", dataType: "html", async: true };
            if (option && option.data) {
                ajaxOption.data = option.data;
            }
            if(option&&option.ajaxOption){
                ajaxOption= $.extend(ajaxOption,option.ajaxOption);
                delete(option.ajaxOption);
            }
            var success = function(html){
                window.dialogModal[defaultOption.id].content(html);
                if (showFun != null) {
                    showFun();
                }
            };
            var error = function(){
                window.dialogModal[defaultOption.id].content("网络异常，请稍候再试！");
            };
            defaultOption = $.extend(defaultOption, { content: '<div class="ui-dialog-content-loading"></div>' }, option);
            defaultOption = $.extend(defaultOption, { onremove: function () { delete (window.dialogModal[defaultOption.id]) } });
            if (notModal) {
                window.dialogModal[defaultOption.id] = dialog(defaultOption).show();
            } else {
                window.dialogModal[defaultOption.id] = dialog(defaultOption).showModal();
            }
            $.ajax($.extend(ajaxOption, { success: success, error: error }));
        }
        return window.dialogModal[defaultOption.id];
    };

    //内容弹窗
    var dialogOpenContentModal = function(title, content, option) {
        if (!window.dialogModal) window.dialogModal = {};
        var notModal = false;
        var quickClose = true;
        if (option && option.notModal === true) {
            notModal = true;
            quickClose = false;
        }
        var id = parseInt(Math.random() * 100000);
        var defaultOption = { id: "dialog_" + id, title: title, fixed: true, quickClose: quickClose, width: 300,  okValue: '确定', cancelValue: '取消' };
        defaultOption = $.extend(defaultOption, { content: content }, option, { onremove: function () { delete (window.dialogModal[defaultOption.id]); } });
        if (notModal) {
            window.dialogModal[defaultOption.id] = dialog(defaultOption).show();
        } else {
            window.dialogModal[defaultOption.id] = dialog(defaultOption).showModal();
        }
        return window.dialogModal[defaultOption.id];
    }


    //显示关闭遮罩
    var dialogLoading = function (flag, isModal) {
        if(flag===false){
            if(window.dialogLoading) window.dialogLoading.close().remove();
        }
        else{
            var innerHtml='<div class="ui-dialog-customer-loading"></div>';
            window.dialogLoading = dialog({ width: 60, height: 60, backdropBackground: "#fff", fixed: true, innerHTML: innerHtml });
            if (isModal != null && isModal) {
                window.dialogLoading.showModal();
            } else {
                window.dialogLoading.show();
            }
        }
    }

    //关闭相应的弹窗，id为弹窗id
    var dialogClose = function (id,result) {
        var dialog = window.dialogModal;
        if (dialog != undefined && dialog[id] != null) {
            if (result != null) {
                dialog[id].close(result).remove();
            } else {
                dialog[id].close().remove();
            }
        }
    }

    //关闭所有弹窗
    var dialogCloseAll = function (result) {
        var dialog = window.dialogModal;
        if(dialog!=undefined){
            for(var d in dialog){
                if (dialog.hasOwnProperty(d)) {
                    if (result != null) {
                        dialog[d].close(result).remove();
                    } else {
                        dialog[d].close().remove();
                    }
                }
            }
        }
    }

    window.dialog.alert = dialogAlert;
    window.dialog.confirm = dialogConfirm;
    window.dialog.openUrlModal = dialogOpenUrlModal;
    window.dialog.openContentModal = dialogOpenContentModal;
    window.dialog.loading = dialogLoading;
    window.dialog.close = dialogClose;
    window.dialog.closeAll=dialogCloseAll;
})();