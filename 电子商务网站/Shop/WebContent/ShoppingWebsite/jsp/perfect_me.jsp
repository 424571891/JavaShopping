<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
.all{
	width:30%;
	margin-left:auto;
	margin-right:auto;
	margin-top:100px;	
	font-size:25px;
}
</style>
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

<div class="all">
<form action="/Shop/MeServlet" method="post">	
姓名：<input name="name"  value="<%= customer.getCname()%>"><br>
性别：<input name="sex" value="<%= sex%>"><br>
电话：<input name="tel" value="<%=tel %>"><br>
收货地址：<input name="address" value="<%=address %>"><br>
账户余额：<input name="balance" value="<%= customer.getCbalance()%>"><br>
<input type="hidden" name="select" value="perfectMe">
<input type="submit" value="提交">
</form>
</div>
</body>
</html>