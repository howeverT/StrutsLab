<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>修改密码</title>
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="css/justified-nav.css" rel="stylesheet">

	</head>
	<body>
		<div class="container">
			<div class="masthead">
				<div id="head">
					<div id="left">
						<h3 class="text-muted">在线机票预订系统</h3>
					</div>
					<div id="right">
						<br />
						<h5>欢迎您,${loginName.getName()}</h5>
					</div>
				</div>
				
				<nav>
					<ul class="nav nav-justified">
						<li class="active"><a href="entrance/home.jsp">主页</a></li>
						<li><a href="entrance/updatePwd.jsp">修改密码</a></li>
						<li><a href="entrance/Booking.jsp">机票预订</a></li>
						<li><a href="entrance/bookSuccess.jsp">预订信息维护</a></li>
						<li><a href="entrance/quitAction">退出系统</a></li>
					</ul>
				</nav>
			</div>
			<div class="jumbotron">
				<h3>欢迎来到机票预订系统</h3>
				<p class="lead">希望您旅途愉快,立即开始购票</p>
				<p>
					<a class="btn btn-lg btn-success" href="entrance/Booking.jsp" role="button">开始购票</a>
				</p>
			</div>
		</div>
		<!--加载-->
		<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
		<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
		<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/front.js"></script>
	</body>
</html>

