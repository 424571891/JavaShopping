<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
<%@ page import="Dao.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To MobiePhone</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/goods_message.css">
</head>
<%
if(session.getAttribute("Merchant")!=null){ %>
	<%@ include file="../html/header_merchant.html" %>
<% }else{ %>
	<%@ include file="../html/header.html" %>
<% }%>

<body>
<%
Goods_message_Dao dao = new Goods_message_Dao();
Goods g=(Goods)request.getAttribute("goods");
if(g==null){
	out.print("没有商品信息！");
}else if(session.getAttribute("Merchant") != null){
	Stock s = dao.getGoodsStock(g.getGno());
	%>
	<form action="/Shop/ShopServlet" method="post">
		<div class="card">
			<div class="card-left"><img src="<%=g.getGimage()%>" class="image"></div>
			<div class="card-right">
			<p class="title"><%=g.getGname()%></p>
			<p class="title_left"><%=g.getGmessage()%></p>
			<p class="price"><%=g.getGprice()%>元</p>
			<p class="title_2"><%=s.getSTsales_num() %>人已购买</p>
			<p class="title_2">剩余 <%=s.getSTnum() %> 件</p>
			<input name="select" value="updateGoods" type="hidden">
			<a href="/Shop/ShoppingWebsite/jsp/updateGoods.jsp?gno=<%=g.getGno()%>" style="text-decoration:none;">修改商品信息</a>
			</div>
		</div>
	</form>
	<% 
}else{
		Stock s = dao.getGoodsStock(g.getGno());
		if(("G001").equals(g.getGno())){
			%>
			<div><img src="/Shop/ShoppingWebsite/image/1.jpg" style="width:40%; height:800px;float:left;">
			<img src="/Shop/ShoppingWebsite/image/2.jpg" style="width:60%; height:800px; float:left;">
			</div>
			<% 
		}
		%>
		<form action="/Shop/CartServlet" method="post">
		<div class="card">
			<div class="card-left"><img src="<%=g.getGimage()%>" class="image"></div>
			<div class="card-right">
			<p class="title"><%=g.getGname()%></p>
			<p class="title_left"><%=g.getGmessage()%></p>
			<p class="price"><%=g.getGprice()%>元</p>
			<p class="title_2"><%=s.getSTsales_num() %>人已购买</p>
			<p class="title_2">剩余 <%=s.getSTnum() %> 件</p>
			<input name="gno" value="<%=g.getGno()%>" type="hidden"/>
			<input name="select" value="addCart" type="hidden">
			<input type="submit" value="加入购物车" class="bt"/>
			</div>
		</div>
		</form>
		<% 
}
%>
</body>


</html>