
var apus = {};
apus.namespace = function () {
	var D, e;
	var E = arguments[0];

	e = E.split(".");
	D = window[e[0]] = window[e[0]] || {};
	$.each(e.slice(1), function (idx, F) {
		D = D[F] = D[F] || {}
	});

	return D;
};
/* UI函数开始 */
apus.namespace('apus.ui.toastr');// 提示
apus.namespace('apus.ui.dataTables');// 表格

var sysCfg = {
	devMode : false,
    today : new Date(),
	loading:function(t){
		var load = new Loading();
		if(t){
			load.init();
			load.start();
			return load;
		}else{
			load.stop();
		}
	},
    formatter : {
        fDate : function(date,f)
        {
	        var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	        var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
	        if(f)
	        {
	        	return date.getFullYear() + '年' + month + '月' + day + '日';
	        }
	        return date.getFullYear() + '-' + month + '-' + day;
        },
        fDateTime : function(time,f)
        {
	        var date = new Date(time);
	        var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	        var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
	        var h = date.getHours() > 9 ? date.getHours() : "0" + date.getHours();
	        var m = date.getMinutes() > 9 ? date.getMinutes() : "0" + date.getMinutes();
	        var s = date.getSeconds() > 9 ? date.getSeconds() : "0" + date.getSeconds();
	        if(f)
	        {
	        	return date.getFullYear() + '年' + month + '月' + day + '日' + " " + h + ":" + m + ":" + s;;
	        }
	        return date.getFullYear() + '-' + month + '-' + day + " " + h + ":" + m + ":" + s;
        },
        fTimeYYMMDD : function(time,f)
        {
	        var date = new Date(time);
	        var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	        var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
	        if(f)
	        {
	        	return date.getFullYear() + '年' + month + '月' + day + '日';
	        }
	        return date.getFullYear() + '-' + month + '-' + day;
        },
        fDetail : function(value)
        {
	        return "";
        }
    },
    beginTime : function()
    {
	    var _t = this.today;
	    _t.setDate(this.today.getMonth() - 1);
	    return this.formatter.fDate(_t);
    },
    endTime : function()
    {
	    var _t = this.today;
	    _t.setMonth(this.today.getMonth() + 2);
	    return this.formatter.fDate(_t);
    },
    openMessage : function(type, text, ptimeout)
    {
	    text = (text == "" ? null : text);
	    var timeout = 1000;
	    if (type == msgType.warning || type == msgType.info)//警告
	    {
		    timeout = 3000;
	    }
	    else if (type == msgType.success)//成功 
	    {
		    text = (text && text != null ? text : "操作成功");//${common_op_succeed}:操作成功
		    var num = this.strlen(text) / 30;
		    num = num > 8 ? 8 : num;
		    timeout = Math.ceil(num) * timeout;//动态判断显示字符数的长度来延长显示时间
	    }
	    else if (type == msgType.error)//失败
	    {
		    text = (text && text != null) ? text : "操作失败";//${common_op_failed}:操作失败，程序出现异常
		    timeout = 3000;
	    }
	    else if (type == msgType.loading)//处理中
	    {
		    timeout = 0;//当为'loading'时，timeout值会被设置为0，表示不会自动关闭。
		    text = text && text != null ? text : "处理中";//${common_op_processing}:处理中
	    }
	    var width = this.strlen(text) * 6.1 + 45;//按字符计算宽度
	    timeout = ptimeout ? ptimeout : timeout;
	    $.jBox.tip(text, type, {
	        timeout : timeout,
	        width : (width > 400 ? 400 : "auto")
	    });//设定最大宽度为400
	    $(".jbox-tip .jbox").css("z-index", "99999");
    },
    closeMessage : function(timeout)
    {
	    timeout = timeout ? timeout : 1000;
	    window.setTimeout("$.jBox.closeTip();", timeout);//设定最小等待时间
    },
    confirm : function(title, text, callBack)
    {
	    $.jBox.confirm(text, title, callBack);
	    $("#jbox-body").css("z-index", "99999");
    },
    isNum : function(s)
    {
	    if (!this.isEmpty(s))
	    {
		    return s.match(/^\d+$/i) == s;
	    }
	    return false;
    },
    isEmpty : function(s)
    {
	    return s == undefined || s == "" || s.length == 0 ;
    },
    strlen : function(str)
    {
	    var len = 0;
	    if(this.isEmpty(str)){
	    	return len;
	    }
	    for (var i = 0; i < str.length; i++)
	    {
		    var c = str.charCodeAt(i);
		    if ((c >= 0x0001 && c <= 0x007e) || (0xff60 <= c && c <= 0xff9f))
		    {
			    len++;
		    }
		    else
		    {
			    len += 2;
		    }
	    }
	    return len;
    },
	alert:function(str){
		alert(str);
	},
    rangTime : function()
    {
	    return new Date().getTime() + "_" + Math.round(Math.random() * 10000);
    },


    jsonStrToObj : function(str)
    {
	    if (!this.isEmpty(str))
	    {
		    if (!/^\[?{.*}\]?$/.test(str))
		    {
		    	
			    str = "{" + str + "}"
		    }
		    try
		    {
			    return eval("(" + str + ")")
		    }
		    catch (e)
		    {
		    	this.openMessage(msgType.error, "json参数格式不对！");
		    }
	    }
    },
    getId:function(obj,key){
	    if (typeof key == "string")
	    {
	    	return obj[key];
	    }
	    else if (typeof key == "function")
	    {
	    	return key(obj);
	    }
	    return obj.id;
    },
    getIds:function(list,key)
    {
    	var ids = "";
	    $(list).each(function(i, val)
	    {
		    ids += "," + sysCfg.getId(val,key);
	    });
	    return ids.replace(",", "");
    },
    urlPath:function(url){
    	if (url != undefined && url.indexOf(basePath) < 0)
        {
    		url = basePath + url;
        }
    	return url;
    },
    test : function()
    {
	    alert(1);
    },
    showLoginWindow:function() {
        $("#loginDlg").show().dialog({
			title:"登录界面",
			width:360,
			height:230,
			modal:true,
			buttons:[{
				iconCls: 'icon-ok',
				text:"登 录",
				handler:function()
		        {
					sysCfg.openMessage(msgType.loading,"登陆中...");
					sysCfg.login("#loginDlg");
		        }
			}],
			close:function(){
				return false;
			}
		}).dialog('center');
        $(".dialog-button:visible").find("a.l-btn").addClass("c6");
        $("#loginDlg input").keyup(function(event){
  		  if(event.keyCode ==13){
  			sysCfg.openMessage(msgType.loading,"登陆中...");
  			sysCfg.login("#loginDlg");
  		  }
  		});
    },
    login:function(dlgId){
	    var username= $("input[name='j_username']").val();
	    if(username==""){
	    	sysCfg.openMessage(msgType.error, "请填写用户名！");
	    	$("input[name='j_username']").prev().focus();
	    	return;
	    }
	    var password= $("input[name='j_password']").val();
	    if(password==""){
	    	sysCfg.openMessage(msgType.error, "请填写密码！");
	    	$("input[name='j_password']").prev().focus();
	    	return;
	    }
	    console.log(basePath + "ajaxLoginProcess");
	    sysCfg.openMessage(msgType.loading,"登陆中...");
	 
	    $.ajax({  
	        url: basePath + "ajaxLoginProcess",  
	        type:"POST",  
	        data:{
	        	j_username:username,
	        	j_password:password
	        },  
	        success: function(data){  
	            if (data.errCode != 0)
		        {
		        	sysCfg.openMessage(msgType.error, data.message);
			        return;
		        }
	            if(typeof dlgId == "string" && dlgId.indexOf("Dlg") != -1)
	            {
	            	$('#centerTab').tabs("getSelected").panel('refresh');
	            	$(dlgId).dialog('close');
	            	sysCfg.openMessage(msgType.success,"登录成功！");
	            }
	            else
	            {
	            	window.location.href = basePath;
	            }
	        }  
	    });  
    }
}, msgType = {//消息控件的使用类型的类
    info : "info",
    success : "success",
    warning : "warning",
    error : "error",
    loading : "loading"
};
$.browser = {
    mozilla : /firefox/.test(navigator.userAgent.toLowerCase()),
    webkit : /webkit/.test(navigator.userAgent.toLowerCase()),
    opera : /opera/.test(navigator.userAgent.toLowerCase()),
    msie : /msie/.test(navigator.userAgent.toLowerCase())
};

//全局设置jquery Ajax请求全局设置
$.ajaxSetup({
    async : false,
    dataType : 'json',
    //contentType:'application/json;charset=UTF-8',
    data : {
	    un : sysCfg.rangTime(),
	    ajax : 'ajax'
    },
    error : function(XMLHttpRequest, textStatus, errorThrown)
    {

	    var status = XMLHttpRequest.status;
	    if (status != 200)
	    {

		    dealAjaxError(status);
	    }
    }
});

(function($) {
    // 备份jquery的ajax方法
    var _ajax = $.ajax;

    // 重写jquery的ajax方法
    $.ajax = function(opt) {
        // 备份opt中error和success方法
        var fn = {
            error : function(XMLHttpRequest, textStatus, errorThrown) {
            },
            success : function(data, textStatus) {
            }
        };
        if (opt.error) {
            fn.error = opt.error;
        }
        if (opt.success) {
            fn.success = opt.success;
        }

        // 扩展增强处理
        var _opt = $.extend(opt, {
            error : function(XMLHttpRequest, textStatus, errorThrown) {
                // 错误方法增强处理
                fn.error(XMLHttpRequest, textStatus, errorThrown);
            },
            success : function(data, textStatus) {
                // 成功回调方法增强处理
                if(data){
                	if(typeof data == "string" && data.indexOf("\"isLoginRequired\":") != -1)
                	{
                		data = sysCfg.jsonStrToObj(data);
                	}
                    if (data.errCode != 0 && data.data != undefined && data.data.isLoginRequired)
                    {
                    	sysCfg.showLoginWindow();
                    } else {
                        fn.success(data, textStatus);
                    }
                }

            }
        });
        _ajax(_opt);
    };
})(jQuery);

function dealAjaxError(status)
{
	var result = true;
	var type;//login/other
	var text = "Failed";
	if (status != null && typeof (status) != "undefined")
	{
		switch (status.toString())
		{
			case "201"://登录超时201
				type = "login";
				text = "登录超时";
				break;
			case "202"://同时登录202
				type = "login";
				text = "同时登录";
				break;
			case "101"://权限不足101
				type = "other";
				text = "权限不足[" + status + "]";
				break;
			case "0"://路径错误或服务已停止0
				type = "other";
				text = "服务器连接失败！";
				break;
			default://程序内部异常
				type = "other";
				text = "服务器处理数据失败，请重试！错误码:[" + status + "]";
				break;
		}
		if (type == "login")
		{
			if (openLoginAlert)
			{
				sysCfg.confirm("提示！",text,function(){
					window.top.location.reload();
				});
				openLoginAlert = false;
			}
			result = false;
		}
		else if (sysCfg.devMode || status != 200)
		{
			sysCfg.openMessage(msgType.error, text);
			result = false;
		}
	}
	return result;
}

