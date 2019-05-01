<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<title>订票信息</title>
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="css/justified-nav.css" rel="stylesheet">
		<script type="text/javascript" src="js/option.js"></script>
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
						<li><a href="entrance/home.jsp">主页</a></li>
						<li><a href="entrance/updatePwd.jsp">修改密码</a></li>
						<li><a href="entrance/Booking.jsp">机票预订</a></li>
						<li class="active"><a href="entrance/bookSuccess.jsp">预订信息维护</a></li>
						<li><a href="quitAction">退出系统</a></li>
					</ul>
				</nav>
			</div>
			
			
			
			<div class="jumbotron" style="width: 1170px;">
			
				<form class="form-inline" method="post" action="showAction">
				  <div class="form-group">
				    <label for="exampleInputName2">姓名</label>
				    <input type="text" class="form-control" name="qname" id="exampleInputName2" placeholder="">
				  </div>
				  <div class="form-group">
				    <label for="exampleInput">出发日期</label>
				    <input type="text" class="form-control" name="qdate" id="exampleInput" placeholder="">
				  </div>
				  <button type="submit" class="btn btn-default">查询</button>
				</form>
			
				<table class="table" >
					<thead>
						<tr>
			    			<th>姓名</th>
			    			<th>性别</th>
			    			<th>始发城市</th>
			    			<th>目的城市</th>
			    			<th>出发日期</th>
			    			<th>身份证</th>
			    			<th>操作</th>
	    				</tr>
    				</thead>
    				<tbody>
    					<s:iterator value="planes" status="st" var="plane">
		    			<tr>
		    				<td><s:property value="%{planes[#st.index].uname}"/></td>
		    				<td><s:property value="#plane.sex"/></td>
		    				<td><s:property value="#plane.scity"/></td>
		    				<td><s:property value="#plane.dcity"/></td>
		    				<td><s:property value="#plane.date"/></td>
		    				<td><s:property value="#plane.ident"/></td>
		    				<td>
								<a href="javascript:updateDetails('<s:property value="id"/>')">修改</a>
								<a href="javascript:deleteUser('<s:property value="id"/>')">删除</a>
							</td>
		    			</tr>
		    		</s:iterator>
    				</tbody>
				</table>
				[<a href="showAction?pageNo=1">首页</a>]
					<c:choose>
						<c:when test="${currentPage>1}">
							[<a href="showAction?pageNo=${currentPage-1}">上一页</a>]
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${currentPage<totalPage}">
							[<a href="showAction?pageNo=${currentPage+1}">下一页</a>]
						</c:when>
					</c:choose>
					[<a href="showAction?pageNo=${totalPage}">尾页</a>]
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
