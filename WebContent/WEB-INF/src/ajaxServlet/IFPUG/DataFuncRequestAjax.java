package ajaxServlet.IFPUG;

import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugProduct;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import business.IFPUG.DataFunctionBusiness;
import business.IFPUG.RequirementBusiness;

import net.sf.hibernate.HibernateException;


public class DataFuncRequestAjax  extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DataFuncRequestAjax() {
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
		
		int type = Integer.valueOf(request.getParameter("type")); 
		int productId = Integer.valueOf(request.getParameter("productId"));
		RequirementBusiness rb = new RequirementBusiness();
		IfpugProduct product = null;
		try {
			product = (IfpugProduct)rb.getProductById(productId);
		} catch (HibernateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        DataFunctionBusiness dfb = new DataFunctionBusiness();  //业务层，对应于COSMIC方法的策略阶段
    
        Object[] list = null;
		if(type == 0){//如果是ILF类型的文件
			list = product.getIfpugIlfs().toArray();
		}
		else {//如果是EIF类型的文件
			list  = product.getIfpugEifs().toArray();
		}
       
        String value = "";
        for (int i = 0; i < list.length; i ++)
        {
        	if(type == 0){
        		IfpugIlf ii = (IfpugIlf)list[i];
        		if(ii.getUfpMethod()==0) 
        			value = value+ii.getId()+','+ ii.getIlfName()+',';
        	}
        	else {
        		IfpugEif ie = (IfpugEif)list[i];
        		if(ie.getUfpMethod() == 0)
        			value = value+ie.getId()+','+ ie.getEifName()+',';
        	}	
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
