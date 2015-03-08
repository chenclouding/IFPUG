
<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.TransactionFunctionBusiness" %>
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
	<script language="javascript"> 
	function setValue(obj)
	{
		var option = obj.options;
		for(j=0;j<option.length;j++)
		{	 if(option[j].selected)
   				document.getElementById('ufpMethod').value = option[j].value;
		} 
	}
   function changePage(epId,type,functionId,epType)
	{
		var method = document.getElementById('ufpMethod').value;
		if(method==""||method=="5"){
			alert("您尚未选择估算方法！");
		}
		else window.location.href="/ifpug/IFPUG/transaction/saveEpMethod.jsp?ufpMethod="+document.getElementById('ufpMethod').value+"&&epId="+epId+"&&epType="+epType+"&&type="+type+"&&functionId="+functionId;
	}
	function confirmdel(){
    	return confirm("确定删除？");
    }
	</script>
	
  </head>
  
  <body>
   <% 
  	  Integer functionId = Integer.valueOf(request.getParameter("functionId"));
   	  String epType = request.getParameter("epType");
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作 
	  IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
    %>
    
    <h1>功能模块<%= function.getFunctionName()%>的基本流程列表：<font color="red">估算方法选择“手动导入DET”不能修改</font></h1>
    <form name="epListForm">
      <table>
       <tr>
         <td>序号</td> 
         <td>流程名称</td>
         <td>估算方法</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
         <td>开始估算</td>
       </tr>
       <% 
       /*分别先取出功能模块对应的EI、EO、EQ类型基本流程*/
       Object[] eiList = function.getIfpugEis().toArray();
       Object[] eoList = function.getIfpugEos().toArray();
       List list = rb.getEpAfterMerge(function);
       IfpugEi ei;
       IfpugEo eo;
       IfpugEq eq;
       TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(list == null||list.size() == 0){%>  
       <h1 style="color:red">目前无基本流程，请添加流程</h1>
       <%}else{ 
       		 Integer i = 0,j = 0, k = 0, len = list.size();
       		 Integer len_ei = eiList.length;
       		 Integer len_eo = eoList.length;
       		 Integer id = 0;
       		 String name = null;
       		 String type = null;
       		 Integer typeId = -1;
       		 String ufpMethodName = null;
       		 Short ufpMethod;
       		 if(epType != null && epType.length()!= 0)
       		 {
       		 	 if(epType.equals("0")) { len = len_ei; }
       		 	 else if (epType.equals("1")) { k = len_ei; len = len_ei+len_eo; }
       		 	 else if (epType.equals("2")) k = len_ei+len_eo;
       		 }
       		 /*判断EI\EO\EQ，根据类型不同，获取id,name*/
       		 for (j = k; j < list.size()&&j < len; j ++){
       	   	    Object e = list.get(j);
       	   	 	if (j < len_ei){
       	   	 		ei = (IfpugEi)e; 
       	   	 		id = ei.getId();  
       	   	 		name = ei.getEiName();
       	   	 		ufpMethod = ei.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EI";
       	   	 		typeId = 0;
       	   	 		
       	   	 	}
       	   	 	else if (j >= len_ei&& j < (len_ei+len_eo)){
       	   	 		eo = (IfpugEo) e;
       	   	 		id = eo.getId();
       	   	 		name = eo.getEoName();
       	   	 		ufpMethod = eo.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EO";
       	   	 		typeId = 1;
       	   	 	}
       	   	 	else {
       	   	 		eq = (IfpugEq) e;
       	   	 		id = eq.getId();
       	   	 		name = eq.getEqName();
       	   	 		ufpMethod = eq.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EQ";
       	   	 		typeId = 2;
       	   	 	}
       	   	 		/*下段用于表格中添加属性选择不同的链接*/
             	/*如果是“手动添加”，跳转至添加记录元素页面retList.jsp*/
             	/*如果是其他方法，跳转至directMethod.jsp页面*/
             	String linkAddr = null;
             	String linkName = null;
             	if(ufpMethod == 5)
             	{
             		linkName = "";
             	}
                else if(ufpMethod == 0){
             		linkAddr = "/ifpug/IFPUG/transaction/derivedMethod.jsp?ufpMethod=";
             		linkName = "手动添加FTR";
             	}
             	else {
             		linkAddr = "/ifpug/IFPUG/transaction/directMethod.jsp?ufpMethod=";
             		linkName = "输入FTR个数";
             	}
             	%>
             <tr>
	          <td><%= ++ i %></td> 
	          <td><%= name %></td>
	          <td>
	         	 <select name="method<%=i%>"  id ="method<%=i%>"  onchange="setValue(method<%=i%>)" >
  			 	    <!--0代表 derived，1代表default，2代表range,3代表value -->
  			 	    <option style="color:red" value="5">=请选择=</option>
  					<option value="0">手动导入DET</option>
  					<option value="1">默认功能点个数</option>
  					<option value="2">选择DET范围</option>
  					<option value="3">输入DET个数</option>
  					<option value="4">选择复杂度</option>
  				</select>
  				<input type="text" name="ufpMethod" id="ufpMethod"  style="display:none"/>
  				<input type="button" id="submit<%=i%>" onclick="changePage(<%=id%>,<%=typeId%>,<%=functionId%>,'<%=epType%>')" value=" 确定 " />
  				<script language="javascript"> 
  					var button<%=i%> ;
  					var method<%=i%>;
  					button<%=i%> = document.getElementById('submit<%=i%>');
  					method<%=i%> = document.getElementById('method<%=i%>');
  					method<%=i%>.value = <%=ufpMethod%>;
  					if(method<%=i%>.value == "5"){ //如果还未添加估算方法
  						button<%=i%>.style.display='';
  						document.getElementById('method<%=i%>').disabled= false;
  					}
  					else {
  						button<%=i%>.style.display='none';
  						document.getElementById('method<%=i%>').disabled= true;
  					}
  					
  					
                </script>  
       			<input type="hidden" name="id" value="<%=id%>"/>
    			<input type="hidden" name="epId" value="<%=id%>"/>
    			<input type="hidden" name="functionId" value="<%=functionId%>"/>
  				<input type="hidden" name="epType" value="<%=epType%>"/>
  				<input type="hidden" name="type" value="<%=typeId%>"/>
	          </td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/transaction/viewElementaryProcess.jsp?epId=<%=id%>&&type=<%=typeId%>&&epType=<%=epType%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/transaction/editElementaryProcess.jsp?epId=<%=id%>&&type=<%=typeId%>&&epType=<%=epType%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/transaction/delElementaryProcess.jsp?epId=<%=id%>&&type=<%=typeId%>&&epType=<%=epType%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
		      <td>
		       <a href="Javascript:window.location='<%=linkAddr%><%=ufpMethod%>&&type=<%=typeId%>&&epId=<%=id%>&&epType=<%=epType%>'"/><%=linkName%>
			   </a>
		      </td>
	         </tr>  
          <%}
       }%>  
       </table> 
        

    </form>		
 </body>
</html>