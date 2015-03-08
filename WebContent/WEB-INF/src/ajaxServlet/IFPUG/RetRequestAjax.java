package ajaxServlet.IFPUG;


import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEifRet;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugIlfRet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.IFPUG.DataFunctionBusiness;

import net.sf.hibernate.HibernateException;



public class RetRequestAjax extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RetRequestAjax() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	    //禁止服务器端缓存，否则会在缓存中取数据，不执行服务器端操作
	    response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);	
		response.setContentType("text/xml;charset=gb2312"); 
		
		int dfId = Integer.valueOf(request.getParameter("dfId")); 
		int type = Integer.valueOf(request.getParameter("type"));	
        DataFunctionBusiness dfb = new DataFunctionBusiness();  //业务层
        Object[] retList = null;
        String value = "";
        if(type == 0){//如果是ILF的RET
        	IfpugIlf ilf = null;
			try {
				ilf = (IfpugIlf)dfb.queryIlfById(dfId);
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	retList = ilf.getIfpugIlfRets().toArray();
        	for(Object e:retList){
        		IfpugIlfRet iir = (IfpugIlfRet)e;
        		value = value+iir.getId()+','+iir.getIlfRetName()+',';	
        	}
        }
        else {
        	IfpugEif eif = null;
			try {
				eif = (IfpugEif)dfb.queryEifById(dfId);
			} catch (HibernateException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	retList = eif.getIfpugEifRets().toArray();
        	for(Object e:retList){
        		IfpugEifRet ier = (IfpugEifRet)e;
        		value = value+ier.getId()+','+ier.getEifRetName()+',';	
        	}
        }
        PrintWriter out = response.getWriter();
     	out.write(value==""?value:value.trim().substring(0,value.length()-1));
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
