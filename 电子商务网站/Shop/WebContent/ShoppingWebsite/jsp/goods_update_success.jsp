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
<p style="font-size:30px;">修改商品信息成功!</p>
<a href="/Shop/Goods_message_servlet?gno=<%=gno %>">返回商品页面</a>
</body>
</html>