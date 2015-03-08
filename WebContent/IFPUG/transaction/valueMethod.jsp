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
    
    <title>UFP方法---用户选择值</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="JavaScript">  
	 function verifyInput()
	{	
		var frm = document.methodForm;
	 	if(isEmpty(frm.detValue.value)) //如果DET栏填入值为空，给出不能为空的提示信息
		{
			alert("数据元素个数不能为空！");
			frm.detValue.focus();
			return false;
		}	
		else { //如果非空，验证用户输入的信息是否为数字
			if(checkNumber(frm.detValue.value)){
				alert("数据元素个数必须为数字！");
				frm.detValue.focus();
				return false;
			}
		}
		if(isEmpty(frm.ftrValue.value)) //如果RET栏填入值为空，给出不能为空的提示信息
		{
			alert("记录元素个数不能为空！");
			frm.ftrValue.focus();
			return false;
		}	
		else { //如果非空，验证用户输入的信息是否为数字
			if(checkNumber(frm.ftrValue.value)){
				alert("记录元素个数必须为数字！");
				frm.ftrValue.focus();
				return false;
			}
		}
	}
	
	function checkNumber(String) //判断输入是否为数字
	{ 
		var Letters = "1234567890"; 
		var i; 
		var c; 
		for( i = 0; i < String.length; i ++ ) 
		{ 
			c = String.charAt( i ); 
			if (Letters.indexOf( c ) ==-1) 
			{ 
				return true; 
			} 
		} 
		return false; 
	}
	</script>

  </head>
  
  <body>
    <%
    	Integer ufpMethod = new Integer(request.getParameter("ufpMethod"));
    	Integer type = new Integer(request.getParameter("type"));
    	Integer epId = new Integer(request.getParameter("epId"));
    	String epType = request.getParameter("epType");

    	Integer ufpCount = 0;
    	Integer functionId = 0;
    	String detValue = "";
    	String ftrValue = "";
    	TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
    	switch (type) {
    	case 0:
    		IfpugEi ei = tfb.queryEiById(epId);
    		ufpCount = ei.getUfpCount();
    		functionId = ei.getIfpugFunction().getId();
    		IfpugEiMethod ei_method = ei.getIfpugEiMethod();
    		if (ei_method != null) {
    			detValue = String.valueOf(ei_method.getDetValue());
    			ftrValue = String.valueOf(ei_method.getFtrValue());
    		} else {
    			detValue = "";
    			ftrValue = "";
    		}
    		break;
    	case 1:
    		IfpugEo eo = tfb.queryEoById(epId);
    		ufpCount = eo.getUfpCount();
    		functionId = eo.getIfpugFunction().getId();
    		IfpugEoMethod eo_method = eo.getIfpugEoMethod();
    		if (eo_method != null) {
    			detValue = String.valueOf(eo_method.getDetValue());
    			ftrValue = String.valueOf(eo_method.getRetValue());
    		} else {
    			detValue = "";
    			ftrValue = "";
    		}
    		break;
    	case 2:
    		IfpugEq eq = tfb.queryEqById(epId);
    		ufpCount = eq.getUfpCount();
    		functionId = eq.getIfpugFunction().getId();
    		IfpugEqMethod eq_method = eq.getIfpugEqMethod();
    		if (eq_method != null) {
    			detValue = String.valueOf(eq_method.getDetValue());
    			ftrValue = String.valueOf(eq_method.getFtrValue());
    		} else {
    			detValue = "";
    			ftrValue = "";
    		}
    		break;
    	}
    	if (detValue.equals("null")) {
    		detValue = "";
    		ftrValue = "";
    	}
    %>
   <form name="methodForm" id ="methodForm" method="post" action="/ifpug/IFPUG/ufpCount_Value.do"  onsubmit="return verifyInput();">
  		<table>
  			<tr>
  				<td width="10%">DET个数值</td>
  				<td >
  			    	<input type="text" name="detValue" style="width:160px"/>
  			    	<script language="javascript">   
						document.methodForm.detValue.value = <%=detValue%>;
					</script>
            	</td>
  			</tr>
  			<tr>
  				<td width="10%">FTR个数值</td>
  				<td >
  			    	<input type="text" name="ftrValue" style="width:160px"/>
  			    	<script language="javascript">   
						document.methodForm.ftrValue.value = <%=ftrValue%>;
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
