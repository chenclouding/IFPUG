package hibernate.IFPUG;

/**
 * IfpugEqMethod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEqMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEq ifpugEq;
	private short methodType;
	private Integer defaultUfp;
	private short complex;
	private short ftrRange;
	private short detRange;
	private Integer ftrValue;
	private Integer detValue;
	private Integer ufpValue = 0;

	// Constructors

	/** default constructor */
	public IfpugEqMethod() {
	}

	/** minimal constructor */
	public IfpugEqMethod(IfpugEq ifpugEq, short methodType) {
		this.ifpugEq = ifpugEq;
		this.methodType = methodType;
	}

	/** full constructor */
	public IfpugEqMethod(IfpugEq ifpugEq, short methodType, Integer defaultUfp,
			short complex, short ftrRange, short detRange, Integer ftrValue,
			Integer detValue, Integer ufpValue) {
		this.ifpugEq = ifpugEq;
		this.methodType = methodType;
		this.defaultUfp = defaultUfp;
		this.complex = complex;
		this.ftrRange = ftrRange;
		this.detRange = detRange;
		this.ftrValue = ftrValue;
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

	public IfpugEq getIfpugEq() {
		return this.ifpugEq;
	}

	public void setIfpugEq(IfpugEq ifpugEq) {
		this.ifpugEq = ifpugEq;
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

	public short getComplex() {
		return this.complex;
	}

	public void setComplex(short complex) {
		this.complex = complex;
	}

	public short getFtrRange() {
		return this.ftrRange;
	}

	public void setFtrRange(short ftrRange) {
		this.ftrRange = ftrRange;
	}

	public short getDetRange() {
		return this.detRange;
	}

	public void setDetRange(short detRange) {
		this.detRange = detRange;
	}

	public Integer getFtrValue() {
		return this.ftrValue;
	}

	public void setFtrValue(Integer ftrValue) {
		this.ftrValue = ftrValue;
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