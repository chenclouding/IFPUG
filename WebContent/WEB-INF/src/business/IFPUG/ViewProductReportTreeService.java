package business.IFPUG;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugProduct;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import net.sf.hibernate.HibernateException;



public class ViewProductReportTreeService {
	public LinkedList<Object> nodes = new LinkedList<Object>();
	public IfpugProduct product;
	public String code = null ;
	public int eiCheck = 0, eoCheck = 0, eqCheck = 0;
	public int k = 0;
	//本类的主要作用是建立产品的树结构
	
	public ViewProductReportTreeService(){}
	
	public String buildReportTree(Integer productId){
	try{
		
		 
		RequirementBusiness rb = new RequirementBusiness();
		product = (IfpugProduct)rb.getProductById(productId);
		Object[] functionList = product.getIfpugFunctions().toArray();		
		//把根节点加入tree	
			Integer arg1 = 0;
			Integer arg2 = -1;
			String arg3 = product.getProductName();
			String arg4 = "功能点个数："
				+ product.getUfpCount()+"FP" + ";估算状态："
				+ rb.changeMeausreStatus(product.getMeasureStatus());
			
			code = "d.add("+arg1+","+arg2+",'"+arg3+"','"+arg4+"');";
			
		int i = 0;
		for (Object f : functionList) {
				i = k + 1;
				IfpugFunction function = (IfpugFunction) f;
				Integer arg11 = i;
				Integer arg21 = 0;
				String arg31 = function.getFunctionName();
				
				String arg51 = "功能点个数："
						+ function.getUfpCount()+"FP" + ";估算状态："
						+ rb.changeMeausreStatus(function.getMeasureStatus());
				code += "d.add(" + arg11 + "," + arg21 + ",'" + arg31 + "','" + arg51 + "');";
				System.out.println(i + ":" + function.getFunctionName());
				addTreeNode(function, i);
		}
		System.out.println("code:"+code);
	  }catch (Exception e) {
			e.printStackTrace();
			return "Failure of Directory tree structure";
		}
	  return code;
	}
	
	 //下面这段代码用于得到该软件产品所有的节点个数
	public void addTreeNode(IfpugFunction function, int i)
	{	int j;
		Short functionType = function.getFunctionType();
		RequirementBusiness rb = new RequirementBusiness();
		
		
		
		if(functionType == 0)//如果该功能模块是组合模块
		{   Object[] childFunctionList = function.getIfpugFunctions().toArray();
			j = i;
			for (Object f:childFunctionList)
			{	j = 1 + ((j > k)?j:k); 
			    k = j;
				IfpugFunction childFunction = (IfpugFunction)f;
				
				code += "d.add("+j+","+i+",'"+childFunction.getFunctionName()+"');"; 
				//System.out.println(function.getFunctionName()+":"+childFunction.getFunctionName());
				addTreeNode(childFunction,j);
			}			
		}
		else {//如果是原子模块
			j = i;
			j ++;
			Object[] eiList = function.getIfpugEis().toArray();
			Object[] eoList = function.getIfpugEos().toArray();
			Object[] eqList = function.getIfpugEqs().toArray();
			k = j + 2;
			if(eiList != null && eiList.length != 0){				
				
			    code += "d.add("+j+","+i+",'EI');";						
			    
				for (Object e:eiList)
				{
					k ++;
					IfpugEi ei = (IfpugEi)e; 
					
					code += "d.add("+k+","+j+",'"+ei.getEiName()+"');"; 
					System.out.println(function.getFunctionName()+":"+k+":"+ei.getEiName());
				}
			}
			if(eoList != null && eoList.length != 0)
			{
				//nodes.add((j+1)+"|"+i+"|EO|#");
				int m = j + 1;
				code += "d.add("+m+","+i+",'EO');";
				for (Object e:eoList)
				{
					k ++;
					IfpugEo eo = (IfpugEo)e;
					code += "d.add("+k+","+m+",'"+eo.getEoName()+"');"; 
				}
			}
			if(eqList != null && eqList.length != 0)
			{
				int n = j + 2;
				code += "d.add("+n+","+i+",'EQ');";
					
				for (Object e:eqList)
				{
					k ++;
					IfpugEq eq = (IfpugEq)e;
					code += "d.add("+k+","+n+",'"+eq.getEqName()+"');"; 
					
				}
			}
		}
	}
	
	public static void main(String[] str) throws HibernateException{
	 
		ViewProductReportTreeService ba = new ViewProductReportTreeService();
		String f = ba.buildReportTree(2);
		 System.out.println(f);
		
	}
}
	




