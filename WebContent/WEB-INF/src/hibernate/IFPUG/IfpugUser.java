package hibernate.IFPUG;

import java.util.HashSet;
import java.util.Set;

/**
 * IfpugUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class IfpugUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Set ifpugProducts = new HashSet(0);

	// Constructors

	/** default constructor */
	public IfpugUser() {
	}

	/** minimal constructor */
	public IfpugUser(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public IfpugUser(String username, String password, Set ifpugProducts) {
		this.username = username;
		this.password = password;
		this.ifpugProducts = ifpugProducts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getIfpugProducts() {
		return this.ifpugProducts;
	}

	public void setIfpugProducts(Set ifpugProducts) {
		this.ifpugProducts = ifpugProducts;
	}

}