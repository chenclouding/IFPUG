<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %>
<%@ page import="hibernate.IFPUG.IfpugEi" %>
<%@ page import="hibernate.IFPUG.IfpugEo" %>
<%@ page import="hibernate.IFPUG.IfpugEq" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ɾ����������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">

  </head>
  
  <body>
    <%
      //��ҳ��Ϊɾ���������̵�ҳ�棬ɾ�������践��elementaryProcessList.jsp,�ش�functionId.
      Integer epId = new Integer(request.getParameter("epId"));//��ȡ��ҳ��elementaryProcessList.jsp����epId,����ɾ������
	  Integer epType = Integer.valueOf(request.getParameter("type"));
	  RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯������װ����������е���ɾ�Ĳ�Ȳ���
	  Object epObject = rb.getElementaryProcessById(epType,epId);//ͨ��epID��ȡEP����
	  IfpugFunction function = null;
	  //���ݻ����������͵Ĳ�ͬ���ڲ�ͬ���ݿ���л�ȡ�������̶�Ӧ�Ĺ���ģ��ID
	  if (epType == 0){
	  		IfpugEi ei = (IfpugEi)epObject;
	  		function = ei.getIfpugFunction();
	  }
	  else if (epType == 1){
	  		IfpugEo eo = (IfpugEo)epObject;
	  		function = eo.getIfpugFunction();
	  }
	  else {
	  		IfpugEq eq = (IfpugEq)epObject;
	  		function = eq.getIfpugFunction();
	  }
      Integer functionId = function.getId();
       //ɾ�����������Ӧ����������
      boolean result = rb.delElementaryProcessById(epType,epId);
      if(result==true){
      	response.sendRedirect("/ifpug/IFPUG/requirement/elementaryProcessList.jsp?functionId="+functionId);
      }
  %>
  </body>
</html>
