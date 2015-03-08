package org.apache.jsp.IFPUG.transaction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.*;
import hibernate.IFPUG.*;

public final class selectFunction_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>选择数据功能</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"/ifpug/images/screen.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t <script language=\"javascript\">\r\n");
      out.write("       var http_request = false;\r\n");
      out.write("       function functionSelectAjax(){    \r\n");
      out.write("\t    if (http_request.readyState == 4) {\r\n");
      out.write("            if (http_request.status == 200) {\r\n");
      out.write("               var dfs = http_request.responseText;\r\n");
      out.write("               while(document.getElementById(\"functionId\").options.length>0){\r\n");
      out.write("                   document.getElementById(\"functionId\").options.remove(0);\r\n");
      out.write("               }\r\n");
      out.write("               if(dfs!=\"\"){\r\n");
      out.write("\t               var funcList = dfs.split(\",\");\r\n");
      out.write("\t                var i =0 ;     \r\n");
      out.write("\t                //在下拉框中增加一个提示按钮“请选择“\r\n");
      out.write("\t                var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                aOption.value=\"\";\r\n");
      out.write("\t                aOption.text = \"=请选择=\";\r\n");
      out.write("\t                document.getElementById(\"functionId\").add(aOption);\r\n");
      out.write("\t                while(i<funcList.length){\r\n");
      out.write("\t                  var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                  aOption.value = funcList[i];\r\n");
      out.write("\t                  aOption.text = funcList[i+1];\r\n");
      out.write("\t                  document.getElementById(\"functionId\").add(aOption);\r\n");
      out.write("\t                  i = i+2;\r\n");
      out.write("\t                }\r\n");
      out.write("                } \r\n");
      out.write("                 else{//如果为空，跳转至添加数据功能页面\r\n");
      out.write("                \talert(\"您尚未添加功能，请先添加功能！\");\r\n");
      out.write("                \twindow.location.href=\"/ifpug/IFPUG/requirement/functionList.jsp?productId=\"+document.epform.productId.value;\r\n");
      out.write("                }          \r\n");
      out.write("            } else {\r\n");
      out.write("                alert('There was a problem with the request.');\r\n");
      out.write("                alert(\"http_request.status:\"+http_request.status);\r\n");
      out.write("            }\r\n");
      out.write("\t     }\r\n");
      out.write("\t    }\r\n");
      out.write("\t    \r\n");
      out.write("\t    \r\n");
      out.write("\t    function epSelectAjax(){    \r\n");
      out.write("\t    if (http_request.readyState == 4) {\r\n");
      out.write("            if (http_request.status == 200) {\r\n");
      out.write("               var eps = http_request.responseText;\r\n");
      out.write("               while(document.getElementById(\"epId\").options.length>0){\r\n");
      out.write("                   document.getElementById(\"epId\").options.remove(0);\r\n");
      out.write("               }\r\n");
      out.write("               if(eps!=\"\"){\r\n");
      out.write("\t               var epList = eps.split(\",\");\r\n");
      out.write("\t                var i =0 ;     \r\n");
      out.write("\t                //在下拉框中增加一个提示按钮“请选择“\r\n");
      out.write("\t                var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                aOption.value=\"\";\r\n");
      out.write("\t                aOption.text = \"=请选择=\";\r\n");
      out.write("\t                document.getElementById(\"epId\").add(aOption);\r\n");
      out.write("\t                while(i<epList.length){\r\n");
      out.write("\t                  var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                  aOption.value = epList[i];\r\n");
      out.write("\t                  aOption.text = epList[i+1];\r\n");
      out.write("\t                  document.getElementById(\"epId\").add(aOption);\r\n");
      out.write("\t                  i = i + 2;\r\n");
      out.write("\t                }\r\n");
      out.write("                } \r\n");
      out.write("                 else{//如果为空，跳转至添加数据功能页面\r\n");
      out.write("                \talert(\"您尚未添加功能，请先添加功能！\");\r\n");
      out.write("                \twindow.location.href=\"/ifpug/IFPUG/requirement/functionList.jsp?productId=\"+document.epform.productId.value;\r\n");
      out.write("                }          \r\n");
      out.write("            } else {\r\n");
      out.write("                alert('There was a problem with the request.');\r\n");
      out.write("                alert(\"http_request.status:\"+http_request.status);\r\n");
      out.write("            }\r\n");
      out.write("\t     }\r\n");
      out.write("\t    }\r\n");
      out.write("\t         \r\n");
      out.write("       function functionHttpRequest(){\r\n");
      out.write("\t       var http_request = creatHttpRequest();\r\n");
      out.write("\t       http_request.onreadystatechange = functionSelectAjax;\r\n");
      out.write("           http_request.open('GET', \"/ifpug/servlet/FunctionRequestAjax?productId=\"+document.epform.productId.value, true);\r\n");
      out.write("           http_request.send(null);     \r\n");
      out.write("       } \r\n");
      out.write("       function epHttpRequest(){\r\n");
      out.write("\t       var http_request = creatHttpRequest();\r\n");
      out.write("\t       http_request.onreadystatechange = epSelectAjax;\r\n");
      out.write("           http_request.open('GET', \"/ifpug/servlet/EpRequestAjax?functionId=\"+document.epform.functionId.value+\"&&epType=\"+document.epform.epType.value, true);\r\n");
      out.write("           http_request.send(null);     \r\n");
      out.write("       }     \r\n");
      out.write("       \r\n");
      out.write("       function creatHttpRequest(){\r\n");
      out.write("\r\n");
      out.write("\t        if (window.XMLHttpRequest) { // Mozilla, Safari,...\r\n");
      out.write("\t            http_request = new XMLHttpRequest();\r\n");
      out.write("\t            if (http_request.overrideMimeType) {\r\n");
      out.write("\t                http_request.overrideMimeType('text/xml');\r\n");
      out.write("\t            }\r\n");
      out.write("\t        } else if (window.ActiveXObject) { // IE\r\n");
      out.write("\t            try {\r\n");
      out.write("\t                http_request = new ActiveXObject(\"Msxml2.XMLHTTP\");\r\n");
      out.write("\t            } catch (e) {\r\n");
      out.write("\t                try {\r\n");
      out.write("\t                    http_request = new ActiveXObject(\"Microsoft.XMLHTTP\");\r\n");
      out.write("\t                } catch (e) {}\r\n");
      out.write("\t            }       \r\n");
      out.write("\t        }\r\n");
      out.write("\t        if (!http_request) {\r\n");
      out.write("\t            alert('Giving up :( Cannot create an XMLHTTP instance');\r\n");
      out.write("\t            return false;\r\n");
      out.write("\t        }\r\n");
      out.write("\t       return http_request;\r\n");
      out.write("       }\r\n");
      out.write("       function verifyInput(){\r\n");
      out.write("       \tvar frm = document.epform;\r\n");
      out.write("       \tif(frm.productId.value==\"\")\r\n");
      out.write("       \t{\r\n");
      out.write("       \t\talert(\"请选择产品！\");\r\n");
      out.write("       \t\tfrm.productId.focus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       \t} \t   \r\n");
      out.write("       \tif(frm.functionId.value==\"\")\r\n");
      out.write("       \t{\r\n");
      out.write("       \t\talert(\"请选择功能模块！\");\r\n");
      out.write("       \t\tfrm.functionId.focus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       \t}\r\n");
      out.write("      /*  if(frm.epId.value==\"\")\r\n");
      out.write("       \t{\r\n");
      out.write("       \t\talert(\"请选择基本流程！\");\r\n");
      out.write("       \t\tfrm.epId.focus();\r\n");
      out.write("       \t\treturn false;\r\n");
      out.write("       \t}*/\r\n");
      out.write("       \t  \r\n");
      out.write("       }\r\n");
      out.write("       function showAction()\r\n");
      out.write("       {\r\n");
      out.write("       \t\tvar frm = document.getElementById(\"epForm\");\r\n");
      out.write("\t\t\tfrm.action=\"/ifpug/IFPUG/transaction/addMethodToEp.jsp?epType=\"+document.epform.epType.value+\"&&functionId=\"+document.epform.functionId.value;\r\n");
      out.write("       }\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  ");
 
     String id = request.getParameter("productId");
     Iterator functionList = null;
     Integer productId = null;
     RequirementBusiness rb = new RequirementBusiness();
     if(id != null &&id.length() != 0) {
     	productId = new Integer(id);
     	/*从数据库中把产品的功能模块信息取出*/
     	IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
     	functionList = product.getIfpugFunctions().iterator();
     }
     else id ="";
    
      /*从数据库中把软件信息取出*/
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
      out.write("  \r\n");
      out.write("     <form name=\"epform\" target=\"epFrame\" method=\"post\" onSubmit=\"return verifyInput();\">        \r\n");
      out.write("       \t<table>\r\n");
      out.write("       \t\t<tr>\r\n");
      out.write("       \t\t\t <td>\r\n");
      out.write("\t                请选择产品\r\n");
      out.write("\t\t\t      \t<select name=\"productId\" id=\"productId\" style=\"width:100px\"  onChange=\"functionHttpRequest();\">\r\n");
      out.write("\t\t\t      \t   <option value=\"\">=请选择=</option>\r\n");
      out.write("\t\t\t      \t   ");

			      	    for(Object p:productList){
		      	        	IfpugProduct fp = (IfpugProduct)p;
      out.write("\r\n");
      out.write("\t\t\t      \t        <option value=\"");
      out.print(fp.getId());
      out.write('"');
      out.write('>');
      out.print(fp.getProductName());
      out.write("</option>\r\n");
      out.write("\t\t\t      \t   ");
}
      out.write(" \t\r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t         </td>\r\n");
      out.write("\t\t         <td>\r\n");
      out.write("\t\t            请选择功能模块\r\n");
      out.write("\t\t\t      \t<select name=\"functionId\" id=\"functionId\" style=\"width:130px\" >\r\n");
      out.write("\t\t\t       \t <option value=\"\">=请选择=</option>\r\n");
      out.write("\t\t\t\t    </select>\t     \r\n");
      out.write("\t\t\t\t</td>\t\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t            筛选事务功能\r\n");
      out.write("\t\t\t      \t<select name=\"epType\" id=\"epType\" style=\"width:80px\">\r\n");
      out.write("\t\t\t       \t <option value=\"\">全部列出</option>\r\n");
      out.write("\t\t\t       \t <option value=\"0\">仅列出EI</option>\r\n");
      out.write("\t\t\t       \t <option value=\"1\">仅列出EO</option>\r\n");
      out.write("\t\t\t       \t <option value=\"2\">仅列出EQ</option>\r\n");
      out.write("\t\t\t\t    </select>\t     \r\n");
      out.write("\t\t\t\t</td>\t\t\t \r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t  <input type=\"submit\" name=\"submit\" onclick=\"showAction();\" value=\"添加估算方法\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("       \t\t</tr>\r\n");
      out.write("       \t</table>\r\n");
      out.write("     </form>\r\n");
      out.write("     <iFrame name=\"epFrame\" frameborder=\"0\" height=\"800px\" width=\"100%\" scrolling=\"no\">\r\n");
      out.write("    </iFrame>\r\n");
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
