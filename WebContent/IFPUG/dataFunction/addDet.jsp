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
    
    <title>�������Ԫ��</title>
    
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
	                //��������������һ����ʾ��ť����ѡ��
	                var aOption = document.createElement("OPTION");
	                aOption.value="";
	                aOption.text = "=��ѡ��=";
	                document.getElementById("dfId").add(aOption);
	                while(i<dfList.length){
	                  var aOption = document.createElement("OPTION");
	                  aOption.value = dfList[i];
	                  aOption.text = dfList[i+1];
	                  document.getElementById("dfId").add(aOption);
	                  i = i+2;
	                }
                }  
                else{//���Ϊ�գ���ת��������ݹ���ҳ��
                	alert("����δ������ݹ��ܣ�����������ݹ��ܣ�");
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
               //��������������һ��Ĭ��ѡ�DET����ӵ�retIdΪ-1��RET��
	           var aOption = document.createElement("OPTION");
	           aOption.value = "-"+document.getElementById("dfId").value;//�趨retId=-dfId;
	           aOption.text = "Ĭ��";
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
       			alert("��ѡ���ļ����ͣ�");
       			frm.type.focus();
       			return false;
       		} 	   
       		if(frm.dfId.value=="")
       		{
       			alert("��ѡ�������ļ���");
       			frm.dfId.focus();
       			return false;
       		}
       		if(frm.retId.value=="")
       		{
       			alert("��ѡ���¼Ԫ�أ�");
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
     	/*�����ݿ��аѲ�Ʒ�Ĺ���ģ����Ϣȡ��*/
     	IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
     	functionList = product.getIfpugFunctions().iterator();
     }
     else id ="";
    
      /*�����ݿ��а������Ϣȡ��*/
      String userName = (String)session.getAttribute("userName");
       /*�����ݿ��а���������Ĺ�����Ϣȡ��*/
       //List productList = rb.getAllProduct(userName); 
      UserBusiness ub = new UserBusiness();
      IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
      Object[] productList = user.getIfpugProducts().toArray();
     
      if(productList == null||productList.length == 0){//���û�����product 
      } 

   %>
      <form name="detform" action="/ifpug/IFPUG/dataFunction/detList.jsp"   method="post" target="detFrame" onSubmit="return verifyInput();" >
         <table>
         	 <tr> 
         	 <td>
	                ��ѡ���Ʒ
			      	<select name="productId" id="productId" style="width:100px">
			      	   <option value="">=��ѡ��=</option>
			      	   <%
			      	      for(Object p:productList){
		      	        	IfpugProduct fp = (IfpugProduct)p;%>
			      	        <option value="<%=fp.getId()%>"><%=fp.getProductName()%></option>
			      	   <%}%> 	
				    </select>
		         </td>
              <td>
	                ��ѡ���ļ�����
			      	<select name="type" id="type" style="width:100px" onChange="dataFuncHttpRequest();">
			      	   <option value="">=��ѡ��=</option>
			      	   <option value="0">ILF</option>
			      	   <option value="1">EIF</option>	 
				    </select>
		        </td>
		         <td>
		            ��ѡ���ļ�����
			      	<select name="dfId" id="dfId" style="width:100px" onChange="retHttpRequest();">	
			        	<option value="">=��ѡ��=</option>
				    </select>   
				</td>		
		         <td>
		            ��ѡ���¼Ԫ��
			      	<select name="retId" id="retId" style="width:100px">	
			      	<option value="">=��ѡ��=</option>
			      	
				    </select>	     
				</td>	 
				<td>
				  <input type="submit" name="submit" value="��������Ԫ��"/>
				</td>
			</tr>
   		</table>
     </form>
    <iFrame name="detFrame" frameborder="0" height="800px" width="100%" scrolling="no">
    </iFrame>
  </body>
</html>

