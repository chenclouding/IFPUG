<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugIlfDet" %>
<%@ page import="hibernate.IFPUG.IfpugEifDet" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ɾ������Ԫ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <%
    //��ȡ��ҳ��detList.jsp����detId��type,����ɾ������
      Integer detId = new Integer(request.getParameter("detId"));
      String type = request.getParameter("type");
      DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼���
      boolean result = false;
      Integer retId;
      //�����ļ����͵Ĳ�ͬ���ò�ͬ�ĺ����Բ�ͬ��RET�������ɾ��RET��¼
      if(type.equals("0")){//�����ILF���͵��ļ���delIlfDetById(id)����
      		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
      		retId = ilfDet.getIfpugIlfRet().getId();
      		result = dfb.delIlfDetById(detId);
      }
      else {//�����EIF�ļ���delEifDetById(id)����
      		IfpugEifDet eifDet = (IfpugEifDet)dfb.queryEifDetById(detId);
      		retId = eifDet.getIfpugEifRet().getId();
      		result = dfb.delEifDetById(detId);
      }
      
      if(result==true){
          response.sendRedirect("/ifpug/IFPUG/dataFunction/detList.jsp?type="+type+"&&retId="+retId);
      }
      else {
          response.sendRedirect("/ifpug/IFPUG/failure.jsp");
      }
   %>
  </body>
</html>
