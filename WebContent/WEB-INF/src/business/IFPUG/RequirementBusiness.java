package business.IFPUG;


import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugProduct;
import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugUser;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import net.sf.hibernate.HibernateException;
import entityOperation.IFPUG.ElementaryProcessDAO;
import entityOperation.IFPUG.FunctionDAO;
import entityOperation.IFPUG.ProductDAO;
import entityOperation.IFPUG.UserDAO;

public class RequirementBusiness {
	public Integer nodeNum = 0;
	
	/********************************************对产品的操作*********************************************/

	//插入待估算的软件信息
	public boolean insertProduct(Object dataObject) throws HibernateException {
		ProductDAO pd = new ProductDAO();
		if (pd.insertProduct(dataObject) == true)
			return true;
		else
			return false;
	}
	//按ID删除产品
	public boolean delProductById(Integer id) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		return pd.delProductById(id);
	}
	/*与updateDataGroup(Integer componentId)不同，按组件信息进行更新,参数中的组件信息为游离态*/
	public boolean updateProduct(Object dataObject) throws HibernateException {
		ProductDAO pd = new ProductDAO();
		if (pd.updateProduct(dataObject) == true)
			return true;
		else
			return false;
	}
	//查询所有软件的信息，返回所有软件的信息列表
	public List getAllProduct(String username) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		IfpugUser user = (IfpugUser)pd.queryByColumnName("IfpugUser", "username", username);
		return pd.queryAllProductByUser(user.getId());
	}	
	public Object getProductById(Integer id) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		return pd.queryProductById(id);
	}
	//判断产品的估算状态能否修改
	public Integer editProductEstimateCheck(Integer productId){
		Integer editEstimate = 0, listLen = 0;
		Short status = 0;
		ProductDAO pd = new ProductDAO();
		IfpugProduct product = (IfpugProduct)pd.queryProductById(productId);
		Object[] functionList = product.getIfpugFunctions().toArray();
		listLen = functionList.length;
		if(functionList == null || listLen == 0) { //该产品不包含模块----------设定为未估算状态
			product.setMeasureStatus(Short.valueOf("0"));
			editEstimate = 0;
		}
		else {//该产品包含了功能模块，将所有功能模块的估算状态相加
			for(Object f:functionList){
				IfpugFunction function = (IfpugFunction)f;
				status += function.getMeasureStatus();
			}
			if (status == 0) editEstimate = 0;  //如果估算状态和为0，说明全都未估算，可修改为未估算状态
			else if(status == 2*functionList.length) editEstimate = 2; //如果估算状态和为2*，说明全部估算，可修改为已估算状态
			else  editEstimate = 1;  //否则为部分估算，可修改为部分估算
		}
		return editEstimate;
	}
	
	/*************************************************对功能模块的操作***************************************/
	//添加第一层功能模块
	public boolean insertFunction(Object dataObject){
		FunctionDAO fd = new FunctionDAO();
	    try {
			return fd.insertFunction(dataObject);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	//按ID获取function对象
	public Object getFunctionById(Integer id) throws HibernateException{
		FunctionDAO fd = new FunctionDAO();
		return fd.queryFunctionById(id);
	}
	
	//按ID删除功能
	public boolean delFunctionById(Integer id) throws HibernateException{
		FunctionDAO fd = new FunctionDAO();
		return fd.delFunctionById(id);
	}
	

	/*判断模块类型能否修改
	 * editType = 0 不能修改
	 * editType = 1 原子模块能改成组合模块
	 * editType = 2 组合模块能改成原子模块
	 * **/
	public Integer editFunctionTypeCheck(Integer functionId)
	{	
		Integer editType = 0;
		FunctionDAO fd = new FunctionDAO();
		IfpugFunction function = (IfpugFunction)fd.queryFunctionById(functionId);
		if (function.getFunctionType() == 1) //如果是原子模块。=>组合模块，条件：原子模块中没有基本流程
		{
			Object[] eiList = function.getIfpugEis().toArray();
			Object[] eoList = function.getIfpugEos().toArray();
			Object[] eqList = function.getIfpugEqs().toArray();
			
			if ((eiList == null || eiList.length == 0)&&(eoList == null || eoList.length == 0)&&(eqList == null || eqList.length == 0))
				editType = 1;	
			else editType = 2;
		}
		else { //如果是组合模块。=>原子模块，条件：组合模块中没有子模块
			Object[] childFunctionList = function.getIfpugFunctions().toArray();
			if(childFunctionList == null || childFunctionList.length == 0)
				editType = 3;
			else editType = 4;
		}
		return editType;
	}
	
	/*判断估算状态能否修改
	 *editStatus = 0；可修改为未估算状态
	 *editStatus = 1；可修改为部分估算状态
	 *editStatus = 2；可修改为已估算状态
	 * **/
	public Integer editFunctionEstimateCheck(Integer functionId)
	{
		Integer editStatus = 0, length = 0;
		FunctionDAO fd = new FunctionDAO();
		IfpugFunction function = (IfpugFunction)fd.queryFunctionById(functionId);
		if (function.getFunctionType() == 1){//如果模块是原子模块。判断其估算状态。
			Object[] eiList = function.getIfpugEis().toArray();
			Object[] eoList = function.getIfpugEos().toArray();
			Object[] eqList = function.getIfpugEqs().toArray();			
			List list = getEpAfterMerge(function);
			length = list.size();
			if (list == null||list.size() == 0)
				//如果基本流程全为空,可修改为未估算状态
				return 0;	
			else{ //如果基本流程非空，获取所有基本流程的估算状态之和。
				for(Object e:eiList){
					IfpugEi ei = (IfpugEi)e;
					editStatus += ei.getMeasureStatus();
				}
				for (Object e:eoList){
					IfpugEo eo = (IfpugEo)e;
					editStatus += eo.getMeasureStatus();
				}
				for (Object e:eqList){
					IfpugEq eq = (IfpugEq)e;
					editStatus += eq.getMeasureStatus();
				}
			} 
		}
		else {//如果是组合模块，分析其所有子模块的估算状态
			Object[] childFunctionList = function.getIfpugFunctions().toArray();
			if(childFunctionList == null || childFunctionList.length == 0)
				return 0;
			else {
				for(Object f:childFunctionList){
					 IfpugFunction childFunction = (IfpugFunction)f;
					 editStatus += childFunction.getMeasureStatus();
				}				
			}
		}
		if(editStatus == 0) return 0;
		else if (editStatus == 2*length)  return 2;
		else return 1;
	}
	
	/***********************************************对基本流程的操作*****************************************/

	//添加基本流程elementaryProcess
	public boolean insertElementaryProcess(Object dataObject) throws HibernateException{
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
	    return epd.addElementaryProcess(dataObject);
	}
	//按ID获取基本流程
	public Object getElementaryProcessById(Integer type,Integer id){
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
		if (type == 0){
			return epd.queryEiById(id);
		}
		else if(type == 1){
			return epd.queryEoById(id);
		}
		else {
			return epd.queryEqById(id);
		}
	}
	//按ID删除基本流程
	public boolean delElementaryProcessById(Integer type,Integer id){
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
		Object epObject = getElementaryProcessById(type,id);
		System.out.println("type:"+type+"id:"+id);
		return epd.delElementaryProcess(epObject);
	}
	
	
	/*更新基本流程*/
	public boolean updateElementaryProcess(Object dataObject) {
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
		if (epd.updateElementaryProcess(dataObject) == true)
			return true;
		else
			return false;
	}

	
	//将三种类型的EP合并存放在一个list里
	public List getEpAfterMerge(IfpugFunction function)
	{
		 /*分别先取出功能模块对应的EI、EO、EQ类型基本流程*/
	       Object[] eiList = function.getIfpugEis().toArray();
	       Object[] eoList = function.getIfpugEos().toArray();
	       Object[] eqList = function.getIfpugEqs().toArray();
	       /*用一个数组把这三个数组存放在一起，便于共用一段代码显示*/
	       List list = new ArrayList();
	       for (Object e:eiList){
	       		list.add(e);
	       }
	       for (Object e:eoList){
	       		list.add(e);
	       }
	        for (Object e:eqList){
	       		list.add(e);
	       }
	       return list;
	}
	
	public String changeMeausreStatus (Short status)
	{
		String strStatus = null;
		switch(status)
		{
		case 0:
			strStatus = "未估算";
			break;
		case 1:
			strStatus ="部分估算";
			break;
		case 2:
			strStatus ="已估算";
			break;
		}
		return strStatus;
	}
	
	public String changeEpType (Integer type)
	{
		String strType = null;
		switch(type)
		{
		case 0:
			strType = "EI";
			break;
		case 1:
			strType = "EO";
			break;
		case 2:
			strType = "EQ";
			break;
		}
		return strType;
	}
	 //下面这段代码用于得到该软件产品所有的节点个数
	public Integer getNodeCount(IfpugFunction function)
	{
		Short functionType = function.getFunctionType();
		if(functionType == 0)//如果该功能模块是组合模块
		{
			Object[] childFunctionList = function.getIfpugFunctions().toArray();
			for (Object f:childFunctionList)
			{
				IfpugFunction childFunction = (IfpugFunction)f;
				nodeNum += getNodeCount(childFunction);
			}
		}
		else {//如果是原子模块
			nodeNum += function.getIfpugEis().size() + function.getIfpugEos().size() + function.getIfpugEqs().size();
		}
		return nodeNum;
	}
	public Date formatStrToDate(String dateStr)
	{
		String[] splitStr = dateStr.split("-");
		System.out.println(splitStr[0]+"/"+splitStr[1]+"/"+splitStr[2]);
		if(Integer.valueOf(splitStr[1]) < 10) splitStr[1]="0"+splitStr[1];
		if(Integer.valueOf(splitStr[2]) < 10) splitStr[2]="0"+splitStr[2];
		dateStr= splitStr[0]+"-"+splitStr[1]+"-"+splitStr[2];
		Date date = Date.valueOf(dateStr);
		return date;
		
	}
	
	
	public static void main(String args[]) {
		RequirementBusiness rb = new RequirementBusiness();
		/*System.out.println("Hello World!");
		Integer result = 0;
		result = rb.editFunctionEstimateCheck(10);
		//result = rb.editFunctionTypeCheck(43);
		System.out.println(result);*/
		String dateStr="2011-9-9";
		Date date  = rb.formatStrToDate(dateStr);
		System.out.println(date);
		
		
	}
}

