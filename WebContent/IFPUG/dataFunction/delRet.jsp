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
    
    <title>删除记录元素</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
    <%
    //获取从页面retList.jsp传来retId和type,用于删除操作
      Integer retId = new Integer(request.getParameter("retId"));
      String type = request.getParameter("type");
      DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层
      boolean result = false;
      Integer dfId;
      //根据文件类型的不同调用不同的函数对不同的RET表操作，删除RET记录
      if(type.equals("0")){//如果是ILF类型的文件，delIlfRetById(id)函数
      		IfpugIlfRet ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId);
      		dfId = ilfRet.getIfpugIlf().getId();
      		result = dfb.delIlfRetById(retId);
      }
      else {//如果是EIF文件，delEifRetById(id)函数
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
