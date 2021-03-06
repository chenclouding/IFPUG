/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.IFPUG.action;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEiMethod;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEoMethod;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugEqMethod;
import hibernate.IFPUG.IfpugFunction;

import hibernate.IFPUG.IfpugProduct;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * Creation date: 05-27-2010
 * 
 * XDoclet definition:
 * @struts.action path="/ufpCount_Complex" name="ufpCountOfEpForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/transaction/complexMethod.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class UfpCount_ComplexAction extends Action {
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
		
		//int ufpMethod = new Integer(ufpCountOfEpForm.getUfpMethod());
		int type = new Integer(ufpCountOfEpForm.getType());//已转换成0、1的ILF\EIF
		int epId = new Integer(ufpCountOfEpForm.getEpId());
		
		TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
		UfpCountBusiness ucb = new UfpCountBusiness(); //调用计算功能的业务逻辑层
		FpCountBusiness fcb = new FpCountBusiness();
		RequirementBusiness rb = new RequirementBusiness();
		
		IfpugProduct product = new IfpugProduct();
		int complex = Integer.valueOf(ufpCountOfEpForm.getComplex());//获得复杂度
		int ufpCount = ucb.getUfpCount(complex, type+2);//调用业务逻辑层函数，计算功能点个数
		boolean result = false;
		IfpugFunction function = null;
		int figure = 0;
		//将此记录加入到method表格中
		switch(type)
		{
		case 0:
			IfpugEi ei = tfb.queryEiById(epId);
			function = ei.getIfpugFunction();
			IfpugEiMethod eiMethod = ei.getIfpugEiMethod();
			if(eiMethod == null)//说明是首次添加方法详细信息
			{
				eiMethod = new IfpugEiMethod();
				figure = 1;
			}
			eiMethod.setComplex(Short.valueOf(String.valueOf(complex)));
			eiMethod.setMethodType(Short.valueOf("4"));
			
			//更新数据库表EI中UFPcount的值
			ei.setUfpMethod(Short.valueOf("4")); //更新方法
			ei.setUfpCount(ufpCount);//更新UFP个数值
			ei.setMeasureStatus(Short.valueOf("2"));
			result = tfb.insertTransactionFunction(ei);
			eiMethod.setIfpugEi(ei);
			if(figure == 1){
				tfb.insertMethod(eiMethod); //调用业务逻辑层函数插入
			}
			else {//如果该EI文件对应的方法已存在，更新
				tfb.updateMethod(eiMethod);
			}
			break;
		case 1:
			IfpugEo eo = tfb.queryEoById(epId);
			function = eo.getIfpugFunction();
			IfpugEoMethod eoMethod = eo.getIfpugEoMethod();
			if(eoMethod == null)//说明是首次添加方法详细信息
			{
				eoMethod = new IfpugEoMethod();
				figure = 1;
			}
			eoMethod.setComplex(complex);
			eoMethod.setMethodType(Short.valueOf("4"));
			
			//更新数据库表EI中UFPcount的值
			eo.setUfpMethod(Short.valueOf("4")); //更新方法
			eo.setUfpCount(ufpCount);//更新UFP个数值
			eo.setMeasureStatus(Short.valueOf("2"));
			result = tfb.insertTransactionFunction(eo);
			eoMethod.setIfpugEo(eo);
			if(figure == 1){
				tfb.insertMethod(eoMethod); //调用业务逻辑层函数插入
			}
			else {//如果该EI文件对应的方法已存在，更新
				tfb.updateMethod(eoMethod);
			}
			break;
		case 2:
			IfpugEq eq = tfb.queryEqById(epId);
			function = eq.getIfpugFunction();
			IfpugEqMethod eqMethod = eq.getIfpugEqMethod();
			if(eqMethod == null)//说明是首次添加方法详细信息
			{
				eqMethod = new IfpugEqMethod();
				figure = 1;
			}
			eqMethod.setComplex(Short.valueOf(String.valueOf(complex)));
			eqMethod.setMethodType(Short.valueOf("4"));
			
			//更新数据库表EI中UFPcount的值
			eq.setUfpMethod(Short.valueOf("4")); //更新方法
			eq.setUfpCount(ufpCount);//更新UFP个数值
			eq.setMeasureStatus(Short.valueOf("2"));
			result = tfb.insertTransactionFunction(eq);
			eqMethod.setIfpugEq(eq);
			if(figure == 1){
				tfb.insertMethod(eqMethod); //调用业务逻辑层函数插入
			}
			else {//如果该EI文件对应的方法已存在，更新
				tfb.updateMethod(eqMethod);
			}
		}
     	while (function.getIfpugProduct() == null) {
			function = function.getIfpugFunction();
		}
		product = function.getIfpugProduct();		
		product.setUfpCount(fcb.dfpCount(product.getId())+fcb.tfpCount(product.getId()));
		rb.updateProduct(product); //估算完数据功能，产品已经部分估算。
		
		if(result==true){
			   return mapping.findForward("success");
		}else{
			   return mapping.findForward("failure");
		}
	}
}