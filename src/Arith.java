/*
 * Created on 2005-4-27
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package util;

/**
 * @author Alligator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.math.BigDecimal;



/**

* ����Java�ļ����Ͳ��ܹ���ȷ�ĶԸ������������㣬����������ṩ��

* ȷ�ĸ��������㣬�����Ӽ��˳����������롣

*/
public class Arith{

   //Ĭ�ϳ������㾫��
   private static final int DEF_DIV_SCALE = 10;
   public Arith(){}
   /**

    * �ṩ��ȷ�ļӷ����㡣

    * @param v1 ������

    * @param v2 ����

    * @return ���������ĺ�

    */

   public double add(double v1,double v2){

       BigDecimal b1 = new BigDecimal(Double.toString(v1));

       BigDecimal b2 = new BigDecimal(Double.toString(v2));

       return b1.add(b2).doubleValue();

   }



   /**

    * �ṩ��ȷ�ļ������㡣

    * @param v1 ������

    * @param v2 ����

    * @return ���������Ĳ�

    */

   public  double sub(double v1,double v2){

       BigDecimal b1 = new BigDecimal(Double.toString(v1));

       BigDecimal b2 = new BigDecimal(Double.toString(v2));

       return b1.subtract(b2).doubleValue();

   }



   /**

    * �ṩ��ȷ�ĳ˷����㡣

    * @param v1 ������

    * @param v2 ����

    * @return ���������Ļ�

    */

   public double mul(double v1,double v2){

       BigDecimal b1 = new BigDecimal(Double.toString(v1));

       BigDecimal b2 = new BigDecimal(Double.toString(v2));

       return b1.multiply(b2).doubleValue();

   }



   /**

    * �ṩ����ԣ���ȷ�ĳ������㣬�����������������ʱ����ȷ��

    * С�����Ժ�10λ���Ժ�������������롣

    * @param v1 ������

    * @param v2 ����

    * @return ������������

    */

   public double div(double v1,double v2){

       return div(v1,v2,DEF_DIV_SCALE);

   }



   /**

    * �ṩ����ԣ���ȷ�ĳ������㡣�����������������ʱ����scale����ָ

    * �����ȣ��Ժ�������������롣

    * @param v1 ������

    * @param v2 ����

    * @param scale ��ʾ��ʾ��Ҫ��ȷ��С�����Ժ�λ��

    * @return ������������

    */

   public double div(double v1,double v2,int scale){

       if(scale<0){

           throw new IllegalArgumentException(

               "The scale must be a positive integer or zero");

       }

       BigDecimal b1 = new BigDecimal(Double.toString(v1));

       BigDecimal b2 = new BigDecimal(Double.toString(v2));

       return b1.divide(b2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();

   }



   /**

    * �ṩ��ȷ��С��λ�������봦��

    * @param v ��Ҫ�������������

    * @param scale С���������λ

    * @return ���������Ľ��

    */

   public double round(double v,int scale){

       if(scale<0){

           throw new IllegalArgumentException(

               "The scale must be a positive integer or zero");

       }

       BigDecimal b = new BigDecimal(Double.toString(v));

       BigDecimal one = new BigDecimal("1");

       return b.divide(one,scale,BigDecimal.ROUND_HALF_UP).doubleValue();

   }

};

