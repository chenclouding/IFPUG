package hibernate.IFPUG;

/**
 * IfpugIlfDirectMethod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugIlfDirectMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlf ifpugIlf;
	private short methodType;
	private Integer defaultMethod;
	private short complex;
	private short detRange;
	private short retRange;
	private Integer detValue;
	private Integer retValue;
	private Integer ufpValue = 0;

	// Constructors

	/** default constructor */
	public IfpugIlfDirectMethod() {
	}

	/** minimal constructor */
	public IfpugIlfDirectMethod(IfpugIlf ifpugIlf, short methodType) {
		this.ifpugIlf = ifpugIlf;
		this.methodType = methodType;
	}

	/** full constructor */
	public IfpugIlfDirectMethod(IfpugIlf ifpugIlf, short methodType,
			Integer defaultMethod, short complex, short detRange,
			short retRange, Integer detValue, Integer retValue, Integer ufpValue) {
		this.ifpugIlf = ifpugIlf;
		this.methodType = methodType;
		this.defaultMethod = defaultMethod;
		this.complex = complex;
		this.detRange = detRange;
		this.retRange = retRange;
		this.detValue = detValue;
		this.retValue = retValue;
		this.ufpValue = ufpValue;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugIlf getIfpugIlf() {
		return this.ifpugIlf;
	}

	public void setIfpugIlf(IfpugIlf ifpugIlf) {
		this.ifpugIlf = ifpugIlf;
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

	public short getDetRange() {
		return this.detRange;
	}

	public void setDetRange(short detRange) {
		this.detRange = detRange;
	}

	public short getRetRange() {
		return this.retRange;
	}

	public void setRetRange(short retRange) {
		this.retRange = retRange;
	}

	public Integer getDetValue() {
		return this.detValue;
	}

	public void setDetValue(Integer detValue) {
		this.detValue = detValue;
	}

	public Integer getRetValue() {
		return this.retValue;
	}

	public void setRetValue(Integer retValue) {
		this.retValue = retValue;
	}

	public Integer getUfpValue() {
		return this.ufpValue;
	}

	public void setUfpValue(Integer ufpValue) {
		this.ufpValue = ufpValue;
	}

}