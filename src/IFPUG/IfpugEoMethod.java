package hibernate.IFPUG;

/**
 * IfpugEoMethod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEoMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEo ifpugEo;
	private short methodType;
	private Integer defaultUfp;
	private Integer complex;
	private short retRange;
	private short detRange;
	private Integer retValue;
	private Integer detValue;
	private Integer ufpValue = 0;

	// Constructors

	/** default constructor */
	public IfpugEoMethod() {
	}

	/** minimal constructor */
	public IfpugEoMethod(IfpugEo ifpugEo, short methodType) {
		this.ifpugEo = ifpugEo;
		this.methodType = methodType;
	}

	/** full constructor */
	public IfpugEoMethod(IfpugEo ifpugEo, short methodType, Integer defaultUfp,
			Integer complex, short retRange, short detRange, Integer retValue,
			Integer detValue, Integer ufpValue) {
		this.ifpugEo = ifpugEo;
		this.methodType = methodType;
		this.defaultUfp = defaultUfp;
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

	public IfpugEo getIfpugEo() {
		return this.ifpugEo;
	}

	public void setIfpugEo(IfpugEo ifpugEo) {
		this.ifpugEo = ifpugEo;
	}

	public short getMethodType() {
		return this.methodType;
	}

	public void setMethodType(short methodType) {
		this.methodType = methodType;
	}

	public Integer getDefaultUfp() {
		return this.defaultUfp;
	}

	public void setDefaultUfp(Integer defaultUfp) {
		this.defaultUfp = defaultUfp;
	}

	public Integer getComplex() {
		return this.complex;
	}

	public void setComplex(Integer complex) {
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