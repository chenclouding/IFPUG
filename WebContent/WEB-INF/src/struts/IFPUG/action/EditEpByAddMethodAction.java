
/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.RequirementBusiness;
import struts.IFPUG.form.ElementaryProcessForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-26-2010
 * 
 * XDoclet definition:
 * @struts.action path="/editEpByAddMethod" name="elementaryProcessForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/transaction/addMethodToEp.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class EditEpByAddMethodAction extends Action {
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
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ElementaryProcessForm elementaryProcessForm = (ElementaryProcessForm) form;// TODO Auto-generated method stub
		//获取elementaryProcessList.jsp页面传过来的epId
		Integer epId = new Integer(elementaryProcessForm.getId());	
		Integer type = Integer.valueOf(elementaryProcessForm.getEpType());
		
		String ufpMethod = elementaryProcessForm.getUfpMethod(); 
		RequirementBusiness rb = new RequirementBusiness();
		Object epObject = rb.getElementaryProcessById(type,epId);
	
		boolean result = false;
		//String ufpMethod = "3";
		//更新数据库中EI\EI\EQ表的数据
		switch(type){
			case 0: 
				IfpugEi ei = (IfpugEi)epObject;
				ei.setUfpMethod(Short.valueOf(ufpMethod));
				result = rb.updateElementaryProcess(ei);
				break;
			case 1:
				IfpugEo eo = (IfpugEo)epObject;
				eo.setUfpMethod(Short.valueOf(ufpMethod));
				eo.setEoName(elementaryProcessForm.getEpName());
				result = rb.updateElementaryProcess(eo);
				break;
			case 2:
				IfpugEq eq = (IfpugEq)epObject;
				eq.setUfpMethod(Short.valueOf(ufpMethod));
				result = rb.updateElementaryProcess(eq);
				break;
		}
	  
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}