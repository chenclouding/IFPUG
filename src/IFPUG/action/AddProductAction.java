
package struts.IFPUG.action;


import hibernate.IFPUG.IfpugProduct;

import java.io.UnsupportedEncodingException;
import java.sql.Date; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.hibernate.HibernateException;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import business.IFPUG.RequirementBusiness;
import business.IFPUG.UserBusiness;
import struts.IFPUG.form.ProductForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-08-2010
 * 
 * XDoclet definition:
 * @struts.action path="/addProduct" name="productForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/welcomeIfpug.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class AddProductAction extends Action {
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
	 * @throws ParseException 
	 * @throws HibernateException 
	 * @throws UnsupportedEncodingException 
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws  HibernateException, UnsupportedEncodingException {
		ProductForm productForm = (ProductForm) form;// TODO Auto-generated method stub
		
		RequirementBusiness rb = new RequirementBusiness();
		UserBusiness ub = new UserBusiness();
		IfpugProduct fp = new IfpugProduct();
		
	
		fp.setProductName(new String(productForm.getProductName().getBytes("ISO-8859-1"),"GB2312"));  
		fp.setProductDesp(new String(productForm.getProductDesp().getBytes("ISO-8859-1"),"GB2312"));
		fp.setDevelopType(Short.valueOf(productForm.getDevelopType()));
		fp.setIfpugFunctions(null);
		fp.setProductType(Short.valueOf(productForm.getProductType()));
		fp.setMeasureMethod(Short.valueOf(productForm.getMeasureMethod()));
		fp.setEstimator(new String(productForm.getEstimator().getBytes("ISO-8859-1"),"GB2312"));
		fp.setMeasureStatus(Short.valueOf(productForm.getMeasureStatus()));
		fp.setLifecyclePhase(Short.valueOf(productForm.getLifecyclePhase()));
		
		fp.setProjectStartTime(rb.formatStrToDate(productForm.getProjectStartTime()));
		fp.setProjectEndTime(rb.formatStrToDate(productForm.getProjectEndTime()));
		fp.setEstimateTime(rb.formatStrToDate(productForm.getEstimateTime()));
		String endDate=productForm.getProjectEndTime();
		fp.setEndTime(endDate==null?null:rb.formatStrToDate(endDate));
		/*fp.setProjectStartTime(Date.valueOf(new String(productForm.getProjectStartTime().getBytes("ISO-8859-1"),"GB2312")));
		fp.setProjectEndTime(Date.valueOf(new String(productForm.getProjectEndTime().getBytes("ISO-8859-1"),"GB2312")));
		fp.setEstimateTime(Date.valueOf(new String(productForm.getEstimateTime().getBytes("ISO-8859-1"),"GB2312")));
		String endDate = new String(productForm.getEndTime().getBytes("ISO-8859-1"),"GB2312");
		Date date = null;
		if (endDate.length() > 0) date = Date.valueOf(endDate);  
		fp.setEndTime(date);*/
		String userName = (String)request.getSession().getAttribute("userName");
		
		fp.setIfpugUser(ub.getUserByUserName(userName));
	
		boolean result = rb.insertProduct(fp);
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}