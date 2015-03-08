<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加记录元素</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="javascript">
		function ufpCountDisplay(){
	  if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var ufpCount = http_request.responseText;
               OutPut.innerText = ufpCount;
            }
      }
	}
    function ufpCountHttpRequest(fileId,fileType){
       var http_request = creatHttpRequest();
       http_request.onreadystatechange = ufpCountDisplay;
       http_request.open('GET', "/ifpug/servlet/UfpCount?fileId="+fileId+"&&fileType="+fileType, true);
       http_request.send(null);     
    } 
    function creatHttpRequest(){
        if (window.XMLHttpRequest) { // Mozilla, Safari,...
            http_request = new XMLHttpRequest();
            if (http_request.overrideMimeType) {
                http_request.overrideMimeType('text/xml');
            }
        } else if (window.ActiveXObject) { // IE
            try {
                http_request = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    http_request = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }       
        }
        if (!http_request) {
            alert('Giving up :( Cannot create an XMLHTTP instance');
            return false;
        }
       return http_request;
      }

    function countfp(){
      
    }
	function verifyInput()
	{	
		var frm = document.retForm;
	 	if(isEmpty(frm.retName.value)) //如果DET栏填入值为空，给出不能为空的提示信息
		{
			alert("记录元素名称不能为空！");
			frm.retName.focus();
			return false;
		}	
		else if(frm.retName.value == "default")
		{
			alert("记录元素名称不能为default!");
			frm.retName.focus();
			return false;
		}		
	}
    function confirmdel(){
    	return confirm("确定删除？");
    }
     </script>
  </head>
  
  <body>
  <%
  		DataFunctionBusiness dfb = new DataFunctionBusiness();
  		Integer type = new Integer(request.getParameter("type"));//从dataFunction.jsp页面获取文件类型(0\1)
  		Integer dfId = new Integer(request.getParameter("dfId"));//从dataFunction.jsp页面获取文件ID
  		Integer productId = null;
  		Object[] retList = null;  		
  		if(type == 0){//列出对应文件下所有的RET
  			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
  			productId = ilf.getIfpugProduct().getId();
  			retList = ilf.getIfpugIlfRets().toArray();
  		}
  		else {
  			IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
  		    productId = eif.getIfpugProduct().getId();
  			retList = eif.getIfpugEifRets().toArray();
  		}
   %>
    
  
  
   <h1>记录元素列表</h1>
    <table>
       <tr>
         <td>序号</td> 
         <td>记录元素名</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
         <td>添加数据元素</td>
       </tr>
       <% 
      
  		IfpugIlfRet ilfRet = null;
  		IfpugEifRet eifRet = null;
        String name = null;
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(retList == null||retList.length == 0){%>  
       <h1 style="color:red">目前无记录元素，请添加</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer id;
             for(Object r:retList)
             {
             	if(type == 0){//如果是ILF文件的RET元素
             		ilfRet = (IfpugIlfRet)r;
             		name = ilfRet.getIlfRetName();
             		id = ilfRet.getId();
             	}
             	else {//如果是EIF文件的RET元素
             		eifRet = (IfpugEifRet)r;
             		name = eifRet.getEifRetName();
             		id = eifRet.getId();
             	}
	          %>
	         <tr>
	          <td><%= ++i %></td> 
	          <td><%= name %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewRet.jsp?retId=<%=id%>&&type=<%=type%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editRet.jsp?retId=<%=id%>&&type=<%=type%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="点击修改" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delRet.jsp?retId=<%=id%>&&type=<%=type%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
		      <td><a href="/ifpug/IFPUG/dataFunction/detList.jsp?retId=<%=id%>&&type=<%=type%>" >添加数据元素</a></td>
	         </tr>  
          <%}
       }%>  
    </table>
  
  
    <h1>新增记录元素</h1>  
     <form  name="retForm" action="/ifpug/IFPUG/addRet.do" onsubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">记录名称</td>
  			<td >
  			    <input type="text" name="retName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">记录描述</td>
  			<td >
  			    <textarea name="retDesp"></textarea>
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
    <input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="dfId" value="<%=dfId%>"/>
    <input type="hidden" name="id" value="<%=dfId%>"/>   
    
 <%-- <h1>功能点个数</h1>  
  <table>
    <tr>
      <td style="font-size:12">目前功能点个数:   <input id="OutPut"/> </td> 
    </tr>
    <tr>
      <td><button onclick="ufpCountHttpRequest(<%=dfId%>,<%=type%>)">重新计算</button> </td> 
    </tr>  
   </table> --%> 
     <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId %>'"> 返回数据功能列表</a>
  	</form> 			
  </body>
</html>
