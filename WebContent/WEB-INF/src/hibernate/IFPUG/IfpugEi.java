package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugEi entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugEi implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugFunction ifpugFunction;
	private short epType;
	private String eiName;
	private String eiDesp;
	private Integer ufpCount = 0;
	private short ufpMethod;
	private short measureStatus;
	private Set ifpugEiDets = new HashSet(0);
	private IfpugEiMethod ifpugEiMethod;

	// Constructors

	/** default constructor */
	public IfpugEi() {
	}

	/** minimal constructor */
	public IfpugEi(IfpugFunction ifpugFunction, short epType, String eiName,
			short measureStatus) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eiName = eiName;
		this.measureStatus = measureStatus;
	}

	/** full constructor */
	public IfpugEi(IfpugFunction ifpugFunction, short epType, String eiName,
			String eiDesp, Integer ufpCount, short ufpMethod,
			short measureStatus, Set ifpugEiDets , IfpugEiMethod ifpugEiMethod) {
		this.ifpugFunction = ifpugFunction;
		this.epType = epType;
		this.eiName = eiName;
		this.eiDesp = eiDesp;
		this.ufpCount = ufpCount;
		this.ufpMethod = ufpMethod;
		this.measureStatus = measureStatus;
		this.ifpugEiDets = ifpugEiDets;
		this.ifpugEiMethod = ifpugEiMethod;
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

	public String getEiName() {
		return this.eiName;
	}

	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	public String getEiDesp() {
		return this.eiDesp;
	}

	public void setEiDesp(String eiDesp) {
		this.eiDesp = eiDesp;
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

	public Set getIfpugEiDets() {
		return ifpugEiDets;
	}

	public void setIfpugEiDets(Set ifpugEiDets) {
		this.ifpugEiDets = ifpugEiDets;
	}

	public IfpugEiMethod getIfpugEiMethod() {
		return ifpugEiMethod;
	}

	public void setIfpugEiMethod(IfpugEiMethod ifpugEiMethod) {
		this.ifpugEiMethod = ifpugEiMethod;
	}



}