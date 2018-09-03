/**
 * Created by jiznfu.zeng on 2015/10/27.
 */
(function (window, document, undefined) {

    var factory = function ($) {
        "use strict";
        $.extend($.validator.messages, {
            required: "这是必填字段",
            remote: "请修正此字段",
            email: "请输入有效的电子邮件地址",
            url: "请输入有效的网址",
            date: "请输入有效的日期",
            dateISO: "请输入有效的日期 (YYYY-MM-DD)",
            number: "请输入有效的数字",
            digits: "只能输入数字",
            creditcard: "请输入有效的信用卡号码",
            equalTo: "你的输入不相同",
            extension: "请输入有效的后缀",
            maxlength: $.validator.format("最多可以输入 {0} 个字符"),
            minlength: $.validator.format("最少要输入 {0} 个字符"),
            rangelength: $.validator.format("请输入长度在 {0} 到 {1} 之间的字符串"),
            range: $.validator.format("请输入范围在 {0} 到 {1} 之间的数值"),
            max: $.validator.format("请输入不大于 {0} 的数值"),
            min: $.validator.format("请输入不小于 {0} 的数值")
        });
        // ===============

        // 自定义添加错误显示
        $.fn.validate.ExError = {
            addRefError: function (refId) {
                $("[error-ref=" + refId + "]").addClass("error");
            },
            removeRefError: function (refId) {
                $("[error-ref=" + refId + "]").removeClass("error");
            },
            addError: function (targetId, errorMsg, offsetLeftEx) {
                var offsetLeftEx = offsetLeftEx ? offsetLeftEx : {'x': 0, 'y': 0}
                var $target = $("#" + targetId);
                if ($target.length == 0) return;

                var errorLabelId = targetId + "-error";
                var $errorLabel = $("#" + errorLabelId);
                if ($errorLabel.length == 0) {
                    var eMsg = errorMsg || "必须填写";
                    //   var left = $target.get(0).offsetLeft + $target.width() + (offsetLeftEx || 30) + "px";
                    /*            var X = $target.get(0).offsetTop;
                     var Y = $target.get(0).offsetLeft + $target.width();*/

                    $target.parent().addClass('validate-error');
                    var X = $target.position().left + $target.outerWidth() + offsetLeftEx.x;
                    var Y = $target.position().top + offsetLeftEx.y;
                    $errorLabel = $("<span id='" + errorLabelId + "' class=\"validate-has-error-ex\">" + eMsg + "</span>").css({'left': X, 'top': Y}).insertAfter($target);
                    $errorLabel.insertAfter($target);
                } else {
                    $errorLabel.html(errorMsg);
                    $errorLabel.show();
                }
                $target.parent().addClass('validate-error');
                this.addRefError(targetId);
            },
            removeError: function (targetId) {
                $("#" + targetId + "-error").hide();
                $("#" + targetId).removeClass("validate-error");
                //  this.removeRefError(targetId);
            }
        };

        $(document)
            .on('init.ext.validate.data-api', '[data-init="validate"]', function (e) {
                e.preventDefault();
                var $this = $(this);
                if ($this.data('validate')) return;
                var opts = {
                        rules: {},
                        messages: {},
                        errorElement: 'span',
                        errorClass: 'validate-has-error',
                        highlight: function (element) {
                            if ($(element).is(":radio") || $(element).is(":checkbox")) {
                                $(element).addClass('error').parent().parent().addClass('validate-error');
                            }
                            else {
                                $(element).addClass('error').parent().addClass('validate-error');
                            }
                        },
                        unhighlight: function (element) {
                            if ($(element).is(":radio") || $(element).is(":checkbox")) {
                                $(element).removeClass('error').parent().parent().removeClass('validate-error');
                            }
                            else {
                                $(element).removeClass('error').parent().removeClass('validate-error');
                            }
                        },
                        errorPlacement: function (error, element) {
                            var X = element.position().top;
                            var Y = element.position().left + element.outerWidth();
                            if (element.closest('.has-switch').length) {
                                error.insertAfter(element.closest('.has-switch'));
                            }
                            else if (element.is(":radio") || element.is(":checkbox")) {
                                var X = element.parent().position().top;
                                var Y = element.parent().position().left + element.parent().outerWidth();
                                error.css({'left': Y, 'top': X}).insertAfter(element.parent());
                            }
                            else if (element.attr('data-init') == "select2") {
                                var X = element.position().top;
                                var Y = element.position().left + element.outerWidth();

                                error.css({'left': Y, 'top': X}).insertAfter(element);
                                element.bind('change', function () {
                                    $(this).valid();
                                })
                            }
                            else {
                                error.css({'left': Y, 'top': X}).insertAfter(element);
                            }
                        }
                    },
                    $fields = $this.find('[data-validate]');
                $fields.each(function (j, el2) {
                    var $field = $(el2),
                        name = $field.attr('name'),
                        validate = attrDefault($field, 'validate', '').toString(),
                        _validate = validate.split(',');

                    for (var k in _validate) {
                        var rule = _validate[k],
                            params,
                            message;

                        if (typeof opts['rules'][name] == 'undefined') {
                            opts['rules'][name] = {};
                            opts['messages'][name] = {};
                        }

                        if ($.inArray(rule, ['required', 'url', 'email', 'number', 'date', 'creditcard']) != -1) {
                            opts['rules'][name][rule] = true;

                            message = $field.data('message-' + rule);

                            if (message) {
                                opts['messages'][name][rule] = message;
                            }
                        }
                        // Parameter Value (#1 parameter)
                        else if (params = rule.match(/(\w+)\[(.*?)\]/i)) {
                            if ($.inArray(params[1], ['min', 'max', 'minlength', 'maxlength', 'equalTo']) != -1) {
                                opts['rules'][name][params[1]] = params[2];


                                message = $field.data('message-' + params[1]);

                                if (message) {
                                    opts['messages'][name][params[1]] = message;
                                }
                            }
                        }
                    }
                });
                $this.validate(opts);
                $this.data('validate', 'validate');

            })
            .on('click', '.validate-has-error-ex,.validate-has-error', function () {
                $(this).hide();
            })
            //AJAX停止事件
            .ajaxStop(function () {
                $('[data-init="validate"]').trigger("init.ext.validate.data-api");
            })
        //页面初始化
        $(function () {
            $('[data-init="validate"]').trigger("init.ext.validate.data-api");
        });


    }; // /factory


// Define as an AMD module if possible
    if (typeof define === 'function' && define.amd) {
        define(['jquery'], factory);
    }
    else if (typeof exports === 'object') {
        // Node/CommonJS
        factory(require('jquery'));
    }
    else if (jQuery) {
        // Otherwise simply initialise as normal, stopping multiple evaluation
        factory(jQuery);
    }


})(window, document);
