
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
    
    <title>�޸Ļ�������</title>
    
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
			alert("����δѡ����㷽����");
		}
		else window.location.href="/ifpug/IFPUG/transaction/saveEpMethod.jsp?ufpMethod="+document.getElementById('ufpMethod').value+"&&epId="+epId+"&&epType="+epType+"&&type="+type+"&&functionId="+functionId;
	}
	function confirmdel(){
    	return confirm("ȷ��ɾ����");
    }
	</script>
	
  </head>
  
  <body>
   <% 
  	  Integer functionId = Integer.valueOf(request.getParameter("functionId"));
   	  String epType = request.getParameter("epType");
	  RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯������װ����������е���ɾ�Ĳ�Ȳ��� 
	  IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
    %>
    
    <h1>����ģ��<%= function.getFunctionName()%>�Ļ��������б�<font color="red">���㷽��ѡ���ֶ�����DET�������޸�</font></h1>
    <form name="epListForm">
      <table>
       <tr>
         <td>���</td> 
         <td>��������</td>
         <td>���㷽��</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
         <td>��ʼ����</td>
       </tr>
       <% 
       /*�ֱ���ȡ������ģ���Ӧ��EI��EO��EQ���ͻ�������*/
       Object[] eiList = function.getIfpugEis().toArray();
       Object[] eoList = function.getIfpugEos().toArray();
       List list = rb.getEpAfterMerge(function);
       IfpugEi ei;
       IfpugEo eo;
       IfpugEq eq;
       TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
       /*���޹�����Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if(list == null||list.size() == 0){%>  
       <h1 style="color:red">Ŀǰ�޻������̣����������</h1>
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
       		 /*�ж�EI\EO\EQ���������Ͳ�ͬ����ȡid,name*/
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
       	   	 		/*�¶����ڱ�����������ѡ��ͬ������*/
             	/*����ǡ��ֶ���ӡ�����ת����Ӽ�¼Ԫ��ҳ��retList.jsp*/
             	/*�����������������ת��directMethod.jspҳ��*/
             	String linkAddr = null;
             	String linkName = null;
             	if(ufpMethod == 5)
             	{
             		linkName = "";
             	}
                else if(ufpMethod == 0){
             		linkAddr = "/ifpug/IFPUG/transaction/derivedMethod.jsp?ufpMethod=";
             		linkName = "�ֶ����FTR";
             	}
             	else {
             		linkAddr = "/ifpug/IFPUG/transaction/directMethod.jsp?ufpMethod=";
             		linkName = "����FTR����";
             	}
             	%>
             <tr>
	          <td><%= ++ i %></td> 
	          <td><%= name %></td>
	          <td>
	         	 <select name="method<%=i%>"  id ="method<%=i%>"  onchange="setValue(method<%=i%>)" >
  			 	    <!--0���� derived��1����default��2����range,3����value -->
  			 	    <option style="color:red" value="5">=��ѡ��=</option>
  					<option value="0">�ֶ�����DET</option>
  					<option value="1">Ĭ�Ϲ��ܵ����</option>
  					<option value="2">ѡ��DET��Χ</option>
  					<option value="3">����DET����</option>
  					<option value="4">ѡ���Ӷ�</option>
  				</select>
  				<input type="text" name="ufpMethod" id="ufpMethod"  style="display:none"/>
  				<input type="button" id="submit<%=i%>" onclick="changePage(<%=id%>,<%=typeId%>,<%=functionId%>,'<%=epType%>')" value=" ȷ�� " />
  				<script language="javascript"> 
  					var button<%=i%> ;
  					var method<%=i%>;
  					button<%=i%> = document.getElementById('submit<%=i%>');
  					method<%=i%> = document.getElementById('method<%=i%>');
  					method<%=i%>.value = <%=ufpMethod%>;
  					if(method<%=i%>.value == "5"){ //�����δ��ӹ��㷽��
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
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/transaction/editElementaryProcess.jsp?epId=<%=id%>&&type=<%=typeId%>&&epType=<%=epType%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/transaction/delElementaryProcess.jsp?epId=<%=id%>&&type=<%=typeId%>&&epType=<%=epType%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
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