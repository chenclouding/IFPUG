package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugEo entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEo implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugFunction ifpugFunction;
	private short epType;
	private String eoName;
	private String eoDesp;
	private Integer ufpCount = 0;
	private short ufpMethod;
	private short measureStatus;
	private IfpugEoMethod ifpugEoMethod;
	private Set ifpugEoDets = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugEo() {
	}

	/** minimal constructor */
	public IfpugEo(IfpugFunction ifpugFunction, short epType, String eoName,
			short measureStatus) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eoName = eoName;
		this.measureStatus = measureStatus;
	}

	/** full constructor */
	public IfpugEo(IfpugFunction ifpugFunction, short epType, String eoName,
			String eoDesp, Integer ufpCount, short ufpMethod,
			short measureStatus, IfpugEoMethod ifpugEoMethod, Set ifpugEoDets) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eoName = eoName;
		this.eoDesp = eoDesp;
		this.ufpCount = ufpCount;
		this.ufpMethod = ufpMethod;
		this.measureStatus = measureStatus;
		this.ifpugEoMethod = ifpugEoMethod;
		this.ifpugEoDets = ifpugEoDets;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugFunction getIfpugFunction() {
		return this.ifpugFunction;
	}

	public void setIfpugFunction(IfpugFunction ifpugFunction) {
		this.ifpugFunction = ifpugFunction;
	}

	public short getEpType() {
		return this.epType;
	}

	public void setEpType(short epType) {
		this.epType = epType;
	}

	public String getEoName() {
		return this.eoName;
	}

	public void setEoName(String eoName) {
		this.eoName = eoName;
	}

	public String getEoDesp() {
		return this.eoDesp;
	}

	public void setEoDesp(String eoDesp) {
		this.eoDesp = eoDesp;
	}

	public Integer getUfpCount() {
		return this.ufpCount;
	}

	public void setUfpCount(Integer ufpCount) {
		this.ufpCount = ufpCount;
	}

	public short getUfpMethod() {
		return this.ufpMethod;
	}

	public void setUfpMethod(short ufpMethod) {
		this.ufpMethod = ufpMethod;
	}

	public short getMeasureStatus() {
		return this.measureStatus;
	}

	public void setMeasureStatus(short measureStatus) {
		this.measureStatus = measureStatus;
	}


	public IfpugEoMethod getIfpugEoMethod() {
		return ifpugEoMethod;
	}

	public void setIfpugEoMethod(IfpugEoMethod ifpugEoMethod) {
		this.ifpugEoMethod = ifpugEoMethod;
	}

	public Set getIfpugEoDets() {
		return this.ifpugEoDets;
	}

	public void setIfpugEoDets(Set ifpugEoDets) {
		this.ifpugEoDets = ifpugEoDets;
	}

}