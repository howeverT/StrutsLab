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
    
    <title>订票页面</title>
	<link rel="stylesheet" type="text/css" href="css/bookPlane.css">
	<script type="text/javascript" src="js/bookPlane.js"></script>

  </head>
  
  <body>
    <div id="backdiv">
    <br><br><br><br><br>
		<h1 align="center">在线机票预订</h1>
		
		<br><br>
		<s:form method="post" action="bookAction">
	    	<s:textfield name="plane.uname" label="姓名"/>
	    	<s:radio name="plane.sex" list="%{#{'男':'男','女':'女'}}" label="性别"/>   	
	    	<s:textfield name="plane.scity" label="始发城市"/>
	    	<s:textfield name="plane.dcity" label="目的城市"/>
	    	<s:textfield name="plane.date" label="出发日期"/>
	    	<s:textfield name="plane.ident" label="身份证"/>
	    	<s:submit name="submit" value="预订" />
	    	
		</s:form>
				
		</div>
  </body>
</html>
