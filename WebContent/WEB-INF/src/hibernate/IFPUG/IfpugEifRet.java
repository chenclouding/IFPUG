package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugEifRet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEifRet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugEif ifpugEif;
	private String eifRetName;
	private String eifRetDesp;
	private Set ifpugEifDets = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugEifRet() {
	}

	/** minimal constructor */
	public IfpugEifRet(IfpugEif ifpugEif, String eifRetName) {
		this.ifpugEif = ifpugEif;
		this.eifRetName = eifRetName;
	}

	/** full constructor */
	public IfpugEifRet(IfpugEif ifpugEif, String eifRetName, String eifRetDesp,
			Set ifpugEifDets) {
		this.ifpugEif = ifpugEif;
		this.eifRetName = eifRetName;
		this.eifRetDesp = eifRetDesp;
		this.ifpugEifDets = ifpugEifDets;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugEif getIfpugEif() {
		return this.ifpugEif;
	}

	public void setIfpugEif(IfpugEif ifpugEif) {
		this.ifpugEif = ifpugEif;
	}

	public String getEifRetName() {
		return this.eifRetName;
	}

	public void setEifRetName(String eifRetName) {
		this.eifRetName = eifRetName;
	}

	public String getEifRetDesp() {
		return this.eifRetDesp;
	}

	public void setEifRetDesp(String eifRetDesp) {
		this.eifRetDesp = eifRetDesp;
	}

	public Set getIfpugEifDets() {
		return this.ifpugEifDets;
	}

	public void setIfpugEifDets(Set ifpugEifDets) {
		this.ifpugEifDets = ifpugEifDets;
	}

}