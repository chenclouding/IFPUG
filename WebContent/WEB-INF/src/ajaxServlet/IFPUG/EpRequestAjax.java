package ajaxServlet.IFPUG;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugFunction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;
import business.IFPUG.RequirementBusiness;

public class EpRequestAjax extends HttpServlet{
	/**
	 * Constructor of the object.
	 */
	public EpRequestAjax() {
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
		PrintWriter out = response.getWriter();
		int functionId = Integer.valueOf(request.getParameter("functionId")); 
		int epType = Integer.valueOf(request.getParameter("epType")); 
        RequirementBusiness rb = new RequirementBusiness();  //
        IfpugFunction function = null;
		try {
			function = (IfpugFunction)rb.getFunctionById(functionId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator it = null;
		String value = "";
		switch(epType)
		{
		case 0:
			it = function.getIfpugEis().iterator(); 
		    while(it.hasNext()){
	        	IfpugEi ei = (IfpugEi)it.next();
	        	value = value+ei.getId()+','+ei.getEiName()+',';	
	     	}
			break;
		case 1:
			it = function.getIfpugEos().iterator();  
			while(it.hasNext()){
		        IfpugEo eo = (IfpugEo)it.next();
		        value = value+eo.getId()+','+eo.getEoName()+',';	
		     }
			break;
		case 2:
			it = function.getIfpugEqs().iterator(); 
			while(it.hasNext()){
		        IfpugEq eq = (IfpugEq)it.next();
		        value = value+eq.getId()+','+eq.getEqName()+',';	
		     }
			break;
			
		}
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
