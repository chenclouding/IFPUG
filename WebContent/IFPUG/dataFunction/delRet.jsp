<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugIlfRet" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ɾ����¼Ԫ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
    <%
    //��ȡ��ҳ��retList.jsp����retId��type,����ɾ������
      Integer retId = new Integer(request.getParameter("retId"));
      String type = request.getParameter("type");
      DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼���
      boolean result = false;
      Integer dfId;
      //�����ļ����͵Ĳ�ͬ���ò�ͬ�ĺ����Բ�ͬ��RET�������ɾ��RET��¼
      if(type.equals("0")){//�����ILF���͵��ļ���delIlfRetById(id)����
      		IfpugIlfRet ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId);
      		dfId = ilfRet.getIfpugIlf().getId();
      		result = dfb.delIlfRetById(retId);
      }
      else {//�����EIF�ļ���delEifRetById(id)����
      		IfpugEifRet eifRet = (IfpugEifRet)dfb.queryEifRetById(retId);
      		dfId = eifRet.getIfpugEif().getId();
      		result = dfb.delEifRetById(retId);
      }
      
      if(result==true){
          response.sendRedirect("/ifpug/IFPUG/dataFunction/retList.jsp?type="+type+"&&dfId="+dfId);
      }
      else {
          response.sendRedirect("/ifpug/IFPUG/failure.jsp");
      }
   %>
  </body>
</html>
