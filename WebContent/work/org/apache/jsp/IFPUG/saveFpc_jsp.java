package org.apache.jsp.IFPUG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.RequirementBusiness;
import hibernate.IFPUG.IfpugProduct;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugEif;

public final class saveFpc_jsp extends org.apache.jasper.runtime.HttpJspBase
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

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>My JSP 'saveFpc.jsp' starting page</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/ifpug/images/screen.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  ");

  	String tcf = request.getParameter("tcf");
  	String fpc = request.getParameter("fpc");
  	Integer productId = new Integer(request.getParameter("productId"));
  	RequirementBusiness rb = new RequirementBusiness();
  	IfpugProduct product = (IfpugProduct) rb.getProductById(productId);
  	product.setMeasureStatus(Short.valueOf("2"));
  	System.out.println(tcf + ":" + fpc);
  	String count;
  	int i, flag = 0;

  	for (i = 0; i < fpc.length(); i++) {
  		if (fpc.charAt(i) == '.') {
  			flag = 1;
  			break;
  		}
  	}
  	if (flag == 1) {
  		count = fpc.substring(0, i);
  		if (fpc.charAt(i + 1) >= '5')
  			product.setUfpCount(Integer.parseInt((count) + 1));
  		else
  			product.setUfpCount(Integer.parseInt((count)));
  	}
  	else{
  			product.setUfpCount(Integer.parseInt(fpc));
  	}

  
  	boolean result = rb.updateProduct(product);
  	if (result == true) {
  		response.sendRedirect("/ifpug/IFPUG/adjustUfp.jsp?tcf=" + tcf
  				+ "&fpc=" + fpc + "&productId=" + productId);
  	} else {
  		response.sendRedirect("/ifpug/IFPUG/failure.jsp");
  	}
  
      out.write("\r\n");
      out.write("   \r\n");
      out.write("   \r\n");
      out.write("  </body>\r\n");
      out.write("</html>");
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
