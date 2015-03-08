<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'productMethod.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<style type="text/css">
	a {
      float:right;
      background:url("/ifpug/IFPUG/images/tableftI.gif") no-repeat left top;
      margin:0;
      padding:0 0 0 5px;
      text-decoration:none;
      }
      span {
      float:right;
      display:block;
      background:url("/ifpug/IFPUG/images/tabrightI.gif") no-repeat right top;
      padding:5px 15px 4px 6px;
      color:#FFF;
      float:none;
      }
    </style>
  </head>
  
  <body>
      <table borderColor="#3cb371" cellSpacing="0" cellPadding="0"  align=center border =1>
    <tr>
    	<td style="FILTER:Blur(Add=true,Direction=180, Strength=20)" bgColor="#3cb371" height="22">
    	产品详细信息
    	</td>
    	<td style="FILTER:Blur(Add=true,Direction=180, Strength=20)" bgColor="#3cb371" height="22">
    	</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">方法：</td>
    	<td valign="top">方法介绍</td>
    </tr>
    <tr>
    	<td valign="top" width="20%">方法介绍：</td>
    	<td>产品就是我们即将要进行估算的软件部分。</td>
    </tr>
     </table>
     <a href="Javascript:window.parent.location='/ifpug/IFPUG/requirement/productList.jsp'"><span>返 回</span></a>
  </body>
</html>
