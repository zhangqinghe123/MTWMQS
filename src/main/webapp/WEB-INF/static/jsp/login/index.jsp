<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<script type="text/javascript"
        src="http://api.map.baidu.com/getscript?v=2.0&ak=sA85emPOmdhtikFDCmEq1uRaWV2qI5F5"></script>
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
        bm.centerAndZoom(point, 14);
        // var marker=new BMap.Marker(point,{icon: myIconpq});
        // bm.addOverlay(marker)

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
