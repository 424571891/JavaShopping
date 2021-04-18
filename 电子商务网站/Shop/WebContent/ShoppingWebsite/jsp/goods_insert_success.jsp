<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String gno=(String)request.getAttribute("gno");
%>
<p style="font-size:30px;">上架商品成功!</p>
<a href="/Shop/Goods_show_servlet?goods_type=shuma">返回商品页面</a>
</body>
</html>