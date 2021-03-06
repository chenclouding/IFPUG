/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;


import java.io.IOException;

import hibernate.IFPUG.IfpugUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import business.IFPUG.UserBusiness;
import struts.IFPUG.form.UserForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-16-2011
 * 
 * XDoclet definition:
 * @struts.action path="/register" name="userForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/ifpug.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class RegisterAction extends Action {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 * @throws HibernateException 
	 * @throws IOException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HibernateException, IOException {
		UserForm userForm = (UserForm) form;// TODO Auto-generated method stub
		IfpugUser user = new IfpugUser();
		
		user.setUsername(userForm.getUsername());
		user.setPassword(userForm.getPassword());
		
		UserBusiness ub = new UserBusiness();
		boolean result = false;
		if(ub.getUserByUserName(userForm.getUsername())==null)
		{
			result = ub.insertUser(user);
			if(result==true){	
				request.getSession().setAttribute("userName", userForm.getUsername());
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().print(
		        "<script>alert('注册成功!');location.href='/ifpug/IFPUG/ifpug.jsp'</script>");
				return null;
			}
			else{
				response.setContentType("text/html;charset=UTF-8"); 
				response.getWriter().print(
		        "<script>alert('注册成功!');location.href='/ifpug/IFPUG/user/register.jsp'</script>");
				return null;
			}
		}
		else {
			response.setContentType("text/html;charset=UTF-8"); 
			response.getWriter().print(
	        "<script>alert('此用户名已经存在!');location.href='/ifpug/IFPUG/user/register.jsp'</script>");
			return null;
			
		}
		
	    
		
		
	}
}