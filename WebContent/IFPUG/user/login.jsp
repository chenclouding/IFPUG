<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎光临IFPUG功能点估算工具</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(images/login_01.gif);
	overflow:hidden;
}
.STYLE3 {font-size: 12px; color: #FFFFFF; }
.STYLE4 {
	color: #FFFFFF;
	font-family: "方正大黑简体";
	font-size: 50px;
}
-->
</style>
  </head>
  
  <body>
    <form name="form1" method="post" action="/ifpug/IFPUG/login.do" >
       <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td background="/ifpug/IFPUG/user/images/login_03.gif">&nbsp;</td>
        <td width="876"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td height="299" valign="top" background="/ifpug/IFPUG/user/images/login_01.jpg">&nbsp;</td>
          </tr>
          <tr>
            <td height="54"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="394" height="69" background="/ifpug/IFPUG/user/images/login_02.jpg">&nbsp;</td>
                <td width="199" background="/ifpug/IFPUG/user/images/login_03.jpg"><table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="22%" height="22"><div align="center"><span class="STYLE3">用户名</span></div></td>
                    <td width="51%" height="22"><input name="textfield" type="text" size="12" style="height:20px;background-color:#032e49; color:#88b5d1; border:solid 1px #88b5d1;" /></td>
                    <td width="27%" height="22">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="22" valign="middle"><div align="center"><span class="STYLE3">密&nbsp; 码</span></div></td>
                    <td height="22" valign="bottom"><input name="textfield2" type="password" size="12" style="height:20px;background-color:#032e49; color:#88b5d1; border:solid 1px #88b5d1;" /></td>
                    <td height="22" valign="bottom">&nbsp;</td>
                  </tr>
                  <tr>
               
                    <td height="22" valign="middle">
                    <td height="22" valign="middle"><img src="/ifpug/IFPUG/user/images/dl.gif" width="39" height="17" /></td>
                  </tr>
                </table></td>
                <td width="283" background="/ifpug/IFPUG/user/images/login_04.jpg">&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="225" background="/ifpug/IFPUG/user/images/login_05.jpg">&nbsp;</td>
          </tr>
        </table></td>
        <td background="/ifpug/IFPUG/user/images/login_03.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
</table>
      </form>
   
  </body>
</html>
