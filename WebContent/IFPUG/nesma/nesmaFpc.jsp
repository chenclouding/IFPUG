<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.MeasureReport" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
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
    
    <title>�򻯹��ܵ����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">

  </head>
  
  <body>
  <%
  	Integer productId = new Integer(request.getParameter("productId"));
  	RequirementBusiness rb = new RequirementBusiness();
  	IfpugProduct product = (IfpugProduct) rb.getProductById(productId);
  	// �õ��ô������Ʒ��ILF��EIF�ĸ���
  	int ilfNum = product.getIfpugIlfs().size();
  	int eifNum = product.getIfpugEifs().size();

  	Object[] functionList = product.getIfpugFunctions().toArray();

  	MeasureReport mr = new MeasureReport();
  	if (functionList != null && functionList.length != 0) {
  		for (Object f : functionList) {
  			mr.getEpFromFunction(f);
  		}
  	}
  	// �õ��ô������Ʒ��EI,EO,EQ�ĸ���
  	int eiNum = mr.eiList.size();
  	int eoNum = mr.eoList.size();
  	int eqNum = mr.eqList.size();
  	
  	int estimatedNum = 7*ilfNum +5*eifNum+4*eiNum+4*eoNum+5*eqNum;
  	int indicativeNum = 35*ilfNum + 15*eifNum;
  %>
  <table style="width:740px">
 	<tr>
  		<td>�������Ʒ������Ϣ</td>
  	</tr>
  	<tr>
  		<td>ILF������<%=ilfNum %></td>
  	</tr>
  	<tr>
  		<td>EIF������<%=eifNum %></td>
  	</tr>
  	<tr>
  		<td>EI������<%=eiNum %></td>
  	</tr>
  	<tr>
  		<td>EO������<%=eoNum %></td>
  	</tr>
  	<tr>
  		<td>EQ������<%=eqNum %></td>
  	</tr>
  </table>
  
    <table style="width:740px">
 	<tr>
  		<td>NESMA�򻯹��ܵ���</td>
  	</tr>
  	<tr>
  		<td>Estimated�������ܵ������<%=estimatedNum %></td>
  	</tr>
  	<tr>
  		<td>Indicative�������ܵ������<%=indicativeNum %></td>
  	</tr>
  
  </table>
     
  </body>
</html>
