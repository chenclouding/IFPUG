<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>编辑产品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
    <script type="text/javascript" src="/ifpug/javascript/calenderJS.js"></script>
	<script language="JavaScript">  
    function verifyInput(editEstimate)
	{	
	 		var frm = document.productForm;  		    	   
			if(isEmpty(frm.productName.value)) 
			{	
			    alert("请填写软件名称！");
				frm.productName.focus();
				return false;
			}	
			//判断估算状态是否能够修改
			if (!isEmpty(frm.measureStatus.value))
			{   
				switch(frm.measureStatus.value)
				{   
					case '0': //可否修改为未估算状态
					{
						if (editEstimate != 0){
							alert("此估算状态不能修改为未估算！"); 
							frm.measureStatus.focus();
							return false;	
						}
						break;
						
					}
					case '1': //可否修改为部分估算状态
					{
						if (editEstimate != 1){
							alert("此估算状态不能修改为部分估算！");
							return false;
						}
						 break;
					}
					case '2': //可否修改为已估算状态
					{
						if (editEstimate != 2){
							alert("此估算状态不能修改为已估算！");
							return false; 
						}
						break;
					}
				   default : alert("error!"); break;
				}
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
    </script> 
  </head>
  
  <body>
      <%
       /*获取从页面productList.jsp传来productId*/
      Integer productId = new Integer(request.getParameter("productId"));
      
      /*从数据库中把id为productId的数据组取出*/
      RequirementBusiness rb = new RequirementBusiness(); //业务层，对应于IFPUG方法的策略阶段
      IfpugProduct  fp = (IfpugProduct)rb.getProductById(productId); 
      
      /*判断估算状态能否改为未估算*/
      Integer editEstimate = rb.editProductEstimateCheck(productId);
      %>
      
  <form  action="/ifpug/IFPUG/editProduct.do" name="productForm" method="post" onSubmit="return verifyInput(<%=editEstimate%>);">
      <table>
  		<tr>
  			<td width="15%">待估算软件名称</td>
  			<td >
  			    <input type="text" name="productName" style="width:160px" value="<%=fp.getProductName()%>"/>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">待估算软件描述</td>
  			<td >
  			    <textarea name="productDesp" style="width:360px"><%=fp.getProductDesp()%></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">软件类型</td>
  			<td >
  			 	<select name="productType" style="width:160px" >
  			 	    <!--0代表MIS系统，1代表web系统  -->
  					<option value="0">MIS</option>
  					<option value="1">Web</option>
  				</select>
  				<script language="javascript">   
  				 
                  document.productForm.productType.value="<%=fp.getProductType()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">项目类型</td>
  			<td >
  			 	<select name="developType" style="width:160px">
  			 	    <!--0代表newDevelop，1代表二次开发，2代表增强型 -->
  					<option value="0">新开发</option>
  					<option value="1">二次开发</option>
  					<option value="2">增强型</option>
  				</select>
  				<script language="javascript">   
                  document.productForm.developType.value="<%= fp.getDevelopType()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>估算方法</td>
  			<td width="40px">
  			 	<select name="measureMethod" style="width:160px">
  			 	    <!--0代表COSMIC标准方法直接估算，1代表USE-CASE辅助估算，2代表COSMIC近似估算  -->
  			 	    <option value="0">COSMIC标准方法直接估算</option>
  					<option value="1">USE-CASE辅助估算</option>
  					<option value="2">COSMIC近似估算</option>
  				</select>
  				<script language="javascript">   
                  document.productForm.measureMethod.value="<%=fp.getMeasureMethod()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>估算原理</td>
  			<td>
  		   		<input type="text" name="estimator" style="width:160px" value="<%= fp.getEstimator()%>"/>
  		   	</td>
  		</tr>
  		<tr>
  			<td width="15%">估算状态</td>
  			<td >
  			 	<select name="measureStatus" style="width:160px" >
  			 	   <!--0代表未估算，1代表部分估算，2代表已估算  -->
  					<option value="0">未估算</option>
  					<option value="1">部分估算</option>
  					<option value="2">已估算</option>
  				</select>
  				<script language="javascript">   
                  document.productForm.measureStatus.value="<%= fp.getMeasureStatus()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>生命周期阶段</td>
  			<td >
  				<select name="lifecyclePhase" style="width:160px">
  			 	    <!--0代表需求定义后，1代表详细设计后，2代表编码完成后，3代表产品交付后  -->
  					<option value="0">需求定义后</option>
  					<option value="1">详细设计后</option>
  					<option value="2">编码完成后</option>
  					<option value="3">产品交付后</option>
  				</select>
  			    <script language="javascript">   
                  document.productForm.lifecyclePhase.value="<%=fp.getLifecyclePhase()%>";   
                </script>
            </td>
  		</tr>
  	    <tr>
  	    	<td>开发开始时间</td>
  	    	<td >
  	    		<input type="text" name="projectStartTime" style="width:160px" value='<%=fp.getTime(fp.getProjectStartTime()) %>' onfocus="HS_setDate(this)"/>
            </td>
  		</tr>
  		<tr>
  			<td>开发结束时间</td>
  			<td>
  				<input type="text" name="projectEndTime" style="width:160px" value='<%=fp.getTime(fp.getProjectEndTime())%>' onfocus="HS_setDate(this)"/>
  				</td>
  		</tr>
  		<tr>
  			<td>估算开始时间</td>
  			<td>
  				<input type="text" name="estimateTime" style="width:160px" value='<%=fp.getTime(fp.getEstimateTime())%>' onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  		<tr>
  			<td>估算结束时间</td>
  			<% //因为估算结束时间允许为空，所有要作如下判断
  			   Date endTime = fp.getEndTime();
  			   String time = null;
  			   if (endTime == null) time = "";
  			   else  time = fp.getTime(endTime); 
  			 %>
  			<td>
  				<input type="text" name="endTime" style="width:160px" value='<%=time%>' onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  	</table>
  	    <input type="submit" name="submit" value=" 保 存 "/>
  		<input type='button' onclick="Javascript:window.location='/ifpug/IFPUG/requirement/productList.jsp'" value=" 返 回 ">
  		<input type="hidden" name="id" value="<%=productId%>"/>
	</form>
  </body>
</html>
