package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugIlfRet entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugIlfRet implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugIlf ifpugIlf;
	private String ilfRetName;
	private String ilfRetDesp;
	private Set ifpugIlfDets = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugIlfRet() {
	}

	/** minimal constructor */
	public IfpugIlfRet(IfpugIlf ifpugIlf, String ilfRetName) {
		this.ifpugIlf = ifpugIlf;
		this.ilfRetName = ilfRetName;
	}

	/** full constructor */
	public IfpugIlfRet(IfpugIlf ifpugIlf, String ilfRetName, String ilfRetDesp,
			Set ifpugIlfDets) {
		this.ifpugIlf = ifpugIlf;
		this.ilfRetName = ilfRetName;
		this.ilfRetDesp = ilfRetDesp;
		this.ifpugIlfDets = ifpugIlfDets;
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

	public String getIlfRetName() {
		return this.ilfRetName;
	}

	public void setIlfRetName(String ilfRetName) {
		this.ilfRetName = ilfRetName;
	}

	public String getIlfRetDesp() {
		return this.ilfRetDesp;
	}

	public void setIlfRetDesp(String ilfRetDesp) {
		this.ilfRetDesp = ilfRetDesp;
	}

	public Set getIfpugIlfDets() {
		return this.ifpugIlfDets;
	}

	public void setIfpugIlfDets(Set ifpugIlfDets) {
		this.ifpugIlfDets = ifpugIlfDets;
	}

}