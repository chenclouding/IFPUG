<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%> 
<%@ page import="hibernate.IFPUG.IfpugEifDet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfDet"%> 
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
    //获取从页面detList.jsp传来detId和type,用于修改操作 
       Integer detId = new Integer(request.getParameter("detId")); 
       String type = request.getParameter("type"); 
       DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层 
       String name = null; //ret的名称 
       String desp = null;//ret的描述 
       Integer retId;//ret对应的ILF\EIF的id
       String retName; //ret的名称
         
         
       if(type.equals("0")){//如果是ILF的det 
       		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
       		name = ilfDet.getIlfDetName();
       		desp = ilfDet.getIlfDetDesp();
       		retId = ilfDet.getIfpugIlfRet().getId();
       		IfpugIlfRet iir = (IfpugIlfRet)dfb.queryIlfRetById(retId);
       		retName = iir.getIlfRetName();
       } 
       else{//如果是EIF的det 
       		IfpugEifDet eifDet = (IfpugEifDet)dfb.queryEifDetById(detId);
       		name = eifDet.getEifDetName();
       		desp = eifDet.getEifDetDesp();
       		retId = eifDet.getIfpugEifRet().getId();
       		IfpugEifRet ier = (IfpugEifRet)dfb.queryEifRetById(retId);
       		retName = ier.getEifRetName();
       } 
       
   %>
      <table>
    <tr>
    	<td>数据功能详细信息</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">DET名称：</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">文件描述：</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">所属Ret名称：</td>
    	<td><%=retName %></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/detList.jsp?type=<%=type%>&&retId=<%=retId%>">返 回</a>
  
   
  </body>
</html>
