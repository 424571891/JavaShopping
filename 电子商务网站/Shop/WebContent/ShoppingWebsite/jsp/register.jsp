<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Register</title>
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
<div class="all">
<form method="post" action="/Shop/ResignServlet" onsubmit="return judge()">
账户&nbsp;&nbsp;&nbsp;&nbsp;：<input name="userno" type="text"/><br/>
密码&nbsp;&nbsp;&nbsp;&nbsp;：<input name="pwd" id="pwd" type="password"/><br/>
确认密码：<input name="pwd_2" id="pwd_2" type="password"/><br/>
<%
if(request.getAttribute("error")!=null){
	out.print(request.getAttribute("error"));
}
%>     	
<br/>
<input type="submit" value="注册"/><br/>

</form>
</div>
<script>

function judge() {
    var pwd = document.getElementById("pwd").value;
    var pwd_2 = document.getElementById("pwd_2").value;
    if (pwd!=pwd_2) {
        alert("密码不一致");
        return false;
    }
    return true;
}
</script>

</body>
</html>