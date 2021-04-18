<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
<%@ page import="Dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/goods_show.css">

</head>

<%
if(session.getAttribute("Merchant")!=null){ %>
	<%@ include file="../html/header_merchant.html" %>
<% }else{ %>
	<%@ include file="../html/header.html" %>
<% }%>

<body>
<div class="a">
<%
List<Goods> list=(List<Goods>)request.getAttribute("list");
Goods_message_Dao dao = new Goods_message_Dao();
if(list==null||list.size()<1){
	out.print("没有商品信息！");
}
else{
	for(Goods g: list){
		String no = g.getGno();
		Stock s = dao.getGoodsStock(no);
		%>
		<div class="card"  onclick="toGoodsMessage('<%=g.getGno()%>')">
			<div class="card-left"><img src="<%=g.getGimage()%>" class="image"></div>
			<div class="card-right">
			<p class="title"><%=g.getGname()%></p>
			<!-- <p>商品信息：<%=g.getGmessage()%></p> -->
			<p class="price"><%=g.getGprice()%>元</p>
			<p class="title_2"><%=s.getSTsales_num()%>人已购买</p>
			<!--  <p>库存：<%=s.getSTnum() %></p>-->
			<p class="title_3">立即抢购</p>
			</div>
		</div>
		<% 
	}
}
%>
</div>

</body>
<script>
function toGoodsMessage(no){
	//window.location.href = "goods_show.jsp";
	//window.location.href = "/Shop/Goods_show_servlet";
	window.location.href = "/Shop/Goods_message_servlet?gno=" + no;
}


function toGoodsShow(){
	//window.location.href = "goods_show.jsp";
	//window.location.href = "/Shop/Goods_show_servlet";
	window.location.href = "/Shop/Goods_show_servlet?goods_type=shuma";
}

</script>
</html>