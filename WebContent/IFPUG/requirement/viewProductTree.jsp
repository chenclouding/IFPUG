<%@ page contentType="text/html; charset=gb2312" language="java" import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@ page import="hibernate.IFPUG.*" %>
<%@ page import="business.IFPUG.ViewProductReportTreeService" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    
    <title>My JSP 'productMeasureReport.jsp' starting page</title>
   
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="jscript" src="../javascript/newtable.js"></script>
	<link rel="StyleSheet" href="/ifpug/javascript/dtree.css" type="text/css" />
	<script type="text/javascript" src="/ifpug/javascript/dtree.js"></script>
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css"> 
  </head>
  
  <body>
  <%  
      
      Integer productId =  new Integer(request.getParameter("productId"));
      
      ViewProductReportTreeService vprts = new ViewProductReportTreeService();     	  
	  String tree = vprts.buildReportTree(productId);
  %>
  
      <div class="dtree">
		<script type="text/javascript">	
			d = new dTree('d');
			<%=tree%>
			document.write(d);
     	</script>
	  </div>       			        
  </body>
</html>
