package util;

public class NumberUtil {
	
	DebugUtil debugUtil;
	
	public NumberUtil(boolean isDebug) {
		debugUtil = new DebugUtil(isDebug);
	}

	/**
	 * ��intת��Ϊ��λ����string����"001"
	 * @param intId
	 * @return
	 */
	public static String convertIntToTripleString(int intId){
		String id = null;
		if ((intId > 0) && (intId < 10)) {
			id = "00" + String.valueOf(intId);
		} else if ((intId >= 10) && (intId < 100)) {
			id = "0" + String.valueOf(intId);
		} else if (intId > 1000) {
			System.out.println("Error, number should less than 1000.");
		}
		
		return id;
	}
	
	/**
	 * ��Stringת��Ϊint
	 * @param strId
	 * @return
	 */
	public static int convertStringToInt(String strId){
		int id = 0;
		
		id =Integer.parseInt(strId);
		
		return id;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
