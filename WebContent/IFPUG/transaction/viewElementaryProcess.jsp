<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEi" %>
<%@ page import="hibernate.IFPUG.IfpugEo" %>
<%@ page import="hibernate.IFPUG.IfpugEq" %>
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
    
    <title>My JSP 'productBasicInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
  <%
  	/*获取从页面productList.jsp传来productId*/
      Integer epId = new Integer(request.getParameter("epId"));
      Integer type = new Integer(request.getParameter("type"));
      /*从数据库中把id为productId的数据组取出*/
      RequirementBusiness rb = new RequirementBusiness(); //业务层，对应于IFPUG方法的策略阶段
      Object epObject = rb.getElementaryProcessById(type,epId);
      String showStatus = null, productName = null, functionName = null, epName = null, epDesp = null;
      Integer productId, functionId;
      Integer ufpCount = 0;
      IfpugFunction function = null;
      switch(type)
      {
      	case 0: 
      		IfpugEi ei = (IfpugEi)epObject;
      		functionName = ei.getIfpugFunction().getFunctionName();
      		epName = ei.getEiName();
      		epDesp = ei.getEiDesp();
      		showStatus = rb.changeMeausreStatus(ei.getMeasureStatus());
      		ufpCount = ei.getUfpCount();
      		function = ei.getIfpugFunction();
      		break;
      	case 1:
      		IfpugEo eo = (IfpugEo)epObject;
      		functionName = eo.getIfpugFunction().getFunctionName();
      		epName = eo.getEoName();
      		epDesp = eo.getEoDesp();
      		showStatus = rb.changeMeausreStatus(eo.getMeasureStatus());
      		ufpCount = eo.getUfpCount();
      		function = eo.getIfpugFunction();
      		break;
      	case 2:
      		IfpugEq eq = (IfpugEq)epObject;
      		functionName = eq.getIfpugFunction().getFunctionName();
      		epName = eq.getEqName();
      		epDesp = eq.getEqDesp();
      		showStatus = rb.changeMeausreStatus(eq.getMeasureStatus());
      		ufpCount = eq.getUfpCount();
      		function = eq.getIfpugFunction();
      		break;
      }

   
     	 while(function.getIfpugProduct() == null)
     	 {
      		 function = function.getIfpugFunction();
     	 }

      productName = function.getIfpugProduct().getProductName();
      functionId = function.getId();
      productId =  function.getIfpugProduct().getId();
   %>
  
   <table>
    <tr>
    	<td>基本流程详细信息</td>
    </tr>
     <tr>
    	<td valign="top" width="20%">所属产品：</td>
    	<td><%=productName %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">所属功能模块：</td>
    	<td><%=functionName%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">基本流程名称：</td>
    	<td valign="top"><%=epName %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">基本流程类型：</td>
    	<td valign="top"><%=rb.changeEpType(type) %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">基本流程描述：</td>
    	<td><%=epDesp%></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">基本流程估算状态：</td>
    	<td><%=showStatus%></td>
    </tr>
      <tr>
    	<td valign="top" width="20%">基本流程功能点个数：</td>
    	<td><%=ufpCount%></td>
    </tr>
    </table>
  	<a href="/ifpug/IFPUG/transaction/addMethodToEp.jsp?productId=<%=functionId%>&&functionId=<%=functionId%>">返 回</a>
    </body>
</html>
