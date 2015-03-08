<%@ page language="java" pageEncoding="GB2312" %>
<%@ page import="business.IFPUG.UserBusiness"%> 
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ page import="java.util.*"%>

<%
	String userName=new String(request.getParameter("username").getBytes("ISO-8859-1"),"GB2312");
	String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"GB2312");
	UserBusiness ub = new UserBusiness();
	boolean isValidateUser = ub.isValidateUser(userName, password);
	
	if(isValidateUser){
		//String employeeId = employeeFacade.getEmployeeIdByUserName(userName);
		//String employeeName = employeeFacade.getEmployeeNameById(employeeId);
		//Collection col = projectFacade.getEmployeeInfoInAllProjectByEmployeeId(employeeId);
		//Iterator iter = col.iterator();
		//if (iter.hasNext())
		//{
		//	ProjectEmployeeRelationBean perb = (ProjectEmployeeRelationBean) iter.next();
		//	String projectId = perb.getProjectId();	
		//	session.setAttribute("projectId", projectId);		
		//}
		
		//List authorityList = authority.queryFunctionsByUserIdAndProjectId(employeeId,"01");
		//session.setAttribute("authorityList",authorityList);
			
		//session.setAttribute("employeeId", employeeId);
		//session.setAttribute("userName",userName);
		//session.setAttribute("employeeName",employeeName);
		
		//session.setMaxInactiveInterval(-1);
		//response.sendRedirect("../success.jsp");
	}else{
	%>
		<script language='javascript'>alert("用户名不存在或密码错误！请重新登陆！");location.href="../index.jsp";</script>
	<%
	}
%>