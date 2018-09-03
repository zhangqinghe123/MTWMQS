<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>

       <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>

                        <a href="#">首页</a>
                    </li>
                    <li class="active">控制台</li>
                </ul><!-- .breadcrumb -->
            </div>

           <div class="page-content">
               <div class="row">
                   <div class="col-xs-12">
                       <!-- 内容开始 -->
                       <h3>你好!欢迎来到“沈阳鼎骏”网络约车管理系统 </h3>
                       <!-- 内容介绍-->
                   </div><!-- /.col -->
               </div><!-- /.row -->
           </div><!-- /.page-content -->

            <%--<div class="page-content">--%>
                <%--<div class="row">--%>
                    <%--<div class="col-xs-12 console-page">--%>
                        <%--<!-- 内容开始 -->--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">出租车概况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>在线车辆</p>--%>
                                        <%--<p>12</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日订单数</p>--%>
                                        <%--<p>89</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日收入</p>--%>
                                        <%--<p>16230</p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">专车概况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>在线车辆</p>--%>
                                        <%--<p>12</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日订单数</p>--%>
                                        <%--<p>89</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日收入</p>--%>
                                        <%--<p>16230</p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>

                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">跨城车概况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>在线车辆</p>--%>
                                        <%--<p>12</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日订单数</p>--%>
                                        <%--<p>89</p>--%>
                                    <%--</div>--%>
                                    <%--<div class="col-sm-4">--%>
                                        <%--<p>今日收入</p>--%>
                                        <%--<p>16230</p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">--%>
                                    <%--出租车收入--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"><span class="line">~</span>--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">--%>
                                <%--</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="chart-area" id="chart-area1"></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">专车收入--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"><span class="line">~</span>--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">--%>
                                <%--</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="chart-area" id="chart-area2"></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">跨城车收入--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"><span class="line">~</span>--%>
                                    <%--<input name="startTime"  class="Wdate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})">--%>
                                <%--</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="chart-area"  id="chart-area3"></div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <%--<div class="row">--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">出租车运营情况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="num-area">--%>
                                        <%--<p>昨日出车数<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">120344</span></p>--%>
                                        <%--<p>昨日订单数<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">25574</span></p>--%>
                                        <%--<p>昨日好评数<span class="none-txt">--</span> <span class="nums">23574</span></p>--%>
                                        <%--<p>出车率<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">51765</span></p>--%>
                                        <%--<p>接单率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">7777777</span></p>--%>
                                        <%--<p>好评率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">447878</span></p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">专车运营情况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="num-area">--%>
                                        <%--<p>昨日出车数<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">120344</span></p>--%>
                                        <%--<p>昨日订单数<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">25574</span></p>--%>
                                        <%--<p>昨日好评数<span class="none-txt">--</span> <span class="nums">23574</span></p>--%>
                                        <%--<p>出车率<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">51765</span></p>--%>
                                        <%--<p>接单率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">7777777</span></p>--%>
                                        <%--<p>好评率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">447878</span></p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                            <%--<div class="col-sm-4 data-unit">--%>
                                <%--<p class="title">跨城车运营情况</p>--%>
                                <%--<div class="data-list">--%>
                                    <%--<div class="num-area">--%>
                                        <%--<p>昨日出车数<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">120344</span></p>--%>
                                        <%--<p>昨日订单数<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">25574</span></p>--%>
                                        <%--<p>昨日好评数<span class="none-txt">--</span> <span class="nums">23574</span></p>--%>
                                        <%--<p>出车率<span class="down-txt"><i class="icon-long-arrow-down"></i>1.3%</span> <span class="nums">51765</span></p>--%>
                                        <%--<p>接单率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">7777777</span></p>--%>
                                        <%--<p>好评率<span class="up-txt"><i class="icon-long-arrow-up"></i>1.3%</span> <span class="nums">447878</span></p>--%>
                                    <%--</div>--%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>


                        <%--<!-- 内容介绍-->--%>
                    <%--</div><!-- /.col -->--%>
                <%--</div><!-- /.row -->--%>
            <%--</div><!-- /.page-content -->--%>
        </div><!-- /.main-content -->
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>
<script src="${basePath}resources/js/highcharts/highcharts.js"></script>
<script src="${basePath}resources/js/highcharts/exporting.js"></script>

<script type="text/javascript">
    $('#chart-area1').highcharts({
        credits:{
            enabled:false // 禁用版权信息
        },
        exporting:false,
        chart: {
            type: 'line'
        },
        title: {
            text: ''
        },
        yAxis: {
            lineWidth: 1,
            tickWidth: 1,
            title:''
        },
        xAxis: {
            categories: ['10-26', '10-27', '10-28', '10-29', '10-30', '10-31']
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            data: [120, 240, 180, 200, 150, 90],
            showInLegend: false
        }]
    });
    $('#chart-area2').highcharts({
        credits:{
            enabled:false // 禁用版权信息
        },
        exporting:false,
        chart: {
            type: 'line'
        },
        title: {
            text: ''
        },
        yAxis: {
            lineWidth: 1,
            tickWidth: 1,
            title:''
        },
        xAxis: {
            categories: ['10-26', '10-27', '10-28', '10-29', '10-30', '10-31']
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            data: [120, 240, 180, 200, 150, 90],
            showInLegend: false
        }]
    });
    $('#chart-area3').highcharts({
        credits:{
            enabled:false // 禁用版权信息
        },
        exporting:false,
        chart: {
            type: 'line'
        },
        title: {
            text: ''
        },
        yAxis: {
            lineWidth: 1,
            tickWidth: 1,
            title:''
        },
        xAxis: {
            categories: ['10-26', '10-27', '10-28', '10-29', '10-30', '10-31']
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            data: [120, 240, 180, 200, 150, 90],
            showInLegend: false
        }]
    });
</script>


