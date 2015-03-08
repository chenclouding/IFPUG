<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
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
     //获取从detList.jsp页面传过来的数据
  	Integer type= new Integer(request.getParameter("type"));
  	Integer dfId = new Integer(request.getParameter("dfId"));
  	Integer retId = new Integer(request.getParameter("retId"));
  	Integer detCount, retCount, ufpCount;
  	//求出对应dfId的det个数和ret个数
    DataFunctionBusiness dfb = new 	DataFunctionBusiness();
    if(type == 0){
    	IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
    	IfpugIlfDirectMethod method =  ilf.getIfpugIlfDirectMethod();
    	detCount = method.getDetValue();
    	retCount = method.getRetValue();
    	ufpCount = method.getUfpValue();
    }
    else {
    	IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
    	IfpugEifDirectMethod method = eif.getIfpugEifDirectMethod();
    	detCount = method.getDetValue();
    	retCount = method.getRetValue();
    	ufpCount = method.getUfpValue();  	    
    }
   %>
   <h1>您已添加的信息：</h1>
   <table>
   	<tr>
   		<td width="10%">数据元素个数</td>
  		<td ><%=detCount %></td>
   	</tr>
   	<tr>
   		<td width="10%">记录元素个数</td>
  		<td ><%=retCount %></td>
   	</tr>
   	<tr>
   		<td width="10%">功能点个数</td>
  		<td ><%=ufpCount %></td>
   	</tr>
  	</table>
   <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/detList.jsp?type=<%=type%>&&retId=<%=retId%>'"> 返回数据元素列表</a>
  </body>
</html>
