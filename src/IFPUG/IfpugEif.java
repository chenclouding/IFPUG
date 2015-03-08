package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugEif entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEif implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugProduct ifpugProduct;
	private String eifName;
	private String eifDesp;
	private Short fileType;
	private Integer ufpCount = 0;
	private Short ufpMethod;
	private IfpugEifDirectMethod ifpugEifDirectMethod;
	private Set ifpugEifRets = new HashSet(0);


	// Constructors

	/** default constructor */
	public IfpugEif() {
	}

	/** minimal constructor */
	public IfpugEif(IfpugProduct ifpugProduct, String eifName) {
		this.ifpugProduct = ifpugProduct;
		this.eifName = eifName;
	}

	/** full constructor */
	public IfpugEif(IfpugProduct ifpugProduct, String eifName, String eifDesp,
			Short fileType, Integer ufpCount, Short ufpMethod, 
			IfpugEifDirectMethod ifpugEifDirectMethod, Set ifpugEifRets) {
		this.ifpugProduct = ifpugProduct;
		this.eifName = eifName;
		this.eifDesp = eifDesp;
		this.fileType = fileType;
		this.ufpCount = ufpCount;
		this.ufpMethod = ufpMethod;
		this.ifpugEifDirectMethod = ifpugEifDirectMethod;
		this.ifpugEifRets = ifpugEifRets;

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

	public String getEifName() {
		return this.eifName;
	}

	public void setEifName(String eifName) {
		this.eifName = eifName;
	}

	public String getEifDesp() {
		return this.eifDesp;
	}

	public void setEifDesp(String eifDesp) {
		this.eifDesp = eifDesp;
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


	public IfpugEifDirectMethod getIfpugEifDirectMethod() {
		return ifpugEifDirectMethod;
	}

	public void setIfpugEifDirectMethod(IfpugEifDirectMethod ifpugEifDirectMethod) {
		this.ifpugEifDirectMethod = ifpugEifDirectMethod;
	}

	public Set getIfpugEifRets() {
		return this.ifpugEifRets;
	}

	public void setIfpugEifRets(Set ifpugEifRets) {
		this.ifpugEifRets = ifpugEifRets;
	}

}