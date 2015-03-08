/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import java.io.UnsupportedEncodingException;

import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEifDet;
import hibernate.IFPUG.IfpugEifRet;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugIlfDet;
import hibernate.IFPUG.IfpugIlfRet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.DataFunctionBusiness;
import struts.IFPUG.form.DetForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-01-2010
 * 
 * XDoclet definition:
 * @struts.action path="/editDet" name="detForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/dataFunction/detList.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class EditDetAction extends Action {
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
		DetForm detForm = (DetForm) form;// TODO Auto-generated method stub
		
		//��ȡeditDet.jspҳ�洫������retId
		Integer detId = new Integer(detForm.getId());
		//��ȡeditDet.jspҳ�洫������type
		Short type = new Short(detForm.getType());
		DataFunctionBusiness dfb = new DataFunctionBusiness();//ҵ���߼��� 
		boolean result = false;
		if(type == 0){//�����ILF���͵�DET
			IfpugIlfDet iid = (IfpugIlfDet)dfb.queryIlfDetById(detId); 
			IfpugIlfRet iir = iid.getIfpugIlfRet();//��ȡDet��Ӧ��RET
			IfpugIlf ifpugIlf = iir.getIfpugIlf(); //��ȡdet��Ӧ��ILF����
			iid.setIfpugIlfRet(iir);
			iid.setIlfDetName(new String(detForm.getDetName().getBytes("ISO-8859-1"),"GB2312"));
			iid.setIlfDetDesp(new String(detForm.getDetDesp().getBytes("ISO-8859-1"),"GB2312"));
			iid.setIlfId(ifpugIlf.getId());
			iid.setType(type);
			result = dfb.updateDet(iid);
		}
		else {//�����EIF���͵�DET
			IfpugEifDet ied = (IfpugEifDet)dfb.queryEifDetById(detId);
			IfpugEifRet ier = ied.getIfpugEifRet();
			IfpugEif ifpugEif = ier.getIfpugEif();
			ied.setEifDetName(new String(detForm.getDetName().getBytes("ISO-8859-1"),"GB2312"));
			ied.setEifDetDesp(new String(detForm.getDetDesp().getBytes("ISO-8859-1"),"GB2312"));
			ied.setEifId(ifpugEif.getId());
			ied.setType(type);
			ied.setIfpugEifRet(ier);
			result = dfb.updateDet(ied);
		}	
		if(result==true){
			   return mapping.findForward("success");
		}else{
			  return mapping.findForward("failure");
		}
	}
}