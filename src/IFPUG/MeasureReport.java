package business.IFPUG;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugProduct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.sf.hibernate.HibernateException;



public class MeasureReport {
	public List eiList = new ArrayList();
	public List eoList = new ArrayList();
	public List eqList = new ArrayList();
	
	public MeasureReport(){}
	//�ݹ������л�������
	public void getEpFromFunction(Object f)
	{
		IfpugFunction function = (IfpugFunction)f;
		if(function.getFunctionType() == 1)//ԭ��ģ��
		{
			eiList.addAll(function.getIfpugEis());
			eoList.addAll(function.getIfpugEos());
			eqList.addAll(function.getIfpugEqs());
		}
		else //���ģ��
		{
			Object[] funcList = function.getIfpugFunctions().toArray();
			for (Object func:funcList)
			{
				getEpFromFunction(func);
			}
		}		
	}
	public String getStatusName(Short measureStatus)
	{
		String measureStatusName;
		 switch (measureStatus)  
         {
	         case 0:measureStatusName = "δ����";break;
	         case 1:measureStatusName = "���ֹ���";break;
	         case 2:measureStatusName = "ȫ������";break;
	         default:measureStatusName = "״̬����";
         } 
		 return measureStatusName;
	}
	
	public String exportMeasureReport(Integer productId){		
		String code = null ;		
	try{
		
		LinkedList<Object> queue = new LinkedList<Object>(); //����ն���
		RequirementBusiness rb = new RequirementBusiness();
		DataFunctionBusiness dfb = new DataFunctionBusiness();
		TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
		
		IfpugProduct root = null;		
		root = (IfpugProduct) rb.getProductById(productId);
		//ȡ������Ʒ
		//ȡ������Ʒ�����ݹ��ܺ�������
		Object[] ilfList = root.getIfpugIlfs().toArray();
		Object[] eifList = root.getIfpugEifs().toArray();
		Object[] functionList = root.getIfpugFunctions().toArray();
		
		for (Object f:functionList)
		{
			getEpFromFunction(f);			
		}
			
		String measureStatusName1 = getStatusName(root.getMeasureStatus());		 
		
		code = "����Ʒ"+root.getProductName()+"�Ķ����������:<br><table border=2 style='width:500px'> <tr><td style='width:150px'>����״̬</td><td>"+
		measureStatusName1+
		"</td></tr><tr><td>���ܵ����</td><td>"+root.getUfpCount()+
		"</td></tr><tr><td>����Ʒ���������ݹ���</td><td>�ڲ��߼��ļ���<br>";
		for(Object o:ilfList){
	    IfpugIlf ilfNode = (IfpugIlf)o;
	    String ilfName = ilfNode.getIlfName();
	    code += ilfName+"<br>";
		}
		code += "<br>�ⲿ�ӿ��ļ���<br>";
		for(Object o:eifList){
		    IfpugEif eifNode = (IfpugEif)o;
		    String eifName = eifNode.getEifName();
		    code += eifName+"<br>";
		}
		code += "</td></tr><tr><td>����Ʒ������������</td><td>�ⲿ���룺<br>";
		for(Object o:eiList){
		    IfpugEi eiNode = (IfpugEi)o;
		    String eiName = eiNode.getEiName();
		    code += eiName+"<br>";
		}
		code += "<br>�ⲿ�����<br>";
		for(Object o:eoList){
		    IfpugEo eoNode = (IfpugEo)o;
		    String eoName = eoNode.getEoName();
		    code += eoName+"<br>";
		}
		code += "<br>�ⲿ��ѯ��<br>";
		for(Object o:eqList){
		    IfpugEq eqNode = (IfpugEq)o;
		    String eqName = eqNode.getEqName();
		    code += eqName+"<br>";
		}
		
		code +="</td></tr></table>";										
		if(ilfList.length!=0){ //���ӽڵ�ǿգ����ӽڵ�ȫ�����
			for(Object obj:ilfList){
				queue.offer(obj);
			}
		}
		if(eifList.length!=0){ //���ӽڵ�ǿգ����ӽڵ�ȫ�����
			for(Object obj:eifList){
				queue.offer(obj);
			}
		}
		if(eiList.size()!=0){ //���ӽڵ�ǿգ����ӽڵ�ȫ�����
			for(Object obj:eiList){
				queue.offer(obj);
			}
		}
		if(eoList.size()!=0){ //���ӽڵ�ǿգ����ӽڵ�ȫ�����
			for(Object obj:eoList){
				queue.offer(obj);
			}
		}
		if(eqList.size()!=0){ //���ӽڵ�ǿգ����ӽڵ�ȫ�����
			for(Object obj:eqList){
				queue.offer(obj);
			}
		}
		
		while(!queue.isEmpty()){
			Object node = queue.remove(); //���ӣ�����
			if(node instanceof hibernate.IFPUG.IfpugIlf ){
				IfpugIlf ilf = (IfpugIlf)node;		
				code += "�ڲ��߼��ļ�"+ilf.getIlfName()+"�Ķ���������£�<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>����״̬</td><td>"+
				"�ѹ���"+
				"</td></tr><tr><td>���㷽��</td><td>"+dfb.getMethodName(ilf.getUfpMethod())
			    +"</td></tr><tr><td>���ܵ����</td><td>"+ilf.getUfpCount()+
				"</td></tr></table>";
			}
			
			if(node instanceof hibernate.IFPUG.IfpugEif ){
				IfpugEif eif = (IfpugEif)node;		
				code += "�ⲿ�ӿ��ļ�"+eif.getEifName()+"�Ķ���������£�<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>����״̬</td><td>"+
				"�ѹ���"+
				"</td></tr><tr><td>���㷽��</td><td>"+dfb.getMethodName(eif.getUfpMethod())
			    +"</td></tr><tr><td>���ܵ����</td><td>"+eif.getUfpCount()+
				"</td></tr></table>";
			}
			
			if(node instanceof hibernate.IFPUG.IfpugEi ){
				IfpugEi ei = (IfpugEi)node;		
				code += "�ⲿ����"+ei.getEiName()+"�Ķ���������£�<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>����״̬</td><td>"+
				getStatusName(ei.getMeasureStatus())+
				"</td></tr><tr><td>���㷽��</td><td>"+dfb.getMethodName(ei.getUfpMethod())
			    +"</td></tr><tr><td>���ܵ����</td><td>"+ei.getUfpCount()+
				"</td></tr></table>";
			}
			if(node instanceof hibernate.IFPUG.IfpugEo ){
				IfpugEo eo = (IfpugEo)node;		
				code += "�ⲿ���"+eo.getEoName()+"�Ķ���������£�<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>����״̬</td><td>"+
				getStatusName(eo.getMeasureStatus())+
				"</td></tr><tr><td>���㷽��</td><td>"+dfb.getMethodName(eo.getUfpMethod())
			    +"</td></tr><tr><td>���ܵ����</td><td>"+eo.getUfpCount()+
				"</td></tr></table>";
			}
			if(node instanceof hibernate.IFPUG.IfpugEq ){
				IfpugEq eq = (IfpugEq)node;	
				code += "�ⲿ��ѯ"+eq.getEqName()+"�Ķ���������£�<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>����״̬</td><td>"+
				getStatusName(eq.getMeasureStatus())+
				"</td></tr><tr><td>���㷽��</td><td>"+dfb.getMethodName(eq.getUfpMethod())
			    +"</td></tr><tr><td>���ܵ����</td><td>"+eq.getUfpCount()+
				"</td></tr></table>";
				
			}
			
			

		}
		
		
		
		}									
		catch (Exception e) {
			e.printStackTrace();
			return "Ŀ¼������ʧ��";
		}
	  return code;
	}
	
	public static void main(String[] str) throws HibernateException{
	 
		MeasureReport ba = new MeasureReport();
		String f = ba.exportMeasureReport(2);
		 System.out.println(f);
		
	}
}
	




