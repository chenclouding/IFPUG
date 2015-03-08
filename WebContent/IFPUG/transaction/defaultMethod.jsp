<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEi"%> 
<%@ page import="hibernate.IFPUG.IfpugEo"%> 
<%@ page import="hibernate.IFPUG.IfpugEq"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UFP方法---默认方法</title>
    
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
		if(isEmpty(frm."defaultUfp".value)) //如果该栏填入值为空，给出不能为空的提示信息
		{
			alert("功能点个数不能为空");
			frm."defaultUfp".focus();
			return false;
		}
		else { //如果非空，验证用户输入的信息是否为数字
			if(checkNumber(frm."defaultUfp".value)){
				alert("功能点个数必须为数字！");
				frm."defaultUfp".focus();
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
  	Integer ufpMethod= new Integer(request.getParameter("ufpMethod"));
  	Integer type=  new Integer(request.getParameter("type"));
  	Integer epId = new Integer(request.getParameter("epId"));
    String  epType = request.getParameter("epType");
    
    Integer ufpCount;
    Integer functionId = 0;
    TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
    switch(type)
    	{
    		case 0:
    			IfpugEi ei = (IfpugEi)tfb.queryEiById(epId);
    			ufpCount = ei.getUfpCount();
    			functionId = ei.getIfpugFunction().getId();
    			break;
    		case 1:
    			IfpugEo eo = (IfpugEo)tfb.queryEoById(epId);
    			ufpCount = eo.getUfpCount();
    			functionId = eo.getIfpugFunction().getId();
    			break;
    		case 2:
    			IfpugEq eq = (IfpugEq)tfb.queryEqById(epId);
    			ufpCount = eq.getUfpCount();
    			functionId = eq.getIfpugFunction().getId();
    			break;    
    		default:	ufpCount = 0;
    	}
   %>
   <form name="methodForm" id ="methodForm" method="post"  action="/ifpug/IFPUG/ufpCount_Default.do"  onsubmit="return verifyInput();">
  		<table>
  			<tr>
  				<td width="13%">默认功能点个数：</td>
  				<td >
  			    	<input type="text" name="defaultUfp" style="width:160px"/>
  			    	<script language="javascript">   
						document.methodForm.defaultUfp.value = <%=ufpCount%>;
					</script>
            	</td>
            	
  			</tr>
  		</table>
  		<input type="submit" name="submit" value="提交"/>
  		<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>"/>
    	<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="epId" value="<%=epId%>"/>
    </form>   
    <table>
    	<tr id="ufpCount"  >
  			<td width="10%">功能点个数</td>
  			<td ><%=ufpCount %></td>
  		</tr>
    </table> 
    <a href ="Javascript:parent.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=<%=functionId%>&&epType=<%=epType%>'"> 返回事务功能列表</a>
  </body>
</html>
