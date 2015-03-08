<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %>
<%@ page import="hibernate.IFPUG.IfpugEi" %>
<%@ page import="hibernate.IFPUG.IfpugEo" %>
<%@ page import="hibernate.IFPUG.IfpugEq" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>删除基本流程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">

  </head>
  
  <body>
    <%
      //此页面为删除基本流程的页面，删除结束需返回elementaryProcessList.jsp,回传functionId.
      Integer epId = new Integer(request.getParameter("epId"));//获取从页面elementaryProcessList.jsp传来epId,用于删除操作
	  Integer epType = Integer.valueOf(request.getParameter("type"));
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作
	  Object epObject = rb.getElementaryProcessById(epType,epId);//通过epID获取EP对象
	  IfpugFunction function = null;
	  //根据基本流程类型的不同，在不同数据库表中获取基本流程对应的功能模块ID
	  if (epType == 0){
	  		IfpugEi ei = (IfpugEi)epObject;
	  		function = ei.getIfpugFunction();
	  }
	  else if (epType == 1){
	  		IfpugEo eo = (IfpugEo)epObject;
	  		function = eo.getIfpugFunction();
	  }
	  else {
	  		IfpugEq eq = (IfpugEq)epObject;
	  		function = eq.getIfpugFunction();
	  }
      Integer functionId = function.getId();
       //删除该数据组对应的数据属性
      boolean result = rb.delElementaryProcessById(epType,epId);
      if(result==true){
      	response.sendRedirect("/ifpug/IFPUG/requirement/elementaryProcessList.jsp?functionId="+functionId);
      }
  %>
  </body>
</html>
