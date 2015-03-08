<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugProduct"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewDataFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
  <%
  	//获取从页面dataFunctionList.jsp传来dfId和type,用于查看操作
       Integer dfId = new Integer(request.getParameter("dfId"));
       Integer type = new Integer(request.getParameter("type"));
       DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层
       Integer productId, ufpCount;
       String name = null, desp = null;
       Short ufpMethod ;
       if(type == 0){ //如果是ILF文件
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		name = ilf.getIlfName();
       		desp = ilf.getIlfDesp();
       		ufpMethod = ilf.getUfpMethod();   
       		ufpCount = ilf.getUfpCount();    	
       		productId = ilf.getIfpugProduct().getId();	
       }
       else { //如果是EIF文件
       		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
       		name = eif.getEifName();
       		desp = eif.getEifDesp();
       		ufpMethod = eif.getUfpMethod();
       		ufpCount = eif.getUfpCount();
       		productId = eif.getIfpugProduct().getId();
       }
       RequirementBusiness rb = new RequirementBusiness();
       IfpugProduct ip = (IfpugProduct)rb.getProductById(productId);
       
       
   %>
      <table>
    <tr>
    	<td>数据功能详细信息</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">文件名称：</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">所属产品：</td>
    	<td><%=ip.getProductName() %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">文件类型：</td>
    	<td valign="top"><%= dfb.getTypeName(type) %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">估算方法类型：</td>
    	<td valign="top"><%= dfb.getMethodName(ufpMethod) %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">文件描述：</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">功能点个数：</td>
    	<td><%=ufpCount%></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId %>&&dfId=<%=dfId %>">返 回</a>
  </body>
</html>
