<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %> 
<%@ page import="hibernate.IFPUG. IfpugProduct" %>
<%@ page import="hibernate.IFPUG.IfpugEi"%> 
<%@ page import="hibernate.IFPUG.IfpugEo"%> 
<%@ page import="hibernate.IFPUG.IfpugEq"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>增加基本流程</title>
    
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
    	var frm = document.epForm; 
    	if(isEmpty(frm.epName.value)) 
		{
			alert("请填写流程的名称！");
			frm.epName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>   
      <%
      //获取从childFunctionList.jsp传过来的functionId
      Integer functionId = new Integer(request.getParameter("functionId"));
      RequirementBusiness rb = new RequirementBusiness();
      IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
      IfpugFunction fatherFunction = function.getIfpugFunction();
      String linkName = null;
      Integer changeId;
      if(fatherFunction == null){//如果该模块没有父模块，返回functionList.jsp
        	linkName = "/ifpug/IFPUG/requirement/functionList.jsp?productId="; 
        	IfpugProduct product = function.getIfpugProduct();
        	changeId = product.getId();
      }
      else {//否则，返回子模块列表。
      		linkName = "/ifpug/IFPUG/requirement/childFunctionList.jsp?functionId="; 
      		changeId = fatherFunction.getId();
      }
      %>
       <h1> 子模块<%= function.getFunctionName()%>的基本流程列表</h1>
      <table>
       <tr>
         <td>序号</td> 
         <td>流程名称</td>
         <td>流程类型</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
       </tr>
       <% 
       /*分别先取出功能模块对应的EI、EO、EQ类型基本流程*/
       Object[] eiList = function.getIfpugEis().toArray();
       Object[] eoList = function.getIfpugEos().toArray();
       List list = rb.getEpAfterMerge(function);
       IfpugEi ei;
       IfpugEo eo;
       IfpugEq eq;
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(list == null||list.size() == 0){%>  
       <h1 style="color:red">目前无基本流程，请添加流程</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer len_ei = eiList.length;
       		 Integer len_eo = eoList.length;
       		 Integer id = 0;
       		 String name = null;
       		 String type = null;
       		 Integer typeId = -1;
       		 /*判断EI\EO\EQ，根据类型不同，获取id,name*/
       	   	 for(Object e:list){
       	   	 	if (i < len_ei){
       	   	 		ei = (IfpugEi)e; 
       	   	 		id = ei.getId();  
       	   	 		name = ei.getEiName();
       	   	 		type = "EI";
       	   	 		typeId = 0;
       	   	 	}
       	   	 	else if (i >= len_ei&& i < (len_ei+len_eo)){
       	   	 		eo = (IfpugEo) e;
       	   	 		id = eo.getId();
       	   	 		name = eo.getEoName();
       	   	 		type = "EO";
       	   	 		typeId = 1;
       	   	 	}
       	   	 	else {
       	   	 		eq = (IfpugEq) e;
       	   	 		id = eq.getId();
       	   	 		name = eq.getEqName();
       	   	 		type = "EQ";
       	   	 		typeId = 2;
       	   	 	}
	         %>
	         <tr>
	          <td><%= ++ i %></td> 
	          <td><%= name %></td>
	          <td><%= type %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/requirement/viewElementaryProcess.jsp?epId=<%=id%>&type=<%=typeId%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/requirement/editElementaryProcess.jsp?epId=<%=id%>&type=<%=typeId%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/requirement/delElementaryProcess.jsp?epId=<%=id%>&type=<%=typeId%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
	         </tr>  
          <%}
       }%>  
       </table>
       
     <h1>新增基本流程</h1>    
     <form  action ="/ifpug/IFPUG/addElementaryProcess.do" name="epForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">流程名称</td>
  			<td >
  			    <input type="text" name="epName" style="width:160px" value=""/>
            </td>
  		</tr>
  		<tr>
  	    	<td valign="top">流程类型<br></td>
  	    	<td valign="top">
  	    		<!--0代表EI，1代表EO,2代表EQ  -->
  		   		<input type="radio" checked="checked" value="0" name="epType">EI
  		   		<input type="radio" value="1" name="epType">EO
  		   		<input type="radio" value="2" name="epType">EQ
  		   </td>
  		</tr>
  		<tr>
  			<td width="10%">待估算软件描述</td>
  			<td >
  			    <textarea name="epDesp"></textarea>
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
    <input type="hidden" name="functionId" value="<%=functionId%>"/>
    <input type="hidden" name="id" value="<%=functionId%>"/>
    <script language="JavaScript">
  	function selectFrame(){
  		if(window.name=="contentFrame"||window.name=="functionFrame"||window.name=="epFrame"){
  			window.location.href="<%=linkName %><%=changeId%>";
  		}     
  		else {
  			parent.location.href="<%=linkName %><%=changeId%>";
  		}
  	}
  	</script> 
   <a href ="Javascript:(window.name=='contentFrame'||window.name=='functionFrame'||window.name=='epFrame')?window.location='<%=linkName %><%=changeId%>':parent.location='<%=linkName %><%=changeId%>'"> 返回到父功能模块列表</a>
  	</form> 
  </body>
</html>
