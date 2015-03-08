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
    
    <title>�����ӹ���ģ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="JavaScript">
    function confirmdel(){
    	return confirm("ȷ��ɾ����");
    }
    function verifyInput(){
    	var frm = document.childFunctionForm; 
    	if(isEmpty(frm.functionName.value)) 
		{
			alert("����д����ģ������ƣ�");
			frm.functionName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>   
      <%
      Integer functionId = new Integer(request.getParameter("functionId"));
      RequirementBusiness rb = new RequirementBusiness();
      IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
      IfpugProduct product = (IfpugProduct)function.getIfpugProduct(); //��ȡ��ģ�������Ĳ�Ʒ����
      Integer id;//���id���ڷ��ع���ģ���б�
      String link = null;
      if(product == null){//�����ģ�黹�и�ģ�飬����ͣ����childFunctionList.jsp,ֻ��id����
      		link = "/ifpug/IFPUG/requirement/childFunctionList.jsp?functionId=";
      		id = function.getIfpugFunction().getId();
      }
      else { //����ص���ģ���б�
      		link = "/ifpug/IFPUG/requirement/functionList.jsp?productId=";
      		id = product.getId();
      }
      %>
      <h1> <%=function.getFunctionName()%>ģ�����ģ���б�</h1>
      <table>
       <tr>
         <td>���</td> 
         <td>��������</td>
         <td>��������</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
         <td>��ӹ���</td>
       </tr>
       <% 
       /*�����ݿ��аѸ�����Ĺ���ȡ��*/
       Object[] functionList = function.getIfpugFunctions().toArray();  
       IfpugFunction childFunction;//����ʵ��Bean
     
       /*���������Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if(functionList==null||functionList.length==0){%>  
       <h1 style="color:red">Ŀǰ�޹���ģ�飬����ӹ���</h1>
       <%}else{ 
           Integer i = 0;
       	   for(Object f:functionList){
	         function = (IfpugFunction)f; 
	         Integer childFunctionId = function.getId();  
	         %>
	         <tr>
	          <td><%= ++i%></td> 
	          <td><%= function.getFunctionName() %></td>
	          <td>
	          <%Short status = function.getFunctionType();
	         	String showstatus = null, linkName = null; 
	         	String name1="/ifpug/IFPUG/requirement/", name2 = null;
	         	if(status==1){
	         		showstatus="ԭ��ģ��";
	         		linkName="��ӻ�������";
	         		name2="elementaryProcessList.jsp?functionId=";
	         	}  
	         	else {
	         		showstatus="���ģ��";
	         		linkName="�����ģ��";
	         		name2="childFunctionList.jsp?functionId=";
	         	}  
	         %>
	          	<%= showstatus%></td>
	          	 <td class = checkimg>
	              	  <a href="/ifpug/IFPUG/requirement/viewChildFunction.jsp?functionId=<%=childFunctionId%>">
	              	  	<IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              	  </a>
	              </td>	
		          <td class = editimg>
		          	  <a href="/ifpug/IFPUG/requirement/editChildFunction.jsp?functionId=<%=childFunctionId%>">
		          	  	<IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          	  </a>
		          </td>
		          <td class = delimg>
		              <a href="/ifpug/IFPUG/requirement/delChildFunction.jsp?functionId=<%=childFunctionId%>" onclick="return confirmdel()">
		              	<img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		              </a>
		          </td>
		           <td><a href="<%=name1+ name2+childFunctionId%>"><%=linkName%></a></td>
	         </tr>  
          <%}
       }%>  
       </table>
       
     <h1>����ģ��</h1>    
     <form  action="/ifpug/IFPUG/addChildFunction.do" name="childFunctionForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">ģ������</td>
  			<td >
  			    <input type="text" name="functionName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">ģ������</td>
  			<td >
  			    <textarea name="functionDesp"></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">ģ������</td>
  			<td >
  			 	<select name="functionType" style="width:160px" >
  			 	    <!--0�������ģ�飬1����ԭ��ģ��  -->
  					<option value="0" selected>���ģ��</option>
  					<option value="1">ԭ��ģ��</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  		    <td>
  				<input type="submit" name="submit" value=" ��  �� "/>
  			</td>
  			<td>
  				<input type="reset" name="reset" value=" ��  �� "/>
  			</td>
  		</tr>
  	</table>
    <input type="hidden" name="functionId" value="<%=functionId%>"/>
    <input type="hidden" name="id" value="<%=functionId%>"/>
  	<a href ="Javascript:window.location='<%=link%><%=id%>'"> ���ص�����ģ���б�</a>
  	</form> 			
  </body>
</html>
