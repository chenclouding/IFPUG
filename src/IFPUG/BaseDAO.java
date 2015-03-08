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
 * ��Hibernate�ṩ�ĳ־ò�������ӡ����á��رղ���
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
	 * ͨ��Ĭ�ϵ�config�ļ� ������ session factory
	 */	
	protected static Session openHibernateSession() {
		try {

			// ��һ��Session��ÿִ��һ�����ݿ����񣬶�Ҫ����һ���µ�sessionʵ��
			Session s = sessionFactory.openSession();
			return (s);

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * �ر�Session
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
	
	
	/*---------FSM�ĳ����У���д������Щ���������ڿ���̨�������HibernateLog��Ϣ�������Ч�ʡ�
	 * --------���ϵļ������ݿ��������insert��update�ȣ�ʵ�ʲ�û�а���־д�뵽tomcat�С�
	 * --------�������ڿ���̨���дprinter��䣬����û��Ҫ����HibernateLog����-------*/
	/**
	 * ����һ������
	 * @param Object Ҫ�����뵽���ݿ��е�ʵ��Bean
	 * @return  boolean ��ʾ�����Ƿ�ɹ�
	 * @throws  HibernateException
	 */
	public boolean insert(Object dataObject)throws HibernateException {

		boolean insertResult = true;
		Session session = null;
		Transaction tx = null;
		try {
			// ��ȡsession����ʼtransaction
			session = openHibernateSession();
			tx = session.beginTransaction();
			// �������� �ύ����
			session.save(dataObject);
			tx.commit();// �ύ		
			return insertResult;
		} catch (HibernateException e) {
			e.printStackTrace();
			if (null != tx)
				tx.rollback();	// ������ɹ���rollback	
			    //throw e;
		} finally {
			closeSession(session); // ��������ִ�гɹ�������Ҫ�ر�session
		}	
		return false;         
	}
	/**
	 * �޸�һ������
	 * @param Object Ҫ�����µ�ʵ��Bean������״̬��
	 * @return boolean ��ʾ�����Ƿ�ɹ�
	 * @throws HibernateException
	 * @others ���ObjectӦ�ô�������״̬��deteched����
	 */
	public boolean update(Object dataObject)throws HibernateException {

		boolean updateResult = true;

		// ��ʼ��session and transaction
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
				tx.rollback();	// ������ɹ���rollback
			//throw e;
		} finally {
			closeSession(session);	// ��������ִ�гɹ�������Ҫ�ر�session
		}
		return false;         
	}
	/**
	 * ����һ������ÿһ������
	 * @param sOperName ��������
	 * @param tableName ���ݱ�����
	 * @return
	 */
	public java.util.List queryAll(String tableName) throws HibernateException{
		
		//��ʼ��session and transaction
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
			closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	
	    return null;       
   }  

	/**
	 * ɾ��һ������
	 * @param  Object Ҫ��ɾ�������ݶ�Ӧ��ʵ��Bean
	 * @return  booleanֵ ��ʾ�����Ƿ�ɹ�
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
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
				tx.rollback();	// ������ɹ���rollback
		} finally {
			closeSession(session);// ��������ִ�гɹ�������Ҫ�ر�session
		}
		return false;
	}
	/**
	 * @param ƾID����һ����¼
	 * @param  Object ��ѯ���������ݶ�Ӧ��ʵ��Bean
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
	 */  
	public Object queryById(String tableName,Integer id) {    	
    	//��ʼ��session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c.id=:key")
				.setInteger("key",id);			
				
			Iterator itr= query.iterate();//Ҳ���Բ��õ�����,����query.uniqueResult()��ֱ�ӷ��ص���Object
			tx.commit();	
							
			//�����ѯ�õ���itΪ���򷵻�null
			if (!itr.hasNext()) {
				return null;  
			}
			
			Object obj = (Object) itr.next();			
			return obj;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	/**
	 * ƾ������ؼ�¼����
	 * @param  tableName�����ݿ����
	 * @param  fkName�����������
	 * @param  fkValue�������ֵ
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
	 */  
	public List queryByFkey(String tableName,String fkName,Integer fkValue) {    	
    	//��ʼ��session and transaction
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
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	/**
	 * ƾ���ݿ����������ؼ�¼����
	 * @param  tableName�����ݿ����
	 * @param  fkName�����������
	 * @param  fkValue�������ֵ
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
	 */  
	public List querysByColumnName(String tableName,String colName,String colValue) {    	
    	//��ʼ��session and transaction
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
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	/**
	 * ƾ���ݿ�����������һ����¼
	 * @param  tableName�����ݿ����
	 * @param  fkName�����������
	 * @param  fkValue�������ֵ
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
	 */   
	public Object queryByColumnName(String tableName,String colName,String colValue) {    	
    	//��ʼ��session and transaction
		Session session = null;
		Transaction tx = null;		
		try {		
			session = openHibernateSession();
			tx = session.beginTransaction();		
			Query query = session.createQuery(
			"from "+tableName+" as c where c."+colName+"=:colName")
				.setString("colName",colValue);			
				
			Iterator itr= query.iterate();//Ҳ���Բ��õ�����,����query.uniqueResult()��ֱ�ӷ��ص���Object
			tx.commit();	
							
			//�����ѯ�õ���itΪ���򷵻�null
			if (!itr.hasNext()) {
				return null;  
			}
			Object obj = (Object) itr.next();			
			return obj;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	
	/**
	 * ƾ���ݿ����������ؼ�¼����
	 * @param  tableName�����ݿ����
	 * @param  colName���г�
	 * @param  colValue����ֵ
	 * @throws HibernateException
	 */  
	public List queryByColumnNames(String tableName,String colName1,Integer colValue1,String colName2,Integer colValue2) {    	
    	//��ʼ��session and transaction
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
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	
	/**
	 * ƾ���ݿ����������ؼ�¼����
	 * @param  tableName�����ݿ����
	 * @param  colName���г�
	 * @param  colValue����ֵ
	 * @throws HibernateException
	 */  
	public List queryByColumnNames(String tableName,String colName1,Integer colValue1,String colName2,String colValue2) {    	
    	//��ʼ��session and transaction
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
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	
	
	/**
	 * ƾ���ݿ�����������һ����¼
	 * @param  tableName�����ݿ����
	 * @param  fkName�����������
	 * @param  fkValue�������ֵ
	 * @throws HibernateException
	 * @others  ���ﲻ��ɾ�����ڳ־�״̬��persistent����Object
	 */   
	public Object queryByPwdAndUser(String tableName,String colName1,String colValue1,String colName2,String colValue2) {    	
    	//��ʼ��session and transaction
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
			Iterator itr= query.iterate();//Ҳ���Բ��õ�����,����query.uniqueResult()��ֱ�ӷ��ص���Object
			tx.commit();				
			//�����ѯ�õ���itΪ���򷵻�null
			if (!itr.hasNext()) {
				return null;  
			}
			
			Object record = itr.next();			
			return record;
												
		} catch (HibernateException e) {
		e.printStackTrace();						
		} finally { 
		closeSession(session);		//��������ִ�гɹ�������Ҫ�ر�session
		}    	    	 
		return null;
	}
	
}  
