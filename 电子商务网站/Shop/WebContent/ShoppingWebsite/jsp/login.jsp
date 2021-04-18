<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Login</title>
<style>
.all{
	width:30%;
	margin-left:auto;
	margin-right:auto;
	margin-top:100px;	
	font-size:25px;
}
</style>
</head>
<body>

<div class="all">
<form method="post" action="/Shop/LoginServlet">
账户：<input name="userno" type="text"/><br/>
密码：<input name="pwd" type="password"/><br/>
用户类型：<input type="radio" name="usertype" value="customer" checked>顾客
      	<input type="radio" name="usertype" value="merchant">商家<br/>
<%
if(request.getAttribute("login_error")!=null){
	out.print(request.getAttribute("login_error"));
}
%>     	
<br/>
<input type="submit" value="登录"/><br/>
<a href="/Shop/ShoppingWebsite/jsp/register.jsp" >注册</a>
</form>

</div>

</body>
</html>



