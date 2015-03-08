<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct"%> 
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
    
    <title>����ڲ��߼��ļ�</title>
    
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
    	var frm = document.dfForm; 
    	if(isEmpty(frm.name.value)) 
		{
			alert("����д���ݹ��ܵ����ƣ�");
			frm.name.focus();
			return false;
		}
    }
    </script>

  </head>
  
  <body>
  <%
  	Integer productId = new Integer(request.getParameter("productId"));
  	RequirementBusiness rb = new RequirementBusiness();
    IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
   %>
    <h1> <%= product.getProductName()%>��Ʒ�����ݹ����б�</h1>
    <table>
       <tr>
         <td>���</td> 
         <td>�ļ���</td>
         <td>���ܵ����</td>
         <td>����</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
         <td>��Ӽ�¼Ԫ��</td>
       </tr>
       <% 
       /*�ֱ���ȡ������ILF\EIF*/
       Object[] ilfList = product.getIfpugIlfs().toArray(); //��ȡ����ILF�б�
       Object[] eifList = product.getIfpugEifs().toArray(); //��ȡ����EIF�б�
       Integer length = ilfList.length;
 	   int k = 0;
       List list = new ArrayList(length+eifList.length);
       if(ilfList != null && ilfList.length != 0)
       {
    		for(Object ilf:ilfList)
    			list.add(ilf);
       }
       if(eifList != null && eifList.length != 0)
       {
       		for (Object eif:eifList)
       			list.add(eif);
       }
       IfpugIlf ii = null; 
       IfpugEif ie = null;
       /*���޹�����Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if((ilfList == null||ilfList.length == 0)&&(eifList == null||eifList.length == 0)){%>  
       <h1 style="color:red">Ŀǰ��ILF\EIF�ļ�������������ļ�</h1>
       <%}else{ 
             Integer i = 0, id = 0;
             String name = null;
             Integer ufpCount = 0;
             String type = null;
             Short  ufpMethod;
             Integer typeId;
             
              for(Object e:list)
              {
             	if(i < length){
             	    ii =  (IfpugIlf)e;
             		name = ii.getIlfName();
             		type = "ILF";
             		typeId = 0;
             		ufpCount = ii.getUfpCount();
             		ufpMethod = ii.getUfpMethod();
             		id = ii.getId();
             	}
             	else {
              		ie =  (IfpugEif)e;
             		name = ie.getEifName();
             		type = "EIF";
             		typeId = 1;
             		ufpCount = ie.getUfpCount();
             		ufpMethod = ie.getUfpMethod();
             		id = ie.getId();
             	}
             	/*�¶����ڱ�����������ѡ��ͬ������*/
             	/*����ǡ��ֶ���ӡ�����ת����Ӽ�¼Ԫ��ҳ��retList.jsp*/
             	/*�����������������ת��directMethod.jspҳ��*/
             	String linkAddr = null;
             	String linkName = null;
             	if(ufpMethod == 0){
             		linkAddr = "/ifpug/IFPUG/dataFunction/retList.jsp?ufpMethod=";
             		linkName = "�ֶ�����RET";
             	}
             	else {
             		linkAddr = "/ifpug/IFPUG/dataFunction/directMethod.jsp?ufpMethod=";
             		linkName = "����RET����";
             	}
             
	          %>
	         <tr>
	          <td><%= ++i %></td> 
	          <td><%= name %></td>
	          <td><%= ufpCount %></td>
	          <td><%= type %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delDataFunction.jsp?dfId=<%=id%>&&type=<%=typeId%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		          </a>
		      </td>
		      <td><a href="<%=linkAddr%><%=ufpMethod%>&&type=<%=typeId%>&&dfId=<%=id%>"><%=linkName%></a></td>
	         </tr>  
          <%}
       }%>  
    </table>
    
    
    <form  action="/ifpug/IFPUG/addDataFunction.do" name="dfForm" method="post" onSubmit="return verifyInput();">
  	<table>
  		<tr>
  			<td width="15%">�����ļ���</td>
  			<td >
  			    <input type="text" name="name" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">�����ļ�����</td>
  			<td >
  			    <textarea name="desp"></textarea>
            </td>
  		</tr>
  		<tr>
  	    	<td width="15%">�����ļ�����</td>
  	    	<td>
  	    		 <!--0����ILF��1����EIF  -->
  		   		<input type="radio" checked="checked" value="0" name="type">ILF
  		   		<input type="radio" value="1" name="type">EIF
  		   </td>
  		<tr>
  			<td width="10%">��������</td>
  			<td >
  			 	<select name="ufpMethod" style="width:160px">
  			 	    <!--0���� derived��1����default��2����range,3����value -->
  					<option value="0" selected>�ֶ�����DET</option>
  					<option value="1">Ĭ�Ϲ��ܵ����</option>
  					<option value="2">ѡ��DET��Χ</option>
  					<option value="3">����DET����</option>
  					<option value="4">ѡ���Ӷ�</option>
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
  	 <input type="hidden" name="productId" value="<%=productId%>"/>
  	</form> 
  	 <input type="hidden" name="productId" value="<%=productId%>"/>			
  </body>
</html>
