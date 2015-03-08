package entityOperation.IFPUG;



import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugProduct;

import java.util.List;
import net.sf.hibernate.HibernateException;



public class ProductDAO extends BaseDAO {

	/**
	 *  �����Ʒ
	 */		
	public boolean insertProduct(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  ��ʵ�����ɾ����Ʒ
	 */	
	public boolean delProduct(Object dataObject) throws HibernateException{
		return del(dataObject);
	}
	/**
	 *  ��ID��ɾ����Ʒ
	 */	
	public boolean delProductById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugProduct",id);
		return del(obj);
	}
	/**
	 *  ���²�Ʒ
	 */	
	public boolean updateProduct(Object dataObject) throws HibernateException {
		return update(dataObject);
	}

	/**
	 *  ��ѯ���еĲ�Ʒ
	 */
	public List queryAllProduct() throws HibernateException {	
        return queryAll("IfpugProduct");
	}

	/**
	 *  ��id������������Ʒȡ����
	 */
	public Object queryProductById(Integer id) {    	
        return queryById("IfpugProduct",id);
    }
	
	/**
	 *  �����û�����ѯ��Ʒ
	 */
	public List queryAllProductByUser(Integer userId) throws HibernateException {	
          return queryByFkey("IfpugProduct","userId",userId);
	}
	
	public static void main(String[] args){
		ProductDAO pd = new ProductDAO();
		IfpugProduct product = (IfpugProduct)pd.queryProductById(1);
		FunctionDAO fd = new FunctionDAO();
		IfpugFunction f = (IfpugFunction) fd.queryFunctionById(1);
		product = f.getIfpugProduct();
		System.out.println("-----------------------------"+product.getProductName());
		
	    //System.out.println(product.getMeasureStatus());
	}
}
