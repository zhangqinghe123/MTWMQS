<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/static/jsp/include/header.jsp"%>
<script type="text/javascript" src="<c:url value="${basePath}resources/js/ajaxfileupload.js" />"></script>
<div class="main-content">
    <div class="breadcrumbs" id="breadcrumbs">
        <script type="text/javascript">
            try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
        </script>

        <ul class="breadcrumb">
            <li>乘客服务中心</li>
            <li>乘客通知管理</li>
            <li>新建/编辑通知</li>
        </ul><!-- .breadcrumb -->
    </div>

    <div class="page-content">
        <div class="row">
            <div class="col-xs-12">
                <!-- 内容开始 -->
                <form class="form-horizontal" role="form" id="noticeForm" modelAttribute="form" >
                    <input name="id" value="${info.id}" type="hidden">
                    <input name="isShare" value="0" type="hidden">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">推送类型：</label>
                        <div class="col-sm-9">
                            <div class="radio">
                                <label>
                                    <input  type="radio" name="pushType" value="1" class="ace" <c:if test="${info.id !=null}" >disabled</c:if> <c:if test="${info.url  == ''}" >checked</c:if>/>
                                    <span class="lbl">文本消息</span>
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input  type="radio" name="pushType" value="2" class="ace" <c:if test="${info.id !=null}" >disabled</c:if> <c:if test="${info.url  != ''}" >checked</c:if>/>
                                    <span class="lbl"> 链接消息</span>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="space-4"></div>


                    <div class="textDiv <c:if test="${info.url  != ''}" >hidden</c:if>">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" >消息内容：</label>
                            <div class="col-sm-9">
                                <textarea type="text" cols="55" rows="5" name="content"  data-rule-required="true"  data-rule-maxlength="611">${info.content}</textarea>
                            </div>
                        </div>
                    </div>
                    <div class="linkDiv <c:if test="${info.url  == ''}" >hidden</c:if>">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">活动名称：</label>

                            <div class="col-sm-9">
                                <input type="text" name="title" data-rule-required="true" data-rule-maxlength="20" value="${info.title}"  />
                            </div>
                        </div>

                        <div class="space-4"></div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right"> 活动图片：</label>

                            <div class="col-sm-9">
                                <input class="upfile-img myFile" type="file" name="file" id="myFile">
                                <div  class="<c:if test="${info.pic == ''}">hidden</c:if> picShow"><img style="padding-top: 15px" width="120px" src="${info.pic}" ></div>
                                <input type="hidden" name="pic" value="${info.pic}">
                            </div>
                        </div>

                        <div class="space-4"></div>

                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right" >跳转链接：</label>
                            <div class="col-sm-9">
                                <textarea type="text" cols="50" rows="5" name="url" data-rule-required="true"  data-rule-maxlength="255">${info.url}</textarea>
                            </div>
                        </div>
                        <div class="space-4"></div>
                    </div>

                <%--    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" >获取用户信息：</label>
                        <div class="col-sm-9">
                            <select name = "isShare">
                                <option value="0">否</option>
                                <option value="1">是</option>
                            </select>
                        </div>
                    </div>--%>

                    <div class="space-4"></div>
                    <div class="clearfix form-actions">
                        <div class="col-md-offset-3 col-md-9">
                            <a class="btn btn-info qz_save_btn" >
                                <i class="icon-ok bigger-110"></i>
                                <span>提交</span>
                            </a>

                            &nbsp;
                            <a class="btn" href="${basePath}admin/message/index">
                                <i class="icon-undo bigger-110"></i>
                                返回
                            </a>
                        </div>
                    </div>
                </form>

                <!-- 内容介绍-->
            </div><!-- /.col -->
        </div><!-- /.row -->
    </div><!-- /.page-content -->
</div><!-- /.main-content -->
<script type="text/javascript" src="<c:url value="${basePath}resources/js/admin/message/form.js" />"></script>
<%@ include file="/WEB-INF/static/jsp/include/footer.jsp"%>
