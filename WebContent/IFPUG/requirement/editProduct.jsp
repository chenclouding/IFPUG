<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.RequirementBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugProduct" %>
<%@ page import="hibernate.IFPUG.IfpugFunction" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>�༭��Ʒ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
    <script type="text/javascript" src="/ifpug/javascript/calenderJS.js"></script>
	<script language="JavaScript">  
    function verifyInput(editEstimate)
	{	
	 		var frm = document.productForm;  		    	   
			if(isEmpty(frm.productName.value)) 
			{	
			    alert("����д������ƣ�");
				frm.productName.focus();
				return false;
			}	
			//�жϹ���״̬�Ƿ��ܹ��޸�
			if (!isEmpty(frm.measureStatus.value))
			{   
				switch(frm.measureStatus.value)
				{   
					case '0': //�ɷ��޸�Ϊδ����״̬
					{
						if (editEstimate != 0){
							alert("�˹���״̬�����޸�Ϊδ���㣡"); 
							frm.measureStatus.focus();
							return false;	
						}
						break;
						
					}
					case '1': //�ɷ��޸�Ϊ���ֹ���״̬
					{
						if (editEstimate != 1){
							alert("�˹���״̬�����޸�Ϊ���ֹ��㣡");
							return false;
						}
						 break;
					}
					case '2': //�ɷ��޸�Ϊ�ѹ���״̬
					{
						if (editEstimate != 2){
							alert("�˹���״̬�����޸�Ϊ�ѹ��㣡");
							return false; 
						}
						break;
					}
				   default : alert("error!"); break;
				}
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
    </script> 
  </head>
  
  <body>
      <%
       /*��ȡ��ҳ��productList.jsp����productId*/
      Integer productId = new Integer(request.getParameter("productId"));
      
      /*�����ݿ��а�idΪproductId��������ȡ��*/
      RequirementBusiness rb = new RequirementBusiness(); //ҵ��㣬��Ӧ��IFPUG�����Ĳ��Խ׶�
      IfpugProduct  fp = (IfpugProduct)rb.getProductById(productId); 
      
      /*�жϹ���״̬�ܷ��Ϊδ����*/
      Integer editEstimate = rb.editProductEstimateCheck(productId);
      %>
      
  <form  action="/ifpug/IFPUG/editProduct.do" name="productForm" method="post" onSubmit="return verifyInput(<%=editEstimate%>);">
      <table>
  		<tr>
  			<td width="15%">�������������</td>
  			<td >
  			    <input type="text" name="productName" style="width:160px" value="<%=fp.getProductName()%>"/>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">�������������</td>
  			<td >
  			    <textarea name="productDesp" style="width:360px"><%=fp.getProductDesp()%></textarea>
            </td>
  		</tr>
  	
  		<tr>
  			<td width="15%">�������</td>
  			<td >
  			 	<select name="productType" style="width:160px" >
  			 	    <!--0����MISϵͳ��1����webϵͳ  -->
  					<option value="0">MIS</option>
  					<option value="1">Web</option>
  				</select>
  				<script language="javascript">   
  				 
                  document.productForm.productType.value="<%=fp.getProductType()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td width="10%">��Ŀ����</td>
  			<td >
  			 	<select name="developType" style="width:160px">
  			 	    <!--0����newDevelop��1������ο�����2������ǿ�� -->
  					<option value="0">�¿���</option>
  					<option value="1">���ο���</option>
  					<option value="2">��ǿ��</option>
  				</select>
  				<script language="javascript">   
                  document.productForm.developType.value="<%= fp.getDevelopType()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>���㷽��</td>
  			<td width="40px">
  			 	<select name="measureMethod" style="width:160px">
  			 	    <!--0����COSMIC��׼����ֱ�ӹ��㣬1����USE-CASE�������㣬2����COSMIC���ƹ���  -->
  			 	    <option value="0">COSMIC��׼����ֱ�ӹ���</option>
  					<option value="1">USE-CASE��������</option>
  					<option value="2">COSMIC���ƹ���</option>
  				</select>
  				<script language="javascript">   
                  document.productForm.measureMethod.value="<%=fp.getMeasureMethod()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>����ԭ��</td>
  			<td>
  		   		<input type="text" name="estimator" style="width:160px" value="<%= fp.getEstimator()%>"/>
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
                  document.productForm.measureStatus.value="<%= fp.getMeasureStatus()%>";   
                </script>
            </td>
  		</tr>
  		<tr>
  			<td>�������ڽ׶�</td>
  			<td >
  				<select name="lifecyclePhase" style="width:160px">
  			 	    <!--0�����������1������ϸ��ƺ�2���������ɺ�3�����Ʒ������  -->
  					<option value="0">�������</option>
  					<option value="1">��ϸ��ƺ�</option>
  					<option value="2">������ɺ�</option>
  					<option value="3">��Ʒ������</option>
  				</select>
  			    <script language="javascript">   
                  document.productForm.lifecyclePhase.value="<%=fp.getLifecyclePhase()%>";   
                </script>
            </td>
  		</tr>
  	    <tr>
  	    	<td>������ʼʱ��</td>
  	    	<td >
  	    		<input type="text" name="projectStartTime" style="width:160px" value='<%=fp.getTime(fp.getProjectStartTime()) %>' onfocus="HS_setDate(this)"/>
            </td>
  		</tr>
  		<tr>
  			<td>��������ʱ��</td>
  			<td>
  				<input type="text" name="projectEndTime" style="width:160px" value='<%=fp.getTime(fp.getProjectEndTime())%>' onfocus="HS_setDate(this)"/>
  				</td>
  		</tr>
  		<tr>
  			<td>���㿪ʼʱ��</td>
  			<td>
  				<input type="text" name="estimateTime" style="width:160px" value='<%=fp.getTime(fp.getEstimateTime())%>' onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  		<tr>
  			<td>�������ʱ��</td>
  			<% //��Ϊ�������ʱ������Ϊ�գ�����Ҫ�������ж�
  			   Date endTime = fp.getEndTime();
  			   String time = null;
  			   if (endTime == null) time = "";
  			   else  time = fp.getTime(endTime); 
  			 %>
  			<td>
  				<input type="text" name="endTime" style="width:160px" value='<%=time%>' onfocus="HS_setDate(this)"/>
  			</td>
  		</tr>
  	</table>
  	    <input type="submit" name="submit" value=" �� �� "/>
  		<input type='button' onclick="Javascript:window.location='/ifpug/IFPUG/requirement/productList.jsp'" value=" �� �� ">
  		<input type="hidden" name="id" value="<%=productId%>"/>
	</form>
  </body>
</html>
