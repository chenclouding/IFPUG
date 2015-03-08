<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.MeasureReport" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%@ page import="hibernate.IFPUG.IfpugIlf" %>
<%@ page import="hibernate.IFPUG.IfpugEif" %>
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
    
    <title>�������ܵ����</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="javascript">
	function countFp(c,productId)
	{
		var e1 = parseFloat(document.getElementById("e1").value);
		var e2 = parseFloat(document.getElementById("e2").value);
		var e3 = parseFloat(document.getElementById("e3").value);
		var e4 = parseFloat(document.getElementById("e4").value);
		var e5 = parseFloat(document.getElementById("e5").value);
		var e6 = parseFloat(document.getElementById("e6").value);
		var e7 = parseFloat(document.getElementById("e7").value);
		var e8 = parseFloat(document.getElementById("e8").value);
		var e9 = parseFloat(document.getElementById("e9").value);
		var ea = parseFloat(document.getElementById("e10").value);
		var eb = parseFloat(document.getElementById("e11").value);
		var ec = parseFloat(document.getElementById("e12").value);
		var ed = parseFloat(document.getElementById("e13").value);
		var ee = parseFloat(document.getElementById("e14").value);
		var s = e1+e2+e3+e4+e5+e6+e7+e8+e9+ea+eb+ec+ed+ee;
		var vaf = parseInt((0.01 * s+0.65)*100)/100;
		
		if(document.getElementById('fptd').display='')  document.getElementById('fptd').display= 'none';
		else document.getElementById('fptd').display = '';
		window.location="/ifpug/IFPUG/saveFpc.jsp?tcf="+vaf+"&fpc="+vaf*c+"&productId="+productId;
	
	}
	</script>
  </head>
  
  <body>
  <%
   String tcf = request.getParameter("tcf");
   String fpc = request.getParameter("fpc");
   if(tcf == null) tcf ="0";
   if(fpc == null) fpc ="0";
   Integer productId = new Integer(request.getParameter("productId"));
   RequirementBusiness rb = new RequirementBusiness();
   IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
   Object[] ilfList = product.getIfpugIlfs().toArray();
   Object[] eifList = product.getIfpugEifs().toArray();
   Object[] functionList = product.getIfpugFunctions().toArray();
   
   Integer dfp = 0, tfp = 0, ufpc = 0;
   if(ilfList != null && ilfList.length != 0)
   {
   		for(Object i:ilfList)
   		{
   			IfpugIlf ilf = (IfpugIlf)i;
   			dfp += ilf.getUfpCount();
   		}
   }
   if(eifList != null && eifList.length != 0)
   {
   		for(Object e:eifList)
   		{
   			IfpugEif eif = (IfpugEif)e;
   			dfp += eif.getUfpCount();
   		}
   }
   
   MeasureReport mr = new MeasureReport();
   if(functionList != null&&functionList.length != 0)
   {
   		for (Object f:functionList)
   		{
   			mr.getEpFromFunction(f);
   		}
   }
   List eiList = mr.eiList;
   List eoList = mr.eoList;
   List eqList = mr.eqList;
   
   if(eiList!=null&&eiList.size()!=0)
   {
   		for(Object o:eiList)
   		{
   			IfpugEi ei = (IfpugEi)o;
   			tfp += ei.getUfpCount();
   		}
   } 
   if(eoList!=null&&eoList.size()!=0)
   {
   		for(Object o:eoList)
   		{
   			IfpugEo eo = (IfpugEo)o;
   			tfp += eo.getUfpCount();
   		}
   } 
   if(eqList!=null&&eqList.size()!=0)
   {
   		for(Object o:eqList)
   		{
   			IfpugEq eq = (IfpugEq)o;
   			tfp += eq.getUfpCount();
   		}
   } 
   
   ufpc = dfp + tfp;
   %>
     <h1>��������(�������Ӷ�����)</h1>  
     <span>(�������ӶȲ�����ȡֵ��Χ��0��5����ʾ����Թ��ܵ�������Ӱ���û�е����ߡ�)</span>
     <form  name="vafForm">
     <table  style="width:720px">
     <tr><td style="width:350px">
  	 <table>
  		<tr>
  			<td width="40%">����ͨѶ</td>
  			<td >
  			    <select name="e1" id="e1" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">�������</td>
  			<td >
  			    <select name="e2" id="e2" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">��������</td>
  			<td >
  			    <select name="e3" id="e3"style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">����Ч��</td>
  			<td >
  			    <select name="e4" id="e4" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">ʵʱ��������</td>
  			<td >
  			    <select name="e5" id="e5" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">�û����渴�Ӷ�</td>
  			<td >
  			    <select name="e6" id="e6" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">��������</td>
  			<td >
  			    <select name="e7" id="e7" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">��������</td>
  			<td >
  			    <select name="e8" id="e8" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">���븴����</td>
  			<td >
  			    <select name="e9" id="e9" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="40%">��װ������</td>
  			<td >
  			    <select name="e10" id="e10" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  			<tr>
  			<td width="40%">����������</td>
  			<td >
  			    <select name="e11" id="e11" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  			<tr>
  			<td width="40%">��ƽ̨Ҫ��</td>
  			<td >
  			    <select name="e12" id="e12" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  			<tr>
  			<td width="40%">����չ��</td>
  			<td >
  			    <select name="e13" id="e13" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>
  			<tr>
  			<td width="40%">�ֲ�ʽ���ݴ���</td>
  			<td >
  			    <select name="e14" id="e14" style="width:80px">
  					<option value="0" selected>0</option>
  					<option value="1">1</option>
  					<option value="2">2</option>
  					<option value="3">3</option>
  					<option value="4">4</option>
  					<option value="5">5</option>
  				</select>
            </td>
  		</tr>  		
  		<tr>
  		    <td>
  				<input type="button" name="submit" value=" ȷ  �� " onclick="return countFp(<%=ufpc%>,<%=productId %>);"/>
  			</td>
  		</tr>
  	</table>
    </td>
    <td id="fptd" style="width:400px" valign="top">
    <h1>�������ӵ���</h1>
  	<table>
  		<tr>
  			<td width="35%">���ݹ��ܵ����</td>
  			<td> 
  				<%=dfp %>
  			 </td>
  		</tr>
  		<tr>
  			<td width="35%">�����ܵ����</td>
  			<td>
  				<%=tfp %>		    
            </td>
  		</tr>
  		<tr>
  			<td width="35%">δ�������ܵ����</td>
  			<td >
  			   <%= ufpc %>
            </td>
  		</tr>
  		<tr>
  			<td width="35%">�������Ӷ�����</td>
  			<td >
  			   <%=tcf %>
            </td>
  		</tr>
  		<tr>
  			<td width="35%">�������ܵ����</td>
  			<td >
  			   <%= fpc %>
            </td>
  		</tr>
  	</table>
  	</td>
  	</tr>
  	</table>
  	<input type="hidden" name="productId" value="<%=productId%>"/>
  	</form> 	
  </body>
</html>
