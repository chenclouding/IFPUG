/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
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
import struts.IFPUG.form.ProductForm;


/** 
 * MyEclipse Struts
 * Creation date: 04-08-2010
 * 
 * XDoclet definition:
 * @struts.action path="/editProduct" name="productForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/requirement/productList.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class EditProductAction extends Action {
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
		ProductForm productForm = (ProductForm) form;// TODO Auto-generated method stub
		RequirementBusiness rb = new RequirementBusiness();//业务层函数,对数据组进行增删改查等操作
		IfpugProduct fp;          //定义实体bean
		
		/*将id为dataGroupId的实体bean查找出来*/
		Integer productId = new Integer(productForm.getId());
		fp = (IfpugProduct)rb.getProductById(productId);
		/*从form表单中获取数据组信息,更新实体Bean*/
		
		fp.setProductName(new String(productForm.getProductName().getBytes("ISO-8859-1"),"GB2312"));
		fp.setProductDesp(new String(productForm.getProductDesp().getBytes("ISO-8859-1"),"GB2312"));
		fp.setDevelopType(Short.valueOf(productForm.getDevelopType()));
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
		String endDate = productForm.getEndTime();
		Date date = null;
		if (endDate.length() > 0) date = Date.valueOf(endDate);  
		fp.setEndTime(date);*/
        
		boolean result = rb.updateProduct(fp);
		if(result==true){
		   return mapping.findForward("success");
		}else{
		   return mapping.findForward("failure");
		}
	}
}