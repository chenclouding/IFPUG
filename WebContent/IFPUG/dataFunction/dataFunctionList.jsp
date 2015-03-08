<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct"%> 
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
    
    <title>添加内部逻辑文件</title>
    
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
    	var frm = document.dfForm; 
    	if(isEmpty(frm.name.value)) 
		{
			alert("请填写数据功能的名称！");
			frm.name.focus();
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
    <h1> <%= product.getProductName()%>产品的数据功能列表</h1>
    <table>
       <tr>
         <td>序号</td> 
         <td>文件名</td>
         <td>功能点个数</td>
         <td>类型</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
         <td>添加记录元素</td>
       </tr>
       <% 
       /*分别先取出所有ILF\EIF*/
       Object[] ilfList = product.getIfpugIlfs().toArray(); //获取所有ILF列表
       Object[] eifList = product.getIfpugEifs().toArray(); //获取所有EIF列表
       Integer length = ilfList.length;
 	   int k = 0;
       List list = new ArrayList(length+eifList.length);
       if(ilfList != null && ilfList.length != 0)
       {
    		for(Object ilf:ilfList)
    			list.add(ilf);
       }
       if(eifList != null && eifList.length != 0)
       {
       		for (Object eif:eifList)
       			list.add(eif);
       }
       IfpugIlf ii = null; 
       IfpugEif ie = null;
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if((ilfList == null||ilfList.length == 0)&&(eifList == null||eifList.length == 0)){%>  
       <h1 style="color:red">目前无ILF\EIF文件，请添加数据文件</h1>
       <%}else{ 
             Integer i = 0, id = 0;
             String name = null;
             Integer ufpCount = 0;
             String type = null;
             Short  ufpMethod;
             Integer typeId;
             
              for(Object e:list)
              {
             	if(i < length){
             	    ii =  (IfpugIlf)e;
             		name = ii.getIlfName();
             		type = "ILF";
             		typeId = 0;
             		ufpCount = ii.getUfpCount();
             		ufpMethod = ii.getUfpMethod();
             		id = ii.getId();
             	}
             	else {
              		ie =  (IfpugEif)e;
             		name = ie.getEifName();
             		type = "EIF";
             		typeId = 1;
             		ufpCount = ie.getUfpCount();
             		ufpMethod = ie.getUfpMethod();
             		id = ie.getId();
             	}
             	/*下段用于表格中添加属性选择不同的链接*/
             	/*如果是“手动添加”，跳转至添加记录元素页面retList.jsp*/
             	/*如果是其他方法，跳转至directMethod.jsp页面*/
             	String linkAddr = null;
             	String linkName = null;
             	if(ufpMethod == 0){
             		linkAddr = "/ifpug/IFPUG/dataFunction/retList.jsp?ufpMethod=";
             		linkName = "手动导入RET";
             	}
             	else {
             		linkAddr = "/ifpug/IFPUG/dataFunction/directMethod.jsp?ufpMethod=";
             		linkName = "输入RET个数";
             	}
             
	          %>
	         <tr>
	          <td><%= ++i %></td> 
	          <td><%= name %></td>
	          <td><%= ufpCount %></td>
	          <td><%= type %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
		      <td><a href="<%=linkAddr%><%=ufpMethod%>&&type=<%=typeId%>&&dfId=<%=id%>"><%=linkName%></a></td>
	         </tr>  
          <%}
       }%>  
    </table>
    
    
    <form  action="/ifpug/IFPUG/addDataFunction.do" name="dfForm" method="post" onSubmit="return verifyInput();">
  	<table>
  		<tr>
  			<td width="15%">数据文件名</td>
  			<td >
  			    <input type="text" name="name" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">数据文件描述</td>
  			<td >
  			    <textarea name="desp"></textarea>
            </td>
  		</tr>
  		<tr>
  	    	<td width="15%">数据文件类型</td>
  	    	<td>
  	    		 <!--0代表ILF，1代表EIF  -->
  		   		<input type="radio" checked="checked" value="0" name="type">ILF
  		   		<input type="radio" value="1" name="type">EIF
  		   </td>
  		<tr>
  			<td width="10%">方法类型</td>
  			<td >
  			 	<select name="ufpMethod" style="width:160px">
  			 	    <!--0代表 derived，1代表default，2代表range,3代表value -->
  					<option value="0" selected>手动导入DET</option>
  					<option value="1">默认功能点个数</option>
  					<option value="2">选择DET范围</option>
  					<option value="3">输入DET个数</option>
  					<option value="4">选择复杂度</option>
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
  	</form> 
  	 <input type="hidden" name="productId" value="<%=productId%>"/>			
  </body>
</html>
