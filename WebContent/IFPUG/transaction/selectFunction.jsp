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
    
    <title>选择数据功能</title>
    
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
	    
	    
	    function epSelectAjax(){    
	    if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var eps = http_request.responseText;
               while(document.getElementById("epId").options.length>0){
                   document.getElementById("epId").options.remove(0);
               }
               if(eps!=""){
	               var epList = eps.split(",");
	                var i =0 ;     
	                //在下拉框中增加一个提示按钮“请选择“
	                var aOption = document.createElement("OPTION");
	                aOption.value="";
	                aOption.text = "=请选择=";
	                document.getElementById("epId").add(aOption);
	                while(i<epList.length){
	                  var aOption = document.createElement("OPTION");
	                  aOption.value = epList[i];
	                  aOption.text = epList[i+1];
	                  document.getElementById("epId").add(aOption);
	                  i = i + 2;
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
       function epHttpRequest(){
	       var http_request = creatHttpRequest();
	       http_request.onreadystatechange = epSelectAjax;
           http_request.open('GET', "/ifpug/servlet/EpRequestAjax?functionId="+document.epform.functionId.value+"&&epType="+document.epform.epType.value, true);
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
      /*  if(frm.epId.value=="")
       	{
       		alert("请选择基本流程！");
       		frm.epId.focus();
       		return false;
       	}*/
       	  
       }
       function showAction()
       {
       		var frm = document.getElementById("epForm");
			frm.action="/ifpug/IFPUG/transaction/addMethodToEp.jsp?epType="+document.epform.epType.value+"&&functionId="+document.epform.functionId.value;
       }
    </script>

  </head>
  
  <body>
  <% 
     String id = request.getParameter("productId");
     Iterator functionList = null;
     Integer productId = null;
     RequirementBusiness rb = new RequirementBusiness();
     if(id != null &&id.length() != 0) {
     	productId = new Integer(id);
     	/*从数据库中把产品的功能模块信息取出*/
     	IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
     	functionList = product.getIfpugFunctions().iterator();
     }
     else id ="";
    
      /*从数据库中把软件信息取出*/
     String userName = (String)session.getAttribute("userName");
       /*从数据库中把所有软件的估算信息取出*/
       //List productList = rb.getAllProduct(userName); 
      UserBusiness ub = new UserBusiness();
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
  
     <form name="epform" target="epFrame" method="post" onSubmit="return verifyInput();">        
       	<table>
       		<tr>
       			 <td>
	                请选择产品
			      	<select name="productId" id="productId" style="width:100px"  onChange="functionHttpRequest();">
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
			      	<select name="functionId" id="functionId" style="width:130px" >
			       	 <option value="">=请选择=</option>
				    </select>	     
				</td>	
				<td>
		            筛选事务功能
			      	<select name="epType" id="epType" style="width:80px">
			       	 <option value="">全部列出</option>
			       	 <option value="0">仅列出EI</option>
			       	 <option value="1">仅列出EO</option>
			       	 <option value="2">仅列出EQ</option>
				    </select>	     
				</td>			 
				<td>
				  <input type="submit" name="submit" onclick="showAction();" value="添加估算方法"/>
				</td>
       		</tr>
       	</table>
     </form>
     <iFrame name="epFrame" frameborder="0" height="800px" width="100%" scrolling="no">
    </iFrame>
  </body>
</html>
