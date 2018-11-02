<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp" %>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=sA85emPOmdhtikFDCmEq1uRaWV2qI5F5"></script>
<script type="text/javascript">
    $(function ($) {
        //地图初始化
        var bm = new BMap.Map("monitor-map-area");//41.818798   123.44835
        var point = new BMap.Point("123.44835", "41.818798");
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
                    userId:$("select[name='userId'] option:selected").val(),
                    startTime:$("#startTime").val(),
                    endTime:$("#endTime").val()
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
                    <form class="form-horizontal" role="form" id="selectForm" modelAttribute="form">
                        <div class="control-group">
                            <div class="input-control">
                                <select name="userId" style="width: 100px">
                                    <option value="">请选择用户</option>
                                    <c:forEach items="${userList}" var="z" varStatus="s">
                                        <option value="${z.id}">${z.userName}</option>
                                    </c:forEach>
                                </select>
                                <input name="startTime" id="startTime" class="Wdate" onClick="WdatePicker({startDate:'%y-%M-%d 00:00:00',dateFmt:'yyyy-MM-dd HH:mm:ss'})" />-
                                <input name="endTime" id="endTime" class="Wdate" onClick="WdatePicker({startDate:'%y-%M-%d 23:59:59',dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startTime\')}'})" />
                                <span class="btn btn-primary btn-sm query_btn" id="showMap" name="showMap">搜索</span>
                            </div>
                        </div>
                    </form>
                    <div class="monitor-map-area" id="monitor-map-area" style="height: 750px;"> </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp" %>