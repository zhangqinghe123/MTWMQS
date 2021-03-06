<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>
<body>
<script type="text/javascript">
    $(function ($) {
        //地图初始化
        var bm = new BMap.Map("monitor-map-area");//41.818798   123.44835
        var point = new BMap.Point("120.395463", "41.503167");
        bm.centerAndZoom(point, 14);
        bm.enableScrollWheelZoom();   //启用滚轮放大缩小，默认禁用
        bm.enableContinuousZoom();    //启用地图惯性拖拽，默认禁用
        bm.addControl(new BMap.NavigationControl());               // 添加平移缩放控件
        bm.addControl(new BMap.ScaleControl());                    // 添加比例尺控件
        bm.addControl(new BMap.OverviewMapControl());              //添加缩略地图控件
        var myIconpq = new BMap.Icon(basePath + "/resources/css/images/pq.png", new BMap.Size(32, 40), {imageOffset: new BMap.Size(0, 10)});
        var myIconpz = new BMap.Icon(basePath + "/resources/css/images/pz.png", new BMap.Size(32, 40), {imageOffset: new BMap.Size(0, 10)});
        function showMap() {
            $.ajax({
                url: basePath + "admin/userInfo/findMapPoint",
                data: {
                    userId:$("#userId").val(),
                    startTime:$("#startTime").val()
                },
                type: 'POST',
                success: function (data) {
                    if (data.errCode == 0) {
                        var list = data.data;
                        var orderMap = list["orderList"];
                        var polyline;
                        var linePoints = [];//数组
                        var marker;
                        for (var i=0;i<orderMap.length;i++) {
                            var point=new BMap.Point(orderMap[i].lng, orderMap[i].lat);
                            if (i==0){
                                bm.centerAndZoom(point, 14);
                                marker=new BMap.Marker(point,{icon: myIconpq});
                                bm.addOverlay(marker);
                            }
                            if (i==orderMap.length-1){
                                marker=new BMap.Marker(point,{icon: myIconpz});
                                bm.addOverlay(marker);
                            }
                            linePoints.push(point);
                        }
                        polyline = new BMap.Polyline(linePoints, {strokeColor:"blue", strokeWeight:6, strokeOpacity:0.5});
                        bm.addOverlay(polyline);
                    } else {
                        apus.ui.toastr.error("获取失败，错误信息：" + data.message);
                    }
                },
                error: function (e) {
                    apus.ui.toastr.error("获取失败");
                },
            });
        }
        $("#showMap").on('click', function () {
            showMap();
        });
        function getNowFormatDate() {
            var date = new Date();
            var seperator1 = "-";
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var strDate = date.getDate();
            if (month >= 1 && month <= 9) {
                month = "0" + month;
            }
            if (strDate >= 0 && strDate <= 9) {
                strDate = "0" + strDate;
            }
            var currentdate = year + seperator1 + month + seperator1 + strDate;
            return currentdate;
        }
        $("#startTime").val(getNowFormatDate());
        $.ajax({
            url: basePath + "admin/userInfo/getUserFence",
            data: {
                userId:$("#userId").val(),
            },
            type: 'POST',
            success: function (data) {
                if (data.errCode == 0) {
                    var localStorage = data.data.split(";");;
                    var arrPolygon = new Array();
                    for (var i = 0; i < localStorage.length; i++) {
                        var location = localStorage[i].split(",");
                        arrPolygon.push(new BMap.Point(location[1], location[0]));
                    }
                    var hPolygon = new BMap.Polygon(arrPolygon, {strokeColor:"blue", strokeWeight:2, strokeOpacity:0,fillColor:""});//添加多边形到地图上
                    bm.addOverlay(hPolygon);//给多边形添加鼠标事件
                }
            },
            error: function (e) {
                apus.ui.toastr.error("获取失败");
            },
        });
    });
</script>
<input name="startTime" id="startTime" class="Wdate" onClick="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'})" />-
<span class="btn btn-primary btn-sm query_btn" id="showMap" name="showMap">搜索</span>
<input type="hidden" value="${userId}" id="userId">
<div class="monitor-map-area" id="monitor-map-area" style="height: 650px;"> </div>
<script>
    $("#closeDialog").on("click",function(){
        var myDialog = window.dialogModal["my_customer_dialog"];
        myDialog.close();
    });
</script>
</body>
</html>
