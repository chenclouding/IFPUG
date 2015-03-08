package business.IFPUG;

import java.util.List;

import net.sf.hibernate.HibernateException;
import entityOperation.IFPUG.DataFunctionDAO;

public class DataFunctionBusiness {

	/*****************************************���ڲ��߼��ļ�ILF�Ĳ���*********************************************/

	//����ϵͳ�ڲ��߼��ļ�
	public boolean insertIlf(Object dataObject) throws HibernateException {
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertIlf(dataObject) == true)
			return true;
		else 
			return false;
	}
	//��ȡ����ϵͳ�ڲ��ļ�ILF
	public List queryAllIlf() throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryAllIlf();
	}
	//����Id��ȡϵͳ�ڲ��ļ�ILF
	public Object queryIlfById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfById(id);		
	}
	//��IDɾ��ILF�ļ�
	public boolean delIlfById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfById(id);
	}
	//����ILF\EIF�ļ�
	public boolean updateDataFunction(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateDataFunction(dataObject)== true)
			return true;
		else
			return false;
	}
	/***********************ILF******************�Լ�¼Ԫ��RET�Ĳ���********************************************
	 * @throws HibernateException */
	//��IDɾ��ILF�ļ��µ�RET
	public boolean delIlfRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfRetById(id);
	}
	//����Id��ȡϵͳ�ڲ��ļ�ILF��RET
	public Object queryIlfRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfRetById(id);		
	}
	/***********************ILF******************�Լ�¼Ԫ��DET�Ĳ���********************************************
	 * @throws HibernateException */
	//��IDɾ��ILF�ļ��µ�DET
	public boolean delIlfDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfDetById(id);
	}
	//����Id��ȡϵͳ�ڲ��ļ�ILF��DET
	public Object queryIlfDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfDetById(id);		
	}
	/***********************ILF******************�Լ�¼����Method�Ĳ���********************************************
	 * @throws HibernateException */
	//��IDɾ��ILF�ļ��µ�DET
	public boolean delIlfMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfMethodById(id);
	}
	//����Id��ȡϵͳ�ڲ��ļ�ILF��DET
	public Object queryIlfMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfMethodById(id);		
	}
	
	
	/*****************************************���ⲿ�ӿ��ļ�EIF�Ĳ���********************************************
	 * @throws HibernateException */

	//�����ⲿ�ӿ��ļ�EIF
	public boolean insertEif(Object dataObject) throws HibernateException {
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertEif(dataObject) == true)
			return true;
		else 
			return false;
	}
	//��ȡ�����ⲿ�ӿ��ļ�EIF
	public List queryAllEif(){
		DataFunctionDAO dd = new DataFunctionDAO();
		try {
			return dd.queryAllEif();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//����Id��ȡ�ⲿ�ӿ��ļ�EIF
	public Object queryEifById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifById(id);		
	}
	//��IDɾ��EIF�ļ�
	public boolean delEifById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifById(id);
	}
	
	/*********************ILF\EIF********************��RET�Ĳ���********************************************
	 * @throws HibernateException */
	//����RET
	public boolean insertRet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertRet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//����RET
	public boolean updateRet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateRet(dataObject)== true)
			return true;
		else
			return false;
	}
	/*********************ILF\EIF********************��dET�Ĳ���********************************************
	 * @throws HibernateException */
	//����RET
	public boolean insertDet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertDet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//����RET
	public boolean updateDet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateDet(dataObject)== true)
			return true;
		else
			return false;
	}
	/*********************ILF\EIF********************��method�Ĳ���********************************************
	 * @throws HibernateException */
	//����method
	public boolean insertMethod(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertMethod(dataObject) == true)
			return true;
		else 
			return false;
	}
	//����method
	public boolean updateMethod(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateMethod(dataObject)== true)
			return true;
		else
			return false;
	}
	/***********************EIF******************�Լ�¼Ԫ��RET�Ĳ���*********************************************/
	//��IDɾ��EIF�ļ��µ�RET
	public boolean delEifRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifRetById(id);
	}
	//����Id��ȡEIF�ļ��µ�RET
	public Object queryEifRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifRetById(id);		
	}
	/***********************EIF******************�Լ�¼Ԫ��DET�Ĳ���*********************************************/
	//��IDɾ��EIF�ļ��µ�RET
	public boolean delEifDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifDetById(id);
	}
	//����Id��ȡEIF�ļ��µ�RET
	public Object queryEifDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifDetById(id);		
	}
	/***********************EIF******************�Է���Method�Ĳ���********************************************
	 * @throws HibernateException */
	//��IDɾ��ILF�ļ��µ�Method
	public boolean delEifMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifMethodById(id);
	}
	//����Id��ȡϵͳ�ڲ��ļ�ILF��Method
	public Object queryEifMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifMethodById(id);		
	}
	
	//����ļ���������
	public String getTypeName(Integer type)
	{
		String name;
		if(type == 0) name ="ILF(�ڲ��߼��ļ�)";
		else name = "EIF(�ⲿ�ӿ��ļ�)";
		return name;
	}
	//��ù��㷽������
	public String getMethodName(Short method)
	{
		String name = null;
		switch(method)
		{
		case 0: name="�ֶ�����DET"; break;
		case 1: name="Ĭ�Ϲ��ܵ����"; break;
		case 2: name="ѡ��DET��Χ"; break;
		case 3: name ="����DET����"; break;
		case 4: name ="ѡ���Ӷ�"; break;		
		}
		return name;
	}
	
}
