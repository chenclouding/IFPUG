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
    
    <title>UFP����---�û�ѡ��ֵ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="JavaScript">  
	 function verifyInput()
	{	
		var frm = document.methodForm;
	 	if(isEmpty(frm.value_det.value)) //���DET������ֵΪ�գ���������Ϊ�յ���ʾ��Ϣ
		{
			alert("����Ԫ�ظ�������Ϊ�գ�");
			frm.value_det.focus();
			return false;
		}	
		else { //����ǿգ���֤�û��������Ϣ�Ƿ�Ϊ����
			if(checkNumber(frm.value_det.value)){
				alert("����Ԫ�ظ�������Ϊ���֣�");
				frm.value_det.focus();
				return false;
			}
		}
		if(isEmpty(frm.value_ret.value)) //���RET������ֵΪ�գ���������Ϊ�յ���ʾ��Ϣ
		{
			alert("��¼Ԫ�ظ�������Ϊ�գ�");
			frm.value_ret.focus();
			return false;
		}	
		else { //����ǿգ���֤�û��������Ϣ�Ƿ�Ϊ����
			if(checkNumber(frm.value_ret.value)){
				alert("��¼Ԫ�ظ�������Ϊ���֣�");
				frm.value_ret.focus();
				return false;
			}
		}
	}
	
	function checkNumber(String) //�ж������Ƿ�Ϊ����
	{ 
		var Letters = "1234567890"; 
		var i; 
		var c; 
		for( i = 0; i < String.length; i ++ ) 
		{ 
			c = String.charAt( i ); 
			if (Letters.indexOf( c ) ==-1) 
			{ 
				return true; 
			} 
		} 
		return false; 
	}
	</script>

  </head>
  
  <body>
    <%
  	Integer ufpMethod= new Integer(request.getParameter("ufpMethod"));
  	Integer type=  new Integer(request.getParameter("type"));
  	Integer dfId = new Integer(request.getParameter("dfId"));
   %>
   <form name="methodForm" id ="methodForm" method="post" action="/ifpug/IFPUG/ufpCount.do"  target="_parent" onsubmit="return verifyInput();">
  		<table>
  			<tr>
  				<td width="10%">DET����ֵ</td>
  				<td >
  			    	<input type="text" name="value_det" style="width:160px"/>
            	</td>
  			</tr>
  			<tr>
  				<td width="10%">RET����ֵ</td>
  				<td >
  			    	<input type="text" name="value_ret" style="width:160px"/>
            	</td>
  			</tr>
  		</table>
  		<input type="submit" name="submit" value="��ʼ����"/>
  		<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>"/>
    	<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="dfId" value="<%=dfId%>"/>
    </form>   
    <%	Integer ufpCount, productId;
    	DataFunctionBusiness dfb = new 	DataFunctionBusiness();
    	if(type == 0){
    	    IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
    	    ufpCount = ilf.getUfpCount();
    	    productId = ilf.getIfpugProduct().getId();
    	}
    	else {
    		IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
    	    ufpCount = eif.getUfpCount();
    	    productId = eif.getIfpugProduct().getId();
    	}
    %>
    
    <table>
    	<tr id="ufpCount"  >
  			<td width="10%">���ܵ����</td>
  			<td ><%=ufpCount %></td>
  		</tr>
    </table> 
    <a href ="Javascript:parent.location='/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId%>'"> �������ݹ����б�</a>
  </body>
</html>
