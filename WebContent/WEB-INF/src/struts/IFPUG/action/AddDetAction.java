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
import net.sf.hibernate.mapping.Set;

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
 * @struts.action path="/addDet" name="detForm" scope="request" validate="true"
 * @struts.action-forward name="success" path="/IFPUG/dataFunction/addDet.jsp" contextRelative="true"
 * @struts.action-forward name="failure" path="/IFPUG/failure.jsp" contextRelative="true"
 */
public class AddDetAction extends Action {
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
		
		Integer type = Integer.valueOf(detForm.getType());	//��ȡaddDet.jspҳ�洫������type	
		Integer retId = Integer.valueOf(detForm.getRetId());//��ȡ��������RETID
		
		DataFunctionBusiness dfb = new DataFunctionBusiness();
		IfpugIlfRet ilfRet = null;
		IfpugEifRet eifRet = null;
		Integer dfId;
		//�¶δ������ڻ�ȡdfId,��Ĭ��RET�ͷ�Ĭ��RET�������
		if(retId < 0){ //���DETҪ������Ĭ��RET��
			dfId = Integer.valueOf(retId.toString().substring(1)); //����retId��ȡdfId
		}
		else { //ͨ��RET�����ȡdfId.
			if(type == 0){
				ilfRet = (IfpugIlfRet)dfb.queryIlfRetById(retId);
				dfId = ilfRet.getIfpugIlf().getId();
			}
			else {
				eifRet = (IfpugEifRet)dfb.queryEifRetById(retId);
				dfId = eifRet.getIfpugEif().getId();
			}
		}
		//���ڻ�ȡ�������ݿ���Ĭ��ret��ID��
		if(type == 0){ //�����ILF��RET
			IfpugIlf ilf = (IfpugIlf)dfb.queryIlfById(dfId);			
			if(retId < 0){ //Ĭ��RET
				Object[] retList = ilf.getIfpugIlfRets().toArray();//��ȡ��Ӧ���ݹ����ļ������е�RET
				for (Object r:retList){//�ҵ������б�������Ϊdefault��RET
					IfpugIlfRet ret = (IfpugIlfRet)r;
					if(ret.getIlfRetName().equals("default"))  
					{
						ilfRet = ret; 
						break;	
					}
				}
			}
		}
		else {
			IfpugEif eif = new IfpugEif();
			if(retId < 0){
				Object[] retList = eif.getIfpugEifRets().toArray();//��ȡ��Ӧ���ݹ����ļ������е�RET
				for (Object r:retList){//�ҵ������б�������Ϊdefault��RET
					IfpugEifRet ret = (IfpugEifRet)r;
					if(ret.getEifRetName().equals("default"))  
					{
						eifRet = ret; 
						break;	
					}
				}
			}
		}
		
		boolean result = false;
		if(type == 0){//�����ILF�µ�RET��DET
			//�˶δ������ڼ���ILF�ļ���ӦRET�����Ƿ��Ѵ���Ĭ��RET�����û�У�����
			if(ilfRet == null){//�����dfId=-retId��Ӧ��ILF�����ļ���û��Ĭ��RET�ļ�¼�������¼
  				IfpugIlf ii = (IfpugIlf)dfb.queryIlfById(dfId);
  				IfpugIlfRet iir = new IfpugIlfRet();
  				iir.setIfpugIlf(ii);
  				iir.setIlfRetName("default");
  				iir.setIlfRetDesp("default ret for dets that belong to ilf directly.");
  				dfb.insertRet(iir);//��Ĭ��RET�������ݿ�
  				ilfRet = iir;
  			}
			
			//�˶δ������ڳ�ʼ��DET��Ȼ��������ݿ�
			IfpugIlfDet iid = new IfpugIlfDet();
			iid.setIfpugIlfRet(ilfRet);
			iid.setIlfDetDesp(new String(detForm.getDetDesp().getBytes("ISO-8859-1"),"GB2312"));
			iid.setIlfDetName(new String(detForm.getDetName().getBytes("ISO-8859-1"),"GB2312"));
			iid.setType(Short.valueOf(type.toString()));
			iid.setIlfId(dfId);
			result = dfb.insertDet(iid); //����DET�����ݿ���
		}
		else{
			if(eifRet == null){//�����dfId=-retId��Ӧ��EIF�����ļ���û��Ĭ��RET�ļ�¼�������¼
  				IfpugEif ie = (IfpugEif)dfb.queryEifById(-retId);
  				IfpugEifRet ier = new IfpugEifRet();
  				ier.setEifRetName("default");
  				ier.setIfpugEif(ie);
  				ier.setEifRetDesp("default ret for dets that belong to eif directly.");
  				dfb.insertRet(ier);
  				eifRet = ier;
  			}
			IfpugEifDet ied = new IfpugEifDet();
			ied.setEifDetDesp(new String(detForm.getDetDesp().getBytes("ISO-8859-1"),"GB2312"));
			ied.setEifDetName(new String(detForm.getDetName().getBytes("ISO-8859-1"),"GB2312"));
			ied.setIfpugEifRet(eifRet);
			ied.setType(Short.valueOf(type.toString()));
			ied.setEifId(dfId);
			result = dfb.insertDet(ied); //����DET�����ݿ���
		}
		if(result==true){
			   return mapping.findForward("success");
		}else{
			   return mapping.findForward("failure");
		}
	}
}