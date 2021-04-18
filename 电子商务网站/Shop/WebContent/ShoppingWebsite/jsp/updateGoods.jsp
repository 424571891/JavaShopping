<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
<%@ page import="Dao.*" %>
<%@ include file="../html/header_merchant.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To MobiePhone</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/updateGoods.css">
</head>

<body>
<%
Goods_message_Dao dao = new Goods_message_Dao();
String gno=request.getParameter("gno");
Goods g = dao.getGoodsMessage(gno);
Stock s = dao.getGoodsStock(gno);
	%>
	<form action="/Shop/ShopServlet" method="post">
	<div class="card">
		<div class="card-left"><img src="<%=g.getGimage()%>" class="image"></div>
		<div class="card-right">
			<div class="title">商品名称：<input name="name" value="<%=g.getGname()%>"/></div>
			<p class="text">商品信息：</p>
			<div class="title"><textarea rows="10" cols="34" name="message" class=""><%=g.getGmessage()%></textarea></div>
			<div class="title">商品单价：<input name="price" value="<%=g.getGprice()%>" class=""/></div>
			<div class="title">商品库存：<%=s.getSTnum()%></div>
			<div class="title">增加库存：<input name="addnum"/></div>
				<input name="gno" value="<%=g.getGno()%>" type="hidden"/>
				<input name="select" value="updateGoods" type="hidden">
			<input type="submit" value="提交"  class="bt"/>
		</div>
	</div>
	</form>
	
</body>

</html>