<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据功能</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <% 
   	   //获取从页面dataFunctionList.jsp传来dfId和type,用于删除操作
       Integer dfId = new Integer(request.getParameter("dfId"));
       Integer type = new Integer(request.getParameter("type"));
       DataFunctionBusiness dfb = new DataFunctionBusiness();//业务逻辑层
       Integer productId;
       String name = null, desp = null;
       Short ufpMethod ;
       if(type == 0){ //如果是ILF文件
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		name = ilf.getIlfName();
       		desp = ilf.getIlfDesp();
       		ufpMethod = ilf.getUfpMethod();       	
       		productId = ilf.getIfpugProduct().getId();	
       }
       else { //如果是EIF文件
       		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
       		name = eif.getEifName();
       		desp = eif.getEifDesp();
       		ufpMethod = eif.getUfpMethod();
       		productId = eif.getIfpugProduct().getId();
       }
   %>
    <form  action="/ifpug/IFPUG/editDataFunction.do" name="dfForm">
  	<table>
  		<tr>
  			<td width="15%">数据文件名</td>
  			<td >
  			    <input type="text" name="name" style="width:160px" value="<%=name %>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">数据文件描述</td>
  			<td >
  			    <textarea name="desp"><%=desp %></textarea>
            </td>
  		</tr>
  		<tr>
  	    	<td width="15%">数据文件类型</td>
  	    	<td>
  	    		 <!--0代表ILF，1代表EIF  -->
  		   		<input type="radio" checked="checked" value="0" name="type">ILF
  		   		<input type="radio" value="1" name="type">EIF
  		   		<script language="javascript">   
                  var typeObject = document.getElementsByName("type");
                  //下段代码的含义选中文件类型
                 typeObject[<%=type%>].checked = true;
                 typeObject[1-<%=type%>].disabled = true; //保证类型不可修改
                </script>
  		   	</td>
  		<tr>
  			<td width="10%">方法类型</td>
  			<td >
  			 	<select name="ufpMethod" style="width:160px" disabled="true">
  			 	    <!--0代表 derived，1代表default，2代表range,3代表value -->
  					<option value="0" selected>手动添加</option>
  					<option value="1">默认值</option>
  					<option value="2">用户选择</option>
  					<option value="3">用户输入</option>
  					<option value="4">选择复杂度</option>
  				</select>
  				<script language="javascript">   
                  document.dfForm.ufpMethod.value="<%= ufpMethod%>";   
                </script>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" 保 存 "/>
    <input type='button' onclick="Javascript:window.location='dataFunctionList.jsp?productId=<%=productId%>'" value=" 返 回 ">
    <input type="hidden" name="id" value="<%=dfId%>"/>
    <input type="hidden" name="productId" value="<%=productId%>"/>
  	</form> 			
  </body>
</html>
