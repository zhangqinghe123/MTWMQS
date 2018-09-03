;
(function ($, window, document, undefined) {
    "use strict";
    var log = console.log.bind(console);
    //定义ConstructorName的构造函数
    var ConstructorName = function (ele, opt) {
        this.$element = ele,
            this.defaults = {
                'id': this.$element.attr('id') + '-red',
                'addCssClass': 'loadIngBox',
                'text': ''
            },
            this.options = $.extend({}, this.defaults, opt)
    }
    //定义ConstructorName的方法
    ConstructorName.prototype = {
        show: function () {
            var self = this;
            var markup = $('<div/>', {
                id: self.options.id,
                class: this.options.addCssClass,
                css: self.positionPopup()
            }), markupConcent = '<div class="ui-loader"><div class="loadingCircle"><div class="sui-loading loading-large"><i class="sui-icon icon-pc-loading"></i></div><h1>' + this.options.text + '</h1></div>'
            markup.append(markupConcent);
            if (self.$element.css('position') === 'static') {
                self.$element.css("position", "relative")
            }
            ;
            self.$element.append(markup);
        },
        hide: function () {
            var self = this;
            $("#" + self.options.id).addClass("hidden");
            setTimeout(function () {
                self.remove();
            }, 250);

        },
        remove: function () {
            var self = this;
            log('remove');
            var $el = $("#" + self.options.id);
            $el.remove();
            log('remove end');
        },
        positionPopup: function () {
            var self = this;
            log('positionPopup');
            return {"position": "absolute", "top": "0", "right": "0", "bottom": "0", "left": "0"}
        },
        init: function () {
            if ($("#" + this.options.id).length < 1) {
                this.show();
            } else {
                this.hide();
            }
            ;

        }
    }
    //在插件中使用ConstructorName对象
    $.fn.loading = function (options) {
        //创建ConstructorName的实体
        var constructorName = new ConstructorName(this, options);
        //调用其方法
        return constructorName.init();
    }
})(jQuery, window, document);
//$('a').loading();
apus.ui.loading = function (el, opt) {
    try {
        $(el).loading(opt);
    }
    catch (err) {
        //在这里处理错误
    }
};