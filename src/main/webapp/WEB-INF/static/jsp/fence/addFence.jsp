<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sA85emPOmdhtikFDCmEq1uRaWV2qI5F5"></script>
<script type="text/javascript">
    $(function ($) {
        //地图初始化
        var map = new BMap.Map("monitor-map-area");
        var point = new BMap.Point("120.395463", "41.503167");
        map.centerAndZoom(point, 14);
        map.enableScrollWheelZoom(true);
        // 添加到地图当中
        var geoc = new BMap.Geocoder();

        function ZoomControl() {
            this.defaultAnchor = BMAP_ANCHOR_TOP_LEFT;
            this.defaultOffset = new BMap.Size(10, 10);
        }

        // 通过JavaScript的prototype属性继承于BMap.Control
        ZoomControl.prototype = new BMap.Control();

        // 自定义控件必须实现自己的initialize方法,并且将控件的DOM元素返回
        // 在本方法中创建个p元素作为控件的容器,并将其添加到地图容器中
        ZoomControl.prototype.initialize = function (map) {
            // 创建一个DOM元素
            var p = document.createElement("p");
            p.innerHTML = '<p id="r-result">搜索地址:<input type="text" id="suggestId" size="20" value="百度" style="width:150px;" /></p><p id="searchResultPanel" style="border:1px solid #C0C0C0;width:150px;height:auto; display:none;"></p>';

            // 添加DOM元素到地图中
            map.getContainer().appendChild(p);
            // 将DOM元素返回
            return p;
        }
        // 创建控件
        var myZoomCtrl = new ZoomControl();
        // 添加到地图当中
        map.addControl(myZoomCtrl);

        var ac = new BMap.Autocomplete(    //建立一个自动完成的对象
            {
                "input": "suggestId"
                , "location": map
            });

        var myValue;
        ac.addEventListener("onconfirm", function (e) {    //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            myValue = _value.province + _value.city + _value.district + _value.street + _value.business;
            $("#searchResultPanel").innerHTML = "onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

            map.clearOverlays();    //清除地图上所有覆盖物
            function myFun() {
                var pp = local.getResults().getPoi(0).point;    //获取第一个智能搜索的结果
                map.centerAndZoom(pp, 18);
                map.addOverlay(new BMap.Marker(pp));    //添加标注
                // $("#longitude").val(pp.lng);
                // $("#latitude").val(pp.lat);
            }

            var local = new BMap.LocalSearch(map, { //智能搜索
                onSearchComplete: myFun
            });
            local.search(myValue);
        });
        map.addEventListener("click", function (e) {
            //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
            var pt = e.point;
            // map.clearOverlays();
            map.addOverlay(new BMap.Marker(pt));
            geoc.getLocation(pt, function (rs) {
                //将对应的HTML元素设置值
                // $("#longitude").val(pt.lng);
                // $("#latitude").val(pt.lat);
                if ($("#fencePoint").val() === "") {
                    var tmp = pt.lat + "," + pt.lng
                    $("#fencePoint").val(tmp);
                } else {
                    var tmp = $("#fencePoint").val() + ";" + pt.lat + "," + pt.lng
                    $("#fencePoint").val(tmp);
                }
            });
        });

        $("#cleanFence").on('click', function () {
            $.ajax({
                url: basePath + "admin/userInfo/cleanFence",
                data: {
                    userId: $("#userId").val()
                },
                type: 'POST',
                success: function (data) {
                    if (data.errCode == 0) {
                        apus.ui.toastr.success("成功！");
                        window.location.href = basePath + '/admin/userInfo/fenceInfo/' + $("#userId").val();
                    } else {
                        apus.ui.toastr.error("删除失败，错误信息：" + data.message);
                    }
                },
                error: function (e) {
                    apus.ui.toastr.error("删除失败");
                },
            });
        });

        $("#addFence").on('click', function () {
            $.ajax({
                url: basePath + "admin/userInfo/addFence",
                data: {
                    userId: $("#userId").val(),
                    vertexes: $("#fencePoint").val()
                },
                type: 'POST',
                success: function (data) {
                    if (data.errCode == 0) {
                        apus.ui.toastr.success("成功！");
                        window.location.href = basePath + '/admin/userInfo/fenceInfo/' + $("#userId").val();
                    } else {
                        apus.ui.toastr.error("删除失败，错误信息：" + data.message);
                    }
                },
                error: function (e) {
                    apus.ui.toastr.error("删除失败");
                },
            });
        });

        if ($("#fencePoint").val() != null && $("#fencePoint").val() !== undefined && $("#fencePoint").val() != "") {
            var localStorage = $("#fencePoint").val().split(";");
            for (var i = 0; i < localStorage.length; i++) {
                var location = localStorage[i].split(",");
                var pt = new BMap.Point(location[1], location[0]);
                map.addOverlay(new BMap.Marker(pt));
                if (i === 0) {
                    map.centerAndZoom(pt, 18);
                }

            }


        }
    });

</script>

<div class="main-content">
    <div class="appversion" id="appversion">
        <ul class="breadcrumb">
            <li>用户管理</li>
            <li class="active">配置用户【${userInfo.userName}】的鹰眼信息</li>
        </ul>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <input type="hidden" id="userId" name="userId" value="${userInfo.id}">
                <textarea name="fencePoint" id="fencePoint" placeholder="点击地图设置围栏多边形" readonly="readonly"
                          style="width:50%">${fencePoint}</textarea>
                <div class="control-group">
                    <div class="input-control">
                        <span class="btn btn-primary btn-sm query_btn" id="addFence" name="addFence">添加围栏</span>
                        <span class="btn btn-primary btn-sm query_btn" id="cleanFence" name="cleanFence">清除围栏</span>
                    </div>
                </div>
                <div class="tab-pane">
                    <div class="monitor-map-area" id="monitor-map-area" style="height: 650px;"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>