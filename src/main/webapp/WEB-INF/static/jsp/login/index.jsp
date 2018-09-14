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


