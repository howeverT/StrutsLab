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
    
    <title>在线机票订票系统首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <h2>用户登陆</h2>

    <form method="POST" action="loginAction">
    	<s:property value="errorMessage" /><br>
    	姓名：<input type="text" name="name"/><br>
    	密码：<input type="password" name="pwd"/>
    	<div>
    		<s:fielderror fieldName="name"></s:fielderror>
    		<s:fielderror fieldName="pwd"></s:fielderror>
    	</div><br>
    	<input type="submit" value="提交"/>
    	<input type="reset" value="重置"/>
    </form>
    <hr color="red">
    <h2>用户注册</h2>
    <form method="POST" action="registerAction">
    	用户账户：<input type="text" name="lname"/><br>
    	登陆密码：<input type="password" name="lpwd"/><br>
    	确认密码：<input type="password" name="vpwd"/>
    	<div>
    		<s:fielderror fieldName="lname"></s:fielderror>
    		<s:fielderror fieldName="lpwd"></s:fielderror>
    		<s:fielderror fieldName="vpwd"></s:fielderror>
    	</div><br>
    	<input type="submit" value="注册"/>
    	<input type="reset" value="重置"/>
    </form>
  </body>
</html>
