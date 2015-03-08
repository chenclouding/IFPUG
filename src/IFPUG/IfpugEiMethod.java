package hibernate.IFPUG;

/**
 * IfpugEiMethod entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEiMethod implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEi ifpugEi;
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
	public IfpugEiMethod() {
	}

	/** minimal constructor */
	public IfpugEiMethod(IfpugEi ifpugEi, short methodType) {
		this.ifpugEi = ifpugEi;
		this.methodType = methodType;
	}

	/** full constructor */
	public IfpugEiMethod(IfpugEi ifpugEi, short methodType, Integer defaultUfp,
			short complex, short ftrRange, short detRange, Integer ftrValue,
			Integer detValue, Integer ufpValue) {
		this.ifpugEi = ifpugEi;
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

	public IfpugEi getIfpugEi() {
		return this.ifpugEi;
	}

	public void setIfpugEi(IfpugEi ifpugEi) {
		this.ifpugEi = ifpugEi;
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