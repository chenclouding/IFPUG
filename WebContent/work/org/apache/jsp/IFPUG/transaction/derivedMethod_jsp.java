package org.apache.jsp.IFPUG.transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.TransactionFunctionBusiness;
import business.IFPUG.RequirementBusiness;
import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugEiDet;
import hibernate.IFPUG.IfpugEoDet;
import hibernate.IFPUG.IfpugEqDet;
import hibernate.IFPUG.IfpugFunction;

public final class derivedMethod_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=gb2312");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("\t\t<title>My JSP 'derivedMethod.jsp' starting page</title>\r\n");
      out.write("\r\n");
      out.write("\t\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t\t<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("\t\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/gcgl/images/screen.css\">\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"/gcgl/javascript/verify.js\"></script>\r\n");
      out.write("\t\t<script language=\"JavaScript\">\r\n");
      out.write("   \t\tfunction confirmdel(){\r\n");
      out.write("    \t\treturn confirm(\"确定删除？\");\r\n");
      out.write("   \t \t}\r\n");
      out.write("   \t \tfunction changeState()\r\n");
      out.write("   \t \t{\r\n");
      out.write("   \t \t\tvar frm = document.epDetForm;\r\n");
      out.write("   \t \t\tfrm.style.display='';\r\n");
      out.write("   \t \t\tfrm.style.disabled='false'; \r\n");
      out.write("   \t \t}\r\n");
      out.write("   \t \tfunction verifyInput()\r\n");
      out.write("   \t \t{\r\n");
      out.write("   \t \t\tvar frm = document.epDetForm;\r\n");
      out.write("   \t \t\tif(isEmpty(frm.epDetName.value)) \r\n");
      out.write("\t\t\t{\t\r\n");
      out.write("\t\t\t    alert(\"请填写数据元素类型的名称！\");\r\n");
      out.write("\t\t\t\tfrm.epDetName.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("   \t \t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t");

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
		
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t\t<table>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td width=\"45%\">\r\n");
      out.write("\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t请为");
      out.print(showType);
      out.write("类型的事务功能");
      out.print(showName);
      out.write("选择数据元素类型：\r\n");
      out.write("\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t<applet code=\"ReportTreeApplet.class\" codebase=\"/gcgl/applet\"\r\n");
      out.write("\t\t\t\t\t\t\tarchive=\"checkTree.jar,hibernate.jar,services.jar,\r\n");
      out.write("     \t\t\tcommons-codec-1.3.jar,commons-httpclient-3.0.jar,commons-logging-1.0.4.jar,\r\n");
      out.write("     \t\t\tjaxen-1.1-beta-9.jar,jdom-1.0.jar,wsdl4j-1.6.1.jar,\r\n");
      out.write("     \t\t\txfire-core-1.2.6.jar,xfire-aegis-1.2.6.jar,xfire-java5-1.2.6.jar\"\r\n");
      out.write("\t\t\t\t\t\t\twidth=\"400\" height=\"300\">\r\n");
      out.write("\t\t\t\t\t\t\t<param value=\"");
      out.print(epId);
      out.write("\" name=\"epId\">\r\n");
      out.write("\t\t\t\t\t\t\t<param value=\"");
      out.print(type);
      out.write("\" name=\"type\">\r\n");
      out.write("\t\t\t\t\t\t\t<param value=\"");
      out.print(productId);
      out.write("\" name=\"productId\">\r\n");
      out.write("\t\t\t\t\t\t</applet>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<h1> ");
      out.print(showName);
      out.write(":用户自主添加的数据元素类型列表</h1>\r\n");
      out.write("      <table>\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td>序号</td> \r\n");
      out.write("         <td>数据名称</td>\r\n");
      out.write("         <td>类型</td>\r\n");
      out.write("         <td>查看</td>\r\n");
      out.write("         <td>修改</td>\r\n");
      out.write("         <td>删除</td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       ");

       	/*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       	if (detList == null || detList.length == 0) {
       
      out.write("  \r\n");
      out.write("       <h1 style=\"color:red\">您目前无尚未添加数据元素类型</h1>\r\n");
      out.write("       ");

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
       
      out.write("\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t          <td>");
      out.print(++i);
      out.write("</td> \r\n");
      out.write("\t          <td>");
      out.print(name);
      out.write("</td>\r\n");
      out.write("\t          <td>");
      out.print(typeName);
      out.write("</td>\r\n");
      out.write("\t          <td class = checkimg>\r\n");
      out.write("\t          \t  <a href=\"/gcgl/IFPUG/transaction/viewDet.jsp?detId=");
      out.print(detId);
      out.write("&&type=");
      out.print(type);
      out.write("&&ufpMethod=");
      out.print(ufpMethod);
      out.write("&&epType=");
      out.print(epType);
      out.write("&&epId=");
      out.print(epId);
      out.write("\">\r\n");
      out.write("\t              \t  <IMG src=\"/gcgl/images/btncheck.gif\" alt=\"点击查看\" border=\"0\" />\r\n");
      out.write("\t              </a>\r\n");
      out.write("\t          </td>\t\r\n");
      out.write("\t\t      <td class = editimg>\r\n");
      out.write("\t\t          <a href=\"/gcgl/IFPUG/transaction/editDet.jsp?detId=");
      out.print(detId);
      out.write("&&type=");
      out.print(type);
      out.write("&&ufpMethod=");
      out.print(ufpMethod);
      out.write("&&epType=");
      out.print(epType);
      out.write("&&epId=");
      out.print(epId);
      out.write("\">\r\n");
      out.write("\t\t          \t <IMG src=\"/gcgl/images/btnedit.gif\" alt=\"点击修改\" border=\"0\"/>\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t\t      <td class = delimg>\r\n");
      out.write("\t\t          <a href=\"/gcgl/IFPUG/transaction/delDet.jsp?detId=");
      out.print(detId);
      out.write("&&type=");
      out.print(type);
      out.write("&&ufpMethod=");
      out.print(ufpMethod);
      out.write("&&epType=");
      out.print(epType);
      out.write("&&epId=");
      out.print(epId);
      out.write("\" onclick=\"return confirmdel()\">\r\n");
      out.write("\t\t             <img src=\"/gcgl/images/btndel.gif\" alt=\"点击删除\" width=\"15\" height=\"12\" border=\"0\" />\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t         </tr>  \r\n");
      out.write("          ");

            	}
            	}
            
      out.write("  \r\n");
      out.write("       </table>\r\n");
      out.write("\r\n");
      out.write("       \t<input type=\"submit\" name=\"submit\" value=\" 继续添加 \" onclick=\"return changeState();\" />\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<form action=\"/gcgl/IFPUG/addEpDet.do\" name=\"epDetForm\" id =\"epDet\" method=\"post\" style=\"display:none;\" onsubmit=\"return verifyInput();\">\r\n");
      out.write("\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t数据名称\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"epDetName\" style=\"width: 160px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"\"/ >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"10%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t数据描述\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<textarea name=\"epDetDesp\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" name=\"submit\" value=\" 增  加 \" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"reset\" name=\"reset\" value=\" 清  除 \" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"epId\" value=\"");
      out.print(epId);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"epType\" value=\"");
      out.print(epType);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ufpMethod\" value=\"");
      out.print(ufpMethod);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"/gcgl/IFPUG/ufpCount_Derived_tfp.do\">\r\n");
      out.write("\t\t\t\t\t\t\t<table>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t文件引用类型(FTR)个数\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"ftrValue\" style=\"width: 160px\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tvalue=\"\"/ >\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<td width=\"10%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<input type=\"submit\" name=\"submit\" value=\" 完成添加 \" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"epId\" value=\"");
      out.print(epId);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"epType\" value=\"");
      out.print(epType);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"hidden\" name=\"ufpMethod\" value=\"");
      out.print(ufpMethod);
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.print(type);
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"epId\" value=\"");
      out.print(epId);
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"epType\" value=\"");
      out.print(epType);
      out.write("\" />\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"ufpMethod\" value=\"");
      out.print(ufpMethod);
      out.write("\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<a\r\n");
      out.write("\t\t\thref=\"Javascript:window.location='/ifpug/IFPUG/transaction/addMethodToEp.jsp?functionId=");
      out.print(functionId);
      out.write("&&epType=");
      out.print(epType);
      out.write("'\">\r\n");
      out.write("\t\t\t返回事务功能列表</a>\r\n");
      out.write("\t</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
