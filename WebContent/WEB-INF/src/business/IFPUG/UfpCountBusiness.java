package business.IFPUG;

public class UfpCountBusiness {
	//ILF\EIF\EI\EO\EQ
	//����ILF/EIF,������Ϊdet�ĸ�����������Ϊret�ĸ���
	//����EI\EO\EQ��������Ϊdet�ĸ�����������Ϊftr�ĸ���
    int[][]  Function_Complex_Table = {{0,0,1},
    								   {0,1,2},
    								   {1,2,2}};//����Ҫ�ظ��ӱ�
    //������Ϊ���Ӷȣ�������Ϊ���ܵ����ͣ�ILF\EIF\EI\EO\EQ��
    int[][]  Function_ComplexValue_Table = {{7,10,15},
    										{5,7,10},
    										{3,4,6},
    										{4,5,7},
    										{3,4,6}};//����Ҫ�ظ��Ӷȼ�Ȩ���ӱ�
    

    //�������ݹ��ܵ㣬��֪det\ret���������ͣ����㸴�Ӷ�
	public Integer  getComplex_valueMethod(int detCount, int retCount, int type){
		int i, j, complex;
		if(detCount >= 1&&detCount <= 19)	i = 0;
		else if(detCount >= 20&&detCount <= 50) i = 1;
		else i = 2;
		
		if(retCount == 1) j = 0;
		else if(retCount <= 5&&retCount >= 2) j = 1;
		else j =2;
		complex = Function_Complex_Table[j][i]; //�õ����Ӷ�
		return complex;
	}
	  //���������ܵ㣬��֪det\ftr���������ͣ����㸴�Ӷ�
	public Integer  getComplex_valueMethod_TF(int detCount, int retCount, int type){
		int i, j, complex;
		if(detCount >= 1&&detCount <= 5)	i = 0;
		else if(detCount > 5&&detCount <= 19) i = 1;
		else i = 2;
		
		if(retCount == 0||retCount == 1) j = 0;
		else if(retCount == 2||retCount == 3) j = 1;
		else j =2;
		complex = Function_Complex_Table[j][i]; //�õ����Ӷ�
		return complex;
	}
	//��֪det\ret��Χ�����ͣ����㸴�Ӷ�
	public Integer getComplex_RangeMethod(int detRange, int retRange, int type){
		return Function_Complex_Table[retRange][detRange];
	}
	
	
	//���ݸ��ӶȺ����ͣ����ع��ܵ����
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
