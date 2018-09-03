apus.ui.submitLock = function (el, config) {
    var $el = $(el);//配置里的
    if (config.submitText != '') {
        $el.html(config.submitText)//如果有正常状态下文字的位置有字，则输出正常状态下文字
    }
    //禁止状态下
    if (!config.status) {
        $el.off('click', function (e) {
            e.stopPropagation()//阻止click事件冒泡
            e.preventDefault();
        }).removeClass('disabled').removeAttr("disabled");//移除禁止样式
        $el.find('.fa-spinner').remove();//移除转圈
    } else {
        //正常状态下
        $el.click(function (e) {
            e.stopPropagation()
            e.preventDefault();
        }).addClass('disabled').attr('disabled',"true");
        $el.append('<span class="fa fa-spin fa-spinner margin-l5"></span>');//添加圈圈
        return false
    }

};


