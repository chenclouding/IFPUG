<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG.IfpugProduct" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加主功能模块-显示主功能模块列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="JavaScript">
    function confirmdel(){
    	return confirm("确定删除？");
    }
    
    function verifyInput(){
    	var frm = document.functionForm; 
    	if(isEmpty(frm.functionName.value)) 
		{
			alert("请填写功能模块的名称！");
			frm.functionName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>   
      <%
      Integer productId = new Integer(request.getParameter("productId"));
      RequirementBusiness rb = new RequirementBusiness();
      IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
      %>
     <h1> <%= product.getProductName()%>产品的模块列表</h1>
      <table>
       <tr>
         <td>序号</td> 
         <td>功能名称</td>
         <td>功能类型</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
         <td>添加功能</td>
       </tr>
       <% 
       /*从数据库中把该软件的功能取出*/
       Object[] functionList = product.getIfpugFunctions().toArray();
       IfpugFunction function;
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(functionList == null||functionList.length == 0){%>  
       <h1 style="color:red">目前无功能模块，请添加功能</h1>
       <%}else{ 
       		 Integer i = 0;
       	   	 for(Object f:functionList){
	         	function = (IfpugFunction)f; 
	         	Integer functionId = function.getId();  
	         %>
	         <tr>
	          <td><%=++ i %></td> 
	          <td><%= function.getFunctionName() %></td>
	          <td>
	          <%Short status = function.getFunctionType();
	         	String showstatus = null, linkName = null; 
	         	String name1="/ifpug/IFPUG/requirement/", name2 = null;
	         	if(status==1){
	         		showstatus="原子模块";
	         		linkName="添加基本流程";
	         		name2="elementaryProcessList.jsp?functionId=";
	         	}  
	         	else if(status==0){
	         		showstatus="组合模块";
	         		linkName="添加子模块";
	         		name2="childFunctionList.jsp?functionId=";
	         	}  
	          %>
	          	<%= showstatus%></td>
	          	
	              <td class = checkimg>
	              	  <a href="/ifpug/IFPUG/requirement/viewFunction.jsp?functionId=<%=functionId%>">
	              	  	<IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              	  </a>
	              </td>	
		          <td class = editimg>
		          	  <a href="/ifpug/IFPUG/requirement/editFunction.jsp?functionId=<%=functionId%>">
		          	  	<IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          	  </a>
		          </td>
		          <td class = delimg>
		              <a href="/ifpug/IFPUG/requirement/delFunction.jsp?functionId=<%=functionId%>" onclick="return confirmdel()">
		              	<img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		              </a>
		          </td>
		          <td><a href="<%=name1+ name2+functionId%>"><%=linkName%></a></td>
	         </tr>  
	         
          <%}
       }%> 
       </table>
       
     <h1>新增模块</h1>  
     <form  action="/ifpug/IFPUG/addFunction.do" name="functionForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">模块名称</td>
  			<td >
  			    <input type="text" name="functionName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">模块描述</td>
  			<td >
  			    <textarea name="functionDesp"></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">模块类型</td>
  			<td >
  			 	<select name="functionType" style="width:160px" >
  			 	    <!--0代表组合模块，1代表原子模块  -->
  					<option value="0" selected>组合模块</option>
  					<option value="1">原子模块</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  		    <td>
  				<input type="submit" name="submit" value=" 增  加 "/>
  			</td>
  			<td>
  				<input type="reset" name="reset" value=" 清  除 "/>
  			</td>
  		</tr>
  	</table>
    <input type="hidden" name="productId" value="<%=productId%>"/>
    <a href ="Javascript:window.name=='contentFrame'?window.location='/ifpug/IFPUG/requirement/productList.jsp':parent.location='/ifpug/IFPUG/requirement/productList.jsp'"> 返回到产品列表</a>
  	</form> 			
  </body>
</html>
