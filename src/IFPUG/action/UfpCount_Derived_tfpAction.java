/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.FpCountBusiness;
import business.IFPUG.RequirementBusiness;
import business.IFPUG.TransactionFunctionBusiness;
import business.IFPUG.UfpCountBusiness;
import struts.IFPUG.form.UfpCountOfEpForm;

/** 
 * MyEclipse Struts
 * Creation date: 06-26-2010
 * 
 * XDoclet definition:
 * @struts.action path="/ufpCount_Derived_tfp" name="ufpCountOfEpForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/welcomeIfpug.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class UfpCount_Derived_tfpAction extends Action {
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
		UfpCountOfEpForm ufpCountOfEpForm = (UfpCountOfEpForm) form;// TODO Auto-generated method stub
		

		//��ȡ��directMethod.JSPҳ�洫�����Ĳ���
		int type = new Integer(ufpCountOfEpForm.getType());//EI\EO\EQ
		int epId = new Integer(ufpCountOfEpForm.getEpId());
		int ftrCount = new Integer(ufpCountOfEpForm.getFtrValue());
		
		HttpSession session =request.getSession(true);		
		session.setAttribute("ftrCount", ftrCount);

		TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
		UfpCountBusiness ucb = new UfpCountBusiness(); //���ü��㹦�ܵ�ҵ���߼���
		RequirementBusiness rb = new  RequirementBusiness();
		FpCountBusiness fcb = new FpCountBusiness();
		
		IfpugProduct product = new IfpugProduct();
		IfpugFunction function = null;
		int complex = 0, ufpCount = 0, detCount = 0;
		
		boolean result;
		switch(type)
		{
		case 0: 
			IfpugEi ei = (IfpugEi)tfb.queryEiById(epId);
			function = ei.getIfpugFunction();
			detCount = ei.getIfpugEiDets().size();
			complex = ucb.getComplex_valueMethod_TF(detCount, ftrCount, type);//����ҵ���߼��㺯�����Ƹ��Ӷ�
			ufpCount = ucb.getUfpCount(complex, type+2);//����ҵ���߼��㺯�������㹦�ܵ����
			ei.setMeasureStatus(Short.valueOf("2"));
			ei.setUfpCount(ufpCount);
			result = tfb.updateTransactionFunction(ei);
			break;
		case 1:
			IfpugEo eo = (IfpugEo)tfb.queryEoById(epId);
			function = eo.getIfpugFunction();
			detCount = eo.getIfpugEoDets().size();
			eo.setMeasureStatus(Short.valueOf("2"));
			complex = ucb.getComplex_valueMethod_TF(detCount, ftrCount, type);//����ҵ���߼��㺯�����Ƹ��Ӷ�
			ufpCount = ucb.getUfpCount(complex, type+2);//����ҵ���߼��㺯�������㹦�ܵ����
			eo.setUfpCount(ufpCount);
			result = tfb.updateTransactionFunction(eo);
			break;
		case 2:
			IfpugEq eq = (IfpugEq)tfb.queryEqById(epId);
			function = eq.getIfpugFunction();
			detCount = eq.getIfpugEqDets().size();
			eq.setMeasureStatus(Short.valueOf("2"));
			complex = ucb.getComplex_valueMethod_TF(detCount, ftrCount, type);//����ҵ���߼��㺯�����Ƹ��Ӷ�
			ufpCount = ucb.getUfpCount(complex, type+2);//����ҵ���߼��㺯�������㹦�ܵ����
			eq.setUfpCount(ufpCount);
			result = tfb.updateTransactionFunction(eq);
			break;
		default: result = false;
		}
     	while (function.getIfpugProduct() == null) {
			function = function.getIfpugFunction();
		}
		product = function.getIfpugProduct();		
		product.setUfpCount(fcb.dfpCount(product.getId())+fcb.tfpCount(product.getId()));
		rb.updateProduct(product); //���������ݹ��ܣ���Ʒ�Ѿ����ֹ��㡣
		
		if(result==true){
			   return mapping.findForward("success");
		}else{
			   return mapping.findForward("failure");
		}
	}
}