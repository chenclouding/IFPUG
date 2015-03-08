<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>

<%@ page import="business.IFPUG.MeasureReport" %>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<jsp:useBean id="projectMeasureBean" scope="session" class="javaBeans.fsm.ProjectMeasureBean"/>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'measureReport.jsp' starting page</title>
    <link rel="StyleSheet" href="/gcgl/javascript/dtree.css" type="text/css" />
	<script type="text/javascript" src="/gcgl/javascript/dtree.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="jscript" src="../javascript/newtable.js"></script>
	
	<link rel="StyleSheet" href="/fsmch/fsmch/javascript/dtree.css" type="text/css" />
    <link rel="stylesheet" type="text/css" href="/gcgl/images/screen.css"> 
  </head>
  
  <body>
  <%  
      
       Integer productId = new Integer(request.getParameter("productId"));
       MeasureReport mr = new MeasureReport();
       String code = mr.exportMeasureReport(productId);          
  %>  
 <%=code %>
 <a href="/gcgl/IFPUG/measureReport1.jsp?productId=<%=productId %>"> 导出度量报告到word</a>
  </body>
</html>
