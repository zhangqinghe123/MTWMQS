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
        ZoomControl.prototype.initialize = function(map){
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
            {"input" : "suggestId"
                ,"location" : map
            });

        var myValue;
        ac.addEventListener("onconfirm", function(e) {    //鼠标点击下拉列表后的事件
            var _value = e.item.value;
            myValue = _value.province +  _value.city +  _value.district +  _value.street +  _value.business;
            $("#searchResultPanel").innerHTML ="onconfirm<br />index = " + e.item.index + "<br />myValue = " + myValue;

            map.clearOverlays();    //清除地图上所有覆盖物
            function myFun(){
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
        map.addEventListener("click", function(e){
            //通过点击百度地图，可以获取到对应的point, 由point的lng、lat属性就可以获取对应的经度纬度
            var pt = e.point;
            map.clearOverlays();
            map.addOverlay(new BMap.Marker(pt));
            geoc.getLocation(pt, function(rs){
                //将对应的HTML元素设置值
                // $("#longitude").val(pt.lng);
                // $("#latitude").val(pt.lat);
            });
        });

    });

</script>

<div class="main-content">
    <div class="appversion" id="appversion">
        <ul class="breadcrumb">
            <li>用户管理</li>
            <li class="active">用户巡查记录</li>
        </ul>
    </div>
    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <input type="hidden" name="userId" value="${userId}">
                <div class="tab-pane">
                    <div class="monitor-map-area" id="monitor-map-area" style="height: 750px;"> </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>