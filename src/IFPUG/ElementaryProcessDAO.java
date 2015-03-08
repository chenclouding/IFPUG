package entityOperation.IFPUG;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

public class  ElementaryProcessDAO extends BaseDAO{	
	
	private Session session;
	/**
	 *  插入基本流程
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
	 *  按实体对象删除基本流程
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
	 *  按id（主键）将EI类型的基本流程取出来
	 */
	public Object queryEiById(Integer id) {    	
		return queryById("IfpugEi",id);
    }
	/**
	 *  按id（主键）将EO类型的基本流程取出来
	 */
	public Object queryEoById(Integer id) {    	
		return queryById("IfpugEo",id);
    }
	/**
	 *  按id（主键）将EQ类型的基本流程取出来
	 */
	public Object queryEqById(Integer id) {    	
		return queryById("IfpugEq",id);
    }
	/**
	 *  按id（主键）将EI类型的DET取出来
	 */
	public Object queryEiDetById(Integer id) {    	
		return queryById("IfpugEiDet",id);
    }
	/**
	 *  按id（主键）将EO类型的基本流程取出来
	 */
	public Object queryEoDetById(Integer id) {    	
		return queryById("IfpugEoDet",id);
    }
	/**
	 *  按id（主键）将EQ类型的基本流程取出来
	 */
	public Object queryEqDetById(Integer id) {    	
		return queryById("IfpugEqDet",id);
    }
	
	/**
	 *  更新基本流程
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
	 *  插入Method
	 */
	public boolean insertMethod(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  更新Method
	 * @throws HibernateException 
	 */
	public boolean updateMethod(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/**
	 *  插入DET
	 */
	public boolean insertDet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
}


