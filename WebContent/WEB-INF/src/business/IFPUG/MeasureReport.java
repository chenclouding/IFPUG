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
	//递归获得所有基本流程
	public void getEpFromFunction(Object f)
	{
		IfpugFunction function = (IfpugFunction)f;
		if(function.getFunctionType() == 1)//原子模块
		{
			eiList.addAll(function.getIfpugEis());
			eoList.addAll(function.getIfpugEos());
			eqList.addAll(function.getIfpugEqs());
		}
		else //组合模块
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
	         case 0:measureStatusName = "未估算";break;
	         case 1:measureStatusName = "部分估算";break;
	         case 2:measureStatusName = "全部估算";break;
	         default:measureStatusName = "状态错误";
         } 
		 return measureStatusName;
	}
	
	public String exportMeasureReport(Integer productId){		
		String code = null ;		
	try{
		
		LinkedList<Object> queue = new LinkedList<Object>(); //定义空队列
		RequirementBusiness rb = new RequirementBusiness();
		DataFunctionBusiness dfb = new DataFunctionBusiness();
		TransactionFunctionBusiness tfb = new TransactionFunctionBusiness();
		
		IfpugProduct root = null;		
		root = (IfpugProduct) rb.getProductById(productId);
		//取出根产品
		//取出根产品的数据功能和事务功能
		Object[] ilfList = root.getIfpugIlfs().toArray();
		Object[] eifList = root.getIfpugEifs().toArray();
		Object[] functionList = root.getIfpugFunctions().toArray();
		
		for (Object f:functionList)
		{
			getEpFromFunction(f);			
		}
			
		String measureStatusName1 = getStatusName(root.getMeasureStatus());		 
		
		code = "本产品"+root.getProductName()+"的度量结果如下:<br><table border=2 style='width:500px'> <tr><td style='width:150px'>估算状态</td><td>"+
		measureStatusName1+
		"</td></tr><tr><td>功能点个数</td><td>"+root.getUfpCount()+
		"</td></tr><tr><td>本产品包含的数据功能</td><td>内部逻辑文件：<br>";
		for(Object o:ilfList){
	    IfpugIlf ilfNode = (IfpugIlf)o;
	    String ilfName = ilfNode.getIlfName();
	    code += ilfName+"<br>";
		}
		code += "<br>外部接口文件：<br>";
		for(Object o:eifList){
		    IfpugEif eifNode = (IfpugEif)o;
		    String eifName = eifNode.getEifName();
		    code += eifName+"<br>";
		}
		code += "</td></tr><tr><td>本产品包含的事务功能</td><td>外部输入：<br>";
		for(Object o:eiList){
		    IfpugEi eiNode = (IfpugEi)o;
		    String eiName = eiNode.getEiName();
		    code += eiName+"<br>";
		}
		code += "<br>外部输出：<br>";
		for(Object o:eoList){
		    IfpugEo eoNode = (IfpugEo)o;
		    String eoName = eoNode.getEoName();
		    code += eoName+"<br>";
		}
		code += "<br>外部查询：<br>";
		for(Object o:eqList){
		    IfpugEq eqNode = (IfpugEq)o;
		    String eqName = eqNode.getEqName();
		    code += eqName+"<br>";
		}
		
		code +="</td></tr></table>";										
		if(ilfList.length!=0){ //若子节点非空，将子节点全部入队
			for(Object obj:ilfList){
				queue.offer(obj);
			}
		}
		if(eifList.length!=0){ //若子节点非空，将子节点全部入队
			for(Object obj:eifList){
				queue.offer(obj);
			}
		}
		if(eiList.size()!=0){ //若子节点非空，将子节点全部入队
			for(Object obj:eiList){
				queue.offer(obj);
			}
		}
		if(eoList.size()!=0){ //若子节点非空，将子节点全部入队
			for(Object obj:eoList){
				queue.offer(obj);
			}
		}
		if(eqList.size()!=0){ //若子节点非空，将子节点全部入队
			for(Object obj:eqList){
				queue.offer(obj);
			}
		}
		
		while(!queue.isEmpty()){
			Object node = queue.remove(); //出队，访问
			if(node instanceof hibernate.IFPUG.IfpugIlf ){
				IfpugIlf ilf = (IfpugIlf)node;		
				code += "内部逻辑文件"+ilf.getIlfName()+"的度量结果如下：<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>估算状态</td><td>"+
				"已估算"+
				"</td></tr><tr><td>估算方法</td><td>"+dfb.getMethodName(ilf.getUfpMethod())
			    +"</td></tr><tr><td>功能点个数</td><td>"+ilf.getUfpCount()+
				"</td></tr></table>";
			}
			
			if(node instanceof hibernate.IFPUG.IfpugEif ){
				IfpugEif eif = (IfpugEif)node;		
				code += "外部接口文件"+eif.getEifName()+"的度量结果如下：<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>估算状态</td><td>"+
				"已估算"+
				"</td></tr><tr><td>估算方法</td><td>"+dfb.getMethodName(eif.getUfpMethod())
			    +"</td></tr><tr><td>功能点个数</td><td>"+eif.getUfpCount()+
				"</td></tr></table>";
			}
			
			if(node instanceof hibernate.IFPUG.IfpugEi ){
				IfpugEi ei = (IfpugEi)node;		
				code += "外部输入"+ei.getEiName()+"的度量结果如下：<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>估算状态</td><td>"+
				getStatusName(ei.getMeasureStatus())+
				"</td></tr><tr><td>估算方法</td><td>"+dfb.getMethodName(ei.getUfpMethod())
			    +"</td></tr><tr><td>功能点个数</td><td>"+ei.getUfpCount()+
				"</td></tr></table>";
			}
			if(node instanceof hibernate.IFPUG.IfpugEo ){
				IfpugEo eo = (IfpugEo)node;		
				code += "外部输出"+eo.getEoName()+"的度量结果如下：<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>估算状态</td><td>"+
				getStatusName(eo.getMeasureStatus())+
				"</td></tr><tr><td>估算方法</td><td>"+dfb.getMethodName(eo.getUfpMethod())
			    +"</td></tr><tr><td>功能点个数</td><td>"+eo.getUfpCount()+
				"</td></tr></table>";
			}
			if(node instanceof hibernate.IFPUG.IfpugEq ){
				IfpugEq eq = (IfpugEq)node;	
				code += "外部查询"+eq.getEqName()+"的度量结果如下：<br><table border=2 style='width:500px'><tr>	<td style='width:150px'>估算状态</td><td>"+
				getStatusName(eq.getMeasureStatus())+
				"</td></tr><tr><td>估算方法</td><td>"+dfb.getMethodName(eq.getUfpMethod())
			    +"</td></tr><tr><td>功能点个数</td><td>"+eq.getUfpCount()+
				"</td></tr></table>";
				
			}
			
			

		}
		
		
		
		}									
		catch (Exception e) {
			e.printStackTrace();
			return "目录树构造失败";
		}
	  return code;
	}
	
	public static void main(String[] str) throws HibernateException{
	 
		MeasureReport ba = new MeasureReport();
		String f = ba.exportMeasureReport(2);
		 System.out.println(f);
		
	}
}
	




