<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<script type="text/javascript"
        src="http://api.map.baidu.com/getscript?v=2.0&ak=zsKT6hGm3BYL65E9DmFyqTNGC90ojzaj"></script>
<script type="text/javascript">
    $(function ($) {
        //地图初始化
        var bm = new BMap.Map("monitor-map-area");//41.818798   123.44835
        var point = new BMap.Point("120.395463", "41.503167");
        bm.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
        bm.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
        bm.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
        bm.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
        bm.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
        // var myIconpq = new BMap.Icon(basePath + "/resources/css/images/position.png", new BMap.Size(32, 40), {imageOffset: new BMap.Size(0, 10)});
        // var point=new BMap.Point($("#longitude").val(), $("#latitude").val());
        bm.centerAndZoom(point, 10);
        // var marker=new BMap.Marker(point,{icon: myIconpq});
        // bm.addOverlay(marker)

        var bdary = new BMap.Boundary();
        bdary.get("朝阳县", function (rs) {       //获取行政区域
            bm.clearOverlays();        //清除地图覆盖物
            //for循环都删除掉了，只剩下这个
            //网上查了下，东西经南北纬的范围
            var EN_JW = "180, 90;";         //东北角
            var NW_JW = "-180,  90;";       //西北角
            var WS_JW = "-180, -90;";       //西南角
            var SE_JW = "180, -90;";        //东南角
            //4.添加环形遮罩层
            // var ply1 = new BMap.Polygon(rs.boundaries[0] + SE_JW + SE_JW + WS_JW + NW_JW + EN_JW + SE_JW, { strokeColor: "none", fillColor: "rgb(246,246,246)", fillOpacity:1, strokeOpacity: 0.5 }); //建立多边形覆盖物
            //
            // bm.addOverlay(ply1);
            //5. 给目标行政区划添加边框，其实就是给目标行政区划添加一个没有填充物的遮罩层
            var ply = new BMap.Polygon(rs.boundaries[0], { strokeWeight: 2, strokeColor: "#00f",fillColor: "" });
            bm.addOverlay(ply);
            //map.setViewport(ply.getPath());    //调整视野
        });

    });
</script>

<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try {
                ace.settings.check('breadcrumbs', 'fixed')
            } catch (e) {
            }
        </script>
        <ul class="breadcrumb">
            <h3>欢迎来到 山洪灾害监测预警移动查询系统</h3>
        </ul>
    </div>

    <div class="page-content">
        <div class="monitor-map-area" id="monitor-map-area" style="height: 750px;"></div>
    </div><!-- /.page-content -->

</div><!-- /.main-content -->
</body>
</html>
