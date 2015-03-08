<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'viewProduct.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<style type="text/css">
    body {
		margin:0;
		padding:0;
		font:  11px/1.5em Verdana;
	}

	h2 {
		font: bold 20px Verdana, Arial, Helvetica, sans-serif;
		color: #000;
		margin: 0px;
		padding: 0px 0px 0px 15px;
	}

	img {
		border: none;
	} 
	
	/*- Menu Tabs I--------------------------- */

    #tabsI {
      float:left;
      width:100%;
      background:#EFF4FA;
      font-size:12px;
      line-height:normal;
	  border-bottom:1px solid #DD740B;
      }
    #tabsI ul {
	margin:0;
	padding:10px 10px 0 50px;
	list-style:none;
      }
    #tabsI li {
      display:inline;
      margin:0;
      padding:0;
      }
    #tabsI a {
      float:left;
      background:url("/ifpug/IFPUG/images/tableftI.gif") no-repeat left top;
      margin:0;
      padding:0 0 0 5px;
      text-decoration:none;
      }
    #tabsI a span {
      float:left;
      display:block;
      background:url("/ifpug/IFPUG/images/tabrightI.gif") no-repeat right top;
      padding:5px 15px 4px 6px;
      color:#FFF;
      }
    /* Commented Backslash Hack hides rule from IE5-Mac \*/
    #tabsI a span {float:none;}
    /* End IE5-Mac hack */
    #tabsI a:hover span {
      color:#FFF;
      }
    #tabsI a:hover {
      background-position:0% -42px;
      }
    #tabsI a:hover span {
      background-position:100% -42px;
      }
    #tabsI a:active span {
      color:#FFF;
      }
    #tabsI a:active {
      background-position:0% -42px;
      }
    #tabsI a:active span {
      background-position:100% -42px;
      }
	
      
	</style>
  </head>
  
  <body>
   <%
 	 String back = "function"; 
  	 Integer functionId = new Integer(request.getParameter("functionId"));//获取从页面productList.jsp传来的软件productId
   %> 
   <div id="tabsI">
  	<ul>
    	<li><a href="Javascript:window.frames['showProductframe'].location.replace('/ifpug/IFPUG/requirement/functionBasicInfo.jsp?functionId=<%=functionId%>')" title="产品信息"><span>查看基本信息</span></a></li>
    	<li><a href="Javascript:window.frames['showProductframe'].location.replace('/ifpug/IFPUG/requirement/functionMethod.jsp?back=<%=back%>&functionId=<%=functionId%>');"title="方法介绍"><span>方法介绍</span></a></li>
    </ul>
   </div>
     <iframe name="showFunctionframe" src="/ifpug/IFPUG/requirement/functionBasicInfo.jsp?functionId=<%=functionId%>" width="70%" height="500" frameborder="0" scrolling="auto"/>
  
  </body>
</html>
