<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG.IfpugProduct" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ɾ��������ģ��</title>
    
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
   <%
      //��ҳ��Ϊɾ��������ģ���ҳ�棬ɾ�������践��functionList.jsp,�ش�productId.
      Integer functionId = new Integer(request.getParameter("functionId"));//��ȡ��ҳ��functionList.jsp����functionId,����ɾ������
	  RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯������װ����������е���ɾ�Ĳ�Ȳ���
      IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
      IfpugProduct product = (IfpugProduct)function.getIfpugProduct();
      Integer productId = product.getId();
    
      //ɾ�����������Ӧ����������
      boolean result = rb.delFunctionById(functionId);
      if(result==true){
      	response.sendRedirect("/ifpug/IFPUG/requirement/functionList.jsp?productId="+productId);
      }
  %>
  <body>
</html>
