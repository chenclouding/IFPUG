package org.apache.jsp.IFPUG.requirement;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.RequirementBusiness;
import business.IFPUG.UserBusiness;
import hibernate.IFPUG.*;

public final class productList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>增加产品-显示产品列表</title>\r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("  \t<link rel=\"stylesheet\" type=\"text/css\" href=\"/ifpug/images/screen.css\">\r\n");
      out.write("  \t<script language=\"JavaScript\" src=\"/ifpug/javascript/verify.js\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\" src=\"/ifpug/javascript/calenderJS.js\"></script>\r\n");
      out.write("\t<script language=\"JavaScript\">  \r\n");
      out.write("\tfunction expandIt(formId) {\r\n");
      out.write("\t\tformObject =document.getElementById(formId)\r\n");
      out.write("\t\tif (formObject.style.display == 'none') {\r\n");
      out.write("\t\t\tformObject.style.display = '';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse {\r\n");
      out.write("\t\t\tformObject.style.display = 'none';\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("    function verifyInput()\r\n");
      out.write("\t{\t\r\n");
      out.write("\t \t\tvar frm = document.productForm;  \t\t    \t   \r\n");
      out.write("\t\t\tif(isEmpty(frm.productName.value)) \r\n");
      out.write("\t\t\t{\t\r\n");
      out.write("\t\t\t    alert(\"请填写软件名称！\");\r\n");
      out.write("\t\t\t\tfrm.productName.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(isEmpty(frm.projectStartTime.value)) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请填写项目开始时间！\");\r\n");
      out.write("\t\t\t\tfrm.projectStartTime.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\t\t\r\n");
      out.write("\t\t\tif(isEmpty(frm.projectEndTime.value)) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请填写项目结束时间！\");\r\n");
      out.write("\t\t\t\tfrm.projectEndTime.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(compareTime(frm.projectEndTime.value,frm.projectStartTime.value))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"项目结束时间应大于开始时间！\");\r\n");
      out.write("\t\t\t\tfrm.projectEndTime.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif(isEmpty(frm.estimateTime.value)) \r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"请填写估算开始时间！\");\r\n");
      out.write("\t\t\t\tfrm.estimateTime.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tif (!isEmpty(frm.endTime.value)&&compareTime(frm.endTime.value,frm.estimateTime.value))\r\n");
      out.write("\t\t\t{\r\n");
      out.write("\t\t\t\talert(\"估算结束时间应大于开始时间！\");\r\n");
      out.write("\t\t\t\tfrm.endTime.focus();\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    function confirmdel(){\r\n");
      out.write("    \treturn confirm(\"确定删除？\");\r\n");
      out.write("    }\r\n");
      out.write("    </script> \r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <h1>产品列表</h1>\r\n");
      out.write("    <table>\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td>序号</td> \r\n");
      out.write("         <td>软件名称</td>\r\n");
      out.write("         <td>估算状态</td>\r\n");
      out.write("         <td>查看</td>\r\n");
      out.write("         <td>修改</td>\r\n");
      out.write("         <td>删除</td>\r\n");
      out.write("         <td>添加功能</td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       ");
        
       String userName = (String)session.getAttribute("userName");
       /*从数据库中把所有软件的估算信息取出*/
       RequirementBusiness rb = new RequirementBusiness();
       //List productList = rb.getAllProduct(userName); 
       UserBusiness ub = new UserBusiness();
       IfpugUser user = (IfpugUser)ub.getUserByUserName(userName);
       Object[] productList = user.getIfpugProducts().toArray();
       
       IfpugProduct product = new IfpugProduct();//定义实体Bean
     
       int i = 1;
       /*若无软件信息，提示添加；若有软件信息，列出估算软件列表*/
       if(productList==null ||productList.length==0 ){
      out.write("  \r\n");
      out.write("       <h1 style=\"color:red\">目前无估算软件信息，请添加待估算的软件</h1>\r\n");
      out.write("       ");
}else{ 
	       for(Object p:productList){ 
	         product = (IfpugProduct)p; 
	         Integer productId = product.getId();  
	         
      out.write("\r\n");
      out.write("\t         <tr>\r\n");
      out.write("\t          <td>");
      out.print( i++);
      out.write("</td> \r\n");
      out.write("\t          <td>");
      out.print( product.getProductName() );
      out.write("</td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("\t          ");
Short status = product.getMeasureStatus();
	         	String showstatus = null; 
	         	if(status==0)  showstatus="未估算";
	         	else if(status==1)  showstatus="部分估算";
	         	else if(status==2)  showstatus="已估算";
      out.write("\r\n");
      out.write("\t          \t");
      out.print( showstatus);
      out.write("</td>\r\n");
      out.write("\t\t         <td class = checkimg>\r\n");
      out.write("\t              \t  <a href=\"/ifpug/IFPUG/requirement/viewProduct.jsp?productId=");
      out.print(productId);
      out.write("\">\r\n");
      out.write("\t              \t  \t<IMG src=\"/ifpug/images/btncheck.gif\" alt=\"点击查看\" border=\"0\" />\r\n");
      out.write("\t              \t  </a>\r\n");
      out.write("\t              </td>\t\r\n");
      out.write("\t\t          <td class = editimg>\r\n");
      out.write("\t\t          \t  <a href=\"/ifpug/IFPUG/requirement/editProduct.jsp?productId=");
      out.print(productId);
      out.write("\">\r\n");
      out.write("\t\t          \t  \t<IMG src=\"/ifpug/images/btnedit.gif\" alt=\"点击修改\" border=\"0\" />\r\n");
      out.write("\t\t          \t  </a>\r\n");
      out.write("\t\t          </td>\r\n");
      out.write("\t\t          <td class = delimg>\r\n");
      out.write("\t\t              <a href=\"/ifpug/IFPUG/requirement/delProduct.jsp?productId=");
      out.print(productId);
      out.write("\" onclick=\"return confirmdel()\">\r\n");
      out.write("\t\t              \t<img src=\"/ifpug/images/btndel.gif\" alt=\"点击删除\" width=\"15\" height=\"12\" border=\"0\" />\r\n");
      out.write("\t\t              </a>\r\n");
      out.write("\t\t          </td>\r\n");
      out.write("\t\t          <td>\r\n");
      out.write("\t\t          \t  <a href=\"/ifpug/IFPUG/requirement/functionList.jsp?productId=");
      out.print(productId);
      out.write("\">添加功能模块</a>\r\n");
      out.write("\t\t          </td>\r\n");
      out.write("\t         </tr>  \r\n");
      out.write("          ");
}
       }
      out.write("  \r\n");
      out.write("    </table>\r\n");
      out.write("    \r\n");
      out.write("    <a onclick=\"expandIt('product'); return false\" href=\"#\"><h1>增加产品</h1></a>\r\n");
      out.write("    \r\n");
      out.write("    <form  action=\"/ifpug/IFPUG/addProduct.do\" name=\"productForm\" id =\"product\" method=\"post\" style=\"display:none;\" onsubmit=\"return verifyInput();\">\r\n");
      out.write("  \t<table>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"15%\">待估算软件名称</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <input type=\"text\" name=\"productName\" style=\"width:160px\" value=\"\"/ >\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"10%\">待估算软件描述</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <textarea name=\"productDesp\"></textarea>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"15%\">软件类型</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t \t<select name=\"productType\" style=\"width:160px\" >\r\n");
      out.write("  \t\t\t \t    <!--0代表MIS系统，1代表web系统  -->\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>MIS</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">Web</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"10%\">项目类型</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t \t<select name=\"developType\" style=\"width:160px\">\r\n");
      out.write("  \t\t\t \t    <!--0代表newDevelop，1代表二次开发，2代表增强型 -->\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>新开发</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">二次开发</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">增强型</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td>估算方法</td>\r\n");
      out.write("  \t\t\t<td width=\"40px\">\r\n");
      out.write("  \t\t\t \t<select name=\"measureMethod\" style=\"width:160px\">\r\n");
      out.write("  \t\t\t \t    <!--0代表COSMIC标准方法直接估算，1代表USE-CASE辅助估算，2代表COSMIC近似估算  -->\r\n");
      out.write("  \t\t\t \t    <option value=\"0\" selected>IFPUG标准估算</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">IFPUG近似估算</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td valign=\"top\">估算人员</td>\r\n");
      out.write("  \t\t\t<td valign=\"top\">\r\n");
      out.write("  \t\t   \t\t<input type=\"text\" name=\"estimator\">\r\n");
      out.write("  \t\t   \t</td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t    <tr>\r\n");
      out.write("  \t    \t<td valign=\"top\">估算状态<br></td><td valign=\"top\">\r\n");
      out.write("  \t\t   \t\t<input type=\"radio\" checked=\"checked\" value=\"0\" name=\"measureStatus\"/> 未估算\r\n");
      out.write("  \t\t   \t\t<input type=\"radio\" value=\"1\" name=\"measureStatus\"/> 部分估算\r\n");
      out.write("  \t\t   \t\t<input type=\"radio\" value=\"2\" name=\"measureStatus\"/> 已估算\r\n");
      out.write("  \t\t   </td>\r\n");
      out.write("  \t\t </tr>\r\n");
      out.write("  \t\t <tr>\r\n");
      out.write("  \t\t\t<td>生命周期阶段</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t \t<select name=\"lifecyclePhase\" style=\"width:160px\">\r\n");
      out.write("  \t\t\t \t    <!--0代表需求定义后，1代表详细设计后，2代表编码完成后，3代表产品交付后  -->\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>需求定义后</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">详细设计后</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">编码完成后</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">产品交付后</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t    <tr>\r\n");
      out.write("  \t\t\t<td>开发开始时间</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("           \t\t<input type=\"text\" name=\"projectStartTime\" style=\"width:160px\" onfocus=\"HS_setDate(this)\"/>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td>开发结束时间</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" name=\"projectEndTime\" style=\"width:160px\" onfocus=\"HS_setDate(this)\"/>\r\n");
      out.write("  \t\t\t</td>\r\n");
      out.write("  \t    </tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td>估算开始时间</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" name=\"estimateTime\" style=\"width:160px\" onfocus=\"HS_setDate(this)\"/>\r\n");
      out.write("  \t\t\t</td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td>估算结束时间</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("              \t<input type=\"text\" name=\"endTime\" style=\"width:160px\" onfocus=\"HS_setDate(this)\"/>\r\n");
      out.write("             \t\r\n");
      out.write("           </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t    <td>\r\n");
      out.write("  \t\t\t\t<input type=\"submit\" name=\"submit\" value=\" 新  增 \"/>\r\n");
      out.write("  \t\t\t</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("  \t\t\t\t<input type=\"reset\" name=\"reset\" value=\" 清  除 \"/>\r\n");
      out.write("  \t\t\t</td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t</table>\r\n");
      out.write("  \t</form> \t\t\t\r\n");
      out.write("  </body>\r\n");
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
