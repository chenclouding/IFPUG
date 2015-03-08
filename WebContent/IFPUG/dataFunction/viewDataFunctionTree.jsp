<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.*" %>
<%@ page import="hibernate.IFPUG.*" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看数据功能点树</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>

 
    <%  
       RequirementBusiness rb = new RequirementBusiness(); 
       String userName = (String)session.getAttribute("userName");
       /*从数据库中把所有软件的估算信息取出*/
       //List productList = rb.getAllProduct(userName); 
      UserBusiness ub = new UserBusiness();
      IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
      Object[] productList = user.getIfpugProducts().toArray();
      
       if(productList == null||productList.length == 0){//如果没有添加product 
      } 

    %>
    <table>
     <tr>
       <td valign ="bottom" width="90px">请选择产品</td>
        <td>
		    <form  action="/ifpug/IFPUG/dataFunction/viewDataFileTree.jsp"  method="post" target="functionFrame" >
		      	<select name="productId" style="width:160px">
		      	 <%
		      	     for(Object p:productList){
		      	        IfpugProduct fp = (IfpugProduct)p;%>
		      	        <option value="<%=fp.getId()%>"><%=fp.getProductName()%></option>
		      	  <%}%>
			 	   
			    </select>
			     <input type="submit" name="submit" value="提交"/>
		    </form>
		</td>
	  </tr>
	</table>   
    <iFrame name="functionFrame" frameborder="0" height="800px" width="100%" scrolling="auto">
    </iFrame>
  </body>
</html>