<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG.IfpugProduct" %> 
<%@page import="business.IFPUG.RequirementBusiness;"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ɾ���ӹ���ģ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<%Integer functionId = new Integer(request.getParameter("functionId"));//��ȡ��ҳ��functionList.jsp����functionId,����ɾ������ 
	  RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯������װ����������е���ɾ�Ĳ�Ȳ��� 
	  IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId); 
      Integer fatherId = function.getIfpugFunction().getId();//�ҵ�����ģ���ֱ�Ӹ�ģ�飬���Id������ҳ����ת
      //ɾ�����������Ӧ���������� 
      boolean result = rb.delFunctionById(functionId); 
      if(result==true){ 
      	  response.sendRedirect("/ifpug/IFPUG/requirement/childFunctionList.jsp?functionId="+fatherId); 
      } 
  %>
  
  </body>
</html>





