/**
 * af.popup - a popup/alert library for html5 mobile apps
 * copyright Indiepath 2011 - Tim Fisher
 * Modifications/enhancements by Intel for App Framework
 *
 */
/* EXAMPLE
 $.query("body").popup({
 title:"Alert! Alert!",
 message:"This is a test of the emergency alert system!! Don't PANIC!",
 cancelText:"Cancel me",
 cancelCallback: function(){console.log("cancelled");},
 doneText:"I'm done!",
 doneCallback: function(){console.log("Done for!");},
 cancelOnly:false,
 doneClass:'button',
 cancelClass:'button',
 onShow:function(){console.log("showing popup");}
 autoCloseDone:true, //default is true will close the popup when done is clicked.
 suppressTitle:false //Do not show the title if set to true
 width:'280px'
 addCssClass:''
 });

 You can programatically trigger a close by dispatching a "close" event to it.

 $.query("body").popup({title:'Alert',id:'myTestPopup'});
 $("#myTestPopup").trigger("close");

 */

(function ($) {
    "use strict";
    var uuid = function () {
        var a = function () {
            return (65536 * (1 + Math.random()) | 0).toString(16).substring(1)
        };
        return a() + a() + "-" + a() + "-" + a() + "-" + a() + "-" + a() + a() + a()
    };
    var uiBlocked = false;
    var blockUI = function (opacity) {
        if (uiBlocked)
            return;
        opacity = opacity ? " style='opacity:" + opacity + ";'" : "";
        $("body").prepend($("<div id='popupMask'" + opacity + "></div>"));
        $("body div#popupMask").bind("touchstart", function (e) {
            e.preventDefault();
        });
        $("body div#popupMask").bind("touchmove", function (e) {
            e.preventDefault();
        });
        uiBlocked = true;
    };

    var unblockUI = function () {
        uiBlocked = false;
        $("body div#popupMask").unbind("touchstart");
        $("body div#popupMask").unbind("touchmove");
        $("body div#popupMask").remove();
    };
    $.fn.popup = function (opts) {
        return new Popup(this[0], opts);
    };
    var queue = [];
    var Popup = function (containerEl, opts) {

        if (typeof containerEl === "string" || containerEl instanceof String) {
            this.container = document.getElementById(containerEl);
        } else {
            this.container = containerEl;
        }
        if (!this.container) {
            window.alert("Error finding container for popup " + containerEl);
            return;
        }

        try {
            if (typeof (opts) === "string" || typeof (opts) === "number")
                opts = {
                    message: opts,
                    cancelOnly: "true",
                    cancelText: "确定"
                };
            this.id = opts.id = opts.id || uuid(); //opts is passed by reference
            this.addCssClass = opts.addCssClass ? opts.addCssClass : "";
            this.width = opts.width || "280px";
            this.height = opts.height || "auto";
            this.suppressTitle = opts.suppressTitle || this.suppressTitle;
            this.title = opts.suppressTitle ? "" : (opts.title || "");
            this.message = opts.message || "";
            this.onAjax = opts.onAjax || "";
            this.hideFooter = opts.hideFooter || false;
            this.cancelText = opts.cancelText || "取消";
            this.cancelCallback = opts.cancelCallback || function () {
                };
            this.cancelClass = opts.cancelClass || "";
            this.doneText = opts.doneText || "确定";
            this.doneCallback = opts.doneCallback || function () {
                    // no action by default
                };
            this.doneClass = opts.doneClass || "";
            this.cancelOnly = opts.cancelOnly || false;
            this.onShow = opts.onShow || function () {
                };
            this.onHide = opts.onHide || function () {
                };
            this.autoCloseDone = opts.autoCloseDone !== undefined ? opts.autoCloseDone : true;
            this.customBtn = opts.customBtn || "";
            queue.push(this);
            if (queue.length === 1)
                this.show();
        } catch (e) {
            console.log("error adding popup " + e);
        }

    };

    Popup.prototype = {
        id: null,
        addCssClass: null,
        width: null,
        height: null,
        title: null,
        message: null,
        onAjax: null,
        hideFooter: null,
        cancelText: null,
        cancelCallback: null,
        cancelClass: null,
        doneText: null,
        doneCallback: null,
        doneClass: null,
        cancelOnly: false,
        onShow: null,
        onHide:null,
        autoCloseDone: true,
        suppressTitle: false,
        customBtn:null,
        show: function () {
            var self = this;
            var thatTitle = '';
            if (this.title != '') {
                thatTitle = '<header>' + this.title + ' <span class="close" ></span></header>';
            }
            var markup = '<div id="' + this.id + '" class="afPopup hidden ' + this.addCssClass + '"  style="width:' + self.width + '">' +
                thatTitle +
                '<div class="messageBox"  style="height:' + self.height + '">' + this.message + '</div>' +
                '<footer>' +
                '<a  class="' + this.cancelClass + '" id="cancel">' + this.cancelText + '</a>' +
                '<a class="' + this.doneClass + '" id="action">' + this.doneText + '</a>' +this.customBtn+
                '</footer>' +
                '</div>';

            var $el = $(markup);
            $(this.container).append($el);
            $el.bind("close", function () {
                self.hide();
            });
            $el.find("header .close").bind("click", function () {
                self.hide();
            });
            if (this.cancelOnly) {
                $el.find("A#action").remove();
                $el.find("A#cancel").addClass("center");
            }
            $el.find("A").each(function () {
                var button = $(this);
                button.bind("click", function (e) {
                    if (button.attr("id") === "cancel") {
                        self.cancelCallback.call(self.cancelCallback, self);
                          self.hide();
                    } else {
                        self.doneCallback.call(self.doneCallback, self);
                        if (self.autoCloseDone) {
                            self.hide();
                        }
                    }
                    e.preventDefault();
                });
            });
            self.positionPopup();
            blockUI(0.7);

            $el.bind("orientationchange", function () {
                self.positionPopup();
            });

            //force header/footer showing to fix CSS style bugs
            $el.find("header").show();
            if (!self.hideFooter) {
                $el.find("footer").show();
            }
            if (self.onAjax === '') {
                setTimeout(function () {
                    $el.removeClass("hidden").addClass("show");
                    self.onShow(self);
                }, 50);
            } else {
                var params = {
                    "success": function (data) {
                        $el.find(".messageBox").html(data);
                        setTimeout(function () {
                            $el.removeClass("hidden").addClass("show");
                            self.onShow(self);
                        }, 50);
                    }
                };
                jQuery.ajax($.extend(true,{},self.onAjax,params));
            }
        },

        hide: function () {
            var self = this;
            $("#" + self.id).addClass("hidden");
            unblockUI();
            setTimeout(function () {
                self.remove();
                self.onHide.call(self.onHide, self);
            }, 250);

        },

        remove: function () {
            var self = this;
            var $el = $("#" + self.id);
            $el.unbind("close");
            $el.find("BUTTON#action").unbind("click");
            $el.find("BUTTON#cancel").unbind("click");
            $el.unbind("orientationchange").remove();
            queue.splice(0, 1);
            if (queue.length > 0)
                queue[0].show();
        },

        positionPopup: function () {
            var self = this;
            var popup = $("#" + this.id);

            popup.css("top", ((window.innerHeight / 2.5) + window.pageYOffset) - (popup[0].clientHeight / 2) + "px");
            popup.css("left", (window.innerWidth / 2) - (popup[0].clientWidth / 2) + "px");
            var fBtn= popup.find('footer>a');
            fBtn.css('width',(100/fBtn.length)+'%');

        }
    };



    /*    $.afui.registerDataDirective("[data-alert]",function(item){
     var $item=$(item);
     var message=$item.attr("data-message");
     if(message.length===0) return;
     $(document.body).popup(message);
     });

     $.afui.popup=function(opts){
     return $(document.body).popup(opts);
     };*/
    //弹出
    $.extend({popup:function (opts) {
        return $(document.body).popup(opts);
    }});

})(jQuery);
