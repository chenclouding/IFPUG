<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.DataFunctionBusiness" %>
<%@ page import="hibernate.IFPUG.IfpugEif"%> 
<%@ page import="hibernate.IFPUG.IfpugIlf"%> 
<%@ page import="hibernate.IFPUG.IfpugIlfRet"%>
<%@ page import="hibernate.IFPUG.IfpugEifRet"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��Ӽ�¼Ԫ��</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="/ifpug/images/screen.css">
	<script language="JavaScript" src="/ifpug/javascript/verify.js"></script>
	<script language="javascript">
		function ufpCountDisplay(){
	  if (http_request.readyState == 4) {
            if (http_request.status == 200) {
               var ufpCount = http_request.responseText;
               OutPut.innerText = ufpCount;
            }
      }
	}
    function ufpCountHttpRequest(fileId,fileType){
       var http_request = creatHttpRequest();
       http_request.onreadystatechange = ufpCountDisplay;
       http_request.open('GET', "/ifpug/servlet/UfpCount?fileId="+fileId+"&&fileType="+fileType, true);
       http_request.send(null);     
    } 
    function creatHttpRequest(){
        if (window.XMLHttpRequest) { // Mozilla, Safari,...
            http_request = new XMLHttpRequest();
            if (http_request.overrideMimeType) {
                http_request.overrideMimeType('text/xml');
            }
        } else if (window.ActiveXObject) { // IE
            try {
                http_request = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    http_request = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {}
            }       
        }
        if (!http_request) {
            alert('Giving up :( Cannot create an XMLHTTP instance');
            return false;
        }
       return http_request;
      }

    function countfp(){
      
    }
	function verifyInput()
	{	
		var frm = document.retForm;
	 	if(isEmpty(frm.retName.value)) //���DET������ֵΪ�գ���������Ϊ�յ���ʾ��Ϣ
		{
			alert("��¼Ԫ�����Ʋ���Ϊ�գ�");
			frm.retName.focus();
			return false;
		}	
		else if(frm.retName.value == "default")
		{
			alert("��¼Ԫ�����Ʋ���Ϊdefault!");
			frm.retName.focus();
			return false;
		}		
	}
    function confirmdel(){
    	return confirm("ȷ��ɾ����");
    }
     </script>
  </head>
  
  <body>
  <%
  		DataFunctionBusiness dfb = new DataFunctionBusiness();
  		Integer type = new Integer(request.getParameter("type"));//��dataFunction.jspҳ���ȡ�ļ�����(0\1)
  		Integer dfId = new Integer(request.getParameter("dfId"));//��dataFunction.jspҳ���ȡ�ļ�ID
  		Integer productId = null;
  		Object[] retList = null;  		
  		if(type == 0){//�г���Ӧ�ļ������е�RET
  			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);
  			productId = ilf.getIfpugProduct().getId();
  			retList = ilf.getIfpugIlfRets().toArray();
  		}
  		else {
  			IfpugEif eif = (IfpugEif)dfb.queryEifById(dfId);
  		    productId = eif.getIfpugProduct().getId();
  			retList = eif.getIfpugEifRets().toArray();
  		}
   %>
    
  
  
   <h1>��¼Ԫ���б�</h1>
    <table>
       <tr>
         <td>���</td> 
         <td>��¼Ԫ����</td>
         <td>�鿴</td>
         <td>�޸�</td>
         <td>ɾ��</td>
         <td>�������Ԫ��</td>
       </tr>
       <% 
      
  		IfpugIlfRet ilfRet = null;
  		IfpugEifRet eifRet = null;
        String name = null;
       /*���޹�����Ϣ����ʾ��ӣ����й�����Ϣ���г����㹦���б�*/
       if(retList == null||retList.length == 0){%>  
       <h1 style="color:red">Ŀǰ�޼�¼Ԫ�أ������</h1>
       <%}else{ 
       		 Integer i = 0;
       		 Integer id;
             for(Object r:retList)
             {
             	if(type == 0){//�����ILF�ļ���RETԪ��
             		ilfRet = (IfpugIlfRet)r;
             		name = ilfRet.getIlfRetName();
             		id = ilfRet.getId();
             	}
             	else {//�����EIF�ļ���RETԪ��
             		eifRet = (IfpugEifRet)r;
             		name = eifRet.getEifRetName();
             		id = eifRet.getId();
             	}
	          %>
	         <tr>
	          <td><%= ++i %></td> 
	          <td><%= name %></td>
	          <td class = checkimg>
	          	  <a href="/ifpug/IFPUG/dataFunction/viewRet.jsp?retId=<%=id%>&&type=<%=type%>">
	              	  <IMG src="/ifpug/images/btncheck.gif" alt="����鿴" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/ifpug/IFPUG/dataFunction/editRet.jsp?retId=<%=id%>&&type=<%=type%>">
		          	 <IMG src="/ifpug/images/btnedit.gif" alt="����޸�" border="0" />
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/ifpug/IFPUG/dataFunction/delRet.jsp?retId=<%=id%>&&type=<%=type%>" onclick="return confirmdel()">
		             <img src="/ifpug/images/btndel.gif" alt="���ɾ��" width="15" height="12" border="0" />
		          </a>
		      </td>
		      <td><a href="/ifpug/IFPUG/dataFunction/detList.jsp?retId=<%=id%>&&type=<%=type%>" >�������Ԫ��</a></td>
	         </tr>  
          <%}
       }%>  
    </table>
  
  
    <h1>������¼Ԫ��</h1>  
     <form  name="retForm" action="/ifpug/IFPUG/addRet.do" onsubmit="return verifyInput();">
  	 <table>
  		<tr>
  			<td width="15%">��¼����</td>
  			<td >
  			    <input type="text" name="retName" style="width:160px" value=""/ >
            </td>
  		</tr>
  		<tr>
  			<td width="10%">��¼����</td>
  			<td >
  			    <textarea name="retDesp"></textarea>
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
    <input type="hidden" name="type" value="<%=type%>"/>
    <input type="hidden" name="dfId" value="<%=dfId%>"/>
    <input type="hidden" name="id" value="<%=dfId%>"/>   
    
 <%-- <h1>���ܵ����</h1>  
  <table>
    <tr>
      <td style="font-size:12">Ŀǰ���ܵ����:   <input id="OutPut"/> </td> 
    </tr>
    <tr>
      <td><button onclick="ufpCountHttpRequest(<%=dfId%>,<%=type%>)">���¼���</button> </td> 
    </tr>  
   </table> --%> 
     <a href ="Javascript:window.location='/ifpug/IFPUG/dataFunction/dataFunctionList.jsp?productId=<%=productId %>'"> �������ݹ����б�</a>
  	</form> 			
  </body>
</html>
