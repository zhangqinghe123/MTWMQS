<%--
  Created by IntelliJ IDEA.
  User: SummerSoft
  Date: 2016/4/7
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>Java API for WebSocket (JSR-356)</title>
</head>
<body>
<script type="text/javascript" src="${basePath}jquery-2.0.3.min.js"></script>
<script type="text/javascript" src="${basePath}sockjs-0.3.min.js"></script>
<script type="text/javascript">
    var websocket = null;
    if ('WebSocket' in window) {
        websocket = new WebSocket("wss://www.djrentcar.com/taxi/api/webSocketServer?token=03f2fdcae50a87e1416643cc222dedb1&key=748608cf3ce28aef747596210761f900e07c65ef4b3947840deacdc1c30f06e7");
    }
    websocket.onopen = onOpen;
    websocket.onmessage = function(evt) {
    	alert(evt.data);
    }
    websocket.onerror = onError;
    websocket.onclose = function(evt) {
    	alert("onClose");
    }
    function onOpen(openEvt) {
        alert(11);
    }
    function onError() {
    	alert("onError");
    }
    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = document.getElementById("inputMsg").value;
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");
        } else {
            alert("连接失败!");
        }
    }
</script>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend();">发送</button>
</body>
</html>
