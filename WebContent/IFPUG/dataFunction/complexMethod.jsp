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
    
    <title>UFP����---�û�ѡ���Ӷ�</title>
    
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
   <form name="methodForm" id ="methodForm" method="post"  action="/ifpug/IFPUG/ufpCount.do"  target="_parent">
  		<table>
  			<tr>
  				<td width="13%">����Ҫ�ظ��Ӷ�</td>
  				<td >
  			    	<input type="radio" value="0" name="complexValue" checked="checked"/>��
  					<input type="radio" value="1" name="complexValue"/>ƽ��
  					<input type="radio" value="2" name="complexValue"/>��
            	</td>
  			</tr>
  		</table>
  		<input type="submit" name="submit" value="��ʼ����"/>
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
  			<td width="10%">���ܵ����</td>
  			<td ><%=ufpCount %></td>
  		</tr>
    </table> 
    <a href ="Javascript:parent.location='/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId %>'"> �������ݹ����б�</a>
  </body>
</html>
