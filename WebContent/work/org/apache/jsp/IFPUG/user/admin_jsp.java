package org.apache.jsp.IFPUG.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import business.IFPUG.UserBusiness;
import hibernate.IFPUG.IfpugUser;
import java.util.*;

public final class admin_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("  \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<HTML>\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>管理员主页</TITLE>\r\n");
      out.write("<!--CharSet-->\r\n");
      out.write("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=gb2312\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/ifpug/images/CSS.CSS\" type=\"text/css\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("<!--\r\n");
      out.write(".style1 {color: #006600}\r\n");
      out.write(".style2 {font-size: 16px}\r\n");
      out.write(".style3 {color: #CC3300}\r\n");
      out.write(".style4 {\r\n");
      out.write("\tfont-family: \"华文隶书\";\r\n");
      out.write("\tfont-size: 24px;\r\n");
      out.write("\tcolor: #FF0000;\r\n");
      out.write("}\r\n");
      out.write(".style6 {\r\n");
      out.write("\tfont-size: 36px;\r\n");
      out.write("\tfont-family: \"华文隶书\";\r\n");
      out.write("}\r\n");
      out.write(".style8 {font-size: 24px; font-family: \"华文隶书\";}\r\n");
      out.write("-->\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"JavaScript\" src=\"javascript/verify.js\"></script>\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("function register(){\r\n");
      out.write("window.location.href=\"/ifpug/IFPUG/user/register.jsp\";\r\n");
      out.write("}\r\n");
      out.write("function confirmdel(){\r\n");
      out.write("\treturn confirm(\"确定删除？\");\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY background=\"/ifpug/images/bline.gif\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\" >\r\n");
      out.write("<!--Counter-->\r\n");
      out.write("<!--Something Here-->\r\n");
      out.write("<table width=\"778\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"130\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td background=\"/ifpug/images/index_topPP_ifpug.png\" valign=\"top\">\r\n");
      out.write("     \r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"778\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" background=\"/ifpug/images/index_bg.gif\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\" width=\"215\" rowspan=\"2\">\r\n");
      out.write("      <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("            <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"20\" background=\"/ifpug/images/01.gif\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td> <img src=\"/ifpug/images/index_pic.gif\" width=\"215\" height=\"155\"></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("            <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"15\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <div align=\"center\">\r\n");
      out.write("<!--Language-->\r\n");
      out.write("<!--Something Here-->\r\n");
      out.write("</div>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("            <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40\" background=\"/ifpug/images/index_lm.gif\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td> <div align=\"center\"><b><a href=\"/ifpug/index.jsp\">主 页</a></b> </div></td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("<!--Button9.Content.Begin-->\r\n");
      out.write("            <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40\" background=\"/ifpug/images/index_lm.gif\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <div align=\"center\"><b>\r\n");
      out.write("<!--Button9.Link-->\r\n");
      out.write("\r\n");
      out.write("    <!--Button9-->管理用户 \r\n");
      out.write("</b></div>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("<!--Button9.Content.End-->\r\n");
      out.write("\r\n");
      out.write("<!--Button10.Content.Begin-->\r\n");
      out.write("            <table width=\"215\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" height=\"40\" background=\"/ifpug/images/index_lm.gif\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td>\r\n");
      out.write("                  <div align=\"center\"><b>\r\n");
      out.write("<!--Button10.Link-->\r\n");
      out.write("<a href=\"/ifpug/IFPUG/user/adminLogin.jsp\">\r\n");
      out.write("<!--Button10-->\r\n");
      out.write("退出系统\r\n");
      out.write("</a></b></div>\r\n");
      out.write("                </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("<!--Button10.Content.End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td valign=\"top\" width=\"563\"><img src=\"/ifpug/images/index_top2.gif\" width=\"563\" height=\"70\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td valign=\"top\">\r\n");
      out.write("      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("     \r\n");
      out.write("        <tr>\r\n");
      out.write("          <td>\r\n");
      out.write("           <!--IndexPage.Content.Begin-->\r\n");
      out.write("            <table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n");
      out.write("            <tr>\r\n");
      out.write("              <td>\r\n");
      out.write("                  <div align=\"left\" class=\"style2 style3\">\r\n");
      out.write("                     <p class=\"style2 style4\">欢迎来到管理员主页！</p>\r\n");
      out.write("                    </div> \r\n");
      out.write("              </td>\r\n");
      out.write("             </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td bgcolor=\"#000000\"><img src=\"/ifpug/images/Spacer.gif\" width=\"1\" height=\"1\"></td>\r\n");
      out.write("             </tr>\r\n");
      out.write("             <tr>\r\n");
      out.write("                <td height=\"128\">\r\n");
      out.write("<!--Page.Content.Begin-->\r\n");
      out.write("<!--Something Here-->\r\n");
      out.write("<div style=\" height:300px; overflow:scroll; overflow-x:hidden;\">\r\n");
      out.write(" ");

           //get all the register users from database
           List userlist = UserBusiness.getAllUsers();
           IfpugUser user = null;
        
      out.write("\r\n");
      out.write("       ");

        /*If no users information, prompts to add;*/
        if(userlist==null ||userlist.size()==0 ){
      out.write("  \r\n");
      out.write("         <h1 style=\"color:red\">当前还没有用户，请添加用户。</h1> \r\n");
      out.write("       ");
}else{ 
      out.write("\r\n");
      out.write("         <table align=\"center\" width=\"550px\">\r\n");
      out.write("\t       <tr> \r\n");
      out.write("\t            <td width=\"30%\">编号</td>\r\n");
      out.write("\t\t        <td width=\"30%\">用户名</td> \r\n");
      out.write("\t\t        <td width=\"30%\">删除</td>\r\n");
      out.write("\t       </tr> \r\n");
      out.write("\t    ");
   for(Object obj:userlist){ 
	         user = (IfpugUser)obj; 
	         Integer userId = user.getId();
	        
	     
      out.write("\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t\t          <td>");
      out.print( userlist.indexOf(obj)+1 );
      out.write("</td>\r\n");
      out.write("\t\t           \r\n");
      out.write("\t\t          <td>\r\n");
      out.write("\t\t          \t");
      out.print(user.getUsername() );
      out.write("\t          \t\t         \t  \t\t\t\t\r\n");
      out.write("\t\t          </td>\t\t         \r\n");
      out.write("\t\t          <td>\r\n");
      out.write("\t\t             <a href=\"/ifpug/IFPUG/user/deleteUser.jsp?userId=");
      out.print(userId);
      out.write("\"\r\n");
      out.write("\t\t                 onclick=\"return confirmdel();\">\r\n");
      out.write("\t\t                 <IMG src=\"/ifpug/images/btndel.gif\" alt=\"Delete\" width=\"15\" height=\"12\" border=\"0\" />\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t           </td>\r\n");
      out.write("\t\t         \r\n");
      out.write("\t         </tr>  \r\n");
      out.write("          ");
}
      out.write("\r\n");
      out.write("           </table>\r\n");
      out.write("        ");
}
      out.write("  \r\n");
      out.write(" </div>\r\n");
      out.write("<p>&nbsp; </p>\r\n");
      out.write("\r\n");
      out.write("<!--Page.Content.End-->\r\n");
      out.write("       </td>\r\n");
      out.write("          </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<!--IndexPage.Content.End-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <table width=\"90%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" height=\"1\">\r\n");
      out.write("              <tr>\r\n");
      out.write("                <td bgcolor=\"#000000\"> </td>\r\n");
      out.write("              </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("\r\n");
      out.write("          </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("      </table>\r\n");
      out.write("    </td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("<table width=\"778\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <td><img src=\"/ifpug/images/index_bottom.gif\" width=\"778\" height=\"50\"></td>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</BODY>\r\n");
      out.write("\r\n");
      out.write(" </HTML>\r\n");
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
