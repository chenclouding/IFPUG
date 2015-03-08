package business.IFPUG;

public class UfpCountBusiness {
	//ILF\EIF\EI\EO\EQ
	//对于ILF/EIF,纵坐标为det的个数，横坐标为ret的个数
	//对于EI\EO\EQ，纵坐标为det的个数，横坐标为ftr的个数
    int[][]  Function_Complex_Table = {{0,0,1},
    								   {0,1,2},
    								   {1,2,2}};//功能要素复杂表
    //纵坐标为复杂度，横坐标为功能点类型（ILF\EIF\EI\EO\EQ）
    int[][]  Function_ComplexValue_Table = {{7,10,15},
    										{5,7,10},
    										{3,4,6},
    										{4,5,7},
    										{3,4,6}};//功能要素复杂度加权因子表
    

    //计算数据功能点，已知det\ret个数，类型，计算复杂度
	public Integer  getComplex_valueMethod(int detCount, int retCount, int type){
		int i, j, complex;
		if(detCount >= 1&&detCount <= 19)	i = 0;
		else if(detCount >= 20&&detCount <= 50) i = 1;
		else i = 2;
		
		if(retCount == 1) j = 0;
		else if(retCount <= 5&&retCount >= 2) j = 1;
		else j =2;
		complex = Function_Complex_Table[j][i]; //得到复杂度
		return complex;
	}
	  //计算事务功能点，已知det\ftr个数，类型，计算复杂度
	public Integer  getComplex_valueMethod_TF(int detCount, int retCount, int type){
		int i, j, complex;
		if(detCount >= 1&&detCount <= 5)	i = 0;
		else if(detCount > 5&&detCount <= 19) i = 1;
		else i = 2;
		
		if(retCount == 0||retCount == 1) j = 0;
		else if(retCount == 2||retCount == 3) j = 1;
		else j =2;
		complex = Function_Complex_Table[j][i]; //得到复杂度
		return complex;
	}
	//已知det\ret范围，类型，计算复杂度
	public Integer getComplex_RangeMethod(int detRange, int retRange, int type){
		return Function_Complex_Table[retRange][detRange];
	}
	
	
	//根据复杂度和类型，返回功能点个数
	public Integer getUfpCount(int complex, int type){
		return Function_ComplexValue_Table[type][complex];
	}
	
	public static void main(String args[]){
		UfpCountBusiness ucb = new UfpCountBusiness();
		int complex = ucb.getComplex_valueMethod(13,1,0);
		System.out.println(complex);
		int ufp = ucb.getUfpCount(complex, 0);
		System.out.println(ufp);
		
	}
}
