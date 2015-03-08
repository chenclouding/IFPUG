package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugFunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugFunction implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugProduct ifpugProduct;
	private IfpugFunction ifpugFunction;
	private String functionName;
	private String functionDesp;
	private short functionType;
	private short measureStatus;
	private Integer ufpCount;
	private Set ifpugFunctions = new HashSet(0);
	private Set ifpugEos = new HashSet(0);
	private Set ifpugEqs = new HashSet(0);
	private Set ifpugEis = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugFunction() {
	}

	/** minimal constructor */
	public IfpugFunction(String functionName, short functionType,
			short measureStatus) {
		this.functionName = functionName;
		this.functionType = functionType;
		this.measureStatus = measureStatus;
	}

	/** full constructor */
	public IfpugFunction(IfpugProduct ifpugProduct,
			IfpugFunction ifpugFunction, String functionName,
			String functionDesp, short functionType, short measureStatus,
			Integer ufpCount, Set ifpugFunctions, Set ifpugEos, Set ifpugEqs,
			Set ifpugEis) {
		this.ifpugProduct = ifpugProduct;
		this.ifpugFunction = ifpugFunction;
		this.functionName = functionName;
		this.functionDesp = functionDesp;
		this.functionType = functionType;
		this.measureStatus = measureStatus;
		this.ufpCount = ufpCount;
		this.ifpugFunctions = ifpugFunctions;
		this.ifpugEos = ifpugEos;
		this.ifpugEqs = ifpugEqs;
		this.ifpugEis = ifpugEis;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugProduct getIfpugProduct() {
		return this.ifpugProduct;
	}

	public void setIfpugProduct(IfpugProduct ifpugProduct) {
		this.ifpugProduct = ifpugProduct;
	}

	public IfpugFunction getIfpugFunction() {
		return this.ifpugFunction;
	}

	public void setIfpugFunction(IfpugFunction ifpugFunction) {
		this.ifpugFunction = ifpugFunction;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionDesp() {
		return this.functionDesp;
	}

	public void setFunctionDesp(String functionDesp) {
		this.functionDesp = functionDesp;
	}

	public short getFunctionType() {
		return this.functionType;
	}

	public void setFunctionType(short functionType) {
		this.functionType = functionType;
	}

	public short getMeasureStatus() {
		return this.measureStatus;
	}

	public void setMeasureStatus(short measureStatus) {
		this.measureStatus = measureStatus;
	}

	public Integer getUfpCount() {
		return this.ufpCount;
	}

	public void setUfpCount(Integer ufpCount) {
		this.ufpCount = ufpCount;
	}

	public Set getIfpugFunctions() {
		return this.ifpugFunctions;
	}

	public void setIfpugFunctions(Set ifpugFunctions) {
		this.ifpugFunctions = ifpugFunctions;
	}

	public Set getIfpugEos() {
		return this.ifpugEos;
	}

	public void setIfpugEos(Set ifpugEos) {
		this.ifpugEos = ifpugEos;
	}

	public Set getIfpugEqs() {
		return this.ifpugEqs;
	}

	public void setIfpugEqs(Set ifpugEqs) {
		this.ifpugEqs = ifpugEqs;
	}

	public Set getIfpugEis() {
		return this.ifpugEis;
	}

	public void setIfpugEis(Set ifpugEis) {
		this.ifpugEis = ifpugEis;
	}
	
	//用于级联操作 Ifpug_Function表与Ifpug_Funcion表的关联	
	public void addFunction(IfpugFunction function){
		if(!ifpugFunctions.contains(function)){
			ifpugFunctions.add(function);
			function.setIfpugFunction(this);
			}
	}
	public void removeIfpugFunction(IfpugFunction function){
		function.removeIfpugFunction(null);
		ifpugFunctions.remove(function);
	}

}