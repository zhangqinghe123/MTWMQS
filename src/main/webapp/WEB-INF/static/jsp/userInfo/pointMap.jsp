<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>
<body>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=zsKT6hGm3BYL65E9DmFyqTNGC90ojzaj"></script>
<script type="text/javascript">
    $(function ($) {
        //地图初始化
        var bm = new BMap.Map("monitor-map-area");//41.818798   123.44835
        var point = new BMap.Point("123.44835", "41.818798");
        bm.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
        bm.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
        bm.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
        bm.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
        bm.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
        var myIconpq = new BMap.Icon(basePath + "/resources/css/images/position.png", new BMap.Size(32, 40), {imageOffset: new BMap.Size(0, 10)});
        var point=new BMap.Point($("#longitude").val(), $("#latitude").val());
        bm.centerAndZoom(point, 19);
        var marker=new BMap.Marker(point,{icon: myIconpq});
        bm.addOverlay(marker)

    });
</script>

<input type="hidden" value="${longitude}" id="longitude">
<input type="hidden" value="${latitude}" id="latitude">
<div class="monitor-map-area" id="monitor-map-area" style="height: 650px;"> </div>
<script>
    $("#closeDialog").on("click",function(){
        var myDialog = window.dialogModal["my_customer_dialog"];
        myDialog.close();
    });
</script>
</body>
</html>
