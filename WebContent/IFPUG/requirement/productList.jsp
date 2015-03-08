<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.UserBusiness" %>
<%@ page import="hibernate.IFPUG.*" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>增加产品-显示产品列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
  	<script type="text/javascript" src="/ifpug/javascript/calenderJS.js"></script>
	<script language="JavaScript">  
	function expandIt(formId) {
		formObject =document.getElementById(formId)
		if (formObject.style.display == 'none') {
			formObject.style.display = '';
		}
		else {
			formObject.style.display = 'none';
		}
	}
	
    function verifyInput()
	{	
	 		var frm = document.productForm;  		    	   
			if(isEmpty(frm.productName.value)) 
			{	
			    alert("请填写软件名称！");
				frm.productName.focus();
				return false;
			}	
			
			if(isEmpty(frm.projectStartTime.value)) 
			{
				alert("请填写项目开始时间！");
				frm.projectStartTime.focus();
				return false;
			}		
			if(isEmpty(frm.projectEndTime.value)) 
			{
				alert("请填写项目结束时间！");
				frm.projectEndTime.focus();
				return false;
			}
			if(compareTime(frm.projectEndTime.value,frm.projectStartTime.value))
			{
				alert("项目结束时间应大于开始时间！");
				frm.projectEndTime.focus();
				return false;
			}
			if(isEmpty(frm.estimateTime.value)) 
			{
				alert("请填写估算开始时间！");
				frm.estimateTime.focus();
				return false;
			}
			if (!isEmpty(frm.endTime.value)&&compareTime(frm.endTime.value,frm.estimateTime.value))
			{
				alert("估算结束时间应大于开始时间！");
				frm.endTime.focus();
				return false;
			}
	}
    function confirmdel(){
    	return confirm("确定删除？");
    }
    </script> 
  </head>
  
  <body>
    <h1>产品列表</h1>
    <table>
       <tr>
         <td>序号</td> 
         <td>软件名称</td>
         <td>估算状态</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
         <td>添加功能</td>
       </tr>
       <%        
       String userName = (String)session.getAttribute("userName");
       /*从数据库中把所有软件的估算信息取出*/
       RequirementBusiness rb = new RequirementBusiness();
       //List productList = rb.getAllProduct(userName); 
       UserBusiness ub = new UserBusiness();
       IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
       Object[] productList = user.getIfpugProducts().toArray();
       
       IfpugProduct product = new IfpugProduct();//定义实体Bean
     
       int i = 1;
       /*若无软件信息，提示添加；若有软件信息，列出估算软件列表*/
       if(productList==null ||productList.length==0 ){%>  
       <h1 style="color:red">目前无估算软件信息，请添加待估算的软件</h1>
       <%}else{ 
	       for(Object p:productList){ 
	         product = (IfpugProduct)p; 
	         Integer productId = product.getId();  
	         %>
	         <tr>
	          <td><%= i++%></td> 
	          <td><%= product.getProductName() %></td>
	          <td>
	          <%Short status = product.getMeasureStatus();
	         	String showstatus = null; 
	         	if(status==0)  showstatus="未估算";
	         	else if(status==1)  showstatus="部分估算";
	         	else if(status==2)  showstatus="已估算";%>
	          	<%= showstatus%></td>
		         <td class = checkimg>
	              	  <a href="/ifpug/IFPUG/requirement/viewProduct.jsp?productId=<%=productId%>">
	              	  	<IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              	  </a>
	              </td>	
		          <td class = editimg>
		          	  <a href="/ifpug/IFPUG/requirement/editProduct.jsp?productId=<%=productId%>">
		          	  	<IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          	  </a>
		          </td>
		          <td class = delimg>
		              <a href="/ifpug/IFPUG/requirement/delProduct.jsp?productId=<%=productId%>" onclick="return confirmdel()">
		              	<img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		              </a>
		          </td>
		          <td>
		          	  <a href="/ifpug/IFPUG/requirement/functionList.jsp?productId=<%=productId%>">添加功能模块</a>
		          </td>
	         </tr>  
          <%}
       }%>  
    </table>
    
    <a onclick="expandIt('product'); return false" href="#"><h1>增加产品</h1></a>
    
    <form  action="/ifpug/IFPUG/addProduct.do" name="productForm" id ="product" method="post" style="display:none;" onsubmit="return verifyInput();">
  	<table>
  		<tr>
  			<td width="15%">待估算软件名称</td>
  			<td >
  			    <input type="text" name="productName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">待估算软件描述</td>
  			<td >
  			    <textarea name="productDesp"></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">软件类型</td>
  			<td >
  			 	<select name="productType" style="width:160px" >
  			 	    <!--0代表MIS系统，1代表web系统  -->
  					<option value="0" selected>MIS</option>
  					<option value="1">Web</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">项目类型</td>
  			<td >
  			 	<select name="developType" style="width:160px">
  			 	    <!--0代表newDevelop，1代表二次开发，2代表增强型 -->
  					<option value="0" selected>新开发</option>
  					<option value="1">二次开发</option>
  					<option value="2">增强型</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td>估算方法</td>
  			<td width="40px">
  			 	<select name="measureMethod" style="width:160px">
  			 	    <!--0代表COSMIC标准方法直接估算，1代表USE-CASE辅助估算，2代表COSMIC近似估算  -->
  			 	    <option value="0" selected>IFPUG标准估算</option>
  					<option value="1">IFPUG近似估算</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td valign="top">估算人员</td>
  			<td valign="top">
  		   		<input type="text" name="estimator">
  		   	</td>
  		</tr>
  	    <tr>
  	    	<td valign="top">估算状态<br></td><td valign="top">
  		   		<input type="radio" checked="checked" value="0" name="measureStatus"/> 未估算
  		   		<input type="radio" value="1" name="measureStatus"/> 部分估算
  		   		<input type="radio" value="2" name="measureStatus"/> 已估算
  		   </td>
  		 </tr>
  		 <tr>
  			<td>生命周期阶段</td>
  			<td >
  			 	<select name="lifecyclePhase" style="width:160px">
  			 	    <!--0代表需求定义后，1代表详细设计后，2代表编码完成后，3代表产品交付后  -->
  					<option value="0" selected>需求定义后</option>
  					<option value="1">详细设计后</option>
  					<option value="2">编码完成后</option>
  					<option value="3">产品交付后</option>
  				</select>
            </td>
  		</tr>
  	    <tr>
  			<td>开发开始时间</td>
  			<td>
           		<input type="text" name="projectStartTime" style="width:160px" onfocus="HS_setDate(this)"/>
            </td>
  		</tr>
  		<tr>
  			<td>开发结束时间</td>
  			<td>
  				<input type="text" name="projectEndTime" style="width:160px" onfocus="HS_setDate(this)"/>
  			</td>
  	    </tr>
  		<tr>
  			<td>估算开始时间</td>
  			<td>
  				<input type="text" name="estimateTime" style="width:160px" onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  		<tr>
  			<td>估算结束时间</td>
  			<td>
              	<input type="text" name="endTime" style="width:160px" onfocus="HS_setDate(this)"/>
             	
           </td>
  		</tr>
  		<tr>
  		    <td>
  				<input type="submit" name="submit" value=" 新  增 "/>
  			</td>
  			<td>
  				<input type="reset" name="reset" value=" 清  除 "/>
  			</td>
  		</tr>
  	</table>
  	</form> 			
  </body>
</html>
