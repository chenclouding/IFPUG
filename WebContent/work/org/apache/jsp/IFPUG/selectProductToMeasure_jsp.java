package org.apache.jsp.IFPUG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.*;
import hibernate.IFPUG.*;

public final class selectProductToMeasure_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>增加功能模块</title>\r\n");
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
      out.write("\r\n");
      out.write(" \r\n");
      out.write("    ");
  
       RequirementBusiness rb = new RequirementBusiness(); 
       String userName = (String)session.getAttribute("userName");
       /*从数据库中把所有软件的估算信息取出*/
       //List productList = rb.getAllProduct(userName); 
      UserBusiness ub = new UserBusiness();
      IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
      Object[] productList = user.getIfpugProducts().toArray();
      if(productList == null||productList.length == 0){//如果没有添加product  
    
      out.write("\r\n");
      out.write("       \t<script language=\"JavaScript\"> \r\n");
      out.write("       \t\talert(\"您尚未添加产品，请先添加待估算软件产品！\");\r\n");
      out.write("       \t\twindow.location.href=\"/ifpug/IFPUG/requirement/productList.jsp\";\r\n");
      out.write("       \t</script>\t\r\n");
      out.write("    ");

      } 
      
    
      out.write("\r\n");
      out.write("    <table style=\"width:500px\">\r\n");
      out.write("     <tr>\r\n");
      out.write("       <td valign =\"bottom\" width=\"90px\">请选择产品:</td>\r\n");
      out.write("        <td>\r\n");
      out.write("\t\t    <form  action=\"/ifpug/IFPUG/measureReport.jsp\"  method=\"post\" target=\"functionFrame\" >\r\n");
      out.write("\t\t      \t<select name=\"productId\" style=\"width:160px\">\r\n");
      out.write("\t\t      \t ");

		      	    for(Object p:productList){
		      	        	IfpugProduct fp = (IfpugProduct)p;
      out.write("\r\n");
      out.write("\t\t      \t        <option value=\"");
      out.print(fp.getId());
      out.write('"');
      out.write('>');
      out.print(fp.getProductName());
      out.write("</option>\r\n");
      out.write("\t\t      \t  ");
}
      out.write("\r\n");
      out.write("\t\t\t \t   \r\n");
      out.write("\t\t\t    </select>\r\n");
      out.write("\t\t\t     <input type=\"submit\" name=\"submit\" value=\"提 交\"/>\r\n");
      out.write("\t\t    </form>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>   \r\n");
      out.write("    <iFrame name=\"functionFrame\" frameborder=\"0\" height=\"800px\" width=\"100%\" scrolling=\"auto\">\r\n");
      out.write("    </iFrame>\r\n");
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
