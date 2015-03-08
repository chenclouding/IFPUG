package entityOperation.IFPUG;

import java.util.List;

import net.sf.hibernate.HibernateException;

public class DataFunctionDAO extends BaseDAO{
	/*-------------------------------------对数据库表ILF的操作--------------------------*/
	/**
	 *  插入内部逻辑文件ILF
	 */		
	public boolean insertIlf(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  获取所有内部逻辑文件ILF
	 * @throws HibernateException 
	 */	
	public List queryAllIlf() throws HibernateException{	
        return queryAll("IfpugIlf");
	}
	/**
	 *  根据ID获取内部逻辑文件ILF
	 * @throws HibernateException 
	 */	
	public Object queryIlfById(Integer id) throws HibernateException{	
        return queryById("IfpugIlf",id);
	}
	/**
	 *  根据Id删除内部逻辑文件ILF
	 * @throws HibernateException  
	 */
	public boolean delIlfById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlf",id);
		return del(obj);
	}
	/**
	 *  更新内部逻辑文件ILF\EIF
	 * @throws HibernateException 
	 */
	public boolean updateDataFunction(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/*--------------------------ILF-----------对数据库表RET的操作--------------------------*/
	/**
	 *  根据Id删除内部逻辑文件ILF包含的RET
	 * @throws HibernateException 
	 *  */
	public boolean delIlfRetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfRet",id);
		return del(obj);
	}
	/**
	 *  根据ID获取内部逻辑文件EIF包含的RET
	 * @throws HibernateException 
	 */	
	public Object queryIlfRetById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfRet",id);
	}
	
	/*--------------------------ILF-----------对数据库表DET的操作--------------------------*/
	/**
	 *  根据Id删除内部逻辑文件ILF包含的DET
	 * @throws HibernateException 
	 *  */
	public boolean delIlfDetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfDet",id);
		return del(obj);
	}
	/**
	 *  根据ID获取内部逻辑文件EIF包含的RET
	 * @throws HibernateException 
	 */	
	public Object queryIlfDetById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfDet",id);
	}
	/*--------------------------ILF-----------对数据库表METHOD的操作--------------------------*/
	/**
	 *  根据Id删除内部逻辑文件ILF包含的METHOD
	 * @throws HibernateException 
	 *  */
	public boolean delIlfMethodById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfMethod",id);
		return del(obj);
	}
	/**
	 *  根据ID获取内部逻辑文件ILF包含的METHOD
	 * @throws HibernateException 
	 */	
	public Object queryIlfMethodById(Integer id) throws HibernateException{	
        return queryById("IfpugIlfMethod",id);
	}
	
	/*-------------------------------------对数据库表EIF的操作--------------------------*/
	/**
	 *  插入外部接口文件EIF
	 */		
	public boolean insertEif(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  获取所有外部接口文件EIF
	 */	
	public List queryAllEif() throws HibernateException {	
        return queryAll("IfpugEif");
	}
	/**
	 *  根据ID获取外部接口文件EIF
	 * @throws HibernateException 
	 */	
	public Object queryEifById(Integer id) throws HibernateException{	
        return queryById("IfpugEif",id);
	}
	/**
	 *  根据Id删除外部接口文件EIF
	 * @throws HibernateException 
	 */
	public boolean delEifById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEif",id);
		return del(obj);
	}
	/*-------------------------ILF/EIF------------对数据库表RET的操作--------------------------*/
	/**
	 *  插入RET
	 */
	public boolean insertRet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  更新RET
	 * @throws HibernateException 
	 */
	public boolean updateRet(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	/*-------------------------ILF/EIF------------对数据库表DET的操作--------------------------*/
	/**
	 *  插入DET
	 */
	public boolean insertDet(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  更新DET
	 * @throws HibernateException 
	 */
	public boolean updateDet(Object dataObject) throws HibernateException{
		return update(dataObject);
	}
	
	/*-------------------------ILF/EIF------------对数据库表Method的操作--------------------------*/
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
	/*--------------------------EIF-----------对数据库表RET的操作--------------------------*/
	/**
	 *  根据Id删除外部接口文件ILF包含的RET
	 * @throws HibernateException 
	 *  */
	public boolean delEifRetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEifRet",id);
		return del(obj);
	}
	/**
	 *  根据ID获取外部接口文件EIF包含的RET
	 * @throws HibernateException 
	 */	
	public Object queryEifRetById(Integer id) throws HibernateException{	
        return queryById("IfpugEifRet",id);
	}
	/*--------------------------EIF-----------对数据库表DET的操作--------------------------*/
	/**
	 *  根据Id删除内部逻辑文件ILF包含的RET
	 * @throws HibernateException 
	 *  */
	public boolean delEifDetById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugIlfDet",id);
		return del(obj);
	}
	/**
	 *  根据ID获取内部逻辑文件EIF包含的RET
	 * @throws HibernateException 
	 */	
	public Object queryEifDetById(Integer id) throws HibernateException{	
        return queryById("IfpugEifDet",id);
	}
	/*--------------------------EIF-----------对数据库表METHOD的操作--------------------------*/
	/**
	 *  根据Id删除内部逻辑文件EIF包含的METHOD
	 * @throws HibernateException 
	 *  */
	public boolean delEifMethodById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugEifMethod",id);
		return del(obj);
	}
	/**
	 *  根据ID获取内部逻辑文件EIFF包含的METHOD
	 * @throws HibernateException 
	 */	
	public Object queryEifMethodById(Integer id) throws HibernateException{	
        return queryById("IfpugEifMethod",id);
	}
}
