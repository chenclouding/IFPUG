<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%@ page import="hibernate.IFPUG.IfpugIlf" %>
<%@ page import="hibernate.IFPUG.IfpugEif" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'saveFpc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
  <%
  	String tcf = request.getParameter("tcf");
  	String fpc = request.getParameter("fpc");
  	Integer productId = new Integer(request.getParameter("productId"));
  	RequirementBusiness rb = new RequirementBusiness();
  	IfpugProduct product = (IfpugProduct) rb.getProductById(productId);
  	product.setMeasureStatus(Short.valueOf("2"));
  	System.out.println(tcf + ":" + fpc);
  	String count;
  	int i, flag = 0;

  	for (i = 0; i < fpc.length(); i++) {
  		if (fpc.charAt(i) == '.') {
  			flag = 1;
  			break;
  		}
  	}
  	if (flag == 1) {
  		count = fpc.substring(0, i);
  		if (fpc.charAt(i + 1) >= '5')
  			product.setUfpCount(Integer.parseInt((count) + 1));
  		else
  			product.setUfpCount(Integer.parseInt((count)));
  	}
  	else{
  			product.setUfpCount(Integer.parseInt(fpc));
  	}

  
  	boolean result = rb.updateProduct(product);
  	if (result == true) {
  		response.sendRedirect("/ifpug/IFPUG/adjustUfp.jsp?tcf=" + tcf
  				+ "&fpc=" + fpc + "&productId=" + productId);
  	} else {
  		response.sendRedirect("/ifpug/IFPUG/failure.jsp");
  	}
  %>
   
   
  </body>
</html>