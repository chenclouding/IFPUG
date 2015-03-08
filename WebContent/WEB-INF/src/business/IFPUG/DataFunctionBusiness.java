package business.IFPUG;

import java.util.List;

import net.sf.hibernate.HibernateException;
import entityOperation.IFPUG.DataFunctionDAO;

public class DataFunctionBusiness {

	/*****************************************对内部逻辑文件ILF的操作*********************************************/

	//插入系统内部逻辑文件
	public boolean insertIlf(Object dataObject) throws HibernateException {
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertIlf(dataObject) == true)
			return true;
		else 
			return false;
	}
	//获取所有系统内部文件ILF
	public List queryAllIlf() throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryAllIlf();
	}
	//根据Id获取系统内部文件ILF
	public Object queryIlfById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfById(id);		
	}
	//按ID删除ILF文件
	public boolean delIlfById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfById(id);
	}
	//更新ILF\EIF文件
	public boolean updateDataFunction(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateDataFunction(dataObject)== true)
			return true;
		else
			return false;
	}
	/***********************ILF******************对记录元素RET的操作********************************************
	 * @throws HibernateException */
	//按ID删除ILF文件下的RET
	public boolean delIlfRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfRetById(id);
	}
	//根据Id获取系统内部文件ILF的RET
	public Object queryIlfRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfRetById(id);		
	}
	/***********************ILF******************对记录元素DET的操作********************************************
	 * @throws HibernateException */
	//按ID删除ILF文件下的DET
	public boolean delIlfDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfDetById(id);
	}
	//根据Id获取系统内部文件ILF的DET
	public Object queryIlfDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfDetById(id);		
	}
	/***********************ILF******************对记录方法Method的操作********************************************
	 * @throws HibernateException */
	//按ID删除ILF文件下的DET
	public boolean delIlfMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delIlfMethodById(id);
	}
	//根据Id获取系统内部文件ILF的DET
	public Object queryIlfMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryIlfMethodById(id);		
	}
	
	
	/*****************************************对外部接口文件EIF的操作********************************************
	 * @throws HibernateException */

	//插入外部接口文件EIF
	public boolean insertEif(Object dataObject) throws HibernateException {
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertEif(dataObject) == true)
			return true;
		else 
			return false;
	}
	//获取所有外部接口文件EIF
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
	//根据Id获取外部接口文件EIF
	public Object queryEifById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifById(id);		
	}
	//按ID删除EIF文件
	public boolean delEifById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifById(id);
	}
	
	/*********************ILF\EIF********************对RET的操作********************************************
	 * @throws HibernateException */
	//插入RET
	public boolean insertRet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertRet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//更新RET
	public boolean updateRet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateRet(dataObject)== true)
			return true;
		else
			return false;
	}
	/*********************ILF\EIF********************对dET的操作********************************************
	 * @throws HibernateException */
	//插入RET
	public boolean insertDet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertDet(dataObject) == true)
			return true;
		else 
			return false;
	}
	//更新RET
	public boolean updateDet(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateDet(dataObject)== true)
			return true;
		else
			return false;
	}
	/*********************ILF\EIF********************对method的操作********************************************
	 * @throws HibernateException */
	//插入method
	public boolean insertMethod(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if(dd.insertMethod(dataObject) == true)
			return true;
		else 
			return false;
	}
	//更新method
	public boolean updateMethod(Object dataObject) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		if (dd.updateMethod(dataObject)== true)
			return true;
		else
			return false;
	}
	/***********************EIF******************对记录元素RET的操作*********************************************/
	//按ID删除EIF文件下的RET
	public boolean delEifRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifRetById(id);
	}
	//根据Id获取EIF文件下的RET
	public Object queryEifRetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifRetById(id);		
	}
	/***********************EIF******************对记录元素DET的操作*********************************************/
	//按ID删除EIF文件下的RET
	public boolean delEifDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifDetById(id);
	}
	//根据Id获取EIF文件下的RET
	public Object queryEifDetById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifDetById(id);		
	}
	/***********************EIF******************对方法Method的操作********************************************
	 * @throws HibernateException */
	//按ID删除ILF文件下的Method
	public boolean delEifMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.delEifMethodById(id);
	}
	//根据Id获取系统内部文件ILF的Method
	public Object queryEifMethodById(Integer id) throws HibernateException{
		DataFunctionDAO dd = new DataFunctionDAO();
		return dd.queryEifMethodById(id);		
	}
	
	//获得文件类型名称
	public String getTypeName(Integer type)
	{
		String name;
		if(type == 0) name ="ILF(内部逻辑文件)";
		else name = "EIF(外部接口文件)";
		return name;
	}
	//获得估算方法名称
	public String getMethodName(Short method)
	{
		String name = null;
		switch(method)
		{
		case 0: name="手动导入DET"; break;
		case 1: name="默认功能点个数"; break;
		case 2: name="选择DET范围"; break;
		case 3: name ="输入DET个数"; break;
		case 4: name ="选择复杂度"; break;		
		}
		return name;
	}
	
}
