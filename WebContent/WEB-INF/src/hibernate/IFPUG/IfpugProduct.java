package hibernate.IFPUG;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * IfpugProduct entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugProduct implements java.io.Serializable {

	// Fields

	private Integer id;
	private IfpugUser ifpugUser;
	private String productName;
	private String productDesp;
	private Short productType;
	private Short developType;
	private Short measureMethod;
	private Short lifecyclePhase;
	private Short measureStatus;
	private String estimator;
	private Date projectStartTime;
	private Date projectEndTime;
	private Date endTime;
	private Date estimateTime;
	private Integer ufpCount;
	private Set ifpugEifs = new HashSet(0);
	private Set ifpugIlfs = new HashSet(0);
	private Set ifpugFunctions = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugProduct() {
	}

	/** minimal constructor */
	public IfpugProduct(String productName, Short productType,
			Short developType, Short measureMethod, Short lifecyclePhase,
			Short measureStatus, Date projectStartTime, Date projectEndTime,
			Date estimateTime) {
		this.productName = productName;
		this.productType = productType;
		this.developType = developType;
		this.measureMethod = measureMethod;
		this.lifecyclePhase = lifecyclePhase;
		this.measureStatus = measureStatus;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.estimateTime = estimateTime;
	}

	/** full constructor */
	public IfpugProduct(IfpugUser ifpugUser, String productName,
			String productDesp, Short productType, Short developType,
			Short measureMethod, Short lifecyclePhase, Short measureStatus,
			String estimator, Date projectStartTime, Date projectEndTime,
			Date endTime, Date estimateTime, Integer ufpCount, Set ifpugEifs,
			Set ifpugIlfs, Set ifpugFunctions) {
		this.ifpugUser = ifpugUser;
		this.productName = productName;
		this.productDesp = productDesp;
		this.productType = productType;
		this.developType = developType;
		this.measureMethod = measureMethod;
		this.lifecyclePhase = lifecyclePhase;
		this.measureStatus = measureStatus;
		this.estimator = estimator;
		this.projectStartTime = projectStartTime;
		this.projectEndTime = projectEndTime;
		this.endTime = endTime;
		this.estimateTime = estimateTime;
		this.ufpCount = ufpCount;
		this.ifpugEifs = ifpugEifs;
		this.ifpugIlfs = ifpugIlfs;
		this.ifpugFunctions = ifpugFunctions;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public IfpugUser getIfpugUser() {
		return this.ifpugUser;
	}

	public void setIfpugUser(IfpugUser ifpugUser) {
		this.ifpugUser = ifpugUser;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesp() {
		return this.productDesp;
	}

	public void setProductDesp(String productDesp) {
		this.productDesp = productDesp;
	}

	public Short getProductType() {
		return this.productType;
	}

	public void setProductType(Short productType) {
		this.productType = productType;
	}

	public Short getDevelopType() {
		return this.developType;
	}

	public void setDevelopType(Short developType) {
		this.developType = developType;
	}

	public Short getMeasureMethod() {
		return this.measureMethod;
	}

	public void setMeasureMethod(Short measureMethod) {
		this.measureMethod = measureMethod;
	}

	public Short getLifecyclePhase() {
		return this.lifecyclePhase;
	}

	public void setLifecyclePhase(Short lifecyclePhase) {
		this.lifecyclePhase = lifecyclePhase;
	}

	public Short getMeasureStatus() {
		return this.measureStatus;
	}

	public void setMeasureStatus(Short measureStatus) {
		this.measureStatus = measureStatus;
	}

	public String getEstimator() {
		return this.estimator;
	}

	public void setEstimator(String estimator) {
		this.estimator = estimator;
	}

	public Date getProjectStartTime() {
		return this.projectStartTime;
	}

	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}

	public Date getProjectEndTime() {
		return this.projectEndTime;
	}

	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getEstimateTime() {
		return this.estimateTime;
	}

	public void setEstimateTime(Date estimateTime) {
		this.estimateTime = estimateTime;
	}

	public Integer getUfpCount() {
		return this.ufpCount;
	}

	public void setUfpCount(Integer ufpCount) {
		this.ufpCount = ufpCount;
	}

	public Set getIfpugEifs() {
		return this.ifpugEifs;
	}

	public void setIfpugEifs(Set ifpugEifs) {
		this.ifpugEifs = ifpugEifs;
	}

	public Set getIfpugIlfs() {
		return this.ifpugIlfs;
	}

	public void setIfpugIlfs(Set ifpugIlfs) {
		this.ifpugIlfs = ifpugIlfs;
	}

	public Set getIfpugFunctions() {
		return this.ifpugFunctions;
	}

	public void setIfpugFunctions(Set ifpugFunctions) {
		this.ifpugFunctions = ifpugFunctions;
	}
	//用于级联操作 Ifpug_Function表与Ifpug_ProductInfo表的关联
	public void addFunction(IfpugFunction function){
		if(!ifpugFunctions.contains(function)){
			ifpugFunctions.add(function);
			function.setIfpugProduct(this);
			}
	}
	public void removeIfpugFunction(IfpugFunction function){		
		function.setIfpugProduct(null);
		ifpugFunctions.remove(function);
	}
	public String getTime(Date date){
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdFormat.format(date);
		return str;
	}

}