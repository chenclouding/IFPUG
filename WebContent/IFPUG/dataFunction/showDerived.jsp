<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugEifDirectMethod"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfDirectMethod"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UFP����--�ֶ����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
     <%
     //��ȡ��detList.jspҳ�洫����������
  	Integer type= new Integer(request.getParameter("type"));
  	Integer dfId = new Integer(request.getParameter("dfId"));
  	Integer retId = new Integer(request.getParameter("retId"));
  	Integer detCount, retCount, ufpCount;
  	//�����ӦdfId��det������ret����
    DataFunctionBusiness dfb = new 	DataFunctionBusiness();
    if(type == 0){
    	IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
    	IfpugIlfDirectMethod method =  ilf.getIfpugIlfDirectMethod();
    	detCount = method.getDetValue();
    	retCount = method.getRetValue();
    	ufpCount = method.getUfpValue();
    }
    else {
    	IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
    	IfpugEifDirectMethod method = eif.getIfpugEifDirectMethod();
    	detCount = method.getDetValue();
    	retCount = method.getRetValue();
    	ufpCount = method.getUfpValue();  	    
    }
   %>
   <h1>������ӵ���Ϣ��</h1>
   <table>
   	<tr>
   		<td width="10%">����Ԫ�ظ���</td>
  		<td ><%=detCount %></td>
   	</tr>
   	<tr>
   		<td width="10%">��¼Ԫ�ظ���</td>
  		<td ><%=retCount %></td>
   	</tr>
   	<tr>
   		<td width="10%">���ܵ����</td>
  		<td ><%=ufpCount %></td>
   	</tr>
  	</table>
   <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/detList.jsp?type=<%=type%>&&retId=<%=retId%>'"> ��������Ԫ���б�</a>
  </body>
</html>
