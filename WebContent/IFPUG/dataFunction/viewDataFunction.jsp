<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugProduct"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewDataFunction.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
  <%
  	//��ȡ��ҳ��dataFunctionList.jsp����dfId��type,���ڲ鿴����
       Integer dfId = new Integer(request.getParameter("dfId"));
       Integer type = new Integer(request.getParameter("type"));
       DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼���
       Integer productId, ufpCount;
       String name = null, desp = null;
       Short ufpMethod ;
       if(type == 0){ //�����ILF�ļ�
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		name = ilf.getIlfName();
       		desp = ilf.getIlfDesp();
       		ufpMethod = ilf.getUfpMethod();   
       		ufpCount = ilf.getUfpCount();    	
       		productId = ilf.getIfpugProduct().getId();	
       }
       else { //�����EIF�ļ�
       		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
       		name = eif.getEifName();
       		desp = eif.getEifDesp();
       		ufpMethod = eif.getUfpMethod();
       		ufpCount = eif.getUfpCount();
       		productId = eif.getIfpugProduct().getId();
       }
       RequirementBusiness rb = new RequirementBusiness();
       IfpugProduct ip = (IfpugProduct)rb.getProductById(productId);
       
       
   %>
      <table>
    <tr>
    	<td>���ݹ�����ϸ��Ϣ</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�ļ����ƣ�</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">������Ʒ��</td>
    	<td><%=ip.getProductName() %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�ļ����ͣ�</td>
    	<td valign="top"><%= dfb.getTypeName(type) %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">���㷽�����ͣ�</td>
    	<td valign="top"><%= dfb.getMethodName(ufpMethod) %></td>
    </tr>
     <tr>
    	<td valign="top" width="20%">�ļ�������</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">���ܵ������</td>
    	<td><%=ufpCount%></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId %>&&dfId=<%=dfId %>">�� ��</a>
  </body>
</html>
