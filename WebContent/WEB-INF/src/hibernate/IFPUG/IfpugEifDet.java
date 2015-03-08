package hibernate.IFPUG;

/**
 * IfpugEifDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEifDet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEifRet ifpugEifRet;
	private short type;
	private Integer eifId;
	private String eifDetName;
	private String eifDetDesp;

	// Constructors

	/** default constructor */
	public IfpugEifDet() {
	}

	/** minimal constructor */
	public IfpugEifDet(IfpugEifRet ifpugEifRet, short type, Integer eifId,
			String eifDetName) {
		this.ifpugEifRet = ifpugEifRet;
		this.type = type;
		this.eifId = eifId;
		this.eifDetName = eifDetName;
	}

	/** full constructor */
	public IfpugEifDet(IfpugEifRet ifpugEifRet, short type, Integer eifId,
			String eifDetName, String eifDetDesp) {
		this.ifpugEifRet = ifpugEifRet;
		this.type = type;
		this.eifId = eifId;
		this.eifDetName = eifDetName;
		this.eifDetDesp = eifDetDesp;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugEifRet getIfpugEifRet() {
		return this.ifpugEifRet;
	}

	public void setIfpugEifRet(IfpugEifRet ifpugEifRet) {
		this.ifpugEifRet = ifpugEifRet;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public Integer getEifId() {
		return this.eifId;
	}

	public void setEifId(Integer eifId) {
		this.eifId = eifId;
	}

	public String getEifDetName() {
		return this.eifDetName;
	}

	public void setEifDetName(String eifDetName) {
		this.eifDetName = eifDetName;
	}

	public String getEifDetDesp() {
		return this.eifDetDesp;
	}

	public void setEifDetDesp(String eifDetDesp) {
		this.eifDetDesp = eifDetDesp;
	}

}