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
    
    <title>�޸�������ģ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
 	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
 	<script language="JavaScript">
 	function verifyInput(editEstimate,editType)
 	{
 		var frm = document.functionForm;	    	   
		if(isEmpty(frm.functionName.value)) 
		{	
			 alert("����д����ģ�����ƣ�");
			 frm.functionName.focus();
			 return false;
		}
		
		//�ж�ģ�������Ƿ��ܹ��޸�
		if(!isEmpty(frm.functionType.value))
		{   
			switch(frm.functionType.value){
				case '0': //�޸ĳ����ģ��
				{
					if(editType==2) {  //editType == 2��ʾ��ģ�����ԭ��ģ�飬�ְ�����������
						 alert("��ģ�����Ͳ����޸ģ�");
						 frm.functionType.focus();
						 return false;
					} 
					//else return true;
					break;
				}
				case '1': //�޸ĳ�ԭ��ģ��
				{
					if(editType==4){ //editType == 4��ʾ��ģ��������ģ�飬�ְ�����ģ��
						alert("��ģ������̬�����޸ģ�");
						frm.functionType.focus();
						return false;
					} 
					//else  return true;
			        break;
			     }
			    default��alert("error"); break;
			}
		}
		//�жϹ���״̬�Ƿ��ܹ��޸�
		if (!isEmpty(frm.measureStatus.value))
		{   
			switch(frm.measureStatus.value){
				case "0": //�ɷ��޸�Ϊδ����״̬
					if (editEstimate == 0)  return true;
					else {
						 alert("�˹���״̬�����޸�Ϊδ���㣡");
						 frm.measureStatus.focus();
						 return false;
					} 
					break;
				case "1": //�ɷ��޸�Ϊ���ֹ���״̬
					if (editEstimate == 1)  return true;
					else {
						 alert("�˹���״̬�����޸�Ϊ���ֹ��㣡");
						 frm.measureStatus.focus();
						 return false;
					}
					break;
				case "2": //�ɷ��޸�Ϊ�ѹ���״̬
					if (editEstimate == 2)  return true;
					else{
						 alert("�˹���״̬�����޸�Ϊ�ѹ��㣡");
						 frm.measureStatus.focus();
						 return false;
					}
					break;
				//default : alert("error!"); break;
			}
		}
 	}
 	</script>
  </head>
  
  <body>
      <%
       /*��ȡ��ҳ��functionList.jsp����functionId*/
      Integer functionId = new Integer(request.getParameter("functionId"));
      /*�����ݿ��а�idΪfunctionId��������ȡ��*/
      RequirementBusiness rb = new RequirementBusiness(); //ҵ��㣬��Ӧ��IFPUG�����Ĳ��Խ׶�
      IfpugFunction ifi = (IfpugFunction)rb.getFunctionById(functionId); //��ȡ���ܶ���
      IfpugProduct product = ifi.getIfpugProduct();//ͨ�����ܵ�IfpugProduct���Ի�ȡProduct����
      Integer productId = product.getId();//���productId������ת��functionListҳ��
     
      //�жϹ���״̬�ܷ��Ϊδ����
      Integer editEstimate = rb.editFunctionEstimateCheck(functionId);
      //�ж�ģ�������ܷ��޸�
      Integer editType = rb.editFunctionTypeCheck(functionId);
      %>
      
  <form  action="/ifpug/IFPUG/editFunction.do" name="functionForm" method="post" onSubmit="return verifyInput(<%=editEstimate%>,<%=editType%>);">
     <table>
  		<tr>
  			<td width="15%">ģ������</td>
  			<td >
  			    <input type="text" name="functionName" style="width:160px" value="<%=ifi.getFunctionName()%>"/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">ģ������</td>
  			<td >
  			    <textarea name="functionDesp"><%=ifi.getFunctionDesp()%></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">ģ������</td>
  			<td >
  			 	<select name="functionType" style="width:160px" >
  			 	    <!--0�������ģ�飬1����ԭ��ģ��  -->
  					<option value="0" >���ģ��</option>
  					<option value="1">ԭ��ģ��</option>
  				</select>
  				<script language="javascript">   
                  document.functionForm.functionType.value="<%=ifi.getFunctionType()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td width="15%">����״̬</td>
  			<td >
  			 	<select name="measureStatus" style="width:160px" >
  			 	   <!--0����δ���㣬1�����ֹ��㣬2�����ѹ���  -->
  					<option value="0">δ����</option>
  					<option value="1">���ֹ���</option>
  					<option value="2">�ѹ���</option>
  				</select>
  				<script language="javascript">   
                  document.functionForm.measureStatus.value="<%= ifi.getMeasureStatus()%>";   
                </script>
            </td>
  		</tr>
  	</table>
  	<input type="submit" name="submit" value=" �� �� "/>
    <input type='button' onclick="Javascript:window.location='functionList.jsp?productId=<%=productId %>'" value=" �� �� ">
  	<input type="hidden" name="id" value="<%=functionId%>"/>
  	<input type="hidden" name="productId" value="<%=productId%>"/>
	</form>
  </body>
</html>
