package business.IFPUG;

import net.sf.hibernate.HibernateException;
import entityOperation.IFPUG.DataFunctionDAO;
import entityOperation.IFPUG.ElementaryProcessDAO;
import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEiDet;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEoDet;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugEqDet;

public class TransactionFunctionBusiness {
	public String getEpMethodNameById(Short methodId)
	{
		switch(methodId)
		{
		case 0:
			return "�ֶ����";
		case 1:
			return "Ĭ��ֵ";
		case 2:
			return "�û�ѡ��";
		case 3:
			return "�û�����";
		case 4:
			return "ѡ���Ӷ�";
		default: return "";
		}
	}
	
	
	//����Id��ȡϵͳEI
	public IfpugEi queryEiById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEi ei = new IfpugEi();
		ei = (IfpugEi)ed.queryEiById(id);	
		return ei;
	}
	//����Id��ȡϵͳEO
	public IfpugEo queryEoById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEo eo = new IfpugEo();
		eo = (IfpugEo)ed.queryEoById(id);	
		return eo;
	}
	//����Id��ȡϵͳEQ
	public IfpugEq queryEqById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEq eq = new IfpugEq();
		eq = (IfpugEq)ed.queryEqById(id);	
		return eq;
	}
	
	//����EI\EO\EQ�ļ�
	public boolean updateTransactionFunction(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if (ed.updateElementaryProcess(dataObject)== true)
			return true;
		else
			return false;
	}
	
	//����EI\EO\EQ�ļ�
	public boolean insertTransactionFunction(Object dataObject) throws HibernateException {
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.updateElementaryProcess(dataObject) == true)
			return true;
		else 
			return false;
	}
	//����method
	public boolean insertMethod(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.insertMethod(dataObject) == true)
			return true;
		else 
			return false;
	}
	//����method
	public boolean updateMethod(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if (ed.updateMethod(dataObject)== true)
			return true;
		else
			return false;
	}
	
	//����DET
	public boolean insertDet(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.insertDet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//��IDɾ��EI�ļ��µ�DET
	public boolean delEiDetById(Integer id) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEiDet det = (IfpugEiDet)ed.queryEiDetById(id);
		
		return ed.delElementaryProcess(det);
	}
	//��IDɾ��EO�ļ��µ�DET
	public boolean delEoDetById(Integer id) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEoDet det = (IfpugEoDet)ed.queryEoDetById(id);
		return ed.delElementaryProcess(det);
	}
	public static void main(String args[])
	{
		TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
		try {
			tfb.delEiDetById(3);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//��IDɾ��EQ�ļ��µ�DET
	public boolean delEqDetById(Integer id) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEqDet det = (IfpugEqDet)ed.queryEqDetById(id);
		return ed.delElementaryProcess(det);
	}

}
