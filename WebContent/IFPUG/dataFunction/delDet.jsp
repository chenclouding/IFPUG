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
      String type = request.getParameter("type");
      DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层
      boolean result = false;
      Integer retId;
      //根据文件类型的不同调用不同的函数对不同的RET表操作，删除RET记录
      if(type.equals("0")){//如果是ILF类型的文件，delIlfDetById(id)函数
      		IfpugIlfDet ilfDet = (IfpugIlfDet)dfb.queryIlfDetById(detId);
      		retId = ilfDet.getIfpugIlfRet().getId();
      		result = dfb.delIlfDetById(detId);
      }
      else {//如果是EIF文件，delEifDetById(id)函数
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
