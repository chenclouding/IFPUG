<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG.IfpugProduct" %> 
<%@page import="business.IFPUG.RequirementBusiness;"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除子功能模块</title>
    
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
  	<%Integer functionId = new Integer(request.getParameter("functionId"));//获取从页面functionList.jsp传来functionId,用于删除操作 
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作 
	  IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId); 
      Integer fatherId = function.getIfpugFunction().getId();//找到该子模块的直接父模块，获得Id，便于页面跳转
      //删除该数据组对应的数据属性 
      boolean result = rb.delFunctionById(functionId); 
      if(result==true){ 
      	  response.sendRedirect("/ifpug/IFPUG/requirement/childFunctionList.jsp?functionId="+fatherId); 
      } 
  %>
  
  </body>
</html>





