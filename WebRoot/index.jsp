<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>机票订购系统</title>
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/logcom.css" />
		<script type="text/javascript" src="js/front.js"></script>
	</head>
	<body>
		<div id="tbl">
			<br><br>
			<div id="lhead">
				<img src="images/logo.png" width="130px" height="130px"/>
				<h3>机票订购系统</h3>
			</div>
			<div id="tblog">
				<form method="POST" action="loginAction" namespace="/">
					<input type="text" name="user.name" placeholder="姓名  <s:property value="fieldErrors['user.name'][0]" /> "/><br>
					 <!--<s:fielderror fieldName="user.name"></s:fielderror>-->
					<input type="password" name="user.pwd" placeholder="密码  <s:property value="fieldErrors['user.pwd'][0]" />"/><br><br><br>
					<button type="submit" class="btn btn-primary btmy">登录</button>
					<br>
					<br>
					<p>没有账号？<a href="reg.jsp" ">注册</a></p>
				</form>
			</div>
		<div id="tbreg">
			<form method="POST" action="registerAction">
				<input type="text" name="ruser.name" placeholder="用户账户  <s:property value="fieldErrors['ruser.name'][0]" />"/><br>
				<input type="password" name="ruser.pwd" placeholder="登陆密码  <s:property value="fieldErrors['ruser.pwd'][0]" />"/><br>
				<input type="password" type="password" name="vpwd" placeholder="确认密码  <s:property value="fieldErrors['pwd'][0]" />"/><br><br><br>
				<button type="submit" class="btn btn-primary btmy">注册</button>
				<br>
				<br>
				<p>已有账号？<a href="javascript:void(0);" onclick="changePg2()">登录</a></p>
			</form>
		</div>
		</div>
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	</body>
</html>

