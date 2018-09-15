<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    pageContext.setAttribute("basePath", basePath);
%>
<body>


<input type="hidden" value="${recordId}" id="recordId">
<img id="pic" src="" width="995px" >

<script>
    var srcPath = basePath + 'admin/userInfo/getPatrolPic?patrolRecordId=' + $("#recordId").val()
    $("#pic").attr("src", srcPath)
    $("#closeDialog").on("click",function(){
        var myDialog = window.dialogModal["my_customer_dialog"];
        myDialog.close();
    });
</script>
</body>
</html>
