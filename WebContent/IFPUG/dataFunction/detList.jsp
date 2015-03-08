<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%>
<%@ page import="hibernate.IFPUG.IfpugIlfDet"%>
<%@ page import="hibernate.IFPUG.IfpugEifDet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据元素列表</title>
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
    	var frm = document.detForm; 
    	if(isEmpty(frm.detName.value)) 
		{
			alert("请填写数据元素的名称！");
			frm.detName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>
  <%
  	//获取从addDet.jsp页面传过来的retId,type
  	Integer type = new Integer(request.getParameter("type"));
  	Integer retId = new Integer(request.getParameter("retId")); 
  	DataFunctionBusiness dfb = new DataFunctionBusiness();
  	Object[] detList = null;
  	IfpugIlfRet ilfRet = null;
  	IfpugEifRet eifRet = null;
	Integer dfId;
  	if(type == 0){//如果是ILF下RET的DET
  		IfpugIlfRet iir = (IfpugIlfRet)dfb.queryIlfRetById(retId);//通过retId获得RET对象
  		if(iir == null){ //如果没有找到该retId的记录,说明该RETid为负，是默认RET
  			dfId = Integer.valueOf(retId.toString().substring(1));
  			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
  			Object[] retList = ilf.getIfpugIlfRets().toArray();//获取对应数据功能文件下所有的RET
  			for (Object r:retList){//找到下属列表中名字为default的RET
  				IfpugIlfRet ret = (IfpugIlfRet)r;
  				if(ret.getIlfRetName().equals("default"))  
  				{
  					ilfRet = ret; 
  					detList = ilfRet.getIfpugIlfDets().toArray();	
  					break;	
  				}
  			}	
  		}
  	    else{
  	    	detList = iir.getIfpugIlfDets().toArray();//根据级联关系，获取该RET对象下属的DET
  	    	dfId = iir.getIfpugIlf().getId();
  	    }  			
  	}
  	else {//如果是EIF下RET的DET
  		IfpugEifRet ier = (IfpugEifRet)dfb.queryEifRetById(retId);
  		if(ier == null){//如果没有找到该retId的记录,说明该RETid为负，是默认RET
  			dfId = Integer.valueOf(retId.toString().substring(1));
  			IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
  			Object[] retList = eif.getIfpugEifRets().toArray();//获取对应数据功能文件下所有的RET
  			for (Object r:retList){//找到下属列表中名字为default的RET
  				IfpugEifRet ret = (IfpugEifRet)r;
  				if(ret.getEifRetName().equals("default"))  
  				{
  					eifRet = ret; 
  					detList = eifRet.getIfpugEifDets().toArray();
  					break;	
  				}
  			}
  			
  		}
  		else {
  			detList = ier.getIfpugEifDets().toArray();//根据级联关系，获取该RET对象下属的DET 
  			dfId = ier.getIfpugEif().getId();
  		}
  	}
  	%>
  	 <h1> 数据元素列表</h1>
      <table>
       <tr>
         <td>序号</td> 
         <td>数据名称</td>
         <td>所属文件类型</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
       </tr>
       <% 
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(detList == null||detList.length == 0){%>  
       <h1 style="color:red">目前无数据元素，请添加</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer detId; 
       		 String name;//用于显示数据元素的名字
       		 String typeName;//所属文件类型的名称ILF、EIF
       		 for(Object d:detList){
       		 	if(type == 0){//如果是ILF的DET
       		 		IfpugIlfDet det = (IfpugIlfDet)d;
       		 		detId = det.getId();
       		 		name = det.getIlfDetName();
       		 		typeName = "ILF";
       		 	}
       		 	else {//如果是EIF的DET
       		 		IfpugEifDet det = (IfpugEifDet)d;
       		 		detId = det.getId();
       		 		name = det.getEifDetName();
       		 		typeName = "EIF";
       		 		
       		 	}
	         %>
	         <tr>
	          <td><%= ++ i %></td> 
	          <td><%= name %></td>
	          <td><%= typeName %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewDet.jsp?detId=<%=detId%>&&type=<%=type%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editDet.jsp?detId=<%=detId%>&&type=<%=type%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delDet.jsp?detId=<%=detId%>&&type=<%=type%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
	         </tr>  
          <%}
       }%>  
       </table>
  
    <h1>新增数据元素</h1>  
     <form  action="/ifpug/IFPUG/addDet.do" name="detForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">数据名称</td>
  			<td >
  			    <input type="text" name="detName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">数据描述</td>
  			<td >
  			    <textarea name="detDesp"></textarea>
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
  	<script language="JavaScript">
  	function selectFrame(type,dfId){
  		if(window.name=="contentFrame"||window.name == "retFrame"){
  			window.location.href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>";
  		}  
  		else if(window.name == "detFrame"){
  			parent.location.href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>";
  		}
  	}
  	</script>
  	<input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="retId" value="<%=retId%>"/>
  	</form> 	
  	
  	<form action="/ifpug/IFPUG/ufpCount_Derived.do">	
  		<table>
  			<tr>
  				<td width="10%">
  					<input type="submit" name="submit" value=" 完成添加,计算功能点 "/>
  				</td>
  			</tr>
  		</table>
  		<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="dfId" value="<%=dfId%>"/>
    	<input type="hidden" name="retId" value="<%=retId%>"/>
  	</form>	
  	 <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&dfId=<%=dfId%>'"> 返回记录元素列表</a>	
  </body>
</html>

