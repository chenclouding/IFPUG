<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>���㹦�ܵ�</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript">  
	function loadContent(ufpMethod,epId,typeId,epType){
 	 if(ufpMethod == 1)		document.frames["methodFrame"].location.replace("/ifpug/IFPUG/transaction/defaultMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&epId="+epId+"&&epType="+epType);
 	 else if(ufpMethod == 2 ) document.frames["methodFrame"].location.replace("/ifpug/IFPUG/transaction/rangeMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&epId="+epId+"&&epType="+epType);
 	 else if(ufpMethod == 3) document.frames["methodFrame"].location.replace("/ifpug/IFPUG/transaction/valueMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&epId="+epId+"&&epType="+epType);
 	 else document.frames["methodFrame"].location.replace("/ifpug/IFPUG/transaction/complexMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&epId="+epId+"&&epType="+epType);
	}
	</script>
  </head>
  <body>
  <%
  	Integer ufpMethod= new Integer(request.getParameter("ufpMethod"));
  	Integer type= new Integer(request.getParameter("type"));
  	Integer epId = new Integer(request.getParameter("epId"));
	String epType = request.getParameter("epType");
   	String srcName= null;
   	if(ufpMethod == 1) srcName = "/ifpug/IFPUG/transaction/defaultMethod.jsp";
   	else if(ufpMethod == 2) srcName = "/ifpug/IFPUG/transaction/rangeMethod.jsp";
   	else if(ufpMethod == 3) srcName = "/ifpug/IFPUG/transaction/valueMethod.jsp";
   	else srcName = "/ifpug/IFPUG/transaction/complexMethod.jsp";
   %>
   <a><h1>���㹦�ܵ���</h1></a>
   
   <form name="selectMethodForm">
   	<table>
   		<tr>
   		<td><h1>����ǰѡ��ļ��㷽��</h1></td>
   		<td>
   			<input type="radio" value="1" name="ufpMethod" onclick="loadContent(1,<%=epId%>,<%=type %>,'<%=epType%>');" />Ĭ�Ϲ��ܵ����
   			<input type="radio" value="2" name="ufpMethod" onclick="loadContent(2,<%=epId%>,<%=type %>,'<%=epType%>');"/>ѡ��DET��Χ
   			<input type="radio" value="3" name="ufpMethod" onclick="loadContent(3,<%=epId%>,<%=type %>,'<%=epType%>');"/>����DET����
   			<input type="radio" value="4" name="ufpMethod" onclick="loadContent(4,<%=epId%>,<%=type %>,'<%=epType%>');"/>ѡ���Ӷ�
   			<script language="javascript">   
                  var method = document.getElementsByName("ufpMethod");
                  method[<%=ufpMethod%> - 1].checked = true; //ѡ�ж�Ӧ�ķ���
           </script>
   		</td>
   		</tr>
   	</table>
   	<input type="hidden" name="id" value="<%=epId%>"/>
   	<input type="hidden" name="type" value="<%=type%>"/>
   	<input type="hidden" name="epId" value="<%=epId%>"/>
   	<input type="hidden" name="epType" value="<%=epType%>"/>
   </form>
   <iFrame src="<%=srcName%>?ufpMethod=<%=ufpMethod%>&&epId=<%=epId%>&&type=<%=type%>&&epType=<%=epType%>" id="methodFrame" frameborder="0" height="800px" width="100%" scrolling="no">
   </iFrame>
  </body>
</html>
