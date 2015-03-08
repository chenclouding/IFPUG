package org.apache.jsp.IFPUG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.RequirementBusiness;
import business.IFPUG.MeasureReport;
import hibernate.IFPUG.IfpugProduct;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;

public final class adjustUfp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>调整功能点个数</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/ifpug/images/screen.css\">\r\n");
      out.write("\t<script language=\"javascript\">\r\n");
      out.write("\tfunction countFp(c,productId)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar e1 = parseFloat(document.getElementById(\"e1\").value);\r\n");
      out.write("\t\tvar e2 = parseFloat(document.getElementById(\"e2\").value);\r\n");
      out.write("\t\tvar e3 = parseFloat(document.getElementById(\"e3\").value);\r\n");
      out.write("\t\tvar e4 = parseFloat(document.getElementById(\"e4\").value);\r\n");
      out.write("\t\tvar e5 = parseFloat(document.getElementById(\"e5\").value);\r\n");
      out.write("\t\tvar e6 = parseFloat(document.getElementById(\"e6\").value);\r\n");
      out.write("\t\tvar e7 = parseFloat(document.getElementById(\"e7\").value);\r\n");
      out.write("\t\tvar e8 = parseFloat(document.getElementById(\"e8\").value);\r\n");
      out.write("\t\tvar e9 = parseFloat(document.getElementById(\"e9\").value);\r\n");
      out.write("\t\tvar ea = parseFloat(document.getElementById(\"e10\").value);\r\n");
      out.write("\t\tvar eb = parseFloat(document.getElementById(\"e11\").value);\r\n");
      out.write("\t\tvar ec = parseFloat(document.getElementById(\"e12\").value);\r\n");
      out.write("\t\tvar ed = parseFloat(document.getElementById(\"e13\").value);\r\n");
      out.write("\t\tvar ee = parseFloat(document.getElementById(\"e14\").value);\r\n");
      out.write("\t\tvar s = e1+e2+e3+e4+e5+e6+e7+e8+e9+ea+eb+ec+ed+ee;\r\n");
      out.write("\t\tvar vaf = parseInt((0.01 * s+0.65)*100)/100;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(document.getElementById('fptd').display='')  document.getElementById('fptd').display= 'none';\r\n");
      out.write("\t\telse document.getElementById('fptd').display = '';\r\n");
      out.write("\t\twindow.location=\"/ifpug/IFPUG/saveFpc.jsp?tcf=\"+vaf+\"&fpc=\"+vaf*c+\"&productId=\"+productId;\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  ");

   String tcf = request.getParameter("tcf");
   String fpc = request.getParameter("fpc");
   if(tcf == null) tcf ="0";
   if(fpc == null) fpc ="0";
   Integer productId = new Integer(request.getParameter("productId"));
   RequirementBusiness rb = new RequirementBusiness();
   IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
   Object[] ilfList = product.getIfpugIlfs().toArray();
   Object[] eifList = product.getIfpugEifs().toArray();
   Object[] functionList = product.getIfpugFunctions().toArray();
   
   Integer dfp = 0, tfp = 0, ufpc = 0;
   if(ilfList != null && ilfList.length != 0)
   {
   		for(Object i:ilfList)
   		{
   			IfpugIlf ilf = (IfpugIlf)i;
   			dfp += ilf.getUfpCount();
   		}
   }
   if(eifList != null && eifList.length != 0)
   {
   		for(Object e:eifList)
   		{
   			IfpugEif eif = (IfpugEif)e;
   			dfp += eif.getUfpCount();
   		}
   }
   
   MeasureReport mr = new MeasureReport();
   if(functionList != null&&functionList.length != 0)
   {
   		for (Object f:functionList)
   		{
   			mr.getEpFromFunction(f);
   		}
   }
   List eiList = mr.eiList;
   List eoList = mr.eoList;
   List eqList = mr.eqList;
   
   if(eiList!=null&&eiList.size()!=0)
   {
   		for(Object o:eiList)
   		{
   			IfpugEi ei = (IfpugEi)o;
   			tfp += ei.getUfpCount();
   		}
   } 
   if(eoList!=null&&eoList.size()!=0)
   {
   		for(Object o:eoList)
   		{
   			IfpugEo eo = (IfpugEo)o;
   			tfp += eo.getUfpCount();
   		}
   } 
   if(eqList!=null&&eqList.size()!=0)
   {
   		for(Object o:eqList)
   		{
   			IfpugEq eq = (IfpugEq)o;
   			tfp += eq.getUfpCount();
   		}
   } 
   
   ufpc = dfp + tfp;
   
      out.write("\r\n");
      out.write("     <h1>调整因子(技术复杂度因子)</h1>  \r\n");
      out.write("     <span>(各个复杂度参数的取值范围从0到5，表示该项对功能点总数的影响从没有到极高。)</span>\r\n");
      out.write("     <form  name=\"vafForm\">\r\n");
      out.write("     <table  style=\"width:720px\">\r\n");
      out.write("     <tr><td style=\"width:350px\">\r\n");
      out.write("  \t <table>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">数据通讯</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e1\" id=\"e1\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">软件性能</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e2\" id=\"e2\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">可配置性</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e3\" id=\"e3\"style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">事务效率</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e4\" id=\"e4\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">实时数据输入</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e5\" id=\"e5\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">用户界面复杂度</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e6\" id=\"e6\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">在线升级</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e7\" id=\"e7\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">复杂运算</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e8\" id=\"e8\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">代码复用性</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e9\" id=\"e9\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">安装简易性</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e10\" id=\"e10\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">操作方便性</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e11\" id=\"e11\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">跨平台要求</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e12\" id=\"e12\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">可扩展性</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e13\" id=\"e13\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"40%\">分布式数据处理</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t    <select name=\"e14\" id=\"e14\" style=\"width:80px\">\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\" selected>0</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">1</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">2</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">3</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">4</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"5\">5</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>  \t\t\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t    <td>\r\n");
      out.write("  \t\t\t\t<input type=\"button\" name=\"submit\" value=\" 确  定 \" onclick=\"return countFp(");
      out.print(ufpc);
      out.write(',');
      out.print(productId );
      out.write(");\"/>\r\n");
      out.write("  \t\t\t</td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t</table>\r\n");
      out.write("    </td>\r\n");
      out.write("    <td id=\"fptd\" style=\"width:400px\" valign=\"top\">\r\n");
      out.write("    <h1>调整因子调整</h1>\r\n");
      out.write("  \t<table>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"35%\">数据功能点个数</td>\r\n");
      out.write("  \t\t\t<td> \r\n");
      out.write("  \t\t\t\t");
      out.print(dfp );
      out.write("\r\n");
      out.write("  \t\t\t </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"35%\">事务功能点个数</td>\r\n");
      out.write("  \t\t\t<td>\r\n");
      out.write("  \t\t\t\t");
      out.print(tfp );
      out.write("\t\t    \r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"35%\">未调整功能点个数</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t   ");
      out.print( ufpc );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"35%\">技术复杂度因子</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t   ");
      out.print(tcf );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t\t<tr>\r\n");
      out.write("  \t\t\t<td width=\"35%\">调整后功能点个数</td>\r\n");
      out.write("  \t\t\t<td >\r\n");
      out.write("  \t\t\t   ");
      out.print( fpc );
      out.write("\r\n");
      out.write("            </td>\r\n");
      out.write("  \t\t</tr>\r\n");
      out.write("  \t</table>\r\n");
      out.write("  \t</td>\r\n");
      out.write("  \t</tr>\r\n");
      out.write("  \t</table>\r\n");
      out.write("  \t<input type=\"hidden\" name=\"productId\" value=\"");
      out.print(productId);
      out.write("\"/>\r\n");
      out.write("  \t</form> \t\r\n");
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
