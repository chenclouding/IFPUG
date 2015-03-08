package org.apache.jsp.IFPUG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class tree_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/struts-bean.tld");
    _jspx_dependants.add("/WEB-INF/struts-html.tld");
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
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title></title>\r\n");
      out.write("\t\t<link rel=\"StyleSheet\" href=\"../javascript/dtree.css\" type=\"text/css\" />\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"../javascript/dtree.js\"></script>\r\n");
      out.write("\t\t<style>\r\n");
      out.write("body{\r\n");
      out.write("\tfont-family: \"宋体\"; \r\n");
      out.write("\tfont-size: 12px; \r\n");
      out.write("\tfont-weight: normal;}\r\n");
      out.write("a{\r\n");
      out.write("\tfont-family: \"宋体\"; \r\n");
      out.write("\tfont-size: 12px; \r\n");
      out.write("\tcolor: #000000; \r\n");
      out.write("\tfont-weight: normal; \r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body bgcolor=\"#e7f3f8\">\r\n");
      out.write("\t");
String projectId = "";
	projectId =  (String)session.getAttribute("projectId");
	//Variables used for FSM
	String productId = (String)request.getAttribute("productId");  
      out.write("\r\n");
      out.write("\t\t<div class=\"dtree\">\r\n");
      out.write("\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t<!--\r\n");
      out.write("\t\td = new dTree('d');\r\n");
      out.write("        d.add(0,-1,'规模估算');\r\n");
      out.write("\t\t d.add(60,0,'IFPUG功能点','welcomeIfpug.jsp');\r\n");
      out.write("\t\t d.add(61,60,'需求分解');\r\n");
      out.write("\t\t    d.add(62,61,'添加产品','requirement/productList.jsp');\r\n");
      out.write("\t\t    d.add(63,61,'添加功能模块','requirement/addFunction.jsp');\r\n");
      out.write("\t\t    d.add(64,61,'添加基本流程','requirement/addElementaryProcess.jsp');\r\n");
      out.write("\t\t\td.add(65,61,'查看需求分解树','requirement/viewRequirementTree.jsp');\r\n");
      out.write("\r\n");
      out.write("        d.add(66,60,'估算数据功能点');\r\n");
      out.write("            d.add(67,66,'添加数据功能','dataFunction/addDataFunction.jsp');\r\n");
      out.write("\t\t    d.add(69,66,'添加记录元素','dataFunction/addRet.jsp');\r\n");
      out.write("\t\t    d.add(70,66,'添加数据元素','dataFunction/addDet.jsp');\r\n");
      out.write("\t\t    d.add(71,66,'查看数据功能点树','dataFunction/viewDataFunctionTree.jsp');\r\n");
      out.write("        d.add(72,60,'估算事务功能点');\r\n");
      out.write("        \td.add(73,72,'估算事务功能点','transaction/selectFunction.jsp');\r\n");
      out.write("\t\t\td.add(74,72,'查看事务功能点树','transaction/viewTransactionTree.jsp');\r\n");
      out.write("        d.add(17,60,'估算NESMA功能点总数','nesma/nesmaSelectPro.jsp');\r\n");
      out.write("        d.add(27,60,'估算调整后功能点总数','selectProduct.jsp');  \r\n");
      out.write("\t\t\r\n");
      out.write("\t    d.add(47,60,'导出度量','selectProductToMeasure.jsp');\r\n");
      out.write("\t        \t d.config.target = \"contentFrame\";\r\n");
      out.write("\t\t       document.write(d);\t\t\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<p>\r\n");
      out.write("\t\t\t<a href=\"javascript: d.openAll();\">展开目录</a> | <a href=\"javascript: d.closeAll();\">收起目录</a>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\r\n");
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
