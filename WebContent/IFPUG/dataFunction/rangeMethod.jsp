<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'rangeMethod.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">

  </head>
  
  <body>
  <%
  	Integer ufpMethod= new Integer(request.getParameter("ufpMethod"));
    Integer type=  new Integer(request.getParameter("type"));
  	Integer dfId = new Integer(request.getParameter("dfId"));
  	
   %>
   	<form name="methodForm" id ="methodForm" method="post" action="/ifpug/IFPUG/ufpCount.do"  target="_parent">
  		<table>
  			<tr>
  				<td width="10%" align="center">DET个数范围</td>
  				<td >
  			    	<input type="radio" value="0" name="range_det" checked="checked"/>1~19
  					<input type="radio" value="1" name="range_det"/>20~50
  					<input type="radio" value="2" name="range_det"/>51+
            	</td>
  			</tr>
  			<tr>
  				<td width="10%">RET个数范围</td>
  				<td >
  			    	<input type="radio" value="0" name="range_ret" checked="checked"/>=1 
  					<input type="radio" value="1" name="range_ret"/>2~5
  					<input type="radio" value="2" name="range_ret"/>6+
            	</td>
  			</tr>
  		</table>
  		<input type="submit" name="submit" value="开始计算"/>
  		<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>"/>
    	<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="dfId" value="<%=dfId%>"/>
    </form>   
    <%	Integer ufpCount, productId;
    	DataFunctionBusiness dfb = new 	DataFunctionBusiness();
    	if(type == 0){
    	    IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
    	    ufpCount = ilf.getUfpCount();
    	    productId = ilf.getIfpugProduct().getId();
    	}
    	else {
    		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
    	    ufpCount = eif.getUfpCount();
    	    productId = eif.getIfpugProduct().getId();
    	}
    %>
    
    <table>
    	<tr id="ufpCount"  >
  			<td width="10%">功能点个数</td>
  			<td ><%=ufpCount %></td>
  		</tr>
    </table> 
    <a href ="Javascript:parent.location='/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId%>'"> 返回数据功能列表</a>
  </body>
</html>
