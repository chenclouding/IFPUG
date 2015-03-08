<%@ page language="java" contentType="text/html; charset=gb2312" pageEncoding="gb2312"%>
<center>
<%!String error=null; %>
<%error=(String)request.getAttribute("msg") ;
if(error!=null&&error!=null){
%>
<font color="red"><b><%=error %></b></font><br>
<%} %>
</center>