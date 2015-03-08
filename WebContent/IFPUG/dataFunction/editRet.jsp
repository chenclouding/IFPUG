<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'editRet.jsp' starting page</title>
    
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
       Integer dfId;//ret对应的ILF\EIF的id
         
         
       if(type.equals("0")){//如果是ILF的ret 
       		IfpugIlfRet ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId); 
       		name = ilfRet.getIlfRetName(); 
       		desp = ilfRet.getIlfRetDesp(); 
       		dfId = ilfRet.getIfpugIlf().getId();
       } 
       else{//如果是EIF的ret 
       		IfpugEifRet eifRet = (IfpugEifRet)dfb.queryEifRetById(retId); 
       		name = eifRet.getEifRetName(); 
       		desp = eifRet.getEifRetDesp(); 
       		dfId = eifRet.getIfpugEif().getId(); 
       } 
   %>
    <form  action="/ifpug/IFPUG/editRet.do" >
  	 <table>
  		<tr>
  			<td width="15%">记录名称</td>
  			<td >
  			    <input type="text" name="retName" style="width:160px" value="<%=name%>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">记录描述</td>
  			<td >
  			    <textarea name="retDesp"><%=desp%></textarea>
            </td>
  		</tr>
  	</table>
    
    <input type="hidden" name="id" value="<%=retId%>"/>
    <input type="hidden" name="fileId" value="<%=type%>"/>
    <input type="hidden" name="dfId" value="<%=dfId%>"/>
    <input type="hidden" name="type" value="<%=type%>"/>
    <input type="submit" name="submit" value=" 保 存 "/>
    <input type='button' onclick="Javascript:window.location='/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>'" value=" 返 回 ">
  	</form> 			
  </body>
</html>
