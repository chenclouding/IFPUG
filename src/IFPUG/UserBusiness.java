package business.IFPUG;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import hibernate.IFPUG.IfpugUser;
import net.sf.hibernate.HibernateException;
import entityOperation.IFPUG.UserDAO;

public class UserBusiness {
	/***********************************************��ע���û��Ĳ���*****************************************/
	//�û�ע��
	public boolean insertUser(Object dataObject) throws HibernateException {
		UserDAO ud = new UserDAO();
		if (ud.insertUser(dataObject) == true)
			return true;
		else
			return false;
	}
	
	//ͨ��UserId��ѯusername
	public static int getUserIdByUserName(String userName){
		UserDAO ud = new UserDAO();
		return ((IfpugUser)ud.queryRegByUserName(userName)).getId();
	}
	//ͨ��Username��ѯuser
	public  IfpugUser getUserByUserName(String userName){
		UserDAO ud = new UserDAO();
		return (IfpugUser)ud.queryRegByUserName(userName);
	}
	//ͨ��Username��ѯuser
	public  IfpugUser getUserByNameAndId(String userName,String password){
		UserDAO ud = new UserDAO();
		return (IfpugUser)ud.queryByPwdAndUser("IfpugUser","username", userName, "password", password);
	}
	
	//get all of the users registered
	public static List getAllUsers(){
		UserDAO ud = new UserDAO();
		List users;
		try {
			users = ud.getAllUsers();
			return users;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	//del user registerId by id
	public static boolean delUserById(int userId){
		UserDAO ud = new UserDAO();
		return ud.delUserById(userId);
	}
	
	public boolean isUserExist(String userName)
	{
		UserDAO ud = new UserDAO();
		return (ud.queryRegByUserName(userName)==null)?false:true;
	}
	public boolean isValidateUser(String userName, String password)
	{
		boolean isValidate = false;
		if (!isUserExist(userName)) {
			return false;
			
		}
		UserDAO ud = new UserDAO();
		isValidate = ud.queryByPwdAndUser("IfpugUser", "username", userName, "password", password)==null?false:true;
		System.out.println("exist2");
		return isValidate;
	}
}
