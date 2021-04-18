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
Merchant merchant = (Merchant)session.getAttribute("Merchant");
String name = merchant.getMname();
String tel = merchant.getMtel();
if(tel==null){
	tel="";
}
if(name==null){
	tel="";
}
%>

<div class="all">
<form action="/Shop/MeServlet" method="post">	
姓名：<input name="name"  value="<%= name %>"><br>
电话：<input name="tel" value="<%=tel %>"><br>
<input type="hidden" name="select" value="perfectMe_merchant">
<input type="submit" value="提交">
</form>
</div>
</body>
</html>