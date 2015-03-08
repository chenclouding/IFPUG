<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="business.IFPUG.UserBusiness" %>
<%@ page import="hibernate.IFPUG.*" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>���Ӳ�Ʒ-��ʾ��Ʒ�б�</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
  	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
  	<script type="text/javascript" src="/ifpug/javascript/calenderJS.js"></script>
	<script language="JavaScript">  
	function expandIt(formId) {
		formObject =document.getElementById(formId)
		if (formObject.style.display == 'none') {
			formObject.style.display = '';
		}
		else {
			formObject.style.display = 'none';
		}
	}
	
    function verifyInput()
	{	
	 		var frm = document.productForm;  		    	   
			if(isEmpty(frm.productName.value)) 
			{	
			    alert("����д������ƣ�");
				frm.productName.focus();
				return false;
			}	
			
			if(isEmpty(frm.projectStartTime.value)) 
			{
				alert("����д��Ŀ��ʼʱ�䣡");
				frm.projectStartTime.focus();
				return false;
			}		
			if(isEmpty(frm.projectEndTime.value)) 
			{
				alert("����д��Ŀ����ʱ�䣡");
				frm.projectEndTime.focus();
				return false;
			}
			if(compareTime(frm.projectEndTime.value,frm.projectStartTime.value))
			{
				alert("��Ŀ����ʱ��Ӧ���ڿ�ʼʱ�䣡");
				frm.projectEndTime.focus();
				return false;
			}
			if(isEmpty(frm.estimateTime.value)) 
			{
				alert("����д���㿪ʼʱ�䣡");
				frm.estimateTime.focus();
				return false;
			}
			if (!isEmpty(frm.endTime.value)&&compareTime(frm.endTime.value,frm.estimateTime.value))
			{
				alert("�������ʱ��Ӧ���ڿ�ʼʱ�䣡");
				frm.endTime.focus();
				return false;
			}
	}
    function confirmdel(){
    	return confirm("ȷ��ɾ����");
    }
    </script> 
  </head>
  
  <body>
    <h1>��Ʒ�б�</h1>
    <table>
       <tr>
         <td>���</td> 
         <td>�������</td>
         <td>����״̬</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
         <td>��ӹ���</td>
       </tr>
       <%        
       String userName = (String)session.getAttribute("userName");
       /*�����ݿ��а���������Ĺ�����Ϣȡ��*/
       RequirementBusiness rb = new RequirementBusiness();
       //List productList = rb.getAllProduct(userName); 
       UserBusiness ub = new UserBusiness();
       IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
       Object[] productList = user.getIfpugProducts().toArray();
       
       IfpugProduct product = new IfpugProduct();//����ʵ��Bean
     
       int i = 1;
       /*���������Ϣ����ʾ��ӣ����������Ϣ���г���������б�*/
       if(productList==null ||productList.length==0 ){%>  
       <h1 style="color:red">Ŀǰ�޹��������Ϣ������Ӵ���������</h1>
       <%}else{ 
	       for(Object p:productList){ 
	         product = (IfpugProduct)p; 
	         Integer productId = product.getId();  
	         %>
	         <tr>
	          <td><%= i++%></td> 
	          <td><%= product.getProductName() %></td>
	          <td>
	          <%Short status = product.getMeasureStatus();
	         	String showstatus = null; 
	         	if(status==0)  showstatus="δ����";
	         	else if(status==1)  showstatus="���ֹ���";
	         	else if(status==2)  showstatus="�ѹ���";%>
	          	<%= showstatus%></td>
		         <td class = checkimg>
	              	  <a href="/ifpug/IFPUG/requirement/viewProduct.jsp?productId=<%=productId%>">
	              	  	<IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              	  </a>
	              </td>	
		          <td class = editimg>
		          	  <a href="/ifpug/IFPUG/requirement/editProduct.jsp?productId=<%=productId%>">
		          	  	<IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          	  </a>
		          </td>
		          <td class = delimg>
		              <a href="/ifpug/IFPUG/requirement/delProduct.jsp?productId=<%=productId%>" onclick="return confirmdel()">
		              	<img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		              </a>
		          </td>
		          <td>
		          	  <a href="/ifpug/IFPUG/requirement/functionList.jsp?productId=<%=productId%>">��ӹ���ģ��</a>
		          </td>
	         </tr>  
          <%}
       }%>  
    </table>
    
    <a onclick="expandIt('product'); return false" href="#"><h1>���Ӳ�Ʒ</h1></a>
    
    <form  action="/ifpug/IFPUG/addProduct.do" name="productForm" id ="product" method="post" style="display:none;" onsubmit="return verifyInput();">
  	<table>
  		<tr>
  			<td width="15%">�������������</td>
  			<td >
  			    <input type="text" name="productName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">�������������</td>
  			<td >
  			    <textarea name="productDesp"></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">�������</td>
  			<td >
  			 	<select name="productType" style="width:160px" >
  			 	    <!--0����MISϵͳ��1����webϵͳ  -->
  					<option value="0" selected>MIS</option>
  					<option value="1">Web</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">��Ŀ����</td>
  			<td >
  			 	<select name="developType" style="width:160px">
  			 	    <!--0����newDevelop��1������ο�����2������ǿ�� -->
  					<option value="0" selected>�¿���</option>
  					<option value="1">���ο���</option>
  					<option value="2">��ǿ��</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td>���㷽��</td>
  			<td width="40px">
  			 	<select name="measureMethod" style="width:160px">
  			 	    <!--0����COSMIC��׼����ֱ�ӹ��㣬1����USE-CASE�������㣬2����COSMIC���ƹ���  -->
  			 	    <option value="0" selected>IFPUG��׼����</option>
  					<option value="1">IFPUG���ƹ���</option>
  				</select>
            </td>
  		</tr>
  		<tr>
  			<td valign="top">������Ա</td>
  			<td valign="top">
  		   		<input type="text" name="estimator">
  		   	</td>
  		</tr>
  	    <tr>
  	    	<td valign="top">����״̬<br></td><td valign="top">
  		   		<input type="radio" checked="checked" value="0" name="measureStatus"/> δ����
  		   		<input type="radio" value="1" name="measureStatus"/> ���ֹ���
  		   		<input type="radio" value="2" name="measureStatus"/> �ѹ���
  		   </td>
  		 </tr>
  		 <tr>
  			<td>�������ڽ׶�</td>
  			<td >
  			 	<select name="lifecyclePhase" style="width:160px">
  			 	    <!--0�����������1������ϸ��ƺ�2���������ɺ�3�����Ʒ������  -->
  					<option value="0" selected>�������</option>
  					<option value="1">��ϸ��ƺ�</option>
  					<option value="2">������ɺ�</option>
  					<option value="3">��Ʒ������</option>
  				</select>
            </td>
  		</tr>
  	    <tr>
  			<td>������ʼʱ��</td>
  			<td>
           		<input type="text" name="projectStartTime" style="width:160px" onfocus="HS_setDate(this)"/>
            </td>
  		</tr>
  		<tr>
  			<td>��������ʱ��</td>
  			<td>
  				<input type="text" name="projectEndTime" style="width:160px" onfocus="HS_setDate(this)"/>
  			</td>
  	    </tr>
  		<tr>
  			<td>���㿪ʼʱ��</td>
  			<td>
  				<input type="text" name="estimateTime" style="width:160px" onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  		<tr>
  			<td>�������ʱ��</td>
  			<td>
              	<input type="text" name="endTime" style="width:160px" onfocus="HS_setDate(this)"/>
             	
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
  	</form> 			
  </body>
</html>
