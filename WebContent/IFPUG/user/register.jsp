 <%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%> 
<%@ page contentType="text/html; charset=gb2312" language="java" %>
<HTML>
<HEAD>
<TITLE>IFPUG���ܵ���㹤��--ע��</TITLE>
<!--CharSet-->
<META HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=gb2312">
<link rel="stylesheet" href="/ifpug/images/CSS.CSS" type="text/css">
<style type="text/css">
<!--
.style1 {color: #006600}
.style2 {font-size: 16px}
.style3 {color: #CC3300}
.style4 {
	font-family: "��������";
	font-size: 24px;
	color: #FF0000;
}
.style6 {
	font-size: 36px;
	font-family: "��������";
}
.style8 {font-size: 24px; font-family: "��������";}
-->
</style>
<script language="JavaScript" src="javascript/verify.js"></script>
<script language="JavaScript">
function verifyInput(){
	if(registerForm.username.value==null||registerForm.username.value==""){
		alert("�������û�����");
		registerForm.username.focus();
		return false;
	}else if(registerForm.password.value==null||registerForm.password.value==""){
		registerForm.password.focus();
		alert("���������룡");
		return false;
	}else if(registerForm.repassword.value==null||registerForm.repassword.value==""){
		registerForm.repassword.focus();
		alert("���ٴ���������ȷ�ϣ�");
		return false;
	}else if(registerForm.password.value!=registerForm.repassword2.value){
		registerForm.repassword.focus();
		alert("�����������һ�£�");
		return false;
	}else{
	    registerForm.submit();
    }
}

</script>
</HEAD>
<BODY background="/ifpug/images/bline.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload=document.form1.userName.focus()>
<!--Counter-->
<!--Something Here-->
<table width="778" border="0" cellspacing="0" cellpadding="0" align="center" height="130">
  <tr>
    <td background="/ifpug/images/index_topPP_ifpug.png" valign="top">
     
    </td>
  </tr>
</table>
<table width="778" border="0" cellspacing="0" cellpadding="0" align="center" background="/ifpug/images/index_bg.gif">
  <tr>
    <td valign="top" width="215" rowspan="2">
      <table width="215" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>
            <table width="215" border="0" cellspacing="0" cellpadding="0" height="20" background="/ifpug/images/01.gif">
              <tr>
                <td> <img src="/ifpug/images/index_pic.gif" width="215" height="155"></td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td>
            <table width="215" border="0" cellspacing="0" cellpadding="0" height="15">
              <tr>
                <td>
                  <div align="center">
<!--Language-->
<!--Something Here-->
</div>
                </td>
              </tr>
            </table>
            <table width="215" border="0" cellspacing="0" cellpadding="0" height="40" background="/ifpug/images/index_lm.gif">
              <tr>
                <td> <div align="center"><b><a href="/ifpug/index.jsp">�� ҳ</a></b> </div></td>
              </tr>
            </table>



<!--Button10.Content.Begin-->
            <table width="215" border="0" cellspacing="0" cellpadding="0" height="40" background="/ifpug/images/index_lm.gif">
              <tr>
                <td>
                  <div align="center"><b>
<!--Button10.Link-->
<a href="/ifpug/index.jsp">
<!--Button10-->
�˳�ϵͳ
</a></b></div>
                </td>
              </tr>
            </table>
<!--Button10.Content.End-->


          </td>
        </tr>
      </table>
    </td>
    <td valign="top" width="563"><img src="/ifpug/images/index_top2.gif" width="563" height="70"></td>
  </tr>
  <tr>
    <td valign="top">
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
     
        <tr>
          <td>
           <!--IndexPage.Content.Begin-->
            <table width="90%" border="0" cellspacing="0" cellpadding="0" align="center">
            <tr>
              <td>
                  <div align="left" class="style2 style3">
                     <p class="style2 style4">��ӭע���½��</p>
                    </div> 
              </td>
             </tr>
             <tr>
                <td bgcolor="#000000"><img src="/ifpug/images/Spacer.gif" width="1" height="1"></td>
             </tr>
             <tr>
                <td height="128">
<!--Page.Content.Begin-->
<!--Something Here-->
<form action="/ifpug/IFPUG/register.do" name="registerForm" method="post" onSubmit="return verifyInput();">
	<table style="width:300px">
		<tr>
			<td width="100px">�û���:</td><td><input type="text" name="username" ></td>
		</tr>
		<tr>
			<td>���룺</td><td><input type="password" name="password"></td>
		</tr>
		<tr>
			<td>ȷ���������룺</td><td><input type="password" name="repassword"></td>
		</tr>
	</table>
  <input type="submit" name="submit" value="ע ��" /> 
  <input type='button' onclick="Javascript:window.location='/ifpug/index.jsp'" value="ȡ ��"> 
</form>
<p>&nbsp; </p>

<!--Page.Content.End-->
       </td>
          </tr>
</table>
<!--IndexPage.Content.End-->


            <table width="90%" border="0" cellspacing="0" cellpadding="0" align="center" height="1">
              <tr>
                <td bgcolor="#000000"> </td>
              </tr>
            </table>
            <table width="90%" border="0" cellspacing="0" cellpadding="4" align="center">
              <tr>
                <td>
                  <p align="center">
<!--Your Company Name-->
���������
<!--TCopyRight-->
 ��Ȩ���� @2005<br>
<!--TAddress-->
��˾��ַ:�����к�����ѧԺ·37��
<!--Address-->
<br>
<!--TTelephone-->
�绰:010��82316288
<!--Telephone-->
<br>
<!--TEMail-->

<!--EMail-->

<!--Email-->
</p>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<table width="778" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td><img src="/ifpug/images/index_bottom.gif" width="778" height="50"></td>
  </tr>
</table>
</BODY>

 </HTML>
