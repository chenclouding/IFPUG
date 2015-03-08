<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page import="business.IFPUG.TransactionFunctionBusiness"%>
<%@ page import="business.IFPUG.RequirementBusiness"%>
<%@ page import="hibernate.IFPUG.IfpugEi"%>
<%@ page import="hibernate.IFPUG.IfpugEo"%>
<%@ page import="hibernate.IFPUG.IfpugEq"%>
<%@ page import="hibernate.IFPUG.IfpugEiDet"%>
<%@ page import="hibernate.IFPUG.IfpugEoDet"%>
<%@ page import="hibernate.IFPUG.IfpugEqDet"%>
<%@ page import="hibernate.IFPUG.IfpugFunction"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'derivedMethod.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="/gcgl/images/screen.css">
		<script language="JavaScript" src="/gcgl/javascript/verify.js"></script>
		<script language="JavaScript">
   		function confirmdel(){
    		return confirm("确定删除？");
   	 	}
   	 	function changeState()
   	 	{
   	 		var frm = document.epDetForm;
   	 		frm.style.display='';
   	 		frm.style.disabled='false'; 
   	 	}
   	 	function verifyInput()
   	 	{
   	 		var frm = document.epDetForm;
   	 		if(isEmpty(frm.epDetName.value)) 
			{	
			    alert("请填写数据元素类型的名称！");
				frm.epDetName.focus();
				return false;
			}	
   	 	}
		</script>
	</head>
	<body>
		<%
			Integer ufpMethod = new Integer(request.getParameter("ufpMethod"));
			Integer type = new Integer(request.getParameter("type"));
			Integer epId = new Integer(request.getParameter("epId"));
			String epType = request.getParameter("epType");

			TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
			RequirementBusiness dfb = new RequirementBusiness();
			String showName = null, showType = null;
			Integer functionId = 0;
			Object[] detList = null;
			switch (type) {
			case 0:
				IfpugEi ei = tfb.queryEiById(epId);
				showName = ei.getEiName();
				showType = "EI";
				functionId = ei.getIfpugFunction().getId();
				detList = ei.getIfpugEiDets().toArray();
				break;
			case 1:
				IfpugEo eo = tfb.queryEoById(epId);
				showName = eo.getEoName();
				showType = "EO";
				functionId = eo.getIfpugFunction().getId();
				detList = eo.getIfpugEoDets().toArray();
				break;
			case 2:
				IfpugEq eq = tfb.queryEqById(epId);
				showName = eq.getEqName();
				showType = "EQ";
				functionId = eq.getIfpugFunction().getId();
				detList = eq.getIfpugEqDets().toArray();
				break;
			}
			IfpugFunction function = (IfpugFunction) dfb.getFunctionById(functionId);
		    while(function.getIfpugProduct() == null)
      	    {
      		    function = function.getIfpugFunction();
      	     }
			Integer productId = function.getIfpugProduct().getId();
		%>

		<div>
		 
			<table>
				<tr>
					<td width="45%">
						<h1>
							请为<%=showType%>类型的事务功能<%=showName%>选择数据元素类型：
						</h1>
						<applet code="ReportTreeApplet.class" codebase="/gcgl/applet"
							archive="checkTree.jar,hibernate.jar,services.jar,
     			commons-codec-1.3.jar,commons-httpclient-3.0.jar,commons-logging-1.0.4.jar,
     			jaxen-1.1-beta-9.jar,jdom-1.0.jar,wsdl4j-1.6.1.jar,
     			xfire-core-1.2.6.jar,xfire-aegis-1.2.6.jar,xfire-java5-1.2.6.jar"
							width="400" height="300">
							<param value="<%=epId%>" name="epId">
							<param value="<%=type%>" name="type">
							<param value="<%=productId%>" name="productId">
						</applet>
					</td>
				</tr>
				<tr>
					<td valign="top">
					<h1> <%=showName%>:用户自主添加的数据元素类型列表</h1>
      <table>
       <tr>
         <td>序号</td> 
         <td>数据名称</td>
         <td>类型</td>
         <td>查看</td>
         <td>修改</td>
         <td>删除</td>
       </tr>
       <%
       	/*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       	if (detList == null || detList.length == 0) {
       %>  
       <h1 style="color:red">您目前无尚未添加数据元素类型</h1>
       <%
       	} else {
       		Integer i = 0;
       		Integer detId;
       		String name;//用于显示数据元素的名字
       		String typeName;//所属文件类型的名称ILF、EIF
       		Short fileType;
       		for (Object d : detList) {
       			if (type == 0) {//如果是ILF的DET
       				IfpugEiDet det = (IfpugEiDet) d;
       				detId = det.getId();
       				name = det.getEiDetName();
       				typeName = "EI";
       				fileType = det.getFileType();
       			} else if (type == 1) {//如果是EIF的DET
       				IfpugEoDet det = (IfpugEoDet) d;
       				detId = det.getId();
       				name = det.getEoDetName();
       				typeName = "EO";
       				fileType = det.getFileType();
       			} else {
       				IfpugEqDet det = (IfpugEqDet) d;
       				detId = det.getId();
       				name = det.getEqDetName();
       				typeName = "EQ";
       				fileType = det.getFileType();
       			}
       			if (fileType != 3)
       				continue;
       %>
	         <tr>
	          <td><%=++i%></td> 
	          <td><%=name%></td>
	          <td><%=typeName%></td>
	          <td class = checkimg>
	          	  <a href="/gcgl/IFPUG/transaction/viewDet.jsp?detId=<%=detId%>&&type=<%=type%>&&ufpMethod=<%=ufpMethod%>&&epType=<%=epType%>&&epId=<%=epId%>">
	              	  <IMG src="/gcgl/images/btncheck.gif" alt="点击查看" border="0" />
	              </a>
	          </td>	
		      <td class = editimg>
		          <a href="/gcgl/IFPUG/transaction/editDet.jsp?detId=<%=detId%>&&type=<%=type%>&&ufpMethod=<%=ufpMethod%>&&epType=<%=epType%>&&epId=<%=epId%>">
		          	 <IMG src="/gcgl/images/btnedit.gif" alt="点击修改" border="0"/>
		          </a>
		      </td>
		      <td class = delimg>
		          <a href="/gcgl/IFPUG/transaction/delDet.jsp?detId=<%=detId%>&&type=<%=type%>&&ufpMethod=<%=ufpMethod%>&&epType=<%=epType%>&&epId=<%=epId%>" onclick="return confirmdel()">
		             <img src="/gcgl/images/btndel.gif" alt="点击删除" width="15" height="12" border="0" />
		          </a>
		      </td>
	         </tr>  
          <%
            	}
            	}
            %>  
       </table>

       	<input type="submit" name="submit" value=" 继续添加 " onclick="return changeState();" />
						
						
						<form action="/gcgl/IFPUG/addEpDet.do" name="epDetForm" id ="epDet" method="post" style="display:none;" onsubmit="return verifyInput();">
							<table>
								<tr>
									<td width="15%">
										数据名称
									</td>
									<td>
										<input type="text" name="epDetName" style="width: 160px"
											value=""/ >
									</td>
								</tr>
								<tr>
									<td width="10%">
										数据描述
									</td>
									<td>
										<textarea name="epDetDesp"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										<input type="submit" name="submit" value=" 增  加 " />
									</td>
									<td>
										<input type="reset" name="reset" value=" 清  除 " />
									</td>
								</tr>
							</table>
							<input type="hidden" name="type" value="<%=type%>" />
							<input type="hidden" name="epId" value="<%=epId%>" />
							<input type="hidden" name="epType" value="<%=epType%>" />
							<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>" />
						</form>
						<form action="/gcgl/IFPUG/ufpCount_Derived_tfp.do">
							<table>
								<tr>
									<td width="15%">
										文件引用类型(FTR)个数
									</td>
									<td>
										<input type="text" name="ftrValue" style="width: 160px"
											value=""/ >
									</td>
								</tr>
								<tr>
									<td width="10%">
										<input type="submit" name="submit" value=" 完成添加 " />
									</td>
								</tr>
							</table>
							<input type="hidden" name="type" value="<%=type%>" />
							<input type="hidden" name="epId" value="<%=epId%>" />
							<input type="hidden" name="epType" value="<%=epType%>" />
							<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>" />
						</form>
					</td>
				</tr>
			</table>
			<input type="hidden" name="type" value="<%=type%>" />
			<input type="hidden" name="epId" value="<%=epId%>" />
			<input type="hidden" name="epType" value="<%=epType%>" />
			<input type="hidden" name="ufpMethod" value="<%=ufpMethod%>" />
		</div>
		<a
			href="Javascript:window.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=<%=functionId%>&&epType=<%=epType%>'">
			返回事务功能列表</a>
	</body>

</html>
