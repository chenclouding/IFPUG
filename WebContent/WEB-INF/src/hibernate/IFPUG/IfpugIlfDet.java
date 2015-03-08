package hibernate.IFPUG;

/**
 * IfpugIlfDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugIlfDet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlfRet ifpugIlfRet;
	private Integer ilfId;
	private short type;
	private String ilfDetName;
	private String ilfDetDesp;

	// Constructors

	/** default constructor */
	public IfpugIlfDet() {
	}

	/** minimal constructor */
	public IfpugIlfDet(IfpugIlfRet ifpugIlfRet, Integer ilfId, String ilfDetName) {
		this.ifpugIlfRet = ifpugIlfRet;
		this.ilfId = ilfId;
		this.ilfDetName = ilfDetName;
	}

	/** full constructor */
	public IfpugIlfDet(IfpugIlfRet ifpugIlfRet, Integer ilfId, short type,
			String ilfDetName, String ilfDetDesp) {
		this.ifpugIlfRet = ifpugIlfRet;
		this.ilfId = ilfId;
		this.type = type;
		this.ilfDetName = ilfDetName;
		this.ilfDetDesp = ilfDetDesp;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugIlfRet getIfpugIlfRet() {
		return this.ifpugIlfRet;
	}

	public void setIfpugIlfRet(IfpugIlfRet ifpugIlfRet) {
		this.ifpugIlfRet = ifpugIlfRet;
	}

	public Integer getIlfId() {
		return this.ilfId;
	}

	public void setIlfId(Integer ilfId) {
		this.ilfId = ilfId;
	}

	public short getType() {
		return this.type;
	}

	public void setType(short type) {
		this.type = type;
	}

	public String getIlfDetName() {
		return this.ilfDetName;
	}

	public void setIlfDetName(String ilfDetName) {
		this.ilfDetName = ilfDetName;
	}

	public String getIlfDetDesp() {
		return this.ilfDetDesp;
	}

	public void setIlfDetDesp(String ilfDetDesp) {
		this.ilfDetDesp = ilfDetDesp;
	}

}