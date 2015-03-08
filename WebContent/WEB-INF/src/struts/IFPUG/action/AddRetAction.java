/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import java.io.UnsupportedEncodingException;

import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEifRet;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugIlfRet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.DataFunctionBusiness;
import business.IFPUG.RequirementBusiness;
import struts.IFPUG.form.RetForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-29-2010
 * 
 * XDoclet definition:
 * @struts.action path="/addRet" name="retForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/dataFunction/addRet.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class AddRetAction extends Action {
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
		RetForm retForm = (RetForm) form;// TODO Auto-generated method stub
		
	
		Integer fileId = Integer.valueOf(retForm.getId());	//获取retList.jsp页面传过来的fileId	
		Integer type = Integer.valueOf(retForm.getType());//获取传过来的文件类型
		
		DataFunctionBusiness dfb = new DataFunctionBusiness();
		boolean result = false;
		if(type == 0){
			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(fileId);
			IfpugIlfRet iir = new IfpugIlfRet();
			iir.setIlfRetName(new String(retForm.getRetName().getBytes("ISO-8859-1"),"GB2312"));
			iir.setIlfRetDesp(new String(retForm.getRetDesp().getBytes("ISO-8859-1"),"GB2312"));
			iir.setIfpugIlf(ilf);
			result = dfb.insertRet(iir);
		}
		else{
			IfpugEif eif = (IfpugEif)dfb.queryEifById(fileId);
			IfpugEifRet ier = new IfpugEifRet();
			ier.setEifRetName(new String(retForm.getRetName().getBytes("ISO-8859-1"),"GB2312"));
			ier.setEifRetDesp(new String(retForm.getRetDesp().getBytes("ISO-8859-1"),"GB2312"));
			ier.setIfpugEif(eif);
			result = dfb.insertRet(ier);
		}
		if(result==true){
			   return mapping.findForward("success");
		}else{
			   return mapping.findForward("failure");
		}
	}
}