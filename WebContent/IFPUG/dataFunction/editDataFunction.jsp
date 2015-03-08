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
    
    <title>�޸����ݹ���</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  </head>
  
  <body>
   <% 
   	   //��ȡ��ҳ��dataFunctionList.jsp����dfId��type,����ɾ������
       Integer dfId = new Integer(request.getParameter("dfId"));
       Integer type = new Integer(request.getParameter("type"));
       DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼���
       Integer productId;
       String name = null, desp = null;
       Short ufpMethod ;
       if(type == 0){ //�����ILF�ļ�
       		IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
       		name = ilf.getIlfName();
       		desp = ilf.getIlfDesp();
       		ufpMethod = ilf.getUfpMethod();       	
       		productId = ilf.getIfpugProduct().getId();	
       }
       else { //�����EIF�ļ�
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
  			<td width="15%">�����ļ���</td>
  			<td >
  			    <input type="text" name="name" style="width:160px" value="<%=name %>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">�����ļ�����</td>
  			<td >
  			    <textarea name="desp"><%=desp %></textarea>
            </td>
  		</tr>
  		<tr>
  	    	<td width="15%">�����ļ�����</td>
  	    	<td>
  	    		 <!--0����ILF��1����EIF  -->
  		   		<input type="radio" checked="checked" value="0" name="type">ILF
  		   		<input type="radio" value="1" name="type">EIF
  		   		<script language="javascript">   
                  var typeObject = document.getElementsByName("type");
                  //�¶δ���ĺ���ѡ���ļ�����
                 typeObject[<%=type%>].checked = true;
                 typeObject[1-<%=type%>].disabled = true; //��֤���Ͳ����޸�
                </script>
  		   	</td>
  		<tr>
  			<td width="10%">��������</td>
  			<td >
  			 	<select name="ufpMethod" style="width:160px" disabled="true">
  			 	    <!--0���� derived��1����default��2����range,3����value -->
  					<option value="0" selected>�ֶ����</option>
  					<option value="1">Ĭ��ֵ</option>
  					<option value="2">�û�ѡ��</option>
  					<option value="3">�û�����</option>
  					<option value="4">ѡ���Ӷ�</option>
  				</select>
  				<script language="javascript">   
                  document.dfForm.ufpMethod.value="<%= ufpMethod%>";   
                </script>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" �� �� "/>
    <input type='button' onclick="Javascript:window.location='dataFunctionList.jsp?productId=<%=productId%>'" value=" �� �� ">
    <input type="hidden" name="id" value="<%=dfId%>"/>
    <input type="hidden" name="productId" value="<%=productId%>"/>
  	</form> 			
  </body>
</html>
