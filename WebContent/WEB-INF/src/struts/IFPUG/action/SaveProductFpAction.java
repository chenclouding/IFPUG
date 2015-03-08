/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import hibernate.IFPUG.IfpugProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.RequirementBusiness;
import struts.IFPUG.form.FpForm;

/** 
 * MyEclipse Struts
 * Creation date: 06-13-2010
 * 
 * XDoclet definition:
 * @struts.action path="/saveProductFp" name="fpForm" scope="request" validate="true"
 */
public class SaveProductFpAction extends Action {
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
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws HibernateException {
		FpForm fpForm = (FpForm) form;// TODO Auto-generated method stub
		
		RequirementBusiness rb = new RequirementBusiness();//ҵ��㺯��,�������������ɾ�Ĳ�Ȳ���
		     
		
		/*��idΪdataGroupId��ʵ��bean���ҳ���*/
		Integer productId = new Integer(fpForm.getProductId());
		String s = fpForm.getFpc();
		String count;
		int i;
		for (i = 0; i < s.length(); i ++)
			if(s.charAt(i) == '.') break;
		count = s.substring(0,i - 1);
		IfpugProduct fp = (IfpugProduct)rb.getProductById(productId);
	    if(s.charAt(i + 1) >= '5') fp.setUfpCount(Integer.parseInt((count) + 1));
	    else fp.setUfpCount(Integer.parseInt((count)));
      
	    boolean result = rb.updateProduct(fp);
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}