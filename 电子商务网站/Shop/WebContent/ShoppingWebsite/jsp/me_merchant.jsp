<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*" %>
<%@ include file="../html/header_merchant.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/me.css">
</head>
<body>


<%
Merchant merchant = (Merchant)session.getAttribute("Merchant");
String tel = merchant.getMtel();
if(tel==null){
	tel="";
}
%>
<div class="card">

<div class="card-left">
<a href="/Shop/ShoppingWebsite/jsp/perfect_me_merchant.jsp">修改个人信息</a>
<br> 
<a href="/Shop/ShoppingWebsite/jsp/add_goods.jsp">上架商品</a>
<br>
<a href="/Shop/OutServlet">退出登录</a>
</div>

<div class="card-right"> 
<div class="card-right-item">
姓名：<%= merchant.getMname()%><br>
电话：<%= tel%><br>
</div>
</div>

</div>

</body>
</html>