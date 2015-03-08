package entityOperation.IFPUG;

import java.util.List;

import net.sf.hibernate.HibernateException;

public class DataFunctionDAO extends BaseDAO{
	/*-------------------------------------�����ݿ��ILF�Ĳ���--------------------------*/
	/**
	 *  �����ڲ��߼��ļ�ILF
	 */		
	public boolean insertIlf(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ��ȡ�����ڲ��߼��ļ�ILF
	 * @throws HibernateException 
	 */	
	public List queryAllIlf() throws HibernateException{	
        return queryAll("IfpugIlf");
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�ILF
	 * @throws HibernateException 
	 */	
	public Object queryIlfById(Integer id) throws HibernateException{	
        return queryById("IfpugIlf",id);
	}
	/**
	 *  ����Idɾ���ڲ��߼��ļ�ILF
	 * @throws HibernateException  
	 */
	public boolean delIlfById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlf",id);
		return del(obj);
	}
	/**
	 *  �����ڲ��߼��ļ�ILF\EIF
	 * @throws HibernateException 
	 */
	public boolean updateDataFunction(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/*--------------------------ILF-----------�����ݿ��RET�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ڲ��߼��ļ�ILF������RET
	 * @throws HibernateException 
	 *  */
	public boolean delIlfRetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfRet",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�EIF������RET
	 * @throws HibernateException 
	 */	
	public Object queryIlfRetById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfRet",id);
	}
	
	/*--------------------------ILF-----------�����ݿ��DET�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ڲ��߼��ļ�ILF������DET
	 * @throws HibernateException 
	 *  */
	public boolean delIlfDetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfDet",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�EIF������RET
	 * @throws HibernateException 
	 */	
	public Object queryIlfDetById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfDet",id);
	}
	/*--------------------------ILF-----------�����ݿ��METHOD�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ڲ��߼��ļ�ILF������METHOD
	 * @throws HibernateException 
	 *  */
	public boolean delIlfMethodById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfMethod",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�ILF������METHOD
	 * @throws HibernateException 
	 */	
	public Object queryIlfMethodById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfMethod",id);
	}
	
	/*-------------------------------------�����ݿ��EIF�Ĳ���--------------------------*/
	/**
	 *  �����ⲿ�ӿ��ļ�EIF
	 */		
	public boolean insertEif(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ��ȡ�����ⲿ�ӿ��ļ�EIF
	 */	
	public List queryAllEif() throws HibernateException {	
        return queryAll("IfpugEif");
	}
	/**
	 *  ����ID��ȡ�ⲿ�ӿ��ļ�EIF
	 * @throws HibernateException 
	 */	
	public Object queryEifById(Integer id) throws HibernateException{	
        return queryById("IfpugEif",id);
	}
	/**
	 *  ����Idɾ���ⲿ�ӿ��ļ�EIF
	 * @throws HibernateException 
	 */
	public boolean delEifById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEif",id);
		return del(obj);
	}
	/*-------------------------ILF/EIF------------�����ݿ��RET�Ĳ���--------------------------*/
	/**
	 *  ����RET
	 */
	public boolean insertRet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ����RET
	 * @throws HibernateException 
	 */
	public boolean updateRet(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/*-------------------------ILF/EIF------------�����ݿ��DET�Ĳ���--------------------------*/
	/**
	 *  ����DET
	 */
	public boolean insertDet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ����DET
	 * @throws HibernateException 
	 */
	public boolean updateDet(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	
	/*-------------------------ILF/EIF------------�����ݿ��Method�Ĳ���--------------------------*/
	/**
	 *  ����Method
	 */
	public boolean insertMethod(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ����Method
	 * @throws HibernateException 
	 */
	public boolean updateMethod(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/*--------------------------EIF-----------�����ݿ��RET�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ⲿ�ӿ��ļ�ILF������RET
	 * @throws HibernateException 
	 *  */
	public boolean delEifRetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEifRet",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ⲿ�ӿ��ļ�EIF������RET
	 * @throws HibernateException 
	 */	
	public Object queryEifRetById(Integer id) throws HibernateException{	
        return queryById("IfpugEifRet",id);
	}
	/*--------------------------EIF-----------�����ݿ��DET�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ڲ��߼��ļ�ILF������RET
	 * @throws HibernateException 
	 *  */
	public boolean delEifDetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfDet",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�EIF������RET
	 * @throws HibernateException 
	 */	
	public Object queryEifDetById(Integer id) throws HibernateException{	
        return queryById("IfpugEifDet",id);
	}
	/*--------------------------EIF-----------�����ݿ��METHOD�Ĳ���--------------------------*/
	/**
	 *  ����Idɾ���ڲ��߼��ļ�EIF������METHOD
	 * @throws HibernateException 
	 *  */
	public boolean delEifMethodById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEifMethod",id);
		return del(obj);
	}
	/**
	 *  ����ID��ȡ�ڲ��߼��ļ�EIFF������METHOD
	 * @throws HibernateException 
	 */	
	public Object queryEifMethodById(Integer id) throws HibernateException{	
        return queryById("IfpugEifMethod",id);
	}
}
