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
	
	/********************************************�Բ�Ʒ�Ĳ���*********************************************/

	//���������������Ϣ
	public boolean insertProduct(Object dataObject) throws HibernateException {
		ProductDAO pd = new ProductDAO();
		if (pd.insertProduct(dataObject) == true)
			return true;
		else
			return false;
	}
	//��IDɾ����Ʒ
	public boolean delProductById(Integer id) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		return pd.delProductById(id);
	}
	/*��updateDataGroup(Integer componentId)��ͬ���������Ϣ���и���,�����е������ϢΪ����̬*/
	public boolean updateProduct(Object dataObject) throws HibernateException {
		ProductDAO pd = new ProductDAO();
		if (pd.updateProduct(dataObject) == true)
			return true;
		else
			return false;
	}
	//��ѯ�����������Ϣ�����������������Ϣ�б�
	public List getAllProduct(String username) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		IfpugUser user = (IfpugUser)pd.queryByColumnName("IfpugUser", "username", username);
		return pd.queryAllProductByUser(user.getId());
	}	
	public Object getProductById(Integer id) throws HibernateException{
		ProductDAO pd = new ProductDAO();
		return pd.queryProductById(id);
	}
	//�жϲ�Ʒ�Ĺ���״̬�ܷ��޸�
	public Integer editProductEstimateCheck(Integer productId){
		Integer editEstimate = 0, listLen = 0;
		Short status = 0;
		ProductDAO pd = new ProductDAO();
		IfpugProduct product = (IfpugProduct)pd.queryProductById(productId);
		Object[] functionList = product.getIfpugFunctions().toArray();
		listLen = functionList.length;
		if(functionList == null || listLen == 0) { //�ò�Ʒ������ģ��----------�趨Ϊδ����״̬
			product.setMeasureStatus(Short.valueOf("0"));
			editEstimate = 0;
		}
		else {//�ò�Ʒ�����˹���ģ�飬�����й���ģ��Ĺ���״̬���
			for(Object f:functionList){
				IfpugFunction function = (IfpugFunction)f;
				status += function.getMeasureStatus();
			}
			if (status == 0) editEstimate = 0;  //�������״̬��Ϊ0��˵��ȫ��δ���㣬���޸�Ϊδ����״̬
			else if(status == 2*functionList.length) editEstimate = 2; //�������״̬��Ϊ2*��˵��ȫ�����㣬���޸�Ϊ�ѹ���״̬
			else  editEstimate = 1;  //����Ϊ���ֹ��㣬���޸�Ϊ���ֹ���
		}
		return editEstimate;
	}
	
	/*************************************************�Թ���ģ��Ĳ���***************************************/
	//��ӵ�һ�㹦��ģ��
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
	//��ID��ȡfunction����
	public Object getFunctionById(Integer id) throws HibernateException{
		FunctionDAO fd = new FunctionDAO();
		return fd.queryFunctionById(id);
	}
	
	//��IDɾ������
	public boolean delFunctionById(Integer id) throws HibernateException{
		FunctionDAO fd = new FunctionDAO();
		return fd.delFunctionById(id);
	}
	

	/*�ж�ģ�������ܷ��޸�
	 * editType = 0 �����޸�
	 * editType = 1 ԭ��ģ���ܸĳ����ģ��
	 * editType = 2 ���ģ���ܸĳ�ԭ��ģ��
	 * **/
	public Integer editFunctionTypeCheck(Integer functionId)
	{	
		Integer editType = 0;
		FunctionDAO fd = new FunctionDAO();
		IfpugFunction function = (IfpugFunction)fd.queryFunctionById(functionId);
		if (function.getFunctionType() == 1) //�����ԭ��ģ�顣=>���ģ�飬������ԭ��ģ����û�л�������
		{
			Object[] eiList = function.getIfpugEis().toArray();
			Object[] eoList = function.getIfpugEos().toArray();
			Object[] eqList = function.getIfpugEqs().toArray();
			
			if ((eiList == null || eiList.length == 0)&&(eoList == null || eoList.length == 0)&&(eqList == null || eqList.length == 0))
				editType = 1;	
			else editType = 2;
		}
		else { //��������ģ�顣=>ԭ��ģ�飬���������ģ����û����ģ��
			Object[] childFunctionList = function.getIfpugFunctions().toArray();
			if(childFunctionList == null || childFunctionList.length == 0)
				editType = 3;
			else editType = 4;
		}
		return editType;
	}
	
	/*�жϹ���״̬�ܷ��޸�
	 *editStatus = 0�����޸�Ϊδ����״̬
	 *editStatus = 1�����޸�Ϊ���ֹ���״̬
	 *editStatus = 2�����޸�Ϊ�ѹ���״̬
	 * **/
	public Integer editFunctionEstimateCheck(Integer functionId)
	{
		Integer editStatus = 0, length = 0;
		FunctionDAO fd = new FunctionDAO();
		IfpugFunction function = (IfpugFunction)fd.queryFunctionById(functionId);
		if (function.getFunctionType() == 1){//���ģ����ԭ��ģ�顣�ж������״̬��
			Object[] eiList = function.getIfpugEis().toArray();
			Object[] eoList = function.getIfpugEos().toArray();
			Object[] eqList = function.getIfpugEqs().toArray();			
			List list = getEpAfterMerge(function);
			length = list.size();
			if (list == null||list.size() == 0)
				//�����������ȫΪ��,���޸�Ϊδ����״̬
				return 0;	
			else{ //����������̷ǿգ���ȡ���л������̵Ĺ���״̬֮�͡�
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
		else {//��������ģ�飬������������ģ��Ĺ���״̬
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
	
	/***********************************************�Ի������̵Ĳ���*****************************************/

	//��ӻ�������elementaryProcess
	public boolean insertElementaryProcess(Object dataObject) throws HibernateException{
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
	    return epd.addElementaryProcess(dataObject);
	}
	//��ID��ȡ��������
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
	//��IDɾ����������
	public boolean delElementaryProcessById(Integer type,Integer id){
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
		Object epObject = getElementaryProcessById(type,id);
		System.out.println("type:"+type+"id:"+id);
		return epd.delElementaryProcess(epObject);
	}
	
	
	/*���»�������*/
	public boolean updateElementaryProcess(Object dataObject) {
		ElementaryProcessDAO epd = new ElementaryProcessDAO();
		if (epd.updateElementaryProcess(dataObject) == true)
			return true;
		else
			return false;
	}

	
	//���������͵�EP�ϲ������һ��list��
	public List getEpAfterMerge(IfpugFunction function)
	{
		 /*�ֱ���ȡ������ģ���Ӧ��EI��EO��EQ���ͻ�������*/
	       Object[] eiList = function.getIfpugEis().toArray();
	       Object[] eoList = function.getIfpugEos().toArray();
	       Object[] eqList = function.getIfpugEqs().toArray();
	       /*��һ���������������������һ�𣬱��ڹ���һ�δ�����ʾ*/
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
			strStatus = "δ����";
			break;
		case 1:
			strStatus ="���ֹ���";
			break;
		case 2:
			strStatus ="�ѹ���";
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
	 //������δ������ڵõ��������Ʒ���еĽڵ����
	public Integer getNodeCount(IfpugFunction function)
	{
		Short functionType = function.getFunctionType();
		if(functionType == 0)//����ù���ģ�������ģ��
		{
			Object[] childFunctionList = function.getIfpugFunctions().toArray();
			for (Object f:childFunctionList)
			{
				IfpugFunction childFunction = (IfpugFunction)f;
				nodeNum += getNodeCount(childFunction);
			}
		}
		else {//�����ԭ��ģ��
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

