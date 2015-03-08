<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%> 
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
    
    <title>My JSP 'viewRet.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <%
   //获取从页面retList.jsp传来retId和type,用于修改操作 
       Integer retId = new Integer(request.getParameter("retId")); 
       String type = request.getParameter("type"); 
       DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层 
       String name = null; //ret的名称 
       String desp = null;//ret的描述 
       String dfName = null; //数据功能的名称
       Integer dfId;//ret对应的ILF\EIF的id
       Integer detCount; //包含DET的个数
         
         
       if(type.equals("0")){//如果是ILF的ret 
       		IfpugIlfRet ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId); 
       		name = ilfRet.getIlfRetName(); 
       		desp = ilfRet.getIlfRetDesp(); 
       		dfId = ilfRet.getIfpugIlf().getId();
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		dfName = ilf.getIlfName();
       		detCount = ilfRet.getIfpugIlfDets().size();
       } 
       else{//如果是EIF的ret 
       		IfpugEifRet eifRet = (IfpugEifRet)dfb.queryEifRetById(retId); 
       		name = eifRet.getEifRetName(); 
       		desp = eifRet.getEifRetDesp(); 
       		dfId = eifRet.getIfpugEif().getId(); 
       		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
       		dfName = eif.getEifName();
       		detCount = eifRet.getIfpugEifDets().size();
       } 
       
       
   %>
      <table>
    <tr>
    	<td>数据功能详细信息</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">RET名称：</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">文件描述：</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">所属数据功能名称：</td>
    	<td><%=dfName %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">所属数据功能类型：</td>
    	<td valign="top"><%= dfb.getTypeName(Integer.valueOf(type)) %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">包含DET个数：</td>
    	<td><%= detCount%></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>">返 回</a>
  
   
  </body>
</html>
