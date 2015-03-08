package hibernate.IFPUG;

/**
 * IfpugEoDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEoDet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlf ifpugIlf;
	private IfpugEif ifpugEif;
	private IfpugEifDet ifpugEifDet;
	private IfpugEo ifpugEo;
	private IfpugIlfDet ifpugIlfDet;
	private String eoDetName;
	private String eoDetDesp;
	private short fileType;

	// Constructors

	/** default constructor */
	public IfpugEoDet() {
	}

	/** minimal constructor */
	public IfpugEoDet(IfpugEo ifpugEo, String eoDetName, short fileType) {
		this.ifpugEo = ifpugEo;
		this.eoDetName = eoDetName;
		this.fileType = fileType;
	}

	/** full constructor */
	public IfpugEoDet(IfpugIlf ifpugIlf, IfpugEif ifpugEif,
			IfpugEifDet ifpugEifDet, IfpugEo ifpugEo, IfpugIlfDet ifpugIlfDet,
			String eoDetName, String eoDetDesp, short fileType) {
		this.ifpugIlf = ifpugIlf;
		this.ifpugEif = ifpugEif;
		this.ifpugEifDet = ifpugEifDet;
		this.ifpugEo = ifpugEo;
		this.ifpugIlfDet = ifpugIlfDet;
		this.eoDetName = eoDetName;
		this.eoDetDesp = eoDetDesp;
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

	public IfpugEifDet getIfpugEifDet() {
		return this.ifpugEifDet;
	}

	public void setIfpugEifDet(IfpugEifDet ifpugEifDet) {
		this.ifpugEifDet = ifpugEifDet;
	}

	public IfpugEo getIfpugEo() {
		return this.ifpugEo;
	}

	public void setIfpugEo(IfpugEo ifpugEo) {
		this.ifpugEo = ifpugEo;
	}

	public IfpugIlfDet getIfpugIlfDet() {
		return this.ifpugIlfDet;
	}

	public void setIfpugIlfDet(IfpugIlfDet ifpugIlfDet) {
		this.ifpugIlfDet = ifpugIlfDet;
	}

	public String getEoDetName() {
		return this.eoDetName;
	}

	public void setEoDetName(String eoDetName) {
		this.eoDetName = eoDetName;
	}

	public String getEoDetDesp() {
		return this.eoDetDesp;
	}

	public void setEoDetDesp(String eoDetDesp) {
		this.eoDetDesp = eoDetDesp;
	}

	public short getFileType() {
		return this.fileType;
	}

	public void setFileType(short fileType) {
		this.fileType = fileType;
	}

}