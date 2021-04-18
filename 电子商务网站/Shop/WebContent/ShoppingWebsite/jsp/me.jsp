<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*" %>
<%@ include file="../html/header.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/me.css">
</head>
<body>


<%
Customer customer = (Customer)session.getAttribute("Customer");
String address = customer.getCaddress();
String tel = customer.getCtel();
String sex=customer.getCsex();
if(address == null){
	address="";
}
if(tel==null){
	tel="";
}
if(sex==null){
	sex="";
}
%>
<div class="card">

<div class="card-left">
<a href="/Shop/ShoppingWebsite/jsp/perfect_me.jsp">修改个人信息</a>
<br>
<a href="/Shop/ShoppingWebsite/jsp/order.jsp">查看订单</a>
<br>
<a href="/Shop/OutServlet">退出登录</a>
</div>

<div class="card-right"> 
<div class="card-right-item">
姓名：<%= customer.getCname()%><br>
性别：<%= sex%><br>
电话：<%= tel%><br>
收货地址：<%= address%><br>
账户余额：<%= customer.getCbalance()%><br>
</div>
</div>

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

function toIndex(){
	window.location.href = "/Shop/ShoppingWebsite/jsp/index.jsp";
}

function toCart(){
	window.location.href = "/Shop/CartServlet";
}

function toMe(){
	window.location.href = "/Shop/MeServlet";
}

function toSearch(){
	window.location.href = "/Shop/Goods_message_servlet?gno=G001";
}

document.getElementById("piglogo").onclick = toIndex;
document.getElementById("cartlogo").onclick = toCart;
document.getElementById("melogo").onclick = toMe;
document.getElementById("search").onclick = toSearch;

</script>

</html>