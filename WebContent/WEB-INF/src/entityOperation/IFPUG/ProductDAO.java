package entityOperation.IFPUG;



import hibernate.IFPUG.IfpugFunction;
import hibernate.IFPUG.IfpugProduct;

import java.util.List;
import net.sf.hibernate.HibernateException;



public class ProductDAO extends BaseDAO {

	/**
	 *  插入产品
	 */		
	public boolean insertProduct(Object dataObject) throws HibernateException{
		return insert(dataObject);
	}
	/**
	 *  按实体对象删除产品
	 */	
	public boolean delProduct(Object dataObject) throws HibernateException{
		return del(dataObject);
	}
	/**
	 *  按ID号删除产品
	 */	
	public boolean delProductById(Integer id) throws HibernateException{
		Object obj = queryById("IfpugProduct",id);
		return del(obj);
	}
	/**
	 *  更新产品
	 */	
	public boolean updateProduct(Object dataObject) throws HibernateException {
		return update(dataObject);
	}

	/**
	 *  查询所有的产品
	 */
	public List queryAllProduct() throws HibernateException {	
        return queryAll("IfpugProduct");
	}

	/**
	 *  按id（主键）将产品取出来
	 */
	public Object queryProductById(Integer id) {    	
        return queryById("IfpugProduct",id);
    }
	
	/**
	 *  按照用户名查询产品
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
