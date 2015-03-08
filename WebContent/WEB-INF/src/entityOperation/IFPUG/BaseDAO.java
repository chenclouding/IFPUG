package entityOperation.IFPUG;

import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.cfg.Configuration;
/**
 * @author Jeremy
 * 
 * 对Hibernate提供的持久层进行连接、设置、关闭操作
 * 
 */
public abstract class BaseDAO {


	private static final SessionFactory sessionFactory;

	public BaseDAO(){}
	
	static {
		 try {			
		 // Create the SessionFactory
		 sessionFactory = new Configuration().configure("/hibernate.cfg.xml")
					.buildSessionFactory();
		 }
		 //catch (Throwable ex) {
		 //log.error("Initial SessionFactory creation failed.", ex);		 
		 catch (HibernateException e) {
			 e.printStackTrace();
			 throw new ExceptionInInitializerError(e);
		 }
		 }	

	/**
	 * 通过默认的config文件 来配置 session factory
	 */	
	protected static Session openHibernateSession() {
		try {

			// 打开一个Session，每执行一个数据库事务，都要创建一个新的session实例
			Session s = sessionFactory.openSession();
			return (s);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭Session
	 * 
	 * @param hibernate
	 *            session
	 * @throws HibernateException
	 */
	public void closeSession(Session s){
		try {
			if (null != s)
				s.close();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s = null;
		}
	}
	
	
	/*---------FSM的程序中，改写上述有些函数，不在控制台输入输出HibernateLog信息，以提高效率。
	 * --------以上的几个数据库操作函数insert，update等，实际并没有把日志写入到tomcat中。
	 * --------仅仅是在控制台输出写printer语句，所以没必要加上HibernateLog函数-------*/
	/**
	 * 增加一条数据
	 * @param Object 要被插入到数据库中的实体Bean
	 * @return  boolean 表示插入是否成功
	 * @throws  HibernateException
	 */
	public boolean insert(Object dataObject)throws HibernateException {

		boolean insertResult = true;
		Session session = null;
		Transaction tx = null;
		try {
			// 获取session，开始transaction
			session = openHibernateSession();
			tx = session.beginTransaction();
			// 保存数据 提交对象
			session.save(dataObject);
			tx.commit();// 提交		
			return insertResult;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();	// 如果不成功则rollback	
			    //throw e;
		} finally {
			closeSession(session); // 不管事务执行成功与否，最后都要关闭session
		}	
		return false;         
	}
	/**
	 * 修改一条数据
	 * @param Object 要被更新的实体Bean（游离状态）
	 * @return boolean 表示插入是否成功
	 * @throws HibernateException
	 * @others 这个Object应该处于游离状态（deteched）；
	 */
	public boolean update(Object dataObject)throws HibernateException {

		boolean updateResult = true;

		// 初始化session and transaction
		Session session = null;
		Transaction tx = null;

		try {
			session = openHibernateSession();
			tx = session.beginTransaction();
			session.update(dataObject);
			tx.commit();
			return updateResult;
			
		} catch (HibernateException e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();	// 如果不成功则rollback
			//throw e;
		} finally {
			closeSession(session);	// 不管事务执行成功与否，最后都要关闭session
		}
		return false;         
	}
	/**
	 * 查找一个表中每一条数据
	 * @param sOperName 操作名称
	 * @param tableName 数据表名称
	 * @return
	 */
	public java.util.List queryAll(String tableName) throws HibernateException{
		
		//初始化session and transaction
		Session session = null;
		Transaction tx = null;
		
		try {			
			
			session = openHibernateSession();
			tx = session.beginTransaction();
			
			Query query = session.createQuery("from " + tableName);														
			java.util.List ql= query.list();			
			tx.commit();				
			return(ql);
												
		} catch (HibernateException e) {
			e.printStackTrace();						
		} finally {
			closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	
	    return null;       
   }  

	/**
	 * 删除一条数据
	 * @param  Object 要被删除的数据对应的实体Bean
	 * @return  boolean值 表示插入是否成功
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */
	public boolean del(Object dataObject)throws HibernateException {
		Session session = null;
		Transaction tx = null;

		try {	
			session = openHibernateSession();
			tx = session.beginTransaction();			
			session.delete(dataObject);
			tx.commit();
			return true;			
		} catch (HibernateException e) {
			if (null != tx)
				tx.rollback();	// 如果不成功则rollback
		} finally {
			closeSession(session);// 不管事务执行成功与否，最后都要关闭session
		}
		return false;
	}
	/**
	 * @param 凭ID返回一条记录
	 * @param  Object 查询出来的数据对应的实体Bean
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */  
	public Object queryById(String tableName,Integer id) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c.id=:key")
				.setInteger("key",id);			
				
			Iterator itr= query.iterate();//也可以不用迭代器,若用query.uniqueResult()则直接返回的是Object
			tx.commit();	
							
			//如果查询得到的it为空则返回null
			if (!itr.hasNext()) {
				return null;  
			}
			
			Object obj = (Object) itr.next();			
			return obj;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	/**
	 * 凭外键返回记录集合
	 * @param  tableName是数据库表名
	 * @param  fkName是外键的名称
	 * @param  fkValue是外键的值
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */  
	public List queryByFkey(String tableName,String fkName,Integer fkValue) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c."+fkName+"=:key")
				.setInteger("key",fkValue);			
				
			List list = query.list();
			tx.commit();	
			return list;											
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	/**
	 * 凭数据库表的列名返回记录集合
	 * @param  tableName是数据库表名
	 * @param  fkName是外键的名称
	 * @param  fkValue是外键的值
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */  
	public List querysByColumnName(String tableName,String colName,String colValue) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c."+colName+"=:colName")
				.setString("colName",colValue);			
            List list = query.list();			
			return list;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	/**
	 * 凭数据库表的列名返回一条记录
	 * @param  tableName是数据库表名
	 * @param  fkName是外键的名称
	 * @param  fkValue是外键的值
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */   
	public Object queryByColumnName(String tableName,String colName,String colValue) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c."+colName+"=:colName")
				.setString("colName",colValue);			
				
			Iterator itr= query.iterate();//也可以不用迭代器,若用query.uniqueResult()则直接返回的是Object
			tx.commit();	
							
			//如果查询得到的it为空则返回null
			if (!itr.hasNext()) {
				return null;  
			}
			Object obj = (Object) itr.next();			
			return obj;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	
	/**
	 * 凭数据库表的列名返回记录集合
	 * @param  tableName是数据库表名
	 * @param  colName是列称
	 * @param  colValue是列值
	 * @throws HibernateException
	 */  
	public List queryByColumnNames(String tableName,String colName1,Integer colValue1,String colName2,Integer colValue2) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();	
			String sql = "from "+tableName+" as c where c."+colName1+"=:colV1"+" and c."+colName2+"=:colV2";
			Query query = session.createQuery(sql);
			query.setInteger("colV1", colValue1);
			query.setInteger("colV2", colValue2);
			
			
				//.setInteger("colName",colValue);			
            List list = query.list();			
			return list;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	
	/**
	 * 凭数据库表的列名返回记录集合
	 * @param  tableName是数据库表名
	 * @param  colName是列称
	 * @param  colValue是列值
	 * @throws HibernateException
	 */  
	public List queryByColumnNames(String tableName,String colName1,Integer colValue1,String colName2,String colValue2) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c."+colName1+"=:colV1"+" and c."+colName2+"=:colV2" );
			query.setInteger("colV1", colValue1);
			query.setString("colV2", colValue2);  
			
				//.setInteger("colName",colValue);			
            List list = query.list();			
			return list;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	
	
	/**
	 * 凭数据库表的列名返回一条记录
	 * @param  tableName是数据库表名
	 * @param  fkName是外键的名称
	 * @param  fkValue是外键的值
	 * @throws HibernateException
	 * @others  这里不能删除处于持久状态（persistent）的Object
	 */   
	public Object queryByPwdAndUser(String tableName,String colName1,String colValue1,String colName2,String colValue2) {    	
    	//初始化session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
					"from "+tableName+" as c where c."+colName1+"=:colValue1"+" and c."+colName2+"=:colValue2"
			);		
			query.setString("colValue1", colValue1);
			query.setString("colValue2", colValue2);
			Iterator itr= query.iterate();//也可以不用迭代器,若用query.uniqueResult()则直接返回的是Object
			tx.commit();				
			//如果查询得到的it为空则返回null
			if (!itr.hasNext()) {
				return null;  
			}
			
			Object record = itr.next();			
			return record;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//不管事务执行成功与否，最后都要关闭session
		}    	    	 
		return null;
	}
	
}  
