<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
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
    
    <title>删除数据元素</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <%
    //获取从页面detList.jsp传来detId和type,用于删除操作
      Integer detId = new Integer(request.getParameter("detId"));
      Integer type =  new Integer(request.getParameter("type"));
      Integer epId = new Integer(request.getParameter("epId"));
	  String epType = request.getParameter("epType");
	  Integer ufpMethod = new Integer(request.getParameter("ufpMethod"));
      TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();//业务逻辑层
      boolean result = false;
      System.out.println(detId);
      //根据文件类型的不同调用不同的函数对不同的RET表操作，删除RET记录
      if(type == 0){//如果是ILF类型的文件，delIlfDetById(id)函数
      		result = tfb.delEiDetById(detId);
      }
      else if(type == 1){//如果是EIF文件，delEifDetById(id)函数
      		result = tfb.delEoDetById(detId);
      }
      else result = tfb.delEqDetById(detId);
      
      if(result==true){
          response.sendRedirect("/ifpug/IFPUG/transaction/derivedMethod.jsp?type="+type+"&&epId="+epId+"&&epType="+epType+"&&ufpMethod="+ufpMethod);
      }
      else {
          response.sendRedirect("/ifpug/IFPUG/failure.jsp");
      }
   %>
  </body>
</html>
