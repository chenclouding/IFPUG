package org.apache.jsp.IFPUG.dataFunction;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import business.IFPUG.*;
import hibernate.IFPUG.*;

public final class addDet_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>添加数据元素</title>\r\n");
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
      out.write("       function dataFuncSelectAjax(){    \r\n");
      out.write("\t    if (http_request.readyState == 4) {\r\n");
      out.write("            if (http_request.status == 200) {\r\n");
      out.write("               var dfs = http_request.responseText;\r\n");
      out.write("               \r\n");
      out.write("               while(document.getElementById(\"dfId\").options.length>0){\r\n");
      out.write("                   document.getElementById(\"dfId\").options.remove(0);\r\n");
      out.write("               }\r\n");
      out.write("               if(dfs!=\"\"){\r\n");
      out.write("\t               var dfList = dfs.split(\",\");\r\n");
      out.write("\t                var i =0 ;     \r\n");
      out.write("\t                //在下拉框中增加一个提示按钮“请选择“\r\n");
      out.write("\t                var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                aOption.value=\"\";\r\n");
      out.write("\t                aOption.text = \"=请选择=\";\r\n");
      out.write("\t                document.getElementById(\"dfId\").add(aOption);\r\n");
      out.write("\t                while(i<dfList.length){\r\n");
      out.write("\t                  var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                  aOption.value = dfList[i];\r\n");
      out.write("\t                  aOption.text = dfList[i+1];\r\n");
      out.write("\t                  document.getElementById(\"dfId\").add(aOption);\r\n");
      out.write("\t                  i = i+2;\r\n");
      out.write("\t                }\r\n");
      out.write("                }  \r\n");
      out.write("                else{//如果为空，跳转至添加数据功能页面\r\n");
      out.write("                \talert(\"您尚未添加数据功能，请先添加数据功能！\");\r\n");
      out.write("                \twindow.location.href=\"/ifpug/IFPUG/dataFunction/addDataFunction.jsp\";\r\n");
      out.write("                }          \r\n");
      out.write("            } else {\r\n");
      out.write("                alert('There was a problem with the request.');\r\n");
      out.write("                alert(\"http_request.status:\"+http_request.status);\r\n");
      out.write("            }\r\n");
      out.write("\t     }\r\n");
      out.write("\t    }     \r\n");
      out.write("       function retSelectAjax(){    \r\n");
      out.write("\t    if (http_request.readyState == 4) {\r\n");
      out.write("            if (http_request.status == 200) {\r\n");
      out.write("               var rets = http_request.responseText;\r\n");
      out.write("               while(document.getElementById(\"retId\").options.length>0){\r\n");
      out.write("                   document.getElementById(\"retId\").options.remove(0);\r\n");
      out.write("               }\r\n");
      out.write("               //在下拉框中增加一个默认选项，DET将添加到retId为-1的RET中\r\n");
      out.write("\t           var aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t           aOption.value = \"-\"+document.getElementById(\"dfId\").value;//设定retId=-dfId;\r\n");
      out.write("\t           aOption.text = \"默认\";\r\n");
      out.write("\t           document.getElementById(\"retId\").add(aOption);\r\n");
      out.write("               if(rets!=\"\"){\r\n");
      out.write("\t               var retList = rets.split(\",\");\r\n");
      out.write("\t                var i =0 ;\r\n");
      out.write("\t                while(i<retList.length&&retList[i+1]!=\"default\"){\r\n");
      out.write("\t                  aOption = document.createElement(\"OPTION\");\r\n");
      out.write("\t                  aOption.value = retList[i];\r\n");
      out.write("\t                  aOption.text = retList[i+1];\r\n");
      out.write("\t                  document.getElementById(\"retId\").add(aOption);\r\n");
      out.write("\t                  i = i+2;\r\n");
      out.write("\t                }\r\n");
      out.write("\t                \r\n");
      out.write("               }    \r\n");
      out.write("            } else {\r\n");
      out.write("                alert('There was a problem with the request.');\r\n");
      out.write("                alert(\"http_request.status:\"+http_request.status);\r\n");
      out.write("            }\r\n");
      out.write("\t     }\r\n");
      out.write("\t    }   \r\n");
      out.write("       \r\n");
      out.write("       function dataFuncHttpRequest(){\r\n");
      out.write("\t       var http_request = creatHttpRequest();\r\n");
      out.write("\t       http_request.onreadystatechange = dataFuncSelectAjax;\r\n");
      out.write("           http_request.open('GET', \"/ifpug/servlet/DataFuncRequestAjax?type=\"+document.detform.type.value+\"&&productId=\"+document.detform.productId.value, true);\r\n");
      out.write("           http_request.send(null);     \r\n");
      out.write("       }\r\n");
      out.write("      function retHttpRequest(){\r\n");
      out.write("\t       var http_request = creatHttpRequest();\r\n");
      out.write("\t       http_request.onreadystatechange = retSelectAjax;\r\n");
      out.write("           http_request.open('GET', \"/ifpug/servlet/RetRequestAjax?dfId=\"+document.detform.dfId.value+\"&type=\"+document.detform.type.value, true);\r\n");
      out.write("           http_request.send(null);     \r\n");
      out.write("       }\r\n");
      out.write("       \r\n");
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
      out.write("       \t\tvar frm = document.detform;\r\n");
      out.write("       \t\tif(frm.type.value==\"\")\r\n");
      out.write("       \t\t{\r\n");
      out.write("       \t\t\talert(\"请选择文件类型！\");\r\n");
      out.write("       \t\t\tfrm.type.focus();\r\n");
      out.write("       \t\t\treturn false;\r\n");
      out.write("       \t\t} \t   \r\n");
      out.write("       \t\tif(frm.dfId.value==\"\")\r\n");
      out.write("       \t\t{\r\n");
      out.write("       \t\t\talert(\"请选择数据文件！\");\r\n");
      out.write("       \t\t\tfrm.dfId.focus();\r\n");
      out.write("       \t\t\treturn false;\r\n");
      out.write("       \t\t}\r\n");
      out.write("       \t\tif(frm.retId.value==\"\")\r\n");
      out.write("       \t\t{\r\n");
      out.write("       \t\t\talert(\"请选择记录元素！\");\r\n");
      out.write("       \t\t\tfrm.retId.focus();\r\n");
      out.write("       \t\t\treturn false;\r\n");
      out.write("       \t\t}\r\n");
      out.write("       }\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>  \r\n");
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
      } 

   
      out.write("\r\n");
      out.write("      <form name=\"detform\" action=\"/ifpug/IFPUG/dataFunction/detList.jsp\"   method=\"post\" target=\"detFrame\" onSubmit=\"return verifyInput();\" >\r\n");
      out.write("         <table>\r\n");
      out.write("         \t <tr> \r\n");
      out.write("         \t <td>\r\n");
      out.write("\t                请选择产品\r\n");
      out.write("\t\t\t      \t<select name=\"productId\" id=\"productId\" style=\"width:100px\">\r\n");
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
      out.write("              <td>\r\n");
      out.write("\t                请选择文件类型\r\n");
      out.write("\t\t\t      \t<select name=\"type\" id=\"type\" style=\"width:100px\" onChange=\"dataFuncHttpRequest();\">\r\n");
      out.write("\t\t\t      \t   <option value=\"\">=请选择=</option>\r\n");
      out.write("\t\t\t      \t   <option value=\"0\">ILF</option>\r\n");
      out.write("\t\t\t      \t   <option value=\"1\">EIF</option>\t \r\n");
      out.write("\t\t\t\t    </select>\r\n");
      out.write("\t\t        </td>\r\n");
      out.write("\t\t         <td>\r\n");
      out.write("\t\t            请选择文件名称\r\n");
      out.write("\t\t\t      \t<select name=\"dfId\" id=\"dfId\" style=\"width:100px\" onChange=\"retHttpRequest();\">\t\r\n");
      out.write("\t\t\t        \t<option value=\"\">=请选择=</option>\r\n");
      out.write("\t\t\t\t    </select>   \r\n");
      out.write("\t\t\t\t</td>\t\t\r\n");
      out.write("\t\t         <td>\r\n");
      out.write("\t\t            请选择记录元素\r\n");
      out.write("\t\t\t      \t<select name=\"retId\" id=\"retId\" style=\"width:100px\">\t\r\n");
      out.write("\t\t\t      \t<option value=\"\">=请选择=</option>\r\n");
      out.write("\t\t\t      \t\r\n");
      out.write("\t\t\t\t    </select>\t     \r\n");
      out.write("\t\t\t\t</td>\t \r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t  <input type=\"submit\" name=\"submit\" value=\"增加数据元素\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("   \t\t</table>\r\n");
      out.write("     </form>\r\n");
      out.write("    <iFrame name=\"detFrame\" frameborder=\"0\" height=\"800px\" width=\"100%\" scrolling=\"no\">\r\n");
      out.write("    </iFrame>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
