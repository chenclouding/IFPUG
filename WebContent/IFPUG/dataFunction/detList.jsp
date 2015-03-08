<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%>
<%@ page import="hibernate.IFPUG.IfpugIlfDet"%>
<%@ page import="hibernate.IFPUG.IfpugEifDet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>����Ԫ���б�</title>
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
    	var frm = document.detForm; 
    	if(isEmpty(frm.detName.value)) 
		{
			alert("����д����Ԫ�ص����ƣ�");
			frm.detName.focus();
			return false;
		}
    }
	</script>
  </head>
  
  <body>
  <%
  	//��ȡ��addDet.jspҳ�洫������retId,type
  	Integer type = new Integer(request.getParameter("type"));
  	Integer retId = new Integer(request.getParameter("retId")); 
  	DataFunctionBusiness dfb = new DataFunctionBusiness();
  	Object[] detList = null;
  	IfpugIlfRet ilfRet = null;
  	IfpugEifRet eifRet = null;
	Integer dfId;
  	if(type == 0){//�����ILF��RET��DET
  		IfpugIlfRet iir = (IfpugIlfRet)dfb.queryIlfRetById(retId);//ͨ��retId���RET����
  		if(iir == null){ //���û���ҵ���retId�ļ�¼,˵����RETidΪ������Ĭ��RET
  			dfId = Integer.valueOf(retId.toString().substring(1));
  			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
  			Object[] retList = ilf.getIfpugIlfRets().toArray();//��ȡ��Ӧ���ݹ����ļ������е�RET
  			for (Object r:retList){//�ҵ������б�������Ϊdefault��RET
  				IfpugIlfRet ret = (IfpugIlfRet)r;
  				if(ret.getIlfRetName().equals("default"))  
  				{
  					ilfRet = ret; 
  					detList = ilfRet.getIfpugIlfDets().toArray();	
  					break;	
  				}
  			}	
  		}
  	    else{
  	    	detList = iir.getIfpugIlfDets().toArray();//���ݼ�����ϵ����ȡ��RET����������DET
  	    	dfId = iir.getIfpugIlf().getId();
  	    }  			
  	}
  	else {//�����EIF��RET��DET
  		IfpugEifRet ier = (IfpugEifRet)dfb.queryEifRetById(retId);
  		if(ier == null){//���û���ҵ���retId�ļ�¼,˵����RETidΪ������Ĭ��RET
  			dfId = Integer.valueOf(retId.toString().substring(1));
  			IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
  			Object[] retList = eif.getIfpugEifRets().toArray();//��ȡ��Ӧ���ݹ����ļ������е�RET
  			for (Object r:retList){//�ҵ������б�������Ϊdefault��RET
  				IfpugEifRet ret = (IfpugEifRet)r;
  				if(ret.getEifRetName().equals("default"))  
  				{
  					eifRet = ret; 
  					detList = eifRet.getIfpugEifDets().toArray();
  					break;	
  				}
  			}
  			
  		}
  		else {
  			detList = ier.getIfpugEifDets().toArray();//���ݼ�����ϵ����ȡ��RET����������DET 
  			dfId = ier.getIfpugEif().getId();
  		}
  	}
  	%>
  	 <h1> ����Ԫ���б�</h1>
      <table>
       <tr>
         <td>���</td> 
         <td>��������</td>
         <td>�����ļ�����</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
       </tr>
       <% 
       /*���޹�����Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if(detList == null||detList.length == 0){%>  
       <h1 style="color:red">Ŀǰ������Ԫ�أ������</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer detId; 
       		 String name;//������ʾ����Ԫ�ص�����
       		 String typeName;//�����ļ����͵�����ILF��EIF
       		 for(Object d:detList){
       		 	if(type == 0){//�����ILF��DET
       		 		IfpugIlfDet det = (IfpugIlfDet)d;
       		 		detId = det.getId();
       		 		name = det.getIlfDetName();
       		 		typeName = "ILF";
       		 	}
       		 	else {//�����EIF��DET
       		 		IfpugEifDet det = (IfpugEifDet)d;
       		 		detId = det.getId();
       		 		name = det.getEifDetName();
       		 		typeName = "EIF";
       		 		
       		 	}
	         %>
	         <tr>
	          <td><%= ++ i %></td> 
	          <td><%= name %></td>
	          <td><%= typeName %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewDet.jsp?detId=<%=detId%>&&type=<%=type%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editDet.jsp?detId=<%=detId%>&&type=<%=type%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delDet.jsp?detId=<%=detId%>&&type=<%=type%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		          </a>
		      </td>
	         </tr>  
          <%}
       }%>  
       </table>
  
    <h1>��������Ԫ��</h1>  
     <form  action="/ifpug/IFPUG/addDet.do" name="detForm" method="post" onSubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">��������</td>
  			<td >
  			    <input type="text" name="detName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">��������</td>
  			<td >
  			    <textarea name="detDesp"></textarea>
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
  	<script language="JavaScript">
  	function selectFrame(type,dfId){
  		if(window.name=="contentFrame"||window.name == "retFrame"){
  			window.location.href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>";
  		}  
  		else if(window.name == "detFrame"){
  			parent.location.href="/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&&dfId=<%=dfId%>";
  		}
  	}
  	</script>
  	<input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="retId" value="<%=retId%>"/>
  	</form> 	
  	
  	<form action="/ifpug/IFPUG/ufpCount_Derived.do">	
  		<table>
  			<tr>
  				<td width="10%">
  					<input type="submit" name="submit" value=" ������,���㹦�ܵ� "/>
  				</td>
  			</tr>
  		</table>
  		<input type="hidden" name="type" value="<%=type%>"/>
    	<input type="hidden" name="dfId" value="<%=dfId%>"/>
    	<input type="hidden" name="retId" value="<%=retId%>"/>
  	</form>	
  	 <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/retList.jsp?type=<%=type%>&dfId=<%=dfId%>'"> ���ؼ�¼Ԫ���б�</a>	
  </body>
</html>

