<%@ page contentType="application/msword;charset=GBK"%>

<%@ page import="business.IFPUG.MeasureReport" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<html>  
  
  <%  
      
      Integer productId = new Integer(request.getParameter("productId"));
       MeasureReport mr = new MeasureReport();
       String code = mr.exportMeasureReport(productId); 
      response.setHeader("Content-disposition","attachment; filename=measureReport.doc");
  %>          

 <%=code %>
  
</html>
