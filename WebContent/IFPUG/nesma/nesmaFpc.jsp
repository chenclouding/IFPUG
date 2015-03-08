<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.MeasureReport" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>简化功能点估算</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">

  </head>
  
  <body>
  <%
  	Integer productId = new Integer(request.getParameter("productId"));
  	RequirementBusiness rb = new RequirementBusiness();
  	IfpugProduct product = (IfpugProduct) rb.getProductById(productId);
  	// 得到该带估算产品中ILF，EIF的个数
  	int ilfNum = product.getIfpugIlfs().size();
  	int eifNum = product.getIfpugEifs().size();

  	Object[] functionList = product.getIfpugFunctions().toArray();

  	MeasureReport mr = new MeasureReport();
  	if (functionList != null && functionList.length != 0) {
  		for (Object f : functionList) {
  			mr.getEpFromFunction(f);
  		}
  	}
  	// 得到该带估算产品中EI,EO,EQ的个数
  	int eiNum = mr.eiList.size();
  	int eoNum = mr.eoList.size();
  	int eqNum = mr.eqList.size();
  	
  	int estimatedNum = 7*ilfNum +5*eifNum+4*eiNum+4*eoNum+5*eqNum;
  	int indicativeNum = 35*ilfNum + 15*eifNum;
  %>
  <table style="width:740px">
 	<tr>
  		<td>待估算产品基本信息</td>
  	</tr>
  	<tr>
  		<td>ILF个数：<%=ilfNum %></td>
  	</tr>
  	<tr>
  		<td>EIF个数：<%=eifNum %></td>
  	</tr>
  	<tr>
  		<td>EI个数：<%=eiNum %></td>
  	</tr>
  	<tr>
  		<td>EO个数：<%=eoNum %></td>
  	</tr>
  	<tr>
  		<td>EQ个数：<%=eqNum %></td>
  	</tr>
  </table>
  
    <table style="width:740px">
 	<tr>
  		<td>NESMA简化功能点数</td>
  	</tr>
  	<tr>
  		<td>Estimated方法功能点个数：<%=estimatedNum %></td>
  	</tr>
  	<tr>
  		<td>Indicative方法功能点个数：<%=indicativeNum %></td>
  	</tr>
  
  </table>
     
  </body>
</html>
