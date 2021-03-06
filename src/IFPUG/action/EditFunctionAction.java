/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import java.io.UnsupportedEncodingException;

import hibernate.IFPUG.IfpugFunction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.RequirementBusiness;
import struts.IFPUG.form.FunctionForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-18-2010
 * 
 * XDoclet definition:
 * @struts.action path="/editFunction" name="functionForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/requirement/functionList.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class EditFunctionAction extends Action {
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
	 * @throws UnsupportedEncodingException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HibernateException, UnsupportedEncodingException {
		FunctionForm functionForm = (FunctionForm) form;// TODO Auto-generated method stub
		RequirementBusiness rb = new RequirementBusiness();//业务层函数,对数据组进行增删改查等操作
		IfpugFunction ifi;          //定义实体bean

		/*将id为dataGroupId的实体bean查找出来*/
		Integer functionId = new Integer(functionForm.getId());
		ifi = (IfpugFunction)rb.getFunctionById(functionId);
		/*从form表单中获取数据组信息,更新实体Bean*/
		ifi.setMeasureStatus(Short.valueOf(functionForm.getMeasureStatus()));
		//ifi.setUfpCount(new Integer(functionForm.getUpfCount().toString()));
		ifi.setFunctionDesp(new String(functionForm.getFunctionDesp().getBytes("ISO-8859-1"),"GB2312"));
		ifi.setFunctionName(new String(functionForm.getFunctionName().getBytes("ISO-8859-1"),"GB2312"));
		ifi.setFunctionType(Short.valueOf(functionForm.getFunctionType()));
		ifi.setMeasureStatus(Short.valueOf(functionForm.getMeasureStatus()));
		
		boolean result = rb.updateProduct(ifi);
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}