<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>计算功能点</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript">  
	function loadContent(ufpMethod,dfId,typeId){
 	 if(ufpMethod == 1)		document.frames["methodFrame"].location.replace("/ifpug/IFPUG/dataFunction/defaultMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&dfId="+dfId);
 	 //如果选择了“默认”方法，页面下半部分载入defaultMethod.jsp
 	 else if(ufpMethod == 2 ) document.frames["methodFrame"].location.replace("/ifpug/IFPUG/dataFunction/rangeMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&dfId="+dfId);
 	 //如果选择了“用户选择”方法，页面下半部分载入rangeMethod.jsp
 	 else if(ufpMethod == 3) document.frames["methodFrame"].location.replace("/ifpug/IFPUG/dataFunction/valueMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&dfId="+dfId);
 	 //如果选择了“用户输入”方法，页面下半部分载入valueMethod.jsp
 	 else document.frames["methodFrame"].location.replace("/ifpug/IFPUG/dataFunction/complexMethod.jsp?ufpMethod="+ufpMethod+"&&type="+typeId+"&&dfId="+dfId);
	 //如果选择了“选择复杂度”方法，页面下半部分载入complexMethod.jsp
	}
	</script>
  </head>
  <body>
  <%
  	Integer ufpMethod= new Integer(request.getParameter("ufpMethod"));
  	Integer type= new Integer(request.getParameter("type"));
  	Integer dfId = new Integer(request.getParameter("dfId"));

   	String srcName= null;
   	if(ufpMethod == 1) srcName = "/ifpug/IFPUG/dataFunction/defaultMethod.jsp";
   	else if(ufpMethod == 2) srcName = "/ifpug/IFPUG/dataFunction/rangeMethod.jsp";
   	else if(ufpMethod == 3) srcName = "/ifpug/IFPUG/dataFunction/valueMethod.jsp";
   	else srcName = "/ifpug/IFPUG/dataFunction/complexMethod.jsp";
   %>
   <a><h1>计算功能点数</h1></a>
   
   <form name="selectMethodForm">
   	<table>
   		<tr>
   		<td><h1>您当前选择的计算方法</h1></td>
   		<td>
   			<input type="radio" value="1" name="ufpMethod" onclick="loadContent(1,<%=dfId%>,<%=type %>);" />默认功能点个数
   			<input type="radio" value="2" name="ufpMethod" onclick="loadContent(2,<%=dfId%>,<%=type %>);"/>选择DET范围
   			<input type="radio" value="3" name="ufpMethod" onclick="loadContent(3,<%=dfId%>,<%=type %>);"/>输入DET个数
   			<input type="radio" value="4" name="ufpMethod" onclick="loadContent(4,<%=dfId%>,<%=type %>);"/>选择复杂度
   			<script language="javascript">   
                  var method = document.getElementsByName("ufpMethod");
                  method[<%=ufpMethod%> - 1].checked = true; //选中对应的方法
           </script>
   		</td>
   		</tr>
   	</table>
   	<input type="hidden" name="id" value="<%=dfId%>"/>
   	<input type="hidden" name="type" value="<%=type%>"/>
   	<input type="hidden" name="dfId" value="<%=dfId%>"/>
   </form>
   <iFrame src="<%=srcName%>?ufpMethod=<%=ufpMethod%>&&dfId=<%=dfId%>&&type=<%=type%>" id="methodFrame" frameborder="0" height="800px" width="100%" scrolling="no">
   </iFrame>
  </body>
</html>
