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
    
    <title>添加数据元素</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	
	 <script language="javascript">
       var http_request = false;
       function dataFuncSelectAjax(){    
	    if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var dfs = http_request.responseText;
               
               while(document.getElementById("dfId").options.length>0){
                   document.getElementById("dfId").options.remove(0);
               }
               if(dfs!=""){
	               var dfList = dfs.split(",");
	                var i =0 ;     
	                //在下拉框中增加一个提示按钮“请选择“
	                var aOption = document.createElement("OPTION");
	                aOption.value="";
	                aOption.text = "=请选择=";
	                document.getElementById("dfId").add(aOption);
	                while(i<dfList.length){
	                  var aOption = document.createElement("OPTION");
	                  aOption.value = dfList[i];
	                  aOption.text = dfList[i+1];
	                  document.getElementById("dfId").add(aOption);
	                  i = i+2;
	                }
                }  
                else{//如果为空，跳转至添加数据功能页面
                	alert("您尚未添加数据功能，请先添加数据功能！");
                	window.location.href="/ifpug/IFPUG/dataFunction/addDataFunction.jsp";
                }          
            } else {
                alert('There was a problem with the request.');
                alert("http_request.status:"+http_request.status);
            }
	     }
	    }     
       function retSelectAjax(){    
	    if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var rets = http_request.responseText;
               while(document.getElementById("retId").options.length>0){
                   document.getElementById("retId").options.remove(0);
               }
               //在下拉框中增加一个默认选项，DET将添加到retId为-1的RET中
	           var aOption = document.createElement("OPTION");
	           aOption.value = "-"+document.getElementById("dfId").value;//设定retId=-dfId;
	           aOption.text = "默认";
	           document.getElementById("retId").add(aOption);
               if(rets!=""){
	               var retList = rets.split(",");
	                var i =0 ;
	                while(i<retList.length&&retList[i+1]!="default"){
	                  aOption = document.createElement("OPTION");
	                  aOption.value = retList[i];
	                  aOption.text = retList[i+1];
	                  document.getElementById("retId").add(aOption);
	                  i = i+2;
	                }
	                
               }    
            } else {
                alert('There was a problem with the request.');
                alert("http_request.status:"+http_request.status);
            }
	     }
	    }   
       
       function dataFuncHttpRequest(){
	       var http_request = creatHttpRequest();
	       http_request.onreadystatechange = dataFuncSelectAjax;
           http_request.open('GET', "/ifpug/servlet/DataFuncRequestAjax?type="+document.detform.type.value+"&&productId="+document.detform.productId.value, true);
           http_request.send(null);     
       }
      function retHttpRequest(){
	       var http_request = creatHttpRequest();
	       http_request.onreadystatechange = retSelectAjax;
           http_request.open('GET', "/ifpug/servlet/RetRequestAjax?dfId="+document.detform.dfId.value+"&type="+document.detform.type.value, true);
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
       		var frm = document.detform;
       		if(frm.type.value=="")
       		{
       			alert("请选择文件类型！");
       			frm.type.focus();
       			return false;
       		} 	   
       		if(frm.dfId.value=="")
       		{
       			alert("请选择数据文件！");
       			frm.dfId.focus();
       			return false;
       		}
       		if(frm.retId.value=="")
       		{
       			alert("请选择记录元素！");
       			frm.retId.focus();
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
      } 

   %>
      <form name="detform" action="/ifpug/IFPUG/dataFunction/detList.jsp"   method="post" target="detFrame" onSubmit="return verifyInput();" >
         <table>
         	 <tr> 
         	 <td>
	                请选择产品
			      	<select name="productId" id="productId" style="width:100px">
			      	   <option value="">=请选择=</option>
			      	   <%
			      	      for(Object p:productList){
		      	        	IfpugProduct fp = (IfpugProduct)p;%>
			      	        <option value="<%=fp.getId()%>"><%=fp.getProductName()%></option>
			      	   <%}%> 	
				    </select>
		         </td>
              <td>
	                请选择文件类型
			      	<select name="type" id="type" style="width:100px" onChange="dataFuncHttpRequest();">
			      	   <option value="">=请选择=</option>
			      	   <option value="0">ILF</option>
			      	   <option value="1">EIF</option>	 
				    </select>
		        </td>
		         <td>
		            请选择文件名称
			      	<select name="dfId" id="dfId" style="width:100px" onChange="retHttpRequest();">	
			        	<option value="">=请选择=</option>
				    </select>   
				</td>		
		         <td>
		            请选择记录元素
			      	<select name="retId" id="retId" style="width:100px">	
			      	<option value="">=请选择=</option>
			      	
				    </select>	     
				</td>	 
				<td>
				  <input type="submit" name="submit" value="增加数据元素"/>
				</td>
			</tr>
   		</table>
     </form>
    <iFrame name="detFrame" frameborder="0" height="800px" width="100%" scrolling="no">
    </iFrame>
  </body>
</html>

