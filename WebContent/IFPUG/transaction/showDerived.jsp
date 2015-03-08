<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEi"%>
<%@ page import="hibernate.IFPUG.IfpugEo"%> 
<%@ page import="hibernate.IFPUG.IfpugEq"%>  
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugEifDirectMethod"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfDirectMethod"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UFP方法--手动添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
     <%
   			Integer ufpMethod = new Integer(request.getParameter("ufpMethod"));
			Integer type = new Integer(request.getParameter("type"));
			Integer epId = new Integer(request.getParameter("epId"));
			String epType = request.getParameter("epType");
			TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
			Integer detCount = 0, ftrCount = 0, ufpCount = 0;
			ftrCount = Integer.valueOf(session.getAttribute("ftrCount").toString());
			switch(type)
			{
				case 0:
					IfpugEi ei = tfb.queryEiById(epId);
					detCount = ei.getIfpugEiDets().size();
					ufpCount = ei.getUfpCount();
					break;
				case 1:
					IfpugEo eo = tfb.queryEoById(epId);
					detCount = eo.getIfpugEoDets().size();
					ufpCount = eo.getUfpCount();
					break;
				case 2:
					IfpugEq eq = tfb.queryEqById(epId);
					detCount = eq.getIfpugEqDets().size();
					ufpCount = eq.getUfpCount();
					break;
			}
   %>
   <h1>您已添加的信息：</h1>
   <table>
   	<tr>
   		<td width="15%">数据元素类型个数</td>
  		<td ><%=detCount %></td>
   	</tr>
   	<tr>
   		<td width="15%">引用文件类型个数</td>
  		<td ><%=ftrCount %></td>
   	</tr>
   	<tr>
   		<td width="15%">功能点个数</td>
  		<td ><%=ufpCount %></td>
   	</tr>
  	</table>
   <a href ="Javascript:window.location='/ifpug/IFPUG/transaction/derivedMethod.jsp?epType=<%=epType%>&&ufpMethod=<%=ufpMethod %>&&type=<%=type %>&&epId=<%=epId %>'"> 返回</a>
  </body>
</html>
