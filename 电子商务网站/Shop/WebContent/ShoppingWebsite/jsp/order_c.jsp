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
Customer c=(Customer)session.getAttribute("Customer");
OrderDao dao = new OrderDao();
Goods_message_Dao dao_2 = new Goods_message_Dao();
if(list==null||list.size()<1){
	out.print("没有订单信息！");
}
else{
	for(Order g: list){
		//String no = g.getGno();
		%>
		<form action="/Shop/OrderServlet?sub=complete" method="post">
		<div style="border:1px solid red; background:#d2d2d2; margin-bottom:30px ; padding-bottom:60px;">
		
		<h2>订单介绍：</h2>

			<div class="card-item">
			<p>订单编号：<%=g.getOno()%></p>
			<p>下单时间：<%=g.getOtime_create()%></p>
			<p>完成时间：<%=g.getOtime_complete()%></p>
			<p>状态：<%=g.getOstatus()%></p>
			<p>总金额：<%=g.getOprice()%></p>
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
		<div class="card-right-2"><%=g_3.getGname()%></div>
		<div class="card-right-3"><%=g_3.getGprice()%></div>
		<div class="card-right-4"><%=g_2.getODnum()%></div>
		</div>
		</div>
			<% 
		}//for
		%>
			<div class="card-bottom">
			<% 
			if(state.equals("daishouhuo")){
				%>
				<input type="submit" value="确认收货"/ class="bt">
				<input type="hidden" name="hidden_bt" value="shouhuo">
				<% 
			}else if(state.equals("daifahuo")){
			%>
				<input type="" value="取消订单"/ class="bt">
					<input type="hidden" name="hidden_bt" value="quxiao">
			<% 
			}else if(state.equals("complete")){
				%>
				<input type="" value="投诉订单"/ class="bt" >
				<% 
			}
			%>
		</div>
		</div>
		<input type="hidden" name="hidden_ono" value="<%= g.getOno()%>">                   <!--  订单号-->
		</form>
		<%
	}//for
}
%>


</body>
<script>
function toTousu(cno,ono){
	window.location.href="/Shop/ShoppingWebsite/jsp/complaint.jsp?cno="+cno+"&ono="+ono;
}
</script>
</html>