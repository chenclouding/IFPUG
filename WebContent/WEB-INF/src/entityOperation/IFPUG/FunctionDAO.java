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
	 *  在指定产品下插入功能
	 */		
	public boolean insertFunction(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  按ID号删除功能
	 */	
	public boolean delFunctionById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugFunction",id);
		return del(obj);
	}
	/**
	 *  按id（主键）将功能取出来
	 */
	public Object queryFunctionById(Integer id) {    	
        return queryById("IfpugFunction",id);

    }

	/**
	 *  按fatherId取出所有主模块
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
	
//	//删除Order记录
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
	

