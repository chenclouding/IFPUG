<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %>
<%@ page import="hibernate.IFPUG.IfpugEi" %>
<%@ page import="hibernate.IFPUG.IfpugEo" %>
<%@ page import="hibernate.IFPUG.IfpugEq" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改基本流程</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <%
      //此页面为修改基本流程的页面，修改结束需返回elementaryProcessList.jsp,回传functionId.
      Integer epId = new Integer(request.getParameter("epId"));//获取从页面elementaryProcessList.jsp传来epId,用于删除操作
	  Integer type = Integer.valueOf(request.getParameter("type"));
	  String epType = request.getParameter("epType");
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作
	  Object epObject = rb.getElementaryProcessById(type,epId);//通过epId获取EP对象
	   //根据基本流程类型的不同，在不同数据库表中获取基本流程对应的功能模块ID
	  String desp = null, name = null;
	  Short measureStatus = null;
	  IfpugFunction function = null;
	  Short ufpMethod = null;
	  switch(type){
	  	case 0:
	  		IfpugEi ei = (IfpugEi)epObject;
	  		desp = ei.getEiDesp();
	  		name = ei.getEiName();
	  		measureStatus = ei.getMeasureStatus();
	  		ufpMethod = ei.getUfpMethod();
	  		function = ei.getIfpugFunction();
	  		break;
	    case 1:
	   		IfpugEo eo = (IfpugEo)epObject;
	  		desp = eo.getEoDesp();
	  		name = eo.getEoName();
	  		measureStatus = eo.getMeasureStatus();
	  		function = eo.getIfpugFunction();
	  		break;
	  	case 2:
	  		IfpugEq eq = (IfpugEq)epObject;
	  		desp = eq.getEqDesp();
	  		name = eq.getEqName();
	  		measureStatus = eq.getMeasureStatus();
	  		function = eq.getIfpugFunction();
	  		break;
	   }
	   Integer functionId = function.getId();
    %>
      
  <form  action ="/ifpug/IFPUG/editElementaryProcess.do" name ="epForm">
  	 <table>
  		<tr>
  			<td width="15%">流程名称</td>
  			<td >
  			    <input type="text" name="epName" style="width:160px" value="<%=name%>"/>
            </td>
  		</tr>
  		<tr>
  	    	<td valign="top">流程类型<br></td>
  	    	<td  valign="top">
  	    		<!--0代表EI，1代表EO,2代表EQ  -->
  		   		<input type="radio" checked="checked" value="0" name="epType">EI
  		   		<input type="radio" value="1" name="epType">EO
  		   		<input type="radio" value="2" name="epType">EQ
  		   		<script language="javascript">   
                  var type = document.getElementsByName("epType");
                  //下段代码的含义使基本流程的类型再选中后，不可修改
                  for (var i = 0; i < 3; i ++){//变量epType是基本流程的类型，取值为0、1、2 
                  	if (i == <%=type%>) type[<%=type%>].checked = true; //通过epType值，选中对应按钮
                  	else type[i].disabled = true; //未选中按钮置灰，不可再选中。
                  }
                </script>
  		   </td>
  		</tr>
  		<tr>
  			<td width="10%">估算方法</td>
  			<td >
  			    <select name="ufpMethod"  id ="ufpMethod" disabled="true">
  			 	    <!--0代表 derived，1代表default，2代表range,3代表value -->
  			 	    <option style="color:red" value="5">=请选择=</option>
  					<option value="0" >手动导入DET</option>
  					<option value="1">默认功能点个数</option>
  					<option value="2">选择DET范围</option>
  					<option value="3">输入DET个数</option>
  					<option value="4">选择复杂度</option>
  				</select>
  				<script language="JavaScript">
  					document.epForm.ufpMethod.value=<%=ufpMethod%>;
  				</script>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">待估算软件描述</td>
  			<td >
  			    <textarea name="epDesp"><%=desp%></textarea>
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
                  document.epForm.measureStatus.value="<%= measureStatus%>";   
                </script>
            </td>
  		</tr>
  		</table>
  		<input type="submit" name="submit" value=" 保 存 "/>
    <input type='button' onclick="Javascript:window.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=<%=functionId%>&&epType=<%=epType%>'" value=" 返 回 ">
  	<input type="hidden" name="id" value="<%=epId%>"/>
  	<input type="hidden" name="functionId" value="<%=functionId%>"/>
  	</form> 			
  </body>
</html>
