<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
<%@ page import="Dao.*"%>
<%@ include file="../html/header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/order.css">
</head>

<body>

<div class="nav">
<div class="nav_a"><a href="/Shop/OrderServlet?select=daifahuo" target="c">待发货</a></div>
<div class="nav_a"><a href="/Shop/OrderServlet?select=daishouhuo" target="c">待收货</a></div>
<div class="nav_a"><a href="/Shop/OrderServlet?select=complete" target="c">已完成</a></div>
</div>

<div style="width:100%;">
<iframe src="/Shop/OrderServlet?select=daifahuo" frameborder="0" scrolling="no" width="100%" onload="setIframeHeight(this)" name="c"></iframe>
</div>


</body>

<script>
function setIframeHeight(iframe) {
	if (iframe) {
	var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
	if (iframeWin.document.body) {
	iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
	}
	}
	};
</script>
</html>