<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.*" %>
   <%@ include file="../html/header.html" %>
<!DOCTYPE html>
<html>


<link rel="stylesheet" type="text/css" href="/Shop/ShoppingWebsite/css/shoppingCart.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src=""></script>
</head>
<body>


<form action="CartServlet" method="post" name="form1">
<%
List<SCDetail> list=(List<SCDetail>)request.getAttribute("cart_list");
if(list==null||list.size()<1){
	out.print("没有商品信息！");
}
else{
	for(SCDetail g: list){
		//String no = g.getSCDno();
		%>
		<div class="card">
		<div class="card-left">
			<input name="check" type="checkbox" value="<%=g.getSCDno()%>" class="cc"/>
		</div>
		<div class="card-right">
			<div class="card-right-1"><img src="<%=g.getGoods().getGimage()%>" class="image"></div>
			<div class="card-right-2"><%=g.getGoods().getGname()%></div>
			<div class="card-right-3"><%=g.getGoods().getGprice()%></div>
			<div class="card-right-4"><%=g.getSCDnum()%></div>
		</div>
		</div>
		<% 
	}
}
%>
<input name="select" value="payment" type="hidden" id="select">

<!-- checkbox为1个时，form.check.length=undefined -->
<input name="check" type="checkbox" value="0" style="display:none;"/>
<div class="card-bottom1">
<input type="button" value="删除" onclick="is_delete(form1.check,form1)" class="bt"/>
</div>
<div class="card-bottom2">
<input type="button" value="结算" onclick="is_check(form1.check,form1)" class="bt"/>
</div>
</form>
</body>

<script>

function is_check(check,formname){

	var flag=false;
	for(i=0;i<check.length;i++){
		if(check[i].checked){
			flag=true;
			break;
		}
	}
	
	if(!flag){
		alert("请先选择商品！")
		return false;
	}else{
	//	if(confirm("确定选择这些吗？")){
			document.getElementById("select").value="payment";
			formname.submit();
	//	}
	}
}

function is_delete(check,formname){

	console.log("check.length:",check.length);
	var flag=false;
	for(i=0;i<check.length;i++){
		if(check[i].checked){
			flag=true;
			break;
		}
	}
	
	if(!flag){
		alert("请先选择商品！")
		return false;
	}else{
		if(confirm("确定选择这些吗？")){
			document.getElementById("select").value="delete";
			formname.submit();
		}//
	}
}

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