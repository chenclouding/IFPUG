package entityOperation.IFPUG;

import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import hibernate.IFPUG.IfpugProduct;
import hibernate.IFPUG.IfpugFunction;

public class  FunctionDAO extends BaseDAO{	
	
	/**
	 *  ��ָ����Ʒ�²��빦��
	 */		
	public boolean insertFunction(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ��ID��ɾ������
	 */	
	public boolean delFunctionById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugFunction",id);
		return del(obj);
	}
	/**
	 *  ��id��������������ȡ����
	 */
	public Object queryFunctionById(Integer id) {    	
        return queryById("IfpugFunction",id);

    }

	/**
	 *  ��fatherIdȡ��������ģ��
	 */
	//public List queryAllFatherFunction(Integer functionId,Integer fatherId) {    	
        
    //}
	
	/*public List queryByObject(String tableName, String colName,Object object){
		
		Session session = null;
		Transaction tx = null;	
		session = openHibernateSession();
		try {
			tx = session.beginTransaction();
			String hql = "from IfpugFunction where ifpugProduct = object";
			List functionList = session.find(hql);
			return functionList;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	
}
	
//	//ɾ��Order��¼
//	public boolean delFunction(Integer functionId) { 
//		// TODO Auto-generated method stub 
//		
//		Transaction tx = null;
//		try {
//			tx = session.beginTransaction();
//			IfpugFunction function = (IfpugFunction)session.get(IfpugFunction.class, functionId);
//			session.delete(function); 
//			tx.commit();
//			return true;
//		} catch (HibernateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	} 
	

