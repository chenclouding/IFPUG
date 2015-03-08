package hibernate.IFPUG;

/**
 * IfpugEqDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEqDet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlfDet ifpugIlfDet;
	private IfpugIlf ifpugIlf;
	private IfpugEq ifpugEq;
	private IfpugEif ifpugEif;
	private IfpugEifDet ifpugEifDet;
	private String eqDetName;
	private String eqDetDesp;
	private short fileType;
	private Integer ilfDetId;

	// Constructors

	/** default constructor */
	public IfpugEqDet() {
	}

	/** minimal constructor */
	public IfpugEqDet(IfpugEq ifpugEq, String eqDetName, short fileType) {
		this.ifpugEq = ifpugEq;
		this.eqDetName = eqDetName;
		this.fileType = fileType;
	}

	/** full constructor */
	public IfpugEqDet(IfpugIlfDet ifpugIlfDet, IfpugIlf ifpugIlf,
			IfpugEq ifpugEq, IfpugEif ifpugEif, IfpugEifDet ifpugEifDet,
			String eqDetName, String eqDetDesp, short fileType, Integer ilfDetId) {
		this.ifpugIlfDet = ifpugIlfDet;
		this.ifpugIlf = ifpugIlf;
		this.ifpugEq = ifpugEq;
		this.ifpugEif = ifpugEif;
		this.ifpugEifDet = ifpugEifDet;
		this.eqDetName = eqDetName;
		this.eqDetDesp = eqDetDesp;
		this.fileType = fileType;
		this.ilfDetId = ilfDetId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugIlfDet getIfpugIlfDet() {
		return this.ifpugIlfDet;
	}

	public void setIfpugIlfDet(IfpugIlfDet ifpugIlfDet) {
		this.ifpugIlfDet = ifpugIlfDet;
	}

	public IfpugIlf getIfpugIlf() {
		return this.ifpugIlf;
	}

	public void setIfpugIlf(IfpugIlf ifpugIlf) {
		this.ifpugIlf = ifpugIlf;
	}

	public IfpugEq getIfpugEq() {
		return this.ifpugEq;
	}

	public void setIfpugEq(IfpugEq ifpugEq) {
		this.ifpugEq = ifpugEq;
	}

	public IfpugEif getIfpugEif() {
		return this.ifpugEif;
	}

	public void setIfpugEif(IfpugEif ifpugEif) {
		this.ifpugEif = ifpugEif;
	}

	public IfpugEifDet getIfpugEifDet() {
		return this.ifpugEifDet;
	}

	public void setIfpugEifDet(IfpugEifDet ifpugEifDet) {
		this.ifpugEifDet = ifpugEifDet;
	}

	public String getEqDetName() {
		return this.eqDetName;
	}

	public void setEqDetName(String eqDetName) {
		this.eqDetName = eqDetName;
	}

	public String getEqDetDesp() {
		return this.eqDetDesp;
	}

	public void setEqDetDesp(String eqDetDesp) {
		this.eqDetDesp = eqDetDesp;
	}

	public short getFileType() {
		return this.fileType;
	}

	public void setFileType(short fileType) {
		this.fileType = fileType;
	}

	public Integer getIlfDetId() {
		return this.ilfDetId;
	}

	public void setIlfDetId(Integer ilfDetId) {
		this.ilfDetId = ilfDetId;
	}

}