package org.apache.jsp.IFPUG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class ifpug_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(3);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
    _jspx_dependants.add("/WEB-INF/struts-logic.tld");
  }

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
      response.setContentType("text/html; charset=gb2312");
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
      out.write("<HTML>\r\n");
      out.write("\t<HEAD>\r\n");
      out.write("\r\n");
      out.write("\t\t<SCRIPT type=\"text/javascript\">\r\n");
      out.write("function switchSysBar(){\r\n");
      out.write("expireDate=new Date;\r\n");
      out.write("expireDate.setYear(expireDate.getYear()+1);\r\n");
      out.write("if (document.all(\"switchPoint\").innerText==3){\r\n");
      out.write("document.all(\"switchPoint\").innerText=4;\r\n");
      out.write("document.cookie=\"switchPoint=\"+\"4\"+\";expires=\"+expireDate.toGMTString()+\";\";\r\n");
      out.write("document.all(\"frmTitle\").style.display=\"none\";\r\n");
      out.write("}else{\r\n");
      out.write("document.all(\"switchPoint\").innerText=3;\r\n");
      out.write("document.cookie=\"switchPoint=\"+\"3\"+\";expires=\"+expireDate.toGMTString()+\";\";\r\n");
      out.write("document.all(\"frmTitle\").style.display=\"\";\r\n");
      out.write("}}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\t\t<SCRIPT type=\"text/javascript\" language=\"javascript\" charset=gb2312 src=\"/ifpug/javascript/navigator.js\"></SCRIPT>\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t<STYLE type=text/css>\r\n");
      out.write(".navPoint {COLOR: 5E95C3; CURSOR: hand; FONT-FAMILY: Webdings; FONT-SIZE: 9pt}\r\n");
      out.write("</STYLE>\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("#dropmenudiv{\r\n");
      out.write("position:absolute;\r\n");
      out.write("border:1px solid black;\r\n");
      out.write("border-bottom-width: 0;\r\n");
      out.write("font:normal 12px Verdana;\r\n");
      out.write("line-height:18px;\r\n");
      out.write("z-index:100;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#dropmenudiv a{\r\n");
      out.write("width: 100%;\r\n");
      out.write("display: block;\r\n");
      out.write("text-indent: 3px;\r\n");
      out.write("border-bottom: 1px solid black;\r\n");
      out.write("padding: 1px 0;\r\n");
      out.write("text-decoration: none;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#dropmenudiv a:hover{ /*hover background color*/\r\n");
      out.write("background-color: yellow;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\t\t<link href=\"/ifpug/images/css0.css\" rel=\"stylesheet\" type=\"text/css\">\t\t\r\n");
      out.write("\t</head>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<BODY scroll='no' style=\"MARGIN: 0px\">\r\n");
      out.write("\t");

				String userName = (String)session.getAttribute("userName");
	 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t<TABLE align=\"center\" height=\"10%\" width=\"100%\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<TR align=\"center\">\r\n");
      out.write("\t\t\t\t\t<TD colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t\t<div><IMG src=\"/ifpug/images/index_topPP.png\" width=\"80%\"  height=\"100\"> <div>\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\r\n");
      out.write("\t\t\t\t<TR align=\"center\">\r\n");
      out.write("\t\t\t\t\t<TD>\r\n");
      out.write("\t\t\t\t\t    &nbsp;&nbsp;&nbsp;&nbsp;\t\r\n");
      out.write("\t\t\t\t\t\t<FONT color=\"#006600\"> 当前用户：");
      out.print(userName);
      out.write("</FONT>\r\n");
      out.write("\t\t\t\t\t\t&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<a style=\"color: #006600;\" href=\"/ifpug/IFPUG/user/logout.jsp\">退出</a>\r\n");
      out.write("\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t</TR>\t\r\n");
      out.write("\t\t\t</TABLE>\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<TABLE align=\"center\" cellSpacing=0 cellPadding=0 height=\"78%\" width=\"80%\" bgcolor=\"#33CC66\">\r\n");
      out.write("\t\t\t<TR valign=\"top\">\r\n");
      out.write("\t\t\t\t<TD height=\"100%\" align='middle' vAlign=center noWrap id=frmTitle name=\"frmTitle\">\r\n");
      out.write("\t\t\t\t\t<IFRAME frameBorder='0' id='leftFrame1' name='leftFrame1' scrolling='yes' src=\"tree.jsp\" style=\"HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 210px; Z-INDEX: 2\"></IFRAME>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t<TD class=\"T2\" style=\"WIDTH: 9pt\">\r\n");
      out.write("\t\t\t\t\t<TABLE border='0' cellPadding='0' cellSpacing='0' height=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t<TBODY>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<TD onclick='switchSysBar()' style=\"HEIGHT: 100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<SPAN class='navPoint' id='switchPoint' title='收缩/弹出左栏'>3</SPAN>\r\n");
      out.write("\t\t\t\t\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</TBODY>\r\n");
      out.write("\t\t\t\t\t</TABLE>\r\n");
      out.write("\t\t\t\t</TD>\r\n");
      out.write("\t\t\t\t<SCRIPT>\r\n");
      out.write("var spoint = 3;\r\n");
      out.write("if (spoint==4){\r\n");
      out.write("document.all(\"switchPoint\").innerText=4;\r\n");
      out.write("document.all(\"frmTitle\").style.display=\"none\";\r\n");
      out.write("}\r\n");
      out.write("</SCRIPT>\r\n");
      out.write("\t\t\t\t<TD style=\"WIDTH: 100%\">\r\n");
      out.write("\t\t\t\t\t<IFRAME frameBorder='0' id='contentFrame' name='contentFrame' scrolling='yes' src=\"/ifpug/IFPUG/content.jsp\" style=\"HEIGHT: 100%; VISIBILITY: inherit; WIDTH: 100%; Z-INDEX: 1\"></IFRAME>\r\n");
      out.write("\t\t\t\t</TD>\r\n");
      out.write("\t\t\t</TR>\r\n");
      out.write("\t\t</TABLE>\r\n");
      out.write("\t</body>\r\n");
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
