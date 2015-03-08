package ajaxServlet.IFPUG;

import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugIlfRet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import business.IFPUG.DataFunctionBusiness;
import business.IFPUG.UfpCountBusiness;

public class UfpCount extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UfpCount() {
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
		
		//从retList页面获取type和Id
		int fileType = Integer.valueOf(request.getParameter("fileType")); 
		int fileId = Integer.valueOf(request.getParameter("fileId"));
		int retCount = 0;
		int detCount = 0;
		int ufpComplex = 0;
		int ufpCount = 0; //功能点个数
		
		DataFunctionBusiness dfb = new DataFunctionBusiness();
		IfpugIlf ilf = null;
		try {
			ilf = (IfpugIlf)dfb.queryIlfById(fileId);	
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//获取file的ret个数和det个数
		Set rets = ilf.getIfpugIlfRets(); 
		retCount = rets.size();
		for(Object obj:rets){
			IfpugIlfRet iir = (IfpugIlfRet)obj;
			Set dets = iir.getIfpugIlfDets();
			detCount += dets.size();
		}
		
		//计算功能点个数
		UfpCountBusiness ucb = new UfpCountBusiness();
		ufpComplex = ucb.getComplex_valueMethod(detCount, retCount,0);
		ufpCount = ucb.getUfpCount(ufpComplex, fileType);
		
		//保存功能点个数到数据库表IfpugIlf
		ilf.setUfpCount(ufpCount);
		try {
			dfb.updateDataFunction(ilf);
		} catch (HibernateException e) {
			e.printStackTrace();
		}

		PrintWriter out = response.getWriter();
		out.print(ufpCount);
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
