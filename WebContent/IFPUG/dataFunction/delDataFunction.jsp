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
    
    <title>ɾ�����ݹ���</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
    <%
    //��ȡ��ҳ��dataFunctionList.jsp����dfId��type,����ɾ������
      Integer dfId = new Integer(request.getParameter("dfId"));
      Integer type = new Integer(request.getParameter("type"));
      DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼���
      Integer productId;
      boolean result = false;
      if(type == 0){//�����ILF���͵��ļ�������delIlfById(id)����
      		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
      		productId = ilf.getIfpugProduct().getId();
      		result = dfb.delIlfById(dfId);
      	
      }
      else {//�����EIF�ļ�������delEifById(id)����
      		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
      		productId = eif.getIfpugProduct().getId();
      		result = dfb.delEifById(dfId);
      }
      if(result==true){
          response.sendRedirect("/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId="+productId);
      }
      else {
          response.sendRedirect("/ifpug/IFPUG/failure.jsp");
      }
   %>
  </body>
</html>
