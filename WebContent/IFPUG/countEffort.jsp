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
    
    <title>My JSP 'countEffort.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="javascript">
	function calcuEffort(fp)
	{
		var v1 = document.getElementById('devTime').value;
		var v2 = document.getElementById('member').value;
		document.getElementById('effort').display = "";
		document.getElementById('effort').value = v2/v1;
	}
	</script>
  </head>

	<body>
	<%
		Integer productId = new Integer(request.getParameter("productId"));
		RequirementBusiness rb = new RequirementBusiness();
		IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
		int fp = product.getUfpCount();
		
	
	 %>
		<table style="width:440px">
			<tr>
				<td width="35%">软件规模</td>
				<td>
					<input type="text" id="member"name="member" style="width: 160px" value=""/ >
				</td>
			</tr>
			<tr>
  				<td width="35%">生产率：</td>
  				<td >
  			    	<input type="text"id="devTime" name="devTime" style="width:160px" value=""/ >
           		 </td>
  			</tr>
  			<tr>
  		    <td>
  				<input type="button" name="submit" value=" 确  定 " onclick="return calcuEffort(<%=fp%>);"/>
  			</td>
  		</tr>
  			<tr >
  				<td width="35%">工作量(每人天)</td>
  				<td >
  			    	<input type="text" id="effort"  name="effort" style="width:160px" value=""/>人天
           		 </td>
  			</tr>
		</table>

	</body>
</html>
