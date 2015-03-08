package hibernate.IFPUG;

/**
 * IfpugEiDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEiDet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlf ifpugIlf;
	private IfpugEif ifpugEif;
	private IfpugEi ifpugEi;
	private IfpugEifDet ifpugEifDet;
	private IfpugIlfDet ifpugIlfDet;
	private String eiDetName;
	private String eiDetDesp;
	private short fileType;

	// Constructors

	/** default constructor */
	public IfpugEiDet() {
	}

	/** minimal constructor */
	public IfpugEiDet(IfpugEi ifpugEi, String eiDetName, short fileType) {
		this.ifpugEi = ifpugEi;
		this.eiDetName = eiDetName;
		this.fileType = fileType;
	}

	/** full constructor */
	public IfpugEiDet(IfpugIlf ifpugIlf, IfpugEif ifpugEif, IfpugEi ifpugEi,
			IfpugEifDet ifpugEifDet, IfpugIlfDet ifpugIlfDet, String eiDetName,
			String eiDetDesp, short fileType) {
		this.ifpugIlf = ifpugIlf;
		this.ifpugEif = ifpugEif;
		this.ifpugEi = ifpugEi;
		this.ifpugEifDet = ifpugEifDet;
		this.ifpugIlfDet = ifpugIlfDet;
		this.eiDetName = eiDetName;
		this.eiDetDesp = eiDetDesp;
		this.fileType = fileType;
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

	public IfpugEif getIfpugEif() {
		return this.ifpugEif;
	}

	public void setIfpugEif(IfpugEif ifpugEif) {
		this.ifpugEif = ifpugEif;
	}

	public IfpugEi getIfpugEi() {
		return this.ifpugEi;
	}

	public void setIfpugEi(IfpugEi ifpugEi) {
		this.ifpugEi = ifpugEi;
	}

	public IfpugEifDet getIfpugEifDet() {
		return this.ifpugEifDet;
	}

	public void setIfpugEifDet(IfpugEifDet ifpugEifDet) {
		this.ifpugEifDet = ifpugEifDet;
	}

	public IfpugIlfDet getIfpugIlfDet() {
		return this.ifpugIlfDet;
	}

	public void setIfpugIlfDet(IfpugIlfDet ifpugIlfDet) {
		this.ifpugIlfDet = ifpugIlfDet;
	}

	public String getEiDetName() {
		return this.eiDetName;
	}

	public void setEiDetName(String eiDetName) {
		this.eiDetName = eiDetName;
	}

	public String getEiDetDesp() {
		return this.eiDetDesp;
	}

	public void setEiDetDesp(String eiDetDesp) {
		this.eiDetDesp = eiDetDesp;
	}

	public short getFileType() {
		return this.fileType;
	}

	public void setFileType(short fileType) {
		this.fileType = fileType;
	}

}