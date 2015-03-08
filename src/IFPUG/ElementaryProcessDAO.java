package entityOperation.IFPUG;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

public class  ElementaryProcessDAO extends BaseDAO{	
	
	private Session session;
	/**
	 *  �����������
	 */		
	public boolean addElementaryProcess(Object dataObject){
		try {
			return insert(dataObject);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 *  ��ʵ�����ɾ����������
	 */	
	public boolean delElementaryProcess(Object dataObject){
		try {
			return del(dataObject);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	/**
	 *  ��id����������EI���͵Ļ�������ȡ����
	 */
	public Object queryEiById(Integer id) {    	
		return queryById("IfpugEi",id);
    }
	/**
	 *  ��id����������EO���͵Ļ�������ȡ����
	 */
	public Object queryEoById(Integer id) {    	
		return queryById("IfpugEo",id);
    }
	/**
	 *  ��id����������EQ���͵Ļ�������ȡ����
	 */
	public Object queryEqById(Integer id) {    	
		return queryById("IfpugEq",id);
    }
	/**
	 *  ��id����������EI���͵�DETȡ����
	 */
	public Object queryEiDetById(Integer id) {    	
		return queryById("IfpugEiDet",id);
    }
	/**
	 *  ��id����������EO���͵Ļ�������ȡ����
	 */
	public Object queryEoDetById(Integer id) {    	
		return queryById("IfpugEoDet",id);
    }
	/**
	 *  ��id����������EQ���͵Ļ�������ȡ����
	 */
	public Object queryEqDetById(Integer id) {    	
		return queryById("IfpugEqDet",id);
    }
	
	/**
	 *  ���»�������
	 */	
	public boolean updateElementaryProcess(Object dataObject){
		try {
			return update(dataObject);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
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
	/**
	 *  ����DET
	 */
	public boolean insertDet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
}


