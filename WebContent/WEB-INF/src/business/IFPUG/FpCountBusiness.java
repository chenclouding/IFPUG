package business.IFPUG;

import java.util.List;

import net.sf.hibernate.HibernateException;

import hibernate.IFPUG.IfpugEi;
import hibernate.IFPUG.IfpugEif;
import hibernate.IFPUG.IfpugEo;
import hibernate.IFPUG.IfpugEq;
import hibernate.IFPUG.IfpugIlf;
import hibernate.IFPUG.IfpugProduct;

public class FpCountBusiness {
	public Integer dfpCount(Integer productId) throws HibernateException
	{
		RequirementBusiness rb = new RequirementBusiness();
		IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
		Object[] ilfList = product.getIfpugIlfs().toArray();
		Object[] eifList = product.getIfpugEifs().toArray();

		Integer dfp = 0;
		if(ilfList != null && ilfList.length != 0)
		{
			for(Object i:ilfList)
			{
				IfpugIlf ilf = (IfpugIlf)i;
				dfp += ilf.getUfpCount();
			}
		}
		if(eifList != null && eifList.length != 0)
		{
			for(Object e:eifList)
			{
				IfpugEif eif = (IfpugEif)e;
				dfp += eif.getUfpCount();
			}
		}
		return dfp;
	}

	public Integer tfpCount(Integer productId) throws HibernateException
	{
		RequirementBusiness rb = new RequirementBusiness(); 
		IfpugProduct product = (IfpugProduct)rb.getProductById(productId);
		Object[] functionList = product.getIfpugFunctions().toArray();
		Integer tfp = 0;

		MeasureReport mr = new MeasureReport();
		if(functionList != null&&functionList.length != 0)
		{
			for (Object f:functionList)
			{
				mr.getEpFromFunction(f);
			}
		}
		List eiList = mr.eiList;
		List eoList = mr.eoList;
		List eqList = mr.eqList;

		if(eiList!=null&&eiList.size()!=0)
		{
			for(Object o:eiList)
			{
				IfpugEi ei = (IfpugEi)o;
				tfp += ei.getUfpCount();
			}
		} 
		if(eoList!=null&&eoList.size()!=0)
		{
			for(Object o:eoList)
			{
				IfpugEo eo = (IfpugEo)o;
				tfp += eo.getUfpCount();
			}
		} 
		if(eqList!=null&&eqList.size()!=0)
		{
			for(Object o:eqList)
			{
				IfpugEq eq = (IfpugEq)o;
				tfp += eq.getUfpCount();
			}
		} 
		return tfp;

	}
}
