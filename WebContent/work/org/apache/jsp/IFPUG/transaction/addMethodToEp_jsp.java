package org.apache.jsp.IFPUG.transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.RequirementBusiness;
import business.IFPUG.TransactionFunctionBusiness;
import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;

public final class addMethodToEp_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>修改基本流程</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/ifpug/images/screen.css\">\t\r\n");
      out.write("\t<script language=\"javascript\"> \r\n");
      out.write("\tfunction setValue(obj)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar option = obj.options;\r\n");
      out.write("\t\tfor(j=0;j<option.length;j++)\r\n");
      out.write("\t\t{\t if(option[j].selected)\r\n");
      out.write("   \t\t\t\tdocument.getElementById('ufpMethod').value = option[j].value;\r\n");
      out.write("\t\t} \r\n");
      out.write("\t}\r\n");
      out.write("   function changePage(epId,type,functionId,epType)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar method = document.getElementById('ufpMethod').value;\r\n");
      out.write("\t\tif(method==\"\"||method==\"5\"){\r\n");
      out.write("\t\t\talert(\"您尚未选择估算方法！\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse window.location.href=\"/ifpug/IFPUG/transaction/saveEpMethod.jsp?ufpMethod=\"+document.getElementById('ufpMethod').value+\"&&epId=\"+epId+\"&&epType=\"+epType+\"&&type=\"+type+\"&&functionId=\"+functionId;\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction confirmdel(){\r\n");
      out.write("    \treturn confirm(\"确定删除？\");\r\n");
      out.write("    }\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("   ");
 
  	  Integer functionId = Integer.valueOf(request.getParameter("functionId"));
   	  String epType = request.getParameter("epType");
	  RequirementBusiness rb = new RequirementBusiness();//业务层函数，封装了数据组进行的增删改查等操作 
	  IfpugFunction function = (IfpugFunction)rb.getFunctionById(functionId);
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <h1>功能模块");
      out.print( function.getFunctionName());
      out.write("的基本流程列表：<font color=\"red\">估算方法选择“手动导入DET”不能修改</font></h1>\r\n");
      out.write("    <form name=\"epListForm\">\r\n");
      out.write("      <table>\r\n");
      out.write("       <tr>\r\n");
      out.write("         <td>序号</td> \r\n");
      out.write("         <td>流程名称</td>\r\n");
      out.write("         <td>估算方法</td>\r\n");
      out.write("         <td>查看</td>\r\n");
      out.write("         <td>修改</td>\r\n");
      out.write("         <td>删除</td>\r\n");
      out.write("         <td>开始估算</td>\r\n");
      out.write("       </tr>\r\n");
      out.write("       ");
 
       /*分别先取出功能模块对应的EI、EO、EQ类型基本流程*/
       Object[] eiList = function.getIfpugEis().toArray();
       Object[] eoList = function.getIfpugEos().toArray();
       List list = rb.getEpAfterMerge(function);
       IfpugEi ei;
       IfpugEo eo;
       IfpugEq eq;
       TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
       /*若无功能信息，提示添加；若有功能信息，列出估算功能列表*/
       if(list == null||list.size() == 0){
      out.write("  \r\n");
      out.write("       <h1 style=\"color:red\">目前无基本流程，请添加流程</h1>\r\n");
      out.write("       ");
}else{ 
       		 Integer i = 0,j = 0, k = 0, len = list.size();
       		 Integer len_ei = eiList.length;
       		 Integer len_eo = eoList.length;
       		 Integer id = 0;
       		 String name = null;
       		 String type = null;
       		 Integer typeId = -1;
       		 String ufpMethodName = null;
       		 Short ufpMethod;
       		 if(epType != null && epType.length()!= 0)
       		 {
       		 	 if(epType.equals("0")) { len = len_ei; }
       		 	 else if (epType.equals("1")) { k = len_ei; len = len_ei+len_eo; }
       		 	 else if (epType.equals("2")) k = len_ei+len_eo;
       		 }
       		 /*判断EI\EO\EQ，根据类型不同，获取id,name*/
       		 for (j = k; j < list.size()&&j < len; j ++){
       	   	    Object e = list.get(j);
       	   	 	if (j < len_ei){
       	   	 		ei = (IfpugEi)e; 
       	   	 		id = ei.getId();  
       	   	 		name = ei.getEiName();
       	   	 		ufpMethod = ei.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EI";
       	   	 		typeId = 0;
       	   	 		
       	   	 	}
       	   	 	else if (j >= len_ei&& j < (len_ei+len_eo)){
       	   	 		eo = (IfpugEo) e;
       	   	 		id = eo.getId();
       	   	 		name = eo.getEoName();
       	   	 		ufpMethod = eo.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EO";
       	   	 		typeId = 1;
       	   	 	}
       	   	 	else {
       	   	 		eq = (IfpugEq) e;
       	   	 		id = eq.getId();
       	   	 		name = eq.getEqName();
       	   	 		ufpMethod = eq.getUfpMethod();
       	   	 		ufpMethodName = tfb.getEpMethodNameById(ufpMethod);
       	   	 		type = "EQ";
       	   	 		typeId = 2;
       	   	 	}
       	   	 		/*下段用于表格中添加属性选择不同的链接*/
             	/*如果是“手动添加”，跳转至添加记录元素页面retList.jsp*/
             	/*如果是其他方法，跳转至directMethod.jsp页面*/
             	String linkAddr = null;
             	String linkName = null;
             	if(ufpMethod == 5)
             	{
             		linkName = "";
             	}
                else if(ufpMethod == 0){
             		linkAddr = "/ifpug/IFPUG/transaction/derivedMethod.jsp?ufpMethod=";
             		linkName = "手动添加FTR";
             	}
             	else {
             		linkAddr = "/ifpug/IFPUG/transaction/directMethod.jsp?ufpMethod=";
             		linkName = "输入FTR个数";
             	}
             	
      out.write("\r\n");
      out.write("             <tr>\r\n");
      out.write("\t          <td>");
      out.print( ++ i );
      out.write("</td> \r\n");
      out.write("\t          <td>");
      out.print( name );
      out.write("</td>\r\n");
      out.write("\t          <td>\r\n");
      out.write("\t         \t <select name=\"method");
      out.print(i);
      out.write("\"  id =\"method");
      out.print(i);
      out.write("\"  onchange=\"setValue(method");
      out.print(i);
      out.write(")\" >\r\n");
      out.write("  \t\t\t \t    <!--0代表 derived，1代表default，2代表range,3代表value -->\r\n");
      out.write("  \t\t\t \t    <option style=\"color:red\" value=\"5\">=请选择=</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"0\">手动导入DET</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"1\">默认功能点个数</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"2\">选择DET范围</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"3\">输入DET个数</option>\r\n");
      out.write("  \t\t\t\t\t<option value=\"4\">选择复杂度</option>\r\n");
      out.write("  \t\t\t\t</select>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" name=\"ufpMethod\" id=\"ufpMethod\"  style=\"display:none\"/>\r\n");
      out.write("  \t\t\t\t<input type=\"button\" id=\"submit");
      out.print(i);
      out.write("\" onclick=\"changePage(");
      out.print(id);
      out.write(',');
      out.print(typeId);
      out.write(',');
      out.print(functionId);
      out.write(',');
      out.write('\'');
      out.print(epType);
      out.write("')\" value=\" 确定 \" />\r\n");
      out.write("  \t\t\t\t<script language=\"javascript\"> \r\n");
      out.write("  \t\t\t\t\tvar button");
      out.print(i);
      out.write(" ;\r\n");
      out.write("  \t\t\t\t\tvar method");
      out.print(i);
      out.write(";\r\n");
      out.write("  \t\t\t\t\tbutton");
      out.print(i);
      out.write(" = document.getElementById('submit");
      out.print(i);
      out.write("');\r\n");
      out.write("  \t\t\t\t\tmethod");
      out.print(i);
      out.write(" = document.getElementById('method");
      out.print(i);
      out.write("');\r\n");
      out.write("  \t\t\t\t\tmethod");
      out.print(i);
      out.write(".value = ");
      out.print(ufpMethod);
      out.write(";\r\n");
      out.write("  \t\t\t\t\tif(method");
      out.print(i);
      out.write(".value == \"5\"){ //如果还未添加估算方法\r\n");
      out.write("  \t\t\t\t\t\tbutton");
      out.print(i);
      out.write(".style.display='';\r\n");
      out.write("  \t\t\t\t\t\tdocument.getElementById('method");
      out.print(i);
      out.write("').disabled= false;\r\n");
      out.write("  \t\t\t\t\t}\r\n");
      out.write("  \t\t\t\t\telse {\r\n");
      out.write("  \t\t\t\t\t\tbutton");
      out.print(i);
      out.write(".style.display='none';\r\n");
      out.write("  \t\t\t\t\t\tdocument.getElementById('method");
      out.print(i);
      out.write("').disabled= true;\r\n");
      out.write("  \t\t\t\t\t}\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("  \t\t\t\t\t\r\n");
      out.write("                </script>  \r\n");
      out.write("       \t\t\t<input type=\"hidden\" name=\"id\" value=\"");
      out.print(id);
      out.write("\"/>\r\n");
      out.write("    \t\t\t<input type=\"hidden\" name=\"epId\" value=\"");
      out.print(id);
      out.write("\"/>\r\n");
      out.write("    \t\t\t<input type=\"hidden\" name=\"functionId\" value=\"");
      out.print(functionId);
      out.write("\"/>\r\n");
      out.write("  \t\t\t\t<input type=\"hidden\" name=\"epType\" value=\"");
      out.print(epType);
      out.write("\"/>\r\n");
      out.write("  \t\t\t\t<input type=\"hidden\" name=\"type\" value=\"");
      out.print(typeId);
      out.write("\"/>\r\n");
      out.write("\t          </td>\r\n");
      out.write("\t          <td class = checkimg>\r\n");
      out.write("\t          \t  <a href=\"/ifpug/IFPUG/transaction/viewElementaryProcess.jsp?epId=");
      out.print(id);
      out.write("&&type=");
      out.print(typeId);
      out.write("&&epType=");
      out.print(epType);
      out.write("\">\r\n");
      out.write("\t              \t  <IMG src=\"/ifpug/images/btncheck.gif\" alt=\"点击查看\" border=\"0\" />\r\n");
      out.write("\t              </a>\r\n");
      out.write("\t          </td>\t\r\n");
      out.write("\t\t      <td class = editimg>\r\n");
      out.write("\t\t          <a href=\"/ifpug/IFPUG/transaction/editElementaryProcess.jsp?epId=");
      out.print(id);
      out.write("&&type=");
      out.print(typeId);
      out.write("&&epType=");
      out.print(epType);
      out.write("\">\r\n");
      out.write("\t\t          \t <IMG src=\"/ifpug/images/btnedit.gif\" alt=\"点击修改\" border=\"0\" />\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t\t      <td class = delimg>\r\n");
      out.write("\t\t          <a href=\"/ifpug/IFPUG/transaction/delElementaryProcess.jsp?epId=");
      out.print(id);
      out.write("&&type=");
      out.print(typeId);
      out.write("&&epType=");
      out.print(epType);
      out.write("\" onclick=\"return confirmdel()\">\r\n");
      out.write("\t\t             <img src=\"/ifpug/images/btndel.gif\" alt=\"点击删除\" width=\"15\" height=\"12\" border=\"0\" />\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t\t      <td>\r\n");
      out.write("\t\t       <a href=\"Javascript:window.location='");
      out.print(linkAddr);
      out.print(ufpMethod);
      out.write("&&type=");
      out.print(typeId);
      out.write("&&epId=");
      out.print(id);
      out.write("&&epType=");
      out.print(epType);
      out.write("'\"/>");
      out.print(linkName);
      out.write("\r\n");
      out.write("\t\t\t   </a>\r\n");
      out.write("\t\t      </td>\r\n");
      out.write("\t         </tr>  \r\n");
      out.write("          ");
}
       }
      out.write("  \r\n");
      out.write("       </table> \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("    </form>\t\t\r\n");
      out.write(" </body>\r\n");
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
