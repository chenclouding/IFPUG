<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ page import="java.util.*"%>

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<HTML>
	<HEAD>

		<SCRIPT type="text/javascript">
function switchSysBar(){
expireDate=new Date;
expireDate.setYear(expireDate.getYear()+1);
if (document.all("switchPoint").innerText==3){
document.all("switchPoint").innerText=4;
document.cookie="switchPoint="+"4"+";expires="+expireDate.toGMTString()+";";
document.all("frmTitle").style.display="none";
}else{
document.all("switchPoint").innerText=3;
document.cookie="switchPoint="+"3"+";expires="+expireDate.toGMTString()+";";
document.all("frmTitle").style.display="";
}}
</SCRIPT>
		<SCRIPT type="text/javascript" language="javascript" charset=gb2312 src="/ifpug/javascript/navigator.js"></SCRIPT>
		<title></title>
		<STYLE type=text/css>
.navPoint {COLOR: 5E95C3; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt}
</STYLE>
		<style type="text/css">
#dropmenudiv{
position:absolute;
border:1px solid black;
border-bottom-width: 0;
font:normal 12px Verdana;
line-height:18px;
z-index:100;
}

#dropmenudiv a{
width: 100%;
display: block;
text-indent: 3px;
border-bottom: 1px solid black;
padding: 1px 0;
text-decoration: none;
 
}

#dropmenudiv a:hover{ /*hover background color*/
background-color: yellow;
}

</style>
		<link href="/ifpug/images/css0.css" rel="stylesheet" type="text/css">		
	</head>
	
	
	
	<BODY scroll='no' style="MARGIN: 0px">
	<%
				String userName = (String)session.getAttribute("userName");
	 %>
			
		
			<TABLE align="center" height="10%" width="100%">
			
				<TR align="center">
					<TD colspan="3">
						<div><IMG src="/ifpug/images/index_topPP.png" width="80%"  height="100"> <div>
					</TD>
				</TR>
				<TR align="center">
					<TD>
					    &nbsp;&nbsp;&nbsp;&nbsp;	
						<FONT color="#006600"> 当前用户：<%=userName%></FONT>
						&nbsp;&nbsp;
						<a style="color: #006600;" href="/ifpug/IFPUG/user/logout.jsp">退出</a>
					</TD>
				</TR>	
			</TABLE>

		
		<TABLE align="center" cellSpacing=0 cellPadding=0 height="78%" width="80%" bgcolor="#33CC66">
			<TR valign="top">
				<TD height="100%" align='middle' vAlign=center noWrap id=frmTitle name="frmTitle">
					<IFRAME frameBorder='0' id='leftFrame1' name='leftFrame1' scrolling='yes' src="tree.jsp" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 210px; Z-INDEX: 2"></IFRAME>

				</TD>
				<TD class="T2" style="WIDTH: 9pt">
					<TABLE border='0' cellPadding='0' cellSpacing='0' height="100%">
						<TBODY>
							<tr>
								<TD onclick='switchSysBar()' style="HEIGHT: 100%">
									<SPAN class='navPoint' id='switchPoint' title='收缩/弹出左栏'>3</SPAN>
								</TD>
							</tr>
						</TBODY>
					</TABLE>
				</TD>
				<SCRIPT>
var spoint = 3;
if (spoint==4){
document.all("switchPoint").innerText=4;
document.all("frmTitle").style.display="none";
}
</SCRIPT>
				<TD style="WIDTH: 100%">
					<IFRAME frameBorder='0' id='contentFrame' name='contentFrame' scrolling='yes' src="/ifpug/IFPUG/content.jsp" style="HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1"></IFRAME>
				</TD>
			</TR>
		</TABLE>
	</body>
</html>
