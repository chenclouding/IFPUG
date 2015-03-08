<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugIlfDet" %>
<%@ page import="hibernate.IFPUG.IfpugEifDet" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据元素</title>
    
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
         
         
       if(type.equals("0")){//如果是ILF的ret 
       		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
       		name = ilfDet.getIlfDetName();
       		desp = ilfDet.getIlfDetDesp();
       		retId = ilfDet.getIfpugIlfRet().getId();
       } 
       else{//如果是EIF的ret 
       		IfpugEifDet eifDet = (IfpugEifDet)dfb.queryEifDetById(detId);
       		name = eifDet.getEifDetName();
       		desp = eifDet.getEifDetDesp();
       		retId = eifDet.getIfpugEifRet().getId();
       } 
   %>
   <form  action="/ifpug/IFPUG/editDet.do" >
  	 <table>
  		<tr>
  			<td width="15%">数据名称</td>
  			<td >
  			    <input type="text" name="detName" style="width:160px" value="<%=name %>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">数据描述</td>
  			<td >
  			    <textarea name="detDesp"><%=desp %></textarea>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" 保 存 "/>
    <input type='button' onclick="Javascript:window.location='detList.jsp?retId=<%=retId%>&&type=<%=type%>'" value=" 返 回 ">
  	<input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="detId" value="<%=detId%>"/>
    <input type="hidden" name="id" value="<%=detId%>"/>
    <input type="hidden" name="retId" value="<%=retId%>"/>
  	</form> 			
  </body>
</html>
