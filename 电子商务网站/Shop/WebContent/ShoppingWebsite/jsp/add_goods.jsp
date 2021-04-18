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
<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/add_goods.css">
</head>

<body>
	<form action="/Shop/ShopServlet" method="post">
	<div class="card">
		<div class="card-left"><img src="" class="image" id="image"><br>商品图片地址：<input type="text" id="img" name="img" onchange="get()"/></div>
		<div class="card-right">
			<div class="title">大体类型：
			<select name="type" class="op">
				<option value="数码">数码</option>
				<option value="家电">家电</option>
				<option value="服饰">服饰</option>
				<option value="食品">食品</option>
			</select></div>
			<div class="title">具体类型：<input name="concrete_type" value=""/></div>
			<div class="title">商品名称：<input name="name" value=""/></div>
			<p class="text">商品信息：</p>
			<div class="title"><textarea rows="10" cols="34" name="message" class=""></textarea></div>
			<div class="title">商品单价：<input name="price" value="" class=""/></div>
			<div class="title">增加库存：<input name="addnum"/></div>
				<input name="select" value="addGoods" type="hidden">
			<input type="submit" value="提交"  class="bt"/>
		</div>
	</div>
	</form>
</body>
<script type="text/javascript">
function get(){ 
	var input = document.getElementById("img").value; 
    document.getElementById("image").src=input;
} 
</script>
</html>