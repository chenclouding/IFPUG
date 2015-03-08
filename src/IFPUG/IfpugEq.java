package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugEq entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEq implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugFunction ifpugFunction;
	private short epType;
	private String eqName;
	private String eqDesp;
	private Integer ufpCount = 0;
	private short ufpMethod;
	private short measureStatus;
	private IfpugEqMethod ifpugEqMethod;
	private Set ifpugEqDets = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugEq() {
	}

	/** minimal constructor */
	public IfpugEq(IfpugFunction ifpugFunction, short epType, String eqName,
			short measureStatus) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eqName = eqName;
		this.measureStatus = measureStatus;
	}

	/** full constructor */
	public IfpugEq(IfpugFunction ifpugFunction, short epType, String eqName,
			String eqDesp, Integer ufpCount, short ufpMethod,
			short measureStatus,  IfpugEqMethod ifpugEqMethod, Set ifpugEqDets) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eqName = eqName;
		this.eqDesp = eqDesp;
		this.ufpCount = ufpCount;
		this.ufpMethod = ufpMethod;
		this.measureStatus = measureStatus;
		this.ifpugEqMethod = ifpugEqMethod;
		this.ifpugEqDets = ifpugEqDets;
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

	public String getEqName() {
		return this.eqName;
	}

	public void setEqName(String eqName) {
		this.eqName = eqName;
	}

	public String getEqDesp() {
		return this.eqDesp;
	}

	public void setEqDesp(String eqDesp) {
		this.eqDesp = eqDesp;
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


	public IfpugEqMethod getIfpugEqMethod() {
		return ifpugEqMethod;
	}

	public void setIfpugEqMethod(IfpugEqMethod ifpugEqMethod) {
		this.ifpugEqMethod = ifpugEqMethod;
	}

	public Set getIfpugEqDets() {
		return this.ifpugEqDets;
	}

	public void setIfpugEqDets(Set ifpugEqDets) {
		this.ifpugEqDets = ifpugEqDets;
	}

}