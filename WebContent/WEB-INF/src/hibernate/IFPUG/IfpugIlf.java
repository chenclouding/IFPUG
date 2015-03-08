package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugIlf entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugIlf implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugProduct ifpugProduct;
	private String ilfName;
	private String ilfDesp;
	private Short fileType;
	private Integer ufpCount = 0;
	private Short ufpMethod;
	private Set ifpugIlfRets = new HashSet(0);
	private IfpugIlfDirectMethod ifpugIlfDirectMethod;

	// Constructors

	/** default constructor */
	public IfpugIlf() {
	}

	/** minimal constructor */
	public IfpugIlf(String ilfName) {
		this.ilfName = ilfName;
	}

	/** full constructor */
	public IfpugIlf(IfpugProduct ifpugProduct, String ilfName, String ilfDesp,
			Short fileType, Integer ufpCount, Short ufpMethod,  Set ifpugIlfRets,
			IfpugIlfDirectMethod ifpugIlfDirectMethod) {
		this.ifpugProduct = ifpugProduct;
		this.ilfName = ilfName;
		this.ilfDesp = ilfDesp;
		this.fileType = fileType;
		this.ufpCount = ufpCount;
		this.ufpMethod = ufpMethod;
		this.ifpugIlfRets = ifpugIlfRets;
		this.ifpugIlfDirectMethod = ifpugIlfDirectMethod;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugProduct getIfpugProduct() {
		return this.ifpugProduct;
	}

	public void setIfpugProduct(IfpugProduct ifpugProduct) {
		this.ifpugProduct = ifpugProduct;
	}

	public String getIlfName() {
		return this.ilfName;
	}

	public void setIlfName(String ilfName) {
		this.ilfName = ilfName;
	}

	public String getIlfDesp() {
		return this.ilfDesp;
	}

	public void setIlfDesp(String ilfDesp) {
		this.ilfDesp = ilfDesp;
	}

	public Short getFileType() {
		return this.fileType;
	}

	public void setFileType(Short fileType) {
		this.fileType = fileType;
	}

	public Integer getUfpCount() {
		return this.ufpCount;
	}

	public void setUfpCount(Integer ufpCount) {
		this.ufpCount = ufpCount;
	}

	public Short getUfpMethod() {
		return this.ufpMethod;
	}

	public void setUfpMethod(Short ufpMethod) {
		this.ufpMethod = ufpMethod;
	}


	public Set getIfpugIlfRets() {
		return ifpugIlfRets;
	}

	public void setIfpugIlfRets(Set ifpugIlfRets) {
		this.ifpugIlfRets = ifpugIlfRets;
	}

	public IfpugIlfDirectMethod getIfpugIlfDirectMethod() {
		return ifpugIlfDirectMethod;
	}

	public void setIfpugIlfDirectMethod(IfpugIlfDirectMethod ifpugIlfDirectMethod) {
		this.ifpugIlfDirectMethod = ifpugIlfDirectMethod;
	}

}