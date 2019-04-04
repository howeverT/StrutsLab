<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有机票预订信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style "text/css">
		body{
			background: url(images/sk.jpg) no-repeat center;
			height:100%;
			width:100%;
			background-size:cover;
		}
		table{
			margin:0 auto;
			background-color:rgba(255,255,255,0.6);
		}
		h1{
			color:white;
		}
	</style>
  </head>
  
  <body>
    <div>
    	<h1 align="center">您的机票预订信息</h1>
    	<table cellpadding="0" cellspacing="0" border="1" width="70%">
    		<tr>
    			<th>姓名</th>
    			<th>性别</th>
    			<th>始发城市</th>
    			<th>目的城市</th>
    			<th>出发日期</th>
    			<th>身份证</th>
    		</tr>
    		
    		<s:iterator value="planes" status="st" var="plane">
    			<tr>
    				<td><s:property value="%{planes[#st.index].uname}"/></td>
    				<td><s:property value="#plane.sex"/></td>
    				<td><s:property value="#plane.scity"/></td>
    				<td><s:property value="#plane.dcity"/></td>
    				<td><s:property value="#plane.date"/></td>
    				<td><s:property value="#plane.ident"/></td>
    			</tr>
    		</s:iterator>
    	</table>
    </div>
  </body>
</html>
