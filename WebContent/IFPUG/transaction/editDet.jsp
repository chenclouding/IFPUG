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
    
    <title>�޸�����Ԫ��</title>
    
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
         
         
       if(type.equals("0")){//�����ILF��ret 
       		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
       		name = ilfDet.getIlfDetName();
       		desp = ilfDet.getIlfDetDesp();
       		retId = ilfDet.getIfpugIlfRet().getId();
       } 
       else{//�����EIF��ret 
       		IfpugEifDet eifDet = (IfpugEifDet)dfb.queryEifDetById(detId);
       		name = eifDet.getEifDetName();
       		desp = eifDet.getEifDetDesp();
       		retId = eifDet.getIfpugEifRet().getId();
       } 
   %>
   <form  action="/ifpug/IFPUG/editDet.do" >
  	 <table>
  		<tr>
  			<td width="15%">��������</td>
  			<td >
  			    <input type="text" name="detName" style="width:160px" value="<%=name %>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">��������</td>
  			<td >
  			    <textarea name="detDesp"><%=desp %></textarea>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" �� �� "/>
    <input type='button' onclick="Javascript:window.location='detList.jsp?retId=<%=retId%>&&type=<%=type%>'" value=" �� �� ">
  	<input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="detId" value="<%=detId%>"/>
    <input type="hidden" name="id" value="<%=detId%>"/>
    <input type="hidden" name="retId" value="<%=retId%>"/>
  	</form> 			
  </body>
</html>
