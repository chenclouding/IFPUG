<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG.IfpugProduct" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除主功能模块</title>
    
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
   <%
      //此页面为删除主功能模块的页面，删除结束需返回functionList.jsp,回传productId.
      Integer functionId = new Integer(request.getParameter("functionId"));//获取从页面functionList.jsp传来functionId,用于删除操作
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作
      IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
      IfpugProduct product = (IfpugProduct)function.getIfpugProduct();
      Integer productId = product.getId();
    
      //删除该数据组对应的数据属性
      boolean result = rb.delFunctionById(functionId);
      if(result==true){
      	response.sendRedirect("/ifpug/IFPUG/requirement/functionList.jsp?productId="+productId);
      }
  %>
  <body>
</html>
