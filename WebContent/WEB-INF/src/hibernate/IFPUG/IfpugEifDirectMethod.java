package hibernate.IFPUG;

/**
 * IfpugEifDirectMethod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEifDirectMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEif ifpugEif;
	private short methodType;
	private Integer defaultMethod;
	private short complex;
	private short retRange;
	private short detRange;
	private Integer retValue;
	private Integer detValue;
	private Integer ufpValue = 0;

	// Constructors

	/** default constructor */
	public IfpugEifDirectMethod() {
	}

	/** minimal constructor */
	public IfpugEifDirectMethod(IfpugEif ifpugEif, short methodType) {
		this.ifpugEif = ifpugEif;
		this.methodType = methodType;
	}

	/** full constructor */
	public IfpugEifDirectMethod(IfpugEif ifpugEif, short methodType,
			Integer defaultMethod, short complex, short retRange, short detRange,
			Integer retValue, Integer detValue, Integer ufpValue) {
		this.ifpugEif = ifpugEif;
		this.methodType = methodType;
		this.defaultMethod = defaultMethod;
		this.complex = complex;
		this.retRange = retRange;
		this.detRange = detRange;
		this.retValue = retValue;
		this.detValue = detValue;
		this.ufpValue = ufpValue;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugEif getIfpugEif() {
		return this.ifpugEif;
	}

	public void setIfpugEif(IfpugEif ifpugEif) {
		this.ifpugEif = ifpugEif;
	}

	public short getMethodType() {
		return this.methodType;
	}

	public void setMethodType(short methodType) {
		this.methodType = methodType;
	}

	public Integer getDefaultMethod() {
		return this.defaultMethod;
	}

	public void setDefaultMethod(Integer defaultMethod) {
		this.defaultMethod = defaultMethod;
	}

	public short getComplex() {
		return this.complex;
	}

	public void setComplex(short complex) {
		this.complex = complex;
	}

	public short getRetRange() {
		return this.retRange;
	}

	public void setRetRange(short retRange) {
		this.retRange = retRange;
	}

	public short getDetRange() {
		return this.detRange;
	}

	public void setDetRange(short detRange) {
		this.detRange = detRange;
	}

	public Integer getRetValue() {
		return this.retValue;
	}

	public void setRetValue(Integer retValue) {
		this.retValue = retValue;
	}

	public Integer getDetValue() {
		return this.detValue;
	}

	public void setDetValue(Integer detValue) {
		this.detValue = detValue;
	}

	public Integer getUfpValue() {
		return this.ufpValue;
	}

	public void setUfpValue(Integer ufpValue) {
		this.ufpValue = ufpValue;
	}

}