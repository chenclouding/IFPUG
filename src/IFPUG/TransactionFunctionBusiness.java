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
			return "手动添加";
		case 1:
			return "默认值";
		case 2:
			return "用户选择";
		case 3:
			return "用户输入";
		case 4:
			return "选择复杂度";
		default: return "";
		}
	}
	
	
	//根据Id获取系统EI
	public IfpugEi queryEiById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEi ei = new IfpugEi();
		ei = (IfpugEi)ed.queryEiById(id);	
		return ei;
	}
	//根据Id获取系统EO
	public IfpugEo queryEoById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEo eo = new IfpugEo();
		eo = (IfpugEo)ed.queryEoById(id);	
		return eo;
	}
	//根据Id获取系统EQ
	public IfpugEq queryEqById(Integer id){
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEq eq = new IfpugEq();
		eq = (IfpugEq)ed.queryEqById(id);	
		return eq;
	}
	
	//更新EI\EO\EQ文件
	public boolean updateTransactionFunction(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if (ed.updateElementaryProcess(dataObject)== true)
			return true;
		else
			return false;
	}
	
	//插入EI\EO\EQ文件
	public boolean insertTransactionFunction(Object dataObject) throws HibernateException {
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.updateElementaryProcess(dataObject) == true)
			return true;
		else 
			return false;
	}
	//插入method
	public boolean insertMethod(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.insertMethod(dataObject) == true)
			return true;
		else 
			return false;
	}
	//更新method
	public boolean updateMethod(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if (ed.updateMethod(dataObject)== true)
			return true;
		else
			return false;
	}
	
	//插入DET
	public boolean insertDet(Object dataObject) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		if(ed.insertDet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//按ID删除EI文件下的DET
	public boolean delEiDetById(Integer id) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEiDet det = (IfpugEiDet)ed.queryEiDetById(id);
		
		return ed.delElementaryProcess(det);
	}
	//按ID删除EO文件下的DET
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
	//按ID删除EQ文件下的DET
	public boolean delEqDetById(Integer id) throws HibernateException{
		ElementaryProcessDAO ed= new ElementaryProcessDAO();
		IfpugEqDet det = (IfpugEqDet)ed.queryEqDetById(id);
		return ed.delElementaryProcess(det);
	}

}
