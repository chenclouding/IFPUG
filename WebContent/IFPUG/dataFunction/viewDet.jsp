<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%> 
<%@ page import="hibernate.IFPUG.IfpugEifDet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfDet"%> 
<%@ page import="hibernate.IFPUG.IfpugProduct"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewRet.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <%
    //��ȡ��ҳ��detList.jsp����detId��type,�����޸Ĳ��� 
       Integer detId = new Integer(request.getParameter("detId")); 
       String type = request.getParameter("type"); 
       DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼��� 
       String name = null; //ret������ 
       String desp = null;//ret������ 
       Integer retId;//ret��Ӧ��ILF\EIF��id
       String retName; //ret������
         
         
       if(type.equals("0")){//�����ILF��det 
       		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
       		name = ilfDet.getIlfDetName();
       		desp = ilfDet.getIlfDetDesp();
       		retId = ilfDet.getIfpugIlfRet().getId();
       		IfpugIlfRet iir = (IfpugIlfRet)dfb.queryIlfRetById(retId);
       		retName = iir.getIlfRetName();
       } 
       else{//�����EIF��det 
       		IfpugEifDet eifDet = (IfpugEifDet)dfb.queryEifDetById(detId);
       		name = eifDet.getEifDetName();
       		desp = eifDet.getEifDetDesp();
       		retId = eifDet.getIfpugEifRet().getId();
       		IfpugEifRet ier = (IfpugEifRet)dfb.queryEifRetById(retId);
       		retName = ier.getEifRetName();
       } 
       
   %>
      <table>
    <tr>
    	<td>���ݹ�����ϸ��Ϣ</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">DET���ƣ�</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�ļ�������</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">����Ret���ƣ�</td>
    	<td><%=retName %></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/detList.jsp?type=<%=type%>&&retId=<%=retId%>">�� ��</a>
  
   
  </body>
</html>
