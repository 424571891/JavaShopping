<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
<%@ page import="Dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/order.css">
</head>
<body>


<%
String state=(String)request.getAttribute("state");
List<Order> list=(List<Order>)request.getAttribute("order_list");
OrderDao dao = new OrderDao();
LoginDao dao_c=new LoginDao();
Goods_message_Dao dao_2 = new Goods_message_Dao();
if(list==null||list.size()<1){
	out.print("没有订单信息！");
}
else{
	for(Order g: list){
		//String no = g.getGno();
		Customer customer = dao_c.InitCustomerMessage(g.getCno());
		%>
		<form action="/Shop/OrderMerchantServlet" method="post">
		<div style="border:1px solid red; background:#d2d2d2; margin-bottom:50px; padding-bottom:60px;">
			<h2>订单介绍：</h2>
			<div class="card-item"> 
			<p>订单编号：<%=g.getOno()%></p>
			<p>下单时间：<%=g.getOtime_create()%></p>
			<p>完成时间：<%=g.getOtime_complete()%></p>
			<p>状态：<%=g.getOstatus()%></p>
			<p>总金额：<%=g.getOprice()%></p>
			</div>
			<h2>顾客信息：</h2>
			<div class="card-item"> 
			<p>顾客姓名：<%=customer.getCname() %></p>
			<p>顾客电话：<%=customer.getCtel() %></p>
			<p>收货地址：<%=customer.getCaddress() %></p>
			</div>
			<h2>订单详情：</h2>
		<% 
		List<ODetail> odetailList = dao.getODetailList(g.getOno());
		for(ODetail g_2: odetailList ){
			Goods g_3 = dao_2.getGoodsMessage(g_2.getGno());
			%>
			<div class="card">
			<div class="card-right">
				<div class="card-right-1"><img src="<%=g_3.getGimage()%>" class="image"></div>
				<div class="card-right-2"><p><%=g_3.getGname()%></p></div>
			
			<div class="card-right-3">	<p><%=g_3.getGprice()%></p></div>
			<div class="card-right-4">	<p><%=g_2.getODnum()%></p></div>
				<!-- <p>商品总价：<%=g_2.getODprice()%></p> -->
				</div>
			</div>
			<% 
		}//for
		%>
		
		<div class="card-bottom">
		<% 
			if(state.equals("daifahuo")){
				%>
				<input type="submit" value="发货处理"/ class="bt">
				<% 
			}%>
		</div>
		
		</div>
		<input type="hidden" name="hidden_ono" value="<%= g.getOno()%>">                   <!--  订单号-->
		
		
		</form>
		<%
	}//for
}
%>

</body>
</html>