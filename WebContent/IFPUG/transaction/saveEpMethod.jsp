<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
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
    
    <title>My JSP 'saveEpMethod.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">	
  </head>
  
  <body>
  <% 
  		Integer epId = new Integer(request.getParameter("epId"));	
		Integer type = new Integer(request.getParameter("type"));	
		String epType = request.getParameter("epType");
		Integer functionId = new Integer(request.getParameter("functionId"));
		String ufpMethod =  request.getParameter("ufpMethod");	
		RequirementBusiness rb = new RequirementBusiness();
		Object epObject = rb.getElementaryProcessById(type,epId);
		boolean result = false;
		//String ufpMethod = "3";
		//更新数据库中EI\EI\EQ表的数据
		switch(type){
			case 0: 
				IfpugEi ei = (IfpugEi)epObject;
				ei.setUfpMethod(Short.valueOf(ufpMethod));
				result = rb.updateElementaryProcess(ei);
				break;
			case 1:
				IfpugEo eo = (IfpugEo)epObject;
				eo.setUfpMethod(Short.valueOf(ufpMethod));
				result = rb.updateElementaryProcess(eo);
				break;
			case 2:
				IfpugEq eq = (IfpugEq)epObject;
				eq.setUfpMethod(Short.valueOf(ufpMethod));
				result = rb.updateElementaryProcess(eq);
				break;
		}
	   response.sendRedirect("/ifpug/IFPUG/transaction/addMethodToEp.jsp?epId="+epId+"&&epType="+epType+"&&functionId="+functionId);
		%>
  </body>
</html>
