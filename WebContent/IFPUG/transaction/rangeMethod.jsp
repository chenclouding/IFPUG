<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEi"%> 
<%@ page import="hibernate.IFPUG.IfpugEo"%> 
<%@ page import="hibernate.IFPUG.IfpugEq"%> 
<%@ page import="hibernate.IFPUG.IfpugEiMethod"%> 
<%@ page import="hibernate.IFPUG.IfpugEoMethod"%> 
<%@ page import="hibernate.IFPUG.IfpugEqMethod"%> 
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
  	Integer ufpMethod = new Integer(request.getParameter("ufpMethod"));
  	Integer type = new Integer(request.getParameter("type"));
  	Integer epId = new Integer(request.getParameter("epId"));
  	String epType = request.getParameter("epType");
  	String data1, data2, data3;
  	if (type != 0) {
  		data1 = "1-5 ";
  		data2 = "6-19";
  		data3 = "20+ ";
  	} else {
  		data1 = "1-4 ";
  		data2 = "5-15";
  		data3 = "16+ ";
  	}

  	Integer ufpCount = 0;
  	Integer functionId = 0;
  	String detRange = null, ftrRange = null;
  	TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
  	switch (type) {
  	case 0:
  		IfpugEi ei = tfb.queryEiById(epId);
  		ufpCount = ei.getUfpCount();
  		functionId = ei.getIfpugFunction().getId();
  		IfpugEiMethod ei_method = ei.getIfpugEiMethod();
  		if(ei_method != null)
  		{
  			detRange = String.valueOf(ei_method.getDetRange());
  			ftrRange = String.valueOf(ei_method.getFtrRange());
  		}
  		else {
  			detRange = "";
  			ftrRange = "";
  		}
  		break;
  	case 1:
  		IfpugEo eo = tfb.queryEoById(epId);
  		ufpCount = eo.getUfpCount();
  		functionId = eo.getIfpugFunction().getId();
  		IfpugEoMethod eo_method = eo.getIfpugEoMethod();
  		if(eo_method != null)
  		{
  			detRange = String.valueOf(eo_method.getDetRange());
  			ftrRange = String.valueOf(eo_method.getRetRange());
  		}
  		else {
  			detRange = "";
  			ftrRange = "";
  		}
  		break;
  	case 2:
  		IfpugEq eq = tfb.queryEqById(epId);
  		ufpCount = eq.getUfpCount();
  		functionId = eq.getIfpugFunction().getId();
  		IfpugEqMethod eq_method = eq.getIfpugEqMethod();
  		if(eq_method != null)
  		{
  			detRange = String.valueOf(eq_method.getDetRange());
  			ftrRange = String.valueOf(eq_method.getFtrRange());
  		}
  		else {
  			detRange = "";
  			ftrRange = "";
  		}
  		break;
  	}
  %>
   	<form name="methodForm" id ="methodForm" method="post" action="/ifpug/IFPUG/ufpCount_Range.do">
  		<table>
  			<tr>
  				<td width="10%" align="center">DET个数范围</td>
  				<td >
  			    	<input type="radio" value="0" name="detRange" checked="checked"/><%=data1%>
  					<input type="radio" value="1" name="detRange"/><%=data2%>
  					<input type="radio" value="2" name="detRange"/><%=data3%>
  					<script language="javascript">   
                 		var type = document.getElementsByName("detRange");
                  		type[<%=detRange%>].checked = true;
                	</script>
            	</td>
  			</tr>
  			<tr>
  				<td width="10%">FTR个数范围</td>
  				<td >
  			    	<input type="radio" value="0" name="ftrRange" checked="checked"/>0或1  
  					<input type="radio" value="1" name="ftrRange"/>2-3
  					<input type="radio" value="2" name="ftrRange"/>4+ 
  					<script language="javascript">   
                 		var type = document.getElementsByName("ftrRange");
                  		type[<%=ftrRange%>].checked = true;
                	</script>
            	</td>
  			</tr>
  		</table>  		
  		<input type="submit" name="submit" value="开始计算"/>
  		<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>"/>
    	<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="epId" value="<%=epId%>"/>
    	<input type="hidden" name="epType" value="<%=epType%>"/>
    </form>   
    
    <table>
    	<tr id="ufpCount"  >
  			<td width="10%">功能点个数</td>
  			<td ><%=ufpCount%></td>
  		</tr>
    </table> 
     <a href ="Javascript:parent.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=<%=functionId%>&&epType=<%=epType%>'"> 返回事务功能列表</a>
  </body>
</html>
