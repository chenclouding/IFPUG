package util;

public class DebugUtil {
	private boolean debug = false;
	
	public DebugUtil(boolean isDebug){
		this.debug = isDebug;
	}
	
	public DebugUtil(){
	}
	
	/**
	 * 
	 *
	 */
	private static void outputHeader() {
		System.out.print("-------Debug info-------");		
	}
	
	/**
	 * 
	 * @param s
	 */
	public void output(String s){
		if(this.debug){
			outputHeader();			
			System.out.println(s);
		} else {
			// write to file?
		}
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void output(String name, String value ){
		output(name + " is: " + value);
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public void output(String name, int value){
		output(name, String.valueOf(value));
	}
	
	/**
	 * 
	 * @param s
	 * @param isDebug
	 */
	public static void output2(String s, boolean isDebug){
		outputHeader();
		System.out.println(s);
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 * @param isDebug
	 */
	public static void output2(String name, int value, boolean isDebug){
		output2(name + " is: " + String.valueOf(value), isDebug);
	}
}
