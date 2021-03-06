/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import java.io.UnsupportedEncodingException;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugFunction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.RequirementBusiness;
import struts.IFPUG.form.ElementaryProcessForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-24-2010
 * 
 * XDoclet definition:
 * @struts.action path="/addElementaryProcess" name="elementaryProcessForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/requirement/elementaryProcessList.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class AddElementaryProcessAction extends Action {
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
		ElementaryProcessForm elementaryProcessForm = (ElementaryProcessForm) form;// TODO Auto-generated method stub
		RequirementBusiness rb = new RequirementBusiness();
		
		//获取childFunctionList.jsp页面传过来的functionI
		Integer functionId = new Integer(elementaryProcessForm.getId());
		IfpugFunction ifpugFunction =(IfpugFunction)rb.getFunctionById(functionId);
		boolean result = false;
		//根据TYPE不同，将记录插入不同的数据库表
		Short type = Short.valueOf(elementaryProcessForm.getEpType());
		
		
		switch(type){
			case 0: 
				IfpugEi ei = new IfpugEi();
				ei.setEiName(new String(elementaryProcessForm.getEpName().getBytes("ISO-8859-1"),"GB2312"));
				ei.setEiDesp(new String(elementaryProcessForm.getEpDesp().getBytes("ISO-8859-1"),"GB2312"));
				ei.setEpType(type);
				ei.setMeasureStatus(Short.valueOf("0"));
				ei.setUfpMethod(Short.valueOf("5"));
				ei.setIfpugFunction(ifpugFunction);
				result = rb.insertElementaryProcess(ei);
				break;
			case 1:
				IfpugEo eo = new IfpugEo();
				eo.setEoName(new String(elementaryProcessForm.getEpName().getBytes("ISO-8859-1"),"GB2312"));
				eo.setEoDesp(new String(elementaryProcessForm.getEpDesp().getBytes("ISO-8859-1"),"GB2312"));
				eo.setEpType(type);
				eo.setMeasureStatus(Short.valueOf("0"));
				eo.setUfpMethod(Short.valueOf("5"));
				eo.setIfpugFunction(ifpugFunction);
				result = rb.insertElementaryProcess(eo);
				break;
			case 2:
				IfpugEq eq = new IfpugEq();
				eq.setEqName(new String(elementaryProcessForm.getEpName().getBytes("ISO-8859-1"),"GB2312"));
				eq.setEqDesp(new String(elementaryProcessForm.getEpDesp().getBytes("ISO-8859-1"),"GB2312"));
				eq.setEpType(type);
				eq.setMeasureStatus(Short.valueOf("0"));
				eq.setUfpMethod(Short.valueOf("5"));
				eq.setIfpugFunction(ifpugFunction);
				result = rb.insertElementaryProcess(eq);
				break;
		}
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}