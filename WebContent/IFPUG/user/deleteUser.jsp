<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.UserBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugUser" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员--删除用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <%
      Integer userId =  new Integer(request.getParameter("userId"));//get Parameter from admin.jsp   
      UserBusiness ub = new UserBusiness(); 
      boolean delete = ub.delUserById(userId);    
       if(delete==true){ 
           response.sendRedirect("/ifpug/IFPUG/user/admin.jsp"); 
        }else{
           response.sendRedirect("/ifpug/IFPUG/failure.jsp");
        }       
   %>
  </body>
</html>
