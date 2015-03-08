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
    
    <title>增加基本流程-选择功能模块</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
    <script language="javascript">
       var http_request = false;
       function functionSelectAjax(){    
	    if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var dfs = http_request.responseText;
               
               while(document.getElementById("functionId").options.length>0){
                   document.getElementById("functionId").options.remove(0);
               }
               if(dfs!=""){
	               var funcList = dfs.split(",");
	                var i =0 ;     
	                //在下拉框中增加一个提示按钮“请选择“
	                var aOption = document.createElement("OPTION");
	                aOption.value="";
	                aOption.text = "=请选择=";
	                document.getElementById("functionId").add(aOption);
	                while(i<funcList.length){
	                  var aOption = document.createElement("OPTION");
	                  aOption.value = funcList[i];
	                  aOption.text = funcList[i+1];
	                  document.getElementById("functionId").add(aOption);
	                  i = i+2;
	                }
                } 
                 else{//如果为空，跳转至添加数据功能页面
                	alert("您尚未添加功能，请先添加功能！");
                	window.location.href="/ifpug/IFPUG/requirement/functionList.jsp?productId="+document.epform.productId.value;
                }          
            } else {
                alert('There was a problem with the request.');
                alert("http_request.status:"+http_request.status);
            }
	     }
	    }     
       
       function functionHttpRequest(){
	       var http_request = creatHttpRequest();
	       http_request.onreadystatechange = functionSelectAjax;
           http_request.open('GET', "/ifpug/servlet/FunctionRequestAjax?productId="+document.epform.productId.value, true);
           http_request.send(null);     
       }     
       
       function creatHttpRequest(){

	        if (window.XMLHttpRequest) { // Mozilla, Safari,...
	            http_request = new XMLHttpRequest();
	            if (http_request.overrideMimeType) {
	                http_request.overrideMimeType('text/xml');
	            }
	        } else if (window.ActiveXObject) { // IE
	            try {
	                http_request = new ActiveXObject("Msxml2.XMLHTTP");
	            } catch (e) {
	                try {
	                    http_request = new ActiveXObject("Microsoft.XMLHTTP");
	                } catch (e) {}
	            }       
	        }
	        if (!http_request) {
	            alert('Giving up :( Cannot create an XMLHTTP instance');
	            return false;
	        }
	       return http_request;
       }
       function verifyInput(){
       	var frm = document.epform;
       	if(frm.productId.value=="")
       	{
       		alert("请选择产品！");
       		frm.productId.focus();
       		return false;
       	} 	   
       	if(frm.functionId.value=="")
       	{
       		alert("请选择功能模块！");
       		frm.functionId.focus();
       		return false;
       	}
       	  
       }
    </script>
  </head>
  <body>
     <% 
     String id = request.getParameter("productId");
     Iterator functionList = null;
     Integer productId = null;
     RequirementBusiness rb = new RequirementBusiness();
     UserBusiness ub = new UserBusiness();
     if(id != null &&id.length() != 0) {
     	productId = new Integer(id);
     	/*从数据库中把产品的功能模块信息取出*/
     	IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
     	functionList = product.getIfpugFunctions().iterator();
     }
     else id ="";
     String userName = (String)session.getAttribute("userName");
      /*从数据库中把软件信息取出*/
      IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
      Object[] productList = user.getIfpugProducts().toArray(); 
      
      if(productList == null||productList.length == 0){//如果没有添加product 
    %>
       	<script language="JavaScript"> 
       		alert("您尚未添加产品，请先添加待估算软件产品！");
       		window.location.href="/ifpug/IFPUG/requirement/productList.jsp";
       	</script>	
    <%
      } 
       
   %>
  
     <form name="epform" action="/ifpug/IFPUG/requirement/elementaryProcessList.jsp"   target="epFrame" method="post" onSubmit="return verifyInput();">        
       	<table>
       		<tr>
       			 <td>
	                请选择产品
			      	<select name="productId" id="productId" style="width:160px"  onChange="functionHttpRequest();">
			      	   <option value="">=请选择=</option>
			      	   <%
			      	    for(Object p:productList){
		      	        IfpugProduct fp = (IfpugProduct)p;%>
			      	        <option value="<%=fp.getId()%>"><%=fp.getProductName()%></option>
			      	   <%}%> 	
				    </select>
		         </td>
		         <td>
		            请选择功能模块
			      	<select name="functionId" id="functionId" style="width:160px">
			       	 <option value="">=请选择=</option>
				    </select>	     
				</td>		 
				<td>
				  <input type="submit" name="submit" value="添加基本流程"/>
				</td>
       		</tr>
       	</table>
     </form>
     <iFrame name="epFrame" frameborder="0" height="800px" width="100%" scrolling="no">
    </iFrame>
  </body>
</html>
