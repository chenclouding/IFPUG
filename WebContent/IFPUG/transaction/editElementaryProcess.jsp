<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
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
  </head>
  
  <body>
   <%
      //��ҳ��Ϊ�޸Ļ������̵�ҳ�棬�޸Ľ����践��elementaryProcessList.jsp,�ش�functionId.
      Integer epId = new Integer(request.getParameter("epId"));//��ȡ��ҳ��elementaryProcessList.jsp����epId,����ɾ������
	  Integer type = Integer.valueOf(request.getParameter("type"));
	  String epType = request.getParameter("epType");
	  RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯������װ����������е���ɾ�Ĳ�Ȳ���
	  Object epObject = rb.getElementaryProcessById(type,epId);//ͨ��epId��ȡEP����
	   //���ݻ����������͵Ĳ�ͬ���ڲ�ͬ���ݿ���л�ȡ�������̶�Ӧ�Ĺ���ģ��ID
	  String desp = null, name = null;
	  Short measureStatus = null;
	  IfpugFunction function = null;
	  Short ufpMethod = null;
	  switch(type){
	  	case 0:
	  		IfpugEi ei = (IfpugEi)epObject;
	  		desp = ei.getEiDesp();
	  		name = ei.getEiName();
	  		measureStatus = ei.getMeasureStatus();
	  		ufpMethod = ei.getUfpMethod();
	  		function = ei.getIfpugFunction();
	  		break;
	    case 1:
	   		IfpugEo eo = (IfpugEo)epObject;
	  		desp = eo.getEoDesp();
	  		name = eo.getEoName();
	  		measureStatus = eo.getMeasureStatus();
	  		function = eo.getIfpugFunction();
	  		break;
	  	case 2:
	  		IfpugEq eq = (IfpugEq)epObject;
	  		desp = eq.getEqDesp();
	  		name = eq.getEqName();
	  		measureStatus = eq.getMeasureStatus();
	  		function = eq.getIfpugFunction();
	  		break;
	   }
	   Integer functionId = function.getId();
    %>
      
  <form  action ="/ifpug/IFPUG/editElementaryProcess.do" name ="epForm">
  	 <table>
  		<tr>
  			<td width="15%">��������</td>
  			<td >
  			    <input type="text" name="epName" style="width:160px" value="<%=name%>"/>
            </td>
  		</tr>
  		<tr>
  	    	<td valign="top">��������<br></td>
  	    	<td  valign="top">
  	    		<!--0����EI��1����EO,2����EQ  -->
  		   		<input type="radio" checked="checked" value="0" name="epType">EI
  		   		<input type="radio" value="1" name="epType">EO
  		   		<input type="radio" value="2" name="epType">EQ
  		   		<script language="javascript">   
                  var type = document.getElementsByName("epType");
                  //�¶δ���ĺ���ʹ�������̵�������ѡ�к󣬲����޸�
                  for (var i = 0; i < 3; i ++){//����epType�ǻ������̵����ͣ�ȡֵΪ0��1��2 
                  	if (i == <%=type%>) type[<%=type%>].checked = true; //ͨ��epTypeֵ��ѡ�ж�Ӧ��ť
                  	else type[i].disabled = true; //δѡ�а�ť�ûң�������ѡ�С�
                  }
                </script>
  		   </td>
  		</tr>
  		<tr>
  			<td width="10%">���㷽��</td>
  			<td >
  			    <select name="ufpMethod"  id ="ufpMethod" disabled="true">
  			 	    <!--0���� derived��1����default��2����range,3����value -->
  			 	    <option style="color:red" value="5">=��ѡ��=</option>
  					<option value="0" >�ֶ�����DET</option>
  					<option value="1">Ĭ�Ϲ��ܵ����</option>
  					<option value="2">ѡ��DET��Χ</option>
  					<option value="3">����DET����</option>
  					<option value="4">ѡ���Ӷ�</option>
  				</select>
  				<script language="JavaScript">
  					document.epForm.ufpMethod.value=<%=ufpMethod%>;
  				</script>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">�������������</td>
  			<td >
  			    <textarea name="epDesp"><%=desp%></textarea>
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
                  document.epForm.measureStatus.value="<%= measureStatus%>";   
                </script>
            </td>
  		</tr>
  		</table>
  		<input type="submit" name="submit" value=" �� �� "/>
    <input type='button' onclick="Javascript:window.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=<%=functionId%>&&epType=<%=epType%>'" value=" �� �� ">
  	<input type="hidden" name="id" value="<%=epId%>"/>
  	<input type="hidden" name="functionId" value="<%=functionId%>"/>
  	</form> 			
  </body>
</html>
