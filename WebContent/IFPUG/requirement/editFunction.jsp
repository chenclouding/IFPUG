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
    
    <title>修改主功能模块</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
 	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
 	<script language="JavaScript">
 	function verifyInput(editEstimate,editType)
 	{
 		var frm = document.functionForm;	    	   
		if(isEmpty(frm.functionName.value)) 
		{	
			 alert("请填写功能模块名称！");
			 frm.functionName.focus();
			 return false;
		}
		
		//判断模块类型是否能够修改
		if(!isEmpty(frm.functionType.value))
		{   
			switch(frm.functionType.value){
				case '0': //修改成组合模块
				{
					if(editType==2) {  //editType == 2表示该模块既是原子模块，又包含基本流程
						 alert("此模块类型不能修改！");
						 frm.functionType.focus();
						 return false;
					} 
					//else return true;
					break;
				}
				case '1': //修改成原子模块
				{
					if(editType==4){ //editType == 4表示该模块既是组合模块，又包含子模块
						alert("此模块类型态不能修改！");
						frm.functionType.focus();
						return false;
					} 
					//else  return true;
			        break;
			     }
			    default：alert("error"); break;
			}
		}
		//判断估算状态是否能够修改
		if (!isEmpty(frm.measureStatus.value))
		{   
			switch(frm.measureStatus.value){
				case "0": //可否修改为未估算状态
					if (editEstimate == 0)  return true;
					else {
						 alert("此估算状态不能修改为未估算！");
						 frm.measureStatus.focus();
						 return false;
					} 
					break;
				case "1": //可否修改为部分估算状态
					if (editEstimate == 1)  return true;
					else {
						 alert("此估算状态不能修改为部分估算！");
						 frm.measureStatus.focus();
						 return false;
					}
					break;
				case "2": //可否修改为已估算状态
					if (editEstimate == 2)  return true;
					else{
						 alert("此估算状态不能修改为已估算！");
						 frm.measureStatus.focus();
						 return false;
					}
					break;
				//default : alert("error!"); break;
			}
		}
 	}
 	</script>
  </head>
  
  <body>
      <%
       /*获取从页面functionList.jsp传来functionId*/
      Integer functionId = new Integer(request.getParameter("functionId"));
      /*从数据库中把id为functionId的数据组取出*/
      RequirementBusiness rb = new RequirementBusiness(); //业务层，对应于IFPUG方法的策略阶段
      IfpugFunction ifi = (IfpugFunction)rb.getFunctionById(functionId); //获取功能对象
      IfpugProduct product = ifi.getIfpugProduct();//通过功能的IfpugProduct属性获取Product对象
      Integer productId = product.getId();//获得productId便于跳转回functionList页面
     
      //判断估算状态能否改为未估算
      Integer editEstimate = rb.editFunctionEstimateCheck(functionId);
      //判断模块类型能否修改
      Integer editType = rb.editFunctionTypeCheck(functionId);
      %>
      
  <form  action="/ifpug/IFPUG/editFunction.do" name="functionForm" method="post" onSubmit="return verifyInput(<%=editEstimate%>,<%=editType%>);">
     <table>
  		<tr>
  			<td width="15%">模块名称</td>
  			<td >
  			    <input type="text" name="functionName" style="width:160px" value="<%=ifi.getFunctionName()%>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">模块描述</td>
  			<td >
  			    <textarea name="functionDesp"><%=ifi.getFunctionDesp()%></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">模块类型</td>
  			<td >
  			 	<select name="functionType" style="width:160px" >
  			 	    <!--0代表组合模块，1代表原子模块  -->
  					<option value="0" >组合模块</option>
  					<option value="1">原子模块</option>
  				</select>
  				<script language="javascript">   
                  document.functionForm.functionType.value="<%=ifi.getFunctionType()%>";   
                </script>
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
                  document.functionForm.measureStatus.value="<%= ifi.getMeasureStatus()%>";   
                </script>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" 保 存 "/>
    <input type='button' onclick="Javascript:window.location='functionList.jsp?productId=<%=productId %>'" value=" 返 回 ">
  	<input type="hidden" name="id" value="<%=functionId%>"/>
  	<input type="hidden" name="productId" value="<%=productId%>"/>
	</form>
  </body>
</html>
