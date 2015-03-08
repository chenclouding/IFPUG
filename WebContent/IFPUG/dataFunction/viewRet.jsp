<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%> 
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
   //��ȡ��ҳ��retList.jsp����retId��type,�����޸Ĳ��� 
       Integer retId = new Integer(request.getParameter("retId")); 
       String type = request.getParameter("type"); 
       DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼��� 
       String name = null; //ret������ 
       String desp = null;//ret������ 
       String dfName = null; //���ݹ��ܵ�����
       Integer dfId;//ret��Ӧ��ILF\EIF��id
       Integer detCount; //����DET�ĸ���
         
         
       if(type.equals("0")){//�����ILF��ret 
       		IfpugIlfRet ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId); 
       		name = ilfRet.getIlfRetName(); 
       		desp = ilfRet.getIlfRetDesp(); 
       		dfId = ilfRet.getIfpugIlf().getId();
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		dfName = ilf.getIlfName();
       		detCount = ilfRet.getIfpugIlfDets().size();
       } 
       else{//�����EIF��ret 
       		IfpugEifRet eifRet = (IfpugEifRet)dfb.queryEifRetById(retId); 
       		name = eifRet.getEifRetName(); 
       		desp = eifRet.getEifRetDesp(); 
       		dfId = eifRet.getIfpugEif().getId(); 
       		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
       		dfName = eif.getEifName();
       		detCount = eifRet.getIfpugEifDets().size();
       } 
       
       
   %>
      <table>
    <tr>
    	<td>���ݹ�����ϸ��Ϣ</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">RET���ƣ�</td>
    	<td><%=name%></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�ļ�������</td>
    	<td valign="top"><%=desp %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�������ݹ������ƣ�</td>
    	<td><%=dfName %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">�������ݹ������ͣ�</td>
    	<td valign="top"><%= dfb.getTypeName(Integer.valueOf(type)) %></td>
    </tr>
    <tr>
    	<td valign="top" width="20%">����DET������</td>
    	<td><%= detCount%></td>
    </tr>
    </table>
    	<a href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>">�� ��</a>
  
   
  </body>
</html>
