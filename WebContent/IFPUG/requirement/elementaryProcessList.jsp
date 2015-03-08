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
    <title>���ӻ�������</title>
    
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
    	var frm = document.epForm; 
    	if(isEmpty(frm.epName.value)) 
		{
			alert("����д���̵����ƣ�");
			frm.epName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>   
      <%
      //��ȡ��childFunctionList.jsp��������functionId
      Integer functionId = new Integer(request.getParameter("functionId"));
      RequirementBusiness rb = new RequirementBusiness();
      IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
      IfpugFunction fatherFunction = function.getIfpugFunction();
      String linkName = null;
      Integer changeId;
      if(fatherFunction == null){//�����ģ��û�и�ģ�飬����functionList.jsp
        	linkName = "/ifpug/IFPUG/requirement/functionList.jsp?productId="; 
        	IfpugProduct product = function.getIfpugProduct();
        	changeId = product.getId();
      }
      else {//���򣬷�����ģ���б�
      		linkName = "/ifpug/IFPUG/requirement/childFunctionList.jsp?functionId="; 
      		changeId = fatherFunction.getId();
      }
      %>
       <h1> ��ģ��<%= function.getFunctionName()%>�Ļ��������б�</h1>
      <table>
       <tr>
         <td>���</td> 
         <td>��������</td>
         <td>��������</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
       </tr>
       <% 
       /*�ֱ���ȡ������ģ���Ӧ��EI��EO��EQ���ͻ�������*/
       Object[] eiList = function.getIfpugEis().toArray();
       Object[] eoList = function.getIfpugEos().toArray();
       List list = rb.getEpAfterMerge(function);
       IfpugEi ei;
       IfpugEo eo;
       IfpugEq eq;
       /*���޹�����Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if(list == null||list.size() == 0){%>  
       <h1 style="color:red">Ŀǰ�޻������̣����������</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer len_ei = eiList.length;
       		 Integer len_eo = eoList.length;
       		 Integer id = 0;
       		 String name = null;
       		 String type = null;
       		 Integer typeId = -1;
       		 /*�ж�EI\EO\EQ���������Ͳ�ͬ����ȡid,name*/
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
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/requirement/editElementaryProcess.jsp?epId=<%=id%>&type=<%=typeId%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/requirement/delElementaryProcess.jsp?epId=<%=id%>&type=<%=typeId%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		          </a>
		      </td>
	         </tr>  
          <%}
       }%>  
       </table>
       
     <h1>������������</h1>    
     <form  action ="/ifpug/IFPUG/addElementaryProcess.do" name="epForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">��������</td>
  			<td >
  			    <input type="text" name="epName" style="width:160px" value=""/>
            </td>
  		</tr>
  		<tr>
  	    	<td valign="top">��������<br></td>
  	    	<td valign="top">
  	    		<!--0����EI��1����EO,2����EQ  -->
  		   		<input type="radio" checked="checked" value="0" name="epType">EI
  		   		<input type="radio" value="1" name="epType">EO
  		   		<input type="radio" value="2" name="epType">EQ
  		   </td>
  		</tr>
  		<tr>
  			<td width="10%">�������������</td>
  			<td >
  			    <textarea name="epDesp"></textarea>
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
   <a href ="Javascript:(window.name=='contentFrame'||window.name=='functionFrame'||window.name=='epFrame')?window.location='<%=linkName %><%=changeId%>':parent.location='<%=linkName %><%=changeId%>'"> ���ص�������ģ���б�</a>
  	</form> 
  </body>
</html>
