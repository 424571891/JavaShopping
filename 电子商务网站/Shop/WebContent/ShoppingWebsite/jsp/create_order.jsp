<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
    
<!DOCTYPE html>
<html>

<script>

</script>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=""></script>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/order_merchant.css">
</head>
<body>
<div style="border:1px solid red; background:#d2d2d2; margin-bottom:30px; padding-bottom:60px;">
<h2>收货地址</h2>
<%
Customer customer = (Customer)session.getAttribute("Customer");
%>
<p>收货地址：<%= customer.getCaddress()%></p>
<h2>商品详情：</h2>
<form action="OrderServlet" method="post" >
<%
double money=0;
List<SCDetail> list=(List<SCDetail>)request.getAttribute("check_list");
if(list==null||list.size()<1){
	out.print("没有商品信息！");
}
else{
	for(SCDetail g: list){
		//String no = g.getGno();
		money += g.getGoods().getGprice() * g.getSCDnum();
		%>
		
		<div class="card">
		<div class="card-right">
		<div class="card-right-1"><img src="<%=g.getGoods().getGimage()%>" class="image"></div>
		<div class="card-right-2"><%=g.getGoods().getGname()%></div>
		<div class="card-right-3"><%=g.getGoods().getGprice()%></div>
		<div class="card-right-4"><%=g.getSCDnum()%></div>
		</div>
		</div>
		<input name="check" type="hidden" value="<%=g.getSCDno()%>"/>
		<% 
	}
}
%>
<br>
<p style="font-size:30px;">总金额：<%=money %></p>
<input type="hidden" value="<%=money%>" name="money"/>
	<div class="card-bottom">
		<input type="submit" value="点击付款"/ class="bt">
	</div>
	
</form>
</div>
</body>

</html>