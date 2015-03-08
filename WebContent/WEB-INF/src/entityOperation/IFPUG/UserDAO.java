package entityOperation.IFPUG;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hibernate.IFPUG.IfpugUser;
import net.sf.hibernate.HibernateException;

public class UserDAO extends BaseDAO{
	/**
	 *  �û�ע��
	 */		
	public boolean insertUser(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	public boolean queryByNameAndPwd(String username, String password) {    	
        IfpugUser record = (IfpugUser) queryByPwdAndUser("IfpugUser","username",username,"password",password);
        if (record == null) return false;
        else  return true;
    }
	
	/**
	 *  ��username���û���Ϣȡ����
	 */
	public Object queryRegByUserName(String userName) {
	    return queryByColumnName("IfpugUser","username",userName);

    }
	
	/**
	 *  ��ȡ�����û�
	 * @throws HibernateException 
	 */
	public List getAllUsers() throws HibernateException {
	    return queryAll("IfpugUser");

    }
	/**
	 *  ��Idɾ���û�
	 */
	public boolean delUserById(int userId) {
		Object obj = queryById("IfpugUser",userId);
	    try {
			return del(obj);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

    }
	
}
