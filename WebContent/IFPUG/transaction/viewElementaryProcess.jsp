<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEi" %>
<%@ page import="hibernate.IFPUG.IfpugEo" %>
<%@ page import="hibernate.IFPUG.IfpugEq" %>
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
    
    <title>My JSP 'productBasicInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
  <%
  	/*��ȡ��ҳ��productList.jsp����productId*/
      Integer epId = new Integer(request.getParameter("epId"));
      Integer type = new Integer(request.getParameter("type"));
      /*�����ݿ��а�idΪproductId��������ȡ��*/
      RequirementBusiness rb = new RequirementBusiness(); //ҵ��㣬��Ӧ��IFPUG�����Ĳ��Խ׶�
      Object epObject = rb.getElementaryProcessById(type,epId);
      String showStatus = null, productName = null, functionName = null, epName = null, epDesp = null;
      Integer productId, functionId;
      Integer ufpCount = 0;
      IfpugFunction function = null;
      switch(type)
      {
      	case 0: 
      		IfpugEi ei = (IfpugEi)epObject;
      		functionName = ei.getIfpugFunction().getFunctionName();
      		epName = ei.getEiName();
      		epDesp = ei.getEiDesp();
      		showStatus = rb.changeMeausreStatus(ei.getMeasureStatus());
      		ufpCount = ei.getUfpCount();
      		function = ei.getIfpugFunction();
      		break;
      	case 1:
      		IfpugEo eo = (IfpugEo)epObject;
      		functionName = eo.getIfpugFunction().getFunctionName();
      		epName = eo.getEoName();
      		epDesp = eo.getEoDesp();
      		showStatus = rb.changeMeausreStatus(eo.getMeasureStatus());
      		ufpCount = eo.getUfpCount();
      		function = eo.getIfpugFunction();
      		break;
      	case 2:
      		IfpugEq eq = (IfpugEq)epObject;
      		functionName = eq.getIfpugFunction().getFunctionName();
      		epName = eq.getEqName();
      		epDesp = eq.getEqDesp();
      		showStatus = rb.changeMeausreStatus(eq.getMeasureStatus());
      		ufpCount = eq.getUfpCount();
      		function = eq.getIfpugFunction();
      		break;
      }

   
     	 while(function.getIfpugProduct() == null)
     	 {
      		 function = function.getIfpugFunction();
     	 }

      productName = function.getIfpugProduct().getProductName();
      functionId = function.getId();
      productId =  function.getIfpugProduct().getId();
   %>
  
   <table>
    <tr>
    	<td>����������ϸ��Ϣ</td>
    </tr>
     <tr>
    	<td valign="top" width="20%">������Ʒ��</td>
    	<td><%=productName %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">��������ģ�飺</td>
    	<td><%=functionName%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�����������ƣ�</td>
    	<td valign="top"><%=epName %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">�����������ͣ�</td>
    	<td valign="top"><%=rb.changeEpType(type) %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">��������������</td>
    	<td><%=epDesp%></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">�������̹���״̬��</td>
    	<td><%=showStatus%></td>
    </tr>
      <tr>
    	<td valign="top" width="20%">�������̹��ܵ������</td>
    	<td><%=ufpCount%></td>
    </tr>
    </table>
  	<a href="/ifpug/IFPUG/transaction/addMethodToEp.jsp?productId=<%=functionId%>&&functionId=<%=functionId%>">�� ��</a>
    </body>
</html>
