<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="Bean.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gold Pig Shop</title>
<link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>

<div id="head_head">
<p>范由我生，寻靓生活—金猪网, 一个值得让你囊中羞涩的好商城!</p>
<!-- <p>Gold Pig商城，买啥都靠谱!</p>-->
</div>

<div id="all">

<div id="head">
<div class="pig_logo" id="piglogo">
<img src="../image/pig_before.png" class="pig_before"/>
<img src="../image/pig_after.png" class="pig_after"/>
</div>
<div class="se">
<input name="search" type="search" class="search" value="明星同款"/>
<div class="search_logo">
<input type="image" src="../image/search_before.png" class="search_before"/>
<input type="image" src="../image/search_after.png" class="search_after"/>
</div>
</div>

<div class="cart" id="melogo">
<div class="cart_logo">
<input type="image" src="../image/me_before.png" class="cart_before"/>
<input type="image" src="../image/me_after.png" class="cart_after"/>
</div>
<p class="cart_text">个人中心</p>
</div>


<div class="cart" id="cartlogo">
<div class="cart_logo">
<input type="image" src="../image/cart_before.png" class="cart_before"/>
<input type="image" src="../image/cart_after.png" class="cart_after"/>
</div>
<p class="cart_text">订单管理</p>
</div>

</div><!-- head --><!-- ------------------------------------------------------------------- -->

<div id="middle">

<div id="left">


<!-- a -->
<div class="list" style="margin-top:40px;">
<div class="list_item">
<p class="list_item_text">数码</p>
</div><!-- list_item -->

<div class="list_a_content">

<div class="list_content_item" id="mobie">       <!-- ------------------------------------------ -->
<img src="../image/mobiePhone.png" class="list_content_img"/>
<p class="list_content_text">手机</p>
</div><!-- list_content_item-->

<div class="list_content_item">
<img src="../image/computer.png" class="list_content_img"/>
<p class="list_content_text">电脑</p>
</div><!-- list_content_item-->

</div><!-- list_a_content -->
</div><!-- list -->


<!-- b -->
<div class="list">
<div class="list_item">
<p class="list_item_text">家电</p>
</div><!-- list_item -->

<div class="list_b_content">

<div class="list_content_item">
<img src="../image/clothes.png" class="list_content_img"/>
<p class="list_content_text">洗衣机</p>
</div><!-- list_content_item-->

</div><!-- list_b_content -->
</div><!-- list -->


<!-- c -->
<div class="list">
<div class="list_item">
<p class="list_item_text">服饰</p>
</div><!-- list_item -->

<div class="list_c_content">

<div class="list_content_item">
<img src="../image/clothes.png" class="list_content_img"/>
<p class="list_content_text">衣服</p>
</div><!-- list_content_item-->

</div><!-- list_c_content -->
</div><!-- list -->

<!-- d -->
<div class="list">
<div class="list_item">
<p class="list_item_text">食品</p>
</div><!-- list_item -->

<div class="list_d_content">

<div class="list_content_item">
<img src="../image/clothes.png" class="list_content_img"/>
<p class="list_content_text">方便面</p>
</div><!-- list_content_item-->

</div><!-- list_d_content -->
</div><!-- list -->

</div><!-- left -->


<div id="center">
<img src="../image/center_img_1.png" class="center_img"/>
</div><!-- center -->


<!--  
<div id="right">

</div>
-->

</div><!-- middle --><!-- ------------------------------------------------------------------- -->

<div id="footer">
dilidili正版授权<br>
gava全球一点通语言正版授权
</div><!-- footer -->

</div><!-- all -->


<div id="float_left">
<div>

</div>
</div>
</body>

<script>
function toGoodsShow(){
	//window.location.href = "goods_show.jsp";
	//window.location.href = "/Shop/Goods_show_servlet";
	window.location.href = "/Shop/Goods_show_servlet?goods_type=shuma";
}

function toIndex(){
	window.location.href = "/Shop/ShoppingWebsite/jsp/index_merchant.jsp";
}

function toCart(){
	window.location.href = "/Shop/ShoppingWebsite/jsp/order_merchant.jsp";
}

function toMe(){
	window.location.href = "/Shop/MeServlet";
}

document.getElementById("mobie").onclick = toGoodsShow;
document.getElementById("piglogo").onclick = toIndex;
document.getElementById("cartlogo").onclick = toCart;
document.getElementById("melogo").onclick = toMe;
</script>

</html>




